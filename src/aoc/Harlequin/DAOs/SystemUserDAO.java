/**
 * 
 */
package aoc.Harlequin.DAOs;


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
	
	
	
	public void AddUserInformation(String name, String surname, String EMail, String tellNumber, String cellNumber, String userPassword, String authorizationLevel)
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
		SystemUser user = new SystemUser();
		
		user.setUserName(name);
		user.setName(name);
		user.setSurname(surname);
		user.setEMail(EMail);
		user.setTellNumber(tellNumber);
		user.setCellNumber(cellNumber);
		user.setUserPassword(userPassword);
		user.setAuthorizationLevel(authorizationLevel);
		session.save(user);
				
		session.getTransaction().commit();
		
		session.close();
		
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
