package aoc.Harlequin.Services;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import aoc.Harlequin.DAOs.SystemUserDAO;
import aoc.Harlequin.OBJs.SystemUser;




@Path("User")
public class SystemUserService {
	
	@Path("/GetUserInfo")
	@GET
	@Produces("text/plain")
	public String GET( ) throws Exception
	{
		
		SystemUserDAO Object  = new SystemUserDAO();
		SystemUser User  = Object.getUserInfoById(1);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("idSystem_User", User.getIdSystemUser());
		jsonObject.put("User_Name", User.getUserName());
		jsonObject.put("Name", User.getName());
		jsonObject.put("Surname", User.getSurname());
		jsonObject.put("E_Mail", User.getEMail());		
		jsonObject.put("Cell_Number", User.getCellNumber());
		jsonObject.put("Tell_Number", User.getTellNumber());
		jsonObject.put("User_Password", User.getUserPassword());
		jsonObject.put("Authorization_Level", User.getAuthorizationLevel());
		
		System.out.println(jsonObject.toString());
	    
		return jsonObject.toString();
	}
	
	@Path("/GetAllUsers")
	@GET
	@Produces("text/plain")
	public String GETUSERS( ) throws Exception
	{
		
		SystemUserDAO Object  = new SystemUserDAO();
		
		List<SystemUser> Users = Object.ReadAllUsers();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Users.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("idSystem_User", Users.get(i).getIdSystemUser());
			jsonObject.put("User_Name", Users.get(i).getUserName());
			jsonObject.put("Name", Users.get(i).getName());
			jsonObject.put("Surname", Users.get(i).getSurname());
			jsonObject.put("E_Mail", Users.get(i).getEMail());		
			jsonObject.put("Cell_Number", Users.get(i).getCellNumber());
			jsonObject.put("Tell_Number", Users.get(i).getTellNumber());
			jsonObject.put("Authorization_Level", Users.get(i).getAuthorizationLevel());
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
	    
		return JsonArray.toString();
	}
	
	
	@Path("/GetUser/{Username}/{Password}")
	@GET
	@Produces("text/plain")
	public String GET1(@PathParam("Username") String Username,@PathParam("Password") String Password ) throws Exception
	{
		
		String Matched = "false";
		String PasswordUser = "";
		
		SystemUserDAO Object  = new SystemUserDAO();
		
		List<SystemUser> User = Object.CheckUserPassword(Username, Password);
		
		if(User.size() != 0)
		{
			PasswordUser = User.get(0).getUserPassword().toString();
			if(Password.equals(PasswordUser.trim()))
			{
				Matched = "true";
			}
		}
		
		System.out.println("Password:" + Password + ", UserPassword:" + PasswordUser) ;
		
		
		
		
		
		return Matched;
	}
	
	
	@Path("/SaveUserInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		
		System.out.println(jsonTextObject);
		JSONObject r = new JSONObject(jsonTextObject);	
	
		
		System.out.println("WRITING TO DATABASE:"+ r.getString("Name"));
			
		SystemUserDAO Object  = new SystemUserDAO();
		Object.AddUserInformation(r.getString("Name"), r.getString("Surname"), r.getString("Email_address"), r.getString("Tell_Number"), r.getString("Cell_Number"), r.getString("Password"), r.getString("Authorization_Level"));
		
		return "Sucessful";	
		
			
	}
	
	
	

}
