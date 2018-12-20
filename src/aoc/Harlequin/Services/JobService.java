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







import aoc.Harlequin.DAOs.JobDAO;
import aoc.Harlequin.OBJs.SystemJob;




@Path("Job")
public class JobService {
	
	
	
	@SuppressWarnings("deprecation")
	@Path("/GetJobInfoByName/{job_Name}")
	@GET
	@Produces("text/plain")
	public String GETJobByName( @PathParam("job_Name") String job_Name) throws Exception
	{
		
		JobDAO jobDao  = new JobDAO();
		List<SystemJob> jobs  = jobDao.GetJobInfoByJobName(job_Name);
		
        JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < jobs.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Job_Id", jobs.get(i).getJobId());
			jsonObject.put("Job_Name", jobs.get(i).getJobName());
			jsonObject.put("Job_Code", jobs.get(i).getJobCode());
			jsonObject.put("Job_Client_Name", jobs.get(i).getJobClientName());
			jsonObject.put("Job_Details", jobs.get(i).getJobDetails());		
			jsonObject.put("Job_Comments", StringEscapeUtils.escapeJava(jobs.get(i).getJobComments().toString()));
			jsonObject.put("Job_Type", jobs.get(i).getJobType());
			jsonObject.put("Last_Used_Date", jobs.get(i).getLastUsedDate());
			
			
			jsonArray.put(jsonObject);
		
		}
		
	    
		return jsonArray.toString();
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
	@Path("/GetJobInfo/{id}")
	@GET
	@Produces("text/plain")
	public String GET( @PathParam("id") int id) throws Exception
	{
		
		JobDAO jobDao  = new JobDAO();
		SystemJob job  = jobDao.getJobInfoById(id);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("Job_Id", job.getJobId());
		jsonObject.put("Job_Name", job.getJobName());
		jsonObject.put("Job_Code", job.getJobCode());
		jsonObject.put("Job_Client_Name", job.getJobClientName());
		jsonObject.put("Job_Details", job.getJobDetails());		
		jsonObject.put("Job_Comments", StringEscapeUtils.escapeJava(job.getJobComments().toString()));
		jsonObject.put("Job_Type", job.getJobType());
		jsonObject.put("Last_Used_Date", job.getLastUsedDate());
		

	    
		return jsonObject.toString();
	}
	
	
	
	@Path("/DeleteJob/{id}")
	@GET
	@Produces("text/plain")
	public String Delete( @PathParam("id") int id) throws Exception
	{
		
		JobDAO jobDAO  = new JobDAO();
		
		jobDAO.delete(jobDAO.getJobInfoById(id));
	    
		return "Successful";
	}
	
	@SuppressWarnings("deprecation")
	@Path("/GetAllJobs")
	@GET
	@Produces("text/plain")
	public String GETClients( ) throws Exception
	{
		
		JobDAO jobDao  = new JobDAO();
		List<SystemJob> jobs = jobDao.ReadAllJobs();
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < jobs.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Job_Id", jobs.get(i).getJobId());
			jsonObject.put("Job_Name", jobs.get(i).getJobName());
			jsonObject.put("Job_Code", jobs.get(i).getJobCode());
			jsonObject.put("Job_Client_Name", jobs.get(i).getJobClientName());
			jsonObject.put("Job_Details", jobs.get(i).getJobDetails());		
			jsonObject.put("Job_Comments", StringEscapeUtils.escapeJava(jobs.get(i).getJobComments().toString()));
			jsonObject.put("Job_Type", jobs.get(i).getJobType());
			jsonObject.put("Last_Used_Date", jobs.get(i).getLastUsedDate());
			
			
			jsonArray.put(jsonObject);
		}
		

	    
		return jsonArray.toString();
	}
	
	
	
	@Path("/SaveAssignedJobInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String createAssignedJobInfo(String jsonTextObject) throws JSONException
	{

		JSONObject jsonObject = new JSONObject(jsonTextObject);	
		JobDAO jobDao  = new JobDAO();
				
		jobDao.AddJobInformation(jsonObject.getString("Job_Name"), jsonObject.getString("Job_Code"), jsonObject.getString("Job_Client_Name"), jsonObject.getString("Job_Details"), jsonObject.getString("Job_Comments"), jsonObject.getString("Job_Type"));
		
		return "Sucessful";	
	}
	
	
	
	@SuppressWarnings("deprecation")
	@Path("/GetLastJob")
	@GET
	@Produces("text/plain")
	public String GETJob( ) throws Exception
	{
		
		JobDAO jobDao  = new JobDAO();
		
		List<SystemJob> jobs = jobDao.ReadLastJob();
		
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < jobs.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Job_Id", jobs.get(i).getJobId());
			jsonObject.put("Job_Name", jobs.get(i).getJobName());
			jsonObject.put("Job_Code", jobs.get(i).getJobCode());
			jsonObject.put("Job_Client_Name", jobs.get(i).getJobClientName());
			jsonObject.put("Job_Details", jobs.get(i).getJobDetails());		
			jsonObject.put("Job_Comments", StringEscapeUtils.escapeJava(jobs.get(i).getJobComments().toString()));
			jsonObject.put("Job_Type", jobs.get(i).getJobType());
			jsonObject.put("Last_Used_Date", jobs.get(i).getJobType());
			
			
			jsonArray.put(jsonObject);
		}
		
	    
		return jsonArray.toString();
	}
	
	
	@Path("/SaveJobInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{

		JSONObject jsonObject = new JSONObject(jsonTextObject);	
		
		//System.out.println("WRITING TO DATABASE:"+ r.getString("Client_Name"));			
		JobDAO jobDao  = new JobDAO();
		jobDao.AddJobInformation(jsonObject.getString("Job_Name"), jsonObject.getString("Job_Code"), jsonObject.getString("Job_Client_Name"), jsonObject.getString("Job_Details"), jsonObject.getString("Job_Comments"), jsonObject.getString("Job_Type"));
		
		return "Sucessful";	
	}
	
	
	@Path("/UpdateJobInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String update(String jsonTextObject) throws JSONException
	{
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		JobDAO jobDao = new JobDAO();
		JSONObject jsonObject = new JSONObject(jsonTextObject);		
		SystemJob job  = jobDao.getJobInfoById(jsonObject.getInt("Job_Id"));

		job.setJobName(jsonObject.getString("Job_Name"));
		job.setJobClientName(jsonObject.getString("Job_Client_Name"));
		job.setJobDetails(jsonObject.getString("Job_Details"));
		job.setJobComments(jsonObject.getString("Job_Comments"));
		job.setJobType(jsonObject.getString("Job_Type"));
		job.setLastUsedDate(dateFormat.format(date));
				
		jobDao.update(job);
		
		return "Successful";
	}
	

}
