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
		
		JobHistoryDAO jobHistoryDAO  = new JobHistoryDAO();
		JobHistory jobHistory  = jobHistoryDAO.getJobInfoById(Id);
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("Job_Role", jobHistory.getJobRole());
		jsonObject.put("Job_Description", jobHistory.getJobDescription());
		jsonObject.put("Employer_Contact_Person", jobHistory.getEmployerContactPerson());
		jsonObject.put("Employer_Contact_Number", jobHistory.getEmployerContactPerson());
		jsonObject.put("Employer_Industry", jobHistory.getEmployerIndustry());		
		jsonObject.put("Period_From", jobHistory.getPeriodFrom());
		jsonObject.put("Period_To", jobHistory.getPeriodTo());
		jsonObject.put("idMac_Applicants", jobHistory.getIdJobHistory());		
		jsonObject.put("Name", jobHistory.getName());
		jsonObject.put("Surname", jobHistory.getSurname());
		jsonObject.put("Employer_Name", jobHistory.getEmployerName());
	    
		return jsonObject.toString();
	}
	
	@Path("/GetJobHistory/{idNumber}")
	@GET
	@Produces("text/plain")
	public String GET3( @PathParam("idNumber") String idNumber) throws Exception
	{
		
		JobHistoryDAO jobHistoryDao  = new JobHistoryDAO();
		List<JobHistory> historys  = jobHistoryDao.ReadAllJobHistoryByIdNumber(idNumber);
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < historys.size();i++)
		{
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Job_Role", historys.get(i).getJobRole());
			jsonObject.put("Job_Description", historys.get(i).getJobDescription());
			jsonObject.put("Employer_Contact_Person", historys.get(i).getEmployerContactPerson());
			jsonObject.put("Employer_Contact_Number", historys.get(i).getEmployerContactNumber());
			jsonObject.put("Employer_Industry", historys.get(i).getEmployerIndustry());		
			jsonObject.put("Period_From", historys.get(i).getPeriodFrom());
			jsonObject.put("Period_To", historys.get(i).getPeriodTo());
			jsonObject.put("idMac_Applicants", historys.get(i).getIdMacApplicants());
			jsonObject.put("Name", historys.get(i).getName());
			jsonObject.put("Surname", historys.get(i).getSurname());
			jsonObject.put("Employer_Name", historys.get(i).getEmployerName());
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

		JSONObject jsonObject = new JSONObject(jsonTextObject);	
	
		JobHistoryDAO jobHistoryDao  = new JobHistoryDAO();
		jobHistoryDao.AddJobHistroy(jsonObject.getString("Job_Role"), jsonObject.getString("Job_Description"), jsonObject.getString("Employer_Contact_Person"), jsonObject.getString("Employer_Contact_Number"), jsonObject.getString("Employer_Industry"), jsonObject.getString("Period_From"), jsonObject.getString("Period_To"), jsonObject.getString("idMac_Applicants"), jsonObject.getString("Name"), jsonObject.getString("Surname"),jsonObject.getString("Employer_Name"));
		
		return "Sucessful";	
		
			
	}
	
	
	
	@Path("/SaveJobHistoryUser")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create2(String jsonTextObject) throws JSONException
	{
		/*JSONArray json = new JSONArray(jsonTextObject);*/
		JSONObject jsonObject = new JSONObject(jsonTextObject);
		JSONArray jsonArray = jsonObject.getJSONArray("Job");
		
		
		//////////////////////////////////////////////////////////////////////////////
		///////////////////////Removing Job History if exists/////////////////////////
		//////////////////////////////////////////////////////////////////////////////
		
		if(jsonArray.length()>0)
		{
			JSONObject jsonObject1 = new JSONObject( jsonArray.get(0).toString());
			JobHistoryDAO jobHistoryDAO  = new JobHistoryDAO();
			List<JobHistory> historys  = jobHistoryDAO.ReadAllJobHistoryByIdNumber(jsonObject1.getString("idMac_Applicants"));

			
			if(historys.size() > 0)
			{
			
				for(int k = 0 ;k < historys.size();k++)
				{   
				
					jobHistoryDAO.delete(historys.get(k));
				}
			
			}
		}
		
		
		////////////////////////////////////////////////////////////////////////////
		////////////////////////Adding user to database/////////////////////////////
		////////////////////////////////////////////////////////////////////////////
		
		for (int i = 0; i < jsonArray.length(); i++) 
		{
						
			JSONObject jsonObject2 = new JSONObject( jsonArray.get(i).toString());
			JobHistoryDAO jobHistoryDAO1  = new JobHistoryDAO();
				
			jobHistoryDAO1.AddJobHistroy(jsonObject2.getString("Job_Role"), jsonObject2.getString("Job_Description"), jsonObject2.getString("Employer_Contact_Person"), jsonObject2.getString("Employer_Contact_Number"), jsonObject2.getString("Employer_Industry"), jsonObject2.getString("Period_From"), jsonObject2.getString("Period_To"), jsonObject2.getString("idMac_Applicants"), jsonObject2.getString("Name"), jsonObject2.getString("Surname"),jsonObject2.getString("Employer_Name"));
		

		}
	
		return "Sucessful";	
	}
	
	
	
	@Path("/GetAllJobHistory")
	@GET
	@Produces("text/plain")
	public String GETClients( ) throws Exception
	{
		
		JobHistoryDAO jobHistoryDAO  = new JobHistoryDAO();
		
		List<JobHistory> historys = jobHistoryDAO.ReadAllJobHistory();
		
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < historys.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Job_Role", historys.get(i).getJobRole());
			jsonObject.put("Job_Description", historys.get(i).getJobDescription());
			jsonObject.put("Employer_Contact_Person", historys.get(i).getEmployerContactPerson());
			jsonObject.put("Employer_Contact_Number", historys.get(i).getEmployerContactNumber());
			jsonObject.put("Employer_Industry", historys.get(i).getEmployerIndustry());		
			jsonObject.put("Period_From", historys.get(i).getPeriodFrom());
			jsonObject.put("Period_To", historys.get(i).getPeriodTo());
			jsonObject.put("idMac_Applicants", historys.get(i).getIdMacApplicants());
			jsonObject.put("Name", historys.get(i).getName());
			jsonObject.put("Surname", historys.get(i).getSurname());
			jsonObject.put("Employer_Name", historys.get(i).getEmployerName());
			
			
			jsonArray.put(jsonObject);
		}
		

		return jsonArray.toString();
	}

}
