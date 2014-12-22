package com.qycloud.oatos.bigfilein.model.oatos;

/**
 * 登录方式
 *
 * @author yang
 */
public enum LogonMode {

    /**
     * 邮箱或手机登录
     */
    Quick,

    /**
     * 帐号登陆
     */
    Account,

    /**
     * 域帐号登陆
     */
    Ldap;

}
