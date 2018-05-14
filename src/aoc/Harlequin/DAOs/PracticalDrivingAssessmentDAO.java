package aoc.Harlequin.DAOs;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;


import org.hibernate.query.Query;



import aoc.Harlequin.OBJs.PracticalDriversAssessment;
import aoc.Harlequin.util.HibernateUtil;

public class PracticalDrivingAssessmentDAO extends HarlequinDAO {
	
	public PracticalDriversAssessment getAssessmentById(int id)
	{
		
		
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		
		PracticalDriversAssessment Assessments = session.get(PracticalDriversAssessment.class, id);
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
	   
		
		return Assessments;
		
		
	}
	
	
	
	public void AddAppicantInformation(String idMac_Applicants,String name, String surname, String Id_Number,String Client_Name,String PDP_Expiry_Date, String Vehicle_Used, String Assessor_Name,String Assessor_Surname, String Assessor_User_Id,String Date, String KM_End,String KM_Start, String Time_End, String Time_Start, String Weather, String Route,String Total_Score, String Starting_And_Stopping, String General_Driving,String Passing_Or_Overtaking, String General_Road_Behavior, String Observation_And_Anticipation, String Approaching_Junctions_Turning_Exiting, String Reversing, String Clutch, String Retarder_DSC_HillMode, String Comments, String PDA_No,String License_Code)
	{
		
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
		Assessment.setReversing(new BigDecimal(Reversing));
		Assessment.setClutch(new BigDecimal(Clutch));
		Assessment.setRetarderDscHillMode(new BigDecimal(Retarder_DSC_HillMode));
		Assessment.setComments(Comments);
		Assessment.setPdaNo(Integer.parseInt(PDA_No));
		
		
		
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

}
