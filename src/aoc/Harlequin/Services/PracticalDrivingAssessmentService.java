package aoc.Harlequin.Services;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import aoc.Harlequin.DAOs.ClientDAO;
import aoc.Harlequin.DAOs.PracticalDrivingAssessmentDAO;
import aoc.Harlequin.OBJs.PracticalDriversAssessment;
import aoc.Harlequin.OBJs.SystemClient;

@Path("PracticalDrivingAssessment")
public class PracticalDrivingAssessmentService {
	
	@Path("/GetAssessmentInfo")
	@GET
	@Produces("text/plain")
	public String GET( ) throws Exception
	{
		
		PracticalDrivingAssessmentDAO Object  = new PracticalDrivingAssessmentDAO();
		PracticalDriversAssessment Assessment  = Object.getAssessmentById(1);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("idPractical_Drivers_Assessment", Assessment.getIdPracticalDriversAssessment());
		jsonObject.put("idMac_Applicants", Assessment.getIdMacApplicants());
		jsonObject.put("Surname", Assessment.getSurname());
		jsonObject.put("Id_Number", Assessment.getIdNumber());
		jsonObject.put("Client_Name", Assessment.getClientName());		
		jsonObject.put("PDP_Expiry_Date", Assessment.getPdpExpiryDate());
		jsonObject.put("Vehicle_Used", Assessment.getVehicleUsed());
		jsonObject.put("Assessor_Name", Assessment.getAssessorName());
		jsonObject.put("Assessor_Surname", Assessment.getAssessorSurname());
		jsonObject.put("Assessor_User_Id", Assessment.getAssessorUserId());
		jsonObject.put("Date", Assessment.getDate());
		
		jsonObject.put("KM_End", Assessment.getKmEnd());
		jsonObject.put("KM_Start", Assessment.getKmStart());
		jsonObject.put("Time_End", Assessment.getTimeEnd());
		jsonObject.put("Time_Start", Assessment.getTimeStart());		
		jsonObject.put("Weather", Assessment.getWeather());
		jsonObject.put("Route", Assessment.getRoute());
		jsonObject.put("Total_score", Assessment.getTotalScore());
		jsonObject.put("Starting_And_Stopping", Assessment.getStartingAndStopping());
		jsonObject.put("General_Driving", Assessment.getGeneralDriving());
		jsonObject.put("Passing_Or_Overtaking", Assessment.getPassingOrOvertaking());
		
		jsonObject.put("General_Road_Behavior", Assessment.getGeneralRoadBehavior());
		jsonObject.put("Observation_And_Anticipation", Assessment.getObservationAndAnticipation());
		jsonObject.put("Approaching_Junctions_Turning_Exiting", Assessment.getApproachingJunctionsTurningExiting());
		jsonObject.put("Reversing", Assessment.getReversing());		
		jsonObject.put("Clutch", Assessment.getClutch());
		jsonObject.put("Retarder_DSC_HillMode", Assessment.getRetarderDscHillMode());
		jsonObject.put("Comments", Assessment.getComments());
		jsonObject.put("PDA_No", Assessment.getPdaNo());
		
		
		
		System.out.println(jsonObject.toString());
	    
		return jsonObject.toString();
	}
	
	
	@Path("/GetAllAssessments")
	@GET
	@Produces("text/plain")
	public String GETClients( ) throws Exception
	{
		
		PracticalDrivingAssessmentDAO Object  = new PracticalDrivingAssessmentDAO();
		
		List<PracticalDriversAssessment> Assessments = Object.ReadAllAssessments();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Assessments.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			
			
			
			jsonObject.put("idPractical_Drivers_Assessment", Assessments.get(i).getIdPracticalDriversAssessment());
			jsonObject.put("idMac_Applicants", Assessments.get(i).getIdMacApplicants());
			jsonObject.put("Surname", Assessments.get(i).getSurname());
			jsonObject.put("Id_Number", Assessments.get(i).getIdNumber());
			jsonObject.put("Client_Name",Assessments.get(i).getClientName());		
			jsonObject.put("PDP_Expiry_Date", Assessments.get(i).getPdpExpiryDate());
			jsonObject.put("Vehicle_Used", Assessments.get(i).getVehicleUsed());
			jsonObject.put("Assessor_Name", Assessments.get(i).getAssessorName());
			jsonObject.put("Assessor_Surname", Assessments.get(i).getAssessorSurname());
			jsonObject.put("Assessor_User_Id", Assessments.get(i).getAssessorUserId());
			jsonObject.put("Date", Assessments.get(i).getDate());
			
			jsonObject.put("KM_End", Assessments.get(i).getKmEnd());
			jsonObject.put("KM_Start", Assessments.get(i).getKmStart());
			jsonObject.put("Time_End", Assessments.get(i).getTimeEnd());
			jsonObject.put("Time_Start", Assessments.get(i).getTimeStart());		
			jsonObject.put("Weather", Assessments.get(i).getWeather());
			jsonObject.put("Route", Assessments.get(i).getRoute());
			jsonObject.put("Total_score",Assessments.get(i).getTotalScore());
			jsonObject.put("Starting_And_Stopping", Assessments.get(i).getStartingAndStopping());
			jsonObject.put("General_Driving", Assessments.get(i).getGeneralDriving());
			jsonObject.put("Passing_Or_Overtaking", Assessments.get(i).getPassingOrOvertaking());
			
			jsonObject.put("General_Road_Behavior",Assessments.get(i).getGeneralRoadBehavior());
			jsonObject.put("Observation_And_Anticipation", Assessments.get(i).getObservationAndAnticipation());
			jsonObject.put("Approaching_Junctions_Turning_Exiting", Assessments.get(i).getApproachingJunctionsTurningExiting());
			jsonObject.put("Reversing", Assessments.get(i).getReversing());		
			jsonObject.put("Clutch", Assessments.get(i).getClutch());
			jsonObject.put("Retarder_DSC_HillMode", Assessments.get(i).getRetarderDscHillMode());
			jsonObject.put("Comments", Assessments.get(i).getComments());
			jsonObject.put("PDA_No",Assessments.get(i).getPdaNo());
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
	    
		return JsonArray.toString();
	}
	
	@Path("/SaveAssessmentInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		
		System.out.println(jsonTextObject);
		JSONObject r = new JSONObject(jsonTextObject);	
	
		
		System.out.println("WRITING TO DATABASE:"+ r.getString("Client_Name"));
			
		PracticalDrivingAssessmentDAO Object  = new PracticalDrivingAssessmentDAO();
		Object.AddAppicantInformation(r.getString("idMac_Applicants"), r.getString("Name"), r.getString("Surname"), r.getString("Id_Number"), r.getString("Client_Name"), r.getString("PDP_Expiry_Date"), r.getString("Vehicle_Used"), r.getString("Assessor_Name"), r.getString("Assessor_Surname"), "01", r.getString("Date"), r.getString("KM_End"), r.getString("KM_Start"), r.getString("Time_End"), r.getString("Time_Start"), r.getString("Weather"), r.getString("Route"), r.getString ("Total_Score"), r.getString("Starting_And_Stopping"), r.getString("General_Driving"), r.getString("Passing_Or_Overtaking"), r.getString("General_Road_Behavior"), r.getString("Observation_And_Anticipation"), r.getString("Approaching_Junctions_Turning_Exiting"), r.getString("Reversing"), r.getString("Clutch"), r.getString("Retarder_DSC_HillMode"), r.getString("Comments"), r.getString("PDA_No"), r.getString("License_Code"));
		
		return "Sucessful";	
		
			
	}

}