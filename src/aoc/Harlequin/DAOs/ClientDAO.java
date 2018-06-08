package aoc.Harlequin.DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemUser;
import aoc.Harlequin.util.HibernateUtil;

public class ClientDAO extends HarlequinDAO {
	
	public SystemClient getClientInfoById(int id)
	{
		
		
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		
		SystemClient clients = session.get(SystemClient.class, id);
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
	   
		
		return clients;
		
		
	}
	
	
	
	public void delete(Object entity) 
	{
		  Session hibernateSession = this.getSession(); 
		  
		  HibernateUtil.beginTransaction();
		        hibernateSession.delete(entity);
		        hibernateSession.flush();
		  HibernateUtil.commitTransaction();
	}
  
	
	
	public void AddClientInformation( String clientName, String clientEMail,String clientContactName, String clientContactNumber,	String clientAddress1, String clientAddress2,String clientAddress3, String clientAddress4,String clientVatNumber, String clientComments)
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
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
		
		
		
		
		session.save(client);
				
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	public List<SystemClient> GetClientInfoByName(String ClientName)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from SystemClient Where Client_Name = '"+ClientName+"'");
		List<SystemClient> Client = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Client;
	}
	
	
	public List<SystemClient> ReadAllClients()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from SystemClient");
		List<SystemClient> Client = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return Client;
		
		
		
	}

}
