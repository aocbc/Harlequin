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
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
		
		
		
		
		
		return JsonArray.toString();
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
		
		System.out.println(jsonTextObject);
		JSONObject r = new JSONObject(jsonTextObject);	
	
		
		System.out.println("WRITING TO DATABASE:"+ r.getString("Name"));
			
		MacApplicantDAO Object  = new MacApplicantDAO();
		Object.AddAppicantInformation(r.getString("Name"), r.getString("Surname"), r.getString("RSA_Citizen"), r.getString("Id_Number"),r.getString("Passport_Number"),r.getString("Expiry_Date_Of_Passport"), r.getString("Work_Permit_Validity"), r.getString("Cell_Number"), r.getString("Telephone_Number"), r.getString("Job_Type"), r.getString("Date_First_issue_license"), r.getString("License_Code"), r.getString("Expiry_Date_Of_License"), r.getString("PDP_Expiry_Date"), r.getString("Gender"), r.getString("Physical_Address_1"), r.getString("Physical_Address_2"), r.getString("Physical_Address_3"), r.getString("Physical_Address_4"),r.getString("City"),r.getString("Country"),r.getString("Tax_No"), r.getString("Marital_Status"), r.getString("Dependants"), r.getString("Home_Language"), r.getString("Work_History_1"), r.getString("Work_History_2"), r.getString("Work_History_3"), r.getString("Work_History_1"), r.getString("E_Mail"));
		
		return "Sucessful";	
		
			
	}

}

