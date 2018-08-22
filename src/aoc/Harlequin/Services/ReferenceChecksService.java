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
import aoc.Harlequin.DAOs.ReferenceCheckDAO;
import aoc.Harlequin.DAOs.SystemUserDAO;
import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.ReferenceChecks;
import aoc.Harlequin.OBJs.SystemUser;




@Path("ReferenceChecks")
public class ReferenceChecksService 
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
	
	
	
	
	@Path("/GetUserInfoByID/{idMac_Applicants}")
	@GET
	@Produces("text/plain")
	public String GET( @PathParam("idMac_Applicants") String idMac_Applicants) throws Exception
	{
		
		ReferenceCheckDAO Object  = new ReferenceCheckDAO();
		 
		List<ReferenceChecks> Referencecheck  = Object.GetUserById(idMac_Applicants);
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Referencecheck.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idReference_Checks", Referencecheck.get(i).getIdReferenceChecks());
			jsonObject.put("idMac_Applicants", Referencecheck.get(i).getIdMacApplicants());
			jsonObject.put("Applicant_Name", Referencecheck.get(i).getApplicantName());
			jsonObject.put("Applicant_Surname", Referencecheck.get(i).getApplicantSurname());
			jsonObject.put("Id_Number", Referencecheck.get(i).getIdNumber());		
			jsonObject.put("All_Reference_checks_Passed", Referencecheck.get(i).getAllReferenceChecksPassed());
			jsonObject.put("Applicants_Overall_Reference", Referencecheck.get(i).getApplicantsOverallReference());
			jsonObject.put("Criminal_Check_Passed", Referencecheck.get(i).getCriminalCheckPassed());
			jsonObject.put("Applicants_Criminal_Checks_Criteria", Referencecheck.get(i).getApplicantsCriminalChecksCriteria());
			jsonObject.put("Exit_Medical_done", Referencecheck.get(i).getExitMedicalDone());
			
			jsonObject.put("Reference_Check_Complete", Referencecheck.get(i).getReferenceCheckComplete());
			jsonObject.put("Last_Used_Date", Referencecheck.get(i).getLastUsedDate());
			jsonObject.put("Username", Referencecheck.get(i).getUsername());
			jsonObject.put("Usersurname", Referencecheck.get(i).getUsersurname());
			
			jsonObject.put("Reference_Check_Comments", Referencecheck.get(i).getReferenceCheckComments());
			
			JsonArray.put(jsonObject);
	     }
		
		    
		return JsonArray.toString();
	}
	
	
	@Path("/GetUserInfoByIDNumber/{id_number}")
	@GET
	@Produces("text/plain")
	public String GETid( @PathParam("id_number") String id_number) throws Exception
	{
		
		ReferenceCheckDAO Object  = new ReferenceCheckDAO();
		 
		List<ReferenceChecks> Referencecheck  = Object.GetUserByIdNumber(id_number);
		
		
		
		
			JSONObject jsonObject = new JSONObject();
			if(Referencecheck.size() > 0)
			{
				jsonObject.put("idReference_Checks", Referencecheck.get(0).getIdReferenceChecks());
				jsonObject.put("idMac_Applicants", Referencecheck.get(0).getIdMacApplicants());
				jsonObject.put("Applicant_Name", Referencecheck.get(0).getApplicantName());
				jsonObject.put("Applicant_Surname", Referencecheck.get(0).getApplicantSurname());
				jsonObject.put("Id_Number", Referencecheck.get(0).getIdNumber());		
				jsonObject.put("All_Reference_checks_Passed", Referencecheck.get(0).getAllReferenceChecksPassed());
				jsonObject.put("Applicants_Overall_Reference", Referencecheck.get(0).getApplicantsOverallReference());
				jsonObject.put("Criminal_Check_Passed", Referencecheck.get(0).getCriminalCheckPassed());
				jsonObject.put("Applicants_Criminal_Checks_Criteria", Referencecheck.get(0).getApplicantsCriminalChecksCriteria());
				jsonObject.put("Exit_Medical_done", Referencecheck.get(0).getExitMedicalDone());
				
				jsonObject.put("Reference_Check_Complete", Referencecheck.get(0).getReferenceCheckComplete());
				jsonObject.put("Last_Used_Date", Referencecheck.get(0).getLastUsedDate());
				jsonObject.put("Username", Referencecheck.get(0).getUsername());
				jsonObject.put("Usersurname", Referencecheck.get(0).getUsersurname());
				
				jsonObject.put("Reference_Check_Comments", Referencecheck.get(0).getReferenceCheckComments());
			}
			
			
			
	   
		
		    
		return jsonObject.toString();
	}
	
	
	@Path("/GetReferenceChecksByIDNumber/{Id_Number}")
	@GET
	@Produces("text/plain")
	public String GETidNumber( @PathParam("Id_Number") String Id_Number) throws Exception
	{
		
		ReferenceCheckDAO Object  = new ReferenceCheckDAO();
		 
		List<ReferenceChecks> Referencecheck  = Object.GetUserByIdNumber(Id_Number);
		
		JSONArray JsonArray = new JSONArray();
		System.out.println("Id_Number:"+Id_Number );
		
		for(int i = 0; i < Referencecheck.size();i++)
		{
		
		
				JSONObject jsonObject = new JSONObject();
			
				jsonObject.put("idReference_Checks", Referencecheck.get(i).getIdReferenceChecks());
				jsonObject.put("idMac_Applicants", Referencecheck.get(i).getIdMacApplicants());
				jsonObject.put("Applicant_Name", Referencecheck.get(i).getApplicantName());
				jsonObject.put("Applicant_Surname", Referencecheck.get(i).getApplicantSurname());
				jsonObject.put("Id_Number", Referencecheck.get(i).getIdNumber());		
				jsonObject.put("All_Reference_checks_Passed", Referencecheck.get(i).getAllReferenceChecksPassed());
				jsonObject.put("Applicants_Overall_Reference", Referencecheck.get(i).getApplicantsOverallReference());
				jsonObject.put("Criminal_Check_Passed", Referencecheck.get(i).getCriminalCheckPassed());
				jsonObject.put("Applicants_Criminal_Checks_Criteria", Referencecheck.get(i).getApplicantsCriminalChecksCriteria());
				jsonObject.put("Exit_Medical_done", Referencecheck.get(i).getExitMedicalDone());
				
				jsonObject.put("Reference_Check_Complete", Referencecheck.get(i).getReferenceCheckComplete());
				jsonObject.put("Last_Used_Date", Referencecheck.get(i).getLastUsedDate());
				jsonObject.put("Username", Referencecheck.get(i).getUsername());
				jsonObject.put("Usersurname", Referencecheck.get(i).getUsersurname());
				
				jsonObject.put("Reference_Check_Comments", Referencecheck.get(i).getReferenceCheckComments());
				
				JsonArray.put(jsonObject);
		}
			
			
			
	   
		
		    
		return JsonArray.toString();
	}
	
	
	
	@Path("/GetAllReferenceChecks")
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
		
		
		System.out.println(jsonObject.toString());
		return jsonObject.toString();
	}
	
	
	
	@Path("/SaveReferenceCheckInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		
		
		
		System.out.println(jsonTextObject);
		JSONObject r = new JSONObject(jsonTextObject);	
	
		
		
			
		ReferenceCheckDAO Object  = new ReferenceCheckDAO();
		Object.AddReferenceChecksInfo(r.getString("idMac_Applicants"), r.getString("Applicant_Name"),r.getString("Applicant_Surname"), r.getString("Id_Number"), r.getString("All_Reference_Checks_Passed"), r.getString("Applicants_Overall_Reference"), r.getString("Criminal_Check_Passed"), r.getString("Applicants_Criminal_checks_Criteria"), r.getString("Exit_Medical_Done"), r.getString("Reference_Check_Complete"), r.getString("Username"), r.getString("Usersurname"), r.getString("Job_Name"), r.getString("Reference_Check_Comments"));
		
		
		
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
