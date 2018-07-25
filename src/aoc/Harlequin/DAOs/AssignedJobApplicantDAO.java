package aoc.Harlequin.DAOs;

import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.json.JSONArray;
import org.json.JSONObject;

import aoc.Harlequin.OBJs.AssignedJobApplicantList;
import aoc.Harlequin.OBJs.BlockedNumberList;
import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.SystemJob;
import aoc.Harlequin.util.HibernateUtil;

public class AssignedJobApplicantDAO extends HarlequinDAO 
{
	
	public List<AssignedJobApplicantList> ReadAllAssignedJobsInfo()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from AssignedJobApplicantList");
		List<AssignedJobApplicantList> AssignedJobs = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return AssignedJobs;
		
		
		
	}
	
	public List<AssignedJobApplicantList> ReadAllAssignedJobsInfobyIdNumber(String Id_Number)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from AssignedJobApplicantList where idMacApplicants = '" + Id_Number+"'" );
		List<AssignedJobApplicantList> AssignedJobs = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return AssignedJobs;
		
		
		
	}
	
	
	public void UpdateAssignedJobStatusMacLabourInterview(String Id_Number, String JobName,String StageInProcess, String StageStatus, String Complete, String Comments)
	{
		List<AssignedJobApplicantList> AssignedJobs = ReadAllAssignedJobsInfoByIDAndJobName(Id_Number,  JobName);
		
		System.out.println("Size Assigned Jobs:"+ AssignedJobs.size() );
		
		if(AssignedJobs.size()> 0)
		{
			AssignedJobApplicantList Assigned_Job = AssignedJobs.get(0);
			
			Assigned_Job.setStageInProcess(StageInProcess);
			Assigned_Job.setStageStatus(StageStatus);
			Assigned_Job.setMacLabInterviewComplete(Complete);
			Assigned_Job.setMacLabourInterviewComments(Comments);
			
			Session hibernateSession = this.getSession();
			hibernateSession.update(Assigned_Job);
		     
	        HibernateUtil.commitTransaction();
		
					
		}
		
	}
	////////////////////////////////////
	///NEW Function 19-07-2018
	//////////////////////////////////
	public void UpdateAssignedJobStatusPracticalDrivers(String Id_Number, String JobName,String StageInProcess, String StageStatus, String Complete, String Comments)
	{
		List<AssignedJobApplicantList> AssignedJobs = ReadAllAssignedJobsInfoByIDAndJobNamePracticalDrivers(Id_Number,  JobName);
		
		System.out.println("Size Assigned Jobs:"+ AssignedJobs.size() );
		
		if(AssignedJobs.size()> 0)
		{
			AssignedJobApplicantList Assigned_Job = AssignedJobs.get(0);
			
			Assigned_Job.setStageInProcess(StageInProcess);
			Assigned_Job.setStageStatus(StageStatus);
			Assigned_Job.setPracticalDriversTestComments(Comments);
			Assigned_Job.setPracticalDriversTestComplete(Complete);
			
			Session hibernateSession = this.getSession();
			hibernateSession.update(Assigned_Job);
		     
	        HibernateUtil.commitTransaction();
		
					
		}
		
	}
	////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	
	public List<AssignedJobApplicantList> ReadAllAssignedJobsInfoByIDAndJobName(String Id_Number, String JobName)
	{
		Session session = this.getSession();
		//HibernateUtil.beginTransaction();
		
		Query query = session.createQuery("from AssignedJobApplicantList WHERE idMac_Applicants = '"+Id_Number+"' AND Job_Name = '"+JobName+"'");
		List<AssignedJobApplicantList> AssignedJobs = query.list();
		
		//AssignedJobApplicantList x = AssignedJobs.get(0);
		
		
		/*session.clear(); 
		session.flush();
		session.close();*/
		
		
		
		return AssignedJobs;
		
		
		
	}
	
	
	public List<AssignedJobApplicantList> ReadAllAssignedJobsInfoByIDAndJobNamePracticalDrivers(String Id_Number, String JobName)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		Query query = session.createQuery("from AssignedJobApplicantList WHERE idMac_Applicants = '"+Id_Number+"' AND Job_Name = '"+JobName+"'");
		List<AssignedJobApplicantList> AssignedJobs = query.list();
		
		//AssignedJobApplicantList x = AssignedJobs.get(0);
		
		
		/*session.clear(); 
		session.flush();
		session.close();
		*/
		
		
		return AssignedJobs;
		
		
		
	}
	
	
	public List<AssignedJobApplicantList> ReadAllAssignedJobsInfoByID(String Id_Number)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		Query query = session.createQuery("from AssignedJobApplicantList WHERE idMac_Applicants = '"+Id_Number+"'");
		List<AssignedJobApplicantList> AssignedJobs = query.list();
		
		
		
		
		session.clear(); 
		session.flush();
		session.close();
		
		return AssignedJobs;
		
		
		
	}
	
	
	///////////////////////////////////////////////////////////////////////////////
	//Function to delete an object from the database
	//////////////////////////////////////////////////////////////////////////////
	public void delete(Object entity) 
	{
		  Session hibernateSession = this.getSession(); 
		  
		  HibernateUtil.beginTransaction();
		        hibernateSession.delete(entity);
		        hibernateSession.flush();
		  HibernateUtil.commitTransaction();
		  
		    hibernateSession.clear(); 
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
	
	
	
	
	@SuppressWarnings("deprecation")
	public void AddAssignedJob(String JobName, String idMacApplicants)
	{
		
		//Reading the Applicants Information from the Id_Number Provided
		/////////////////////////////////////////////////////////////////////
		MacApplicantDAO ApplicantObject = new MacApplicantDAO();
		List<MacApplicants> Applicant = ApplicantObject.GetApplicantsByApplicantId(idMacApplicants);
		
		
		//Reading the Job Information from the JobName Provided
		////////////////////////////////////////////////////////////////////
		JobDAO Object  = new JobDAO();
		List<SystemJob> Jobs  = Object.GetJobInfoByJobName(JobName);
		
		//Checking if the Job and Applicant Exists
		////////////////////////////////////////
		if(Jobs.size() > 0 && Applicant.size()> 0)
		{	
			    Session session = HibernateUtil.getSessionFactory().openSession();
				session.beginTransaction();
				
				
				
				AssignedJobApplicantList AssignedJob = new AssignedJobApplicantList();
				
				
				AssignedJob.setJobId(Jobs.get(0).getJobId());
				AssignedJob.setJobName(Jobs.get(0).getJobName());
				AssignedJob.setJobCode(Jobs.get(0).getJobCode());
				AssignedJob.setJobClientName(Jobs.get(0).getJobClientName());
				AssignedJob.setJobDetails(Jobs.get(0).getJobDetails()	);
				AssignedJob.setJobComments(StringEscapeUtils.escapeJava(Jobs.get(0).getJobComments().toString()));
				AssignedJob.setJobType(Jobs.get(0).getJobType());
				AssignedJob.setIdMacApplicants(idMacApplicants);
				AssignedJob.setName(Applicant.get(0).getName().toString());
				AssignedJob.setSurname(Applicant.get(0).getSurname().toString());
				AssignedJob.setStageInProcess("MacLabour Interview");
				AssignedJob.setStageStatus("Recently Assigned to a new Job");
				
				
				session.save(AssignedJob);
						
				session.getTransaction().commit();
				
				
				
				session.close();
		}

		
	}
	

}
