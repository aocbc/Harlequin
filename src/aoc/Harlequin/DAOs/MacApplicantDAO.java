package aoc.Harlequin.DAOs;

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
	
	
	public void AddAppicantInformation(String name, String surname, String rsaCitizen,String Id_Number,String Passport_Number,String expiryDateOfPassport, String workPermitValidity, String cellNumber,String telephoneNumber, String jobType,String dateFirstIssueLicense, String licenseCode,String expiryDateOfLicense, String pdpExpiryDate, String gender, String physicalAddress1, String physicalAddress2,String physicalAddress3, String physicalAddress4, String maritalStatus, String dependants, String homeLanguage, String workHistory1, String workHistory2, String workHistory3, String workHistory4,String email)
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
		Applicant.setMaritalStatus(maritalStatus);
		Applicant.setDependants(dependants);
		Applicant.setHomeLanguage(homeLanguage);
		Applicant.setWorkHistory1(workHistory1);
		Applicant.setWorkHistory2(workHistory2);
		Applicant.setWorkHistory3(workHistory3);
		Applicant.setWorkHistory4(workHistory4);
		Applicant.setEmail(email);
		
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
