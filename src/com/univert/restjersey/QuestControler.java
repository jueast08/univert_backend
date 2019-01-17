package com.univert.restjersey;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.univert.model.quest.Quest;
import com.univert.service.QuestService;
import com.univert.service.StatusService;

@Path("/questservice")
public class QuestControler {
	
	@GET
	@Path("/getNumQuestFinish")
    @Produces({MediaType.APPLICATION_JSON})
	public Response getNumQuestFinish() throws JSONException, SQLException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("numberQuest", QuestService.getNumQuestFinish());
		return Response.status(200).entity(jsonObject.toString()).build();
	}
	
	@GET
	@Path("/garden/{id}/quests")
    @Produces({MediaType.APPLICATION_JSON})
	public Response getQuestsByGarden(@PathParam("id") int id) throws JSONException, SQLException {
		JSONObject jsonObject = new JSONObject();
		Gson gson = new Gson();
		
		List<Quest> questList= QuestService.getQuestsByGarden(StatusService.getOnGoingStatus(), id);
		String json = gson.toJson(questList);
		jsonObject.put("ongoing", json);
		
		questList = QuestService.getQuestsByGarden(StatusService.getOpenStatus(), id);
		json = gson.toJson(questList);
		jsonObject.put("todo", json);
		
		questList = QuestService.getQuestsByGarden(StatusService.getClosedStatus(), id);
		json = gson.toJson(questList);
		jsonObject.put("done", json);
		
		return Response.status(200).entity(jsonObject.toString().replaceAll("\\\\", "")).build();
	}
	
	@GET
	@Path("/quests/{id}")
    @Produces({MediaType.APPLICATION_JSON})
	public Response getQuestById(@PathParam("id") int id) throws JSONException, SQLException {
		Gson gson = new Gson();
		String json = gson.toJson(QuestService.getQuestById(id));
		return Response.status(200).entity(json.toString()).build();
	}
	
	@POST
	@Path("/quests/{idQuest}/user/{idUser}")
    @Produces({MediaType.APPLICATION_JSON})
	public Response setQuestByUser(@PathParam("idQuest") int idQuest, @PathParam("idUser") int idUser) throws JSONException, SQLException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("validate", QuestService.setQuestByUser(idQuest, idUser));
		return Response.status(200).entity(jsonObject.toString()).build();
	}
	
}
