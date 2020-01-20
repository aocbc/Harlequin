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
import org.json.JSONObject;

import aoc.Harlequin.DAOs.AssignedJobApplicantDAO;
import aoc.Harlequin.DAOs.JobDAO;
import aoc.Harlequin.OBJs.AssignedJobApplicantList;


@Path("AssignedJobs")
public class AssignedJobListService 
{

	
	@SuppressWarnings("deprecation")
	@Path("/ReadAllAssignedJobs")
	@GET
	@Produces("text/plain")
	public String GetAllAssignedJobs() throws Exception
	{
	    
		AssignedJobApplicantDAO assignedJobApplicantDAO  = new AssignedJobApplicantDAO();
		
		List<AssignedJobApplicantList> assignedJobs = assignedJobApplicantDAO.ReadAllAssignedJobsInfo();
		
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < assignedJobs.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("idAssignedJobApplicantList", assignedJobs.get(i).getIdAssignedJobApplicantList());
			jsonObject.put("Job_Id", assignedJobs.get(i).getJobId());
			jsonObject.put("Job_Name", assignedJobs.get(i).getJobName());
			jsonObject.put("Job_Code", assignedJobs.get(i).getJobCode());
			jsonObject.put("Job_Client_Name", assignedJobs.get(i).getJobClientName());
			jsonObject.put("Job_Details", assignedJobs.get(i).getJobDetails());
			jsonObject.put("Job_Comments", assignedJobs.get(i).getJobComments());
			jsonObject.put("Job_Type", assignedJobs.get(i).getJobType());
			jsonObject.put("idMac_Applicants", assignedJobs.get(i).getIdMacApplicants());
			jsonObject.put("Name", assignedJobs.get(i).getName());
			jsonObject.put("Surname", assignedJobs.get(i).getSurname());
			jsonObject.put("Stage_In_Process", assignedJobs.get(i).getStageInProcess());
			jsonObject.put("Stage_Status", assignedJobs.get(i).getStageStatus());
			jsonObject.put("Mac_Labour_Interview_Comments",StringEscapeUtils.escapeJava( assignedJobs.get(i).getMacLabourInterviewComments()));
			jsonObject.put("Mac_Lab_Interview_Complete", assignedJobs.get(i).getMacLabInterviewComplete());
			jsonObject.put("Practical_Drivers_Test_Complete", assignedJobs.get(i).getPracticalDriversTestComplete());
			jsonObject.put("Practical_Drivers_Test_Comments", StringEscapeUtils.escapeJava(assignedJobs.get(i).getPracticalDriversTestComments()));
			jsonObject.put("Client_Interview_Complete", assignedJobs.get(i).getClientInterviewComplete());
			jsonObject.put("Client_Interview_Comments", StringEscapeUtils.escapeJava(assignedJobs.get(i).getClientInterviewComments()));
			jsonObject.put("Reference_Checks_Complete", assignedJobs.get(i).getReferenceChecksComplete());
			jsonObject.put("Reference_Checks_Comments", StringEscapeUtils.escapeJava(assignedJobs.get(i).getReferenceChecksComments()));
			
			jsonArray.put(jsonObject);
		}

