package aoc.Harlequin.DAOs;

import java.util.ArrayList;
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
		List<AssignedJobApplicantList> AssignedJobs = new ArrayList<AssignedJobApplicantList>(); 
		try
		{
			
			HibernateUtil.beginTransaction();

			Query<AssignedJobApplicantList> query = session.createQuery("from AssignedJobApplicantList");
			AssignedJobs = query.list();
			System.out.println("Testing2");
		}
		catch(Exception ex)
		{
			System.out.println("Error In Function: ReadAllAssignedJobsInfo - AssignedJobApplicantDAO");
			System.out.println(ex.toString());
		}
		finally
		{
			if(session != null && session.isConnected() && session.isOpen())
			{
				session.clear(); // ADDED 170302
				session.flush();
				session.close();
			}
		}
		
		
		return AssignedJobs;
	}
	
	public List<AssignedJobApplicantList> ReadAllAssignedJobsInfobyIdNumber(String Id_Number)
	{
		Session session = this.getSession();
		List<AssignedJobApplicantList> AssignedJobs = new ArrayList<AssignedJobApplicantList>();
		
		//System.out.println("TEsting Function Read by id assigned jobs");
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<AssignedJobApplicantList> query = session.createQuery("from AssignedJobApplicantList where idMacApplicants = '" + Id_Number+"'" );
			AssignedJobs = query.list();
		}
		catch(Exception ex)
		{
			System.out.println("Error In Function: ReadAllAssignedJobsInfobyIdNumber - AssignedJobApplicantDAO");
			System.out.println(ex.toString());
		}
		finally
		{
			if(session != null && session.isConnected() && session.isOpen())
			{
				session.clear(); // ADDED 170302
				session.flush();
				session.close();
			}
		}
		
		
		
		
		
		
		return AssignedJobs;
	}
	
	
	public void UpdateAssignedJobStatusMacLabourInterview(String Id_Number, String JobName,String StageInProcess, String StageStatus, String Complete, String Comments)
	{
		List<AssignedJobApplicantList> AssignedJobs = ReadAllAssignedJobsInfoByIDAndJobName(Id_Number,  JobName);

		System.out.println("Testing New Update Assigned Jobs Mac Labour");
		
		if(AssignedJobs.size()> 0)
		{
			AssignedJobApplicantList Assigned_Job = AssignedJobs.get(0);
			Assigned_Job.setStageInProcess(StageInProcess);
			Assigned_Job.setStageStatus(StageStatus);
			Assigned_Job.setMacLabInterviewComplete(Complete);
			Assigned_Job.setMacLabourInterviewComments(Comments);
			
			Session session = this.getSession();
			
			try
			{
				HibernateUtil.beginTransaction();
				session.update(Assigned_Job);
		        HibernateUtil.commitTransaction();
			}
			catch(Exception ex)
			{
				System.out.println("Error In Function: UpdateAssignedJobStatusMacLabourInterview - AssignedJobApplicantDAO");
				System.out.println(ex.toString());
			}
			finally
			{
				if(session != null && session.isConnected() && session.isOpen())
				{
					session.clear(); // ADDED 170302
					session.flush();
					session.close();
				}
			}

	        //hibernateSession.clear();
	        //hibernateSession.flush();
	        //hibernateSession.close();		
		}
		
	}
	
	////////////////////////////////////
	///NEW Function 19-07-2018
	//////////////////////////////////
	public void UpdateAssignedJobStatusPracticalDrivers(String Id_Number, String JobName,String StageInProcess, String StageStatus, String Complete, String Comments,String RoadTestPassed, String ParkingTestPassed)
	{
		List<AssignedJobApplicantList> AssignedJobs = ReadAllAssignedJobsInfoByIDAndJobNamePracticalDrivers(Id_Number,  JobName);
		
		System.out.println("TEsting Update new Maclabour assigne Jobs");
		
		if(AssignedJobs.size()> 0)
		{
			AssignedJobApplicantList Assigned_Job = AssignedJobs.get(0);
			
			Assigned_Job.setStageInProcess(StageInProcess);
			Assigned_Job.setStageStatus(StageStatus);
			Assigned_Job.setPracticalDriversTestComments(Comments);
			Assigned_Job.setPracticalDriversTestComplete(Complete);
			Assigned_Job.setRoadTestPassed(RoadTestPassed);
			Assigned_Job.setParkingTestPassed(ParkingTestPassed);
			
			System.out.println("Parking Test:"+ ParkingTestPassed);
			System.out.println("Road Test Passed:"+ RoadTestPassed);
			
			
			Session session = this.getSession();
			
			
			
			try
			{
				HibernateUtil.beginTransaction();
				session.update(Assigned_Job);     
		        HibernateUtil.commitTransaction();
			
			}
			catch(Exception ex)
			{
				System.out.println("Error In Function: UpdateAssignedJobStatusPracticalDrivers - AssignedJobApplicantDAO");
				System.out.println(ex.toString());
			}
			finally
			{
				if(session != null && session.isConnected() && session.isOpen())
				{
					session.clear(); // ADDED 170302
					session.flush();
					session.close();
				}
				
			}
	        /*hibernateSession.clear();
	        hibernateSession.flush();
	        hibernateSession.close();*/
					
		}
		
	}
	////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////
	
	public List<AssignedJobApplicantList> ReadAllAssignedJobsInfoByIDAndJobName(String Id_Number, String JobName)
	{
		Session session = this.getSession();
		List<AssignedJobApplicantList> AssignedJobs = new ArrayList<AssignedJobApplicantList>();
	
		try
		{
			HibernateUtil.beginTransaction();
			Query<AssignedJobApplicantList> query = session.createQuery("from AssignedJobApplicantList WHERE idMac_Applicants = '"+Id_Number+"' AND Job_Name = '"+JobName+"'");
			AssignedJobs = query.list();
			
		}
		catch(Exception ex)
		{
			System.out.println("Error In Function: ReadAllAssignedJobsInfoByIDAndJobName - AssignedJobApplicantDAO");
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
		
	
		//AssignedJobApplicantList x = AssignedJobs.get(0);
		return AssignedJobs;
	}
	
	
	public List<AssignedJobApplicantList> ReadAllAssignedJobsInfoByIDAndJobNameClientInterview(String Id_Number, String JobName)
	{
		Session session = this.getSession();
		List<AssignedJobApplicantList> AssignedJobs = new ArrayList<AssignedJobApplicantList>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<AssignedJobApplicantList> query = session.createQuery("from AssignedJobApplicantList WHERE idMac_Applicants = '"+Id_Number+"' AND Job_Name = '"+JobName+"'");
			AssignedJobs = query.list();
			
		}
		catch(Exception ex)
		{
			System.out.println("Error In Function: ReadAllAssignedJobsInfoByIDAndJobNameClientInterview - AssignedJobApplicantDAO");
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
		
		
		
		return AssignedJobs;
	}
	
	
	public List<AssignedJobApplicantList> ReadAllAssignedJobsInfoByIDAndJobNamePracticalDrivers(String Id_Number, String JobName)
	{
		Session session = this.getSession();
		
		List<AssignedJobApplicantList> AssignedJobs = new ArrayList<AssignedJobApplicantList>();
		
		
		try
		{
			HibernateUtil.beginTransaction();
			Query query = session.createQuery("from AssignedJobApplicantList WHERE idMac_Applicants = '"+Id_Number+"' AND Job_Name = '"+JobName+"'");
			AssignedJobs = query.list();
			
			
		}
		catch(Exception ex)
		{
			
			System.out.println("Error In Function: ReadAllAssignedJobsInfoByIDAndJobNamePracticalDrivers - AssignedJobApplicantDAO");
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
		
		
		return AssignedJobs;
		
		
		
	}
	
	
	public List<AssignedJobApplicantList> ReadAllAssignedJobsInfoByID(String Id_Number)
	{
		Session session = this.getSession();
		List<AssignedJobApplicantList> AssignedJobs = new ArrayList<AssignedJobApplicantList>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<AssignedJobApplicantList> query = session.createQuery("from AssignedJobApplicantList WHERE idMac_Applicants = '"+Id_Number+"'");
			AssignedJobs = query.list();
			
		}
		catch(Exception ex)
		{
			System.out.println("Error In Function: ReadAllAssignedJobsInfoByID - AssignedJobApplicantDAO");
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
		
			
		return AssignedJobs;

	}
	
	
	
	public List<AssignedJobApplicantList> CheckAllAssignedJobsInfoByID(String Id_Number, String Name, String Surname, int JobId)
	{
		Session session = this.getSession();
		List<AssignedJobApplicantList> AssignedJobs =new ArrayList<AssignedJobApplicantList>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<AssignedJobApplicantList> query = session.createQuery("from AssignedJobApplicantList WHERE idMac_Applicants = '"+Id_Number+"' AND Name ='"+Name+"' And Surname ='"+Surname+"' And Job_Id ="+JobId);
			AssignedJobs = query.list();
			
		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: ReadAllAssignedJobsInfoByID - AssignedJobApplicantDAO");
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
		
	
		return AssignedJobs;	
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
			  System.out.println("Error In Function: delete - AssignedJobApplicantDAO");
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
	
	///////////////////////////////////////////////////////////////////////////////
	//Function to Update a database object from the database
	//////////////////////////////////////////////////////////////////////////////

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
			  System.out.println("Error In Function: update - AssignedJobApplicantDAO");
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
			
			
			   List<AssignedJobApplicantList> IsApplicantAlreadyAssigned = CheckAllAssignedJobsInfoByID(idMacApplicants,Applicant.get(0).getName().toString(),Applicant.get(0).getSurname().toString(),Jobs.get(0).getJobId());
			
			   if(IsApplicantAlreadyAssigned.size() == 0 )
			   {
				    
				   
				   
				    Session session = this.getSession();;
				 
					try
					{
						    HibernateUtil.beginTransaction();
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
							
							AssignedJob.setMacLabInterviewComplete("No");
							AssignedJob.setMacLabourInterviewComments("Please Add a Comment");
							
							AssignedJob.setPracticalDriversTestComplete("No");
							AssignedJob.setPracticalDriversTestComments("Please Add a comment");
							
							AssignedJob.setClientInterviewComplete("No");
							AssignedJob.setClientInterviewComments("Please Add a comment");
							
							
							AssignedJob.setReferenceChecksComplete("No");
							AssignedJob.setReferenceChecksComments("Please Add a comment");
							
							session.save(AssignedJob);
									
							session.getTransaction().commit();
					}
					catch(Exception ex)
					{
						  System.out.println("Error In Function: AddAssignedJob - AssignedJobApplicantDAO");
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
			   else
			   {
				   System.out.println("Applicant Already Assigned to the job selected.");
			   }
			
			
			    
		}

		
	}
	
	public void UpdateAssignedJobStatusClientrInterview(String Id_Number, String JobName,String StageInProcess, String StageStatus, String Complete, String Comments)
	{
		List<AssignedJobApplicantList> AssignedJobs = ReadAllAssignedJobsInfoByIDAndJobNameClientInterview(Id_Number,  JobName);
		
		if(AssignedJobs.size()> 0)
		{
			AssignedJobApplicantList Assigned_Job = AssignedJobs.get(0);
			
			Assigned_Job.setStageInProcess(StageInProcess);
			Assigned_Job.setStageStatus(StageStatus);
			Assigned_Job.setClientInterviewComplete(Complete);
			Assigned_Job.setClientInterviewComments(Comments);
			
			Session hibernateSession = this.getSession();
			
			try
			{
				HibernateUtil.beginTransaction();
				hibernateSession.update(Assigned_Job); 
		        HibernateUtil.commitTransaction();
		        
			}
			catch(Exception ex)
			{
				
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
		
	}
	

}
