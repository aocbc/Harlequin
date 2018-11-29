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
import aoc.Harlequin.DAOs.MacInterviewDAO;
import aoc.Harlequin.OBJs.MacLabourInterView;
import aoc.Harlequin.OBJs.SystemJob;

@SuppressWarnings("deprecation")
@Path("MacLabourInterview")
public class MacLabourInterviewService {
	
	@Path("/GetInterviewInfo")
	@GET
	@Produces("text/plain")
	public String GET( ) throws Exception
	{
		
		MacInterviewDAO Object  = new MacInterviewDAO();
		MacLabourInterView Interview = Object.getInterviewInfoById(1);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("idMacLabour_InterView", Interview.getIdMacLabourInterView());
		jsonObject.put("idMac_Applicants", Interview.getIdMacApplicants());
		jsonObject.put("Name", Interview.getName());
		jsonObject.put("Surname", Interview.getSurname());
		jsonObject.put("Id_Number", Interview.getIdNumber());		
		jsonObject.put("Client_Name", Interview.getClientName());
		jsonObject.put("Id_Verified", Interview.getIdVerified());
		jsonObject.put("Work_History_Verified", Interview.getWorkHistoryVerified());
		jsonObject.put("Job_Name", Interview.getJobName());
		jsonObject.put("Drivers_License_Verified", Interview.getDriversLicenseVerified());
		jsonObject.put("SAP_Check", Interview.getSapCheck());
		jsonObject.put("Criminal_Record", Interview.getCriminalRecord());
		jsonObject.put("Criminal_Record_Comments", StringEscapeUtils.escapeJava(Interview.getCriminalRecordComments()));
		jsonObject.put("Union_Member", Interview.getUnionMember());		
		jsonObject.put("Union_Name", Interview.getUnionName());
		jsonObject.put("Applicant_Passed_Interview", Interview.getApplicantPassedInterview());
		jsonObject.put("Applicant_Presentable", Interview.getApplicantPresentable());
		jsonObject.put("Applicant_Atttitude", Interview.getApplicantAtttitude());
		jsonObject.put("Interview_comments", StringEscapeUtils.escapeJava(Interview.getInterviewComments()));
		jsonObject.put("Formal_Interview_Complete", Interview.getFormalInterviewComplete());
		
		jsonObject.put("Last_Used_Date", Interview.getLastUsedDate());
		
		System.out.println(jsonObject.toString());
	    
		return jsonObject.toString();
	}
	
