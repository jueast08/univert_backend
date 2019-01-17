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
    @Path("profil/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getCharacterInfo(@PathParam("idUser") int idUser) throws JSONException, SQLException {
		JSONObject jsonObject = new JSONObject();
                Gson gson = new Gson();
                
                com.univert.model.character.Character myChar = CharacterService.getCharacter(idUser);
                String json = gson.toJson(myChar.getName());
		jsonObject.put("name", json);
                json=gson.toJson(myChar.getLevel());
                jsonObject.put("level", json);
                json=gson.toJson(myChar.getExperience());
                jsonObject.put("experience", json);
            		
                List<Badge> myBadge = CharacterService.getBadge(idUser);
                json = gson.toJson(myBadge);
		jsonObject.put("listeBadge", json);
               
                List<Item> myItem = CharacterService.getItem(idUser);
                json = gson.toJson(myItem);
		jsonObject.put("listItem", json);
                
                String result = "@Produces(\"application/json\")" + jsonObject.toString().replaceAll("\\\\", "");
		return Response.status(200).entity(result).build();
    }
	
}
