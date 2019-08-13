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
import aoc.Harlequin.DAOs.AssignedJobApplicantDAO;
import aoc.Harlequin.DAOs.ClientInterviewDAO;
import aoc.Harlequin.DAOs.MacApplicantDAO;
import aoc.Harlequin.OBJs.ClientInterviews;
import aoc.Harlequin.OBJs.MacApplicants;





@SuppressWarnings("deprecation")
@Path("ClientInterview")
public class ClientInterviewService {
	
	@Path("/GetInterviewInfo")
	@GET
	@Produces("text/plain")
	public String GET( ) throws Exception
	{
		
		ClientInterviewDAO clientInterviewDao  = new ClientInterviewDAO();
		ClientInterviews clientInterview = clientInterviewDao.getInterviewInfoById(1);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("idClientInterviews", clientInterview.getIdClientInterviews());
		jsonObject.put("idMac_Applicants", clientInterview.getIdMacApplicants());
		jsonObject.put("Client_Name", clientInterview.getClientName());
		jsonObject.put("Applicant_Name", clientInterview.getApplicantName());
		jsonObject.put("Applicant_Surname", clientInterview.getApplicantSurname());
		jsonObject.put("Interview_questions_Passed", clientInterview.getInterviewQuestionsPassed());
		jsonObject.put("Applicant_Presentable", clientInterview.getApplicantPresentable());
		jsonObject.put("Applicant_Attitude", clientInterview.getApplicantAttitude());
		jsonObject.put("Interview_Comments", StringEscapeUtils.escapeJava(clientInterview.getInterviewComments()));
		jsonObject.put("Client_Interview_Complete", clientInterview.getClientInterviewComplete());
		jsonObject.put("Last_Used_Date", clientInterview.getLastUsedDate());
		jsonObject.put("Client_Interview_Passed", clientInterview.getClientInterviewPassed());
	
	    
		return jsonObject.toString();
	}
	
	@Path("/GetAllInterviews")
	@GET
	@Produces("text/plain")
	public String GETInterviews( ) throws Exception
	{
		
		ClientInterviewDAO clientInterviewDao  = new ClientInterviewDAO();	
		List<ClientInterviews> clientInterviews = clientInterviewDao.ReadAllInterviews();
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < clientInterviews.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
		
			jsonObject.put("idClientInterviews", clientInterviews.get(i).getIdClientInterviews());
			jsonObject.put("idMac_Applicants", clientInterviews.get(i).getIdMacApplicants());
			jsonObject.put("Client_Name", clientInterviews.get(i).getClientName());
			jsonObject.put("Applicant_Name", clientInterviews.get(i).getApplicantName());
			jsonObject.put("Applicant_Surname", clientInterviews.get(i).getApplicantSurname());
			jsonObject.put("Interview_questions_Passed", clientInterviews.get(i).getInterviewQuestionsPassed());
			jsonObject.put("Applicant_Presentable", clientInterviews.get(i).getApplicantPresentable());
			jsonObject.put("Applicant_Attitude", clientInterviews.get(i).getApplicantAttitude());
			jsonObject.put("Interview_Comments", StringEscapeUtils.escapeJava(clientInterviews.get(i).getInterviewComments()));
			jsonObject.put("Client_Interview_Complete", clientInterviews.get(i).getClientInterviewComplete());
			jsonObject.put("Last_Used_Date", clientInterviews.get(i).getLastUsedDate());
			jsonObject.put("Client_Interview_Passed", clientInterviews.get(i).getClientInterviewPassed());
			
			JsonArray.put(jsonObject);
		}

