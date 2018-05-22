package aoc.Harlequin.DAOs;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import aoc.Harlequin.OBJs.ClientInterviews;
import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.MacLabourInterView;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemUser;
import aoc.Harlequin.util.HibernateUtil;

public class ClientInterviewDAO extends HarlequinDAO {
	
	public ClientInterviews getInterviewInfoById(int id)
	{
		
		
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		
		ClientInterviews Interview = session.get(ClientInterviews.class, id);
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
	   
		
		return Interview;
		
		
	}
	
	
	
	
  
	
	
	public void AddInterviewInformation( String idMac_Applicants, String Client_Name, String Applicant_Name,  String Applicant_Surname, String Interview_questions_Passed, String Applicant_Presentable,  String Applicant_Attitude, String Interview_Comments,String Client_Interview_Complete )
	{
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
		ClientInterviews Interview = new ClientInterviews();
		
		
		Interview.setIdMacApplicants(Integer.parseInt(idMac_Applicants));
		Interview.setClientName(Client_Name);
		Interview.setApplicantName(Applicant_Name);
		Interview.setApplicantSurname(Applicant_Surname);
		Interview.setInterviewQuestionsPassed(Interview_questions_Passed);
		Interview.setApplicantPresentable(Applicant_Presentable);
		Interview.setApplicantAttitude(Applicant_Attitude);
		Interview.setInterviewComments(Interview_Comments);
		Interview.setClientInterviewComplete(Client_Interview_Complete);
		
		
		
		
		
		session.save(Interview);
				
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	public List<ClientInterviews> GetClientInfoByName(String ClientName)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from ClientInterviews Where Client_Name = '"+ClientName+"'");
		List<ClientInterviews> Client = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Client;
	}
	
	
	public List<ClientInterviews> ReadAllInterviews()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from MacLabourInterView");
		List<ClientInterviews> Interview = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return Interview;
		
		
		
	}

}
