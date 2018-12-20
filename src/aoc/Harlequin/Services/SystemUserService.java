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
		
		SystemUserDAO systemUserDAO  = new SystemUserDAO();
		systemUserDAO.delete(systemUserDAO.getUserInfoById(Id));
	    
		return "Successful";
	}
	
	
	
	
	@Path("/GetUserInfo")
	@GET
	@Produces("text/plain")
	public String GET( ) throws Exception
	{
		
		SystemUserDAO systemUserDao  = new SystemUserDAO();
		SystemUser user  = systemUserDao.getUserInfoById(1);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("idSystem_User", user.getIdSystemUser());
		jsonObject.put("User_Name", user.getUserName());
		jsonObject.put("Name", user.getName());
		jsonObject.put("Surname", user.getSurname());
		jsonObject.put("E_Mail", user.getEMail());		
		jsonObject.put("Cell_Number", user.getCellNumber());
		jsonObject.put("Tell_Number", user.getTellNumber());
		jsonObject.put("User_Password", user.getUserPassword());
		jsonObject.put("Authorization_Level", user.getAuthorizationLevel());
		jsonObject.put("Last_Used_Date", user.getLastUsedDate());
	    
		return jsonObject.toString();
	}
	
	@Path("/GetAllUsers")
	@GET
	@Produces("text/plain")
	public String GETUSERS( ) throws Exception
	{
		
		SystemUserDAO systemUserDao  = new SystemUserDAO();
		
		List<SystemUser> users = systemUserDao.ReadAllUsers();
		
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < users.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("idSystem_User", users.get(i).getIdSystemUser());
			jsonObject.put("User_Name", users.get(i).getUserName());
			jsonObject.put("Name", users.get(i).getName());
			jsonObject.put("Surname", users.get(i).getSurname());
			jsonObject.put("E_Mail", users.get(i).getEMail());		
			jsonObject.put("Cell_Number", users.get(i).getCellNumber());
			jsonObject.put("Tell_Number", users.get(i).getTellNumber());
			jsonObject.put("Authorization_Level", users.get(i).getAuthorizationLevel());
			jsonObject.put("Last_Used_Date", users.get(i).getLastUsedDate());
			
			
			jsonArray.put(jsonObject);
		}
		
	    
		return jsonArray.toString();
	}
	
	
	@Path("/GetUser/{Username}/{Password}")
	@GET
	@Produces("text/plain")
	public String GET1(@PathParam("Username") String Username,@PathParam("Password") String Password ) throws Exception
	{
		
		String Matched = "false";
		String PasswordUser = "";
		SystemUserDAO systemUserDao  = new SystemUserDAO();
		List<SystemUser> users = systemUserDao.CheckUserPassword(Username, Password);
		
		if(users.size() != 0)
		{
			PasswordUser = users.get(0).getUserPassword().toString();
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
		
		SystemUserDAO systemUserDao  = new SystemUserDAO();
		
		List<SystemUser> user = systemUserDao.CheckUserPassword(Username, Password);
		
		
		if(user.size() != 0)
		{
			UsersName = user.get(0).getName().toString();
			UsersSurname = user.get(0).getSurname().toString();
		}
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("UsersName", UsersName);
		jsonObject.put("UsersSurname", UsersSurname);

		return jsonObject.toString();
	}
	
	
	
	@Path("/GetUserByID/{Id}")
	@GET
	@Produces("text/plain")
	public String GETUser(@PathParam("Id") String Id ) throws Exception
	{
		SystemUserDAO systemUserDao  = new SystemUserDAO();
		List<SystemUser> user = systemUserDao.GetUserById(Id);
        JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("idSystem_User", user.get(0).getIdSystemUser());
		jsonObject.put("User_Name", user.get(0).getUserName().toString());
		jsonObject.put("Name", user.get(0).getUserName().toString());
		jsonObject.put("Surname", user.get(0).getSurname().toString());
		jsonObject.put("E_Mail", user.get(0).getEMail().toString());		
		jsonObject.put("Cell_Number", user.get(0).getCellNumber().toString());
		jsonObject.put("Tell_Number", user.get(0).getTellNumber().toString());
		jsonObject.put("Password", user.get(0).getUserPassword().toString());
		jsonObject.put("Authorization_Level", user.get(0).getAuthorizationLevel().toString());
		jsonObject.put("Last_Used_Date", user.get(0).getLastUsedDate().toString());
		

		return jsonObject.toString();
	}
	
	
	
	@Path("/SaveUserInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		
		

		JSONObject jsonObject = new JSONObject(jsonTextObject);	

			
		SystemUserDAO Object  = new SystemUserDAO();
		Object.AddUserInformation(jsonObject.getString("User_Name"),jsonObject.getString("Name"), jsonObject.getString("Surname"), jsonObject.getString("Email_address"), jsonObject.getString("Tell_Number"), jsonObject.getString("Cell_Number"), jsonObject.getString("Password"), jsonObject.getString("Authorization_Level"));
		
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
		
		
		SystemUserDAO systemUserDAO = new SystemUserDAO();
		JSONObject 	jsonObject = new JSONObject(jsonTextObject);
		SystemUser User  = systemUserDAO.getUserInfoById(Integer.parseInt(jsonObject.getString("idSystem_User")));
		
		User.setName(jsonObject.getString("Name"));
		User.setSurname(jsonObject.getString("Surname"));
		User.setEMail(jsonObject.getString("E_Mail"));
		User.setCellNumber(jsonObject.getString("Cell_Number"));
		User.setTellNumber(jsonObject.getString("Tell_Number"));
		User.setAuthorizationLevel(jsonObject.getString("Authorization_Level"));
		User.setUserPassword(jsonObject.getString("Password"));
		User.setLastUsedDate(dateFormat.format(date));

		systemUserDAO.update(User);
	
		return "Updated";
	}
	

}
