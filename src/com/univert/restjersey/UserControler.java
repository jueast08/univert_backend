package com.univert.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/userservice")
public class UserControler {
	@GET
	@Path("/getNumberUser")
	@Produces("application/json")
	public Response getNumberUser() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("numberUser", 0);
		String result = "@Produces(\"application/json\")" + jsonObject;
		return Response.status(200).entity(result).build();
	}

}