	@Path("/GetAllInterviews")
	@GET
	@Produces("text/plain")
	public String GETInterviews( ) throws Exception
	{
		
		MacInterviewDAO Object  = new MacInterviewDAO();
		
		List<MacLabourInterView> Interviews = Object.ReadAllInterviews();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Interviews.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
		

			jsonObject.put("idMacLabour_InterView", Interviews.get(i).getIdMacLabourInterView());
			jsonObject.put("idMac_Applicants", Interviews.get(i).getIdMacApplicants());
			jsonObject.put("Name", Interviews.get(i).getName());
			jsonObject.put("Surname", Interviews.get(i).getSurname());
			jsonObject.put("Id_Number", Interviews.get(i).getIdNumber());		
			jsonObject.put("Client_Name", Interviews.get(i).getClientName());
			jsonObject.put("Id_Verified", Interviews.get(i).getIdVerified());
			jsonObject.put("Work_History_Verified", Interviews.get(i).getWorkHistoryVerified());
			jsonObject.put("Job_Name", Interviews.get(i).getJobName());
			jsonObject.put("Drivers_License_Verified", Interviews.get(i).getDriversLicenseVerified());
			jsonObject.put("SAP_Check", Interviews.get(i).getSapCheck());
			jsonObject.put("Criminal_Record", Interviews.get(i).getCriminalRecord());
			jsonObject.put("Criminal_Record_Comments", StringEscapeUtils.escapeJava(Interviews.get(i).getCriminalRecordComments()));
			jsonObject.put("Union_Member", Interviews.get(i).getUnionMember());		
			jsonObject.put("Union_Name", Interviews.get(i).getUnionName());
			jsonObject.put("Applicant_Passed_Interview", Interviews.get(i).getApplicantPassedInterview());
			jsonObject.put("Applicant_Presentable", Interviews.get(i).getApplicantPresentable());
			jsonObject.put("Applicant_Atttitude", Interviews.get(i).getApplicantAtttitude());
			jsonObject.put("Interview_comments", StringEscapeUtils.escapeJava(Interviews.get(i).getInterviewComments()));
			jsonObject.put("Formal_Interview_Complete", Interviews.get(i).getFormalInterviewComplete());
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
		
		
		
		MacInterviewDAO Object  = new MacInterviewDAO();
		
		List<MacLabourInterView> Interview = Object.GetClientInfoByName(Client_Name);
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Interview.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMacLabour_InterView", Interview.get(i).getIdMacLabourInterView());
			jsonObject.put("idMac_Applicants", Interview.get(i).getIdMacApplicants());
			jsonObject.put("Name", Interview.get(i).getName());
			jsonObject.put("Surname", Interview.get(i).getSurname());
			jsonObject.put("Id_Number", Interview.get(i).getIdNumber());		
			jsonObject.put("Client_Name", Interview.get(i).getClientName());
			jsonObject.put("Id_Verified", Interview.get(i).getIdVerified());
			jsonObject.put("Work_History_Verified", Interview.get(i).getWorkHistoryVerified());
			jsonObject.put("Job_Name", Interview.get(i).getJobName());
			jsonObject.put("Drivers_License_Verified", Interview.get(i).getDriversLicenseVerified());
			jsonObject.put("SAP_Check", Interview.get(i).getSapCheck());
			jsonObject.put("Criminal_Record", Interview.get(i).getCriminalRecord());
			jsonObject.put("Criminal_Record_Comments", StringEscapeUtils.escapeJava(Interview.get(i).getCriminalRecordComments()));
			jsonObject.put("Union_Member", Interview.get(i).getUnionMember());		
			jsonObject.put("Union_Name", Interview.get(i).getUnionName());
			jsonObject.put("Applicant_Passed_Interview", Interview.get(i).getApplicantPassedInterview());
			jsonObject.put("Applicant_Presentable", Interview.get(i).getApplicantPresentable());
			jsonObject.put("Applicant_Atttitude", Interview.get(i).getApplicantAtttitude());
			jsonObject.put("Interview_comments", StringEscapeUtils.escapeJava(Interview.get(i).getInterviewComments()));
			jsonObject.put("Formal_Interview_Complete", Interview.get(i).getFormalInterviewComplete());
			jsonObject.put("Last_Used_Date", Interview.get(i).getLastUsedDate());
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
		
		
		
		return JsonArray.toString();
	}
	
	
	@Path("/GetInterviewInfobyIdnumber/{Id_Number}")
	@GET
	@Produces("text/plain")
	public String GET4(@PathParam("Id_Number") String Id_Number) throws Exception
	{
		
		
		MacInterviewDAO Object  = new MacInterviewDAO();
		
		List<MacLabourInterView> Interview = Object.GetInterviewByInfoIdNumber(Id_Number);
		

		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Interview.size();i++)
		{
				JSONObject jsonObject = new JSONObject();
			
			
			
				
				jsonObject.put("idMacLabour_InterView", Interview.get(i).getIdMacLabourInterView());
				jsonObject.put("idMac_Applicants", Interview.get(i).getIdMacApplicants());
				jsonObject.put("Name", Interview.get(i).getName());
				jsonObject.put("Surname", Interview.get(i).getSurname());
				jsonObject.put("Id_Number", Interview.get(i).getIdNumber());		
				jsonObject.put("Client_Name", Interview.get(i).getClientName());
				jsonObject.put("Id_Verified", Interview.get(i).getIdVerified());
				jsonObject.put("Work_History_Verified", Interview.get(i).getWorkHistoryVerified());
				jsonObject.put("Job_Name", Interview.get(i).getJobName());
				jsonObject.put("Drivers_License_Verified", Interview.get(i).getDriversLicenseVerified());
				jsonObject.put("SAP_Check", Interview.get(i).getSapCheck());
				jsonObject.put("Criminal_Record", Interview.get(i).getCriminalRecord());
				jsonObject.put("Criminal_Record_Comments", StringEscapeUtils.escapeJava(Interview.get(i).getCriminalRecordComments()));
				jsonObject.put("Union_Member", Interview.get(i).getUnionMember());		
				jsonObject.put("Union_Name", Interview.get(i).getUnionName());
				jsonObject.put("Applicant_Passed_Interview", Interview.get(i).getApplicantPassedInterview());
				jsonObject.put("Applicant_Presentable", Interview.get(i).getApplicantPresentable());
				jsonObject.put("Applicant_Atttitude", Interview.get(i).getApplicantAtttitude());
				jsonObject.put("Interview_comments", StringEscapeUtils.escapeJava(Interview.get(i).getInterviewComments()));
				jsonObject.put("Formal_Interview_Complete", Interview.get(i).getFormalInterviewComplete());
				jsonObject.put("Last_Used_Date", Interview.get(i).getLastUsedDate());
				
				JsonArray.put(jsonObject);
			}
			
			
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
		
		
		
