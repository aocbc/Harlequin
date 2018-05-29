package aoc.Harlequin.Services;

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

import aoc.Harlequin.DAOs.ClientDAO;
import aoc.Harlequin.DAOs.MacApplicantDAO;
import aoc.Harlequin.DAOs.SystemUserDAO;
import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemUser;

@Path("Applicant")
public class MacApplicantService {
	
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
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
	    
		return JsonArray.toString();
	}
	
	
	@Path("/SaveApplicantInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		
	
		JSONObject r = new JSONObject(jsonTextObject);	
	
		
		
		String Flag = r.getString("Flag");
	
		
		
		if(Flag.equals("0"))
		{
			System.out.println("WRITING TO DATABASE:"+ r.getString("Name"));
			
			MacApplicantDAO Object  = new MacApplicantDAO();
			Object.AddAppicantInformation(r.getString("Name"), r.getString("Surname"), r.getString("RSA_Citizen"), r.getString("Id_Number"),r.getString("Passport_Number"),r.getString("Expiry_Date_Of_Passport"), r.getString("Work_Permit_Validity"), r.getString("Cell_Number"), r.getString("Telephone_Number"), r.getString("Job_Type"), r.getString("Date_First_issue_license"), r.getString("License_Code"), r.getString("Expiry_Date_Of_License"), r.getString("PDP_Expiry_Date"), r.getString("Gender"), r.getString("Physical_Address_1"), r.getString("Physical_Address_2"), r.getString("Physical_Address_3"), r.getString("Physical_Address_4"),r.getString("City"),r.getString("Country"),r.getString("Tax_No"), r.getString("Marital_Status"), r.getString("Dependants"), r.getString("Home_Language"), r.getString("Work_History_1"), r.getString("Work_History_2"), r.getString("Work_History_3"), r.getString("Work_History_1"), r.getString("E_Mail"), r.getInt("Age"), r.getString("Date_Of_Birth"), r.getString("Last_Sms_Date"), r.getString("Job_Name"), "Applicant recently added.","New");
			
			
		}
		else if(Flag.equals("1"))
		{
			
			MacApplicants Applicant = new MacApplicants();
			Applicant.setIdMacApplicants(r.getInt("idMac_Applicants"));
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
			Applicant.setWorkHistory1(r.getString("Work_History_1"));
			Applicant.setWorkHistory2(r.getString("Work_History_2"));
			Applicant.setWorkHistory3(r.getString("Work_History_3"));
			Applicant.setWorkHistory4(r.getString("Work_History_4"));
			Applicant.setEmail(r.getString("E_Mail"));
			Applicant.setAge(r.getInt("Age"));
			Applicant.setDateOfBirth(r.getString("Date_Of_Birth"));
			Applicant.setJobName(r.getString("Job_Name"));
			
			
			MacApplicantDAO Object  = new MacApplicantDAO();
						
			Object.update(Applicant);
			
		}
		
		
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

