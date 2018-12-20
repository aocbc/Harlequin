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
import aoc.Harlequin.DAOs.ClientDAO;
import aoc.Harlequin.DAOs.MacApplicantDAO;
import aoc.Harlequin.DAOs.SystemUserDAO;
import aoc.Harlequin.OBJs.AssignedJobApplicantList;
import aoc.Harlequin.OBJs.GeneralHelpUtility;
import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemUser;

@Path("Applicant")
public class MacApplicantService {
	
	
	
	@Path("/MarkApplicantInactiveActive/{idMac_Applicants}/{sms_Account_Active}")
	@GET
	@Produces("text/plain")
	public String MarkApplicantInactiveActive( @PathParam("idMac_Applicants") int idMac_Applicants, @PathParam("sms_Account_Active") String sms_Account_Active ) throws Exception
	{
		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		MacApplicants applicant  = macApplicantDao.getClientApplicantoById(idMac_Applicants);

		applicant.setSmsAccountActive(sms_Account_Active);
		macApplicantDao.update(applicant);

		return "Applicant Inactive";
	}
	
	
	
	@Path("/GetApplicantInfo")
	@GET
	@Produces("text/plain")
	public String GET( ) throws Exception
	{
		
		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		MacApplicants applicant  = macApplicantDao.getClientApplicantoById(1);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("idMac_Applicants", applicant.getIdMacApplicants() );
		jsonObject.put("Name", applicant.getName());
		jsonObject.put("Surname", applicant.getSurname());
		jsonObject.put("RSA_Citizen", applicant.getRsaCitizen());
		jsonObject.put("Id_Number", applicant.getIdNumber());	
		jsonObject.put("Passport_Number", applicant.getPassportNumber());
		jsonObject.put("Expiry_Date_Of_Passport", applicant.getExpiryDateOfPassport());
		jsonObject.put("Work_Permit_Validity", applicant.getWorkPermitValidity());
		jsonObject.put("Cell_Number", applicant.getCellNumber());
		jsonObject.put("Telephone_Number", applicant.getTelephoneNumber());
		jsonObject.put("Job_Type", applicant.getJobType());
		jsonObject.put("Date_First_issue_license", applicant.getDateFirstIssueLicense());
		jsonObject.put("License_Code", applicant.getLicenseCode());
		jsonObject.put("Expiry_Date_Of_License", applicant.getExpiryDateOfLicense());
		jsonObject.put("PDP_Expiry_Date", applicant.getPdpExpiryDate());
		jsonObject.put("Gender", applicant.getGender());
		jsonObject.put("Physical_Address_1", applicant.getPhysicalAddress1());
		jsonObject.put("Physical_Address_2", applicant.getPhysicalAddress2());		
		jsonObject.put("Physical_Address_3", applicant.getPhysicalAddress3());
		jsonObject.put("Physical_Address_4", applicant.getPhysicalAddress4());
		jsonObject.put("City", applicant.getCity());		
		jsonObject.put("Country", applicant.getCountry());
		jsonObject.put("Tax_No", applicant.getTaxNo());
		jsonObject.put("Marital_Status", applicant.getMaritalStatus());
		jsonObject.put("Dependants", applicant.getDependants());
		jsonObject.put("Home_Language", applicant.getHomeLanguage());
		jsonObject.put("Work_History_1", applicant.getWorkHistory1());
		jsonObject.put("Work_History_2", applicant.getWorkHistory2());
		jsonObject.put("Work_History_3", applicant.getWorkHistory3());
		jsonObject.put("Work_History_4", applicant.getWorkHistory4());
		jsonObject.put("E_Mail", applicant.getEmail());
		jsonObject.put("Age", applicant.getAge());
		jsonObject.put("Date_Of_Birth", applicant.getDateOfBirth());
		jsonObject.put("Last_Sms_Date", applicant.getLastSmsDate());
		jsonObject.put("Sms_Group", applicant.getSmsGroup());
		jsonObject.put("Sms_Account_Active", applicant.getSmsAccountActive());
		jsonObject.put("Last_Used_Date", applicant.getLastUsedDate());
		jsonObject.put("Employable", applicant.getEmployable());
		jsonObject.put("Employable_Comments", applicant.getEmployableComments());		

	    
		return jsonObject.toString();
	}
	
	
	@Path("/GetApplicant/{jobType}")
	@GET
	@Produces("text/plain")
	public String GET1(@PathParam("jobType") String jobType) throws Exception
	{
		
		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		
		List<MacApplicants> applicants = macApplicantDao.GetApplicantsByJobType(jobType);
		
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", applicants.get(i).getName());
			jsonObject.put("Surname", applicants.get(i).getSurname());
			jsonObject.put("RSA_Citizen", applicants.get(i).getRsaCitizen());
			jsonObject.put("Id_Number", applicants.get(i).getIdNumber());
			jsonObject.put("Passport_Number", applicants.get(i).getPassportNumber());
			jsonObject.put("Expiry_Date_Of_Passport", applicants.get(i).getExpiryDateOfPassport());
			jsonObject.put("Work_Permit_Validity", applicants.get(i).getWorkPermitValidity());
			jsonObject.put("Cell_Number", applicants.get(i).getCellNumber());
			jsonObject.put("Telephone_Number", applicants.get(i).getTelephoneNumber());
			jsonObject.put("Job_Type", applicants.get(i).getJobType());
			jsonObject.put("Date_First_issue_license", applicants.get(i).getDateFirstIssueLicense());
			jsonObject.put("License_Code", applicants.get(i).getLicenseCode());
			jsonObject.put("Expiry_Date_Of_License", applicants.get(i).getExpiryDateOfLicense());
			jsonObject.put("PDP_Expiry_Date", applicants.get(i).getPdpExpiryDate());
			jsonObject.put("Gender", applicants.get(i).getGender());
			jsonObject.put("Physical_Address_1", applicants.get(i).getPhysicalAddress1());
			jsonObject.put("Physical_Address_2", applicants.get(i).getPhysicalAddress2());		
			jsonObject.put("Physical_Address_3", applicants.get(i).getPhysicalAddress3());
			jsonObject.put("Physical_Address_4", applicants.get(i).getPhysicalAddress4());
			jsonObject.put("City", applicants.get(i).getCity());		
			jsonObject.put("Country", applicants.get(i).getCountry());
			jsonObject.put("Tax_No", applicants.get(i).getTaxNo());
			jsonObject.put("Marital_Status", applicants.get(i).getMaritalStatus());
			jsonObject.put("Dependants", applicants.get(i).getDependants());
			jsonObject.put("Home_Language", applicants.get(i).getHomeLanguage());
			jsonObject.put("Work_History_1", applicants.get(i).getWorkHistory1());
			jsonObject.put("Work_History_2", applicants.get(i).getWorkHistory2());
			jsonObject.put("Work_History_3", applicants.get(i).getWorkHistory3());
			jsonObject.put("Work_History_4", applicants.get(i).getWorkHistory4());
			jsonObject.put("E_Mail", applicants.get(i).getEmail());
			jsonObject.put("Age", applicants.get(i).getAge());
			jsonObject.put("Date_Of_Birth", applicants.get(i).getDateOfBirth());
			jsonObject.put("Last_Sms_Date", applicants.get(i).getLastSmsDate());
			jsonObject.put("Sms_Group", applicants.get(i).getSmsGroup());
			jsonObject.put("Sms_Account_Active", applicants.get(i).getSmsAccountActive());
			jsonObject.put("Last_Used_Date", applicants.get(i).getLastUsedDate());
			jsonObject.put("Employable", applicants.get(i).getEmployable());
			jsonObject.put("Employable_Comments", applicants.get(i).getEmployableComments());
			
			jsonArray.put(jsonObject);
		}
		

		
		return jsonArray.toString();
	}
	
	@Path("/GetApplicantByIdCell/{idNumber}/{cell_Number}")
	@GET
	@Produces("text/plain")
	public String GETIDCELL(@PathParam("idNumber") String idNumber,@PathParam("cell_Number") String cell_Number) throws Exception
	{

		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		List<MacApplicants> applicants = macApplicantDao.GetApplicantsByApplicantIdCell(idNumber, cell_Number);
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", applicants.get(i).getName());
			jsonObject.put("Surname", applicants.get(i).getSurname());
			jsonObject.put("RSA_Citizen", applicants.get(i).getRsaCitizen());
			jsonObject.put("Id_Number", applicants.get(i).getIdNumber());
			jsonObject.put("Passport_Number", applicants.get(i).getPassportNumber());
			jsonObject.put("Expiry_Date_Of_Passport", applicants.get(i).getExpiryDateOfPassport());
			jsonObject.put("Work_Permit_Validity", applicants.get(i).getWorkPermitValidity());
			jsonObject.put("Cell_Number", applicants.get(i).getCellNumber());
			jsonObject.put("Telephone_Number", applicants.get(i).getTelephoneNumber());
			jsonObject.put("Job_Type", applicants.get(i).getJobType());
			jsonObject.put("Date_First_issue_license", applicants.get(i).getDateFirstIssueLicense());
			jsonObject.put("License_Code", applicants.get(i).getLicenseCode());
			jsonObject.put("Expiry_Date_Of_License", applicants.get(i).getExpiryDateOfLicense());
			jsonObject.put("PDP_Expiry_Date", applicants.get(i).getPdpExpiryDate());
			jsonObject.put("Gender", applicants.get(i).getGender());
			jsonObject.put("Physical_Address_1", applicants.get(i).getPhysicalAddress1());
			jsonObject.put("Physical_Address_2", applicants.get(i).getPhysicalAddress2());		
			jsonObject.put("Physical_Address_3", applicants.get(i).getPhysicalAddress3());
			jsonObject.put("Physical_Address_4", applicants.get(i).getPhysicalAddress4());
			jsonObject.put("City", applicants.get(i).getCity());		
			jsonObject.put("Country", applicants.get(i).getCountry());
			jsonObject.put("Tax_No", applicants.get(i).getTaxNo());
			jsonObject.put("Marital_Status", applicants.get(i).getMaritalStatus());
			jsonObject.put("Dependants", applicants.get(i).getDependants());
			jsonObject.put("Home_Language", applicants.get(i).getHomeLanguage());
			jsonObject.put("Work_History_1", applicants.get(i).getWorkHistory1());
			jsonObject.put("Work_History_2", applicants.get(i).getWorkHistory2());
			jsonObject.put("Work_History_3", applicants.get(i).getWorkHistory3());
			jsonObject.put("Work_History_4", applicants.get(i).getWorkHistory4());
			jsonObject.put("E_Mail", applicants.get(i).getEmail());
			jsonObject.put("Age", applicants.get(i).getAge());
			jsonObject.put("Date_Of_Birth", applicants.get(i).getDateOfBirth());
			jsonObject.put("Last_Sms_Date", applicants.get(i).getLastSmsDate());
			jsonObject.put("Sms_Group", applicants.get(i).getSmsGroup());
			jsonObject.put("Sms_Account_Active", applicants.get(i).getSmsAccountActive());
			jsonObject.put("Last_Used_Date", applicants.get(i).getLastUsedDate());
			jsonObject.put("Employable", applicants.get(i).getEmployable());
			jsonObject.put("Employable_Comments", applicants.get(i).getEmployableComments());
			jsonObject.put("Age", applicants.get(i).getAge());
			jsonObject.put("Date_Of_Birth", applicants.get(i).getDateOfBirth());
			
			jsonArray.put(jsonObject);
		}
		

		return jsonArray.toString();
	}
	
	@Path("/GetApplicantById/{idNumber}")
	@GET
	@Produces("text/plain")
	public String GET3(@PathParam("idNumber") String idNumber) throws Exception
	{
		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		List<MacApplicants> applicants = macApplicantDao.GetApplicantsByApplicantId(idNumber);
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", applicants.get(i).getName());
			jsonObject.put("Surname", applicants.get(i).getSurname());
			jsonObject.put("RSA_Citizen", applicants.get(i).getRsaCitizen());
			jsonObject.put("Id_Number", applicants.get(i).getIdNumber());
			jsonObject.put("Passport_Number", applicants.get(i).getPassportNumber());
			jsonObject.put("Expiry_Date_Of_Passport", applicants.get(i).getExpiryDateOfPassport());
			jsonObject.put("Work_Permit_Validity", applicants.get(i).getWorkPermitValidity());
			jsonObject.put("Cell_Number", applicants.get(i).getCellNumber());
			jsonObject.put("Telephone_Number", applicants.get(i).getTelephoneNumber());
			jsonObject.put("Job_Type", applicants.get(i).getJobType());
			jsonObject.put("Date_First_issue_license", applicants.get(i).getDateFirstIssueLicense());
			jsonObject.put("License_Code", applicants.get(i).getLicenseCode());
			jsonObject.put("Expiry_Date_Of_License", applicants.get(i).getExpiryDateOfLicense());
			jsonObject.put("PDP_Expiry_Date", applicants.get(i).getPdpExpiryDate());
			jsonObject.put("Gender", applicants.get(i).getGender());
			jsonObject.put("Physical_Address_1", applicants.get(i).getPhysicalAddress1());
			jsonObject.put("Physical_Address_2", applicants.get(i).getPhysicalAddress2());		
			jsonObject.put("Physical_Address_3", applicants.get(i).getPhysicalAddress3());
			jsonObject.put("Physical_Address_4", applicants.get(i).getPhysicalAddress4());
			jsonObject.put("City", applicants.get(i).getCity());		
			jsonObject.put("Country", applicants.get(i).getCountry());
			jsonObject.put("Tax_No", applicants.get(i).getTaxNo());
			jsonObject.put("Marital_Status", applicants.get(i).getMaritalStatus());
			jsonObject.put("Dependants", applicants.get(i).getDependants());
			jsonObject.put("Home_Language", applicants.get(i).getHomeLanguage());
			jsonObject.put("Work_History_1", applicants.get(i).getWorkHistory1());
			jsonObject.put("Work_History_2", applicants.get(i).getWorkHistory2());
			jsonObject.put("Work_History_3", applicants.get(i).getWorkHistory3());
			jsonObject.put("Work_History_4", applicants.get(i).getWorkHistory4());
			jsonObject.put("E_Mail", applicants.get(i).getEmail());
			jsonObject.put("Age", applicants.get(i).getAge());
			jsonObject.put("Date_Of_Birth", applicants.get(i).getDateOfBirth());
			jsonObject.put("Last_Sms_Date", applicants.get(i).getLastSmsDate());
			jsonObject.put("Sms_Group", applicants.get(i).getSmsGroup());
			jsonObject.put("Sms_Account_Active", applicants.get(i).getSmsAccountActive());
			jsonObject.put("Sms_Group_Count", applicants.get(i).getSmsGroupCount());
			jsonObject.put("Last_Used_Date", applicants.get(i).getLastUsedDate());
			jsonObject.put("Applicant_Status", applicants.get(i).getApplicantStatus());
			jsonObject.put("Nationality", applicants.get(i).getNationality());
			jsonObject.put("Job_Name", applicants.get(i).getJobName());
			jsonObject.put("Employable", applicants.get(i).getEmployable());
			jsonObject.put("Employable_Comments", applicants.get(i).getEmployableComments());
			jsonObject.put("Stage_In_Process", applicants.get(i).getStageInTheProcess());
			
			jsonArray.put(jsonObject);
		}
		

		return jsonArray.toString();
	}
	
	
	
	
	@Path("/GetApplicantsInterview/{idMac_Applicants}/{id_Number}/{job_Name}")
	@GET
	@Produces("text/plain")
	public String GETInterview(@PathParam("idMac_Applicants") String idMac_Applicants,@PathParam("id_Number") String id_Number,@PathParam("job_Name") String job_Name) throws Exception
	{	
		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		List<MacApplicants> applicants = macApplicantDao.GetApplicantsByApplicantId(id_Number);
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", applicants.get(i).getName());
			jsonObject.put("Surname", applicants.get(i).getSurname());
			jsonObject.put("RSA_Citizen", applicants.get(i).getRsaCitizen());
			jsonObject.put("Id_Number", applicants.get(i).getIdNumber());
			jsonObject.put("Passport_Number", applicants.get(i).getPassportNumber());
			jsonObject.put("Expiry_Date_Of_Passport", applicants.get(i).getExpiryDateOfPassport());
			jsonObject.put("Work_Permit_Validity", applicants.get(i).getWorkPermitValidity());
			jsonObject.put("Cell_Number", applicants.get(i).getCellNumber());
			jsonObject.put("Telephone_Number", applicants.get(i).getTelephoneNumber());
			jsonObject.put("Job_Type", applicants.get(i).getJobType());
			jsonObject.put("Date_First_issue_license", applicants.get(i).getDateFirstIssueLicense());
			jsonObject.put("License_Code", applicants.get(i).getLicenseCode());
			jsonObject.put("Expiry_Date_Of_License", applicants.get(i).getExpiryDateOfLicense());
			jsonObject.put("PDP_Expiry_Date", applicants.get(i).getPdpExpiryDate());
			jsonObject.put("Gender", applicants.get(i).getGender());
			jsonObject.put("Physical_Address_1", applicants.get(i).getPhysicalAddress1());
			jsonObject.put("Physical_Address_2", applicants.get(i).getPhysicalAddress2());		
			jsonObject.put("Physical_Address_3", applicants.get(i).getPhysicalAddress3());
			jsonObject.put("Physical_Address_4", applicants.get(i).getPhysicalAddress4());
			jsonObject.put("City", applicants.get(i).getCity());		
			jsonObject.put("Country", applicants.get(i).getCountry());
			jsonObject.put("Tax_No", applicants.get(i).getTaxNo());
			jsonObject.put("Marital_Status", applicants.get(i).getMaritalStatus());
			jsonObject.put("Dependants", applicants.get(i).getDependants());
			jsonObject.put("Home_Language", applicants.get(i).getHomeLanguage());
			jsonObject.put("Work_History_1", applicants.get(i).getWorkHistory1());
			jsonObject.put("Work_History_2", applicants.get(i).getWorkHistory2());
			jsonObject.put("Work_History_3", applicants.get(i).getWorkHistory3());
			jsonObject.put("Work_History_4", applicants.get(i).getWorkHistory4());
			jsonObject.put("E_Mail", applicants.get(i).getEmail());
			jsonObject.put("Age", applicants.get(i).getAge());
			jsonObject.put("Date_Of_Birth", applicants.get(i).getDateOfBirth());
			jsonObject.put("Last_Sms_Date", applicants.get(i).getLastSmsDate());
			jsonObject.put("Sms_Group", applicants.get(i).getSmsGroup());
			jsonObject.put("Sms_Account_Active", applicants.get(i).getSmsAccountActive());
			jsonObject.put("Last_Used_Date", applicants.get(i).getLastUsedDate());
			jsonObject.put("Employable", applicants.get(i).getEmployable());
			jsonObject.put("Employable_Comments", applicants.get(i).getEmployableComments());
			
			jsonArray.put(jsonObject);
		}
		
		
		return jsonArray.toString();
	}
	
	@Path("/GetApplicantByTableId/{idMac_Applicants}")
	@GET
	@Produces("text/plain")
	public String GETid(@PathParam("idMac_Applicants") String idMac_Applicants) throws Exception
	{

		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		
		List<MacApplicants> applicants = macApplicantDao.GetApplicantsByApplicantId(idMac_Applicants);
		
		JSONObject jsonObject = new JSONObject();
		
		if(applicants.size() > 0)
		{
			jsonObject.put("idMac_Applicants", applicants.get(0).getIdMacApplicants());
			jsonObject.put("Name", applicants.get(0).getName());
			jsonObject.put("Surname", applicants.get(0).getSurname());
			jsonObject.put("RSA_Citizen", applicants.get(0).getRsaCitizen());
			jsonObject.put("Id_Number", applicants.get(0).getIdNumber());
			jsonObject.put("Passport_Number", applicants.get(0).getPassportNumber());
			jsonObject.put("Expiry_Date_Of_Passport", applicants.get(0).getExpiryDateOfPassport());
			jsonObject.put("Work_Permit_Validity", applicants.get(0).getWorkPermitValidity());
			jsonObject.put("Cell_Number", applicants.get(0).getCellNumber());
			jsonObject.put("Telephone_Number", applicants.get(0).getTelephoneNumber());
			jsonObject.put("Job_Type", applicants.get(0).getJobType());
			jsonObject.put("Date_First_issue_license", applicants.get(0).getDateFirstIssueLicense());
			jsonObject.put("License_Code", applicants.get(0).getLicenseCode());
			jsonObject.put("Expiry_Date_Of_License", applicants.get(0).getExpiryDateOfLicense());
			jsonObject.put("PDP_Expiry_Date", applicants.get(0).getPdpExpiryDate());
			jsonObject.put("Gender", applicants.get(0).getGender());
			jsonObject.put("Physical_Address_1", applicants.get(0).getPhysicalAddress1());
			jsonObject.put("Physical_Address_2", applicants.get(0).getPhysicalAddress2());		
			jsonObject.put("Physical_Address_3", applicants.get(0).getPhysicalAddress3());
			jsonObject.put("Physical_Address_4", applicants.get(0).getPhysicalAddress4());
			jsonObject.put("City", applicants.get(0).getCity());		
			jsonObject.put("Country", applicants.get(0).getCountry());
			jsonObject.put("Tax_No", applicants.get(0).getTaxNo());
			jsonObject.put("Marital_Status", applicants.get(0).getMaritalStatus());
			jsonObject.put("Dependants", applicants.get(0).getDependants());
			jsonObject.put("Home_Language", applicants.get(0).getHomeLanguage());
			jsonObject.put("Work_History_1", applicants.get(0).getWorkHistory1());
			jsonObject.put("Work_History_2", applicants.get(0).getWorkHistory2());
			jsonObject.put("Work_History_3", applicants.get(0).getWorkHistory3());
			jsonObject.put("Work_History_4", applicants.get(0).getWorkHistory4());
			jsonObject.put("E_Mail", applicants.get(0).getEmail());
			jsonObject.put("Age", applicants.get(0).getAge());
			jsonObject.put("Date_Of_Birth", applicants.get(0).getDateOfBirth());
			jsonObject.put("Last_Sms_Date", applicants.get(0).getLastSmsDate());
			jsonObject.put("Sms_Group", applicants.get(0).getSmsGroup());
			jsonObject.put("Applicant_Status", applicants.get(0).getApplicantStatus());
			jsonObject.put("Sms_Group", applicants.get(0).getSmsGroup());
			jsonObject.put("Applicant_Type", applicants.get(0).getApplicantType());
			jsonObject.put("Last_Sms_Date", applicants.get(0).getLastSmsDate());
			jsonObject.put("Nationality", applicants.get(0).getNationality());
			jsonObject.put("Mac_Labour_Interview_Complete", applicants.get(0).getmacLabInterviewComplete());
			jsonObject.put("Mac_Labour_Interview_Comments", applicants.get(0).getmacLabourInterviewComments());
			jsonObject.put("Sms_Group_Count", applicants.get(0).getSmsGroupCount());
			jsonObject.put("Practical_Drivers_Test_Complete", applicants.get(0).getPracticalDriversTestComplete());
			jsonObject.put("Practical_Drivers_Test_Comments", applicants.get(0).getPracticalDriversTestComments());
			jsonObject.put("Client_Interview_Complete", applicants.get(0).getClientInterviewComplete());
			jsonObject.put("Client_Interview_Comments", applicants.get(0).getClientInterviewComments());
			jsonObject.put("Reference_Checks_Complete", applicants.get(0).getReferenceChecksComplete());
			jsonObject.put("Reference_Checks_Comments", applicants.get(0).getReferenceChecksComments());
			jsonObject.put("Sms_Account_Active", applicants.get(0).getSmsAccountActive());
			jsonObject.put("Last_Used_Date", applicants.get(0).getLastUsedDate());
			jsonObject.put("Employable", applicants.get(0).getEmployable());
			jsonObject.put("Employable_Comments", applicants.get(0).getEmployableComments());
		}
		

		return jsonObject.toString();
	}
	
	
	
	
	
	@Path("/GetAllApplicants")
	@GET
	@Produces("text/plain")
	public String GETAPPLICANTS( ) throws Exception
	{
		
		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		
		List<MacApplicants> applicants = macApplicantDao.ReadAllApplicants();
		
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", applicants.get(i).getName());
			jsonObject.put("Surname", applicants.get(i).getSurname());
			jsonObject.put("RSA_Citizen", applicants.get(i).getRsaCitizen());
			jsonObject.put("Id_Number", applicants.get(i).getIdNumber());
			jsonObject.put("Passport_Number", applicants.get(i).getPassportNumber());
			jsonObject.put("Expiry_Date_Of_Passport", applicants.get(i).getExpiryDateOfPassport());
			jsonObject.put("Work_Permit_Validity", applicants.get(i).getWorkPermitValidity());
			jsonObject.put("Cell_Number", applicants.get(i).getCellNumber());
			jsonObject.put("Telephone_Number", applicants.get(i).getTelephoneNumber());
			jsonObject.put("Job_Type", applicants.get(i).getJobType());
			jsonObject.put("Date_First_issue_license", applicants.get(i).getDateFirstIssueLicense());
			jsonObject.put("License_Code", applicants.get(i).getLicenseCode());
			jsonObject.put("Expiry_Date_Of_License", applicants.get(i).getExpiryDateOfLicense());
			jsonObject.put("PDP_Expiry_Date", applicants.get(i).getPdpExpiryDate());
			jsonObject.put("Gender", applicants.get(i).getGender());
			jsonObject.put("Physical_Address_1", applicants.get(i).getPhysicalAddress1());
			jsonObject.put("Physical_Address_2", applicants.get(i).getPhysicalAddress2());		
			jsonObject.put("Physical_Address_3", applicants.get(i).getPhysicalAddress3());
			jsonObject.put("Physical_Address_4", applicants.get(i).getPhysicalAddress4());
			jsonObject.put("City", applicants.get(i).getCity());		
			jsonObject.put("Country", applicants.get(i).getCountry());
			jsonObject.put("Tax_No", applicants.get(i).getTaxNo());
			jsonObject.put("Marital_Status", applicants.get(i).getMaritalStatus());
			jsonObject.put("Dependants", applicants.get(i).getDependants());
			jsonObject.put("Home_Language", applicants.get(i).getHomeLanguage());
			jsonObject.put("Work_History_1", applicants.get(i).getWorkHistory1());
			jsonObject.put("Work_History_2", applicants.get(i).getWorkHistory2());
			jsonObject.put("Work_History_3", applicants.get(i).getWorkHistory3());
			jsonObject.put("Work_History_4", applicants.get(i).getWorkHistory4());
			jsonObject.put("E_Mail", applicants.get(i).getEmail());
			jsonObject.put("Age", applicants.get(i).getAge());
			jsonObject.put("Date_Of_Birth", applicants.get(i).getDateOfBirth());
			jsonObject.put("Last_Sms_Date", applicants.get(i).getLastSmsDate());
			jsonObject.put("Job_Name", applicants.get(i).getJobName());
			jsonObject.put("Sms_Group", applicants.get(i).getSmsGroup());
			jsonObject.put("Sms_Group_Count", applicants.get(i).getSmsGroupCount());
			jsonObject.put("Applicant_Type", applicants.get(i).getApplicantType());
			jsonObject.put("Applicant_Status", applicants.get(i).getApplicantStatus());
			jsonObject.put("Stage_In_Process", applicants.get(i).getStageInTheProcess());
			jsonObject.put("Nationality", applicants.get(i).getNationality());
			jsonObject.put("Job_Name", applicants.get(i).getJobName());
			jsonObject.put("Sms_Account_Active", applicants.get(i).getSmsAccountActive());
			jsonObject.put("Last_Used_Date", applicants.get(i).getLastUsedDate());
			jsonObject.put("Employable", applicants.get(i).getEmployable());
			jsonObject.put("Employable_Comments", applicants.get(i).getEmployableComments());
			
			jsonArray.put(jsonObject);
		}
		

		return jsonArray.toString();
	}
	
	
	
	@Path("/GetAllApplicantsSMSConsole")
	@GET
	@Produces("text/plain")
	public String GETAPPLICANTSSMSCONSOLE( ) throws Exception
	{
		
		MacApplicantDAO macapplicantDao  = new MacApplicantDAO();
		List<MacApplicants> applicants = macapplicantDao.ReadAllApplicantsSmsConsole();
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", applicants.get(i).getName());
			jsonObject.put("Surname", applicants.get(i).getSurname());
			jsonObject.put("RSA_Citizen", applicants.get(i).getRsaCitizen());
			jsonObject.put("Id_Number", applicants.get(i).getIdNumber());
			jsonObject.put("Passport_Number", applicants.get(i).getPassportNumber());
			jsonObject.put("Expiry_Date_Of_Passport", applicants.get(i).getExpiryDateOfPassport());
			jsonObject.put("Work_Permit_Validity", applicants.get(i).getWorkPermitValidity());
			jsonObject.put("Cell_Number", applicants.get(i).getCellNumber());
			jsonObject.put("Telephone_Number", applicants.get(i).getTelephoneNumber());
			jsonObject.put("Job_Type", applicants.get(i).getJobType());
			jsonObject.put("Date_First_issue_license", applicants.get(i).getDateFirstIssueLicense());
			jsonObject.put("License_Code", applicants.get(i).getLicenseCode());
			jsonObject.put("Expiry_Date_Of_License", applicants.get(i).getExpiryDateOfLicense());
			jsonObject.put("PDP_Expiry_Date", applicants.get(i).getPdpExpiryDate());
			jsonObject.put("Gender", applicants.get(i).getGender());
			jsonObject.put("Physical_Address_1", applicants.get(i).getPhysicalAddress1());
			jsonObject.put("Physical_Address_2", applicants.get(i).getPhysicalAddress2());		
			jsonObject.put("Physical_Address_3", applicants.get(i).getPhysicalAddress3());
			jsonObject.put("Physical_Address_4", applicants.get(i).getPhysicalAddress4());
			jsonObject.put("City", applicants.get(i).getCity());		
			jsonObject.put("Country", applicants.get(i).getCountry());
			jsonObject.put("Tax_No", applicants.get(i).getTaxNo());
			jsonObject.put("Marital_Status", applicants.get(i).getMaritalStatus());
			jsonObject.put("Dependants", applicants.get(i).getDependants());
			jsonObject.put("Home_Language", applicants.get(i).getHomeLanguage());
			jsonObject.put("Work_History_1", applicants.get(i).getWorkHistory1());
			jsonObject.put("Work_History_2", applicants.get(i).getWorkHistory2());
			jsonObject.put("Work_History_3", applicants.get(i).getWorkHistory3());
			jsonObject.put("Work_History_4", applicants.get(i).getWorkHistory4());
			jsonObject.put("E_Mail", applicants.get(i).getEmail());
			jsonObject.put("Age", applicants.get(i).getAge());
			jsonObject.put("Date_Of_Birth", applicants.get(i).getDateOfBirth());
			jsonObject.put("Last_Sms_Date", applicants.get(i).getLastSmsDate());
			jsonObject.put("Job_Name", applicants.get(i).getJobName());
			jsonObject.put("Sms_Group", applicants.get(i).getSmsGroup());
			jsonObject.put("Sms_Group_Count", applicants.get(i).getSmsGroupCount());
			jsonObject.put("Applicant_Type", applicants.get(i).getApplicantType());
			jsonObject.put("Applicant_Status", applicants.get(i).getApplicantStatus());
			jsonObject.put("Stage_In_Process", applicants.get(i).getStageInTheProcess());
			jsonObject.put("Nationality", applicants.get(i).getNationality());
			jsonObject.put("Job_Name", applicants.get(i).getJobName());
			jsonObject.put("Sms_Account_Active", applicants.get(i).getSmsAccountActive());
			jsonObject.put("Last_Used_Date", applicants.get(i).getLastUsedDate());
			jsonObject.put("Employable", applicants.get(i).getEmployable());
			jsonObject.put("Employable_Comments", applicants.get(i).getEmployableComments());
			
			jsonArray.put(jsonObject);
		}
		

	    
		return jsonArray.toString();
	}
	
	//////////////////////////////////////////////////////////////////////////////
	///////////OLD
	//////////////////////////////////////////////////////////////////////////////
	@Path("/GetAllApplicantsPracticalDrivers3")
	@GET
	@Produces("text/plain")
	public String GETAPPLICANTSDrivers( ) throws Exception
	{
		
		MacApplicantDAO Object  = new MacApplicantDAO();
		
		List<MacApplicants> Applicants = Object.GetApplicantsMacInterviewComplete();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", Applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", Applicants.get(i).getName());
			jsonObject.put("Job_Name", Applicants.get(i).getJobName());
			jsonObject.put("Surname", Applicants.get(i).getSurname());
			jsonObject.put("RSA_Citizen", Applicants.get(i).getRsaCitizen());
			jsonObject.put("Id_Number", Applicants.get(i).getIdNumber());
			jsonObject.put("Passport_Number", Applicants.get(i).getPassportNumber());
			jsonObject.put("Expiry_Date_Of_Passport", Applicants.get(i).getExpiryDateOfPassport());
			jsonObject.put("Work_Permit_Validity", Applicants.get(i).getWorkPermitValidity());
			jsonObject.put("Cell_Number", Applicants.get(i).getCellNumber());
			jsonObject.put("Telephone_Number", Applicants.get(i).getTelephoneNumber());
			jsonObject.put("Job_Type", Applicants.get(i).getJobType());
			jsonObject.put("Date_First_issue_license", Applicants.get(i).getDateFirstIssueLicense());
			jsonObject.put("License_Code", Applicants.get(i).getLicenseCode());
			jsonObject.put("Expiry_Date_Of_License", Applicants.get(i).getExpiryDateOfLicense());
			jsonObject.put("PDP_Expiry_Date", Applicants.get(i).getPdpExpiryDate());
			jsonObject.put("Gender", Applicants.get(i).getGender());
			jsonObject.put("Physical_Address_1", Applicants.get(i).getPhysicalAddress1());
			jsonObject.put("Physical_Address_2", Applicants.get(i).getPhysicalAddress2());		
			jsonObject.put("Physical_Address_3", Applicants.get(i).getPhysicalAddress3());
			jsonObject.put("Physical_Address_4", Applicants.get(i).getPhysicalAddress4());
			jsonObject.put("City", Applicants.get(i).getCity());		
			jsonObject.put("Country", Applicants.get(i).getCountry());
			jsonObject.put("Tax_No", Applicants.get(i).getTaxNo());
			jsonObject.put("Marital_Status", Applicants.get(i).getMaritalStatus());
			jsonObject.put("Dependants", Applicants.get(i).getDependants());
			jsonObject.put("Home_Language", Applicants.get(i).getHomeLanguage());
			jsonObject.put("Work_History_1", Applicants.get(i).getWorkHistory1());
			jsonObject.put("Work_History_2", Applicants.get(i).getWorkHistory2());
			jsonObject.put("Work_History_3", Applicants.get(i).getWorkHistory3());
			jsonObject.put("Work_History_4", Applicants.get(i).getWorkHistory4());
			jsonObject.put("E_Mail", Applicants.get(i).getEmail());
			jsonObject.put("Age", Applicants.get(i).getAge());
			jsonObject.put("Date_Of_Birth", Applicants.get(i).getDateOfBirth());
			jsonObject.put("Last_Sms_Date", Applicants.get(i).getLastSmsDate());
			jsonObject.put("Job_Name", Applicants.get(i).getJobName());
			jsonObject.put("Sms_Group", Applicants.get(i).getSmsGroup());
			jsonObject.put("Sms_Group_Count", Applicants.get(i).getSmsGroupCount());
			jsonObject.put("Applicant_Type", Applicants.get(i).getApplicantType());
			jsonObject.put("Applicant_Status", Applicants.get(i).getApplicantStatus());
			jsonObject.put("Practical_Drivers_Test_Comments", Applicants.get(i).getPracticalDriversTestComments());
			jsonObject.put("Practical_Drivers_Test_Complete", Applicants.get(i).getPracticalDriversTestComplete());
			jsonObject.put("Stage_In_Process", Applicants.get(i).getStageInTheProcess());
			jsonObject.put("Sms_Account_Active", Applicants.get(i).getSmsAccountActive());
			
			jsonObject.put("Nationality", Applicants.get(i).getNationality());
			jsonObject.put("Last_Used_Date", Applicants.get(i).getLastUsedDate());
			
			jsonObject.put("Employable", Applicants.get(i).getEmployable());
			jsonObject.put("Employable_Comments", Applicants.get(i).getEmployableComments());
			
			JsonArray.put(jsonObject);
		}
		
	    
		return JsonArray.toString();
	}
	
	////////////////////////////////////////////////////
	////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////
	///////////New
	//////////////////////////////////////////////////////////////////////////////
	@Path("/GetAllApplicantsPracticalDrivers")
	@GET
	@Produces("text/plain")
	public String GETAPPLICANTSDriversNew( ) throws Exception
	{
	
		
						AssignedJobApplicantDAO assignedJobApplicantDao = new AssignedJobApplicantDAO();
			
						MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
						
						List<MacApplicants> applicants = macApplicantDao.GetApplicantsMacInterviewCompleteNew();
						
						JSONArray jsonArray = new JSONArray();
						
						for(int i = 0; i < applicants.size();i++)
						{
									
									List<AssignedJobApplicantList> assignedJobApplicantLists = assignedJobApplicantDao.ReadAllAssignedJobsInfoByID(applicants.get(i).getIdNumber());
									
									for(int j=0; j < assignedJobApplicantLists.size(); j++)
									{
										
										JSONObject jsonObject = new JSONObject();
										
										jsonObject.put("idMac_Applicants", applicants.get(i).getIdMacApplicants());
										jsonObject.put("Name", applicants.get(i).getName());
										jsonObject.put("Surname", applicants.get(i).getSurname());
										jsonObject.put("RSA_Citizen", applicants.get(i).getRsaCitizen());
										jsonObject.put("Id_Number", applicants.get(i).getIdNumber());
										jsonObject.put("Passport_Number", applicants.get(i).getPassportNumber());
										jsonObject.put("Expiry_Date_Of_Passport", applicants.get(i).getExpiryDateOfPassport());
										jsonObject.put("Work_Permit_Validity", applicants.get(i).getWorkPermitValidity());
										jsonObject.put("Cell_Number", applicants.get(i).getCellNumber());
										jsonObject.put("Telephone_Number", applicants.get(i).getTelephoneNumber());
										jsonObject.put("Job_Type", applicants.get(i).getJobType());
										jsonObject.put("Date_First_issue_license", applicants.get(i).getDateFirstIssueLicense());
										jsonObject.put("License_Code", applicants.get(i).getLicenseCode());
										jsonObject.put("Expiry_Date_Of_License", applicants.get(i).getExpiryDateOfLicense());
										jsonObject.put("PDP_Expiry_Date", applicants.get(i).getPdpExpiryDate());
										jsonObject.put("Gender", applicants.get(i).getGender());
										jsonObject.put("Physical_Address_1", applicants.get(i).getPhysicalAddress1());
										jsonObject.put("Physical_Address_2", applicants.get(i).getPhysicalAddress2());		
										jsonObject.put("Physical_Address_3", applicants.get(i).getPhysicalAddress3());
										jsonObject.put("Physical_Address_4", applicants.get(i).getPhysicalAddress4());
										jsonObject.put("City", applicants.get(i).getCity());		
										jsonObject.put("Country", applicants.get(i).getCountry());
										jsonObject.put("Tax_No", applicants.get(i).getTaxNo());
										jsonObject.put("Marital_Status", applicants.get(i).getMaritalStatus());
										jsonObject.put("Dependants", applicants.get(i).getDependants());
										jsonObject.put("Home_Language", applicants.get(i).getHomeLanguage());
										jsonObject.put("Work_History_1", applicants.get(i).getWorkHistory1());
										jsonObject.put("Work_History_2", applicants.get(i).getWorkHistory2());
										jsonObject.put("Work_History_3", applicants.get(i).getWorkHistory3());
										jsonObject.put("Work_History_4", applicants.get(i).getWorkHistory4());
										jsonObject.put("E_Mail", applicants.get(i).getEmail());
										jsonObject.put("Age", applicants.get(i).getAge());
										jsonObject.put("Date_Of_Birth", applicants.get(i).getDateOfBirth());
										jsonObject.put("Last_Sms_Date", applicants.get(i).getLastSmsDate());
										////////////////////////////////////////////////////////////////////////////
										jsonObject.put("Job_Name", assignedJobApplicantLists.get(j).getJobName());
										//////////////////////////////////////////////////////////////
										jsonObject.put("Sms_Group", applicants.get(i).getSmsGroup());
										jsonObject.put("Sms_Group_Count", applicants.get(i).getSmsGroupCount());
										jsonObject.put("Applicant_Type", applicants.get(i).getApplicantType());
										jsonObject.put("Applicant_Status", applicants.get(i).getApplicantStatus());
										jsonObject.put("Stage_In_Process",  assignedJobApplicantLists.get(j).getStageInProcess());
										jsonObject.put("Sms_Account_Active", applicants.get(i).getSmsAccountActive());
										jsonObject.put("Practical_Drivers_Test_Comments", StringEscapeUtils.escapeJava(assignedJobApplicantLists.get(j).getPracticalDriversTestComments()));
										jsonObject.put("Practical_Drivers_Test_Complete", assignedJobApplicantLists.get(j).getPracticalDriversTestComplete());
										jsonObject.put("Mac_Labour_Interview_Comments", StringEscapeUtils.escapeJava(assignedJobApplicantLists.get(j).getMacLabourInterviewComments()));
										jsonObject.put("Mac_Lab_Interview_Complete", assignedJobApplicantLists.get(j).getMacLabInterviewComplete());
										jsonObject.put("Last_Used_Date", applicants.get(i).getLastUsedDate());
										jsonObject.put("RoadTestPassed", assignedJobApplicantLists.get(j).getRoadTestPassed());
										jsonObject.put("ParkingTestPassed", assignedJobApplicantLists.get(j).getParkingTestPassed());
										jsonObject.put("Nationality", applicants.get(i).getNationality());
										jsonObject.put("Employable", applicants.get(i).getEmployable());
										jsonObject.put("Employable_Comments", applicants.get(i).getEmployableComments());
										jsonArray.put(jsonObject);
										
									}
									
						}

	
						return jsonArray.toString();
	}
