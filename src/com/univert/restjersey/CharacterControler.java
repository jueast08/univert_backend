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
import java.sql.SQLException;
import java.util.List;
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
    @Path("profil/{idUser}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCharacterInfo(@PathParam("idUser") int idUser) throws JSONException, SQLException {
		JSONObject jsonObject = new JSONObject();
        Gson gson = new Gson();
        
        com.univert.model.character.Character myChar = CharacterService.getCharacter(idUser);
        jsonObject.put("id", idUser);
        jsonObject.put("name", myChar.getName());
        jsonObject.put("level", myChar.getLevel());
        jsonObject.put("experience", myChar.getExperience());
    		
        List<Badge> myBadge = CharacterService.getBadge(idUser);
        String json = gson.toJson(myBadge);
        jsonObject.put("listBadge", json);
       
        List<Item> myItem = CharacterService.getItem(idUser);
        json = gson.toJson(myItem);
        jsonObject.put("listItem", json);
        
		return Response.status(200).entity(jsonObject.toString()
				.replaceAll("\\\\", "")
				.replaceAll("\"\\[", "\\[")
				.replaceAll("\\]\"", "\\]"))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").build();
    }
	
}
