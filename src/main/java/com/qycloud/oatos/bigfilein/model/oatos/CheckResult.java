package com.qycloud.oatos.bigfilein.model.oatos;

/**
 * Created by jiuyuehe on 2014/11/29.
 */
public class CheckResult {

    private String statusCode;
    private int content;
    private String error;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "CheckResult{" +
                "statusCode='" + statusCode + '\'' +
                ", content='" + content + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
