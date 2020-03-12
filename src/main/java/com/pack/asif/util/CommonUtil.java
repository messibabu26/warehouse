package com.pack.asif.util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommonUtil {
	
	public static Map<Integer,String> convert(
			List<Object[]> list) {
		Map<Integer,String> map=new LinkedHashMap<>();
		for(Object[] ob:list) {
			map.put(Integer.valueOf(ob[0].toString()),ob[1].toString());
		}
		return map;
	}

}
