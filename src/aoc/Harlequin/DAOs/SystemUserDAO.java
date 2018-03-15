/**
 * 
 */
package aoc.Harlequin.DAOs;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
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
	
	
	public void AddUserInformation(String name, String surname, String EMail, String tellNumber, String cellNumber, String userPassword)
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
		
		session.save(user);
				
		session.getTransaction().commit();
		
		session.close();
		
	}


	
	
	
	

}
