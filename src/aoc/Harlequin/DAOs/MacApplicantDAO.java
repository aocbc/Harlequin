package aoc.Harlequin.DAOs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
	
	
	public MacApplicants UpdateAppplicantLastSmsDateById(int id, String Sms_Group,int SmsGroupCount)
	{
		
		
		
		
		
		Session session = this.getSession();

		HibernateUtil.beginTransaction();
	   
		
		MacApplicants applicants = session.get(MacApplicants.class, id);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		
		
		String lastSmsDate = localDate.toString();
		
		applicants.setLastSmsDate(lastSmsDate);
		applicants.setSmsGroup(Sms_Group);
		applicants.setSmsGroupCount(SmsGroupCount);
		
		
		
		
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
	
	
	
	public void AddAppicantInformation(String name, String surname, String rsaCitizen,String Id_Number,String Passport_Number,String expiryDateOfPassport, String workPermitValidity, String cellNumber,String telephoneNumber, String jobType,String dateFirstIssueLicense, String licenseCode,String expiryDateOfLicense, String pdpExpiryDate, String gender, String physicalAddress1, String physicalAddress2,String physicalAddress3, String physicalAddress4, String City,String Country, String Tax_No, String maritalStatus, String dependants, String homeLanguage, String workHistory1, String workHistory2, String workHistory3, String workHistory4,String email,int Age,String DateOfBirth,String lastSmsDate, String Job_Name,String Stage_In_Process, String Applicant_Status)
	{
		
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
		
		
		session.save(Applicant);
				
		session.getTransaction().commit();
		
		session.close();
		
	}
	
	
	public void AddAppicantInformation(String name, String surname,String Id_Number,String cellNumber, String jobType,String email,int age)
	{
		
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

}