		return jsonArray.toString();
	}
	
	
	@SuppressWarnings("deprecation")
	@Path("/ReadAllAssignedJobs/{Job_Id}")
	@GET
	@Produces("text/plain")
	public String GetAllAssignedJobsByJobId(@PathParam("Job_Id") int Job_Id) throws Exception
	{
	    
		AssignedJobApplicantDAO assignedJobApplicantDAO  = new AssignedJobApplicantDAO();
		
		List<AssignedJobApplicantList> assignedJobs = assignedJobApplicantDAO.ReadAllAssignedJobsInfoByJob_Id(Job_Id);
		
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < assignedJobs.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("idAssignedJobApplicantList", assignedJobs.get(i).getIdAssignedJobApplicantList());
			jsonObject.put("Job_Id", assignedJobs.get(i).getJobId());
			jsonObject.put("Job_Name", assignedJobs.get(i).getJobName());
			jsonObject.put("Job_Code", assignedJobs.get(i).getJobCode());
			jsonObject.put("Job_Client_Name", assignedJobs.get(i).getJobClientName());
			jsonObject.put("Job_Details", assignedJobs.get(i).getJobDetails());
			jsonObject.put("Job_Comments", assignedJobs.get(i).getJobComments());
			jsonObject.put("Job_Type", assignedJobs.get(i).getJobType());
			jsonObject.put("idMac_Applicants", assignedJobs.get(i).getIdMacApplicants());
			jsonObject.put("Name", assignedJobs.get(i).getName());
			jsonObject.put("Surname", assignedJobs.get(i).getSurname());
			jsonObject.put("Stage_In_Process", assignedJobs.get(i).getStageInProcess());
			jsonObject.put("Stage_Status", assignedJobs.get(i).getStageStatus());
			jsonObject.put("Mac_Labour_Interview_Comments",StringEscapeUtils.escapeJava( assignedJobs.get(i).getMacLabourInterviewComments()));
			jsonObject.put("Mac_Lab_Interview_Complete", assignedJobs.get(i).getMacLabInterviewComplete());
			jsonObject.put("Practical_Drivers_Test_Complete", assignedJobs.get(i).getPracticalDriversTestComplete());
			jsonObject.put("Practical_Drivers_Test_Comments", StringEscapeUtils.escapeJava(assignedJobs.get(i).getPracticalDriversTestComments()));
			jsonObject.put("Client_Interview_Complete", assignedJobs.get(i).getClientInterviewComplete());
			jsonObject.put("Client_Interview_Comments", StringEscapeUtils.escapeJava(assignedJobs.get(i).getClientInterviewComments()));
			jsonObject.put("Reference_Checks_Complete", assignedJobs.get(i).getReferenceChecksComplete());
			jsonObject.put("Reference_Checks_Comments", StringEscapeUtils.escapeJava(assignedJobs.get(i).getReferenceChecksComments()));
			
			jsonArray.put(jsonObject);
		}

		return jsonArray.toString();
	}
	
	@SuppressWarnings("deprecation")
	@Path("/ReadAllAssignedJobsByLastJob_Id")
	@GET
	@Produces("text/plain")
	public String GetAllAssignedJobsByLastJobId() throws Exception
	{
	    
		AssignedJobApplicantDAO assignedJobApplicantDAO  = new AssignedJobApplicantDAO();
		
		JobDAO jobDao = new JobDAO();
		int jobId = jobDao.getLastJobId();
		
		
		List<AssignedJobApplicantList> assignedJobs = assignedJobApplicantDAO.ReadAllAssignedJobsInfoByJob_Id(jobId);
		
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < assignedJobs.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("idAssignedJobApplicantList", assignedJobs.get(i).getIdAssignedJobApplicantList());
			jsonObject.put("Job_Id", assignedJobs.get(i).getJobId());
			jsonObject.put("Job_Name", assignedJobs.get(i).getJobName());
			jsonObject.put("Job_Code", assignedJobs.get(i).getJobCode());
			jsonObject.put("Job_Client_Name", assignedJobs.get(i).getJobClientName());
			jsonObject.put("Job_Details", assignedJobs.get(i).getJobDetails());
			jsonObject.put("Job_Comments", assignedJobs.get(i).getJobComments());
			jsonObject.put("Job_Type", assignedJobs.get(i).getJobType());
			jsonObject.put("idMac_Applicants", assignedJobs.get(i).getIdMacApplicants());
			jsonObject.put("Name", assignedJobs.get(i).getName());
			jsonObject.put("Surname", assignedJobs.get(i).getSurname());
			jsonObject.put("Stage_In_Process", assignedJobs.get(i).getStageInProcess());
			jsonObject.put("Stage_Status", assignedJobs.get(i).getStageStatus());
			jsonObject.put("Mac_Labour_Interview_Comments",StringEscapeUtils.escapeJava( assignedJobs.get(i).getMacLabourInterviewComments()));
			jsonObject.put("Mac_Lab_Interview_Complete", assignedJobs.get(i).getMacLabInterviewComplete());
			jsonObject.put("Practical_Drivers_Test_Complete", assignedJobs.get(i).getPracticalDriversTestComplete());
			jsonObject.put("Practical_Drivers_Test_Comments", StringEscapeUtils.escapeJava(assignedJobs.get(i).getPracticalDriversTestComments()));
			jsonObject.put("Client_Interview_Complete", assignedJobs.get(i).getClientInterviewComplete());
			jsonObject.put("Client_Interview_Comments", StringEscapeUtils.escapeJava(assignedJobs.get(i).getClientInterviewComments()));
			jsonObject.put("Reference_Checks_Complete", assignedJobs.get(i).getReferenceChecksComplete());
			jsonObject.put("Reference_Checks_Comments", StringEscapeUtils.escapeJava(assignedJobs.get(i).getReferenceChecksComments()));
			
			jsonArray.put(jsonObject);
		}

		return jsonArray.toString();
	}
	
	@SuppressWarnings("deprecation")
	@Path("/ReadAllAssignedJobsByIDNumber/{Id_Number}")
	@GET
	@Produces("text/plain")
	public String GetAllAssignedJobsIdNumber(@PathParam("Id_Number") String idNumber) throws Exception
	{
	    
		AssignedJobApplicantDAO assignedJobApplicantDAO  = new AssignedJobApplicantDAO();
		List<AssignedJobApplicantList> assignedJobs = assignedJobApplicantDAO.ReadAllAssignedJobsInfobyIdNumber(idNumber);
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < assignedJobs.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("idAssignedJobApplicantList", assignedJobs.get(i).getIdAssignedJobApplicantList());
			jsonObject.put("Job_Id", assignedJobs.get(i).getJobId());
			jsonObject.put("Job_Name", assignedJobs.get(i).getJobName());
			jsonObject.put("Job_Code", assignedJobs.get(i).getJobCode());
			jsonObject.put("Job_Client_Name", assignedJobs.get(i).getJobClientName());
			jsonObject.put("Job_Details", assignedJobs.get(i).getJobDetails());
			jsonObject.put("Job_Comments", assignedJobs.get(i).getJobComments());
			jsonObject.put("Job_Type", assignedJobs.get(i).getJobType());
			jsonObject.put("idMac_Applicants", assignedJobs.get(i).getIdMacApplicants());
			jsonObject.put("Name", assignedJobs.get(i).getName());
			jsonObject.put("Surname", assignedJobs.get(i).getSurname());
			jsonObject.put("Stage_In_Process", assignedJobs.get(i).getStageInProcess());
			jsonObject.put("Stage_Status", assignedJobs.get(i).getStageStatus());
			jsonObject.put("Mac_Labour_Interview_Comments", StringEscapeUtils.escapeJava(assignedJobs.get(i).getMacLabourInterviewComments()));
			jsonObject.put("Mac_Lab_Interview_Complete", assignedJobs.get(i).getMacLabInterviewComplete());
			jsonObject.put("Practical_Drivers_Test_Complete", assignedJobs.get(i).getPracticalDriversTestComplete());
			jsonObject.put("Practical_Drivers_Test_Comments", StringEscapeUtils.escapeJava(assignedJobs.get(i).getPracticalDriversTestComments()));
			jsonObject.put("Client_Interview_Complete", assignedJobs.get(i).getClientInterviewComplete());
			jsonObject.put("Client_Interview_Comments", StringEscapeUtils.escapeJava(assignedJobs.get(i).getClientInterviewComments()));
			jsonObject.put("Reference_Checks_Complete", assignedJobs.get(i).getReferenceChecksComplete());
			jsonObject.put("Reference_Checks_Comments", StringEscapeUtils.escapeJava(assignedJobs.get(i).getReferenceChecksComments()));
			
			jsonArray.put(jsonObject);
		}

		return jsonArray.toString();
	}
	
	
	
}
