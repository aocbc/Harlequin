package aoc.Harlequin.DAOs;

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

		HibernateUtil.beginTransaction();
	   
		
		JobHistory jobs = session.get(JobHistory.class, id);
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
	   
		
		return jobs;
		
		
	}
	
	public List<JobHistory> ReadAllJobHistoryByIdNumber(String IdNumber)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from JobHistory WHERE idMac_Applicants = '"+ IdNumber+"'");
		List<JobHistory> JobHistory = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return JobHistory;
		
		
		
	}
	
	public List<JobHistory> ReadAllJobHistory()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from JobHistory");
		List<JobHistory> JobHistory = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return JobHistory;
		
		
		
	}

	
	public void AddJobHistroy( String Job_Role, String Job_Description, String Employer_Contact_Person,String Employer_Contact_Number, String Employer_Industry, String Period_From,String Period_To, String idMac_Applicants, String Name, String Surname,String Employer_Name)
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
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
		
		session.save(history);
				
		session.getTransaction().commit();
		
		session.close();
		
	}
}
