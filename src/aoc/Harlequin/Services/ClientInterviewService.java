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

import aoc.Harlequin.DAOs.AssignedJobApplicantDAO;
import aoc.Harlequin.DAOs.ClientDAO;
import aoc.Harlequin.DAOs.ClientInterviewDAO;
import aoc.Harlequin.DAOs.JobDAO;
import aoc.Harlequin.DAOs.MacApplicantDAO;
import aoc.Harlequin.DAOs.MacInterviewDAO;
import aoc.Harlequin.DAOs.SystemUserDAO;
import aoc.Harlequin.OBJs.ClientInterviews;
import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.MacLabourInterView;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemJob;
import aoc.Harlequin.OBJs.SystemUser;




@Path("ClientInterview")
public class ClientInterviewService {
	
	@Path("/GetInterviewInfo")
	@GET
	@Produces("text/plain")
	public String GET( ) throws Exception
	{
		
		ClientInterviewDAO Object  = new ClientInterviewDAO();
		ClientInterviews Interview = Object.getInterviewInfoById(1);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("idClientInterviews", Interview.getIdClientInterviews());
		jsonObject.put("idMac_Applicants", Interview.getIdMacApplicants());
		jsonObject.put("Client_Name", Interview.getClientName());
		jsonObject.put("Applicant_Name", Interview.getApplicantName());
		jsonObject.put("Applicant_Surname", Interview.getApplicantSurname());

		jsonObject.put("Interview_questions_Passed", Interview.getInterviewQuestionsPassed());
		jsonObject.put("Applicant_Presentable", Interview.getApplicantPresentable());

		jsonObject.put("Applicant_Attitude", Interview.getApplicantAttitude());
		jsonObject.put("Interview_Comments", Interview.getInterviewComments());
		jsonObject.put("Client_Interview_Complete", Interview.getClientInterviewComplete());
		jsonObject.put("Last_Used_Date", Interview.getLastUsedDate());
		
	
	
		
		System.out.println(jsonObject.toString());
	    
		return jsonObject.toString();
	}
	
	@Path("/GetAllInterviews")
	@GET
	@Produces("text/plain")
	public String GETInterviews( ) throws Exception
	{
		
		ClientInterviewDAO Object  = new ClientInterviewDAO();
		
		List<ClientInterviews> Interviews = Object.ReadAllInterviews();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Interviews.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
		

			
			jsonObject.put("idClientInterviews", Interviews.get(i).getIdClientInterviews());
			jsonObject.put("idMac_Applicants", Interviews.get(i).getIdMacApplicants());
			jsonObject.put("Client_Name", Interviews.get(i).getClientName());
			jsonObject.put("Applicant_Name", Interviews.get(i).getApplicantName());
			jsonObject.put("Applicant_Surname", Interviews.get(i).getApplicantSurname());

			jsonObject.put("Interview_questions_Passed", Interviews.get(i).getInterviewQuestionsPassed());
			jsonObject.put("Applicant_Presentable", Interviews.get(i).getApplicantPresentable());

			jsonObject.put("Applicant_Attitude", Interviews.get(i).getApplicantAttitude());
			jsonObject.put("Interview_Comments", Interviews.get(i).getInterviewComments());
			jsonObject.put("Client_Interview_Complete", Interviews.get(i).getClientInterviewComplete());
			jsonObject.put("Last_Used_Date", Interviews.get(i).getLastUsedDate());
			
			JsonArray.put(jsonObject);
		}

		
		System.out.println(JsonArray.toString());
	    
