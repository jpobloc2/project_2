package com.ers.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseUtil {
	public void writeObjectToResponse(Object obj, HttpServletResponse resp) throws IOException {
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(obj);

		// actually write the json to the body of the request
		resp.setContentType("application/json");
		resp.getWriter().println(json);
	}

}
