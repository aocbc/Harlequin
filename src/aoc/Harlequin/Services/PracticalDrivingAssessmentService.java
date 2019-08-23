package aoc.Harlequin.Services;

import java.math.BigDecimal;
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
import aoc.Harlequin.DAOs.MacApplicantDAO;
import aoc.Harlequin.DAOs.PracticalDrivingAssessmentDAO;
import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.PracticalDriversAssessment;


@SuppressWarnings("deprecation")
@Path("PracticalDrivingAssessment")
public class PracticalDrivingAssessmentService {
	
	@Path("/GetAssessmentInfo")
	@GET
	@Produces("text/plain")
	public String GET( ) throws Exception
	{
		
		PracticalDrivingAssessmentDAO practicalDrivingAssessmentDao  = new PracticalDrivingAssessmentDAO();
		PracticalDriversAssessment assessment  = practicalDrivingAssessmentDao.getAssessmentById(1);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("idPractical_Drivers_Assessment", assessment.getIdPracticalDriversAssessment());
		jsonObject.put("idMac_Applicants", assessment.getIdMacApplicants());
		jsonObject.put("Surname", assessment.getSurname());
		jsonObject.put("Id_Number", assessment.getIdNumber());
		jsonObject.put("Client_Name", assessment.getClientName());		
		jsonObject.put("PDP_Expiry_Date", assessment.getPdpExpiryDate());
		jsonObject.put("Vehicle_Used", assessment.getVehicleUsed());
		jsonObject.put("Assessor_Name", assessment.getAssessorName());
		jsonObject.put("Assessor_Surname", assessment.getAssessorSurname());
		jsonObject.put("Assessor_User_Id", assessment.getAssessorUserId());
		jsonObject.put("Date", assessment.getDate());
		jsonObject.put("KM_End", assessment.getKmEnd());
		jsonObject.put("KM_Start", assessment.getKmStart());
		jsonObject.put("Time_End", assessment.getTimeEnd());
		jsonObject.put("Time_Start", assessment.getTimeStart());		
		jsonObject.put("Weather", assessment.getWeather());
		jsonObject.put("Route", assessment.getRoute());
		jsonObject.put("Total_score", assessment.getTotalScore());
		jsonObject.put("Starting_And_Stopping", assessment.getStartingAndStopping());
		jsonObject.put("General_Driving", assessment.getGeneralDriving());
		jsonObject.put("Passing_Or_Overtaking", assessment.getPassingOrOvertaking());
		jsonObject.put("General_Road_Behavior", assessment.getGeneralRoadBehavior());
		jsonObject.put("Observation_And_Anticipation", assessment.getObservationAndAnticipation());
		jsonObject.put("Approaching_Junctions_Turning_Exiting", assessment.getApproachingJunctionsTurningExiting());
		jsonObject.put("Reversing", assessment.getReversing());		
		jsonObject.put("Clutch", assessment.getClutch());
		jsonObject.put("Retarder_DSC_HillMode", assessment.getRetarderDscHillMode());
		jsonObject.put("Comments", StringEscapeUtils.escapeJava(assessment.getComments()));
		jsonObject.put("PDA_No", assessment.getPdaNo());
		jsonObject.put("Last_Used_Date", assessment.getLastUsedDate());
	    
		return jsonObject.toString();
	}
	
	
	@Path("/GetAllAssessments")
	@GET
	@Produces("text/plain")
	public String GETAllAssessments( ) throws Exception
	{
		PracticalDrivingAssessmentDAO practicalDrivingAssessmentDao  = new PracticalDrivingAssessmentDAO();	
		List<PracticalDriversAssessment> assessments = practicalDrivingAssessmentDao.ReadAllAssessments();	
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < assessments.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("idPractical_Drivers_Assessment", assessments.get(i).getIdPracticalDriversAssessment());
			jsonObject.put("idMac_Applicants", assessments.get(i).getIdMacApplicants());
			jsonObject.put("Surname", assessments.get(i).getSurname());
			jsonObject.put("Id_Number", assessments.get(i).getIdNumber());
			jsonObject.put("Client_Name",assessments.get(i).getClientName());		
			jsonObject.put("PDP_Expiry_Date", assessments.get(i).getPdpExpiryDate());
			jsonObject.put("Vehicle_Used", assessments.get(i).getVehicleUsed());
			jsonObject.put("Assessor_Name", assessments.get(i).getAssessorName());
			jsonObject.put("Assessor_Surname", assessments.get(i).getAssessorSurname());
			jsonObject.put("Assessor_User_Id", assessments.get(i).getAssessorUserId());
			jsonObject.put("Date", assessments.get(i).getDate());
			jsonObject.put("KM_End", assessments.get(i).getKmEnd());
			jsonObject.put("KM_Start", assessments.get(i).getKmStart());
			jsonObject.put("Time_End", assessments.get(i).getTimeEnd());
			jsonObject.put("Time_Start", assessments.get(i).getTimeStart());		
			jsonObject.put("Weather", assessments.get(i).getWeather());
			jsonObject.put("Route", assessments.get(i).getRoute());
			jsonObject.put("Total_score",assessments.get(i).getTotalScore());
			jsonObject.put("Starting_And_Stopping", assessments.get(i).getStartingAndStopping());
			jsonObject.put("General_Driving", assessments.get(i).getGeneralDriving());
			jsonObject.put("Passing_Or_Overtaking", assessments.get(i).getPassingOrOvertaking());
			jsonObject.put("General_Road_Behavior",assessments.get(i).getGeneralRoadBehavior());
			jsonObject.put("Observation_And_Anticipation", assessments.get(i).getObservationAndAnticipation());
			jsonObject.put("Approaching_Junctions_Turning_Exiting", assessments.get(i).getApproachingJunctionsTurningExiting());
			jsonObject.put("Reversing", assessments.get(i).getReversing());		
			jsonObject.put("Clutch", assessments.get(i).getClutch());
			jsonObject.put("Retarder_DSC_HillMode", assessments.get(i).getRetarderDscHillMode());
			jsonObject.put("Comments", StringEscapeUtils.escapeJava(assessments.get(i).getComments()));
			jsonObject.put("PDA_No",assessments.get(i).getPdaNo());
			jsonObject.put("Last_Used_Date",assessments.get(i).getLastUsedDate());
			
			
			JsonArray.put(jsonObject);
		}
		
	    
		return JsonArray.toString();
	}
	
	
	@Path("/GetAssessmentByIdClient/{Id_Number}/{Client_Name}")
	@GET
	@Produces("text/plain")
	public String GETAssessment(@PathParam("Id_Number") String Id_Number,@PathParam("Client_Name") String Client_Name ) throws Exception
	{
		PracticalDrivingAssessmentDAO practicalDrivingAssessmentDao  = new PracticalDrivingAssessmentDAO();
		
		List<PracticalDriversAssessment> assessments = practicalDrivingAssessmentDao.ReadAssessmentsByInfo(Id_Number, Client_Name);

		JSONObject jsonObject = new JSONObject();
			
			
			if(assessments.size()>0)
			{
				int i = 0;

				jsonObject.put("idPractical_Drivers_Assessment", assessments.get(i).getIdPracticalDriversAssessment());
				jsonObject.put("idMac_Applicants", assessments.get(i).getIdMacApplicants());
				jsonObject.put("Surname", assessments.get(i).getSurname());
				jsonObject.put("Id_Number", assessments.get(i).getIdNumber());
				jsonObject.put("Client_Name",assessments.get(i).getClientName());		
				jsonObject.put("PDP_Expiry_Date", assessments.get(i).getPdpExpiryDate());
				jsonObject.put("Vehicle_Used", assessments.get(i).getVehicleUsed());
				jsonObject.put("Assessor_Name", assessments.get(i).getAssessorName());
				jsonObject.put("Assessor_Surname", assessments.get(i).getAssessorSurname());
				jsonObject.put("Assessor_User_Id", assessments.get(i).getAssessorUserId());
				jsonObject.put("Date", assessments.get(i).getDate());
				jsonObject.put("KM_End", assessments.get(i).getKmEnd());
				jsonObject.put("KM_Start", assessments.get(i).getKmStart());
				jsonObject.put("Time_End", assessments.get(i).getTimeEnd());
				jsonObject.put("Time_Start", assessments.get(i).getTimeStart());		
				jsonObject.put("Weather", assessments.get(i).getWeather());
				jsonObject.put("Route", assessments.get(i).getRoute());
				jsonObject.put("Total_score",assessments.get(i).getTotalScore());
				jsonObject.put("Starting_And_Stopping", assessments.get(i).getStartingAndStopping());
				jsonObject.put("General_Driving", assessments.get(i).getGeneralDriving());
				jsonObject.put("Passing_Or_Overtaking", assessments.get(i).getPassingOrOvertaking());
				jsonObject.put("General_Road_Behavior",assessments.get(i).getGeneralRoadBehavior());
				jsonObject.put("Observation_And_Anticipation", assessments.get(i).getObservationAndAnticipation());
				jsonObject.put("Approaching_Junctions_Turning_Exiting", assessments.get(i).getApproachingJunctionsTurningExiting());
				jsonObject.put("Reversing", assessments.get(i).getReversing());		
				jsonObject.put("Clutch", assessments.get(i).getClutch());
				jsonObject.put("Retarder_DSC_HillMode", assessments.get(i).getRetarderDscHillMode());
				jsonObject.put("Comments", StringEscapeUtils.escapeJava(assessments.get(i).getComments()));
				jsonObject.put("PDA_No",assessments.get(i).getPdaNo());		
				jsonObject.put("StartingAndStopping1", assessments.get(i).getStartingAndStopping1());
				jsonObject.put("StartingAndStopping2", assessments.get(i).getStartingAndStopping2());
				jsonObject.put("StartingAndStopping3", assessments.get(i).getStartingAndStopping3());
				jsonObject.put("StartingAndStopping4", assessments.get(i).getStartingAndStopping4());
				jsonObject.put("StartingAndStopping5", assessments.get(i).getStartingAndStopping5());
				jsonObject.put("StartingAndStopping6", assessments.get(i).getStartingAndStopping6());
				jsonObject.put("StartingAndStopping7", assessments.get(i).getStartingAndStopping7());
				jsonObject.put("GeneralDriving8", assessments.get(i).getGeneralDriving8());
				jsonObject.put("GeneralDriving9", assessments.get(i).getGeneralDriving9());
				jsonObject.put("GeneralDriving10", assessments.get(i).getGeneralDriving10());
				jsonObject.put("GeneralDriving11", assessments.get(i).getGeneralDriving11());
				jsonObject.put("GeneralDriving12", assessments.get(i).getGeneralDriving12());
				jsonObject.put("GeneralDriving13", assessments.get(i).getGeneralDriving13());
				jsonObject.put("GeneralDriving14", assessments.get(i).getGeneralDriving14());
				jsonObject.put("GeneralDriving15", assessments.get(i).getGeneralDriving15());
				jsonObject.put("GeneralDriving16", assessments.get(i).getGeneralDriving16());
				jsonObject.put("GeneralDriving17", assessments.get(i).getGeneralDriving17());
				jsonObject.put("PassingOrOvertaking18", assessments.get(i).getPassingOrOvertaking18());
				jsonObject.put("PassingOrOvertaking19", assessments.get(i).getPassingOrOvertaking19());
				jsonObject.put("PassingOrOvertaking20", assessments.get(i).getPassingOrOvertaking20());
				jsonObject.put("PassingOrOvertaking21", assessments.get(i).getPassingOrOvertaking21());
				jsonObject.put("GeneralRoadBehavior22", assessments.get(i).getGeneralRoadBehavior22());
				jsonObject.put("GeneralRoadBehavior23", assessments.get(i).getGeneralRoadBehavior23());
				jsonObject.put("ObservationAndAnticipation24", assessments.get(i).getObservationAndAnticipation24());
				jsonObject.put("ObservationAndAnticipation25", assessments.get(i).getObservationAndAnticipation25());
				jsonObject.put("ObservationAndAnticipation26", assessments.get(i).getObservationAndAnticipation26());
				jsonObject.put("ObservationAndAnticipation27", assessments.get(i).getObservationAndAnticipation27());
				jsonObject.put("ObservationAndAnticipation28", assessments.get(i).getObservationAndAnticipation28());
				jsonObject.put("ApproachingJunctionsTurningExiting29", assessments.get(i).getApproachingJunctionsTurningExiting29());
				jsonObject.put("ApproachingJunctionsTurningExiting30", assessments.get(i).getApproachingJunctionsTurningExiting30());
				jsonObject.put("ApproachingJunctionsTurningExiting31", assessments.get(i).getApproachingJunctionsTurningExiting31());
				jsonObject.put("ApproachingJunctionsTurningExiting32", assessments.get(i).getApproachingJunctionsTurningExiting32());
				jsonObject.put("ApproachingJunctionsTurningExiting33", assessments.get(i).getApproachingJunctionsTurningExiting33());
				jsonObject.put("ApproachingJunctionsTurningExiting34", assessments.get(i).getApproachingJunctionsTurningExiting34());
				jsonObject.put("ApproachingJunctionsTurningExiting35", assessments.get(i).getApproachingJunctionsTurningExiting35());
				jsonObject.put("ApproachingJunctionsTurningExiting36", assessments.get(i).getApproachingJunctionsTurningExiting36());
				jsonObject.put("Reversing37", assessments.get(i).getReversing37());
				jsonObject.put("Reversing38", assessments.get(i).getReversing38());
				jsonObject.put("Reversing39", assessments.get(i).getReversing39());
				jsonObject.put("Clutch40", assessments.get(i).getClutch40());
				jsonObject.put("Clutch41", assessments.get(i).getClutch41());
				jsonObject.put("RetarderDSCHillMode42", assessments.get(i).getRetarderDSCHillMode42());
				jsonObject.put("RetarderDSCHillMode43", assessments.get(i).getRetarderDSCHillMode43());
				jsonObject.put("RetarderDSCHillMode44", assessments.get(i).getRetarderDSCHillMode44());
				jsonObject.put("Practical_Drivers_Complete", assessments.get(i).getPracticalDriversTestComplete());
				jsonObject.put("Last_Used_Date",assessments.get(i).getLastUsedDate());
				
				jsonObject.put("RoadTestPassed", assessments.get(i).getRoadTestPassed());
				jsonObject.put("ParkingTestPassed",assessments.get(i).getParkingTestPassed());
				jsonObject.put("ReverseTestPassed",assessments.get(i).getReverseTestPassed());
				
				jsonObject.put("RoadTestComments", assessments.get(i).getRoadTestComments());
				jsonObject.put("ParkingTestComments",assessments.get(i).getParkingTestComments());
				jsonObject.put("ReverseTestComments",assessments.get(i).getReverseTestComments());
				
				jsonObject.put("ManualOrAuto",assessments.get(i).getManualOrAuto());
				
			}

		return jsonObject.toString();
	}
	
	
	@Path("/GetAssessmentByIdJobName/{Id_Number}/{Job_Name}")
	@GET
	@Produces("text/plain")
	public String GetAssessmentByIdJobName(@PathParam("Id_Number") String Id_Number,@PathParam("Job_Name") String Job_Name ) throws Exception
	{
		PracticalDrivingAssessmentDAO practicalDrivingAssessmentDao  = new PracticalDrivingAssessmentDAO();
		
		List<PracticalDriversAssessment> assessments = practicalDrivingAssessmentDao.ReadAssessmentsByIdJobName(Id_Number, Job_Name);

		JSONObject jsonObject = new JSONObject();
			
			
			if(assessments.size()>0)
			{
				int i = 0;

				jsonObject.put("idPractical_Drivers_Assessment", assessments.get(i).getIdPracticalDriversAssessment());
				jsonObject.put("idMac_Applicants", assessments.get(i).getIdMacApplicants());
				jsonObject.put("Surname", assessments.get(i).getSurname());
				jsonObject.put("Id_Number", assessments.get(i).getIdNumber());
				jsonObject.put("Client_Name",assessments.get(i).getClientName());		
				jsonObject.put("PDP_Expiry_Date", assessments.get(i).getPdpExpiryDate());
				jsonObject.put("Vehicle_Used", assessments.get(i).getVehicleUsed());
				jsonObject.put("Assessor_Name", assessments.get(i).getAssessorName());
				jsonObject.put("Assessor_Surname", assessments.get(i).getAssessorSurname());
				jsonObject.put("Assessor_User_Id", assessments.get(i).getAssessorUserId());
				jsonObject.put("Date", assessments.get(i).getDate());
				jsonObject.put("KM_End", assessments.get(i).getKmEnd());
				jsonObject.put("KM_Start", assessments.get(i).getKmStart());
				jsonObject.put("Time_End", assessments.get(i).getTimeEnd());
				jsonObject.put("Time_Start", assessments.get(i).getTimeStart());		
				jsonObject.put("Weather", assessments.get(i).getWeather());
				jsonObject.put("Route", assessments.get(i).getRoute());
				jsonObject.put("Total_score",assessments.get(i).getTotalScore());
				jsonObject.put("Starting_And_Stopping", assessments.get(i).getStartingAndStopping());
				jsonObject.put("General_Driving", assessments.get(i).getGeneralDriving());
				jsonObject.put("Passing_Or_Overtaking", assessments.get(i).getPassingOrOvertaking());
				jsonObject.put("General_Road_Behavior",assessments.get(i).getGeneralRoadBehavior());
				jsonObject.put("Observation_And_Anticipation", assessments.get(i).getObservationAndAnticipation());
				jsonObject.put("Approaching_Junctions_Turning_Exiting", assessments.get(i).getApproachingJunctionsTurningExiting());
				jsonObject.put("Reversing", assessments.get(i).getReversing());		
				jsonObject.put("Clutch", assessments.get(i).getClutch());
				jsonObject.put("Retarder_DSC_HillMode", assessments.get(i).getRetarderDscHillMode());
				jsonObject.put("Comments", StringEscapeUtils.escapeJava(assessments.get(i).getComments()));
				jsonObject.put("PDA_No",assessments.get(i).getPdaNo());		
				jsonObject.put("StartingAndStopping1", assessments.get(i).getStartingAndStopping1());
				jsonObject.put("StartingAndStopping2", assessments.get(i).getStartingAndStopping2());
				jsonObject.put("StartingAndStopping3", assessments.get(i).getStartingAndStopping3());
				jsonObject.put("StartingAndStopping4", assessments.get(i).getStartingAndStopping4());
				jsonObject.put("StartingAndStopping5", assessments.get(i).getStartingAndStopping5());
				jsonObject.put("StartingAndStopping6", assessments.get(i).getStartingAndStopping6());
				jsonObject.put("StartingAndStopping7", assessments.get(i).getStartingAndStopping7());
				jsonObject.put("GeneralDriving8", assessments.get(i).getGeneralDriving8());
				jsonObject.put("GeneralDriving9", assessments.get(i).getGeneralDriving9());
				jsonObject.put("GeneralDriving10", assessments.get(i).getGeneralDriving10());
				jsonObject.put("GeneralDriving11", assessments.get(i).getGeneralDriving11());
				jsonObject.put("GeneralDriving12", assessments.get(i).getGeneralDriving12());
				jsonObject.put("GeneralDriving13", assessments.get(i).getGeneralDriving13());
				jsonObject.put("GeneralDriving14", assessments.get(i).getGeneralDriving14());
				jsonObject.put("GeneralDriving15", assessments.get(i).getGeneralDriving15());
				jsonObject.put("GeneralDriving16", assessments.get(i).getGeneralDriving16());
				jsonObject.put("GeneralDriving17", assessments.get(i).getGeneralDriving17());
				jsonObject.put("PassingOrOvertaking18", assessments.get(i).getPassingOrOvertaking18());
				jsonObject.put("PassingOrOvertaking19", assessments.get(i).getPassingOrOvertaking19());
				jsonObject.put("PassingOrOvertaking20", assessments.get(i).getPassingOrOvertaking20());
				jsonObject.put("PassingOrOvertaking21", assessments.get(i).getPassingOrOvertaking21());
				jsonObject.put("GeneralRoadBehavior22", assessments.get(i).getGeneralRoadBehavior22());
				jsonObject.put("GeneralRoadBehavior23", assessments.get(i).getGeneralRoadBehavior23());
				jsonObject.put("ObservationAndAnticipation24", assessments.get(i).getObservationAndAnticipation24());
				jsonObject.put("ObservationAndAnticipation25", assessments.get(i).getObservationAndAnticipation25());
				jsonObject.put("ObservationAndAnticipation26", assessments.get(i).getObservationAndAnticipation26());
				jsonObject.put("ObservationAndAnticipation27", assessments.get(i).getObservationAndAnticipation27());
				jsonObject.put("ObservationAndAnticipation28", assessments.get(i).getObservationAndAnticipation28());
				jsonObject.put("ApproachingJunctionsTurningExiting29", assessments.get(i).getApproachingJunctionsTurningExiting29());
				jsonObject.put("ApproachingJunctionsTurningExiting30", assessments.get(i).getApproachingJunctionsTurningExiting30());
				jsonObject.put("ApproachingJunctionsTurningExiting31", assessments.get(i).getApproachingJunctionsTurningExiting31());
				jsonObject.put("ApproachingJunctionsTurningExiting32", assessments.get(i).getApproachingJunctionsTurningExiting32());
				jsonObject.put("ApproachingJunctionsTurningExiting33", assessments.get(i).getApproachingJunctionsTurningExiting33());
				jsonObject.put("ApproachingJunctionsTurningExiting34", assessments.get(i).getApproachingJunctionsTurningExiting34());
				jsonObject.put("ApproachingJunctionsTurningExiting35", assessments.get(i).getApproachingJunctionsTurningExiting35());
				jsonObject.put("ApproachingJunctionsTurningExiting36", assessments.get(i).getApproachingJunctionsTurningExiting36());
				jsonObject.put("Reversing37", assessments.get(i).getReversing37());
				jsonObject.put("Reversing38", assessments.get(i).getReversing38());
				jsonObject.put("Reversing39", assessments.get(i).getReversing39());
				jsonObject.put("Clutch40", assessments.get(i).getClutch40());
				jsonObject.put("Clutch41", assessments.get(i).getClutch41());
				jsonObject.put("RetarderDSCHillMode42", assessments.get(i).getRetarderDSCHillMode42());
				jsonObject.put("RetarderDSCHillMode43", assessments.get(i).getRetarderDSCHillMode43());
				jsonObject.put("RetarderDSCHillMode44", assessments.get(i).getRetarderDSCHillMode44());
				jsonObject.put("Practical_Drivers_Complete", assessments.get(i).getPracticalDriversTestComplete());
				jsonObject.put("Last_Used_Date",assessments.get(i).getLastUsedDate());
				
				jsonObject.put("RoadTestPassed", assessments.get(i).getRoadTestPassed());
				jsonObject.put("ParkingTestPassed",assessments.get(i).getParkingTestPassed());
				jsonObject.put("ReverseTestPassed",assessments.get(i).getReverseTestPassed());
				
				jsonObject.put("RoadTestComments", assessments.get(i).getRoadTestComments());
				jsonObject.put("ParkingTestComments",assessments.get(i).getParkingTestComments());
				jsonObject.put("ReverseTestComments",assessments.get(i).getReverseTestComments());
				
				jsonObject.put("ManualOrAuto",assessments.get(i).getManualOrAuto());
				
			}

		return jsonObject.toString();
	}
	
	
	
	
	@Path("/GetAssessmentByIDNumber/{Id_Number}")
	@GET
	@Produces("text/plain")
	public String GETAssessmentsByIdNumber(@PathParam("Id_Number") String Id_Number) throws Exception
	{
		
		PracticalDrivingAssessmentDAO practicalDrivingAssessmentDao  = new PracticalDrivingAssessmentDAO();
		List<PracticalDriversAssessment> assessments = practicalDrivingAssessmentDao.ReadAssessmentsByInfoByIDnumber(Id_Number);
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < assessments.size();i++)
		{
		
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("idPractical_Drivers_Assessment", assessments.get(i).getIdPracticalDriversAssessment());
				jsonObject.put("idMac_Applicants", assessments.get(i).getIdMacApplicants());
				jsonObject.put("Name", assessments.get(i).getName());
				jsonObject.put("Surname", assessments.get(i).getSurname());
				jsonObject.put("Id_Number", assessments.get(i).getIdNumber());
				jsonObject.put("Client_Name",assessments.get(i).getClientName());		
				jsonObject.put("PDP_Expiry_Date", assessments.get(i).getPdpExpiryDate());
				jsonObject.put("Vehicle_Used", assessments.get(i).getVehicleUsed());
				jsonObject.put("Assessor_Name", assessments.get(i).getAssessorName());
				jsonObject.put("Assessor_Surname", assessments.get(i).getAssessorSurname());
				jsonObject.put("Assessor_User_Id", assessments.get(i).getAssessorUserId());
				jsonObject.put("Date", assessments.get(i).getDate());
				jsonObject.put("KM_End", assessments.get(i).getKmEnd());
				jsonObject.put("KM_Start", assessments.get(i).getKmStart());
				jsonObject.put("Time_End", assessments.get(i).getTimeEnd());
				jsonObject.put("Time_Start", assessments.get(i).getTimeStart());		
				jsonObject.put("Weather", assessments.get(i).getWeather());
				jsonObject.put("Route", assessments.get(i).getRoute());
				jsonObject.put("Total_score",assessments.get(i).getTotalScore());
				jsonObject.put("Starting_And_Stopping", assessments.get(i).getStartingAndStopping());
				jsonObject.put("General_Driving", assessments.get(i).getGeneralDriving());
				jsonObject.put("Passing_Or_Overtaking", assessments.get(i).getPassingOrOvertaking());
				jsonObject.put("General_Road_Behavior",assessments.get(i).getGeneralRoadBehavior());
				jsonObject.put("Observation_And_Anticipation", assessments.get(i).getObservationAndAnticipation());
				jsonObject.put("Approaching_Junctions_Turning_Exiting", assessments.get(i).getApproachingJunctionsTurningExiting());
				jsonObject.put("Reversing", assessments.get(i).getReversing());		
				jsonObject.put("Clutch", assessments.get(i).getClutch());
				jsonObject.put("Retarder_DSC_HillMode", assessments.get(i).getRetarderDscHillMode());
				jsonObject.put("Comments", StringEscapeUtils.escapeJava(assessments.get(i).getComments()));
				jsonObject.put("PDA_No",assessments.get(i).getPdaNo());
				jsonObject.put("License_Code",assessments.get(i).getLicenseCode());
				jsonObject.put("Practical_Drivers_Test_Complete",assessments.get(i).getPracticalDriversTestComplete());
				jsonObject.put("Practical_Drivers_Test_Comments",StringEscapeUtils.escapeJava(assessments.get(i).getPracticalDriversTestComments()));
				jsonObject.put("Job_Name",assessments.get(i).getjobName());
				jsonObject.put("Last_Used_Date",assessments.get(i).getLastUsedDate());
				jsonObject.put("PDP_Expiry_Date",assessments.get(i).getPdpExpiryDate());
				jsonObject.put("RoadTestPassed",assessments.get(i).getRoadTestPassed());
				jsonObject.put("ParkingTestPassed",assessments.get(i).getParkingTestPassed());

				jsonArray.put(jsonObject);
				
			}
			
	    
		return jsonArray.toString();
	}
	
	@Path("/GetLastAssessmentByIDNumber/{Id_Number}")
	@GET
	@Produces("text/plain")
	public String GETAssessmentByIdNumber(@PathParam("Id_Number") String Id_Number) throws Exception
	{
		
		PracticalDrivingAssessmentDAO practicalDrivingAssessmentDao  = new PracticalDrivingAssessmentDAO();
		List<PracticalDriversAssessment> assessments = practicalDrivingAssessmentDao.ReadAssessmentsByInfoByIDnumber(Id_Number);
		
		JSONObject jsonObject = new JSONObject();
		if(assessments.size()>0)
		{
				int i = assessments.size() - 1;
		
				
				jsonObject.put("idPractical_Drivers_Assessment", assessments.get(i).getIdPracticalDriversAssessment());
				jsonObject.put("idMac_Applicants", assessments.get(i).getIdMacApplicants());
				jsonObject.put("Surname", assessments.get(i).getSurname());
				jsonObject.put("Id_Number", assessments.get(i).getIdNumber());
				jsonObject.put("Client_Name",assessments.get(i).getClientName());		
				jsonObject.put("PDP_Expiry_Date", assessments.get(i).getPdpExpiryDate());
				jsonObject.put("Vehicle_Used", assessments.get(i).getVehicleUsed());
				jsonObject.put("Assessor_Name", assessments.get(i).getAssessorName());
				jsonObject.put("Assessor_Surname", assessments.get(i).getAssessorSurname());
				jsonObject.put("Assessor_User_Id", assessments.get(i).getAssessorUserId());
				jsonObject.put("Date", assessments.get(i).getDate());
				jsonObject.put("KM_End", assessments.get(i).getKmEnd());
				jsonObject.put("KM_Start", assessments.get(i).getKmStart());
				jsonObject.put("Time_End", assessments.get(i).getTimeEnd());
				jsonObject.put("Time_Start", assessments.get(i).getTimeStart());		
				jsonObject.put("Weather", assessments.get(i).getWeather());
				jsonObject.put("Route", assessments.get(i).getRoute());
				jsonObject.put("Total_score",assessments.get(i).getTotalScore());
				jsonObject.put("Starting_And_Stopping", assessments.get(i).getStartingAndStopping());
				jsonObject.put("General_Driving", assessments.get(i).getGeneralDriving());
				jsonObject.put("Passing_Or_Overtaking", assessments.get(i).getPassingOrOvertaking());
				jsonObject.put("General_Road_Behavior",assessments.get(i).getGeneralRoadBehavior());
				jsonObject.put("Observation_And_Anticipation", assessments.get(i).getObservationAndAnticipation());
				jsonObject.put("Approaching_Junctions_Turning_Exiting", assessments.get(i).getApproachingJunctionsTurningExiting());
				jsonObject.put("Reversing", assessments.get(i).getReversing());		
				jsonObject.put("Clutch", assessments.get(i).getClutch());
				jsonObject.put("Retarder_DSC_HillMode", assessments.get(i).getRetarderDscHillMode());
				jsonObject.put("Comments", StringEscapeUtils.escapeJava(assessments.get(i).getComments()));
				jsonObject.put("PDA_No",assessments.get(i).getPdaNo());		
				jsonObject.put("StartingAndStopping1", assessments.get(i).getStartingAndStopping1());
				jsonObject.put("StartingAndStopping2", assessments.get(i).getStartingAndStopping2());
				jsonObject.put("StartingAndStopping3", assessments.get(i).getStartingAndStopping3());
				jsonObject.put("StartingAndStopping4", assessments.get(i).getStartingAndStopping4());
				jsonObject.put("StartingAndStopping5", assessments.get(i).getStartingAndStopping5());
				jsonObject.put("StartingAndStopping6", assessments.get(i).getStartingAndStopping6());
				jsonObject.put("StartingAndStopping7", assessments.get(i).getStartingAndStopping7());
				jsonObject.put("GeneralDriving8", assessments.get(i).getGeneralDriving8());
				jsonObject.put("GeneralDriving9", assessments.get(i).getGeneralDriving9());
				jsonObject.put("GeneralDriving10", assessments.get(i).getGeneralDriving10());
				jsonObject.put("GeneralDriving11", assessments.get(i).getGeneralDriving11());
				jsonObject.put("GeneralDriving12", assessments.get(i).getGeneralDriving12());
				jsonObject.put("GeneralDriving13", assessments.get(i).getGeneralDriving13());
				jsonObject.put("GeneralDriving14", assessments.get(i).getGeneralDriving14());
				jsonObject.put("GeneralDriving15", assessments.get(i).getGeneralDriving15());
				jsonObject.put("GeneralDriving16", assessments.get(i).getGeneralDriving16());
				jsonObject.put("GeneralDriving17", assessments.get(i).getGeneralDriving17());
				jsonObject.put("PassingOrOvertaking18", assessments.get(i).getPassingOrOvertaking18());
				jsonObject.put("PassingOrOvertaking19", assessments.get(i).getPassingOrOvertaking19());
				jsonObject.put("PassingOrOvertaking20", assessments.get(i).getPassingOrOvertaking20());
				jsonObject.put("PassingOrOvertaking21", assessments.get(i).getPassingOrOvertaking21());
				jsonObject.put("GeneralRoadBehavior22", assessments.get(i).getGeneralRoadBehavior22());
				jsonObject.put("GeneralRoadBehavior23", assessments.get(i).getGeneralRoadBehavior23());
				jsonObject.put("ObservationAndAnticipation24", assessments.get(i).getObservationAndAnticipation24());
				jsonObject.put("ObservationAndAnticipation25", assessments.get(i).getObservationAndAnticipation25());
				jsonObject.put("ObservationAndAnticipation26", assessments.get(i).getObservationAndAnticipation26());
				jsonObject.put("ObservationAndAnticipation27", assessments.get(i).getObservationAndAnticipation27());
				jsonObject.put("ObservationAndAnticipation28", assessments.get(i).getObservationAndAnticipation28());
				jsonObject.put("ApproachingJunctionsTurningExiting29", assessments.get(i).getApproachingJunctionsTurningExiting29());
				jsonObject.put("ApproachingJunctionsTurningExiting30", assessments.get(i).getApproachingJunctionsTurningExiting30());
				jsonObject.put("ApproachingJunctionsTurningExiting31", assessments.get(i).getApproachingJunctionsTurningExiting31());
				jsonObject.put("ApproachingJunctionsTurningExiting32", assessments.get(i).getApproachingJunctionsTurningExiting32());
				jsonObject.put("ApproachingJunctionsTurningExiting33", assessments.get(i).getApproachingJunctionsTurningExiting33());
				jsonObject.put("ApproachingJunctionsTurningExiting34", assessments.get(i).getApproachingJunctionsTurningExiting34());
				jsonObject.put("ApproachingJunctionsTurningExiting35", assessments.get(i).getApproachingJunctionsTurningExiting35());
				jsonObject.put("ApproachingJunctionsTurningExiting36", assessments.get(i).getApproachingJunctionsTurningExiting36());
				jsonObject.put("Reversing37", assessments.get(i).getReversing37());
				jsonObject.put("Reversing38", assessments.get(i).getReversing38());
				jsonObject.put("Reversing39", assessments.get(i).getReversing39());
				jsonObject.put("Clutch40", assessments.get(i).getClutch40());
				jsonObject.put("Clutch41", assessments.get(i).getClutch41());
				jsonObject.put("RetarderDSCHillMode42", assessments.get(i).getRetarderDSCHillMode42());
				jsonObject.put("RetarderDSCHillMode43", assessments.get(i).getRetarderDSCHillMode43());
				jsonObject.put("RetarderDSCHillMode44", assessments.get(i).getRetarderDSCHillMode44());
				jsonObject.put("Practical_Drivers_Complete", assessments.get(i).getPracticalDriversTestComplete());
				jsonObject.put("Last_Used_Date",assessments.get(i).getLastUsedDate());
				
				jsonObject.put("RoadTestPassed", assessments.get(i).getRoadTestPassed());
				jsonObject.put("ParkingTestPassed",assessments.get(i).getParkingTestPassed());
				jsonObject.put("ReverseTestPassed",assessments.get(i).getReverseTestPassed());
				
				jsonObject.put("RoadTestComments", assessments.get(i).getRoadTestComments());
				jsonObject.put("ParkingTestComments",assessments.get(i).getParkingTestComments());
				jsonObject.put("ReverseTestComments",assessments.get(i).getReverseTestComments());
				
				jsonObject.put("ManualOrAuto",assessments.get(i).getManualOrAuto());

				
				
			}
			
	    
		return jsonObject.toString();
	}
	
	@Path("/SaveAssessmentInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		JSONObject jsonObject = new JSONObject(jsonTextObject);	
			
		PracticalDrivingAssessmentDAO practicalDrivingAssessmentDao  = new PracticalDrivingAssessmentDAO();
		practicalDrivingAssessmentDao.AddAppicantInformation(jsonObject.getString("ManualORAuto"),jsonObject.getString("idMac_Applicants"), jsonObject.getString("Name"), jsonObject.getString("Surname"), jsonObject.getString("Id_Number"), jsonObject.getString("Client_Name"), jsonObject.getString("PDP_Expiry_Date"), jsonObject.getString("Vehicle_Used"), jsonObject.getString("Assessor_Name"), jsonObject.getString("Assessor_Surname"), "01", jsonObject.getString("Date"), jsonObject.getString("KM_End"), jsonObject.getString("KM_Start"), jsonObject.getString("Time_End"), jsonObject.getString("Time_Start"), jsonObject.getString("Weather"), jsonObject.getString("Route"), jsonObject.getString ("Total_Score"), jsonObject.getString("Starting_And_Stopping"), jsonObject.getString("General_Driving"), jsonObject.getString("Passing_Or_Overtaking"), jsonObject.getString("General_Road_Behavior"), jsonObject.getString("Observation_And_Anticipation"), jsonObject.getString("Approaching_Junctions_Turning_Exiting"),jsonObject.getString("Reversing"), jsonObject.getString("Clutch"), jsonObject.getString("Retarder_DSC_HillMode"), jsonObject.getString("Comments"), jsonObject.getString("PDA_No"), jsonObject.getString("License_Code"), jsonObject.getString("Job_Name"),jsonObject.getString("PracticalDriversTestComplete"),jsonObject.getString("StartingAndStopping1") ,jsonObject.getString("StartingAndStopping2"),jsonObject.getString("StartingAndStopping3"), jsonObject.getString("StartingAndStopping4"), jsonObject.getString("StartingAndStopping5"), jsonObject.getString("StartingAndStopping6"), jsonObject.getString("StartingAndStopping7"), jsonObject.getString("GeneralDriving8"), jsonObject.getString("GeneralDriving9"), jsonObject.getString("GeneralDriving10"), jsonObject.getString("GeneralDriving11"), jsonObject.getString("GeneralDriving12"), jsonObject.getString("GeneralDriving13"), jsonObject.getString("GeneralDriving14"), jsonObject.getString("GeneralDriving15"), jsonObject.getString("GeneralDriving16"), jsonObject.getString("GeneralDriving17"), jsonObject.getString("PassingOrOvertaking18"), jsonObject.getString("PassingOrOvertaking19"), jsonObject.getString("PassingOrOvertaking20"), jsonObject.getString("PassingOrOvertaking21"), jsonObject.getString("GeneralRoadBehavior22"), jsonObject.getString("GeneralRoadBehavior23"), jsonObject.getString("ObservationAndAnticipation24"), jsonObject.getString("ObservationAndAnticipation25"), jsonObject.getString("ObservationAndAnticipation26"), jsonObject.getString("ObservationAndAnticipation27"), jsonObject.getString("ObservationAndAnticipation28"), jsonObject.getString("ApproachingJunctionsTurningExiting29"), jsonObject.getString("ApproachingJunctionsTurningExiting30"), jsonObject.getString("ApproachingJunctionsTurningExiting31"), jsonObject.getString("ApproachingJunctionsTurningExiting32"), jsonObject.getString("ApproachingJunctionsTurningExiting33"), jsonObject.getString("ApproachingJunctionsTurningExiting34"), jsonObject.getString("ApproachingJunctionsTurningExiting35"), jsonObject.getString("ApproachingJunctionsTurningExiting36"), jsonObject.getString("Reversing37"), jsonObject.getString("Reversing38"), jsonObject.getString("Reversing39"), jsonObject.getString("Clutch40"), jsonObject.getString("Clutch41"), jsonObject.getString("RetarderDSCHillMode42"), jsonObject.getString("RetarderDSCHillMode43"), jsonObject.getString("RetarderDSCHillMode44"),  jsonObject.getString("RoadTestComments"), jsonObject.getString("RoadTestComplete"), jsonObject.getString("ParkingTestComments"),jsonObject.getString("ParkingTestComplete"), jsonObject.getString("ReverseTestComments"), jsonObject.getString("ReverseTestComplete"));

		/////////////////////////////////////////////////////////
		AssignedJobApplicantDAO assignedjobdao = new AssignedJobApplicantDAO(); 
		//AssignedJobApplicantList assignedjob = new AssignedJobApplicantList();
		////////////////////////////////////////////////////////
		
		MacApplicantDAO macApplicantDao  = new MacApplicantDAO();
		List<MacApplicants> Applicants = macApplicantDao.GetApplicantsByApplicantId(jsonObject.getString("Id_Number"));

		 
		
		if(Applicants.size()>0)
		{
			
			String roadTestComplete = jsonObject.getString("RoadTestComplete"); 
			String reverseTestComplete = jsonObject.getString("ReverseTestComplete"); 
			String parkingTestComplete = jsonObject.getString("ParkingTestComplete");
			boolean passedDriversTest = false;
			
			if(roadTestComplete.trim().equals("Yes") && reverseTestComplete.trim().equals("Yes") && parkingTestComplete.trim().equals("Yes")  )
			{
				passedDriversTest = true;
			}
			
			
			
			
			if(passedDriversTest )
			{
				Applicants.get(0).setPracticalDriversTestComplete(jsonObject.getString("PracticalDriversTestComplete"));
				Applicants.get(0).setStageInTheProcess("Client Interview");
				Applicants.get(0).setJobName(jsonObject.getString("Job_Name"));
				Applicants.get(0).setLastUsedDate(dateFormat.format(date));
				assignedjobdao.UpdateAssignedJobStatusPracticalDrivers(jsonObject.getString("Id_Number"), jsonObject.getString("Job_Name"), "Client Interview", "beginning", jsonObject.getString("PracticalDriversTestComplete"), ((jsonObject.getString("Comments").equals("")) ? "N/A" : jsonObject.getString("Comments")),roadTestComplete, parkingTestComplete, reverseTestComplete); 
			}
			else
			{
				Applicants.get(0).setPracticalDriversTestComplete(jsonObject.getString("PracticalDriversTestComplete"));
				Applicants.get(0).setStageInTheProcess("Practical Drivers Test");
				Applicants.get(0).setJobName(jsonObject.getString("Job_Name"));
				Applicants.get(0).setLastUsedDate(dateFormat.format(date));
				assignedjobdao.UpdateAssignedJobStatusPracticalDrivers(jsonObject.getString("Id_Number"), jsonObject.getString("Job_Name"), "Practical Drivers Test", "pending", jsonObject.getString("PracticalDriversTestComplete"), ((jsonObject.getString("Comments").equals("")) ? "N/A" : jsonObject.getString("Comments")),roadTestComplete, parkingTestComplete, reverseTestComplete); 
				
			}
			macApplicantDao.update(Applicants.get(0));

		}
		
		return "Sucessful";	
		
			
	}

}
