/**
 * 
 */
package aoc.Harlequin.DAOs;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
		ReferenceChecks References = new ReferenceChecks();
		try
		{
			HibernateUtil.beginTransaction();
			References = session.get(ReferenceChecks.class, id);
		}
		catch(Exception ex)
		{
			System.out.println("Error In Function: getReferenceCheckInfoById - ReferenceCheckDAO");
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
			
		return References;
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

		  	System.out.println("Error In Function: delete - ReferenceCheckDAO");
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
  
	
	
	
	public List<ReferenceChecks> GetUserById(String idMac_Applicants)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		List<ReferenceChecks> Reference = new ArrayList<ReferenceChecks>();
		
		try
		{
			Query<ReferenceChecks> query = session.createQuery("from ReferenceChecks Where idMac_Applicants = '"+idMac_Applicants+"'");
			Reference = query.list();
		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: GetUserById - ReferenceCheckDAO");
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
		
	
		return Reference;
	}
	
	
	public List<ReferenceChecks> GetUserByIdNumber(String Id_Number)
	{
		Session session = this.getSession();
		List<ReferenceChecks> Reference = new ArrayList<ReferenceChecks>();

		try
		{
			HibernateUtil.beginTransaction();
			Query<ReferenceChecks> query = session.createQuery("from ReferenceChecks Where Id_Number = '"+Id_Number+"'");
			Reference = query.list();
		

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: GetUserByIdNumber - ReferenceCheckDAO");
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
		
			
		return Reference;
	}
	
	
	
	public List<ReferenceChecks> GetUserByIdAndJob(String idMac_Applicants,String Job_Name)
	{
		Session session = this.getSession();
		List<ReferenceChecks> Reference = new ArrayList<ReferenceChecks>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<ReferenceChecks> query = session.createQuery("from ReferenceChecks Where idMac_Applicants = '"+idMac_Applicants+"' and Job_Name ='"+Job_Name+"'");
			Reference = query.list();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: GetUserByIdAndJob - ReferenceCheckDAO");
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
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();*/
		Session session = this.getSession();

		MacApplicants Applicant =  new MacApplicants();

		try
		{
			
			HibernateUtil.beginTransaction();
			Applicant =  session.get(MacApplicants.class, Integer.valueOf(idMac_Applicants));
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
			
			if(ReferenceCheckComments.equals(""))
			{
				ReferenceCheck.setReferenceCheckComments("N/A");
			}
			else
			{
				ReferenceCheck.setReferenceCheckComments(ReferenceCheckComments);
			}
			
			ReferenceCheck.setLastUsedDate(dateFormat.format(date));
			ReferenceCheck.setUsername(Username);
			ReferenceCheck.setUsersurname(Usersurname);
			ReferenceCheck.setJobName(Job_Name);
			
			
			session.save(ReferenceCheck);
					
			session.getTransaction().commit();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddReferenceChecksInfo - ReferenceCheckDAO");
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
			
			Applicant.setReferenceChecksComplete(Reference_Check_Complete);
			
			if(ReferenceCheckComments.equals(""))
			{
				Applicant.setReferenceChecksComments("N/A");
			}
			else
			{
				Applicant.setReferenceChecksComments(ReferenceCheckComments);
			}
			
			
			update(Applicant);

		}
		
	}
	
	public void update(Object entity) 
	{  
		  		Session hibernateSession = this.getSession();
		 
		      
		        try
		        {
		        	    HibernateUtil.beginTransaction();
				        hibernateSession.update(entity);
				        HibernateUtil.commitTransaction();

		        }
		        catch(Exception ex)
		        {

		        	System.out.println("Error In Function: update - ReferenceCheckDAO");
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
	
	public List<SystemUser> ReadAllUsers()
	{
		Session session = this.getSession();
		List<SystemUser> User = new ArrayList<SystemUser>();
		
		try
		{	
			HibernateUtil.beginTransaction();
			Query<SystemUser> query = session.createQuery("from SystemUser");
			User = query.list();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: ReadAllUsers - ReferenceCheckDAO");
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

		return User;

	}


	

	
	
	
	

}
