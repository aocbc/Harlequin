/**
 * 
 */
package aoc.Harlequin.DAOs;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import aoc.Harlequin.OBJs.ClientInterviews;
import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.ReferenceChecks;
import aoc.Harlequin.OBJs.SystemUser;
import aoc.Harlequin.util.HibernateUtil;

/**
 * @author Jateen
 *
 */
public class ReferenceCheckDAO extends HarlequinDAO
{
	
	
	public ReferenceChecks getReferenceCheckInfoById(int id)
	{
		
		
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		
		ReferenceChecks References = session.get(ReferenceChecks.class, id);
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
	   
		
		return References;
		
		
	}
	
	
	public void delete(Object entity) 
	{
		  Session hibernateSession = this.getSession(); 
		  
		  HibernateUtil.beginTransaction();
		        hibernateSession.delete(entity);
		        hibernateSession.flush();
		  HibernateUtil.commitTransaction();
	}
  
	
	
	
	public List<ReferenceChecks> GetUserById(String idMac_Applicants)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from ReferenceChecks Where idMac_Applicants = '"+idMac_Applicants+"'");
		List<ReferenceChecks> Reference = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Reference;
	}
	
	
	public List<ReferenceChecks> GetUserByIdNumber(String Id_Number)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from ReferenceChecks Where Id_Number = '"+Id_Number+"'");
		List<ReferenceChecks> Reference = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Reference;
	}
	
	
	
	public List<ReferenceChecks> GetUserByIdAndJob(String idMac_Applicants,String Job_Name)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from ReferenceChecks Where idMac_Applicants = '"+idMac_Applicants+"' and Job_Name ='"+Job_Name+"'");
		List<ReferenceChecks> Reference = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Reference;
	}
	
	
	
	public void AddReferenceChecksInfo(String idMac_Applicants,String Applicant_Name, String Applicant_Surname, String Id_Number, String All_Reference_Checks_Passed, String Applicants_Overall_Reference, String Criminal_Check_Passed, String Applicants_Criminal_checks_Criteria, String Exit_Medical_Done, String Reference_Check_Complete, String Username, String Usersurname, String Job_Name , String ReferenceCheckComments)
	{
		////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////
		List<ReferenceChecks> OldReferencecheck = GetUserByIdAndJob(idMac_Applicants, Job_Name);
		
		if(OldReferencecheck.size() > 0)
		{
			delete(OldReferencecheck.get(0));
		}
		////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		MacApplicants Applicant =  session.get(MacApplicants.class, Integer.valueOf(idMac_Applicants));
		
		
		ReferenceChecks ReferenceCheck = new ReferenceChecks();
		
		ReferenceCheck.setIdMacApplicants(Integer.valueOf(idMac_Applicants));
		ReferenceCheck.setApplicantName(Applicant_Name);
		ReferenceCheck.setApplicantSurname(Applicant_Surname);
		ReferenceCheck.setIdNumber(Id_Number);
		ReferenceCheck.setAllReferenceChecksPassed(All_Reference_Checks_Passed);
		ReferenceCheck.setApplicantsOverallReference(Applicants_Overall_Reference);
		ReferenceCheck.setCriminalCheckPassed(Criminal_Check_Passed);
		ReferenceCheck.setApplicantsOverallReference(Applicants_Overall_Reference);
		ReferenceCheck.setApplicantsCriminalChecksCriteria(Applicants_Criminal_checks_Criteria);
		ReferenceCheck.setExitMedicalDone(Exit_Medical_Done);
		ReferenceCheck.setReferenceCheckComplete(Reference_Check_Complete);
		ReferenceCheck.setReferenceCheckComments(ReferenceCheckComments);
		ReferenceCheck.setLastUsedDate(dateFormat.format(date));
		ReferenceCheck.setUsername(Username);
		ReferenceCheck.setUsersurname(Usersurname);
		ReferenceCheck.setJobName(Job_Name);
		
		
		session.save(ReferenceCheck);
				
		session.getTransaction().commit();
		
		
		
		session.close();
		
		Applicant.setReferenceChecksComplete(Reference_Check_Complete);
		Applicant.setReferenceChecksComments(ReferenceCheckComments);
		
		update(Applicant);

		
	}
	
	public void update(Object entity) 
	{  
		  Session hibernateSession = this.getSession();
		  HibernateUtil.beginTransaction();
		        //hibernateSession.save(entity);        
		        //hibernateSession.saveOrUpdate(entity);
		        hibernateSession.update(entity);
		     
		        HibernateUtil.commitTransaction();
		      
		        
		        
		 
	}
	
	public List<SystemUser> ReadAllUsers()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from SystemUser");
		List<SystemUser> User = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return User;
		
		
		
	}


	

	
	
	
	

}
