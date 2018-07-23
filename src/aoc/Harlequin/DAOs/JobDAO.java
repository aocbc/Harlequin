package aoc.Harlequin.DAOs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

		HibernateUtil.beginTransaction();
	   
		
		SystemJob jobs = session.get(SystemJob.class, id);
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
	   
		
		return jobs;
		
		
	}
	
	public List<SystemJob> ReadAllJobs()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from SystemJob");
		List<SystemJob> Job = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return Job;
		
		
		
	}
	///////////////////////////////////////////////////////////////////////////////
	//Function to delete an object from the database
	//////////////////////////////////////////////////////////////////////////////
	public void delete(Object entity) {
		  Session hibernateSession = this.getSession(); 
		  
		  HibernateUtil.beginTransaction();
		        hibernateSession.delete(entity);
		        hibernateSession.flush();
		  HibernateUtil.commitTransaction();
		  
		    hibernateSession.clear(); // ADDED 170302
	        hibernateSession.flush();
	        hibernateSession.close();
		 }
	
	///////////////////////////////////////////////////////////////////////////////
	//Function to Update a database object from the database
	//////////////////////////////////////////////////////////////////////////////
	public void update(Object entity) 
	{  
		  Session hibernateSession = this.getSession();
		  HibernateUtil.beginTransaction();
		        //hibernateSession.save(entity);        
		        //hibernateSession.saveOrUpdate(entity);
		        hibernateSession.update(entity);
		     
		        HibernateUtil.commitTransaction();
		      
		        
		        
		 
	}
	
	public List<SystemJob> ReadLastJob()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from SystemJob order by Job_Id DESC");
		query.setMaxResults(1);
		List<SystemJob> Job = query.list();
		
		session.clear(); 
		session.flush();
		session.close();
		
		return Job;
		
		
		
	}
	
	
	public List<SystemJob> GetClientNameByJobName(String Job_Name)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from SystemJob Where Job_Name = '"+Job_Name+"'");
		List<SystemJob> Job = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Job;
	}
	
	
	
	public List<SystemJob> GetJobInfoByJobName(String Job_Name)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from SystemJob Where Job_Name = '"+Job_Name+"'");
		List<SystemJob> Job = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Job;
	}
	
	
	
	
	public void AddJobInformation( String jobName, String jobCode, String jobClientName,String jobDetails, String jobComments, String jobtype)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		SystemJob job = new SystemJob();
		
		job.setJobName(jobName);
		job.setJobCode(jobCode);
		job.setJobClientName(jobClientName);
		job.setJobDetails(jobDetails);
		job.setJobComments(jobComments);
		job.setJobType(jobtype);
		job.setLastUsedDate(dateFormat.format(date));
		
		
		
		session.save(job);
				
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	
	
}
