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
		jsonObject.put("Comments", StringEscapeUtils.escapeJava(Assessment.getComments()));
		jsonObject.put("PDA_No", Assessment.getPdaNo());
		
		jsonObject.put("Last_Used_Date", Assessment.getLastUsedDate());
		
		System.out.println(jsonObject.toString());
	    
		return jsonObject.toString();
	}
	
	
	@Path("/GetAllAssessments")
	@GET
	@Produces("text/plain")
	public String GETAllAssessments( ) throws Exception
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
			jsonObject.put("Comments", StringEscapeUtils.escapeJava(Assessments.get(i).getComments()));
			jsonObject.put("PDA_No",Assessments.get(i).getPdaNo());
			jsonObject.put("Last_Used_Date",Assessments.get(i).getLastUsedDate());
			
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
	    
		return JsonArray.toString();
	}
	
	
	@Path("/GetAssessment/{idMac_Applicants}/{Client_Name}")
	@GET
	@Produces("text/plain")
	public String GETAssessment(@PathParam("idMac_Applicants") String idMac_Applicants,@PathParam("Client_Name") String Client_Name ) throws Exception
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		PracticalDrivingAssessmentDAO Object  = new PracticalDrivingAssessmentDAO();
		
		List<PracticalDriversAssessment> Assessments = Object.ReadAssessmentsByInfo(idMac_Applicants, Client_Name);
		
		
		
		
			JSONObject jsonObject = new JSONObject();
			
			
			if(Assessments.size()>0)
			{
				int i = 0;
				
				
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
				jsonObject.put("Comments", StringEscapeUtils.escapeJava(Assessments.get(i).getComments()));
				jsonObject.put("PDA_No",Assessments.get(i).getPdaNo());
								
				jsonObject.put("StartingAndStopping1", Assessments.get(i).getStartingAndStopping1());
				jsonObject.put("StartingAndStopping2", Assessments.get(i).getStartingAndStopping2());
				jsonObject.put("StartingAndStopping3", Assessments.get(i).getStartingAndStopping3());
				jsonObject.put("StartingAndStopping4", Assessments.get(i).getStartingAndStopping4());
				jsonObject.put("StartingAndStopping5", Assessments.get(i).getStartingAndStopping5());
				jsonObject.put("StartingAndStopping6", Assessments.get(i).getStartingAndStopping6());
				jsonObject.put("StartingAndStopping7", Assessments.get(i).getStartingAndStopping7());
			
				jsonObject.put("GeneralDriving8", Assessments.get(i).getGeneralDriving8());
				jsonObject.put("GeneralDriving9", Assessments.get(i).getGeneralDriving9());
				jsonObject.put("GeneralDriving10", Assessments.get(i).getGeneralDriving10());
				jsonObject.put("GeneralDriving11", Assessments.get(i).getGeneralDriving11());
				jsonObject.put("GeneralDriving12", Assessments.get(i).getGeneralDriving12());
				jsonObject.put("GeneralDriving13", Assessments.get(i).getGeneralDriving13());
				jsonObject.put("GeneralDriving14", Assessments.get(i).getGeneralDriving14());
				jsonObject.put("GeneralDriving15", Assessments.get(i).getGeneralDriving15());
				jsonObject.put("GeneralDriving16", Assessments.get(i).getGeneralDriving16());
				jsonObject.put("GeneralDriving17", Assessments.get(i).getGeneralDriving17());
				
				jsonObject.put("PassingOrOvertaking18", Assessments.get(i).getPassingOrOvertaking18());
				jsonObject.put("PassingOrOvertaking19", Assessments.get(i).getPassingOrOvertaking19());
				jsonObject.put("PassingOrOvertaking20", Assessments.get(i).getPassingOrOvertaking20());
				jsonObject.put("PassingOrOvertaking21", Assessments.get(i).getPassingOrOvertaking21());
				
				jsonObject.put("GeneralRoadBehavior22", Assessments.get(i).getGeneralRoadBehavior22());
				jsonObject.put("GeneralRoadBehavior23", Assessments.get(i).getGeneralRoadBehavior23());

				jsonObject.put("ObservationAndAnticipation24", Assessments.get(i).getObservationAndAnticipation24());
				jsonObject.put("ObservationAndAnticipation25", Assessments.get(i).getObservationAndAnticipation25());
				jsonObject.put("ObservationAndAnticipation26", Assessments.get(i).getObservationAndAnticipation26());
				jsonObject.put("ObservationAndAnticipation27", Assessments.get(i).getObservationAndAnticipation27());
				jsonObject.put("ObservationAndAnticipation28", Assessments.get(i).getObservationAndAnticipation28());
				
				jsonObject.put("ApproachingJunctionsTurningExiting29", Assessments.get(i).getApproachingJunctionsTurningExiting29());
				jsonObject.put("ApproachingJunctionsTurningExiting30", Assessments.get(i).getApproachingJunctionsTurningExiting30());
				jsonObject.put("ApproachingJunctionsTurningExiting31", Assessments.get(i).getApproachingJunctionsTurningExiting31());
				jsonObject.put("ApproachingJunctionsTurningExiting32", Assessments.get(i).getApproachingJunctionsTurningExiting32());
				jsonObject.put("ApproachingJunctionsTurningExiting33", Assessments.get(i).getApproachingJunctionsTurningExiting33());
				jsonObject.put("ApproachingJunctionsTurningExiting34", Assessments.get(i).getApproachingJunctionsTurningExiting34());
				jsonObject.put("ApproachingJunctionsTurningExiting35", Assessments.get(i).getApproachingJunctionsTurningExiting35());
				jsonObject.put("ApproachingJunctionsTurningExiting36", Assessments.get(i).getApproachingJunctionsTurningExiting36());
				
				jsonObject.put("Reversing37", Assessments.get(i).getReversing37());
				jsonObject.put("Reversing38", Assessments.get(i).getReversing38());
				jsonObject.put("Reversing39", Assessments.get(i).getReversing39());
				
				jsonObject.put("Clutch40", Assessments.get(i).getClutch40());
				jsonObject.put("Clutch41", Assessments.get(i).getClutch41());
				
				jsonObject.put("RetarderDSCHillMode42", Assessments.get(i).getRetarderDSCHillMode42());
				jsonObject.put("RetarderDSCHillMode43", Assessments.get(i).getRetarderDSCHillMode43());
				jsonObject.put("RetarderDSCHillMode44", Assessments.get(i).getRetarderDSCHillMode44());
		
				jsonObject.put("Practical_Drivers_Complete", Assessments.get(i).getPracticalDriversTestComplete());
			
				jsonObject.put("Last_Used_Date",Assessments.get(i).getLastUsedDate());
			
			}
			
			
		
		
		
		
		
		
		
		
	    
		return jsonObject.toString();
	}
	
	
	
	
	@Path("/GetAssessmentByIDNumber/{Id_Number}")
	@GET
	@Produces("text/plain")
	public String GETAssessmentsByIdNumber(@PathParam("Id_Number") String Id_Number) throws Exception
	{
		
		PracticalDrivingAssessmentDAO Object  = new PracticalDrivingAssessmentDAO();
		
		List<PracticalDriversAssessment> Assessments = Object.ReadAssessmentsByInfoByIDnumber(Id_Number);
		
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Assessments.size();i++)
		{
		
				JSONObject jsonObject = new JSONObject();
			
				
				
				jsonObject.put("idPractical_Drivers_Assessment", Assessments.get(i).getIdPracticalDriversAssessment());
				jsonObject.put("idMac_Applicants", Assessments.get(i).getIdMacApplicants());
				jsonObject.put("Name", Assessments.get(i).getName());
				
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
				jsonObject.put("Comments", StringEscapeUtils.escapeJava(Assessments.get(i).getComments()));
				jsonObject.put("PDA_No",Assessments.get(i).getPdaNo());
				
				jsonObject.put("License_Code",Assessments.get(i).getLicenseCode());
				jsonObject.put("Practical_Drivers_Test_Complete",Assessments.get(i).getPracticalDriversTestComplete());
				jsonObject.put("Practical_Drivers_Test_Comments",StringEscapeUtils.escapeJava(Assessments.get(i).getPracticalDriversTestComments()));
				
				jsonObject.put("Job_Name",Assessments.get(i).getjobName());
				jsonObject.put("Last_Used_Date",Assessments.get(i).getLastUsedDate());
				
				jsonObject.put("PDP_Expiry_Date",Assessments.get(i).getPdpExpiryDate());
				
				
				
				
				
				JsonArray.put(jsonObject);
				
			}
			
			
		
		
		
		
		
		
		
		
	    
		return JsonArray.toString();
	}
	
	@Path("/SaveAssessmentInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		System.out.println(jsonTextObject);
		JSONObject r = new JSONObject(jsonTextObject);	
	
		
		System.out.println("WRITING TO DATABASE:"+ r.getString("Client_Name"));
			
		PracticalDrivingAssessmentDAO Object  = new PracticalDrivingAssessmentDAO();
		Object.AddAppicantInformation(r.getString("idMac_Applicants"), r.getString("Name"), r.getString("Surname"), r.getString("Id_Number"), r.getString("Client_Name"), r.getString("PDP_Expiry_Date"), r.getString("Vehicle_Used"), r.getString("Assessor_Name"), r.getString("Assessor_Surname"), "01", r.getString("Date"), r.getString("KM_End"), r.getString("KM_Start"), r.getString("Time_End"), r.getString("Time_Start"), r.getString("Weather"), r.getString("Route"), r.getString ("Total_Score"), r.getString("Starting_And_Stopping"), r.getString("General_Driving"), r.getString("Passing_Or_Overtaking"), r.getString("General_Road_Behavior"), r.getString("Observation_And_Anticipation"), r.getString("Approaching_Junctions_Turning_Exiting"), r.getString("Reversing"), r.getString("Clutch"), r.getString("Retarder_DSC_HillMode"), r.getString("Comments"), r.getString("PDA_No"), r.getString("License_Code"), r.getString("Job_Name"),r.getString("PracticalDriversTestComplete"),r.getString("StartingAndStopping1") ,r.getString("StartingAndStopping2"),r.getString("StartingAndStopping3"), r.getString("StartingAndStopping4"), r.getString("StartingAndStopping5"), r.getString("StartingAndStopping6"), r.getString("StartingAndStopping7"), r.getString("GeneralDriving8"), r.getString("GeneralDriving9"), r.getString("GeneralDriving10"), r.getString("GeneralDriving11"), r.getString("GeneralDriving12"), r.getString("GeneralDriving13"), r.getString("GeneralDriving14"), r.getString("GeneralDriving15"), r.getString("GeneralDriving16"), r.getString("GeneralDriving17"), r.getString("PassingOrOvertaking18"), r.getString("PassingOrOvertaking19"), r.getString("PassingOrOvertaking20"), r.getString("PassingOrOvertaking21"), r.getString("GeneralRoadBehavior22"), r.getString("GeneralRoadBehavior23"), r.getString("ObservationAndAnticipation24"), r.getString("ObservationAndAnticipation25"), r.getString("ObservationAndAnticipation26"), r.getString("ObservationAndAnticipation27"), r.getString("ObservationAndAnticipation28"), r.getString("ApproachingJunctionsTurningExiting29"), r.getString("ApproachingJunctionsTurningExiting30"), r.getString("ApproachingJunctionsTurningExiting31"), r.getString("ApproachingJunctionsTurningExiting32"), r.getString("ApproachingJunctionsTurningExiting33"), r.getString("ApproachingJunctionsTurningExiting34"), r.getString("ApproachingJunctionsTurningExiting35"), r.getString("ApproachingJunctionsTurningExiting36"), r.getString("Reversing37"), r.getString("Reversing38"), r.getString("Reversing39"), r.getString("Clutch40"), r.getString("Clutch41"), r.getString("RetarderDSCHillMode42"), r.getString("RetarderDSCHillMode43"), r.getString("RetarderDSCHillMode44"));
		
		
		/////////////////////////////////////////////////////////
		AssignedJobApplicantDAO assignedjobdao = new AssignedJobApplicantDAO(); 
		//AssignedJobApplicantList assignedjob = new AssignedJobApplicantList();
		////////////////////////////////////////////////////////
		
		MacApplicantDAO Object1  = new MacApplicantDAO();
		
		
		List<MacApplicants> Applicants = Object1.GetApplicantsByApplicantId(r.getString("Id_Number"));
		System.out.println("HELLOWORLD:"+ Applicants.size()+", ID:"+r.getString("Id_Number")+", PC:"+r.getString("PracticalDriversTestComplete"));
		
		if(Applicants.size()>0)
		{
			
			if(r.getString("PracticalDriversTestComplete").equals("Yes") )
			{
				Applicants.get(0).setPracticalDriversTestComplete(r.getString("PracticalDriversTestComplete"));
				Applicants.get(0).setStageInTheProcess("Client Interview");
				Applicants.get(0).setJobName(r.getString("Job_Name"));
				Applicants.get(0).setLastUsedDate(dateFormat.format(date));
				assignedjobdao.UpdateAssignedJobStatusPracticalDrivers(r.getString("Id_Number"), r.getString("Job_Name"), "Client Interview", "beginning", r.getString("PracticalDriversTestComplete"), ((r.getString("Comments").equals("")) ? "N/A" : r.getString("Comments"))); 
				
			}
			else if(r.getString("PracticalDriversTestComplete").equals("No"))
			{

				Applicants.get(0).setPracticalDriversTestComplete(r.getString("PracticalDriversTestComplete"));
				Applicants.get(0).setStageInTheProcess("Practical Drivers Test");
				Applicants.get(0).setJobName(r.getString("Job_Name"));
				Applicants.get(0).setLastUsedDate(dateFormat.format(date));
				assignedjobdao.UpdateAssignedJobStatusPracticalDrivers(r.getString("Id_Number"), r.getString("Job_Name"), "Client Interview", "beginning", r.getString("PracticalDriversTestComplete"), ((r.getString("Comments").equals("")) ? "N/A" : r.getString("Comments"))); 
				
			}
			Object1.update(Applicants.get(0));
			
			
		}
		
		
		return "Sucessful";	
		
			
	}

}
