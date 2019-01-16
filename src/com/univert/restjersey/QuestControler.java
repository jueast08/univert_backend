package com.univert.restjersey;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.univert.service.QuestService;

@Path("/questservice")
public class QuestControler {
	@GET
	@Path("/getNumQuestFinish")
	@Produces("application/json")
	public Response getNumQuestFinish() throws JSONException, SQLException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("numberQuest", QuestService.getNumQuestFinish());
		String result = "@Produces(\"application/json\")" + jsonObject;
		return Response.status(200).entity(result).build();
	}

}
