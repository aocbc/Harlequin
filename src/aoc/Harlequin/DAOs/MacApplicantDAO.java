package aoc.Harlequin.DAOs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import aoc.Harlequin.OBJs.MacApplicants;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemUser;
import aoc.Harlequin.util.HibernateUtil;

public class MacApplicantDAO extends HarlequinDAO {
	
	public MacApplicants getClientApplicantoById(int id)
	{
		
		
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		
		MacApplicants applicants = session.get(MacApplicants.class, id);
		
		
		
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
	   
		
		return applicants;
		
		
	}
	
	public MacApplicants UpdateAppplicantEmpoyableId(int id, String Employable, String EmployableComments)
	{
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		MacApplicants applicants = session.get(MacApplicants.class, id);
		
		applicants.setEmployable(Employable);
		if(!EmployableComments.equals(""))
		{
			applicants.setEmployableComments(EmployableComments);
			
		}
		
		session.clear(); 
		session.flush();
		session.close();
		
		update(applicants);
		
		return applicants;
	
	}
	
	
	public MacApplicants UpdateAppplicantLastSmsDateById(int id, String Sms_Group,int SmsGroupCount)
	{
		
		
		
		
		
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		
		MacApplicants applicants = session.get(MacApplicants.class, id);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		
		
		String lastSmsDate = localDate.toString();
		
		applicants.setLastSmsDate(lastSmsDate);
		applicants.setSmsGroup(Sms_Group.trim());
		applicants.setSmsGroupCount(SmsGroupCount);
		
		System.out.println("SMSGROUP:"+Sms_Group);
		
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		update(applicants);
		
		
		
		return applicants;
		
		
	}
	
	
	
	
	public MacApplicants UpdateAppplicantStatusById(int id, String Applicant_Status)
	{
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		MacApplicants applicants = session.get(MacApplicants.class, id);
		
		applicants.setStageInTheProcess(Applicant_Status);
		
		session.clear(); 
		session.flush();
		session.close();
		
		update(applicants);
		
		return applicants;
	
	}
	
	
	public MacApplicants UpdateAppplicantStageInProcessById(int id, String Stage_In_Process)
	{
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		MacApplicants applicants = session.get(MacApplicants.class, id);
		
		applicants.setStageInTheProcess(Stage_In_Process);
		
		session.clear(); 
		session.flush();
		session.close();
		
		update(applicants);
		
		return applicants;
	
	}
	
	public MacApplicants UpdateAppplicantMacLabourById(int id, String InterviewComplete, String InterviewComments)
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		MacApplicants applicants = session.get(MacApplicants.class, id);
		
		applicants.setmacLabInterviewComplete(InterviewComplete);
		
		if(InterviewComplete.equals("Yes"))
		{
			applicants.setStageInTheProcess("Practical Drivers Test");
		}
		else if(InterviewComplete.equals("No"))
		{
			applicants.setStageInTheProcess("MacLabour Interview");
		}
		
		
		applicants.setmacLabourInterviewComments(InterviewComments);
		
		
		if(InterviewComments.equals(""))
		{
			applicants.setmacLabourInterviewComments("N/A");
			
		}
		
		applicants.setLastUsedDate(dateFormat.format(date));
		
		
		session.clear(); 
		session.flush();
		session.close();
		
		update(applicants);
		
