package com.qycloud.oatos.bigfilein.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * 服务器端实现加密算法。
 *
 * @author 郭天良
 */
public class Security {

    // token 默认长度
    private final static int TOKEN_LENGTH = 80;

    private final static int SIZE = 256;
    // 加密用字符数组，做字符映射
    private final byte sbox[] = new byte[SIZE];
    private int i;
    private int j;

    /**
     * 转换字符串为十六进制字符串
     *
     * @param s String to be converted
     * @return Hex equivalent of the input string
     */
    public static String byteStringToHexString(final String s) {
        StringBuilder hexString = new StringBuilder(65);
        for (int i = 0; i < s.length(); i++) {
            hexString.append(byteToHexChars(s.charAt(i)));
        }
        return hexString.toString();
    }

    /**
     * 字符为十六进制字符
     *
     * @param i Number to be converted
     * @return Hex equivalent, in two characters.
     */
    private static String byteToHexChars(final int i) {
        final String s = "0" + Integer.toHexString(i);
        return s.substring(s.length() - 2);
    }

    /**
     * @param text
     * @return
     */
    public static String SHA256(final String text) {
        MessageDigest messageDigesSHA256 = null;
        try {
            messageDigesSHA256 = MessageDigest.getInstance("SHA-256");
        } catch (final NoSuchAlgorithmException ex) {
            Logs.getLogger().error("ServerKey config error!", ex);
        }
        messageDigesSHA256.update(text.getBytes());

        byte byteData[] = messageDigesSHA256.digest();

        StringBuilder hexString = new StringBuilder(65);
        for (int i = 0, len = byteData.length; i < len; i++) {
            hexString.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return hexString.toString();
    }

    /**
     * 构造数字和字符的随机数
     *
     * @return
     */
    public static String randomCharString() {
        return randomCharString(TOKEN_LENGTH);
    }

    /**
     * 得到一个指定长度的随机字符
     *
     * @param length
     * @return
     */
    public static String randomCharString(int length) {
        Random random = new Random();
        char[] radStr = "1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] randBuffer = new char[length];
        for (int i = 0; i < length; i++) {
            randBuffer[i] = radStr[random.nextInt(36)];
        }

        return new String(randBuffer);
    }

    /**
     * 解密
     *
     * @param plaintext
     * @return
     */
    private String codeDecode(final String plaintext) {
        byte x;
        StringBuilder mString = new StringBuilder(65);
        final int pl = plaintext.length();
        for (int k = 0; k < pl; k++) {
            i = i + 1 & 0xff;
            j = j + sbox[i] & 0xff;

            x = sbox[i];
            sbox[i] = sbox[j];
            sbox[j] = x;
            mString.append((char) (plaintext.charAt(k) ^ sbox[sbox[i] + sbox[j] & 0xff] & 0xff));
        }
        return mString.toString();
    }

    /**
     * 用一个 Key，加密文本，对称加密
     *
     * @param key
     * @param plaintext
     * @return
     */
    public String codeDecode(final String key, final String plaintext) {

        setUp(key);
        return codeDecode(plaintext);
    }

    /**
     * 设定 Key，用于加密
     *
     * @param key
     */
    private void setUp(final String key) {
        int k;
        byte x;

        for (i = 0; i < SIZE; i++) {
            sbox[i] = (byte) i;
        }

        final int kl = key.length();
        for (i = 0, j = 0, k = 0; i < SIZE; i++) {
            j = j + sbox[i] + key.charAt(k) & 0xff;
            k = (k + 1) % kl;

            x = sbox[i];
            sbox[i] = sbox[j];
            sbox[j] = x;
        }

        i = 0;
        j = 0;
    }

}
