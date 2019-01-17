/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.restjersey;

import com.google.gson.Gson;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.univert.service.CharacterService;
import com.univert.model.character.*;
import com.univert.service.UserService;
import java.sql.SQLException;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Aurélien
 */
    
@Path("/characterservice")
public class CharacterControler {
    @GET
    @Path("profil/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCharacter(@PathParam("id") int id) throws JSONException, SQLException {
		JSONObject jsonObject = new JSONObject();
                Gson gson = new Gson();
                
                com.univert.model.character.Character myChar = CharacterService.getCharacter(id);
                String json = gson.toJson(myChar);
		jsonObject.put("character", json);
                
		String result = "@Produces(\"application/json\")" + jsonObject;
		return Response.status(200).entity(result).build();
	}
    
     @GET
     @Path("profil/{id}")
     @Produces({MediaType.APPLICATION_JSON})
     public Response getBadge(@PathParam("id") int id) throws JSONException, SQLException {
		JSONObject jsonObject = new JSONObject();
                Gson gson = new Gson();
                
                Badge myBadge = CharacterService.getBadge(id);
                String json = gson.toJson(myBadge);
		jsonObject.put("badge", json);
                
		String result = "@Produces(\"application/json\")" + jsonObject;
		return Response.status(200).entity(result).build();
	}
     
     @GET
     @Path("profil/{id}")
     @Produces({MediaType.APPLICATION_JSON})
     public Response getItem(@PathParam("id") int id) throws JSONException, SQLException {
		JSONObject jsonObject = new JSONObject();
                Gson gson = new Gson();
                
                Item myItem = CharacterService.getItem(id);
                String json = gson.toJson(myItem);
		jsonObject.put("item", json);
                
		String result = "@Produces(\"application/json\")" + jsonObject;
		return Response.status(200).entity(result).build();
	}
}
