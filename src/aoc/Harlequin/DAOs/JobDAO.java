package aoc.Harlequin.DAOs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;








import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemJob;
import aoc.Harlequin.util.HibernateUtil;

public class JobDAO extends HarlequinDAO {
	
	public SystemJob getJobInfoById(int id)
	{
		
		
		Session session = this.getSession();
		SystemJob jobs = new SystemJob();
		try
		{
			HibernateUtil.beginTransaction();
			jobs = session.get(SystemJob.class, id);

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: getJobInfoById - JobDAO");
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
	
	public List<SystemJob> ReadAllJobs()
	{
		Session session = this.getSession();
		List<SystemJob> Job = new ArrayList<SystemJob>();
		
		try
		{
			HibernateUtil.beginTransaction();
			
			Query<SystemJob> query = session.createQuery("from SystemJob");
			Job = query.list();
			

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: ReadAllJobs - JobDAO");
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

		return Job;
		
		
		
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
	
			  		System.out.println("Error In Function: delete - JobDAO");
			  		System.out.println(ex.toString());
			  }
			  finally
			  {
	
	
			  	if(hibernateSession != null && hibernateSession.isConnected())
			  	{
			  		 hibernateSession.clear(); // ADDED 170302
				     hibernateSession.flush();
				     hibernateSession.close();
			  	}
	
			  }
			  
		 
		  
		   
		}
	
	///////////////////////////////////////////////////////////////////////////////
	//Function to Update a database object from the database
	//////////////////////////////////////////////////////////////////////////////
	public void update(Object entity) 
	{  
		  Session hibernateSession = this.getSession();
		  
		  try
		  {
			    HibernateUtil.beginTransaction();
		        //hibernateSession.save(entity);        
		        //hibernateSession.saveOrUpdate(entity);
		        hibernateSession.update(entity);
		        HibernateUtil.commitTransaction();

		  }
		  catch(Exception ex)
		  {
			  	System.out.println("Error In Function: AddAppicantInformation - MacApplicantDAO");
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
	
	public List<SystemJob> ReadLastJob()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		List<SystemJob> Job = new ArrayList<>();
		
		try
		{
			Query<SystemJob> query = session.createQuery("from SystemJob order by Job_Id DESC");
			query.setMaxResults(1);
			Job = query.list();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: ReadLastJob - JobDAO");
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
		

		return Job;

	}
	
	
	public List<SystemJob> GetClientNameByJobName(String Job_Name)
	{
		Session session = this.getSession();
		List<SystemJob> Job = new ArrayList<SystemJob>();
		
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<SystemJob> query = session.createQuery("from SystemJob Where Job_Name = '"+Job_Name+"'");
			Job = query.list();
			

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: GetClientNameByJobName - JobDAO");
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
		
	
		return Job;
	}
	
	
	
	public List<SystemJob> GetJobInfoByJobName(String Job_Name)
	{
		Session session = this.getSession();
		List<SystemJob> Job = new ArrayList<SystemJob>();
		
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<SystemJob> query = session.createQuery("from SystemJob Where Job_Name = '"+Job_Name+"'");
			Job = query.list();
		

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: GetJobInfoByJobName - MacApplicantDAO");
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

		return Job;
	}
	
	
	
	
	public void AddJobInformation( String jobName, String Job_Date,String jobCode, String jobClientName,String jobDetails, String jobComments, String jobtype)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Session session = this.getSession();
		
		try
		{
			/*Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();*/
			HibernateUtil.beginTransaction();
			SystemJob job = new SystemJob();

			job.setJobName(jobName.trim());
			job.setJobCode(jobCode.trim());
			job.setJobClientName(jobClientName.trim());
			job.setJobDetails(jobDetails.trim());
			job.setJobComments(jobComments.trim());
			job.setJobType(jobtype.trim());
			job.setLastUsedDate(dateFormat.format(date));
			job.setJobDate(Job_Date);

			session.save(job);				
			session.getTransaction().commit();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddAppicantInformation - MacApplicantDAO");
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

		
	}
	
	public int getLastJobId()
	{
		Session session = this.getSession();
		List<SystemJob> Job = new ArrayList<SystemJob>();
		int job_id = 0;
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<SystemJob> query = session.createQuery("from SystemJob");
			Job = query.list();
			int size = Job.size();
			if(Job!= null)
			{
				job_id = Job.get(size-1).getJobId();

			}

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: GetJobInfoByJobName - MacApplicantDAO");
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

		return job_id;
	}
	
	
	
}
