package aoc.Harlequin.DAOs;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;


import org.hibernate.query.Query;






import aoc.Harlequin.OBJs.MacLabourInterView;
import aoc.Harlequin.OBJs.PracticalDriversAssessment;
import aoc.Harlequin.util.HibernateUtil;

public class PracticalDrivingAssessmentDAO extends HarlequinDAO {
	
	public PracticalDriversAssessment getAssessmentById(int id)
	{
		
		
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		
		PracticalDriversAssessment Assessments = session.get(PracticalDriversAssessment.class, id);
		
		session.clear(); 
		session.flush();
		session.close();
	   
		
		return Assessments;
		
		
	}
	
	public void delete(Object entity) 
	{
		  Session hibernateSession = this.getSession(); 
		  
		  HibernateUtil.beginTransaction();
		  hibernateSession.delete(entity);
		  hibernateSession.flush();
		  HibernateUtil.commitTransaction();
		  
	}
	
	public void AddAppicantInformation(String idMac_Applicants,String name, String surname, String Id_Number,String Client_Name,String PDP_Expiry_Date, String Vehicle_Used, String Assessor_Name,String Assessor_Surname, String Assessor_User_Id,String Date, String KM_End,String KM_Start, String Time_End, String Time_Start, String Weather, String Route,String Total_Score, String Starting_And_Stopping, String General_Driving,String Passing_Or_Overtaking, String General_Road_Behavior, String Observation_And_Anticipation, String Approaching_Junctions_Turning_Exiting, String Reversing, String Clutch, String Retarder_DSC_HillMode, String Comments, String PDA_No,String License_Code,String Job_Name,String PracticalDriversComplete, String StartingAndStoppingArray[], String GeneralDrivingArray[],String PassingOrOvertakingArray[], String GeneralRoadBehaviorArray[],String ObservationAndAnticipationArray[], String ApproachingJunctionsTurningExitingArray[], String ReversingArray[], String ClutchArray[], String RetarderDSCHillModeArray[] )
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		///////////////////////////////////////////////////////////////////////////////////////////////////
		List<PracticalDriversAssessment> OldAssesment = ReadAssessmentsByInfo(idMac_Applicants,Client_Name);
		if(OldAssesment.size() > 0)
		{
			delete(OldAssesment.get(0));
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
		PracticalDriversAssessment Assessment = new PracticalDriversAssessment();
		
		Assessment.setIdMacApplicants(Integer.parseInt(idMac_Applicants));
		Assessment.setName(name);
		Assessment.setSurname(surname);
		Assessment.setIdNumber(Id_Number);
		Assessment.setClientName(Client_Name);
		Assessment.setPdpExpiryDate(PDP_Expiry_Date);
		Assessment.setVehicleUsed(Vehicle_Used);
		Assessment.setAssessorName(Assessor_Name);
		Assessment.setAssessorSurname(Assessor_Surname);
		Assessment.setAssessorUserId(Integer.parseInt(Assessor_User_Id));
		Assessment.setDate(Date);
		Assessment.setKmEnd(KM_End);
		Assessment.setKmStart(KM_Start);
		Assessment.setTimeEnd(Time_End);
		Assessment.setTimeStart(Time_Start);
		Assessment.setWeather(Weather);
		Assessment.setRoute(Route);
		Assessment.setTotalScore(new BigDecimal(Total_Score));
		Assessment.setStartingAndStopping(new BigDecimal(Starting_And_Stopping));
		Assessment.setGeneralDriving(new BigDecimal(General_Driving));
		Assessment.setObservationAndAnticipation(new BigDecimal(Observation_And_Anticipation));
		Assessment.setApproachingJunctionsTurningExiting(new BigDecimal(Approaching_Junctions_Turning_Exiting));
		Assessment.setPassingOrOvertaking(new BigDecimal(Passing_Or_Overtaking));
		Assessment.setGeneralRoadBehavior(new BigDecimal(General_Road_Behavior));
		Assessment.setObservationAndAnticipation(new BigDecimal(Observation_And_Anticipation));
		Assessment.setLicenseCode(License_Code);
		Assessment.setReversing(new BigDecimal(Reversing));
		Assessment.setClutch(new BigDecimal(Clutch));
		Assessment.setRetarderDscHillMode(new BigDecimal(Retarder_DSC_HillMode));
		Assessment.setComments(Comments);
		Assessment.setjobName(Job_Name);
		Assessment.setPracticalDriversTestComplete(PracticalDriversComplete);
		Assessment.setPracticalDriversTestComments(Comments);
		Assessment.setLastUsedDate(dateFormat.format(date));		
		
		if(StartingAndStoppingArray.length == 7)
		{
			
			Assessment.setStartingAndStopping1(StartingAndStoppingArray[0]);
			Assessment.setStartingAndStopping2(StartingAndStoppingArray[1]);
			Assessment.setStartingAndStopping3(StartingAndStoppingArray[2]);
			Assessment.setStartingAndStopping4(StartingAndStoppingArray[3]);
			Assessment.setStartingAndStopping5(StartingAndStoppingArray[4]);
			Assessment.setStartingAndStopping6(StartingAndStoppingArray[5]);
			Assessment.setStartingAndStopping7(StartingAndStoppingArray[6]);
		}
		
		if(GeneralDrivingArray.length == 10)
		{
			Assessment.setGeneralDriving8(GeneralDrivingArray[0]);
			Assessment.setGeneralDriving9(GeneralDrivingArray[1]);
			Assessment.setGeneralDriving10(GeneralDrivingArray[2]);
			Assessment.setGeneralDriving11(GeneralDrivingArray[3]);
			Assessment.setGeneralDriving12(GeneralDrivingArray[4]);
			Assessment.setGeneralDriving13(GeneralDrivingArray[5]);
			Assessment.setGeneralDriving14(GeneralDrivingArray[6]);
			Assessment.setGeneralDriving15(GeneralDrivingArray[7]);
			Assessment.setGeneralDriving16(GeneralDrivingArray[8]);
			Assessment.setGeneralDriving17(GeneralDrivingArray[9]);
		}
		
		if(PassingOrOvertakingArray.length == 4)
		{
			Assessment.setPassingOrOvertaking18(PassingOrOvertakingArray[0]);
			Assessment.setPassingOrOvertaking19(PassingOrOvertakingArray[1]);
			Assessment.setPassingOrOvertaking20(PassingOrOvertakingArray[2]);
			Assessment.setPassingOrOvertaking21(PassingOrOvertakingArray[3]);
			
			
		}
		
		if(GeneralRoadBehaviorArray.length == 2)
		{
			Assessment.setGeneralRoadBehavior22(GeneralRoadBehaviorArray[0]);
			Assessment.setGeneralRoadBehavior23(GeneralRoadBehaviorArray[1]);
		}
		
		if(ObservationAndAnticipationArray.length == 5)
		{
			Assessment.setObservationAndAnticipation24(ObservationAndAnticipationArray[0]);
			Assessment.setObservationAndAnticipation25(ObservationAndAnticipationArray[1]);
			Assessment.setObservationAndAnticipation26(ObservationAndAnticipationArray[2]);
			Assessment.setObservationAndAnticipation27(ObservationAndAnticipationArray[3]);
			Assessment.setObservationAndAnticipation28(ObservationAndAnticipationArray[4]);
		}
		
		if(ApproachingJunctionsTurningExitingArray.length == 8)
		{
			Assessment.setApproachingJunctionsTurningExiting29(ApproachingJunctionsTurningExitingArray[0]);
			Assessment.setApproachingJunctionsTurningExiting30(ApproachingJunctionsTurningExitingArray[1]);
			Assessment.setApproachingJunctionsTurningExiting31(ApproachingJunctionsTurningExitingArray[2]);
			Assessment.setApproachingJunctionsTurningExiting32(ApproachingJunctionsTurningExitingArray[3]);
			
			Assessment.setApproachingJunctionsTurningExiting33(ApproachingJunctionsTurningExitingArray[4]);
			Assessment.setApproachingJunctionsTurningExiting34(ApproachingJunctionsTurningExitingArray[5]);
			Assessment.setApproachingJunctionsTurningExiting35(ApproachingJunctionsTurningExitingArray[6]);
			Assessment.setApproachingJunctionsTurningExiting36(ApproachingJunctionsTurningExitingArray[7]);
			
			
		}
		
		if(ReversingArray.length == 3)
		{
			Assessment.setReversing37(ReversingArray[0]);
			Assessment.setReversing38(ReversingArray[1]);
			Assessment.setReversing39(ReversingArray[2]);
		}
		
		if(ClutchArray.length == 2)
		{
			Assessment.setClutch40(ClutchArray[0]);
			Assessment.setClutch41(ClutchArray[1]);
			
		}
		
		if(RetarderDSCHillModeArray.length == 3)
		{
			Assessment.setRetarderDSCHillMode42(RetarderDSCHillModeArray[0]);
			Assessment.setRetarderDSCHillMode43(RetarderDSCHillModeArray[1]);
			Assessment.setRetarderDSCHillMode44(RetarderDSCHillModeArray[2]);
			
		}
		
		session.save(Assessment);
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	public void AddAppicantInformation(String idMac_Applicants,String name, String surname, String Id_Number,String Client_Name,String PDP_Expiry_Date, String Vehicle_Used, String Assessor_Name,String Assessor_Surname, String Assessor_User_Id,String Date, String KM_End,String KM_Start, String Time_End, String Time_Start, String Weather, String Route,String Total_Score, String Starting_And_Stopping, String General_Driving,String Passing_Or_Overtaking, String General_Road_Behavior, String Observation_And_Anticipation, String Approaching_Junctions_Turning_Exiting, String Reversing, String Clutch, String Retarder_DSC_HillMode, String Comments, String PDA_No,String License_Code,String Job_Name,String PracticalDriversComplete )
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		///////////////////////////////////////////////////////////////////////////////////////////////////
		List<PracticalDriversAssessment> OldAssesment = ReadAssessmentsByInfo(idMac_Applicants,Client_Name);
		if(OldAssesment.size() > 0)
		{
			delete(OldAssesment.get(0));
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
		PracticalDriversAssessment Assessment = new PracticalDriversAssessment();
		
		Assessment.setIdMacApplicants(Integer.parseInt(idMac_Applicants));
		Assessment.setName(name);
		Assessment.setSurname(surname);
		Assessment.setIdNumber(Id_Number);
		Assessment.setClientName(Client_Name);
		Assessment.setPdpExpiryDate(PDP_Expiry_Date);
		Assessment.setVehicleUsed(Vehicle_Used);
		Assessment.setAssessorName(Assessor_Name);
		Assessment.setAssessorSurname(Assessor_Surname);
		Assessment.setAssessorUserId(Integer.parseInt(Assessor_User_Id));
		Assessment.setDate(Date);
		Assessment.setKmEnd(KM_End);
		Assessment.setKmStart(KM_Start);
		Assessment.setTimeEnd(Time_End);
		Assessment.setTimeStart(Time_Start);
		Assessment.setWeather(Weather);
		Assessment.setRoute(Route);
		Assessment.setTotalScore(new BigDecimal(Total_Score));
		Assessment.setStartingAndStopping(new BigDecimal(Starting_And_Stopping));
		Assessment.setGeneralDriving(new BigDecimal(General_Driving));
		Assessment.setObservationAndAnticipation(new BigDecimal(Observation_And_Anticipation));
		Assessment.setApproachingJunctionsTurningExiting(new BigDecimal(Approaching_Junctions_Turning_Exiting));
		Assessment.setPassingOrOvertaking(new BigDecimal(Passing_Or_Overtaking));
		Assessment.setGeneralRoadBehavior(new BigDecimal(General_Road_Behavior));
		Assessment.setObservationAndAnticipation(new BigDecimal(Observation_And_Anticipation));
		Assessment.setLicenseCode(License_Code);
		Assessment.setReversing(new BigDecimal(Reversing));
		Assessment.setClutch(new BigDecimal(Clutch));
		Assessment.setRetarderDscHillMode(new BigDecimal(Retarder_DSC_HillMode));
		Assessment.setComments(Comments);
		Assessment.setjobName(Job_Name);
		Assessment.setPracticalDriversTestComplete(PracticalDriversComplete);
		Assessment.setPracticalDriversTestComments(Comments);
		Assessment.setLastUsedDate(dateFormat.format(date));		
		
		session.save(Assessment);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public List<PracticalDriversAssessment> ReadAllAssessments()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from PracticalDriversAssessment");
		List<PracticalDriversAssessment> Assesment = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return Assesment;
		
		
		
	}
	
	
	public List<PracticalDriversAssessment> ReadAssessmentsByInfo(String idMac_Applicants, String Client_Name)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from PracticalDriversAssessment Where idMac_Applicants='"+idMac_Applicants.trim()+"' And Client_Name='"+Client_Name.trim()+"'");
		List<PracticalDriversAssessment> Assesment = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return Assesment;
		
		
		
	}
	
	public List<PracticalDriversAssessment> ReadAssessmentsByInfoByIDnumber(String Id_Number)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from PracticalDriversAssessment Where Id_Number='"+Id_Number+"'");
		List<PracticalDriversAssessment> Assesment = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return Assesment;
		
		
		
	}
	
	

}
