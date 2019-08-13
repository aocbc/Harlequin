package aoc.Harlequin.Services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;
import org.json.JSONObject;

import aoc.Harlequin.DAOs.AssignedJobApplicantDAO;
import aoc.Harlequin.DAOs.ClientDAO;
import aoc.Harlequin.DAOs.ClientInterviewDAO;
import aoc.Harlequin.DAOs.JobHistoryDAO;
import aoc.Harlequin.DAOs.MacApplicantDAO;
import aoc.Harlequin.DAOs.MacInterviewDAO;
import aoc.Harlequin.DAOs.PracticalDrivingAssessmentDAO;
import aoc.Harlequin.DAOs.ReferenceCheckDAO;
import aoc.Harlequin.OBJs.AssignedJobApplicantList;
import aoc.Harlequin.OBJs.ClientInterviews;
import aoc.Harlequin.OBJs.JobHistory;
import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.MacLabourInterView;
import aoc.Harlequin.OBJs.PracticalDriversAssessment;
import aoc.Harlequin.OBJs.ReferenceChecks;
import aoc.Harlequin.OBJs.SystemClient;

@Path("ApplicantUpdate")
public class ApplicantUpdateService {
	
	@Path("/GetClientbyid/{idClient}")
	@GET
	@Produces("text/plain")
	public String GET(@PathParam("idClient") int idClient ) throws Exception
	{
		
		ClientDAO clientDao  = new ClientDAO();
		SystemClient client  = clientDao.getClientInfoById(idClient);
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("idClient", client.getIdClient());
		jsonObject.put("Client_Name", client.getClientName());
		jsonObject.put("Client_E_Mail", client.getClientEMail());
		jsonObject.put("Client_Contact_Name", client.getClientContactName());
		jsonObject.put("Client_Contact_Number", client.getClientContactNumber());		
		jsonObject.put("Client_Address_1", client.getClientAddress1());
		jsonObject.put("Client_Address_2", client.getClientAddress2());
		jsonObject.put("Client_Address_3", client.getClientAddress3());
		jsonObject.put("Client_Address_4", client.getClientAddress4());
		jsonObject.put("Client_Vat_Number", client.getClientVatNumber());
		jsonObject.put("Client_Comments", client.getClientComments());
		jsonObject.put("Last_Used_Date", client.getLastUsedDate());

		return jsonObject.toString();
	}
	
	@Path("/UpdateIdNumber")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String update(String jsonTextObject) throws JSONException
	{		
		
		System.out.println(jsonTextObject);
		JSONObject jsonObject = new JSONObject(jsonTextObject);
		String old_Id_Number = jsonObject.getString("Old_Id_Number");
		String new_Id_Number = jsonObject.getString("New_Id_Number");
		
		MacApplicantDAO macApplicantDAO = new MacApplicantDAO();
		AssignedJobApplicantDAO assignedJobApplicantDAO = new AssignedJobApplicantDAO(); 
		MacInterviewDAO macInterviewDAO = new MacInterviewDAO(); 
		PracticalDrivingAssessmentDAO practicalDrivingAssesmentDAO = new PracticalDrivingAssessmentDAO();
		ClientInterviewDAO clientInterviewDAO = new ClientInterviewDAO();
		ReferenceCheckDAO referenceCheckDAO = new ReferenceCheckDAO(); 
		JobHistoryDAO jobHistoryDAO = new JobHistoryDAO();
		
		List<MacApplicants> macApplicant = macApplicantDAO.GetApplicantsByApplicantId(old_Id_Number);
		
		
		
		if(macApplicant != null)
		{
			if(macApplicant.size() > 0)
			{
				macApplicant.get(0).setIdNumber(new_Id_Number.trim());
				macApplicantDAO.update(macApplicant.get(0));
				
				List<AssignedJobApplicantList> assignedJobApplicantList =  assignedJobApplicantDAO.ReadAllAssignedJobsInfobyIdNumber(old_Id_Number);
				if(assignedJobApplicantList != null)
				{
					if(assignedJobApplicantList.size() > 0)
					{
						for(int i = 0 ; i < assignedJobApplicantList.size(); i++)
						{
							assignedJobApplicantList.get(i).setIdMacApplicants(new_Id_Number.trim());
							assignedJobApplicantDAO.update(assignedJobApplicantList.get(i));
						}
					}
					
				}
				
				List<MacLabourInterView> macLabourInterViewList = macInterviewDAO.GetInterviewByInfoIdNumber(old_Id_Number);
				if(macLabourInterViewList != null)
				{
					if(macLabourInterViewList.size() > 0)
					{
						for(int j = 0 ; j < macLabourInterViewList.size(); j++)
						{
							macLabourInterViewList.get(j).setIdNumber(new_Id_Number);
							
							macInterviewDAO.update(macLabourInterViewList.get(j));
							
						}
					}
					
				}
				
				List<PracticalDriversAssessment> practicalDriversInterviews = practicalDrivingAssesmentDAO.ReadAssessmentsByInfoByIDnumber(old_Id_Number);
				if(practicalDriversInterviews != null)
				{
					if(practicalDriversInterviews.size() > 0)
					{
						for(int a = 0; a < practicalDriversInterviews.size();a++)
						{
							practicalDriversInterviews.get(a).setIdNumber(new_Id_Number);
							practicalDrivingAssesmentDAO.update(practicalDriversInterviews.get(a));
						}
						
					}
				}
				
				List<ClientInterviews> clientInterviews = clientInterviewDAO.GetClientInfoByIdNumber(old_Id_Number);
				if(clientInterviews != null)
				{
					if(clientInterviews.size() > 0)
					{
						for(int b = 0; b < clientInterviews.size();b++)
						{
							clientInterviews.get(b).setIdNumber(new_Id_Number);
							clientInterviewDAO.update(clientInterviews.get(b));
						}
						
					}
				}
				
				
				List<ReferenceChecks> referenceChecks = referenceCheckDAO.GetUserByIdNumber(old_Id_Number);
				if(referenceChecks != null)
				{
					if(referenceChecks.size() > 0)
					{
						for(int c = 0; c < referenceChecks.size();c++)
						{
							referenceChecks.get(c).setIdNumber(new_Id_Number);
							referenceCheckDAO.update(referenceChecks.get(c));
						}
						
					}
				}
				
				
				
				 List<JobHistory> jobHistory = jobHistoryDAO.ReadAllJobHistoryByIdNumber(old_Id_Number);
				if(jobHistory != null)
				{
					if(jobHistory.size() > 0)
					{
						for(int d = 0; d< jobHistory.size();d++)
						{
							jobHistory.get(d).setIdMacApplicants(new_Id_Number);
							jobHistoryDAO.update(jobHistory.get(d));
						}
						
					}
				}
				
				
				
				
				
			}
			
		}
		
			
		return "Updated";
	}
	
	
	
	
	
	

}
