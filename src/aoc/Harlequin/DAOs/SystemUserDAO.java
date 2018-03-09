/**
 * 
 */
package aoc.Harlequin.DAOs;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
	
	

}