		return JsonArray.toString();
	}
	
	
	@Path("/GetInterviewInfo/{Id_Number}/{idMac_Applicants}/{Job_Name}")
	@GET
	@Produces("text/plain")
	public String GET3(String Surname,@PathParam("Id_Number") String Id_Number, @PathParam("idMac_Applicants") String idMac_Applicants , @PathParam("Job_Name") String Job_Name  ) throws Exception
	{
		
		System.out.println("Hello world"+Id_Number+","+idMac_Applicants+","+Job_Name);
		
		MacInterviewDAO Object  = new MacInterviewDAO();
		
		List<MacLabourInterView> Interview = Object.GetInterviewByInfo(Id_Number, idMac_Applicants,Job_Name);
		
		
			JSONObject jsonObject = new JSONObject();
			
			if(Interview.size()>0)
			{
				System.out.println("Hellowaorld");
				jsonObject.put("idMacLabour_InterView", Interview.get(0).getIdMacLabourInterView());
				jsonObject.put("idMac_Applicants", Interview.get(0).getIdMacApplicants());
				jsonObject.put("Name", Interview.get(0).getName());
				jsonObject.put("Surname", Interview.get(0).getSurname());
				jsonObject.put("Id_Number", Interview.get(0).getIdNumber());		
				jsonObject.put("Client_Name", Interview.get(0).getClientName());
				jsonObject.put("Id_Verified", Interview.get(0).getIdVerified());
				jsonObject.put("Work_History_Verified", Interview.get(0).getWorkHistoryVerified());
				jsonObject.put("Job_Name", Interview.get(0).getJobName());
				jsonObject.put("Drivers_License_Verified", Interview.get(0).getDriversLicenseVerified());
				jsonObject.put("SAP_Check", Interview.get(0).getSapCheck());
				jsonObject.put("Criminal_Record", Interview.get(0).getCriminalRecord());
				jsonObject.put("Criminal_Record_Comments", StringEscapeUtils.escapeJava(Interview.get(0).getCriminalRecordComments()));
				jsonObject.put("Union_Member", Interview.get(0).getUnionMember());		
				jsonObject.put("Union_Name", Interview.get(0).getUnionName());
				jsonObject.put("Applicant_Passed_Interview", Interview.get(0).getApplicantPassedInterview());
				jsonObject.put("Applicant_Presentable", Interview.get(0).getApplicantPresentable());
				jsonObject.put("Applicant_Atttitude", Interview.get(0).getApplicantAtttitude());
				jsonObject.put("Interview_comments", StringEscapeUtils.escapeJava(Interview.get(0).getInterviewComments()));
				jsonObject.put("Formal_Interview_Complete", Interview.get(0).getFormalInterviewComplete());
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
		
		JobDAO Job = new JobDAO();
			
		System.out.println(jsonTextObject);
		JSONObject r = new JSONObject(jsonTextObject);	
	
		List<SystemJob> Job_For_Interview = Job.GetClientNameByJobName(r.getString("Job_Name"));
		String Client_Name =  Job_For_Interview.get(0).getJobClientName();
		
		MacInterviewDAO Object  = new MacInterviewDAO();
		
		Object.AddInterviewInformation(r.getString("idMac_Applicants"), r.getString("Name"), r.getString("Surname"), r.getString("Id_Number"), Client_Name, r.getString("Id_Verified"), r.getString("Work_History_Verified"), r.getString("Job_Name"), r.getString("Drivers_License_Verified"), r.getString("SAP_Check"), r.getString("Criminal_Record"), r.getString("Criminal_Record_Comments"), r.getString("Union_Member"), r.getString("Union_Name"), r.getString("Applicant_Passed_Interview"), r.getString("Applicant_Presentable"), r.getString("Applicant_Attitude"), removeSpecialCharacters(r.getString("Interview_Comments")), r.getString("Formal_Interview_Complete"));
		
		return "Sucessful";		
	}
	
	
	public String removeSpecialCharacters(String string)
	{
		//string = string.replace("'", "/'");

		return string;
	}

}
