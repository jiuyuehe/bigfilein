package com.qycloud.oatos.bigfilein.utils;

import com.qycloud.oatos.bigfilein.model.oatos.EncryptModel;
import com.qycloud.oatos.bigfilein.model.oatos.NonceParam;

/**
 * 加密工具
 *
 * @author yang
 */
public class EncryptUtil {

    /**
     * 通过明文的账号和密码得到加密后的密码
     *
     * @param account  登录帐号,修改密码时为id
     * @param password 明文密码
     * @return
     */
    public static EncryptModel encrypt(String account, String password) {
        EncryptModel encrypt = new EncryptModel();
        // 1.随机字符串
        String nonce = Security.randomCharString();
//		String spassword = Security.SHA256(password);
        // 2.hash校验码
        String hashKey = Security.SHA256(account + password + nonce);
        // 3.字符混淆
        String encryptPwd = new Security().codeDecode(nonce, password);
        // 4.密码转成16进制
        String hexPwd = Security.byteStringToHexString(encryptPwd);

        encrypt.setNonce(nonce);
        encrypt.setHashKey(hashKey);
        encrypt.setPassword(hexPwd);
        return encrypt;
    }

    public static EncryptModel encrypt(String account, String password, NonceParam nonceDTO) {
        EncryptModel encrypt = encrypt(account, password);
        nonceDTO.setHashKey(encrypt.getHashKey());
        nonceDTO.setNonce(encrypt.getNonce());
        return encrypt;
    }
}
