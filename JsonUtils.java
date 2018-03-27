package com.stkj.pperty.util;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.google.common.base.Strings;


/**
 *
 * @author luoyh
 * @date Jul 24, 2015
 */
public abstract class JsonUtils {
	
	public static void main(String[] args) {

		List<Map<String, Object>> datas = JsonUtils.readList("[{\"houseNo\":0202030201,\"time\":20171215,\"phone\": 15102351291}]", new TypeReference<List<Map<String, Object>>>() {});


		System.out.println(datas);


	}
	private static final ObjectMapper mapper;
	
	static {
		mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
	}

	public static <T> T readObject(String jsonStr, Class<T> t) {
		if (Strings.isNullOrEmpty(jsonStr))
			return null;
		try {
			return mapper.readValue(jsonStr, t);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> List<T> readList(String jsonStr, TypeReference<List<T>> reference) {
		if (Strings.isNullOrEmpty(jsonStr))
			return null;
		try {
			return mapper.readValue(jsonStr, reference);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static Map<String, String> readTree(String jsonStr) {
		if (Strings.isNullOrEmpty(jsonStr))
			return null;
		Map<String, String> map = null;
		JsonNode root = null;
		try {
			root = mapper.readTree(jsonStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (root != null) {
			map = new HashMap<String, String>();
			for (Iterator<String> it = root.fieldNames(); it.hasNext();) {
				String field = it.next();
				JsonNode node = root.get(field);
				JsonNodeType type = node.getNodeType();
				if(type == JsonNodeType.NULL) {
					map.put(field, null);
				} else {
					map.put(field, node.asText());
				}
			}
		}
		return map;
	}

	public static void writeObj(OutputStream out, Object obj) {
		try {
			mapper.writeValue(out, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String writeObjToString(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] writeObjToByte(Object obj) {
		try {
			return mapper.writeValueAsBytes(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String toStringHex(String s) {
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, "utf-8");// UTF-16le:Not
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

}
