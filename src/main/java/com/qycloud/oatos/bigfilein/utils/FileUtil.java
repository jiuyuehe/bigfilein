package com.qycloud.oatos.bigfilein.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 文件操作工具
 * 
 * @author yang
 * 
 */
public class FileUtil {

	public static String uuid() {
		return UUID.randomUUID().toString().toLowerCase();
	}


	/**
	 * 取文件的MD5
	 * 
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static String getFileMD5(File file) {
		String md5 = null;
		FileInputStream is = null;
		try {
			is = new FileInputStream(file);
			md5 =  getMd5(is);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (Exception e) {
			}
		}
		return md5;
	}

	public static String getMd5(InputStream is) {
		String md5 = null;
		
		try {
			md5 =  DigestUtils.md5Hex(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return md5;
	}

	public static String getMD5(byte[] data) {
		return DigestUtils.md5Hex(data);
	}


}
