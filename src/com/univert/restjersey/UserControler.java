package com.univert.restjersey;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.univert.service.UserService;

@Path("/userservice")
public class UserControler {
	@GET
	@Path("/getNumberUser")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getNumberUser() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("numberUser", 0);
		return Response.status(200).entity(jsonObject.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").build();
	}

	@GET
    @Path("verifyUser/{id}/{mdp}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response verifyUser(@PathParam("id") String id, @PathParam("mdp") String mdp) throws JSONException, SQLException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("idUser", UserService.verifyUser(id, mdp));
		return Response.status(200).entity(jsonObject.toString()).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").build();
	}
	
	@GET
    @Path("verifyBadge/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response verifyBadge(@PathParam("id") String id) throws JSONException, SQLException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("idUser", UserService.verifyBadge(id));
		return Response.status(200).entity(jsonObject.toString())
		.header("Access-Control-Allow-Origin", "*")
		.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
		.header("Access-Control-Allow-Credentials", "true")
		.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
		.header("Access-Control-Max-Age", "1209600")
		.build();
	}
}
