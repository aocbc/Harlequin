package aoc.Harlequin.DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;




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
	
	public void AddJobInformation( String jobName, String jobCode, String jobClientName,String jobDetails, String jobComments, String jobtype)
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
		SystemJob job = new SystemJob();
		
		job.setJobName(jobName);
		job.setJobCode(jobCode);
		job.setJobClientName(jobClientName);
		job.setJobDetails(jobDetails);
		job.setJobComments(jobComments);
		job.setJobType(jobtype);
		
		session.save(job);
				
		session.getTransaction().commit();
		
		session.close();
		
	}

}
