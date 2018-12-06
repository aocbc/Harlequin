package aoc.Harlequin.Services;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import aoc.Harlequin.DAOs.ClientDAO;
import aoc.Harlequin.DAOs.MacApplicantDAO;
import aoc.Harlequin.DAOs.SystemUserDAO;
import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.SystemUser;




@Path("User")
public class SystemUserService 
{

	@Path("/DeleteUser/{Id}")
	@GET
	@Produces("text/plain")
	public String Delete( @PathParam("Id") int Id) throws Exception
	{
		
		
		SystemUserDAO Object  = new SystemUserDAO();
		
		Object.delete(Object.getUserInfoById(Id));
	    
		return "Successful";
	}
	
	
	
	
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
		jsonObject.put("Last_Used_Date", User.getLastUsedDate());
		
		
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
			jsonObject.put("Last_Used_Date", Users.get(i).getLastUsedDate());
			
			
			JsonArray.put(jsonObject);
		}
		
	    
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
		
		return Matched;
	}
	
	
	
	@Path("/GetUserInfoby/{Username}/{Password}")
	@GET
	@Produces("text/plain")
	public String GET4(@PathParam("Username") String Username,@PathParam("Password") String Password ) throws Exception
	{
		String UsersName ="";
		String UsersSurname = "";
		
		SystemUserDAO Object  = new SystemUserDAO();
		
		List<SystemUser> User = Object.CheckUserPassword(Username, Password);
		
		
		if(User.size() != 0)
		{
			UsersName = User.get(0).getName().toString();
			UsersSurname = User.get(0).getSurname().toString();
		}
		
		
		JSONObject j = new JSONObject();
		
		j.put("UsersName", UsersName);
		j.put("UsersSurname", UsersSurname);
		
		
		
		
		
		return j.toString();
	}
	
	
	
	@Path("/GetUserByID/{Id}")
	@GET
	@Produces("text/plain")
	public String GETUser(@PathParam("Id") String Id ) throws Exception
	{
		
		
		
		SystemUserDAO Object  = new SystemUserDAO();
		
		List<SystemUser> User = Object.GetUserById(Id);
		
		
		System.out.println("IdNumber:" + User.get(0).getName().toString() ) ;
		
        JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("idSystem_User", User.get(0).getIdSystemUser());
		jsonObject.put("User_Name", User.get(0).getUserName().toString());
		jsonObject.put("Name", User.get(0).getUserName().toString());
		jsonObject.put("Surname", User.get(0).getSurname().toString());
		jsonObject.put("E_Mail", User.get(0).getEMail().toString());		
		jsonObject.put("Cell_Number", User.get(0).getCellNumber().toString());
		jsonObject.put("Tell_Number", User.get(0).getTellNumber().toString());
		jsonObject.put("Password", User.get(0).getUserPassword().toString());
		jsonObject.put("Authorization_Level", User.get(0).getAuthorizationLevel().toString());
		jsonObject.put("Last_Used_Date", User.get(0).getLastUsedDate().toString());
		

		return jsonObject.toString();
	}
	
	
	
	@Path("/SaveUserInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		
		

		JSONObject r = new JSONObject(jsonTextObject);	

			
		SystemUserDAO Object  = new SystemUserDAO();
		Object.AddUserInformation(r.getString("User_Name"),r.getString("Name"), r.getString("Surname"), r.getString("Email_address"), r.getString("Tell_Number"), r.getString("Cell_Number"), r.getString("Password"), r.getString("Authorization_Level"));
		
		return "Sucessful";	
		
			
	}
	
	
	 
	@Path("/UpdateUserInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String update(String jsonTextObject) throws JSONException
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		
		SystemUserDAO t = new SystemUserDAO();
		JSONObject test = new JSONObject(jsonTextObject);
		SystemUser User  = t.getUserInfoById(Integer.parseInt(test.getString("idSystem_User")));
		
		User.setName(test.getString("Name"));
		User.setSurname(test.getString("Surname"));
		User.setEMail(test.getString("E_Mail"));
		User.setCellNumber(test.getString("Cell_Number"));
		User.setTellNumber(test.getString("Tell_Number"));
		User.setAuthorizationLevel(test.getString("Authorization_Level"));
		User.setUserPassword(test.getString("Password"));
		User.setLastUsedDate(dateFormat.format(date));
		
		
		
		t.update(User);
		
		
		
		
		return "Updated";
	}
	

}
