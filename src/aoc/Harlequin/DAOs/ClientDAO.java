package aoc.Harlequin.DAOs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.util.HibernateUtil;

public class ClientDAO extends HarlequinDAO {
	
	public SystemClient getClientInfoById(int id)
	{

		Session session = this.getSession();
		SystemClient clients = new SystemClient();

		try
		{
			HibernateUtil.beginTransaction();   
			clients = session.get(SystemClient.class, id);
				

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: getClientInfoById - ClientDAO");
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
		
		return clients;
		
		
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

			  	System.out.println("Error In Function: update - ClientDAO");
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
	
	/*public void delete(Object entity) 
	{
		  Session hibernateSession = this.getSession(); 
		  
		  HibernateUtil.beginTransaction();
		        hibernateSession.delete(entity);
		        //hibernateSession.flush();
		  HibernateUtil.commitTransaction();
	}*/
  
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

		  	System.out.println("Error In Function: delete - ClientDAO");
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
	
	public void AddClientInformation( String clientName, String clientEMail,String clientContactName, String clientContactNumber,	String clientAddress1, String clientAddress2,String clientAddress3, String clientAddress4,String clientVatNumber, String clientComments)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		/*Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();*/
		Session hibernateSession = this.getSession();
		
		try
		{
			HibernateUtil.beginTransaction();
			SystemClient client = new SystemClient();
			
			client.setClientName(clientName);
			client.setClientEMail(clientEMail);
			client.setClientContactName(clientContactName);
			client.setClientContactNumber(clientContactNumber);
			client.setClientAddress1(clientAddress1);
			client.setClientAddress2(clientAddress2);
			client.setClientAddress3(clientAddress3);
			client.setClientAddress4(clientAddress4);
			client.setClientVatNumber(clientVatNumber);
			client.setClientComments(clientComments);
			client.setLastUsedDate(dateFormat.format(date));

			hibernateSession.save(client);
					
			hibernateSession.getTransaction().commit();
		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddClientInformation - ClientDAO");
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
	
	public List<SystemClient> GetClientInfoByName(String ClientName)
	{
		Session session = this.getSession();
		List<SystemClient> Client = new ArrayList<SystemClient>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<SystemClient> query = session.createQuery("from SystemClient Where Client_Name = '"+ClientName+"'");
			Client = query.list();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: GetClientInfoByName - MacApplicantDAO");
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
	
	
	public List<SystemClient> ReadAllClients()
	{
		Session session = this.getSession();
		
		List<SystemClient> Client = new ArrayList<SystemClient>();
		HibernateUtil.beginTransaction();
		
		try
		{
			Query<SystemClient> query = session.createQuery("from SystemClient");
			Client = query.list();

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
		
	

		return Client;
		
		
		
	}

}
