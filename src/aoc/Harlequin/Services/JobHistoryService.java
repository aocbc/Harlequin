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

import aoc.Harlequin.DAOs.ClientDAO;
import aoc.Harlequin.DAOs.JobDAO;
import aoc.Harlequin.DAOs.JobHistoryDAO;
import aoc.Harlequin.OBJs.JobHistory;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemJob;


@Path("JobHistory")
public class JobHistoryService {
	
	@Path("/GetJobHistoryInfo/{Id}")
	@GET
	@Produces("text/plain")
	public String GET( @PathParam("Id") int Id) throws Exception
	{
		
		JobHistoryDAO Object  = new JobHistoryDAO();
		JobHistory JobHistory  = Object.getJobInfoById(Id);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("Job_Role", JobHistory.getJobRole());
		jsonObject.put("Job_Description", JobHistory.getJobDescription());
		jsonObject.put("Employer_Contact_Person", JobHistory.getEmployerContactPerson());
		jsonObject.put("Employer_Contact_Number", JobHistory.getEmployerContactPerson());
		jsonObject.put("Employer_Industry", JobHistory.getEmployerIndustry());		
		jsonObject.put("Period_From", JobHistory.getPeriodFrom());
		jsonObject.put("Period_To", JobHistory.getPeriodTo());
		jsonObject.put("idMac_Applicants", JobHistory.getIdJobHistory());		
		jsonObject.put("Name", JobHistory.getName());
		jsonObject.put("Surname", JobHistory.getSurname());
		jsonObject.put("Employer_Name", JobHistory.getEmployerName());
		
		
		
		System.out.println(jsonObject.toString());
	    
		return jsonObject.toString();
	}
	
	@Path("/GetJobHistory/{IdNumber}")
	@GET
	@Produces("text/plain")
	public String GET3( @PathParam("IdNumber") String IdNumber) throws Exception
	{
		
		JobHistoryDAO Object  = new JobHistoryDAO();
		List<JobHistory> History  = Object.ReadAllJobHistoryByIdNumber(IdNumber);
		
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < History.size();i++)
		{
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Job_Role", History.get(i).getJobRole());
			jsonObject.put("Job_Description", History.get(i).getJobDescription());
			jsonObject.put("Employer_Contact_Person", History.get(i).getEmployerContactPerson());
			jsonObject.put("Employer_Contact_Number", History.get(i).getEmployerContactNumber());
			jsonObject.put("Employer_Industry", History.get(i).getEmployerIndustry());		
			jsonObject.put("Period_From", History.get(i).getPeriodFrom());
			jsonObject.put("Period_To", History.get(i).getPeriodTo());
			jsonObject.put("idMac_Applicants", History.get(i).getIdMacApplicants());
			jsonObject.put("Name", History.get(i).getName());
			jsonObject.put("Surname", History.get(i).getSurname());
			jsonObject.put("Employer_Name", History.get(i).getEmployerName());
			JsonArray.put(jsonObject);
		}
		
		
	    
		return JsonArray.toString();
	}
	
	
	@Path("/SaveJobHistory")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{

		JSONObject r = new JSONObject(jsonTextObject);	
	
		
		//System.out.println("WRITING TO DATABASE:"+ r.getString("Client_Name"));
			
		JobHistoryDAO Object  = new JobHistoryDAO();
		Object.AddJobHistroy(r.getString("Job_Role"), r.getString("Job_Description"), r.getString("Employer_Contact_Person"), r.getString("Employer_Contact_Number"), r.getString("Employer_Industry"), r.getString("Period_From"), r.getString("Period_To"), r.getString("idMac_Applicants"), r.getString("Name"), r.getString("Surname"),r.getString("Employer_Name"));
		
		return "Sucessful";	
		
			
	}
	
	
	
	@Path("/SaveJobHistoryUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create2(String jsonTextObject) throws JSONException
	{
		/*JSONArray json = new JSONArray(jsonTextObject);*/
		JSONObject json = new JSONObject(jsonTextObject);
		JSONArray Jobs = json.getJSONArray("Job");
		
		
		//////////////////////////////////////////////////////////////////////////////
		///////////////////////Removing Job History if exists/////////////////////////
		//////////////////////////////////////////////////////////////////////////////
		
		if(Jobs.length()>0)
		{
			JSONObject x = new JSONObject( Jobs.get(0).toString());
			JobHistoryDAO Object1  = new JobHistoryDAO();
			List<JobHistory> History  = Object1.ReadAllJobHistoryByIdNumber(x.getString("idMac_Applicants"));

			
			if(History.size() > 0)
			{
			
				for(int k = 0 ;k<History.size();k++)
				{   
					System.out.println("Test3");
					Object1.delete(History.get(k));
				}
			
			}
		}
		
		
		////////////////////////////////////////////////////////////////////////////
		////////////////////////Adding user to database/////////////////////////////
		////////////////////////////////////////////////////////////////////////////
		
		for (int i = 0; i < Jobs.length(); i++) 
		{
			
			
			JSONObject r = new JSONObject( Jobs.get(i).toString());
			JobHistoryDAO Object  = new JobHistoryDAO();
			
			
			
			
			
			Object.AddJobHistroy(r.getString("Job_Role"), r.getString("Job_Description"), r.getString("Employer_Contact_Person"), r.getString("Employer_Contact_Number"), r.getString("Employer_Industry"), r.getString("Period_From"), r.getString("Period_To"), r.getString("idMac_Applicants"), r.getString("Name"), r.getString("Surname"),r.getString("Employer_Name"));
		
			
			
		}
		
		
				return "Sucessful";	
		
			
	}
	
	
	
	@Path("/GetAllJobHistory")
	@GET
	@Produces("text/plain")
	public String GETClients( ) throws Exception
	{
		
		JobHistoryDAO Object  = new JobHistoryDAO();
		
		List<JobHistory> History = Object.ReadAllJobHistory();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < History.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Job_Role", History.get(i).getJobRole());
			jsonObject.put("Job_Description", History.get(i).getJobDescription());
			jsonObject.put("Employer_Contact_Person", History.get(i).getEmployerContactPerson());
			jsonObject.put("Employer_Contact_Number", History.get(i).getEmployerContactNumber());
			jsonObject.put("Employer_Industry", History.get(i).getEmployerIndustry());		
			jsonObject.put("Period_From", History.get(i).getPeriodFrom());
			jsonObject.put("Period_To", History.get(i).getPeriodTo());
			jsonObject.put("idMac_Applicants", History.get(i).getIdMacApplicants());
			jsonObject.put("Name", History.get(i).getName());
			jsonObject.put("Surname", History.get(i).getSurname());
			jsonObject.put("Employer_Name", History.get(i).getEmployerName());
			
			
			JsonArray.put(jsonObject);
		}
		

		return JsonArray.toString();
	}

}