		return JsonArray.toString();
	}
	
	
	
	
	@Path("/GetInterviewInfo/{Client_Name}")
	@GET
	@Produces("text/plain")
	public String GET1(@PathParam("Client_Name") String Client_Name ) throws Exception
	{
		
		
		
		ClientInterviewDAO Object  = new ClientInterviewDAO();
		
		List<ClientInterviews> Interview = Object.GetClientInfoByName(Client_Name);
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Interview.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idClientInterviews", Interview.get(i).getIdClientInterviews());
			jsonObject.put("idMac_Applicants", Interview.get(i).getIdMacApplicants());
			jsonObject.put("Client_Name", Interview.get(i).getClientName());
			jsonObject.put("Applicant_Name", Interview.get(i).getApplicantName());
			jsonObject.put("Applicant_Surname", Interview.get(i).getApplicantSurname());

			jsonObject.put("Interview_questions_Passed", Interview.get(i).getInterviewQuestionsPassed());
			jsonObject.put("Applicant_Presentable", Interview.get(i).getApplicantPresentable());

			jsonObject.put("Applicant_Attitude", Interview.get(i).getApplicantAttitude());
			jsonObject.put("Interview_Comments", Interview.get(i).getInterviewComments());
			jsonObject.put("Client_Interview_Complete", Interview.get(i).getClientInterviewComplete());
			jsonObject.put("Last_Used_Date", Interview.get(i).getLastUsedDate());
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
		
		
		
		return JsonArray.toString();
	}
	
	
	
	@Path("/GetInterview/{Id_Number}/{idMac_Applicants}/{Job_Name}")
	@GET
	@Produces("text/plain")
	public String GET1(@PathParam("Id_Number") String Id_Number,@PathParam("idMac_Applicants") String idMac_Applicants, @PathParam("Job_Name") String Job_Name ) throws Exception
	{
		
		
		
		System.out.println("Hello world"+Id_Number+","+idMac_Applicants+","+Job_Name);
		
		ClientInterviewDAO Object  = new ClientInterviewDAO();
		
		List<ClientInterviews> Interview = Object.GetInterviewByInfo(Id_Number, idMac_Applicants,Job_Name);
		
		
			JSONObject jsonObject = new JSONObject();
			
			if(Interview.size()>0)
			{
				System.out.println("Hellowaorld");
				jsonObject.put("Interview_questions_Passed", Interview.get(0).getInterviewQuestionsPassed());
				jsonObject.put("Applicant_Presentable", Interview.get(0).getApplicantPresentable());
				jsonObject.put("Applicant_Attitude", Interview.get(0).getApplicantAttitude());
				jsonObject.put("Interview_Comments", Interview.get(0).getInterviewComments());
				jsonObject.put("Client_Interview_Complete", Interview.get(0).getClientInterviewComplete());
				jsonObject.put("Last_Used_Date", Interview.get(0).getLastUsedDate());
				
			}
			
			
		
		
		
		
		
		
		System.out.println(jsonObject.toString());
		
		
		
		return jsonObject.toString();
	}
	
	
	@Path("/SaveInterviewInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		
		JSONObject r = new JSONObject(jsonTextObject);	
	
		ClientInterviewDAO Object  = new ClientInterviewDAO();
		
		
		
		Object.AddInterviewInformation(r.getString("Id_Number"),r.getString("Job_Name"),r.getString("idMac_Applicants"), r.getString("Client_Name"), r.getString("Applicant_Name"), r.getString("Applicant_Surname"), r.getString("Interview_questions_Passed"), r.getString("Applicant_Presentable"), r.getString("Applicant_Attitude"), r.getString("Interview_Comments"), r.getString("Client_Interview_Complete"));
		
		AssignedJobApplicantDAO assigned_job = new AssignedJobApplicantDAO();
		
		MacApplicantDAO Applicant = new MacApplicantDAO();
		
		List<MacApplicants> x = Applicant.GetApplicantsByApplicantId(r.getString("Id_Number"));
		if(x.size()>0)
		{
			
			if(r.getString("Client_Interview_Complete").equals("Yes"))
			{
				x.get(0).setClientInterviewComplete(r.getString("Client_Interview_Complete"));
				x.get(0).setStageInTheProcess("Reference Checks");
				x.get(0).setLastUsedDate(dateFormat.format(date));
				assigned_job.UpdateAssignedJobStatusClientrInterview(r.getString("Id_Number"), r.getString("Job_Name"), "Reference Checks", "beginning",r.getString("Client_Interview_Complete"),((r.getString("Interview_Comments").equals("")) ? "N/A" : r.getString("Interview_Comments")));
				
				
			}
			else if(r.getString("Client_Interview_Complete").equals("No"))
			{
				x.get(0).setClientInterviewComplete(r.getString("Client_Interview_Complete"));
				x.get(0).setStageInTheProcess("Client Interview");
				x.get(0).setLastUsedDate(dateFormat.format(date));
				assigned_job.UpdateAssignedJobStatusClientrInterview(r.getString("Id_Number"), r.getString("Job_Name"), "Client Interview", "pending",r.getString("Client_Interview_Complete"),((r.getString("Interview_Comments").equals("")) ? "N/A" : r.getString("Interview_Comments")));
				
			}
			
			Applicant.update(x.get(0));
		}
		
		
		return "Sucessful";	
		
			
	}
	
	
	

}
