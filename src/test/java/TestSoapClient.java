import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by jiuyuehe on 2014/11/21.
 */
public class TestSoapClient {



    /**
     * 天晴短息发送测试
     *
     * @param url
     * @param receiver
     * @param content
     */
    public static boolean postCttqMsg(String url, String receiver, String content) {

        CloseableHttpClient httpPost = HttpClients.createDefault();
        HttpPost postm = new HttpPost(url);
        postm.addHeader("Content-Type", "text/xml; charset=utf-8");
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">");
        sb.append("<soap:Body>");
        sb.append("<sendSmsMob xmlns=\"http://tempuri.org/\">");
        sb.append("<strReceivers>" + receiver + "</strReceivers>");
        sb.append("<smsContent>" + content + "</smsContent>");
        sb.append("</sendSmsMob>");
        sb.append("</soapenv:Body>");
        sb.append("</soapenv:Envelope>");
        HttpEntity httpEntity = new StringEntity(sb.toString(), "UTF-8");
        postm.setEntity(httpEntity);
        try {
            CloseableHttpResponse response = httpPost.execute(postm);

            StatusLine sl  = response.getStatusLine();
            int statusCode =  sl.getStatusCode();

            String resStr =  EntityUtils.toString(response.getEntity());

            if(statusCode ==200 && resStr.contains("error='0'"))
                return  true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }


    public static void post(String url) {
        CloseableHttpClient httpPost = HttpClients.createDefault();
        HttpPost postm = new HttpPost(url);
        postm.addHeader("Content-Type", "text/xml; charset=utf-8");
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        sb.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:con=\"http://control.liutu.doodoole.com/\">");
        sb.append("<soapenv:Header/>");
        sb.append("<soapenv:Body>");
        sb.append("<con:sayhello>");
        sb.append("<arg0>?asdf12312</arg0>");
        sb.append("</con:sayhello>");
        sb.append("</soapenv:Body>");
        sb.append("</soapenv:Envelope>");
        HttpEntity httpEntity = new StringEntity(sb.toString(), "UTF-8");
        postm.setEntity(httpEntity);
        try {
            CloseableHttpResponse response = httpPost.execute(postm);
            System.out.println(response.getStatusLine());
            System.out.printf("entity" + EntityUtils.toString(response.getEntity()));
            HttpEntity entity = response.getEntity();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       // TestSoapClient.post("http://127.0.0.1:9999/TestServer/sayHello?wsdl");

        System.out.println(" <sendSmsMobResult><result error='0'><Sms   SendDate=\"20141124\" SendTime=\"104405\" MESSAGE =\"成功\"/></result></sendSmsMobResult>".contains("error='0'"));

    }


}
