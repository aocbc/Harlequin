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

import aoc.Harlequin.OBJs.ReferenceChecks;
import aoc.Harlequin.OBJs.SystemUser;
import aoc.Harlequin.util.HibernateUtil;

/**
 * @author Jateen
 *
 */
public class ReferenceCheckDAO extends HarlequinDAO
{
	
	
	public ReferenceChecks getReferenceCheckInfoById(int id)
	{
		
		
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		
		ReferenceChecks References = session.get(ReferenceChecks.class, id);
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
	   
		
		return References;
		
		
	}
	
	
	public void delete(Object entity) 
	{
		  Session hibernateSession = this.getSession(); 
		  
		  HibernateUtil.beginTransaction();
		        hibernateSession.delete(entity);
		        hibernateSession.flush();
		  HibernateUtil.commitTransaction();
	}
  
	
	
	
	public List<ReferenceChecks> GetUserById(String idMac_Applicants)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from ReferenceChecks Where idMac_Applicants = '"+idMac_Applicants+"'");
		List<ReferenceChecks> Reference = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Reference;
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
