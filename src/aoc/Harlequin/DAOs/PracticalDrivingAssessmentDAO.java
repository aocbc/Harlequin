package aoc.Harlequin.DAOs;

import java.util.List;

import org.hibernate.Session;


import org.hibernate.query.Query;

import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.PracticalDriversAssessment;
import aoc.Harlequin.util.HibernateUtil;

public class PracticalDrivingAssessmentDAO extends HarlequinDAO {
	
	public PracticalDriversAssessment getClientApplicantoById(int id)
	{
		
		
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		
		PracticalDriversAssessment Assessments = session.get(PracticalDriversAssessment.class, id);
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
	   
		
		return Assessments;
		
		
	}
	
	
	
	public void AddAppicantInformation(int idMac_Applicants,String name, String surname, String Id_Number,String Client_Name,String PDP_Expiry_Date, String Vehicle_Used, String Assessor_Name,String Assessor_Surname, int Assessor_User_Id,String Date, String KM_End,String KM_Start, String Time_End, String Time_Start, String Weather, String Route,double Total_Score, double Starting_And_Stopping, double General_Driving,double Passing_Or_Overtaking, double General_Road_Behavior, double Observation_And_Anticipation, double Approaching_Junctions_Turning_Exiting, double Reversing, double Clutch, double Retarder_DSC_HillMode, String Comments, int PDA_No)
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
		PracticalDriversAssessment Assessment = new PracticalDriversAssessment();
		
		Assessment.setIdMacApplicants(idMac_Applicants);
		Assessment.setName(name);
		Assessment.setSurname(surname);
		Assessment.setIdNumber(Id_Number);
		Assessment.setClientName(Client_Name);
		Assessment.setPdpExpiryDate(PDP_Expiry_Date);
		Assessment.setVehicleUsed(Vehicle_Used);
		Assessment.setAssessorName(Assessor_Name);
		Assessment.setAssessorSurname(Assessor_Surname);
		Assessment.setAssessorUserId(Assessor_User_Id);
		Assessment.setDate(Date);
		Assessment.setKmEnd(KM_End);
		Assessment.setKmStart(KM_Start);
		Assessment.setTimeEnd(Time_End);
		Assessment.setTimeStart(Time_Start);
		Assessment.setWeather(Weather);
		Assessment.setRoute(Route);
		Assessment.setTotalScore(Total_Score);
		Assessment.setStartingAndStopping(Starting_And_Stopping);
		Assessment.setGeneralDriving(General_Driving);
		Assessment.setObservationAndAnticipation(Observation_And_Anticipation);
		Assessment.setApproachingJunctionsTurningExiting(Approaching_Junctions_Turning_Exiting);
		Assessment.setReversing(Reversing);
		Assessment.setReversing(Reversing);
		Assessment.setClutch(Clutch);
		Assessment.setRetarderDscHillMode(Retarder_DSC_HillMode);
		Assessment.setComments(Comments);
		Assessment.setPdaNo(PDA_No);
		
		
		
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
