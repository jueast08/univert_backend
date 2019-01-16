/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.univert.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.univert.service.CharacterService;
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
		jsonObject.put("Character", CharacterService.getCharacterInfo(id));
                jsonObject.put("Badge", CharacterService.getBadgeInfo(id));
                jsonObject.put("Item", CharacterService.getBadgeInfo(id));
		String result = "@Produces(\"application/json\")" + jsonObject;
		return Response.status(200).entity(result).build();
	}

}
