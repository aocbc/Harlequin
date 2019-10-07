/**
 * 
 */
package aoc.Harlequin.DAOs;


import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

			//user.setUserPassword(toHexString(getSHA(userPassword)));
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
	
	 public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
	 {  
	        // Static getInstance method is called with hashing SHA  
	        MessageDigest md = MessageDigest.getInstance("SHA-256");  
	  
	        // digest() method called  
	        // to calculate message digest of an input  
	        // and return array of byte 
	        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
	  } 
	    
	    
	 
	 public static String toHexString(byte[] hash) 
	 { 
	        // Convert byte array into signum representation  
	        BigInteger number = new BigInteger(1, hash);  
	  
	        // Convert message digest into hex value  
	        StringBuilder hexString = new StringBuilder(number.toString(16));  
	  
	        // Pad with leading zeros 
	        while (hexString.length() < 32)  
	        {  
	            hexString.insert(0, '0');  
	        }  
	  
	        return hexString.toString();  
	 } 


	

	
	
	
	

}
