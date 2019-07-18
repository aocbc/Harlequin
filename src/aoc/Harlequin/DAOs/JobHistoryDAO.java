package aoc.Harlequin.DAOs;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import aoc.Harlequin.OBJs.JobHistory;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemJob;
import aoc.Harlequin.util.HibernateUtil;

public class JobHistoryDAO extends HarlequinDAO {
	
	public JobHistory getJobInfoById(int id)
	{
		
		
		Session session = this.getSession();
		JobHistory jobs = new JobHistory();

		try
		{
			HibernateUtil.beginTransaction();
			jobs = session.get(JobHistory.class, id);
			
		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: getJobInfoById - JobHistoryDAO");
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

		
		return jobs;
		
		
	}
	
	public List<JobHistory> ReadAllJobHistoryByIdNumber(String IdNumber)
	{
		Session session = this.getSession();
		List<JobHistory> JobHistory = new ArrayList<JobHistory>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<JobHistory> query = session.createQuery("from JobHistory WHERE idMac_Applicants = '"+ IdNumber.trim()+"'");
			JobHistory = query.list();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: ReadAllJobHistoryByIdNumber - JobHistoryDAO");
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
	
		return JobHistory;
		
		
		
	}
	
	
	public List<JobHistory> ReadAllJobHistoryByidJob_History(int idJob_History)
	{
		Session session = this.getSession();
		List<JobHistory> JobHistory = new ArrayList<JobHistory>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<JobHistory> query = session.createQuery("from JobHistory WHERE idJob_History = "+ idJob_History);
			JobHistory = query.list();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: ReadAllJobHistoryByidJob_History - JobHistoryDAO");
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
	
		return JobHistory;
		
		
		
	}
	
	public List<JobHistory> ReadAllJobHistory()
	{
		Session session = this.getSession();
		List<JobHistory> JobHistory = new ArrayList<JobHistory>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<JobHistory> query = session.createQuery("from JobHistory");
			JobHistory = query.list();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: ReadAllJobHistory - JobHistoryDAO");
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
		
		
	
		
		return JobHistory;
		
		
		
	}

	
	///////////////////////////////////////////////////////////////////////////////
	//Function to delete an object from the database
	//////////////////////////////////////////////////////////////////////////////
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

		  	System.out.println("Error In Function: AddAppicantInformation - JobHistoryDAO");
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
	
	public void AddJobHistroy( String Currently_Employed,String Job_Role, String Job_Description, String Employer_Contact_Person,String Employer_Contact_Number, String Employer_Industry, String Period_From,String Period_To, String idMac_Applicants, String Name, String Surname,String Employer_Name)
	{
		
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();*/
		Session session = this.getSession(); 
		
		try
		{
			HibernateUtil.beginTransaction();
			JobHistory history = new JobHistory();
			
			history.setJobRole(Job_Role);;
			history.setJobDescription(Job_Description);
			history.setEmployerContactPerson(Employer_Contact_Person);
			history.setEmployerContactNumber(Employer_Contact_Number);
			history.setEmployerIndustry(Employer_Industry);
			history.setPeriodTo(Period_To);
			history.setPeriodFrom(Period_From);
			history.setName(Name);
			history.setSurname(Surname);
			history.setEmployerName(Employer_Name);
			history.setIdMacApplicants(idMac_Applicants);
			history.setCurrentlyEmployed(Currently_Employed);
			
			session.save(history);		
			session.getTransaction().commit();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddJobHistroy - JobHistoryDAO");
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

		session.close();
		
	}
}
