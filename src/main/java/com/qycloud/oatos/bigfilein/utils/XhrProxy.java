package com.qycloud.oatos.bigfilein.utils;

import com.qycloud.oatos.bigfilein.model.Constant;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;


public class XhrProxy {


    public static final String TEXT = "text/plain;charset=UTF-8";

    public static final String JSON = "application/json;charset=UTF-8";

    static {
        System.setProperty("java.net.preferIPv4Stack", "true");
        System.setProperty("java.net.preferIPv6Addresses", "false");
    }

    public XhrProxy() {
    }

    /**
     * get
     * @param url
     * @param token
     * @param params
     * @return
     * @throws Exception
     */
    public static HttpResponse get(String url, String token, String params)
            throws Exception {
        return get(url, token, params, null);
    }

    /**
     * get
     *
     * @param url
     * @param token
     * @param params
     * @param headers
     * @return
     * @throws Exception
     */
    public static HttpResponse get(String url, String token, String params,
                                   Map<String, String> headers) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            String getURL = url;
            if (params != null && !params.isEmpty()) {
                getURL = getURL + "?" + params;
            }
            HttpGet get = new HttpGet(getURL);
            get.setHeader(Constant.UserTokenkey, token);
            if (headers != null) {
                for (String key : headers.keySet()) {
                    get.setHeader(key, headers.get(key));
                }
            }
            RequestConfig config = RequestConfig.custom()
                    .setSocketTimeout(30000).setConnectTimeout(5000).build();
            get.setConfig(config);
            return httpclient.execute(get);
        } finally {
            // httpclient.close();
        }
    }

    public static String getStr(String url, String token, String params) throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            String getURL = url;
            if (params != null && !params.isEmpty()) {
                getURL = getURL + "?" + params;
            }
            HttpGet get = new HttpGet(getURL);
            get.setHeader(Constant.UserTokenkey, token);

            RequestConfig config = RequestConfig.custom()
                    .setSocketTimeout(30000).setConnectTimeout(5000).build();
            get.setConfig(config);
            HttpResponse res = httpclient.execute(get);
            return EntityUtils.toString(res.getEntity(), "UTF-8");
        } finally {
            httpclient.close();
        }
    }

    /**
     * post
     *
     * @param url
     * @param token
     * @param postData
     * @return
     * @throws Exception
     */
    public static String post(String url, String token, String postData)
            throws Exception {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(Constant.UserTokenkey, token);
        headers.put("Content-Type", "text/plain; charset=UTF-8");
        return post(url, postData, headers);
    }

    /**
     * post
     *
     * @param url
     * @param postData
     * @param headers
     * @return
     * @throws Exception
     */
    public static String post(String url, String postData,
                              Map<String, String> headers) throws Exception {
        HttpEntity postEntity = null;
        if (postData != null) {
            postEntity = new StringEntity(postData, "UTF-8");
        }
        return post(url, postEntity, headers);
    }



    /**
     * post
     *
     * @param url
     * @param postEntity
     * @param headers
     * @return
     * @throws Exception
     */
    public static String post(String url, HttpEntity postEntity,
                              Map<String, String> headers) throws Exception {

       PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
       CloseableHttpClient httpclient = HttpClients.custom().setConnectionManager(cm).build();
        try {
            HttpPost post = new HttpPost(url);
            post.setHeader("Accept", "text/plain;charset=UTF-8");
            if (headers != null) {
                for (String key : headers.keySet()) {
                    post.setHeader(key, headers.get(key));
                }
            }
            if (postEntity != null) {
                post.setEntity(postEntity);
            }
            RequestConfig config = RequestConfig.custom()
                    .setSocketTimeout(30000).setConnectTimeout(5000).build();
            post.setConfig(config);
            CloseableHttpResponse response = httpclient.execute(post);
            try {
//				int statusCode = response.getStatusLine().getStatusCode();
//				if (statusCode >= 400) {
//					// 抛出网络错误异常
//					throw new IOException(statusCode + "");
//				}
                return EntityUtils.toString(response.getEntity(), "UTF-8");
            } finally {
               response.close();
            }
        } finally {
           httpclient.close();
        }
    }






}
