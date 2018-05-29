/**
 * 
 */
package aoc.Harlequin.DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import aoc.Harlequin.OBJs.ApplicantSmsHistory;
import aoc.Harlequin.OBJs.PracticalDriversAssessment;
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
	
	
	public void AddSmsHistory(int idMac_Applicants, String Cell_Number, String Message, String Job_Name, String Client_Name, String Sms_Group,String Sms_Date)
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
		smsHistory.setSmsDate(Sms_Date);
		session.save(smsHistory);
				
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	
	public List<ApplicantSmsHistory> ReadGroupHistory(String Group_Code)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from ApplicantSmsHistory WHERE Sms_Group='"+Group_Code+"'");
		List<ApplicantSmsHistory> History = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return History;
		
		
		
	}
	
}
