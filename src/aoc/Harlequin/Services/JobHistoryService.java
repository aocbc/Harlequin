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
		
		
		
		System.out.println(jsonObject.toString());
	    
		return jsonObject.toString();
	}
	
	
	@Path("/SaveJobHistory")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		
		System.out.println(jsonTextObject);
		JSONObject r = new JSONObject(jsonTextObject);	
	
		
		//System.out.println("WRITING TO DATABASE:"+ r.getString("Client_Name"));
			
		JobHistoryDAO Object  = new JobHistoryDAO();
		Object.AddJobHistroy(r.getString("Job_Role"), r.getString("Job_Description"), r.getString("Employer_Contact_Person"), r.getString("Employer_Contact_Number"), r.getString("Employer_Industry"), r.getString("Period_From"), r.getString("Period_To"), r.getString("idMac_Applicants"), r.getString("Name"), r.getString("Surname"));
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
			
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
	    
		return JsonArray.toString();
	}

}