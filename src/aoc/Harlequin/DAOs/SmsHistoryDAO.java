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
	
	
	public void AddSmsHistory(int idMac_Applicants, String Cell_Number, String Message, String Job_Name, String Client_Name, String Sms_Group)
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
		ApplicantSmsHistory smsHistory = new ApplicantSmsHistory();
		
		smsHistory.setIdMacApplicants(idMac_Applicants);
		smsHistory.setCellNumber(Cell_Number);
		smsHistory.setMessage(Message);
		smsHistory.setJobName(Job_Name);
		smsHistory.setClientName(Client_Name);
		smsHistory.setSmsGroup(Sms_Group);
		
		session.save(smsHistory);
				
		session.getTransaction().commit();
		
		session.close();
		
	}
	
}
