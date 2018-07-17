package aoc.Harlequin.Services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONObject;

import aoc.Harlequin.DAOs.AssignedJobApplicantDAO;
import aoc.Harlequin.OBJs.AssignedJobApplicantList;


@Path("AssignedJobs")
public class AssignedJobListService 
{

	
	@Path("/ReadAllAssignedJobs")
	@GET
	@Produces("text/plain")
	public String GetAllAssignedJobs() throws Exception
	{
	    
		AssignedJobApplicantDAO Object  = new AssignedJobApplicantDAO();
		
		List<AssignedJobApplicantList> AssignedJobs = Object.ReadAllAssignedJobsInfo();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < AssignedJobs.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("idAssignedJobApplicantList", AssignedJobs.get(i).getIdAssignedJobApplicantList());
			jsonObject.put("Job_Id", AssignedJobs.get(i).getJobId());
			jsonObject.put("Job_Name", AssignedJobs.get(i).getJobName());
			
			jsonObject.put("Job_Code", AssignedJobs.get(i).getJobCode());
			jsonObject.put("Job_Client_Name", AssignedJobs.get(i).getJobClientName());
			jsonObject.put("Job_Details", AssignedJobs.get(i).getJobDetails());
			
			jsonObject.put("Job_Comments", AssignedJobs.get(i).getJobComments());
			jsonObject.put("Job_Type", AssignedJobs.get(i).getJobType());
			jsonObject.put("idMac_Applicants", AssignedJobs.get(i).getIdMacApplicants());
			
			jsonObject.put("Name", AssignedJobs.get(i).getName());
			jsonObject.put("Surname", AssignedJobs.get(i).getSurname());
			jsonObject.put("Stage_In_Process", AssignedJobs.get(i).getStageInProcess());

			jsonObject.put("Stage_Status", AssignedJobs.get(i).getStageStatus());
			
			JsonArray.put(jsonObject);
		}

		return JsonArray.toString();
	}
	
	
	
	
	
}
