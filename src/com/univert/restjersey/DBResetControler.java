package com.univert.restjersey;


import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.univert.db.ResetBdd;
import com.univert.service.UserService;

@Path("/DBResetservice")
public class DBResetControler {
	@GET
	@Path("/reset")
	@Produces({MediaType.APPLICATION_JSON})
	public Response reset() throws JSONException, SQLException {
		JSONObject jsonObject = new JSONObject();	
		jsonObject.put("reset", ResetBdd.resetDatabase(getClass().getClassLoader().getResourceAsStream("univert2.sql")));
		return Response.status(200).entity(jsonObject.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").build();
	}
}
