package com.cbdz.sib.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class InitialPageController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(InitialPageController.class);

    @RequestMapping(value = "/initialInfo", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> getInitialInfo(HttpServletRequest request) {
        return this.success();
    }
}