		return JsonArray.toString();
	}
	
	
	
	
	@Path("/GetInterviewInfo/{client_Name}")
	@GET
	@Produces("text/plain")
	public String GET1(@PathParam("client_Name") String client_Name ) throws Exception
	{

		ClientInterviewDAO clientInterviewDao  = new ClientInterviewDAO();
		List<ClientInterviews> clientInterview = clientInterviewDao.GetClientInfoByName(client_Name);
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < clientInterview.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idClientInterviews", clientInterview.get(i).getIdClientInterviews());
			jsonObject.put("idMac_Applicants", clientInterview.get(i).getIdMacApplicants());
			jsonObject.put("Client_Name", clientInterview.get(i).getClientName());
			jsonObject.put("Applicant_Name", clientInterview.get(i).getApplicantName());
			jsonObject.put("Applicant_Surname", clientInterview.get(i).getApplicantSurname());
			jsonObject.put("Interview_questions_Passed", clientInterview.get(i).getInterviewQuestionsPassed());
			jsonObject.put("Applicant_Presentable", clientInterview.get(i).getApplicantPresentable());
			jsonObject.put("Applicant_Attitude", clientInterview.get(i).getApplicantAttitude());
			jsonObject.put("Interview_Comments", StringEscapeUtils.escapeJava(clientInterview.get(i).getInterviewComments()));
			jsonObject.put("Client_Interview_Complete", clientInterview.get(i).getClientInterviewComplete());
			jsonObject.put("Last_Used_Date", clientInterview.get(i).getLastUsedDate());
			jsonObject.put("Client_Interview_Passed", clientInterview.get(i).getClientInterviewPassed());

			JsonArray.put(jsonObject);
		}
		

		return JsonArray.toString();
	}
	
	
	@Path("/GetInterviewInfoByID/{id_Number}")
	@GET
	@Produces("text/plain")
	public String GET5(@PathParam("id_Number") String id_Number ) throws Exception
	{
		ClientInterviewDAO clientInterviewDao  = new ClientInterviewDAO();
		List<ClientInterviews> clientInterviews = clientInterviewDao.GetClientInfoByIdNumber(id_Number);		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < clientInterviews.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idClientInterviews", clientInterviews.get(i).getIdClientInterviews());
			jsonObject.put("Id_Number", clientInterviews.get(i).getIdNumber());
			jsonObject.put("idMac_Applicants", clientInterviews.get(i).getIdMacApplicants());
			jsonObject.put("Client_Name", clientInterviews.get(i).getClientName());
			jsonObject.put("Applicant_Name", clientInterviews.get(i).getApplicantName());
			jsonObject.put("Applicant_Surname", clientInterviews.get(i).getApplicantSurname());
			jsonObject.put("Interview_questions_Passed", clientInterviews.get(i).getInterviewQuestionsPassed());
			jsonObject.put("Applicant_Presentable", clientInterviews.get(i).getApplicantPresentable());
			jsonObject.put("Applicant_Attitude", clientInterviews.get(i).getApplicantAttitude());
			jsonObject.put("Interview_Comments", StringEscapeUtils.escapeJava(clientInterviews.get(i).getInterviewComments()));
			jsonObject.put("Client_Interview_Complete", clientInterviews.get(i).getClientInterviewComplete());
			jsonObject.put("Last_Used_Date", clientInterviews.get(i).getLastUsedDate());
			jsonObject.put("Client_Interview_Passed", clientInterviews.get(i).getClientInterviewPassed());
			jsonObject.put("Job_Name", clientInterviews.get(i).getJobName());
			
			JsonArray.put(jsonObject);
		}
		
		return JsonArray.toString();
	}
	
	
	
	@Path("/GetInterview/{id_Number}/{idMac_Applicants}/{job_Name}")
	@GET
	@Produces("text/plain")
	public String GET1(@PathParam("id_Number") String id_Number,@PathParam("idMac_Applicants") String idMac_Applicants, @PathParam("job_Name") String job_Name ) throws Exception
	{
		
		ClientInterviewDAO clientInterviewDao  = new ClientInterviewDAO();
		List<ClientInterviews> clientInterviews = clientInterviewDao.GetInterviewByInfo(id_Number, idMac_Applicants,job_Name);
		
		
			JSONObject jsonObject = new JSONObject();
			
			if(clientInterviews.size()>0)
			{
				System.out.println("Hellowaorld");
				jsonObject.put("Interview_questions_Passed", clientInterviews.get(0).getInterviewQuestionsPassed());
				jsonObject.put("Applicant_Presentable", clientInterviews.get(0).getApplicantPresentable());
				jsonObject.put("Applicant_Attitude", clientInterviews.get(0).getApplicantAttitude());
				jsonObject.put("Interview_Comments", StringEscapeUtils.escapeJava(clientInterviews.get(0).getInterviewComments()));
				jsonObject.put("Client_Interview_Complete", clientInterviews.get(0).getClientInterviewComplete());
				jsonObject.put("Last_Used_Date", clientInterviews.get(0).getLastUsedDate());
				jsonObject.put("Client_Interview_Passed", clientInterviews.get(0).getClientInterviewPassed());
			}
			
		
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
		JSONObject jsonObject = new JSONObject(jsonTextObject);	
		ClientInterviewDAO clientInterviewDao  = new ClientInterviewDAO();
		
		clientInterviewDao.AddInterviewInformation(jsonObject.getString("Id_Number"),jsonObject.getString("Job_Name"),jsonObject.getString("idMac_Applicants"), jsonObject.getString("Client_Name"), jsonObject.getString("Applicant_Name"), jsonObject.getString("Applicant_Surname"), jsonObject.getString("Interview_questions_Passed"), jsonObject.getString("Applicant_Presentable"), jsonObject.getString("Applicant_Attitude"), jsonObject.getString("Interview_Comments"), jsonObject.getString("Client_Interview_Complete"), jsonObject.getString("Client_Interview_Passed"));
		
		AssignedJobApplicantDAO assignedJobDao = new AssignedJobApplicantDAO();
		MacApplicantDAO macApplicantDao = new MacApplicantDAO();
		
		List<MacApplicants> applicants = macApplicantDao.GetApplicantsByApplicantId(jsonObject.getString("Id_Number"));
		if(applicants.size()>0)
		{
			
			if(jsonObject.getString("Client_Interview_Passed").equals("Yes"))
			{
				applicants.get(0).setClientInterviewComplete(jsonObject.getString("Client_Interview_Complete"));
				applicants.get(0).setStageInTheProcess("Reference Checks");
				applicants.get(0).setLastUsedDate(dateFormat.format(date));
				assignedJobDao.UpdateAssignedJobStatusClientrInterview(jsonObject.getString("Id_Number"), jsonObject.getString("Job_Name"), "Reference Checks", "beginning",jsonObject.getString("Client_Interview_Complete"),((jsonObject.getString("Interview_Comments").equals("")) ? "N/A" : jsonObject.getString("Interview_Comments")),jsonObject.getString("Client_Interview_Passed"));
				
				
			}
			else if(jsonObject.getString("Client_Interview_Passed").equals("No"))
			{
				applicants.get(0).setClientInterviewComplete(jsonObject.getString("Client_Interview_Complete"));
				applicants.get(0).setStageInTheProcess("Client Interview");
				applicants.get(0).setLastUsedDate(dateFormat.format(date));
				assignedJobDao.UpdateAssignedJobStatusClientrInterview(jsonObject.getString("Id_Number"), jsonObject.getString("Job_Name"), "Client Interview", "pending",jsonObject.getString("Client_Interview_Complete"),((jsonObject.getString("Interview_Comments").equals("")) ? "N/A" : jsonObject.getString("Interview_Comments")),jsonObject.getString("Client_Interview_Passed"));
				
			}
			
			macApplicantDao.update(applicants.get(0));
		}
		
		
		return "Sucessful";	
		
			
	}
	
	
	

}
