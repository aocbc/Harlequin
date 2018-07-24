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
import aoc.Harlequin.DAOs.MacApplicantDAO;
import aoc.Harlequin.DAOs.SystemUserDAO;
import aoc.Harlequin.OBJs.AssignedJobApplicantList;
import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemUser;

@Path("Applicant")
public class MacApplicantService {
	
	
	
	@Path("/MarkApplicantInactiveActive/{idMac_Applicants}/{Sms_Account_Active}")
	@GET
	@Produces("text/plain")
	public String MarkApplicantInactiveActive( @PathParam("idMac_Applicants") int idMac_Applicants, @PathParam("Sms_Account_Active") String Sms_Account_Active ) throws Exception
	{
		
		System.out.println("ID:"+idMac_Applicants+","+Sms_Account_Active);
		
		MacApplicantDAO Object  = new MacApplicantDAO();
		MacApplicants Applicant  = Object.getClientApplicantoById(idMac_Applicants);
		
		System.out.println("Name:"+Applicant.getName());
		
		
		Applicant.setSmsAccountActive(Sms_Account_Active);
		
		
		Object.update(Applicant);
		
		
		
		
		
		
		return "Applicant Inactive";
	}
	
	
	
	@Path("/GetApplicantInfo")
	@GET
	@Produces("text/plain")
	public String GET( ) throws Exception
	{
		
		MacApplicantDAO Object  = new MacApplicantDAO();
		MacApplicants Applicant  = Object.getClientApplicantoById(1);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("idMac_Applicants", Applicant.getIdMacApplicants() );
		jsonObject.put("Name", Applicant.getName());
		jsonObject.put("Surname", Applicant.getSurname());
		jsonObject.put("RSA_Citizen", Applicant.getRsaCitizen());
		jsonObject.put("Id_Number", Applicant.getIdNumber());	
		jsonObject.put("Passport_Number", Applicant.getPassportNumber());
		jsonObject.put("Expiry_Date_Of_Passport", Applicant.getExpiryDateOfPassport());
		jsonObject.put("Work_Permit_Validity", Applicant.getWorkPermitValidity());
		jsonObject.put("Cell_Number", Applicant.getCellNumber());
		jsonObject.put("Telephone_Number", Applicant.getTelephoneNumber());
		jsonObject.put("Job_Type", Applicant.getJobType());
		jsonObject.put("Date_First_issue_license", Applicant.getDateFirstIssueLicense());
		jsonObject.put("License_Code", Applicant.getLicenseCode());
		
		jsonObject.put("Expiry_Date_Of_License", Applicant.getExpiryDateOfLicense());
		jsonObject.put("PDP_Expiry_Date", Applicant.getPdpExpiryDate());
		jsonObject.put("Gender", Applicant.getGender());
		jsonObject.put("Physical_Address_1", Applicant.getPhysicalAddress1());
		jsonObject.put("Physical_Address_2", Applicant.getPhysicalAddress2());		
		jsonObject.put("Physical_Address_3", Applicant.getPhysicalAddress3());
		jsonObject.put("Physical_Address_4", Applicant.getPhysicalAddress4());
		
		jsonObject.put("City", Applicant.getCity());		
		jsonObject.put("Country", Applicant.getCountry());
		jsonObject.put("Tax_No", Applicant.getTaxNo());
		
		jsonObject.put("Marital_Status", Applicant.getMaritalStatus());
		jsonObject.put("Dependants", Applicant.getDependants());
		jsonObject.put("Home_Language", Applicant.getHomeLanguage());
		jsonObject.put("Work_History_1", Applicant.getWorkHistory1());
		jsonObject.put("Work_History_2", Applicant.getWorkHistory2());
		jsonObject.put("Work_History_3", Applicant.getWorkHistory3());
		jsonObject.put("Work_History_4", Applicant.getWorkHistory4());
		jsonObject.put("E_Mail", Applicant.getEmail());
		
		jsonObject.put("Age", Applicant.getAge());
		jsonObject.put("Date_Of_Birth", Applicant.getDateOfBirth());
		jsonObject.put("Last_Sms_Date", Applicant.getLastSmsDate());
		jsonObject.put("Sms_Group", Applicant.getSmsGroup());
		jsonObject.put("Sms_Account_Active", Applicant.getSmsAccountActive());
		jsonObject.put("Last_Used_Date", Applicant.getLastUsedDate());
		
		
		System.out.println(jsonObject.toString());
	    
		return jsonObject.toString();
	}
	
	
	@Path("/GetApplicant/{Jobtype}")
	@GET
	@Produces("text/plain")
	public String GET1(@PathParam("Jobtype") String Jobtype) throws Exception
	{
		
		String Matched = "false";
		String PasswordUser = "";
		
		MacApplicantDAO Object  = new MacApplicantDAO();
		
		List<MacApplicants> Applicants = Object.GetApplicantsByJobType(Jobtype);
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", Applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", Applicants.get(i).getName());
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
			jsonObject.put("Sms_Group", Applicants.get(i).getSmsGroup());
			jsonObject.put("Sms_Account_Active", Applicants.get(i).getSmsAccountActive());
			jsonObject.put("Last_Used_Date", Applicants.get(i).getLastUsedDate());
			
			
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
		
		
		
		
		