		return applicants;
	
	}
	
	
	public MacApplicants UpdateAppplicantMacLabourByIdJobName(int id, String InterviewComplete, String InterviewComments,String JobName, String Id_Number)
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		MacApplicants applicants = session.get(MacApplicants.class, id);
		applicants.setmacLabInterviewComplete(InterviewComplete);
		
		
		AssignedJobApplicantDAO assigned_job = new AssignedJobApplicantDAO();
		
		if(InterviewComplete.equals("Yes"))
		{
			applicants.setStageInTheProcess("Practical Drivers Test");
			
			if(InterviewComments.equals(""))
			{
				assigned_job.UpdateAssignedJobStatusMacLabourInterview(Id_Number, JobName, "Practical Drivers Test", "beginning",InterviewComplete,"N/A");
				
			}
			else
			{
				assigned_job.UpdateAssignedJobStatusMacLabourInterview(Id_Number, JobName, "Practical Drivers Test", "beginning",InterviewComplete,InterviewComments);
				
			}
			
			
		}
		else if(InterviewComplete.equals("No"))
		{
			applicants.setStageInTheProcess("MacLabour Interview");
			
			if(InterviewComments.equals(""))
			{
				assigned_job.UpdateAssignedJobStatusMacLabourInterview(Id_Number, JobName, "MacLabour Interview", "pending",InterviewComplete,"N/A");
			}
			else
			{
				assigned_job.UpdateAssignedJobStatusMacLabourInterview(Id_Number, JobName, "MacLabour Interview", "pending",InterviewComplete,InterviewComments);
				
			}
			
		}
		
		
		applicants.setmacLabourInterviewComments(InterviewComments);
		
		
		if(InterviewComments.equals(""))
		{
			applicants.setmacLabourInterviewComments("N/A");
			
		}
		
		applicants.setLastUsedDate(dateFormat.format(date));
		
		
		/*session.clear(); 
		session.flush();
		session.close();*/
		
		update(applicants);
		
		return applicants;
	
	}
	
	
	
	
	public MacApplicants UpdateAppplicantDriversById(int id, String TestComplete, String TestComments)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		MacApplicants applicants = session.get(MacApplicants.class, id);
		
		applicants.setPracticalDriversTestComments(TestComments);
		applicants.setPracticalDriversTestComplete(TestComplete);
		
		

		
		if(TestComplete.equals("Yes"))
		{
			applicants.setStageInTheProcess("Client Interview");
		}
		else if(TestComplete.equals("No"))
		{
			applicants.setStageInTheProcess("Practical Drivers Test");
		}
		
		applicants.setLastUsedDate(dateFormat.format(date));
		
		session.clear(); 
		session.flush();
		session.close();
		
		update(applicants);
		
		return applicants;
	
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///New Function
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////
	
	
	
	public MacApplicants UpdateAppplicantDriversByIdJobNAme(int id, String TestComplete, String TestComments, String Id_Number, String JobName)
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		MacApplicants applicants = session.get(MacApplicants.class, id);
		
		applicants.setPracticalDriversTestComments(TestComments);
		applicants.setPracticalDriversTestComplete(TestComplete);
		
		AssignedJobApplicantDAO assigned_job = new AssignedJobApplicantDAO();
		
		
		if(TestComplete.equals("Yes"))
		{
			applicants.setStageInTheProcess("Client Interview");
			assigned_job.UpdateAssignedJobStatusPracticalDrivers(Id_Number, JobName, "Client Interview", "beginning", TestComplete, TestComments);
		}
		else if(TestComplete.equals("No"))
		{
			applicants.setStageInTheProcess("Practical Drivers Test");
			assigned_job.UpdateAssignedJobStatusPracticalDrivers(Id_Number, JobName, "Practical Drivers Test", "pending", TestComplete, TestComments);
		}
		
		
		applicants.setLastUsedDate(dateFormat.format(date));
		/*session.clear(); 
		session.flush();
		session.close();*/
		
		update(applicants);
		
		return applicants;
	
	}
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	public void update(Object entity) 
	{  
		  Session hibernateSession = this.getSession();
		  HibernateUtil.beginTransaction();
		        //hibernateSession.save(entity);        
		        //hibernateSession.saveOrUpdate(entity);
		  hibernateSession.update(entity);
		        
		        HibernateUtil.commitTransaction();
		 
	}
	
	
	public List<MacApplicants> GetApplicantsByJobType(String JobType)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from MacApplicants Where Job_Type = '"+JobType+"'");
		List<MacApplicants> Applicant = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Applicant;
	}
	
	
	public List<MacApplicants> GetApplicantsMacInterviewComplete()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from MacApplicants Where Mac_Lab_Interview_Complete = 'Yes'");
		List<MacApplicants> Applicant = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Applicant;
	}
	
	//////////////////////////////////////////////////////////////////////////////
	//////////////////////////NEW///////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	public List<MacApplicants> GetApplicantsMacInterviewCompleteNew()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from MacApplicants as x where exists(from AssignedJobApplicantList as y WHERE ((x.idNumber = y.idMacApplicants) AND (y.macLabInterviewComplete = 'Yes')))");
		List<MacApplicants> Applicant = query.list();
		
		session.clear(); 
		session.flush();
		session.close();
		return Applicant;
	}
	//////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	public List<MacApplicants> GetApplicantsSiteComplete()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		//Query query = session.createQuery("from MacApplicants Where Job_Name <> 'NA' AND Job_Name <> 'None'");
		Query query = session.createQuery("from MacApplicants as x where exists(from AssignedJobApplicantList as y WHERE x.idNumber = y.idMacApplicants )");
		List<MacApplicants> Applicant = query.list();
		
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Applicant;
	}
	
	
	
	////////////////////////////////////////////////////////////////////////
	//////////////////////////OLD//////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	public List<MacApplicants> GetApplicantsDriversComplete()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from MacApplicants Where Practical_Drivers_Test_Complete = 'Yes'");
		List<MacApplicants> Applicant = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Applicant;
	}
	/////////////////////////////////////////////////////////////////////
	/////////////////////////////New/////////////////////////////////////
	///////////////////////////////////////////////////////////////////
	public List<MacApplicants> GetApplicantsDriversCompleteNew()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from MacApplicants as x where exists(from AssignedJobApplicantList as y WHERE ((x.idNumber = y.idMacApplicants) AND (y.practicalDriversTestComplete = 'Yes')))");
		List<MacApplicants> Applicant = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Applicant;
	}
	
	
	
	public List<MacApplicants> GetApplicantsReferenceComplete()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from MacApplicants Where Client_Interview_Complete = 'Yes'");
		List<MacApplicants> Applicant = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Applicant;
	}
	
	public List<MacApplicants> GetApplicantsReferenceCheck()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		//Query query = session.createQuery("from MacApplicants as x where exists(from AssignedJobApplicantList as y WHERE x.idNumber = y.idMacApplicants )");
		Query query = session.createQuery("from MacApplicants where Job_Name <> 'None' AND Job_Name <> 'NA' ");
		
		List<MacApplicants> Applicant = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Applicant;
	}
	
	
	public List<MacApplicants> GetApplicantsByApplicantId(String IdNumber)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		Query query = session.createQuery("from MacApplicants Where Id_Number = '"+IdNumber+"'");
		List<MacApplicants> Applicant = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Applicant;
	}
	

	public List<MacApplicants> GetApplicantsByApplicantIdCell(String IdNumber,String Cell_Number)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		Query query = session.createQuery("from MacApplicants Where Id_Number = '"+IdNumber+"' OR Cell_Number = '"+Cell_Number.trim()+"'");
		List<MacApplicants> Applicant = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Applicant;
	}
	
	
	public List<MacApplicants> GetApplicantByidMac_Applicants(String idMac_Applicants)
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from SystemUser Where idMac_Applicants = '"+idMac_Applicants+"'");
		List<MacApplicants> Applicant = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		return Applicant;
	}
	
	
	public void AddAppicantInformation(String name, String surname, String rsaCitizen,String Id_Number,String Passport_Number,String expiryDateOfPassport, String workPermitValidity, String cellNumber,String telephoneNumber, String jobType,String dateFirstIssueLicense, String licenseCode,String expiryDateOfLicense, String pdpExpiryDate, String gender, String physicalAddress1, String physicalAddress2,String physicalAddress3, String physicalAddress4, String City,String Country, String Tax_No, String maritalStatus, String dependants, String homeLanguage, String workHistory1, String workHistory2, String workHistory3, String workHistory4,String email,int Age,String DateOfBirth,String lastSmsDate, String Job_Name,String Stage_In_Process, String Applicant_Status, String Applicant_Type,String Sms_Group,String Nationality)
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
		MacApplicants Applicant = new MacApplicants();
		
		Applicant.setName(name);
		Applicant.setSurname(surname);
		Applicant.setRsaCitizen(rsaCitizen);
		Applicant.setIdNumber(Id_Number);
		Applicant.setPassportNumber(Passport_Number);
		Applicant.setExpiryDateOfPassport(expiryDateOfPassport);
		Applicant.setWorkPermitValidity(workPermitValidity);
		Applicant.setCellNumber(cellNumber);
		Applicant.setTelephoneNumber(telephoneNumber);
		Applicant.setJobType(jobType);
		Applicant.setDateFirstIssueLicense(dateFirstIssueLicense);
		Applicant.setLicenseCode(licenseCode);
		Applicant.setExpiryDateOfLicense(expiryDateOfLicense);
		Applicant.setPdpExpiryDate(pdpExpiryDate);
		Applicant.setGender(gender);
		Applicant.setPhysicalAddress1(physicalAddress1);
		Applicant.setPhysicalAddress2(physicalAddress2);
		Applicant.setPhysicalAddress3(physicalAddress3);
		Applicant.setPhysicalAddress4(physicalAddress4);
		Applicant.setCity(City);
		Applicant.setCountry(Country);
		Applicant.setTaxNo(Tax_No);
		Applicant.setMaritalStatus(maritalStatus);
		Applicant.setDependants(dependants);
		Applicant.setHomeLanguage(homeLanguage);
		Applicant.setWorkHistory1(workHistory1);
		Applicant.setWorkHistory2(workHistory2);
		Applicant.setWorkHistory3(workHistory3);
		Applicant.setWorkHistory4(workHistory4);
		Applicant.setEmail(email);
		Applicant.setAge(Age);
		Applicant.setDateOfBirth(DateOfBirth);
		Applicant.setLastSmsDate(lastSmsDate);
		Applicant.setJobName(Job_Name);
		Applicant.setStageInTheProcess(Stage_In_Process);
		Applicant.setApplicantStatus(Applicant_Status);
		Applicant.setApplicantType(Applicant_Type);
		Applicant.setSmsGroup(Sms_Group);
		Applicant.setNationality(Nationality);
		
		Applicant.setmacLabInterviewComplete("No");
		Applicant.setmacLabourInterviewComments("N/A");
		Applicant.setSmsGroupCount(0);
		Applicant.setPracticalDriversTestComments("N/A");
		Applicant.setPracticalDriversTestComplete("No");
		Applicant.setClientInterviewComments("N/A");
		Applicant.setClientInterviewComplete("No");
		Applicant.setReferenceChecksComments("N/A");
		Applicant.setReferenceChecksComplete("Yes");
		
		Applicant.setSmsAccountActive("Yes");
		
		Applicant.setLastUsedDate(dateFormat.format(date));
		
		session.save(Applicant);
				
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	
	public void AddPermanentInformation(String name, String surname, String rsaCitizen,String Id_Number,String Passport_Number,String expiryDateOfPassport, String workPermitValidity, String cellNumber,String telephoneNumber, String jobType,String dateFirstIssueLicense, String licenseCode,String expiryDateOfLicense, String pdpExpiryDate, String gender, String physicalAddress1, String physicalAddress2,String physicalAddress3, String physicalAddress4, String City,String Country, String Tax_No, String maritalStatus, String dependants, String homeLanguage, String workHistory1, String workHistory2, String workHistory3, String workHistory4,String email,int Age,String DateOfBirth,String lastSmsDate, String Job_Name,String Stage_In_Process, String Applicant_Status,String Applicant_Type)
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		
		
		MacApplicants Applicant = new MacApplicants();
		
		Applicant.setName(name);
		Applicant.setSurname(surname);
		Applicant.setRsaCitizen(rsaCitizen);
		Applicant.setIdNumber(Id_Number);
		Applicant.setPassportNumber(Passport_Number);
		Applicant.setExpiryDateOfPassport(expiryDateOfPassport);
		Applicant.setWorkPermitValidity(workPermitValidity);
		Applicant.setCellNumber(cellNumber);
		Applicant.setTelephoneNumber(telephoneNumber);
		Applicant.setJobType(jobType);
		Applicant.setDateFirstIssueLicense(dateFirstIssueLicense);
		Applicant.setLicenseCode(licenseCode);
		Applicant.setExpiryDateOfLicense(expiryDateOfLicense);
		Applicant.setPdpExpiryDate(pdpExpiryDate);
		Applicant.setGender(gender);
		Applicant.setPhysicalAddress1(physicalAddress1);
		Applicant.setPhysicalAddress2(physicalAddress2);
		Applicant.setPhysicalAddress3(physicalAddress3);
		Applicant.setPhysicalAddress4(physicalAddress4);
		Applicant.setCity(City);
		Applicant.setCountry(Country);
		Applicant.setTaxNo(Tax_No);
		Applicant.setMaritalStatus(maritalStatus);
		Applicant.setDependants(dependants);
		Applicant.setHomeLanguage(homeLanguage);
		Applicant.setWorkHistory1(workHistory1);
		Applicant.setWorkHistory2(workHistory2);
		Applicant.setWorkHistory3(workHistory3);
		Applicant.setWorkHistory4(workHistory4);
		Applicant.setEmail(email);
		Applicant.setAge(Age);
		Applicant.setDateOfBirth(DateOfBirth);
		Applicant.setLastSmsDate(lastSmsDate);
		Applicant.setJobName(Job_Name);
		Applicant.setStageInTheProcess(Stage_In_Process);
		Applicant.setApplicantStatus(Applicant_Status);
		Applicant.setApplicantType(Applicant_Type);
		
		Applicant.setmacLabInterviewComplete("No");
		Applicant.setmacLabourInterviewComments("N/A");
		Applicant.setSmsGroupCount(0);
		Applicant.setPracticalDriversTestComments("N/A");
		Applicant.setPracticalDriversTestComplete("No");
		Applicant.setClientInterviewComments("N/A");
		Applicant.setClientInterviewComplete("No");
		Applicant.setReferenceChecksComments("N/A");
		Applicant.setReferenceChecksComplete("Yes");
		Applicant.setSmsGroup("None");
		Applicant.setSmsGroupCount(3);
		
		
		if(rsaCitizen == "Yes")
		{
			Applicant.setNationality("SA");
			
		}
		else
		{
			Applicant.setNationality("N/A");
		}
		
		
		
		
		Applicant.setSmsAccountActive("Yes");
		Applicant.setLastUsedDate(dateFormat.format(date));
		
		session.save(Applicant);
				
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	
	public void AddAppicantInformation(String name, String surname,String Id_Number,String cellNumber, String jobType,String email,int age)
	{
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		
		cellNumber= cellNumber.replaceAll("0", "+27");
		
		MacApplicants Applicant = new MacApplicants();
		
		Applicant.setName(name);
		Applicant.setSurname(surname);
		Applicant.setIdNumber(Id_Number);
		Applicant.setCellNumber(cellNumber);
		Applicant.setJobType(jobType);
		Applicant.setEmail(email);
		Applicant.setAge(age);
		
		Applicant.setLastUsedDate(dateFormat.format(date));
		
		session.save(Applicant);
				
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	public List<MacApplicants> ReadAllApplicants()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from MacApplicants");
		List<MacApplicants> Applicant = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return Applicant;
		
		
		
	}
	
	
	public List<MacApplicants> ReadAllApplicantsSmsConsole()
	{
		Session session = this.getSession();
		HibernateUtil.beginTransaction();
		
		
		
		Query query = session.createQuery("from MacApplicants WHERE Sms_Account_Active = 'Yes' ");
		List<MacApplicants> Applicant = query.list();
		
		session.clear(); // ADDED 170302
		session.flush();
		session.close();
		
		return Applicant;
		
		
		
	}

}
