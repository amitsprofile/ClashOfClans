package com.aptmgmt.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.aptmgmt.rest.JsonViews;

public class CustomUtils {
	private static ObjectMapper mapper = new ObjectMapper();
	
	public static String writeValueAsString(Object obj) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectWriter viewWriter;
		viewWriter = mapper.writerWithView(JsonViews.User.class);
		return viewWriter.writeValueAsString(obj);
	}
}