		return JsonArray.toString();
	}
	
	@Path("/GetApplicantByIdCell/{IdNumber}/{Cell_Number}")
	@GET
	@Produces("text/plain")
	public String GETIDCELL(@PathParam("IdNumber") String IdNumber,@PathParam("Cell_Number") String Cell_Number) throws Exception
	{
		
		
		
		MacApplicantDAO Object  = new MacApplicantDAO();
		
		List<MacApplicants> Applicants = Object.GetApplicantsByApplicantIdCell(IdNumber, Cell_Number);
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", Applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", Applicants.get(i).getName());
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
			jsonObject.put("Sms_Group", Applicants.get(i).getSmsGroup());
			jsonObject.put("Sms_Account_Active", Applicants.get(i).getSmsAccountActive());
			jsonObject.put("Last_Used_Date", Applicants.get(i).getLastUsedDate());
			
			
			
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
		
		
		
		
		
		return JsonArray.toString();
	}
	
	@Path("/GetApplicantById/{IdNumber}")
	@GET
	@Produces("text/plain")
	public String GET3(@PathParam("IdNumber") String IdNumber) throws Exception
	{
		
		
		
		MacApplicantDAO Object  = new MacApplicantDAO();
		
		List<MacApplicants> Applicants = Object.GetApplicantsByApplicantId(IdNumber);
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", Applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", Applicants.get(i).getName());
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
			jsonObject.put("Sms_Group", Applicants.get(i).getSmsGroup());
			jsonObject.put("Sms_Account_Active", Applicants.get(i).getSmsAccountActive());
			
			jsonObject.put("Last_Used_Date", Applicants.get(i).getLastUsedDate());
			
			
			
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
		
		
		
		
		
		return JsonArray.toString();
	}
	
	
	
	
	@Path("/GetApplicantsInterview/{idMac_Applicants}/{Id_Number}/{Job_Name}")
	@GET
	@Produces("text/plain")
	public String GETInterview(@PathParam("idMac_Applicants") String idMac_Applicants,@PathParam("IdNumber") String IdNumber,@PathParam("Job_Name") String Job_Name) throws Exception
	{
		
		
		
		MacApplicantDAO Object  = new MacApplicantDAO();
		
		
		
		List<MacApplicants> Applicants = Object.GetApplicantsByApplicantId(IdNumber);
		
		
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", Applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", Applicants.get(i).getName());
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
			jsonObject.put("Sms_Group", Applicants.get(i).getSmsGroup());
			jsonObject.put("Sms_Account_Active", Applicants.get(i).getSmsAccountActive());
			
			jsonObject.put("Last_Used_Date", Applicants.get(i).getLastUsedDate());
			
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
		
		
		
		
		
		return JsonArray.toString();
	}
	
	@Path("/GetApplicantByTableId/{idMac_Applicants}")
	@GET
	@Produces("text/plain")
	public String GETid(@PathParam("idMac_Applicants") String idMac_Applicants) throws Exception
	{
		
		
		
		MacApplicantDAO Object  = new MacApplicantDAO();
		
		List<MacApplicants> Applicants = Object.GetApplicantsByApplicantId(idMac_Applicants);
		
		
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", Applicants.get(0).getIdMacApplicants());
			jsonObject.put("Name", Applicants.get(0).getName());
			jsonObject.put("Surname", Applicants.get(0).getSurname());
			jsonObject.put("RSA_Citizen", Applicants.get(0).getRsaCitizen());
			jsonObject.put("Id_Number", Applicants.get(0).getIdNumber());
			jsonObject.put("Passport_Number", Applicants.get(0).getPassportNumber());
			jsonObject.put("Expiry_Date_Of_Passport", Applicants.get(0).getExpiryDateOfPassport());
			jsonObject.put("Work_Permit_Validity", Applicants.get(0).getWorkPermitValidity());
			jsonObject.put("Cell_Number", Applicants.get(0).getCellNumber());
			jsonObject.put("Telephone_Number", Applicants.get(0).getTelephoneNumber());
			jsonObject.put("Job_Type", Applicants.get(0).getJobType());
			jsonObject.put("Date_First_issue_license", Applicants.get(0).getDateFirstIssueLicense());
			jsonObject.put("License_Code", Applicants.get(0).getLicenseCode());
			
			jsonObject.put("Expiry_Date_Of_License", Applicants.get(0).getExpiryDateOfLicense());
			jsonObject.put("PDP_Expiry_Date", Applicants.get(0).getPdpExpiryDate());
			jsonObject.put("Gender", Applicants.get(0).getGender());
			jsonObject.put("Physical_Address_1", Applicants.get(0).getPhysicalAddress1());
			jsonObject.put("Physical_Address_2", Applicants.get(0).getPhysicalAddress2());		
			jsonObject.put("Physical_Address_3", Applicants.get(0).getPhysicalAddress3());
			jsonObject.put("Physical_Address_4", Applicants.get(0).getPhysicalAddress4());
			
			jsonObject.put("City", Applicants.get(0).getCity());		
			jsonObject.put("Country", Applicants.get(0).getCountry());
			jsonObject.put("Tax_No", Applicants.get(0).getTaxNo());
			
			jsonObject.put("Marital_Status", Applicants.get(0).getMaritalStatus());
			jsonObject.put("Dependants", Applicants.get(0).getDependants());
			jsonObject.put("Home_Language", Applicants.get(0).getHomeLanguage());
			jsonObject.put("Work_History_1", Applicants.get(0).getWorkHistory1());
			jsonObject.put("Work_History_2", Applicants.get(0).getWorkHistory2());
			jsonObject.put("Work_History_3", Applicants.get(0).getWorkHistory3());
			jsonObject.put("Work_History_4", Applicants.get(0).getWorkHistory4());
			jsonObject.put("E_Mail", Applicants.get(0).getEmail());
			jsonObject.put("Age", Applicants.get(0).getAge());
			jsonObject.put("Date_Of_Birth", Applicants.get(0).getDateOfBirth());
			jsonObject.put("Last_Sms_Date", Applicants.get(0).getLastSmsDate());
			jsonObject.put("Sms_Group", Applicants.get(0).getSmsGroup());
			jsonObject.put("Applicant_Status", Applicants.get(0).getApplicantStatus());
			jsonObject.put("Sms_Group", Applicants.get(0).getSmsGroup());
			jsonObject.put("Applicant_Type", Applicants.get(0).getApplicantType());
		
			jsonObject.put("Last_Sms_Date", Applicants.get(0).getLastSmsDate());
		
			jsonObject.put("Nationality", Applicants.get(0).getNationality());
		
			jsonObject.put("Mac_Labour_Interview_Complete", Applicants.get(0).getmacLabInterviewComplete());
			jsonObject.put("Mac_Labour_Interview_Comments", Applicants.get(0).getmacLabourInterviewComments());
			
			jsonObject.put("Sms_Group_Count", Applicants.get(0).getSmsGroupCount());
			
			jsonObject.put("Practical_Drivers_Test_Complete", Applicants.get(0).getPracticalDriversTestComplete());
			jsonObject.put("Practical_Drivers_Test_Comments", Applicants.get(0).getPracticalDriversTestComments());
			
			jsonObject.put("Client_Interview_Complete", Applicants.get(0).getClientInterviewComplete());
			jsonObject.put("Client_Interview_Comments", Applicants.get(0).getClientInterviewComments());
			
			jsonObject.put("Reference_Checks_Complete", Applicants.get(0).getReferenceChecksComplete());
			jsonObject.put("Reference_Checks_Comments", Applicants.get(0).getReferenceChecksComments());
			
			jsonObject.put("Sms_Account_Active", Applicants.get(0).getSmsAccountActive());
			
			jsonObject.put("Last_Used_Date", Applicants.get(0).getLastUsedDate());
			
			
		
		
		
		return jsonObject.toString();
	}
	
	
	
	
	
	@Path("/GetAllApplicants")
	@GET
	@Produces("text/plain")
	public String GETAPPLICANTS( ) throws Exception
	{
		
		MacApplicantDAO Object  = new MacApplicantDAO();
		
		List<MacApplicants> Applicants = Object.ReadAllApplicants();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", Applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", Applicants.get(i).getName());
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
			jsonObject.put("Stage_In_Process", Applicants.get(i).getStageInTheProcess());
			jsonObject.put("Nationality", Applicants.get(i).getNationality());
			jsonObject.put("Job_Name", Applicants.get(i).getJobName());
			jsonObject.put("Sms_Account_Active", Applicants.get(i).getSmsAccountActive());
			
			jsonObject.put("Last_Used_Date", Applicants.get(i).getLastUsedDate());
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		
	    
		return JsonArray.toString();
	}
	
	
	
	@Path("/GetAllApplicantsSMSConsole")
	@GET
	@Produces("text/plain")
	public String GETAPPLICANTSSMSCONSOLE( ) throws Exception
	{
		
		MacApplicantDAO Object  = new MacApplicantDAO();
		
		List<MacApplicants> Applicants = Object.ReadAllApplicantsSmsConsole();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", Applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", Applicants.get(i).getName());
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
			jsonObject.put("Stage_In_Process", Applicants.get(i).getStageInTheProcess());
			jsonObject.put("Nationality", Applicants.get(i).getNationality());
			jsonObject.put("Job_Name", Applicants.get(i).getJobName());
			jsonObject.put("Sms_Account_Active", Applicants.get(i).getSmsAccountActive());
			
			jsonObject.put("Last_Used_Date", Applicants.get(i).getLastUsedDate());
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		
	    
		return JsonArray.toString();
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
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
	    
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
	
		
						AssignedJobApplicantDAO Object1 = new AssignedJobApplicantDAO();
			
						MacApplicantDAO Object  = new MacApplicantDAO();
						
						List<MacApplicants> Applicants = Object.GetApplicantsMacInterviewCompleteNew();
						
						JSONArray JsonArray = new JSONArray();
						
						for(int i = 0; i < Applicants.size();i++)
						{
									
									List<AssignedJobApplicantList> x = Object1.ReadAllAssignedJobsInfoByID(Applicants.get(i).getIdNumber());
									
									for(int j=0; j < x.size(); j++)
									{
										
										JSONObject jsonObject = new JSONObject();
										
										jsonObject.put("idMac_Applicants", Applicants.get(i).getIdMacApplicants());
										jsonObject.put("Name", Applicants.get(i).getName());
										
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
										////////////////////////////////////////////////////////////////////////////
										jsonObject.put("Job_Name", x.get(j).getJobName());
										//////////////////////////////////////////////////////////////
										jsonObject.put("Sms_Group", Applicants.get(i).getSmsGroup());
										jsonObject.put("Sms_Group_Count", Applicants.get(i).getSmsGroupCount());
										jsonObject.put("Applicant_Type", Applicants.get(i).getApplicantType());
										jsonObject.put("Applicant_Status", Applicants.get(i).getApplicantStatus());
										jsonObject.put("Stage_In_Process", Applicants.get(i).getStageInTheProcess());
										jsonObject.put("Sms_Account_Active", Applicants.get(i).getSmsAccountActive());
										
										
										
										jsonObject.put("Practical_Drivers_Test_Comments", x.get(j).getPracticalDriversTestComments());
										jsonObject.put("Practical_Drivers_Test_Complete", x.get(j).getPracticalDriversTestComplete());
										jsonObject.put("Mac_Labour_Interview_Comments", x.get(j).getMacLabourInterviewComments());
										jsonObject.put("Mac_Lab_Interview_Complete", x.get(j).getMacLabInterviewComplete());
										jsonObject.put("Last_Used_Date", Applicants.get(i).getLastUsedDate());
										
										
										
										jsonObject.put("Nationality", Applicants.get(i).getNationality());
										JsonArray.put(jsonObject);
										
									}
									
						}
	
	
	
	
	
	
	System.out.println(JsonArray.toString());
	
	return JsonArray.toString();
	}
