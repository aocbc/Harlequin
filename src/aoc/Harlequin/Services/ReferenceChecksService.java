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

import org.apache.commons.lang3.StringEscapeUtils;
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

		SystemUserDAO systemUserDao  = new SystemUserDAO();
		systemUserDao.delete(systemUserDao.getUserInfoById(Id));
	    
		return "Successful";
	}
	
	@Path("/GetUserInfoByID/{idMac_Applicants}")
	@GET
	@Produces("text/plain")
	public String GET( @PathParam("idMac_Applicants") String idMac_Applicants) throws Exception
	{
		
		ReferenceCheckDAO referenceCheckDao  = new ReferenceCheckDAO();
		List<ReferenceChecks> referenceChecks  = referenceCheckDao.GetUserById(idMac_Applicants);
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < referenceChecks.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("idReference_Checks", referenceChecks.get(i).getIdReferenceChecks());
			jsonObject.put("idMac_Applicants", referenceChecks.get(i).getIdMacApplicants());
			jsonObject.put("Applicant_Name", referenceChecks.get(i).getApplicantName());
			jsonObject.put("Applicant_Surname", referenceChecks.get(i).getApplicantSurname());
			jsonObject.put("Id_Number", referenceChecks.get(i).getIdNumber());		
			jsonObject.put("All_Reference_checks_Passed", referenceChecks.get(i).getAllReferenceChecksPassed());
			jsonObject.put("Applicants_Overall_Reference", referenceChecks.get(i).getApplicantsOverallReference());
			jsonObject.put("Criminal_Check_Passed", referenceChecks.get(i).getCriminalCheckPassed());
			jsonObject.put("Applicants_Criminal_Checks_Criteria", referenceChecks.get(i).getApplicantsCriminalChecksCriteria());
			jsonObject.put("Exit_Medical_done", referenceChecks.get(i).getExitMedicalDone());
			jsonObject.put("Reference_Check_Complete", referenceChecks.get(i).getReferenceCheckComplete());
			jsonObject.put("Last_Used_Date", referenceChecks.get(i).getLastUsedDate());
			jsonObject.put("Username", referenceChecks.get(i).getUsername());
			jsonObject.put("Usersurname", referenceChecks.get(i).getUsersurname());
			jsonObject.put("Reference_Check_Comments", StringEscapeUtils.escapeJava(referenceChecks.get(i).getReferenceCheckComments()));
			
			jsonArray.put(jsonObject);
	     }
		
		    
		return jsonArray.toString();
	}
	
	
	@Path("/GetUserInfoByIDNumber/{id_number}")
	@GET
	@Produces("text/plain")
	public String GETid( @PathParam("id_number") String id_number) throws Exception
	{
		
			ReferenceCheckDAO referenceCheckDao  = new ReferenceCheckDAO(); 
			List<ReferenceChecks> referenceChecks  = referenceCheckDao.GetUserByIdNumber(id_number);
		
			JSONObject jsonObject = new JSONObject();
			if(referenceChecks.size() > 0)
			{
				jsonObject.put("idReference_Checks", referenceChecks.get(0).getIdReferenceChecks());
				jsonObject.put("idMac_Applicants", referenceChecks.get(0).getIdMacApplicants());
				jsonObject.put("Applicant_Name", referenceChecks.get(0).getApplicantName());
				jsonObject.put("Applicant_Surname", referenceChecks.get(0).getApplicantSurname());
				jsonObject.put("Id_Number", referenceChecks.get(0).getIdNumber());		
				jsonObject.put("All_Reference_checks_Passed", referenceChecks.get(0).getAllReferenceChecksPassed());
				jsonObject.put("Applicants_Overall_Reference", referenceChecks.get(0).getApplicantsOverallReference());
				jsonObject.put("Criminal_Check_Passed", referenceChecks.get(0).getCriminalCheckPassed());
				jsonObject.put("Applicants_Criminal_Checks_Criteria", referenceChecks.get(0).getApplicantsCriminalChecksCriteria());
				jsonObject.put("Exit_Medical_done", referenceChecks.get(0).getExitMedicalDone());
				jsonObject.put("Reference_Check_Complete", referenceChecks.get(0).getReferenceCheckComplete());
				jsonObject.put("Last_Used_Date", referenceChecks.get(0).getLastUsedDate());
				jsonObject.put("Username", referenceChecks.get(0).getUsername());
				jsonObject.put("Usersurname", referenceChecks.get(0).getUsersurname());
				jsonObject.put("Reference_Check_Comments", StringEscapeUtils.escapeJava(referenceChecks.get(0).getReferenceCheckComments()));
			}

		    
		return jsonObject.toString();
	}
	
	
	@Path("/GetReferenceChecksByIDNumber/{id_Number}")
	@GET
	@Produces("text/plain")
	public String GETidNumber( @PathParam("id_Number") String id_Number) throws Exception
	{
		
		ReferenceCheckDAO referenceCheckDAO  = new ReferenceCheckDAO();
		List<ReferenceChecks> referenceChecks  = referenceCheckDAO.GetUserByIdNumber(id_Number);
		JSONArray jsonArray = new JSONArray();
	
		
		for(int i = 0; i < referenceChecks.size();i++)
		{
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("idReference_Checks", referenceChecks.get(i).getIdReferenceChecks());
				jsonObject.put("idMac_Applicants", referenceChecks.get(i).getIdMacApplicants());
				jsonObject.put("Applicant_Name", referenceChecks.get(i).getApplicantName());
				jsonObject.put("Applicant_Surname", referenceChecks.get(i).getApplicantSurname());
				jsonObject.put("Id_Number", referenceChecks.get(i).getIdNumber());		
				jsonObject.put("All_Reference_checks_Passed", referenceChecks.get(i).getAllReferenceChecksPassed());
				jsonObject.put("Applicants_Overall_Reference", referenceChecks.get(i).getApplicantsOverallReference());
				jsonObject.put("Criminal_Check_Passed", referenceChecks.get(i).getCriminalCheckPassed());
				jsonObject.put("Applicants_Criminal_Checks_Criteria", referenceChecks.get(i).getApplicantsCriminalChecksCriteria());
				jsonObject.put("Exit_Medical_done", referenceChecks.get(i).getExitMedicalDone());
				jsonObject.put("Reference_Check_Complete", referenceChecks.get(i).getReferenceCheckComplete());
				jsonObject.put("Last_Used_Date", referenceChecks.get(i).getLastUsedDate());
				jsonObject.put("Username", referenceChecks.get(i).getUsername());
				jsonObject.put("Usersurname", referenceChecks.get(i).getUsersurname());
				jsonObject.put("Reference_Check_Comments", StringEscapeUtils.escapeJava(referenceChecks.get(i).getReferenceCheckComments()));
				jsonArray.put(jsonObject);
		}
			
		
		return jsonArray.toString();
	}
	
	
	
	@Path("/GetAllReferenceChecks")
	@GET
	@Produces("text/plain")
	public String GETUSERS( ) throws Exception
	{
		
		SystemUserDAO systemUserDAO  = new SystemUserDAO();
		List<SystemUser> users = systemUserDAO.ReadAllUsers();
		JSONArray JsonArray = new JSONArray();
		
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
		
		SystemUserDAO systemUserDAO  = new SystemUserDAO();
		List<SystemUser> user = systemUserDAO.CheckUserPassword(Username, Password);
		
		if(user.size() != 0)
		{
			PasswordUser = user.get(0).getUserPassword().toString();
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
		
		List<SystemUser> users = systemUserDao.CheckUserPassword(Username, Password);
		
		
		if(users.size() != 0)
		{
			UsersName = users.get(0).getName().toString();
			UsersSurname = users.get(0).getSurname().toString();
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
		SystemUserDAO systemUserDAO  = new SystemUserDAO();
		List<SystemUser> users = systemUserDAO.GetUserById(Id);
	
        JSONObject jsonObject = new JSONObject();
		jsonObject.put("idSystem_User", users.get(0).getIdSystemUser());
		jsonObject.put("User_Name", users.get(0).getUserName().toString());
		jsonObject.put("Name", users.get(0).getUserName().toString());
		jsonObject.put("Surname", users.get(0).getSurname().toString());
		jsonObject.put("E_Mail", users.get(0).getEMail().toString());		
		jsonObject.put("Cell_Number", users.get(0).getCellNumber().toString());
		jsonObject.put("Tell_Number", users.get(0).getTellNumber().toString());
		jsonObject.put("Password", users.get(0).getUserPassword().toString());
		jsonObject.put("Authorization_Level", users.get(0).getAuthorizationLevel().toString());
		jsonObject.put("Last_Used_Date", users.get(0).getLastUsedDate().toString());
		

		return jsonObject.toString();
	}
	
	
	
	@Path("/SaveReferenceCheckInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		JSONObject jsonObject = new JSONObject(jsonTextObject);	
		ReferenceCheckDAO referenceCheckDAO  = new ReferenceCheckDAO();
		referenceCheckDAO.AddReferenceChecksInfo(jsonObject.getString("idMac_Applicants"), jsonObject.getString("Applicant_Name"),jsonObject.getString("Applicant_Surname"), jsonObject.getString("Id_Number"), jsonObject.getString("All_Reference_Checks_Passed"), jsonObject.getString("Applicants_Overall_Reference"), jsonObject.getString("Criminal_Check_Passed"), jsonObject.getString("Applicants_Criminal_checks_Criteria"), jsonObject.getString("Exit_Medical_Done"), jsonObject.getString("Reference_Check_Complete"), jsonObject.getString("Username"), jsonObject.getString("Usersurname"), jsonObject.getString("Job_Name"), jsonObject.getString("Reference_Check_Comments"));
				
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
		
		SystemUserDAO systemUserDao = new SystemUserDAO();
		JSONObject jsonObject = new JSONObject(jsonTextObject);
		SystemUser user  = systemUserDao.getUserInfoById(Integer.parseInt(jsonObject.getString("idSystem_User")));
		
		user.setName(jsonObject.getString("Name"));
		user.setSurname(jsonObject.getString("Surname"));
		user.setEMail(jsonObject.getString("E_Mail"));
		user.setCellNumber(jsonObject.getString("Cell_Number"));
		user.setTellNumber(jsonObject.getString("Tell_Number"));
		user.setAuthorizationLevel(jsonObject.getString("Authorization_Level"));
		user.setUserPassword(jsonObject.getString("Password"));
		user.setLastUsedDate(dateFormat.format(date));
		
		systemUserDao.update(user);
		
		return "Updated";
	}
	

}
