package com.qycloud.oatos.bigfilein.utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

/**
 * json
 * 
 * @author yang
 * 
 */
public final class Json {

	private static final ObjectMapper mapper = new ObjectMapper();

	private Json() {

	}

	/**
	 * to json
	 * @param obj
	 * @return
	 * @throws Exception 
	 */
	public static String toJson(Object obj) throws Exception {
		return mapper.writeValueAsString(obj);
	}

	/**
	 * parse json as Object
	 * @param json
	 * @param clazz
	 * @return
	 * @throws Exception 
	 */
	public static <T> T parse(String json, Class<T> clazz) throws Exception {
		return mapper.readValue(json, clazz);
	}

	/**
	 * parse json as array
	 * @param json
	 * @param typeRef
	 * @return
	 * @throws Exception 
	 */
	public static <T> T parseArray(String json, TypeReference<T> typeRef) throws Exception {
		return mapper.readValue(json, typeRef);
	}

}
