package aoc.Harlequin.Services;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

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
		
		
		System.out.println(jsonObject.toString());
	    
		return jsonObject.toString();
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
	
	
	

}
