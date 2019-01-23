package aoc.Harlequin.DAOs;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		PracticalDriversAssessment Assessments = new PracticalDriversAssessment();
		
		try
		{
			HibernateUtil.beginTransaction();
			Assessments = session.get(PracticalDriversAssessment.class, id);


		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: getAssessmentById - PracticalDrivingAssessmentDAO");
			System.out.println(ex.toString());
		}
		finally
		{


			if(session != null && session.isConnected())
			{
				session.clear();
				session.flush();
				session.close();
			}

		}
		
			
		return Assessments;
		
		
	}
	
	public void delete(Object entity) 
	{
		  Session hibernateSession = this.getSession(); 		  
		  try
		  {
			  
			  HibernateUtil.beginTransaction();
			  hibernateSession.delete(entity);
			  hibernateSession.flush();
			  HibernateUtil.commitTransaction();


		  }
		  catch(Exception ex)
		  {

		  	System.out.println("Error In Function: delete - PracticalDrivingAssessmentDAO");
		  	System.out.println(ex.toString());
		  }
		  finally
		  {


		  	if(hibernateSession != null && hibernateSession.isConnected())
		  	{
		  		hibernateSession.clear();
		  		hibernateSession.flush();
		  		hibernateSession.close();
		  	}

		  }
		  
	}
	
	public void AddAppicantInformation(String idMac_Applicants,String name, String surname, String Id_Number,String Client_Name,String PDP_Expiry_Date, String Vehicle_Used, String Assessor_Name,String Assessor_Surname, String Assessor_User_Id,String Date, String KM_End,String KM_Start, String Time_End, String Time_Start, String Weather, String Route,String Total_Score, String Starting_And_Stopping, String General_Driving,String Passing_Or_Overtaking, String General_Road_Behavior, String Observation_And_Anticipation, String Approaching_Junctions_Turning_Exiting, String Reversing, String Clutch, String Retarder_DSC_HillMode, String Comments, String PDA_No,String License_Code,String Job_Name,String PracticalDriversComplete, String StartingAndStopping1 ,String StartingAndStopping2, String StartingAndStopping3,  String StartingAndStopping4,  String StartingAndStopping5,  String StartingAndStopping6,  String StartingAndStopping7,  String GeneralDriving8,  String GeneralDriving9,  String GeneralDriving10,  String GeneralDriving11,  String GeneralDriving12,  String GeneralDriving13,  String GeneralDriving14,  String GeneralDriving15,  String GeneralDriving16,  String GeneralDriving17,  String PassingOrOvertaking18,  String PassingOrOvertaking19,  String PassingOrOvertaking20,  String PassingOrOvertaking21,  String GeneralRoadBehavior22,  String GeneralRoadBehavior23,  String ObservationAndAnticipation24,  String ObservationAndAnticipation25,  String ObservationAndAnticipation26,  String ObservationAndAnticipation27,  String ObservationAndAnticipation28,  String ApproachingJunctionsTurningExiting29,  String ApproachingJunctionsTurningExiting30,  String ApproachingJunctionsTurningExiting31,  String ApproachingJunctionsTurningExiting32,  String ApproachingJunctionsTurningExiting33,  String ApproachingJunctionsTurningExiting34,  String ApproachingJunctionsTurningExiting35,  String ApproachingJunctionsTurningExiting36,  String Reversing37,  String Reversing38,  String Reversing39,  String Clutch40,  String Clutch41,  String RetarderDSCHillMode42,  String RetarderDSCHillMode43,  String RetarderDSCHillMode44 , String RoadTestComments , String RoadTestComplete,  String ParkingTestComments ,String ParkingTestComplete, String ReverseTestComments, String ReverseTestComplete  )
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

		/*Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();*/
		
		Session session = this.getSession(); 
		try
		{
			 HibernateUtil.beginTransaction();
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
				Assessment.setPdaNo(PDA_No);
				
					
					Assessment.setStartingAndStopping1(Integer.parseInt(StartingAndStopping1));
					Assessment.setStartingAndStopping2(Integer.parseInt(StartingAndStopping2));
					Assessment.setStartingAndStopping3(Integer.parseInt(StartingAndStopping3));
					Assessment.setStartingAndStopping4(Integer.parseInt(StartingAndStopping4));
					Assessment.setStartingAndStopping5(Integer.parseInt(StartingAndStopping5));
					Assessment.setStartingAndStopping6(Integer.parseInt(StartingAndStopping6));
					Assessment.setStartingAndStopping7(Integer.parseInt(StartingAndStopping7));
				
				
				
					Assessment.setGeneralDriving8(Integer.parseInt(GeneralDriving8));
					Assessment.setGeneralDriving9(Integer.parseInt(GeneralDriving9));
					Assessment.setGeneralDriving10(Integer.parseInt(GeneralDriving10));
					Assessment.setGeneralDriving11(Integer.parseInt(GeneralDriving11));
					Assessment.setGeneralDriving12(Integer.parseInt(GeneralDriving12));
					Assessment.setGeneralDriving13(Integer.parseInt(GeneralDriving13));
					Assessment.setGeneralDriving14(Integer.parseInt(GeneralDriving14));
					Assessment.setGeneralDriving15(Integer.parseInt(GeneralDriving15));
					Assessment.setGeneralDriving16(Integer.parseInt(GeneralDriving16));
					Assessment.setGeneralDriving17(Integer.parseInt(GeneralDriving17));
				
				
				
					Assessment.setPassingOrOvertaking18(Integer.parseInt(PassingOrOvertaking18));
					Assessment.setPassingOrOvertaking19(Integer.parseInt(PassingOrOvertaking19));
					Assessment.setPassingOrOvertaking20(Integer.parseInt(PassingOrOvertaking20));
					Assessment.setPassingOrOvertaking21(Integer.parseInt(PassingOrOvertaking21));
					
					
				
				
					Assessment.setGeneralRoadBehavior22(Integer.parseInt(GeneralRoadBehavior22));
					Assessment.setGeneralRoadBehavior23(Integer.parseInt(GeneralRoadBehavior23));
				
				
				
					Assessment.setObservationAndAnticipation24(Integer.parseInt(ObservationAndAnticipation24));
					Assessment.setObservationAndAnticipation25(Integer.parseInt(ObservationAndAnticipation25));
					Assessment.setObservationAndAnticipation26(Integer.parseInt(ObservationAndAnticipation26));
					Assessment.setObservationAndAnticipation27(Integer.parseInt(ObservationAndAnticipation27));
					Assessment.setObservationAndAnticipation28(Integer.parseInt(ObservationAndAnticipation28));
				
				
				
					Assessment.setApproachingJunctionsTurningExiting29(Integer.parseInt(ApproachingJunctionsTurningExiting29));
					Assessment.setApproachingJunctionsTurningExiting30(Integer.parseInt(ApproachingJunctionsTurningExiting30));
					Assessment.setApproachingJunctionsTurningExiting31(Integer.parseInt(ApproachingJunctionsTurningExiting31));
					Assessment.setApproachingJunctionsTurningExiting32(Integer.parseInt(ApproachingJunctionsTurningExiting32));
					
					Assessment.setApproachingJunctionsTurningExiting33(Integer.parseInt(ApproachingJunctionsTurningExiting33));
					Assessment.setApproachingJunctionsTurningExiting34(Integer.parseInt(ApproachingJunctionsTurningExiting34));
					Assessment.setApproachingJunctionsTurningExiting35(Integer.parseInt(ApproachingJunctionsTurningExiting35));
					Assessment.setApproachingJunctionsTurningExiting36(Integer.parseInt(ApproachingJunctionsTurningExiting36));
					
					
					Assessment.setReversing37(Integer.parseInt(Reversing37));
					Assessment.setReversing38(Integer.parseInt(Reversing38));
					Assessment.setReversing39(Integer.parseInt(Reversing39));
				
					Assessment.setClutch40(Integer.parseInt(Clutch40));
					Assessment.setClutch41(Integer.parseInt(Clutch41));
					
				    Assessment.setRetarderDSCHillMode42(Integer.parseInt(RetarderDSCHillMode42));
					Assessment.setRetarderDSCHillMode43(Integer.parseInt(RetarderDSCHillMode43));
					Assessment.setRetarderDSCHillMode44(Integer.parseInt(RetarderDSCHillMode44));
					
					Assessment.setRoadTestPassed(RoadTestComplete);
					Assessment.setRoadTestComments(RoadTestComments);
					
					Assessment.setParkingTestPassed(ParkingTestComplete);
					Assessment.setParkingTestComments(ParkingTestComments);
					
					Assessment.setReverseTestComments(ReverseTestComments);
					Assessment.setReverseTestPassed(ReverseTestComplete);
					
				session.save(Assessment);
				session.getTransaction().commit();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddAppicantInformation - PracticalDrivingAssessmentDAO");
			System.out.println(ex.toString());
		}
		finally
		{


			if(session != null && session.isConnected())
			{
				session.close();
			}

		}
		
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
		
		
		
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();*/
		Session session = this.getSession(); 
		try
		{
			HibernateUtil.beginTransaction();
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

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddAppicantInformation - ClientInterviewDAO");
			System.out.println(ex.toString());
		}
		finally
		{

			if(session != null && session.isConnected())
			{
				
				session.close();
			}

		}
		
	}
	
	public List<PracticalDriversAssessment> ReadAllAssessments()
	{
		Session session = this.getSession();
		
		List<PracticalDriversAssessment> Assesment = new ArrayList<PracticalDriversAssessment>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<PracticalDriversAssessment> query = session.createQuery("from PracticalDriversAssessment");
			Assesment = query.list();
			

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddAppicantInformation - ClientInterviewDAO");
			System.out.println(ex.toString());
		}
		finally
		{


			if(session != null && session.isConnected())
			{
				session.clear();
				session.flush();
				session.close();
			}

		}

		
		return Assesment;
	}
	
	
	public List<PracticalDriversAssessment> ReadAssessmentsByInfo(String idMac_Applicants, String Client_Name)
	{
		Session session = this.getSession();
		List<PracticalDriversAssessment> Assesment = new ArrayList<PracticalDriversAssessment>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<PracticalDriversAssessment> query = session.createQuery("from PracticalDriversAssessment Where idMac_Applicants='"+idMac_Applicants.trim()+"' And Client_Name='"+Client_Name.trim()+"'");
			Assesment = query.list();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddAppicantInformation - ClientInterviewDAO");
			System.out.println(ex.toString());
		}
		finally
		{


			if(session != null && session.isConnected())
			{
				session.clear();
				session.flush();
				session.close();
			}

		}
		
		return Assesment;
	}
	
	public List<PracticalDriversAssessment> ReadAssessmentsByInfoByIDnumber(String Id_Number)
	{
		Session session = this.getSession();
		List<PracticalDriversAssessment> Assesment = new ArrayList<PracticalDriversAssessment>();

		try
		{
			HibernateUtil.beginTransaction();
			Query<PracticalDriversAssessment> query = session.createQuery("from PracticalDriversAssessment Where Id_Number='"+Id_Number+"'");
			Assesment = query.list();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddAppicantInformation - ClientInterviewDAO");
			System.out.println(ex.toString());
		}
		finally
		{


			if(session != null && session.isConnected())
			{
				session.clear();
				session.flush();
				session.close();
			}

		}
		
		return Assesment;
		
	}
	
	

}
