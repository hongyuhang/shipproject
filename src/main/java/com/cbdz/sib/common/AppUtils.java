package com.cbdz.sib.common;


import com.alibaba.fastjson.JSONObject;
import com.cbdz.sib.model.BaseModel;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class AppUtils {
    public static void addSeqAttribute(List<? extends BaseModel> models, int offset, int limit) {
        int start = 1 + (offset - 1) * limit;
        for(BaseModel model : models) {
            model.setSeq(start++);
        }
    }

    /**
     * post请求
     *
     * @param url
     * @param json
     * @return
     */
    public static String doPostJson(String url, JSONObject json) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        JSONObject response = null;
        try {
            StringEntity s = new StringEntity(json.toString());
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");// 发送json数据需要设置contentType
            post.setEntity(s);
            HttpResponse res = client.execute(post);
            if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = res.getEntity();
                String result = EntityUtils.toString(res.getEntity());// 返回json格式：
                return result;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     *get请求
     * @param urlString
     * @return
     */
    public static String doGetUrl(String urlString) {
        String res = "";
        try {
            URL url = new URL(urlString);
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                res += line;
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 格式化Calendar（年月日 时分秒.毫秒）
     * @param x_cal
     * @return
     */
    public static String toStringYmdHmsS(Calendar x_cal) {
        SimpleDateFormat p_df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return p_df.format(x_cal.getTime());
    }

    /**
     * 当前时间
     * @return
     */
    public static String currentTimestamp() {
        return toStringYmdHmsS(Calendar.getInstance());
    }

    /**
     *
     * @param x_val
     * @param x_default
     * @return
     */
    public static String getDefault(String x_val, String x_default) {
        if (x_val == null) {
            return x_default;
        }
        return x_val;
    }

    /**
     * 左补文字
     * @param src
     * @param len
     * @param ch
     * @return
     */
    public static String padLeft(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, 0, src.length());
        for (int i = src.length(); i < len; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }

    /**
     * 右补文字
     * @param src
     * @param len
     * @param ch
     * @return
     */
    public static String padRight(String src, int len, char ch) {
        int diff = len - src.length();
        if (diff <= 0) {
            return src;
        }

        char[] charr = new char[len];
        System.arraycopy(src.toCharArray(), 0, charr, diff, src.length());
        for (int i = 0; i < diff; i++) {
            charr[i] = ch;
        }
        return new String(charr);
    }
}
