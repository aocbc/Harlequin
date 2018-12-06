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
import aoc.Harlequin.OBJs.MacLabourInterView;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemUser;
import aoc.Harlequin.util.HibernateUtil;

public class ClientInterviewDAO extends HarlequinDAO {
	
	public ClientInterviews getInterviewInfoById(int id)
	{
		
		
		Session session = this.getSession();
		ClientInterviews Interview = new ClientInterviews();
		
		
		try
		{
			HibernateUtil.beginTransaction();
			Interview = session.get(ClientInterviews.class, id);
			

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: getInterviewInfoById - ClientInterviewDAO");
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

		  	System.out.println("Error In Function: update - MacInterviewDAO");
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

		  	System.out.println("Error In Function: delete - ClientInterviewDAO");
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
	
	public void AddInterviewInformation( String Id_number,String Job_Name,String idMac_Applicants, String Client_Name, String Applicant_Name,  String Applicant_Surname, String Interview_questions_Passed, String Applicant_Presentable,  String Applicant_Attitude, String Interview_Comments,String Client_Interview_Complete, String clientInterviewPassed )
	{
		////////////////////////////////////////////////////////////////////////////////////////
		List<ClientInterviews> OldInterview = GetInterviewByInfo(Id_number, idMac_Applicants, Job_Name);
		if(OldInterview.size() > 0)
		{
			delete(OldInterview.get(0));
		}
		
		//////////////////////////////////////////////////////////////////////////////////////
		
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();*/
		
		Session session = this.getSession(); 
		try
		{
			HibernateUtil.beginTransaction();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
						
			ClientInterviews Interview = new ClientInterviews();

			Interview.setIdMacApplicants(Integer.parseInt(idMac_Applicants));
			Interview.setClientName(Client_Name);
			Interview.setApplicantName(Applicant_Name);
			Interview.setApplicantSurname(Applicant_Surname);
			Interview.setInterviewQuestionsPassed(Interview_questions_Passed);
			Interview.setApplicantPresentable(Applicant_Presentable);
			Interview.setApplicantAttitude(Applicant_Attitude);
			Interview.setInterviewComments(Interview_Comments);
			Interview.setClientInterviewComplete(Client_Interview_Complete);
			Interview.setIdNumber(Id_number);
			Interview.setJobName(Job_Name);
			Interview.setLastUsedDate(dateFormat.format(date));
			Interview.setClientInterviewPassed(clientInterviewPassed);
			
			session.save(Interview);
			session.getTransaction().commit();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddInterviewInformation - ClientInterviewDAO");
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
	
	public List<ClientInterviews> GetClientInfoByName(String ClientName)
	{
		Session session = this.getSession();
		List<ClientInterviews> Client = new ArrayList<ClientInterviews>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<ClientInterviews> query = session.createQuery("from ClientInterviews Where Client_Name = '"+ClientName.trim()+"'");
			Client = query.list();
		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: GetClientInfoByName - ClientInterviewDAO");
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
	
	
	public List<ClientInterviews> GetClientInfoByIdNumber(String Id_Number)
	{
		Session session = this.getSession();
		List<ClientInterviews> Client = new ArrayList<ClientInterviews>();
		
		
		HibernateUtil.beginTransaction();
		try
		{
			Query<ClientInterviews> query = session.createQuery("from ClientInterviews Where Id_Number = '"+Id_Number+"'");
			Client = query.list();
			

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddAppicantInformation - ClientInterviewDAO");
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
	
	
	public List<ClientInterviews> GetInterviewByInfo(String Id_Number, String idMac_Applicants,String Job_Name)
	{
		Session session = this.getSession();
		List<ClientInterviews> Interview = new ArrayList<ClientInterviews>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<ClientInterviews> query = session.createQuery("from ClientInterviews Where idMac_Applicants = '"+idMac_Applicants.trim()+"' AND Id_Number = '"+Id_Number.trim()+"' AND Job_Name ='"+Job_Name.trim()+"'");
			Interview = query.list();
		

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: GetInterviewByInfo - ClientInterviewDAO");
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
	
	public List<ClientInterviews> ReadAllInterviews()
	{
		Session session = this.getSession();
		List<ClientInterviews> Interview = new ArrayList<ClientInterviews>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<ClientInterviews> query = session.createQuery("from MacLabourInterView");
			Interview = query.list();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: ReadAllInterviews - ClientInterviewDAO");
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
