/**
 * 
 */
package aoc.Harlequin.DAOs;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

		HibernateUtil.beginTransaction();
	   
		
		SystemUser users = session.get(SystemUser.class, id);
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
	   
		
		return users;
		
		
	}
	
	
	public void delete(Object entity) 
	{
		  Session hibernateSession = this.getSession(); 
		  
		  HibernateUtil.beginTransaction();
		        hibernateSession.delete(entity);
		        hibernateSession.flush();
		  HibernateUtil.commitTransaction();
	}
  
	
	public List<SystemUser> CheckUserPassword(String Username, String Password)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from SystemUser Where User_Name = '"+Username+"'");
		List<SystemUser> User = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return User;
	}
	
	
	public List<SystemUser> GetUserById(String IdNumber)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from SystemUser Where idSystem_User = '"+IdNumber+"'");
		List<SystemUser> User = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return User;
	}
	
	
	
	public void AddUserInformation(String User_Name,String name, String surname, String EMail, String tellNumber, String cellNumber, String userPassword, String authorizationLevel)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
		SystemUser user = new SystemUser();
		
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
		
		
		
		session.close();

		
	}
	
	public void update(Object entity) 
	{  
		  Session hibernateSession = this.getSession();
		  HibernateUtil.beginTransaction();
		        //hibernateSession.save(entity);        
		        //hibernateSession.saveOrUpdate(entity);
		        hibernateSession.update(entity);
		     
		        HibernateUtil.commitTransaction();
		      
		        
		        
		 
	}
	
	public List<SystemUser> ReadAllUsers()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from SystemUser");
		List<SystemUser> User = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return User;
		
		
		
	}


	

	
	
	
	

}
