package aoc.Harlequin.DAOs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
		MacLabourInterView Interview = new MacLabourInterView();
		try
		{
			HibernateUtil.beginTransaction();
			Interview = session.get(MacLabourInterView.class, id);

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: getInterviewInfoById - MacInterviewDAO");
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

		return Interview;
		
		
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

		  	System.out.println("Error In Function: AddAppicantInformation - MacInterviewDAO");
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
  
	
	
	public void AddInterviewInformation( String idMac_Applicants, String Name,String Surname, String Id_Number,	String Client_Name, String Id_Verified,String Work_History_Verified,String Job_Name, String Drivers_License_Verified,String SAP_Check, String Criminal_Record, String Criminal_Record_comments, String Union_Member,String Union_Name, String Applicant_Passed_Interview, String Applicant_Presentable,String Applicant_Attitude, String Interview_Comments, String Formal_Interview_Complete, String Passed)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		///////////////////////////////////////////////////////////////////////////////////////////////////
		List<MacLabourInterView> OldInterview = GetInterviewByInfo(Id_Number,idMac_Applicants,Job_Name);
		if(OldInterview.size() > 0)
		{
			delete(OldInterview.get(0));
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////////

/*		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
*/		
		
		Session session = this.getSession();
		MacLabourInterView Interview = new MacLabourInterView();
		
		try
		{
			HibernateUtil.beginTransaction();

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
			
			Interview.setLastUsedDate(dateFormat.format(date));
			Interview.setPassed(Passed);

			session.save(Interview);
					
			session.getTransaction().commit();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddInterviewInformation - MacInterviewDAO");
			System.out.println(ex.toString());
		}
		finally
		{


			if(session != null && session.isConnected())
			{
				
				session.close();
			}

		}
		
		
		
	}
	
	public List<MacLabourInterView> GetClientInfoByName(String ClientName)
	{
		Session session = this.getSession();
		List<MacLabourInterView> Client = new ArrayList<MacLabourInterView>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<MacLabourInterView> query = session.createQuery("from MacLabourInterView Where Client_Name = '"+ClientName+"'");
			Client = query.list();
			

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: GetClientInfoByName - MacInterviewDAO");
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
		
		
		
		return Client;
	}
	
	
	public List<MacLabourInterView> GetInterviewByInfo(String Id_Number, String idMac_Applicants,String Job_Name)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		List<MacLabourInterView> Interview = new ArrayList<MacLabourInterView>();
		try
		{
			Query<MacLabourInterView> query = session.createQuery("from MacLabourInterView Where idMac_Applicants = '"+idMac_Applicants.trim()+"' AND Id_Number = '"+Id_Number.trim()+"' AND Job_Name ='"+Job_Name.trim()+"'");
			Interview = query.list();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: GetInterviewByInfo - MacInterviewDAO");
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
		
		
		return Interview;
	}
	
	public List<MacLabourInterView> GetInterviewByInfoIdNumber(String Id_Number)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		List<MacLabourInterView> Interview = new ArrayList<MacLabourInterView>();
		try
		{
			Query<MacLabourInterView> query = session.createQuery("from MacLabourInterView Where Id_Number = '"+Id_Number.trim()+"'");
			Interview = query.list();
		

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddAppicantInformation - MacInterviewDAO");
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
		
		
		return Interview;
	}
	
	
	public List<MacLabourInterView> ReadAllInterviews()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		List<MacLabourInterView> Interview = new ArrayList<MacLabourInterView>();
		
		try
		{
			Query<MacLabourInterView> query = session.createQuery("from MacLabourInterView");
			Interview = query.list();
		

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddAppicantInformation - MacInterviewDAO");
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
		
	
		return Interview;
		
		
		
	}

}
