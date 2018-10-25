package com.cbdz.sib.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControllerLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(ControllerLogAspect.class);

    ThreadLocal<Long> threadId=new ThreadLocal<>();
    ThreadLocal<String> name=new ThreadLocal<>();

    @Pointcut("execution(public * com.*.*.*.controller.*.*(..))")
    public void controllerlog(){}

    @Before("controllerlog()")
    public void doBefore(JoinPoint joinPoint){
        try {
            threadId.set(Thread.currentThread().getId());
            String methodName = joinPoint.getSignature().getName();
            name.set(methodName);

            //获取请求报文头部元数据
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            //获取请求对象
            HttpServletRequest request = requestAttributes.getRequest();
            List temp = Arrays.asList(joinPoint.getArgs());
            List args = new ArrayList();
            if (temp != null) {
                for (Object obj : temp) {
                    // 如果参数类型只是request的话，只把参数部分取出来就可以
                    if (obj instanceof HttpServletRequest) {
                        args.add(((HttpServletRequest) obj).getParameterMap());
                    } else {
                        args.add(obj);
                    }
                }
            }

            logger.info("!**********ThreadId is " + Thread.currentThread().getId() + " : " + joinPoint.getSignature().getName() + " is start:");
            logger.info("!**********Params is :" + JSON.toJSONString(args));
        } catch (Exception e) {
            logger.error("控制器切面出错");
        }
    }

    @AfterReturning(returning = "ret", pointcut = "controllerlog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("!**********ThreadId is " + threadId.get() + " : " + name.get() + " is end");
    }
}
