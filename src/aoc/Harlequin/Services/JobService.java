package aoc.Harlequin.Services;
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






import aoc.Harlequin.DAOs.JobDAO;
import aoc.Harlequin.OBJs.SystemJob;




@Path("Job")
public class JobService {
	
	
	
	@SuppressWarnings("deprecation")
	@Path("/GetJobInfoByName/{Job_Name}")
	@GET
	@Produces("text/plain")
	public String GETJobByName( @PathParam("Job_Name") String Job_Name) throws Exception
	{
		
		JobDAO Object  = new JobDAO();
		List<SystemJob> Jobs  = Object.GetJobInfoByJobName(Job_Name);
		
        JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Jobs.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Job_Id", Jobs.get(i).getJobId());
			jsonObject.put("Job_Name", Jobs.get(i).getJobName());
			jsonObject.put("Job_Code", Jobs.get(i).getJobCode());
			jsonObject.put("Job_Client_Name", Jobs.get(i).getJobClientName());
			jsonObject.put("Job_Details", Jobs.get(i).getJobDetails());		
			jsonObject.put("Job_Comments", StringEscapeUtils.escapeJava(Jobs.get(i).getJobComments().toString()));
			jsonObject.put("Job_Type", Jobs.get(i).getJobType());
			
			
			JsonArray.put(jsonObject);
		
		}
		
		
		
		
	    
		return JsonArray.toString();
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
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
		jsonObject.put("Job_Comments", StringEscapeUtils.escapeJava(Job.getJobComments().toString()));
		jsonObject.put("Job_Type", Job.getJobType());
		
		
		
		System.out.println(jsonObject.toString());
	    
		return jsonObject.toString();
	}
	
	
	
	@Path("/DeleteJob/{Id}")
	@GET
	@Produces("text/plain")
	public String Delete( @PathParam("Id") int Id) throws Exception
	{
		
		JobDAO Object  = new JobDAO();
		
		Object.delete(Object.getJobInfoById(Id));
	    
		return "Successful";
	}
	
	@SuppressWarnings("deprecation")
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
			jsonObject.put("Job_Comments", StringEscapeUtils.escapeJava(Jobs.get(i).getJobComments().toString()));
			jsonObject.put("Job_Type", Jobs.get(i).getJobType());
			
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
	    
		return JsonArray.toString();
	}
	
	
	
	@Path("/SaveAssignedJobInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String createAssignedJobInfo(String jsonTextObject) throws JSONException
	{

		System.out.println(jsonTextObject);
		JSONObject r = new JSONObject(jsonTextObject);	
		
		//System.out.println("WRITING TO DATABASE:"+ r.getString("Client_Name"));			
		JobDAO Object  = new JobDAO();
		
		
		
		
		
		Object.AddJobInformation(r.getString("Job_Name"), r.getString("Job_Code"), r.getString("Job_Client_Name"), r.getString("Job_Details"), r.getString("Job_Comments"), r.getString("Job_Type"));
		
		return "Sucessful";	
	}
	
	
	
	@SuppressWarnings("deprecation")
	@Path("/GetLastJob")
	@GET
	@Produces("text/plain")
	public String GETJob( ) throws Exception
	{
		
		JobDAO Object  = new JobDAO();
		
		List<SystemJob> Jobs = Object.ReadLastJob();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Jobs.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Job_Id", Jobs.get(i).getJobId());
			jsonObject.put("Job_Name", Jobs.get(i).getJobName());
			jsonObject.put("Job_Code", Jobs.get(i).getJobCode());
			jsonObject.put("Job_Client_Name", Jobs.get(i).getJobClientName());
			jsonObject.put("Job_Details", Jobs.get(i).getJobDetails());		
			jsonObject.put("Job_Comments", StringEscapeUtils.escapeJava(Jobs.get(i).getJobComments().toString()));
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
	
	
	@Path("/UpdateJobInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String update(String jsonTextObject) throws JSONException
	{
		JobDAO t = new JobDAO();
		JSONObject test = new JSONObject(jsonTextObject);
		System.out.println("Applicant Update"+test.toString());
		
		SystemJob Job  = t.getJobInfoById(test.getInt("Job_Id"));
		
		
		
		Job.setJobName(test.getString("Job_Name"));
		
		Job.setJobClientName(test.getString("Job_Client_Name"));
		Job.setJobDetails(test.getString("Job_Details"));
		Job.setJobComments(test.getString("Job_Comments"));
		Job.setJobType(test.getString("Job_Type"));
	
		
		
		
		
		t.update(Job);
		
		
		
		
		return "Successful";
	}
	

}