////////////////////////////////////////////////////
////////////////////////////////////////////////////

	
	@Path("/GetAllApplicantsSiteComplete")
	@GET
	@Produces("text/plain")
	public String GETAPPLICANTSSiteApp( ) throws Exception
	{
		
		AssignedJobApplicantDAO Object1 = new AssignedJobApplicantDAO();
		
		
		
		MacApplicantDAO Object  = new MacApplicantDAO();
		List<MacApplicants> Applicants = Object.GetApplicantsSiteComplete();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Applicants.size();i++)
		{
			
			
			
			
			List<AssignedJobApplicantList> x = Object1.ReadAllAssignedJobsInfoByID(Applicants.get(i).getIdNumber());
			
			for(int j=0; j < x.size(); j++)
			{
				JSONObject jsonObject = new JSONObject();
				
				jsonObject.put("idMac_Applicants", Applicants.get(i).getIdMacApplicants());
				jsonObject.put("Name", Applicants.get(i).getName());
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
				////////////////////////////////////////////////////////////////////////////
				jsonObject.put("Job_Name", x.get(j).getJobName());
				//////////////////////////////////////////////////////////////
				
				jsonObject.put("Sms_Group", Applicants.get(i).getSmsGroup());
				jsonObject.put("Sms_Group_Count", Applicants.get(i).getSmsGroupCount());
				jsonObject.put("Applicant_Type", Applicants.get(i).getApplicantType());
				jsonObject.put("Applicant_Status", Applicants.get(i).getApplicantStatus());
				jsonObject.put("Stage_In_Process", Applicants.get(i).getStageInTheProcess());
				jsonObject.put("Sms_Account_Active", Applicants.get(i).getSmsAccountActive());
				
				jsonObject.put("Mac_Labour_Interview_Comments", x.get(j).getMacLabourInterviewComments());
				jsonObject.put("Mac_Lab_Interview_Complete", x.get(j).getMacLabInterviewComplete());
				
				
				jsonObject.put("Nationality", Applicants.get(i).getNationality());
				jsonObject.put("Last_Used_Date", Applicants.get(i).getLastUsedDate());

				
				
				
				
				JsonArray.put(jsonObject);

			}
			
			
		}
		
	    
		return JsonArray.toString();
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
			
			jsonObject.put("Client_Interview_Comments", Applicants.get(i).getClientInterviewComments());
			jsonObject.put("Client_Interview_Complete", Applicants.get(i).getClientInterviewComplete());
			jsonObject.put("Stage_In_Process", Applicants.get(i).getStageInTheProcess());
			jsonObject.put("Sms_Account_Active", Applicants.get(i).getSmsAccountActive());
			
			
			
			jsonObject.put("Nationality", Applicants.get(i).getNationality());
			jsonObject.put("Last_Used_Date", Applicants.get(i).getLastUsedDate());
			
			
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
		
		AssignedJobApplicantDAO Object1 = new AssignedJobApplicantDAO();
		
	
		MacApplicantDAO Object  = new MacApplicantDAO();
		List<MacApplicants> Applicants = Object.GetApplicantsDriversCompleteNew();
		JSONArray JsonArray = new JSONArray();
	
		for(int i = 0; i < Applicants.size();i++)
		{
			
			List<AssignedJobApplicantList> x = Object1.ReadAllAssignedJobsInfoByID(Applicants.get(i).getIdNumber());
			
			for(int j=0; j < x.size(); j++)
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
				
				////////////////////////////////////////////////////////////////////////////
				jsonObject.put("Job_Name", x.get(j).getJobName());
				//////////////////////////////////////////////////////////////
				
				jsonObject.put("Sms_Group", Applicants.get(i).getSmsGroup());
				jsonObject.put("Sms_Group_Count", Applicants.get(i).getSmsGroupCount());
				jsonObject.put("Applicant_Type", Applicants.get(i).getApplicantType());
				jsonObject.put("Applicant_Status", Applicants.get(i).getApplicantStatus());
		
				jsonObject.put("Client_Interview_Comments", Applicants.get(i).getClientInterviewComments());
				jsonObject.put("Client_Interview_Complete", Applicants.get(i).getClientInterviewComplete());
				jsonObject.put("Stage_In_Process", Applicants.get(i).getStageInTheProcess());
				jsonObject.put("Sms_Account_Active", Applicants.get(i).getSmsAccountActive());
		
				jsonObject.put("Practical_Drivers_Test_Comments", x.get(j).getPracticalDriversTestComments());
				jsonObject.put("Practical_Drivers_Test_Complete", x.get(j).getPracticalDriversTestComplete());
		
				jsonObject.put("Nationality", Applicants.get(i).getNationality());
				jsonObject.put("Last_Used_Date", Applicants.get(i).getLastUsedDate());
		
		
				JsonArray.put(jsonObject);
			}
			
		}
	
	
	
	
	
	
		System.out.println(JsonArray.toString());
	
		return JsonArray.toString();
	}
	
	
	
	
	@Path("/GetAllApplicantsReferencecheck")
	@GET
	@Produces("text/plain")
	public String GETAPPLICANTReferencecheck( ) throws Exception
	{
		
		MacApplicantDAO Object  = new MacApplicantDAO();
		
		List<MacApplicants> Applicants = Object.GetApplicantsReferenceComplete();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Applicants.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("idMac_Applicants", Applicants.get(i).getIdMacApplicants());
			jsonObject.put("Name", Applicants.get(i).getName());
			jsonObject.put("Surname", Applicants.get(i).getSurname());
			jsonObject.put("Job_Name", Applicants.get(i).getJobName());
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
			
			jsonObject.put("Reference_Checks_Comments", Applicants.get(i).getClientInterviewComments());
			jsonObject.put("Reference_Checks_Complete", Applicants.get(i).getClientInterviewComplete());
			jsonObject.put("Stage_In_Process", Applicants.get(i).getStageInTheProcess());
			jsonObject.put("Sms_Account_Active", Applicants.get(i).getSmsAccountActive());
			
			
			
			jsonObject.put("Nationality", Applicants.get(i).getNationality());
			
			jsonObject.put("Last_Used_Date", Applicants.get(i).getLastUsedDate());
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
	    
		return JsonArray.toString();
	}
	
	@Path("/UpdateApplicantInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String update(String jsonTextObject) throws JSONException
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		
		MacApplicantDAO t = new MacApplicantDAO();
		JSONObject test = new JSONObject(jsonTextObject);
		System.out.println("Applicant Update"+test.toString());
		
		MacApplicants Applicant  = t.getClientApplicantoById(Integer.parseInt(test.getString("idMac_Applicants")));
		
		
		
		Applicant.setName(test.getString("Name"));
		Applicant.setSurname(test.getString("Surname"));
		Applicant.setRsaCitizen(test.getString("RSA_Citizen"));
		Applicant.setIdNumber(test.getString("Id_Number"));
		Applicant.setPassportNumber(test.getString("Passport_Number"));
		Applicant.setExpiryDateOfPassport(test.getString("Expiry_Date_Of_Passport"));
		Applicant.setWorkPermitValidity(test.getString("Work_Permit_Validity"));
		Applicant.setCellNumber(test.getString("Cell_Number"));
		Applicant.setTelephoneNumber(test.getString("Telephone_Number"));
		Applicant.setJobType(test.getString("Job_Type"));
		Applicant.setDateFirstIssueLicense(test.getString("Date_First_issue_license"));
		Applicant.setLicenseCode(test.getString("License_Code"));
		Applicant.setExpiryDateOfLicense(test.getString("Expiry_Date_Of_License"));
		Applicant.setPdpExpiryDate(test.getString("PDP_Expiry_Date"));
		Applicant.setGender(test.getString("Gender"));
		Applicant.setPhysicalAddress1(test.getString("Physical_Address_1"));
		Applicant.setPhysicalAddress2(test.getString("Physical_Address_2"));
		Applicant.setPhysicalAddress3(test.getString("Physical_Address_3"));
		Applicant.setPhysicalAddress4(test.getString("Physical_Address_4"));
		Applicant.setCity(test.getString("City"));
		Applicant.setCountry(test.getString("Country"));
		Applicant.setTaxNo(test.getString("Tax_No"));
		Applicant.setMaritalStatus(test.getString("Marital_Status"));
		Applicant.setDependants(test.getString("Dependants"));
		Applicant.setHomeLanguage(test.getString("Home_Language"));
		Applicant.setApplicantType("Normal");
		Applicant.setApplicantStatus("Recently Updated Details on System");
		Applicant.setEmail(test.getString("E_Mail"));
		Applicant.setAge(Integer.parseInt(test.getString("Age")));
		Applicant.setDateOfBirth(test.getString("Date_Of_Birth"));
		Applicant.setApplicantStatus(test.getString("Applicant_Status"));
		Applicant.setSmsGroup(test.getString("Sms_Group"));
		Applicant.setStageInTheProcess("Recently Updated Details on System");
		
		Applicant.setApplicantType(test.getString("Applicant_Type"));
		
		Applicant.setLastSmsDate(test.getString("Last_Sms_Date"));
		Applicant.setNationality(test.getString("Nationality"));
		
		
		Applicant.setmacLabInterviewComplete(test.getString("Mac_Labour_Interview_Complete"));
		Applicant.setmacLabourInterviewComments(test.getString("Mac_Labour_Interview_Comments"));
		
		Applicant.setSmsGroupCount(Integer.parseInt(test.getString("Sms_Group_Count")));
		
		Applicant.setPracticalDriversTestComplete(test.getString("Practical_Drivers_Test_Complete"));
		Applicant.setPracticalDriversTestComments(test.getString("Practical_Drivers_Test_Comments"));
		
		Applicant.setClientInterviewComments(test.getString("Client_Interview_Comments"));
		Applicant.setClientInterviewComplete(test.getString("Client_Interview_Complete"));
		
		Applicant.setReferenceChecksComments(test.getString("Reference_Checks_Comments"));
		Applicant.setReferenceChecksComplete(test.getString("Reference_Checks_Complete"));
		
		Applicant.setLastUsedDate(dateFormat.format(date));
		
		
		t.update(Applicant);
		
		
		
		
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
		
		JSONObject r = new JSONObject(jsonTextObject);	
		String Flag = r.getString("Flag");
		MacApplicantDAO Object  = new MacApplicantDAO();
		
		if(Flag.equals("0")|| Flag.equals("2"))
		{
			System.out.println("WRITING TO DATABASE:"+ r.getString("Name"));
			
			
			Object.AddAppicantInformation(r.getString("Name"), r.getString("Surname"), r.getString("RSA_Citizen"), r.getString("Id_Number"),r.getString("Passport_Number"),r.getString("Expiry_Date_Of_Passport"), r.getString("Work_Permit_Validity"), r.getString("Cell_Number"), r.getString("Telephone_Number"), r.getString("Job_Type"), r.getString("Date_First_issue_license"), r.getString("License_Code"), r.getString("Expiry_Date_Of_License"), r.getString("PDP_Expiry_Date"), r.getString("Gender"), r.getString("Physical_Address_1"), r.getString("Physical_Address_2"), r.getString("Physical_Address_3"), r.getString("Physical_Address_4"),r.getString("City"),r.getString("Country"),r.getString("Tax_No"), r.getString("Marital_Status"), r.getString("Dependants"), r.getString("Home_Language"), r.getString("Work_History_1"), r.getString("Work_History_2"), r.getString("Work_History_3"), r.getString("Work_History_1"), r.getString("E_Mail"), r.getInt("Age"), r.getString("Date_Of_Birth"), r.getString("Last_Sms_Date"), r.getString("Job_Name"), r.getString("Stage_In_Process"),"New",r.getString("Applicant_Type"),r.getString("Sms_Group"),r.getString("Nationality"));
			
			
		}
		else if(Flag.equals("1"))
		{
			
			MacApplicants Applicant = Object.getClientApplicantoById(r.getInt("idMac_Applicants"));
			Applicant.setName(r.getString("Name"));
			Applicant.setSurname(r.getString("Surname"));
			Applicant.setRsaCitizen(r.getString("RSA_Citizen"));
			Applicant.setIdNumber(r.getString("Id_Number"));
			Applicant.setPassportNumber(r.getString("Passport_Number"));
			Applicant.setExpiryDateOfPassport(r.getString("Expiry_Date_Of_Passport"));
			Applicant.setWorkPermitValidity(r.getString("Work_Permit_Validity"));
			Applicant.setCellNumber(r.getString("Cell_Number"));
			Applicant.setTelephoneNumber(r.getString("Telephone_Number"));
			Applicant.setJobType(r.getString("Job_Type"));
			Applicant.setDateFirstIssueLicense(r.getString("Date_First_issue_license"));
			Applicant.setLicenseCode(r.getString("License_Code"));
			Applicant.setExpiryDateOfLicense(r.getString("Expiry_Date_Of_License"));
			Applicant.setPdpExpiryDate(r.getString("PDP_Expiry_Date"));
			Applicant.setGender(r.getString("Gender"));
			Applicant.setPhysicalAddress1(r.getString("Physical_Address_1"));
			Applicant.setPhysicalAddress2(r.getString("Physical_Address_2"));
			Applicant.setPhysicalAddress3(r.getString("Physical_Address_3"));
			Applicant.setPhysicalAddress4(r.getString("Physical_Address_4"));
			Applicant.setCity(r.getString("City"));
			Applicant.setCountry(r.getString("Country"));
			Applicant.setTaxNo(r.getString("Tax_No"));
			Applicant.setMaritalStatus(r.getString("Marital_Status"));
			Applicant.setDependants(r.getString("Dependants"));
			Applicant.setHomeLanguage(r.getString("Home_Language"));
			Applicant.setEmail(r.getString("E_Mail"));
			Applicant.setAge(r.getInt("Age"));
			Applicant.setDateOfBirth(r.getString("Date_Of_Birth"));
			Applicant.setJobName(r.getString("Job_Name"));
			
			Applicant.setStageInTheProcess(r.getString("Stage_In_Process"));
			Applicant.setApplicantType(r.getString("Applicant_Type"));
			
			Applicant.setApplicantStatus("New");
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
		
		JSONObject r = new JSONObject(jsonTextObject);	
	    String Flag = r.getString("Flag");
		MacApplicantDAO Object  = new MacApplicantDAO();
		AssignedJobApplicantDAO AssignJob = new AssignedJobApplicantDAO();
		
		if(Flag.equals("0")|| Flag.equals("2"))
		{
			System.out.println("WRITING TO DATABASE:"+ r.getString("Name"));
			
			
			Object.AddAppicantInformation(r.getString("Name"), r.getString("Surname"), r.getString("RSA_Citizen"), r.getString("Id_Number"),r.getString("Passport_Number"),r.getString("Expiry_Date_Of_Passport"), r.getString("Work_Permit_Validity"), r.getString("Cell_Number"), r.getString("Telephone_Number"), r.getString("Job_Type"), r.getString("Date_First_issue_license"), r.getString("License_Code"), r.getString("Expiry_Date_Of_License"), r.getString("PDP_Expiry_Date"), r.getString("Gender"), r.getString("Physical_Address_1"), r.getString("Physical_Address_2"), r.getString("Physical_Address_3"), r.getString("Physical_Address_4"),r.getString("City"),r.getString("Country"),r.getString("Tax_No"), r.getString("Marital_Status"), r.getString("Dependants"), r.getString("Home_Language"), r.getString("Work_History_1"), r.getString("Work_History_2"), r.getString("Work_History_3"), r.getString("Work_History_1"), r.getString("E_Mail"), r.getInt("Age"), r.getString("Date_Of_Birth"), r.getString("Last_Sms_Date"), r.getString("Job_Name"), r.getString("Stage_In_Process"),"New",r.getString("Applicant_Type"),r.getString("Sms_Group"),r.getString("Nationality"));
			AssignJob.AddAssignedJob(r.getString("Job_Name"), r.getString("Id_Number"));
			
		}
		else if(Flag.equals("1"))
		{
			
			MacApplicants Applicant = Object.getClientApplicantoById(r.getInt("idMac_Applicants"));
			Applicant.setName(r.getString("Name"));
			Applicant.setSurname(r.getString("Surname"));
			Applicant.setRsaCitizen(r.getString("RSA_Citizen"));
			Applicant.setIdNumber(r.getString("Id_Number"));
			Applicant.setPassportNumber(r.getString("Passport_Number"));
			Applicant.setExpiryDateOfPassport(r.getString("Expiry_Date_Of_Passport"));
			Applicant.setWorkPermitValidity(r.getString("Work_Permit_Validity"));
			Applicant.setCellNumber(r.getString("Cell_Number"));
			Applicant.setTelephoneNumber(r.getString("Telephone_Number"));
			Applicant.setJobType(r.getString("Job_Type"));
			Applicant.setDateFirstIssueLicense(r.getString("Date_First_issue_license"));
			Applicant.setLicenseCode(r.getString("License_Code"));
			Applicant.setExpiryDateOfLicense(r.getString("Expiry_Date_Of_License"));
			Applicant.setPdpExpiryDate(r.getString("PDP_Expiry_Date"));
			Applicant.setGender(r.getString("Gender"));
			Applicant.setPhysicalAddress1(r.getString("Physical_Address_1"));
			Applicant.setPhysicalAddress2(r.getString("Physical_Address_2"));
			Applicant.setPhysicalAddress3(r.getString("Physical_Address_3"));
			Applicant.setPhysicalAddress4(r.getString("Physical_Address_4"));
			Applicant.setCity(r.getString("City"));
			Applicant.setCountry(r.getString("Country"));
			Applicant.setTaxNo(r.getString("Tax_No"));
			Applicant.setMaritalStatus(r.getString("Marital_Status"));
			Applicant.setDependants(r.getString("Dependants"));
			Applicant.setHomeLanguage(r.getString("Home_Language"));
			Applicant.setEmail(r.getString("E_Mail"));
			Applicant.setAge(r.getInt("Age"));
			Applicant.setDateOfBirth(r.getString("Date_Of_Birth"));
			Applicant.setJobName(r.getString("Job_Name"));
			
			Applicant.setStageInTheProcess(r.getString("Stage_In_Process"));
			Applicant.setApplicantType(r.getString("Applicant_Type"));
			
			Applicant.setApplicantStatus("New");
			Applicant.setSmsAccountActive("Yes");
			
			Applicant.setLastUsedDate(dateFormat.format(date));
						
			Object.update(Applicant);
			
			
			AssignJob.AddAssignedJob(r.getString("Job_Name"), r.getString("Id_Number"));
			
			
		}
		
		
		return "Sucessful";	
		
			
	}
	
	
	
	@Path("/SavePermanentInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String createPermanent(String jsonTextObject) throws JSONException
	{
		JSONObject r = new JSONObject(jsonTextObject);	

		System.out.println("WRITING TO DATABASE:"+ r.getString("Name"));
			
		MacApplicantDAO Object  = new MacApplicantDAO();
		Object.AddPermanentInformation(r.getString("Name"), r.getString("Surname"), r.getString("RSA_Citizen"), r.getString("Id_Number"),r.getString("Passport_Number"),r.getString("Expiry_Date_Of_Passport"), r.getString("Work_Permit_Validity"), r.getString("Cell_Number"), r.getString("Telephone_Number"), r.getString("Job_Type"), r.getString("Date_First_issue_license"), r.getString("License_Code"), r.getString("Expiry_Date_Of_License"), r.getString("PDP_Expiry_Date"), r.getString("Gender"), r.getString("Physical_Address_1"), r.getString("Physical_Address_2"), r.getString("Physical_Address_3"), r.getString("Physical_Address_4"),r.getString("City"),r.getString("Country"),r.getString("Tax_No"), r.getString("Marital_Status"), r.getString("Dependants"), r.getString("Home_Language"), r.getString("Work_History_1"), r.getString("Work_History_2"), r.getString("Work_History_3"), r.getString("Work_History_1"), r.getString("E_Mail"), r.getInt("Age"), r.getString("Date_Of_Birth"), r.getString("Last_Sms_Date"), r.getString("Job_Name"), "Applicant recently added On Harlequin.","New", r.getString("Applicant_Type"));
			
		return "Sucessful";		
	}
	
	
	@Path("/SaveLandApplicantInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String createL(String jsonTextObject) throws JSONException
	{
		
		System.out.println(jsonTextObject);
		JSONObject r = new JSONObject(jsonTextObject);	
	
		
		System.out.println("WRITING TO DATABASE:"+ r.getString("Name"));
			
		MacApplicantDAO Object  = new MacApplicantDAO();
		Object.AddAppicantInformation(r.getString("Name"), r.getString("Surname"), r.getString("Id_Number"), r.getString("Cell_Number"), r.getString("Job_Type"), r.getString("E_Mail"),0);
		
		return "Sucessful";	
		
			
	}
	
	@Path("/UpdateMacLabourInterview")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String UpdateMacInterview(String jsonTextObject) throws JSONException
	{
		
		System.out.println(jsonTextObject);
		JSONObject r = new JSONObject(jsonTextObject);	
	
		
	
			
		MacApplicantDAO Object  = new MacApplicantDAO();
		//Object.UpdateAppplicantMacLabourById(Integer.parseInt(r.getString("idMac_Applicants")), r.getString("Formal_Interview_Complete"), r.getString("Interview_Comments"));
		Object.UpdateAppplicantMacLabourByIdJobName(Integer.parseInt(r.getString("idMac_Applicants")), r.getString("Formal_Interview_Complete"), r.getString("Interview_Comments"), r.getString("Job_Name"),r.getString("Id_Number"));
		
		return "Sucessful";	
		
			
	}
	
	
	@Path("/UpdateApplicantSmsDate")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String Update(String jsonTextObject) throws JSONException
	{
		
		System.out.println(jsonTextObject);
		JSONObject r = new JSONObject(jsonTextObject);	
	
		
		
			
		
		
		
		
		MacApplicantDAO Object  = new MacApplicantDAO();
		
		Object.UpdateAppplicantLastSmsDateById(r.getInt("idMac_Applicants"),"None",0);
		
		
		
		return "Sucessful";	
		
			
	}

}

