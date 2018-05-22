/**
 * 
 */
package aoc.Harlequin.DAOs;

import org.hibernate.Session;

import aoc.Harlequin.OBJs.ApplicantSmsHistory;
import aoc.Harlequin.OBJs.SystemUser;
import aoc.Harlequin.util.HibernateUtil;

/**
 * @author Jateen
 *
 */
public class SmsHistoryDAO extends HarlequinDAO 
{

	public ApplicantSmsHistory getUserInfoById(int id)
	{
		
		
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		
		ApplicantSmsHistory History = session.get(ApplicantSmsHistory.class, id);
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
	   
		
		return History;
		
		
	}
	
}
