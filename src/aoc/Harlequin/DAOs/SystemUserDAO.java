/**
 * 
 */
package aoc.Harlequin.DAOs;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import aoc.Harlequin.OBJs.SystemUser;
import aoc.Harlequin.util.HibernateUtil;

/**
 * @author Jateen
 *
 */
public class SystemUserDAO extends HarlequinDAO
{
	
	
	public SystemUser getUserInfoById(int id)
	{
		
		
		Session session = this.getSession();
		SystemUser users = new SystemUser();
		
		try
		{
			HibernateUtil.beginTransaction();
			users = session.get(SystemUser.class, id);

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: getUserInfoById - SystemUserDAO");
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
		
		return users;
		
		
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

		  	System.out.println("Error In Function: delete - SystemUserDAO");
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
  
	
	public List<SystemUser> CheckUserPassword(String Username, String Password)
	{
		Session session = this.getSession();
		List<SystemUser> User = new ArrayList<SystemUser>();
		
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<SystemUser> query = session.createQuery("from SystemUser Where User_Name = '"+Username+"'");
			User = query.list();
			
		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: CheckUserPassword - SystemUserDAO");
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
		
		return User;
	}
	
	
	public List<SystemUser> GetUserById(String IdNumber)
	{
		Session session = this.getSession();
		List<SystemUser> User = new ArrayList<SystemUser>();
		
		try
		{
			HibernateUtil.beginTransaction();
			Query<SystemUser> query = session.createQuery("from SystemUser Where idSystem_User = '"+IdNumber+"'");
			User = query.list();
		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: GetUserById - SystemUserDAO");
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
		

		return User;
	}
	
	
	
	public void AddUserInformation(String User_Name,String name, String surname, String EMail, String tellNumber, String cellNumber, String userPassword, String authorizationLevel)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
/*		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
*/		
		Session session = this.getSession();
		SystemUser user = new SystemUser();
	
		
		try
		{
			
			HibernateUtil.beginTransaction();
			user.setUserName(User_Name);
			user.setName(name);
			user.setSurname(surname);
			user.setEMail(EMail);
			user.setTellNumber(tellNumber);
			user.setCellNumber(cellNumber);
			user.setUserPassword(userPassword);
			user.setAuthorizationLevel(authorizationLevel);
			user.setLastUsedDate(dateFormat.format(date));
			
			
			session.save(user);
					
			session.getTransaction().commit();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: AddUserInformation - SystemUserDAO");
			System.out.println(ex.toString());
		}
		finally
		{


			if(session != null && session.isConnected())
			{
				/*session.clear();
				session.flush();*/
				session.close();
			}

		}

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
			  	System.out.println("Error In Function: update - SystemUserDAO");
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
	
	public List<SystemUser> ReadAllUsers()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		List<SystemUser> User = new ArrayList<SystemUser>();
		try
		{
			Query<SystemUser> query = session.createQuery("from SystemUser");
			User = query.list();

		}
		catch(Exception ex)
		{

			System.out.println("Error In Function: ReadAllUsers - SystemUserDAO");
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
		
		return User;
		
		
		
	}


	

	
	
	
	

}
