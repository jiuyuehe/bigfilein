package com.qycloud.oatos.bigfilein.model.oatos;


import com.qycloud.oatos.bigfilein.model.oatos.BaseDTO;

/**
 * 登录结果
 *
 * @author yang
 */
public class LoginResultDTO extends BaseDTO {

    /**
     * 登录帐号
     */
    private String account;

    /**
     * 登录token<br>
     * 登录成功后有正确的token
     */
    private String token;

    /**
     * 是否为付费用户
     */
    private boolean vip;

    public LoginResultDTO() {
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

}