////////////////////////////////////////////////////
////////////////////////////////////////////////////

	
	
	////////
	//NEW///
	////////
	@Path("/GetApplicantsReferenceChecks")
	@GET
	@Produces("text/plain")
	public String GETAPPLICANTSReferenceChecks( ) throws Exception
	{
		
		AssignedJobApplicantDAO assignedJobApplicantDao = new AssignedJobApplicantDAO();
		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		List<MacApplicants> applicants = macApplicantDao.GetApplicantsSiteComplete();		
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < applicants.size();i++)
		{

			List<AssignedJobApplicantList> assignedJobApplicantLists = assignedJobApplicantDao.ReadAllAssignedJobsInfoByID(applicants.get(i).getIdNumber());
			
			for(int j=0; j < assignedJobApplicantLists.size(); j++)
			{
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("idMac_Applicants", applicants.get(i).getIdMacApplicants());
				jsonObject.put("Name", applicants.get(i).getName());
		    	jsonObject.put("Surname", applicants.get(i).getSurname());
				jsonObject.put("RSA_Citizen", applicants.get(i).getRsaCitizen());
				jsonObject.put("Id_Number", applicants.get(i).getIdNumber());
				jsonObject.put("Passport_Number", applicants.get(i).getPassportNumber());
				jsonObject.put("Expiry_Date_Of_Passport", applicants.get(i).getExpiryDateOfPassport());
				jsonObject.put("Work_Permit_Validity", applicants.get(i).getWorkPermitValidity());
				jsonObject.put("Cell_Number", applicants.get(i).getCellNumber());
				jsonObject.put("Telephone_Number", applicants.get(i).getTelephoneNumber());
				jsonObject.put("Job_Type", applicants.get(i).getJobType());
				jsonObject.put("Date_First_issue_license", applicants.get(i).getDateFirstIssueLicense());
				jsonObject.put("License_Code", applicants.get(i).getLicenseCode());
				jsonObject.put("Expiry_Date_Of_License", applicants.get(i).getExpiryDateOfLicense());
				jsonObject.put("PDP_Expiry_Date", applicants.get(i).getPdpExpiryDate());
				jsonObject.put("Gender", applicants.get(i).getGender());
				jsonObject.put("Physical_Address_1", applicants.get(i).getPhysicalAddress1());
				jsonObject.put("Physical_Address_2", applicants.get(i).getPhysicalAddress2());		
				jsonObject.put("Physical_Address_3", applicants.get(i).getPhysicalAddress3());
				jsonObject.put("Physical_Address_4", applicants.get(i).getPhysicalAddress4());
				jsonObject.put("City", applicants.get(i).getCity());		
				jsonObject.put("Country", applicants.get(i).getCountry());
				jsonObject.put("Tax_No", applicants.get(i).getTaxNo());
				jsonObject.put("Marital_Status", applicants.get(i).getMaritalStatus());
				jsonObject.put("Dependants", applicants.get(i).getDependants());
				jsonObject.put("Home_Language", applicants.get(i).getHomeLanguage());
				jsonObject.put("Work_History_1", applicants.get(i).getWorkHistory1());
				jsonObject.put("Work_History_2", applicants.get(i).getWorkHistory2());
				jsonObject.put("Work_History_3", applicants.get(i).getWorkHistory3());
				jsonObject.put("Work_History_4", applicants.get(i).getWorkHistory4());
				jsonObject.put("E_Mail", applicants.get(i).getEmail());
				jsonObject.put("Age", applicants.get(i).getAge());
				jsonObject.put("Date_Of_Birth", applicants.get(i).getDateOfBirth());
				jsonObject.put("Last_Sms_Date", applicants.get(i).getLastSmsDate());
				////////////////////////////////////////////////////////////////////////////
				jsonObject.put("Job_Name", assignedJobApplicantLists.get(j).getJobName());
				//////////////////////////////////////////////////////////////
				jsonObject.put("Sms_Group", applicants.get(i).getSmsGroup());
				jsonObject.put("Sms_Group_Count", applicants.get(i).getSmsGroupCount());
				jsonObject.put("Applicant_Type", applicants.get(i).getApplicantType());
				jsonObject.put("Applicant_Status", applicants.get(i).getApplicantStatus());
				jsonObject.put("Stage_In_Process",  assignedJobApplicantLists.get(j).getStageInProcess());
				jsonObject.put("Sms_Account_Active", applicants.get(i).getSmsAccountActive());
				jsonObject.put("Mac_Labour_Interview_Comments", StringEscapeUtils.escapeJava(assignedJobApplicantLists.get(j).getMacLabourInterviewComments()));
				jsonObject.put("Mac_Lab_Interview_Complete", assignedJobApplicantLists.get(j).getMacLabInterviewComplete());
				jsonObject.put("Nationality", applicants.get(i).getNationality());
				jsonObject.put("Last_Used_Date", applicants.get(i).getLastUsedDate());			
				jsonObject.put("Employable", applicants.get(i).getEmployable());
				jsonObject.put("Employable_Comments", applicants.get(i).getEmployableComments());

				jsonArray.put(jsonObject);

			}
			
			
		}
		
	    
		return jsonArray.toString();
	}
	
	
	
	
	
	
	@Path("/GetAllApplicantsSiteComplete")
	@GET
	@Produces("text/plain")
	public String GETAPPLICANTSSiteApp( ) throws Exception
	{
		
		AssignedJobApplicantDAO assignedJobApplicantDao = new AssignedJobApplicantDAO();
		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		List<MacApplicants> applicants = macApplicantDao.GetApplicantsSiteComplete();
		
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < applicants.size();i++)
		{
			List<AssignedJobApplicantList> assignedJobApplicantLists = assignedJobApplicantDao.ReadAllAssignedJobsInfoByID(applicants.get(i).getIdNumber());
			
			for(int j=0; j < assignedJobApplicantLists.size(); j++)
			{
				JSONObject jsonObject = new JSONObject();
				
				jsonObject.put("idMac_Applicants", applicants.get(i).getIdMacApplicants());
				jsonObject.put("Name", applicants.get(i).getName());
		    	jsonObject.put("Surname", applicants.get(i).getSurname());
				jsonObject.put("RSA_Citizen", applicants.get(i).getRsaCitizen());
				jsonObject.put("Id_Number", applicants.get(i).getIdNumber());
				jsonObject.put("Passport_Number", applicants.get(i).getPassportNumber());
				jsonObject.put("Expiry_Date_Of_Passport", applicants.get(i).getExpiryDateOfPassport());
				jsonObject.put("Work_Permit_Validity", applicants.get(i).getWorkPermitValidity());
				jsonObject.put("Cell_Number", applicants.get(i).getCellNumber());
				jsonObject.put("Telephone_Number", applicants.get(i).getTelephoneNumber());
				jsonObject.put("Job_Type", applicants.get(i).getJobType());
				jsonObject.put("Date_First_issue_license", applicants.get(i).getDateFirstIssueLicense());
				jsonObject.put("License_Code", applicants.get(i).getLicenseCode());
				jsonObject.put("Expiry_Date_Of_License", applicants.get(i).getExpiryDateOfLicense());
				jsonObject.put("PDP_Expiry_Date", applicants.get(i).getPdpExpiryDate());
				jsonObject.put("Gender", applicants.get(i).getGender());
				jsonObject.put("Physical_Address_1", applicants.get(i).getPhysicalAddress1());
				jsonObject.put("Physical_Address_2", applicants.get(i).getPhysicalAddress2());		
				jsonObject.put("Physical_Address_3", applicants.get(i).getPhysicalAddress3());
				jsonObject.put("Physical_Address_4", applicants.get(i).getPhysicalAddress4());
				jsonObject.put("City", applicants.get(i).getCity());		
				jsonObject.put("Country", applicants.get(i).getCountry());
				jsonObject.put("Tax_No", applicants.get(i).getTaxNo());
				jsonObject.put("Marital_Status", applicants.get(i).getMaritalStatus());
				jsonObject.put("Dependants", applicants.get(i).getDependants());
				jsonObject.put("Home_Language", applicants.get(i).getHomeLanguage());
				jsonObject.put("Work_History_1", applicants.get(i).getWorkHistory1());
				jsonObject.put("Work_History_2", applicants.get(i).getWorkHistory2());
				jsonObject.put("Work_History_3", applicants.get(i).getWorkHistory3());
				jsonObject.put("Work_History_4", applicants.get(i).getWorkHistory4());
				jsonObject.put("E_Mail", applicants.get(i).getEmail());
				jsonObject.put("Age", applicants.get(i).getAge());
				jsonObject.put("Date_Of_Birth", applicants.get(i).getDateOfBirth());
				jsonObject.put("Last_Sms_Date", applicants.get(i).getLastSmsDate());
				////////////////////////////////////////////////////////////////////////////
				jsonObject.put("Job_Name", assignedJobApplicantLists.get(j).getJobName());
				//////////////////////////////////////////////////////////////		
				jsonObject.put("Sms_Group", applicants.get(i).getSmsGroup());
				jsonObject.put("Sms_Group_Count", applicants.get(i).getSmsGroupCount());
				jsonObject.put("Applicant_Type", applicants.get(i).getApplicantType());
				jsonObject.put("Applicant_Status", applicants.get(i).getApplicantStatus());
				jsonObject.put("Stage_In_Process",  assignedJobApplicantLists.get(j).getStageInProcess());
				jsonObject.put("Sms_Account_Active", applicants.get(i).getSmsAccountActive());				
				jsonObject.put("Mac_Labour_Interview_Comments",  StringEscapeUtils.escapeJava(assignedJobApplicantLists.get(j).getMacLabourInterviewComments()));
				jsonObject.put("Mac_Lab_Interview_Complete", assignedJobApplicantLists.get(j).getMacLabInterviewComplete());			
				jsonObject.put("Nationality", applicants.get(i).getNationality());
				jsonObject.put("Last_Used_Date", applicants.get(i).getLastUsedDate());
				jsonObject.put("Employable", applicants.get(i).getEmployable());
				jsonObject.put("Employable_Comments", applicants.get(i).getEmployableComments());
	
				jsonArray.put(jsonObject);

			}
			
			
		}
		
	    
		return jsonArray.toString();
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////OLD///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////
	@Path("/GetAllApplicantsClientInterview")
	@GET
	@Produces("text/plain")
	public String GETAPPLICANTSClientInterview( ) throws Exception
	{
		
		MacApplicantDAO Object  = new MacApplicantDAO();
		
		List<MacApplicants> Applicants = Object.GetApplicantsDriversComplete();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", Applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", Applicants.get(i).getName());
			jsonObject.put("Job_Name", Applicants.get(i).getJobName());
			jsonObject.put("Surname", Applicants.get(i).getSurname());
			jsonObject.put("RSA_Citizen", Applicants.get(i).getRsaCitizen());
			jsonObject.put("Id_Number", Applicants.get(i).getIdNumber());
			jsonObject.put("Passport_Number", Applicants.get(i).getPassportNumber());
			jsonObject.put("Expiry_Date_Of_Passport", Applicants.get(i).getExpiryDateOfPassport());
			jsonObject.put("Work_Permit_Validity", Applicants.get(i).getWorkPermitValidity());
			jsonObject.put("Cell_Number", Applicants.get(i).getCellNumber());
			jsonObject.put("Telephone_Number", Applicants.get(i).getTelephoneNumber());
			jsonObject.put("Job_Type", Applicants.get(i).getJobType());
			jsonObject.put("Date_First_issue_license", Applicants.get(i).getDateFirstIssueLicense());
			jsonObject.put("License_Code", Applicants.get(i).getLicenseCode());
			jsonObject.put("Expiry_Date_Of_License", Applicants.get(i).getExpiryDateOfLicense());
			jsonObject.put("PDP_Expiry_Date", Applicants.get(i).getPdpExpiryDate());
			jsonObject.put("Gender", Applicants.get(i).getGender());
			jsonObject.put("Physical_Address_1", Applicants.get(i).getPhysicalAddress1());
			jsonObject.put("Physical_Address_2", Applicants.get(i).getPhysicalAddress2());		
			jsonObject.put("Physical_Address_3", Applicants.get(i).getPhysicalAddress3());
			jsonObject.put("Physical_Address_4", Applicants.get(i).getPhysicalAddress4());
			jsonObject.put("City", Applicants.get(i).getCity());		
			jsonObject.put("Country", Applicants.get(i).getCountry());
			jsonObject.put("Tax_No", Applicants.get(i).getTaxNo());
			jsonObject.put("Marital_Status", Applicants.get(i).getMaritalStatus());
			jsonObject.put("Dependants", Applicants.get(i).getDependants());
			jsonObject.put("Home_Language", Applicants.get(i).getHomeLanguage());
			jsonObject.put("Work_History_1", Applicants.get(i).getWorkHistory1());
			jsonObject.put("Work_History_2", Applicants.get(i).getWorkHistory2());
			jsonObject.put("Work_History_3", Applicants.get(i).getWorkHistory3());
			jsonObject.put("Work_History_4", Applicants.get(i).getWorkHistory4());
			jsonObject.put("E_Mail", Applicants.get(i).getEmail());
			jsonObject.put("Age", Applicants.get(i).getAge());
			jsonObject.put("Date_Of_Birth", Applicants.get(i).getDateOfBirth());
			jsonObject.put("Last_Sms_Date", Applicants.get(i).getLastSmsDate());
			jsonObject.put("Job_Name", Applicants.get(i).getJobName());
			jsonObject.put("Sms_Group", Applicants.get(i).getSmsGroup());
			jsonObject.put("Sms_Group_Count", Applicants.get(i).getSmsGroupCount());
			jsonObject.put("Applicant_Type", Applicants.get(i).getApplicantType());
			jsonObject.put("Applicant_Status", Applicants.get(i).getApplicantStatus());
			
			jsonObject.put("Client_Interview_Comments", StringEscapeUtils.escapeJava(Applicants.get(i).getClientInterviewComments()));
			jsonObject.put("Client_Interview_Complete", Applicants.get(i).getClientInterviewComplete());
			jsonObject.put("Stage_In_Process", Applicants.get(i).getStageInTheProcess());
			jsonObject.put("Sms_Account_Active", Applicants.get(i).getSmsAccountActive());
			
			
			
			jsonObject.put("Nationality", Applicants.get(i).getNationality());
			jsonObject.put("Last_Used_Date", Applicants.get(i).getLastUsedDate());
			
			jsonObject.put("Employable", Applicants.get(i).getEmployable());
			jsonObject.put("Employable_Comments", Applicants.get(i).getEmployableComments());
			
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
	    
		return JsonArray.toString();
	}
	////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////New///////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////
	@Path("/GetAllApplicantsClientInterviewNew")
	@GET
	@Produces("text/plain")
	public String GETAPPLICANTSClientInterviewNEw( ) throws Exception
	{
		
		AssignedJobApplicantDAO assignedJobApplicantDao = new AssignedJobApplicantDAO();
		
	
		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		List<MacApplicants> applicants = macApplicantDao.GetApplicantsDriversCompleteNew();
		JSONArray jsonArray = new JSONArray();
	
		for(int i = 0; i < applicants.size();i++)
		{
			
			List<AssignedJobApplicantList> assignedJobApplicantLists = assignedJobApplicantDao.ReadAllAssignedJobsInfoByID(applicants.get(i).getIdNumber());
			
			for(int j=0; j < assignedJobApplicantLists.size(); j++)
			{
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("idMac_Applicants", applicants.get(i).getIdMacApplicants());
				jsonObject.put("Name", applicants.get(i).getName());
				jsonObject.put("Job_Name", applicants.get(i).getJobName());
				jsonObject.put("Surname", applicants.get(i).getSurname());
				jsonObject.put("RSA_Citizen", applicants.get(i).getRsaCitizen());
				jsonObject.put("Id_Number", applicants.get(i).getIdNumber());
				jsonObject.put("Passport_Number", applicants.get(i).getPassportNumber());
				jsonObject.put("Expiry_Date_Of_Passport", applicants.get(i).getExpiryDateOfPassport());
				jsonObject.put("Work_Permit_Validity", applicants.get(i).getWorkPermitValidity());
				jsonObject.put("Cell_Number", applicants.get(i).getCellNumber());
				jsonObject.put("Telephone_Number", applicants.get(i).getTelephoneNumber());
				jsonObject.put("Job_Type", applicants.get(i).getJobType());
				jsonObject.put("Date_First_issue_license", applicants.get(i).getDateFirstIssueLicense());
				jsonObject.put("License_Code", applicants.get(i).getLicenseCode());
				jsonObject.put("Expiry_Date_Of_License", applicants.get(i).getExpiryDateOfLicense());
				jsonObject.put("PDP_Expiry_Date", applicants.get(i).getPdpExpiryDate());
				jsonObject.put("Gender", applicants.get(i).getGender());
				jsonObject.put("Physical_Address_1", applicants.get(i).getPhysicalAddress1());
				jsonObject.put("Physical_Address_2", applicants.get(i).getPhysicalAddress2());		
				jsonObject.put("Physical_Address_3", applicants.get(i).getPhysicalAddress3());
				jsonObject.put("Physical_Address_4", applicants.get(i).getPhysicalAddress4());
				jsonObject.put("City", applicants.get(i).getCity());		
				jsonObject.put("Country", applicants.get(i).getCountry());
				jsonObject.put("Tax_No", applicants.get(i).getTaxNo());
				jsonObject.put("Marital_Status", applicants.get(i).getMaritalStatus());
				jsonObject.put("Dependants", applicants.get(i).getDependants());
				jsonObject.put("Home_Language", applicants.get(i).getHomeLanguage());
				jsonObject.put("Work_History_1", applicants.get(i).getWorkHistory1());
				jsonObject.put("Work_History_2", applicants.get(i).getWorkHistory2());
				jsonObject.put("Work_History_3", applicants.get(i).getWorkHistory3());
				jsonObject.put("Work_History_4", applicants.get(i).getWorkHistory4());
				jsonObject.put("E_Mail", applicants.get(i).getEmail());
				jsonObject.put("Age", applicants.get(i).getAge());
				jsonObject.put("Date_Of_Birth", applicants.get(i).getDateOfBirth());
				jsonObject.put("Last_Sms_Date", applicants.get(i).getLastSmsDate());
				////////////////////////////////////////////////////////////////////////////
				jsonObject.put("Job_Name", assignedJobApplicantLists.get(j).getJobName());
				//////////////////////////////////////////////////////////////
				jsonObject.put("Sms_Group", applicants.get(i).getSmsGroup());
				jsonObject.put("Sms_Group_Count", applicants.get(i).getSmsGroupCount());
				jsonObject.put("Applicant_Type", applicants.get(i).getApplicantType());
				jsonObject.put("Applicant_Status", applicants.get(i).getApplicantStatus());
				jsonObject.put("Client_Interview_Comments", StringEscapeUtils.escapeJava(assignedJobApplicantLists.get(j).getClientInterviewComments()));
				jsonObject.put("Client_Interview_Complete", assignedJobApplicantLists.get(j).getClientInterviewComplete());
				jsonObject.put("Stage_In_Process", assignedJobApplicantLists.get(j).getStageInProcess());
				jsonObject.put("Sms_Account_Active", applicants.get(i).getSmsAccountActive());
				jsonObject.put("Practical_Drivers_Test_Comments", StringEscapeUtils.escapeJava(assignedJobApplicantLists.get(j).getPracticalDriversTestComments()));
				jsonObject.put("Practical_Drivers_Test_Complete", assignedJobApplicantLists.get(j).getPracticalDriversTestComplete());
				jsonObject.put("Nationality", applicants.get(i).getNationality());
				jsonObject.put("Last_Used_Date", applicants.get(i).getLastUsedDate());
				jsonObject.put("Employable", applicants.get(i).getEmployable());
				jsonObject.put("Employable_Comments", applicants.get(i).getEmployableComments());
		
		
				jsonArray.put(jsonObject);
			}
			
		}
	
	
		return jsonArray.toString();
	}
	
	
	
	
	@Path("/GetAllApplicantsReferencecheck")
	@GET
	@Produces("text/plain")
	public String GETAPPLICANTReferencecheck( ) throws Exception
	{
		
		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		List<MacApplicants> applicants = macApplicantDao.GetApplicantsReferenceCheck();
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", applicants.get(i).getName());
			jsonObject.put("Surname", applicants.get(i).getSurname());
			jsonObject.put("Job_Name", applicants.get(i).getJobName());
			jsonObject.put("RSA_Citizen", applicants.get(i).getRsaCitizen());
			jsonObject.put("Id_Number", applicants.get(i).getIdNumber());
			jsonObject.put("Passport_Number", applicants.get(i).getPassportNumber());
			jsonObject.put("Expiry_Date_Of_Passport", applicants.get(i).getExpiryDateOfPassport());
			jsonObject.put("Work_Permit_Validity", applicants.get(i).getWorkPermitValidity());
			jsonObject.put("Cell_Number", applicants.get(i).getCellNumber());
			jsonObject.put("Telephone_Number", applicants.get(i).getTelephoneNumber());
			jsonObject.put("Job_Type", applicants.get(i).getJobType());
			jsonObject.put("Date_First_issue_license", applicants.get(i).getDateFirstIssueLicense());
			jsonObject.put("License_Code", applicants.get(i).getLicenseCode());
			jsonObject.put("Expiry_Date_Of_License", applicants.get(i).getExpiryDateOfLicense());
			jsonObject.put("PDP_Expiry_Date", applicants.get(i).getPdpExpiryDate());
			jsonObject.put("Gender", applicants.get(i).getGender());
			jsonObject.put("Physical_Address_1", applicants.get(i).getPhysicalAddress1());
			jsonObject.put("Physical_Address_2", applicants.get(i).getPhysicalAddress2());		
			jsonObject.put("Physical_Address_3", applicants.get(i).getPhysicalAddress3());
			jsonObject.put("Physical_Address_4", applicants.get(i).getPhysicalAddress4());
			jsonObject.put("City", applicants.get(i).getCity());		
			jsonObject.put("Country", applicants.get(i).getCountry());
			jsonObject.put("Tax_No", applicants.get(i).getTaxNo());
			jsonObject.put("Marital_Status", applicants.get(i).getMaritalStatus());
			jsonObject.put("Dependants", applicants.get(i).getDependants());
			jsonObject.put("Home_Language", applicants.get(i).getHomeLanguage());
			jsonObject.put("Work_History_1", applicants.get(i).getWorkHistory1());
			jsonObject.put("Work_History_2", applicants.get(i).getWorkHistory2());
			jsonObject.put("Work_History_3", applicants.get(i).getWorkHistory3());
			jsonObject.put("Work_History_4", applicants.get(i).getWorkHistory4());
			jsonObject.put("E_Mail", applicants.get(i).getEmail());
			jsonObject.put("Age", applicants.get(i).getAge());
			jsonObject.put("Date_Of_Birth", applicants.get(i).getDateOfBirth());
			jsonObject.put("Last_Sms_Date", applicants.get(i).getLastSmsDate());
			jsonObject.put("Job_Name", applicants.get(i).getJobName());
			jsonObject.put("Sms_Group", applicants.get(i).getSmsGroup());
			jsonObject.put("Sms_Group_Count", applicants.get(i).getSmsGroupCount());
			jsonObject.put("Applicant_Type", applicants.get(i).getApplicantType());
			jsonObject.put("Applicant_Status", applicants.get(i).getApplicantStatus());
			jsonObject.put("Reference_Checks_Comments", StringEscapeUtils.escapeJava(applicants.get(i).getReferenceChecksComments()));
			jsonObject.put("Reference_Checks_Complete", applicants.get(i).getReferenceChecksComplete());
			jsonObject.put("Stage_In_Process", applicants.get(i).getStageInTheProcess());
			jsonObject.put("Sms_Account_Active", applicants.get(i).getSmsAccountActive());
			jsonObject.put("Nationality", applicants.get(i).getNationality());
			jsonObject.put("Last_Used_Date", applicants.get(i).getLastUsedDate());
			jsonObject.put("Employable", applicants.get(i).getEmployable());
			jsonObject.put("Employable_Comments", applicants.get(i).getEmployableComments());
			
			jsonArray.put(jsonObject);
		}


		return jsonArray.toString();
	}
	
	@Path("/UpdateApplicantInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String update(String jsonTextObject) throws JSONException
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
				
		MacApplicantDAO macApplicantDAO = new MacApplicantDAO();
		JSONObject jsonObject = new JSONObject(jsonTextObject);

		MacApplicants applicant  = macApplicantDAO.getClientApplicantoById(Integer.parseInt(jsonObject.getString("idMac_Applicants")));
		
		applicant.setName(jsonObject.getString("Name"));
		applicant.setSurname(jsonObject.getString("Surname"));
		applicant.setRsaCitizen(jsonObject.getString("RSA_Citizen"));
		applicant.setIdNumber(jsonObject.getString("Id_Number"));
		applicant.setPassportNumber(jsonObject.getString("Passport_Number"));
		applicant.setExpiryDateOfPassport(jsonObject.getString("Expiry_Date_Of_Passport"));
		applicant.setWorkPermitValidity(jsonObject.getString("Work_Permit_Validity"));
		applicant.setCellNumber(jsonObject.getString("Cell_Number"));
		applicant.setTelephoneNumber(jsonObject.getString("Telephone_Number"));
		applicant.setJobType(jsonObject.getString("Job_Type"));
		applicant.setDateFirstIssueLicense(jsonObject.getString("Date_First_issue_license"));
		applicant.setLicenseCode(jsonObject.getString("License_Code"));
		applicant.setExpiryDateOfLicense(jsonObject.getString("Expiry_Date_Of_License"));
		applicant.setPdpExpiryDate(jsonObject.getString("PDP_Expiry_Date"));
		applicant.setGender(jsonObject.getString("Gender"));
		applicant.setPhysicalAddress1(jsonObject.getString("Physical_Address_1"));
		applicant.setPhysicalAddress2(jsonObject.getString("Physical_Address_2"));
		applicant.setPhysicalAddress3(jsonObject.getString("Physical_Address_3"));
		applicant.setPhysicalAddress4(jsonObject.getString("Physical_Address_4"));
		applicant.setCity(jsonObject.getString("City"));
		applicant.setCountry(jsonObject.getString("Country"));
		applicant.setTaxNo(jsonObject.getString("Tax_No"));
		applicant.setMaritalStatus(jsonObject.getString("Marital_Status"));
		applicant.setDependants(jsonObject.getString("Dependants"));
		applicant.setHomeLanguage(jsonObject.getString("Home_Language"));
		applicant.setApplicantType("Normal");
		applicant.setApplicantStatus("Recently Updated Details on System");
		applicant.setEmail(jsonObject.getString("E_Mail"));
		applicant.setAge(Integer.parseInt(jsonObject.getString("Age")));
		applicant.setDateOfBirth(jsonObject.getString("Date_Of_Birth"));
		applicant.setApplicantStatus(jsonObject.getString("Applicant_Status"));
		applicant.setSmsGroup(jsonObject.getString("Sms_Group"));
		applicant.setStageInTheProcess("Recently Updated Details on System");
		applicant.setApplicantType(jsonObject.getString("Applicant_Type"));
		applicant.setLastSmsDate(jsonObject.getString("Last_Sms_Date"));
		applicant.setNationality(jsonObject.getString("Nationality"));
		applicant.setmacLabInterviewComplete(jsonObject.getString("Mac_Labour_Interview_Complete"));
		applicant.setmacLabourInterviewComments(jsonObject.getString("Mac_Labour_Interview_Comments"));
		applicant.setSmsGroupCount(Integer.parseInt(jsonObject.getString("Sms_Group_Count")));
		applicant.setPracticalDriversTestComplete(jsonObject.getString("Practical_Drivers_Test_Complete"));
		applicant.setPracticalDriversTestComments(jsonObject.getString("Practical_Drivers_Test_Comments"));
		applicant.setClientInterviewComments(jsonObject.getString("Client_Interview_Comments"));
		applicant.setClientInterviewComplete(jsonObject.getString("Client_Interview_Complete"));
		applicant.setReferenceChecksComments(jsonObject.getString("Reference_Checks_Comments"));
		applicant.setReferenceChecksComplete(jsonObject.getString("Reference_Checks_Complete"));
		applicant.setLastUsedDate(dateFormat.format(date));
			
		macApplicantDAO.update(applicant);

		return "Successful";
	}
	
	
	@Path("/SaveApplicantInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		JSONObject jsonObject = new JSONObject(jsonTextObject);	
		String Flag = jsonObject.getString("Flag");
		MacApplicantDAO Object  = new MacApplicantDAO();
		
		if(Flag.equals("0")|| Flag.equals("2"))
		{
			
			Object.AddAppicantInformation(jsonObject.getString("Name"), jsonObject.getString("Surname"), jsonObject.getString("RSA_Citizen"), jsonObject.getString("Id_Number"),jsonObject.getString("Passport_Number"),jsonObject.getString("Expiry_Date_Of_Passport"), jsonObject.getString("Work_Permit_Validity"), jsonObject.getString("Cell_Number"), jsonObject.getString("Telephone_Number"), jsonObject.getString("Job_Type"), jsonObject.getString("Date_First_issue_license"), jsonObject.getString("License_Code"), jsonObject.getString("Expiry_Date_Of_License"), jsonObject.getString("PDP_Expiry_Date"), jsonObject.getString("Gender"), jsonObject.getString("Physical_Address_1"), jsonObject.getString("Physical_Address_2"), jsonObject.getString("Physical_Address_3"), jsonObject.getString("Physical_Address_4"),jsonObject.getString("City"),jsonObject.getString("Country"),jsonObject.getString("Tax_No"), jsonObject.getString("Marital_Status"), jsonObject.getString("Dependants"), jsonObject.getString("Home_Language"), jsonObject.getString("Work_History_1"), jsonObject.getString("Work_History_2"), jsonObject.getString("Work_History_3"), jsonObject.getString("Work_History_1"), jsonObject.getString("E_Mail"), jsonObject.getInt("Age"), jsonObject.getString("Date_Of_Birth"), jsonObject.getString("Last_Sms_Date"), jsonObject.getString("Job_Name"), jsonObject.getString("Stage_In_Process"),"New",jsonObject.getString("Applicant_Type"),jsonObject.getString("Sms_Group"),jsonObject.getString("Nationality"));
			
			
		}
		else if(Flag.equals("1"))
		{
			
			MacApplicants Applicant = Object.getClientApplicantoById(jsonObject.getInt("idMac_Applicants"));
			Applicant.setName(jsonObject.getString("Name"));
			Applicant.setSurname(jsonObject.getString("Surname"));
			Applicant.setRsaCitizen(jsonObject.getString("RSA_Citizen"));
			Applicant.setIdNumber(jsonObject.getString("Id_Number"));
			Applicant.setPassportNumber(jsonObject.getString("Passport_Number"));
			Applicant.setExpiryDateOfPassport(jsonObject.getString("Expiry_Date_Of_Passport"));
			Applicant.setWorkPermitValidity(jsonObject.getString("Work_Permit_Validity"));
			Applicant.setCellNumber(jsonObject.getString("Cell_Number"));
			Applicant.setTelephoneNumber(jsonObject.getString("Telephone_Number"));
			Applicant.setJobType(jsonObject.getString("Job_Type"));
			Applicant.setDateFirstIssueLicense(jsonObject.getString("Date_First_issue_license"));
			Applicant.setLicenseCode(jsonObject.getString("License_Code"));
			Applicant.setExpiryDateOfLicense(jsonObject.getString("Expiry_Date_Of_License"));
			Applicant.setPdpExpiryDate(jsonObject.getString("PDP_Expiry_Date"));
			Applicant.setGender(jsonObject.getString("Gender"));
			Applicant.setPhysicalAddress1(jsonObject.getString("Physical_Address_1"));
			Applicant.setPhysicalAddress2(jsonObject.getString("Physical_Address_2"));
			Applicant.setPhysicalAddress3(jsonObject.getString("Physical_Address_3"));
			Applicant.setPhysicalAddress4(jsonObject.getString("Physical_Address_4"));
			Applicant.setCity(jsonObject.getString("City"));
			Applicant.setCountry(jsonObject.getString("Country"));
			Applicant.setTaxNo(jsonObject.getString("Tax_No"));
			Applicant.setMaritalStatus(jsonObject.getString("Marital_Status"));
			Applicant.setDependants(jsonObject.getString("Dependants"));
			Applicant.setHomeLanguage(jsonObject.getString("Home_Language"));
			Applicant.setEmail(jsonObject.getString("E_Mail"));
			Applicant.setAge(jsonObject.getInt("Age"));
			Applicant.setDateOfBirth(jsonObject.getString("Date_Of_Birth"));
			Applicant.setJobName(jsonObject.getString("Job_Name"));
			
			Applicant.setStageInTheProcess(jsonObject.getString("Stage_In_Process"));
			Applicant.setApplicantType("New");
			
			/*Applicant.setApplicantStatus("New");*/
			Applicant.setSmsAccountActive("Yes");
			Applicant.setLastUsedDate(dateFormat.format(date));
			
						
			Object.update(Applicant);
			
		}
		
		
		return "Sucessful";	
		
			
	}
	
	
	@Path("/SaveApplicantInfoApplicantSite")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String assignApplicant(String jsonTextObject) throws JSONException
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		JSONObject jsonObject = new JSONObject(jsonTextObject);	
	    String Flag = jsonObject.getString("Flag");
		MacApplicantDAO macApplicantDAO  = new MacApplicantDAO();
		AssignedJobApplicantDAO assignJobApplicantDao = new AssignedJobApplicantDAO();
		
		if(Flag.equals("0")|| Flag.equals("2"))
		{
		
			macApplicantDAO.AddAppicantInformation(jsonObject.getString("Name"), jsonObject.getString("Surname"), jsonObject.getString("RSA_Citizen"), jsonObject.getString("Id_Number"),jsonObject.getString("Passport_Number"),jsonObject.getString("Expiry_Date_Of_Passport"), jsonObject.getString("Work_Permit_Validity"), jsonObject.getString("Cell_Number"), jsonObject.getString("Telephone_Number"), jsonObject.getString("Job_Type"), jsonObject.getString("Date_First_issue_license"), jsonObject.getString("License_Code"), jsonObject.getString("Expiry_Date_Of_License"), jsonObject.getString("PDP_Expiry_Date"), jsonObject.getString("Gender"),jsonObject.getString("Physical_Address_1"), jsonObject.getString("Physical_Address_2"), jsonObject.getString("Physical_Address_3"), jsonObject.getString("Physical_Address_4"),jsonObject.getString("City"),jsonObject.getString("Country"),jsonObject.getString("Tax_No"), jsonObject.getString("Marital_Status"), jsonObject.getString("Dependants"), jsonObject.getString("Home_Language"), jsonObject.getString("Work_History_1"), jsonObject.getString("Work_History_2"),jsonObject.getString("Work_History_3"), jsonObject.getString("Work_History_1"), jsonObject.getString("E_Mail"), jsonObject.getInt("Age"),jsonObject.getString("Date_Of_Birth"), jsonObject.getString("Last_Sms_Date"), jsonObject.getString("Job_Name"), jsonObject.getString("Stage_In_Process"),"New",jsonObject.getString("Applicant_Type"),jsonObject.getString("Sms_Group"),jsonObject.getString("Nationality"));
			assignJobApplicantDao.AddAssignedJob(jsonObject.getString("Job_Name"), jsonObject.getString("Id_Number"));
			
		}
		else if(Flag.equals("1"))
		{
			
			MacApplicants applicant = macApplicantDAO.getClientApplicantoById(jsonObject.getInt("idMac_Applicants"));
			applicant.setName(jsonObject.getString("Name"));
			applicant.setSurname(jsonObject.getString("Surname"));
			applicant.setRsaCitizen(jsonObject.getString("RSA_Citizen"));
			applicant.setIdNumber(jsonObject.getString("Id_Number"));
			applicant.setPassportNumber(jsonObject.getString("Passport_Number"));
			applicant.setExpiryDateOfPassport(jsonObject.getString("Expiry_Date_Of_Passport"));
			applicant.setWorkPermitValidity(jsonObject.getString("Work_Permit_Validity"));
			applicant.setCellNumber(jsonObject.getString("Cell_Number"));
			applicant.setTelephoneNumber(jsonObject.getString("Telephone_Number"));
			applicant.setJobType(jsonObject.getString("Job_Type"));
			applicant.setDateFirstIssueLicense(jsonObject.getString("Date_First_issue_license"));
			applicant.setLicenseCode(jsonObject.getString("License_Code"));
			applicant.setExpiryDateOfLicense(jsonObject.getString("Expiry_Date_Of_License"));
			applicant.setPdpExpiryDate(jsonObject.getString("PDP_Expiry_Date"));
			applicant.setGender(jsonObject.getString("Gender"));
			applicant.setPhysicalAddress1(jsonObject.getString("Physical_Address_1"));
			applicant.setPhysicalAddress2(jsonObject.getString("Physical_Address_2"));
			applicant.setPhysicalAddress3(jsonObject.getString("Physical_Address_3"));
			applicant.setPhysicalAddress4(jsonObject.getString("Physical_Address_4"));
			applicant.setCity(jsonObject.getString("City"));
			applicant.setCountry(jsonObject.getString("Country"));
			applicant.setTaxNo(jsonObject.getString("Tax_No"));
			applicant.setMaritalStatus(jsonObject.getString("Marital_Status"));
			applicant.setDependants(jsonObject.getString("Dependants"));
			applicant.setHomeLanguage(jsonObject.getString("Home_Language"));
			applicant.setEmail(jsonObject.getString("E_Mail"));
			applicant.setAge(jsonObject.getInt("Age"));
			applicant.setDateOfBirth(jsonObject.getString("Date_Of_Birth"));
			applicant.setJobName(jsonObject.getString("Job_Name"));
			applicant.setStageInTheProcess(jsonObject.getString("Stage_In_Process"));
			applicant.setApplicantType(jsonObject.getString("Applicant_Type"));
			applicant.setApplicantStatus("New");
			applicant.setSmsAccountActive("Yes");
			applicant.setLastUsedDate(dateFormat.format(date));
			macApplicantDAO.update(applicant);
		
			assignJobApplicantDao.AddAssignedJob(jsonObject.getString("Job_Name"), jsonObject.getString("Id_Number"));	
		}
		
		
		return "Sucessful";	
		
			
	}
	
	
	
	@Path("/SavePermanentInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String createPermanent(String jsonTextObject) throws JSONException
	{
		JSONObject jsonObject = new JSONObject(jsonTextObject);	

		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		macApplicantDao.AddPermanentInformation(jsonObject.getString("Name"), jsonObject.getString("Surname"), jsonObject.getString("RSA_Citizen"), jsonObject.getString("Id_Number"),jsonObject.getString("Passport_Number"),jsonObject.getString("Expiry_Date_Of_Passport"),jsonObject.getString("Work_Permit_Validity"), jsonObject.getString("Cell_Number"), jsonObject.getString("Telephone_Number"), jsonObject.getString("Job_Type"),jsonObject.getString("Date_First_issue_license"), jsonObject.getString("License_Code"), jsonObject.getString("Expiry_Date_Of_License"), jsonObject.getString("PDP_Expiry_Date"), jsonObject.getString("Gender"), jsonObject.getString("Physical_Address_1"),jsonObject.getString("Physical_Address_2"), jsonObject.getString("Physical_Address_3"), jsonObject.getString("Physical_Address_4"),jsonObject.getString("City"),jsonObject.getString("Country"),jsonObject.getString("Tax_No"), jsonObject.getString("Marital_Status"), jsonObject.getString("Dependants"),jsonObject.getString("Home_Language"), jsonObject.getString("Work_History_1"), jsonObject.getString("Work_History_2"), jsonObject.getString("Work_History_3"), jsonObject.getString("Work_History_1"), jsonObject.getString("E_Mail"), jsonObject.getInt("Age"), jsonObject.getString("Date_Of_Birth"), jsonObject.getString("Last_Sms_Date"), jsonObject.getString("Job_Name"), "Applicant recently added On Harlequin.","New", jsonObject.getString("Applicant_Type"));
			
		return "Sucessful";		
	}
	
	
	@Path("/SaveLandApplicantInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String createL(String jsonTextObject) throws JSONException
	{
		JSONObject jsonObject = new JSONObject(jsonTextObject);	
		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		macApplicantDao.AddAppicantInformation(jsonObject.getString("Name"), jsonObject.getString("Surname"), jsonObject.getString("Id_Number"), jsonObject.getString("Cell_Number"), jsonObject.getString("Job_Type"), jsonObject.getString("E_Mail"),0);
		
		return "Sucessful";	
			
	}
	
	@Path("/UpdateMacLabourInterview")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String UpdateMacInterview(String jsonTextObject) throws JSONException
	{

		JSONObject jsonObject = new JSONObject(jsonTextObject);	
		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		//Object.UpdateAppplicantMacLabourById(Integer.parseInt(r.getString("idMac_Applicants")), r.getString("Formal_Interview_Complete"), r.getString("Interview_Comments"));
		macApplicantDao.UpdateAppplicantMacLabourByIdJobName(Integer.parseInt(jsonObject.getString("idMac_Applicants")), jsonObject.getString("Formal_Interview_Complete"), GeneralHelpUtility.escapeMetaCharacters(jsonObject.getString("Interview_Comments")), jsonObject.getString("Job_Name"),jsonObject.getString("Id_Number"));
		
		return "Sucessful";	
	}
	
	
	
	
	@Path("/UpdateApplicantSmsDate")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String Update(String jsonTextObject) throws JSONException
	{
		
		JSONObject jsonObject = new JSONObject(jsonTextObject);	
		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		macApplicantDao.UpdateAppplicantLastSmsDateById(jsonObject.getInt("idMac_Applicants"),"None",0);
			
		return "Sucessful";	
	}
	
	
	
	@Path("/UpdateApplicantEmployable/{idMac_Applicants}/{Employable}/{EmployableComments}")
	@GET
	@Produces("text/plain")
	public  String UpdateEmployable(@PathParam("idMac_Applicants") int idMac_Applicants,@PathParam("Employable") String Employable,@PathParam("EmployableComments") String EmployableComments) throws JSONException
	{

		MacApplicantDAO macApplicantDao = new MacApplicantDAO();
		macApplicantDao.UpdateAppplicantEmpoyableId(idMac_Applicants, Employable, EmployableComments);

		return "Sucessful";	
	
	}

}

