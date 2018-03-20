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
import aoc.Harlequin.DAOs.SystemUserDAO;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemJob;
import aoc.Harlequin.OBJs.SystemUser;




@Path("Job")
public class JobService {
	
	@Path("/GetJobInfo/{Id}")
	@GET
	@Produces("text/plain")
	public String GET( @PathParam("Id") int Id) throws Exception
	{
		
		JobDAO Object  = new JobDAO();
		SystemJob Job  = Object.getJobInfoById(Id);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("Job_Id", Job.getJobId());
		jsonObject.put("Job_Name", Job.getJobName());
		jsonObject.put("Job_Code", Job.getJobCode());
		jsonObject.put("Job_Client_Name", Job.getJobClientName());
		jsonObject.put("Job_Details", Job.getJobDetails());		
		jsonObject.put("Job_Comments", Job.getJobComments());
		jsonObject.put("Job_Type", Job.getJobType());
		
		
		
		System.out.println(jsonObject.toString());
	    
		return jsonObject.toString();
	}
	
	@Path("/GetAllJobs")
	@GET
	@Produces("text/plain")
	public String GETClients( ) throws Exception
	{
		
		JobDAO Object  = new JobDAO();
		
		List<SystemJob> Jobs = Object.ReadAllJobs();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Jobs.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Job_Id", Jobs.get(i).getJobId());
			jsonObject.put("Job_Name", Jobs.get(i).getJobName());
			jsonObject.put("Job_Code", Jobs.get(i).getJobCode());
			jsonObject.put("Job_Client_Name", Jobs.get(i).getJobClientName());
			jsonObject.put("Job_Details", Jobs.get(i).getJobDetails());		
			jsonObject.put("Job_Comments", Jobs.get(i).getJobComments());
			jsonObject.put("Job_Type", Jobs.get(i).getJobType());
			
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
	    
		return JsonArray.toString();
	}
	
	
	
	
	@Path("/SaveJobInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		
		System.out.println(jsonTextObject);
		JSONObject r = new JSONObject(jsonTextObject);	
	
		
		//System.out.println("WRITING TO DATABASE:"+ r.getString("Client_Name"));
			
		JobDAO Object  = new JobDAO();
		Object.AddJobInformation(r.getString("Job_Name"), r.getString("Job_Code"), r.getString("Job_Client_Name"), r.getString("Job_Details"), r.getString("Job_Comments"), r.getString("Job_Type"));
		return "Sucessful";	
		
			
	}
	
	
	

}
