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
		
		MacInterviewDAO macInterviewDAO  = new MacInterviewDAO();
		MacLabourInterView Interviews = macInterviewDAO.getInterviewInfoById(1);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("idMacLabour_InterView", Interviews.getIdMacLabourInterView());
		jsonObject.put("idMac_Applicants", Interviews.getIdMacApplicants());
		jsonObject.put("Name", Interviews.getName());
		jsonObject.put("Surname", Interviews.getSurname());
		jsonObject.put("Id_Number", Interviews.getIdNumber());		
		jsonObject.put("Client_Name", Interviews.getClientName());
		jsonObject.put("Id_Verified", Interviews.getIdVerified());
		jsonObject.put("Work_History_Verified", Interviews.getWorkHistoryVerified());
		jsonObject.put("Job_Name", Interviews.getJobName());
		jsonObject.put("Drivers_License_Verified", Interviews.getDriversLicenseVerified());
		jsonObject.put("SAP_Check", Interviews.getSapCheck());
		jsonObject.put("Criminal_Record", Interviews.getCriminalRecord());
		jsonObject.put("Criminal_Record_Comments", StringEscapeUtils.escapeJava(Interviews.getCriminalRecordComments()));
		jsonObject.put("Union_Member", Interviews.getUnionMember());		
		jsonObject.put("Union_Name", Interviews.getUnionName());
		jsonObject.put("Applicant_Passed_Interview", Interviews.getApplicantPassedInterview());
		jsonObject.put("Applicant_Presentable", Interviews.getApplicantPresentable());
		jsonObject.put("Applicant_Atttitude", Interviews.getApplicantAtttitude());
		jsonObject.put("Interview_comments", StringEscapeUtils.escapeJava(Interviews.getInterviewComments()));
		jsonObject.put("Formal_Interview_Complete", Interviews.getFormalInterviewComplete());
		jsonObject.put("Last_Used_Date", Interviews.getLastUsedDate());

	    
		return jsonObject.toString();
	}
	
	@Path("/GetAllInterviews")
	@GET
	@Produces("text/plain")
	public String GETInterviews( ) throws Exception
	{
		
		MacInterviewDAO macInterviewDao  = new MacInterviewDAO();
		
		List<MacLabourInterView> interviews = macInterviewDao.ReadAllInterviews();
		
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < interviews.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
		

			jsonObject.put("idMacLabour_InterView", interviews.get(i).getIdMacLabourInterView());
			jsonObject.put("idMac_Applicants", interviews.get(i).getIdMacApplicants());
			jsonObject.put("Name", interviews.get(i).getName());
			jsonObject.put("Surname", interviews.get(i).getSurname());
			jsonObject.put("Id_Number", interviews.get(i).getIdNumber());		
			jsonObject.put("Client_Name", interviews.get(i).getClientName());
			jsonObject.put("Id_Verified", interviews.get(i).getIdVerified());
			jsonObject.put("Work_History_Verified", interviews.get(i).getWorkHistoryVerified());
			jsonObject.put("Job_Name", interviews.get(i).getJobName());
			jsonObject.put("Drivers_License_Verified", interviews.get(i).getDriversLicenseVerified());
			jsonObject.put("SAP_Check", interviews.get(i).getSapCheck());
			jsonObject.put("Criminal_Record", interviews.get(i).getCriminalRecord());
			jsonObject.put("Criminal_Record_Comments", StringEscapeUtils.escapeJava(interviews.get(i).getCriminalRecordComments()));
			jsonObject.put("Union_Member", interviews.get(i).getUnionMember());		
			jsonObject.put("Union_Name", interviews.get(i).getUnionName());
			jsonObject.put("Applicant_Passed_Interview", interviews.get(i).getApplicantPassedInterview());
			jsonObject.put("Applicant_Presentable", interviews.get(i).getApplicantPresentable());
			jsonObject.put("Applicant_Atttitude", interviews.get(i).getApplicantAtttitude());
			jsonObject.put("Interview_comments", StringEscapeUtils.escapeJava(interviews.get(i).getInterviewComments()));
			jsonObject.put("Formal_Interview_Complete", interviews.get(i).getFormalInterviewComplete());
			jsonObject.put("Last_Used_Date", interviews.get(i).getLastUsedDate());
			
			
			
			jsonArray.put(jsonObject);
		}


	    
		return jsonArray.toString();
	}
	
	
	
	
	@Path("/GetInterviewInfo/{Client_Name}")
	@GET
	@Produces("text/plain")
	public String GET1(@PathParam("Client_Name") String Client_Name ) throws Exception
	{
		MacInterviewDAO macInterviewDAO  = new MacInterviewDAO();
		List<MacLabourInterView> interviews = macInterviewDAO.GetClientInfoByName(Client_Name);
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < interviews.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMacLabour_InterView", interviews.get(i).getIdMacLabourInterView());
			jsonObject.put("idMac_Applicants", interviews.get(i).getIdMacApplicants());
			jsonObject.put("Name", interviews.get(i).getName());
			jsonObject.put("Surname", interviews.get(i).getSurname());
			jsonObject.put("Id_Number", interviews.get(i).getIdNumber());		
			jsonObject.put("Client_Name", interviews.get(i).getClientName());
			jsonObject.put("Id_Verified", interviews.get(i).getIdVerified());
			jsonObject.put("Work_History_Verified", interviews.get(i).getWorkHistoryVerified());
			jsonObject.put("Job_Name", interviews.get(i).getJobName());
			jsonObject.put("Drivers_License_Verified", interviews.get(i).getDriversLicenseVerified());
			jsonObject.put("SAP_Check", interviews.get(i).getSapCheck());
			jsonObject.put("Criminal_Record", interviews.get(i).getCriminalRecord());
			jsonObject.put("Criminal_Record_Comments", StringEscapeUtils.escapeJava(interviews.get(i).getCriminalRecordComments()));
			jsonObject.put("Union_Member", interviews.get(i).getUnionMember());		
			jsonObject.put("Union_Name", interviews.get(i).getUnionName());
			jsonObject.put("Applicant_Passed_Interview", interviews.get(i).getApplicantPassedInterview());
			jsonObject.put("Applicant_Presentable", interviews.get(i).getApplicantPresentable());
			jsonObject.put("Applicant_Atttitude", interviews.get(i).getApplicantAtttitude());
			jsonObject.put("Interview_comments", StringEscapeUtils.escapeJava(interviews.get(i).getInterviewComments()));
			jsonObject.put("Formal_Interview_Complete", interviews.get(i).getFormalInterviewComplete());
			jsonObject.put("Last_Used_Date", interviews.get(i).getLastUsedDate());
			
			jsonArray.put(jsonObject);
		}
		
		
		return jsonArray.toString();
	}
	
	
	@Path("/GetInterviewInfobyIdnumber/{Id_Number}")
	@GET
	@Produces("text/plain")
	public String GET4(@PathParam("Id_Number") String Id_Number) throws Exception
	{
		
		
		MacInterviewDAO macInterviewDao  = new MacInterviewDAO();
		List<MacLabourInterView> Interviews = macInterviewDao.GetInterviewByInfoIdNumber(Id_Number);
		JSONArray jsonArray = new JSONArray();
		
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
				
				jsonArray.put(jsonObject);
			}
		
		return jsonArray.toString();
	}
	
	
	@Path("/GetInterviewInfo/{Id_Number}/{idMac_Applicants}/{Job_Name}")
	@GET
	@Produces("text/plain")
	public String GET3(String Surname,@PathParam("Id_Number") String Id_Number, @PathParam("idMac_Applicants") String idMac_Applicants , @PathParam("Job_Name") String Job_Name  ) throws Exception
	{
		
		MacInterviewDAO macInterviewDao  = new MacInterviewDAO();
		List<MacLabourInterView> interviews = macInterviewDao.GetInterviewByInfo(Id_Number, idMac_Applicants,Job_Name);
		JSONObject jsonObject = new JSONObject();
			
			if(interviews.size()>0)
			{

				jsonObject.put("idMacLabour_InterView", interviews.get(0).getIdMacLabourInterView());
				jsonObject.put("idMac_Applicants", interviews.get(0).getIdMacApplicants());
				jsonObject.put("Name", interviews.get(0).getName());
				jsonObject.put("Surname", interviews.get(0).getSurname());
				jsonObject.put("Id_Number", interviews.get(0).getIdNumber());		
				jsonObject.put("Client_Name", interviews.get(0).getClientName());
				jsonObject.put("Id_Verified", interviews.get(0).getIdVerified());
				jsonObject.put("Work_History_Verified", interviews.get(0).getWorkHistoryVerified());
				jsonObject.put("Job_Name", interviews.get(0).getJobName());
				jsonObject.put("Drivers_License_Verified", interviews.get(0).getDriversLicenseVerified());
				jsonObject.put("SAP_Check", interviews.get(0).getSapCheck());
				jsonObject.put("Criminal_Record", interviews.get(0).getCriminalRecord());
				jsonObject.put("Criminal_Record_Comments", StringEscapeUtils.escapeJava(interviews.get(0).getCriminalRecordComments()));
				jsonObject.put("Union_Member", interviews.get(0).getUnionMember());		
				jsonObject.put("Union_Name", interviews.get(0).getUnionName());
				jsonObject.put("Applicant_Passed_Interview", interviews.get(0).getApplicantPassedInterview());
				jsonObject.put("Applicant_Presentable", interviews.get(0).getApplicantPresentable());
				jsonObject.put("Applicant_Atttitude", interviews.get(0).getApplicantAtttitude());
				jsonObject.put("Interview_comments", StringEscapeUtils.escapeJava(interviews.get(0).getInterviewComments()));
				jsonObject.put("Formal_Interview_Complete", interviews.get(0).getFormalInterviewComplete());
				jsonObject.put("Last_Used_Date", interviews.get(0).getLastUsedDate());
			}
					
		
		return jsonObject.toString();
	}
	
	
	
	
	@Path("/SaveInterviewInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		
		JobDAO jobDao = new JobDAO();
		JSONObject jsonObject = new JSONObject(jsonTextObject);	
		List<SystemJob> Job_For_Interview = jobDao.GetClientNameByJobName(jsonObject.getString("Job_Name"));
		String Client_Name =  Job_For_Interview.get(0).getJobClientName();
		MacInterviewDAO macInterviewDao  = new MacInterviewDAO();
		
		macInterviewDao.AddInterviewInformation(jsonObject.getString("idMac_Applicants"), jsonObject.getString("Name"), jsonObject.getString("Surname"), jsonObject.getString("Id_Number"), Client_Name, jsonObject.getString("Id_Verified"), jsonObject.getString("Work_History_Verified"), jsonObject.getString("Job_Name"), jsonObject.getString("Drivers_License_Verified"), jsonObject.getString("SAP_Check"), jsonObject.getString("Criminal_Record"), jsonObject.getString("Criminal_Record_Comments"), jsonObject.getString("Union_Member"), jsonObject.getString("Union_Name"), jsonObject.getString("Applicant_Passed_Interview"), jsonObject.getString("Applicant_Presentable"), jsonObject.getString("Applicant_Attitude"), removeSpecialCharacters(jsonObject.getString("Interview_Comments")), jsonObject.getString("Formal_Interview_Complete"));
		
		return "Sucessful";		
	}
	
	
	public String removeSpecialCharacters(String string)
	{
		//string = string.replace("'", "/'");

		return string;
	}

}
