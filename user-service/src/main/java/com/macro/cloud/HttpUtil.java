package com.macro.cloud;

import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class HttpUtil {
    public static void doPost(String uri, Map<String, String> map) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        try {
            httpClient = HttpClients.createDefault();
            CloseableHttpResponse response;
            httpPost = new HttpPost(uri);
            List<NameValuePair> params = new ArrayList<NameValuePair>(map.size());
            for (Map.Entry<String, String> obj : map.entrySet()) {
                params.add(new BasicNameValuePair(obj.getKey(), obj.getValue()));
            }
//            StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
//            stringEntity.setContentEncoding("utf-8");
            httpPost.setProtocolVersion(HttpVersion.HTTP_1_1);
            httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            RequestConfig config = RequestConfig.custom()
                    .setSocketTimeout(5000)
                    .setConnectionRequestTimeout(5000)
                    .build();
            httpPost.setConfig(config);
            response = httpClient.execute(httpPost);
            if (response != null && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
//                log.info("向{}请求成功", uri);
//                log.info("请求数据: {}, 请求成功", json);
//                return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            } else {
//                log.info("向{}请求失败", uri);
//                log.info("请求数据: {}, 请求失败", json);
//                throw new KgServiceException(IDPS_POST_REQUEST_CODE, IDPS_POST_REQUEST_MSG);
            }
        } catch (Exception e) {
//            log.error(e);
//            throw new KgServiceException(IDPS_POST_REQUEST_CODE, IDPS_POST_REQUEST_MSG);
        } finally {
            if (httpPost != null) {
                httpPost.releaseConnection();
            }
            if (httpClient != null) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}