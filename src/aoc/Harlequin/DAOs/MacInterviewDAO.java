package aoc.Harlequin.DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.MacLabourInterView;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemUser;
import aoc.Harlequin.util.HibernateUtil;

public class MacInterviewDAO extends HarlequinDAO {
	
	public MacLabourInterView getInterviewInfoById(int id)
	{
		
		
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		
		MacLabourInterView Interview = session.get(MacLabourInterView.class, id);
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
	   
		
		return Interview;
		
		
	}
	
	
	
	public void delete(Object entity) 
	{
		  Session hibernateSession = this.getSession(); 
		  
		  HibernateUtil.beginTransaction();
		  hibernateSession.delete(entity);
		  hibernateSession.flush();
		  HibernateUtil.commitTransaction();
		  
	}
  
	
	
	public void AddInterviewInformation( String idMac_Applicants, String Name,String Surname, String Id_Number,	String Client_Name, String Id_Verified,String Work_History_Verified,String Job_Name, String Drivers_License_Verified,String SAP_Check, String Criminal_Record, String Criminal_Record_comments, String Union_Member,String Union_Name, String Applicant_Passed_Interview, String Applicant_Presentable,String Applicant_Attitude, String Interview_Comments, String Formal_Interview_Complete)
	{
		
		///////////////////////////////////////////////////////////////////////////////////////////////////
		List<MacLabourInterView> OldInterview = GetInterviewByInfo(Id_Number,idMac_Applicants,Job_Name);
		if(OldInterview.size() > 0)
		{
			delete(OldInterview.get(0));
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		

		MacLabourInterView Interview = new MacLabourInterView();
		
		
		Interview.setIdMacApplicants(Integer.parseInt(idMac_Applicants));
		Interview.setName(Name);
		Interview.setSurname(Surname);
		Interview.setIdNumber(Id_Number);
		Interview.setClientName(Client_Name);
		Interview.setIdVerified(Id_Verified);
		Interview.setWorkHistoryVerified(Work_History_Verified);
		Interview.setJobName(Job_Name);
		Interview.setDriversLicenseVerified(Drivers_License_Verified);
		Interview.setSapCheck(SAP_Check);
		Interview.setCriminalRecord(Criminal_Record);
		Interview.setCriminalRecordComments(Criminal_Record_comments);
		Interview.setUnionMember(Union_Member);
		Interview.setUnionName(Union_Name);
		Interview.setApplicantPassedInterview(Applicant_Passed_Interview);
		Interview.setApplicantPresentable(Applicant_Presentable);
		Interview.setApplicantAtttitude(Applicant_Attitude);
		Interview.setInterviewComments(Interview_Comments);
		Interview.setFormalInterviewComplete(Formal_Interview_Complete);
		
		
		
		session.save(Interview);
				
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	public List<MacLabourInterView> GetClientInfoByName(String ClientName)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from MacLabourInterView Where Client_Name = '"+ClientName+"'");
		List<MacLabourInterView> Client = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Client;
	}
	
	
	public List<MacLabourInterView> GetInterviewByInfo(String Id_Number, String idMac_Applicants,String Job_Name)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from MacLabourInterView Where idMac_Applicants = '"+idMac_Applicants.trim()+"' AND Id_Number = '"+Id_Number.trim()+"' AND Job_Name ='"+Job_Name.trim()+"'");
		List<MacLabourInterView> Interview = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		
		return Interview;
	}
	
	
	public List<MacLabourInterView> ReadAllInterviews()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from MacLabourInterView");
		List<MacLabourInterView> Interview = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return Interview;
		
		
		
	}

}
