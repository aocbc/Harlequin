package aoc.Harlequin.OBJs;

import java.util.Collection;

// Generated 19 Mar 2018 10:38:10 AM by Hibernate Tools 3.4.0.CR1

/**
 * MacApplicants generated by hbm2java
 */
public class MacApplicants implements java.io.Serializable {

	private Integer idMacApplicants;
	private String name;
	private String surname;
	private String rsaCitizen;
	private String Id_Number;
	private String workPermitValidity;
	private String cellNumber;
	private String telephoneNumber;
	private String jobType;
	private String dateFirstIssueLicense;
	private String licenseCode;
	private String expiryDateOfLicense;
	private String pdpExpiryDate;
	private String gender;
	private String physicalAddress1;
	private String physicalAddress2;
	private String physicalAddress3;
	private String physicalAddress4;
	private String maritalStatus;
	private String dependants;
	private String homeLanguage;
	private String workHistory1;
	private String workHistory2;
	private String workHistory3;
	private String workHistory4;
	private String email;
	private String passportNumber;
	private String expiryDateOfPassport;
	private String city;
	private String tax_No;
	private String country;
	private Integer age;
	private String dateOfBirth;
	private String lastSmsDate;
	private String jobName;
	private String stageInTheProcess;
	private String applicantStatus;
	private String smsGroup;
	private int smsGroupCount;
	private String applicantType;
	private String nationality;
	private String macLabourInterviewComments;
	private String macLabInterviewComplete;
	private String practicalDriversTestComplete;
	private String practicalDriversTestComments;
	private String clientInterviewComplete;
	private String clientInterviewComments;
	
	private String referenceChecksComplete;
	private String referenceChecksComments;
	
	
	private String smsAccountActive;
	
	public MacApplicants() {
	}

	public MacApplicants(String name, String surname, String rsaCitizen,
			String Id_Number, String workPermitValidity, String cellNumber,
			String telephoneNumber, String jobType,String macLabourInterviewComments,String macLabInterviewComplete,
			String dateFirstIssueLicense, String licenseCode,
			String expiryDateOfLicense, String pdpExpiryDate, String gender,
			String physicalAddress1, String physicalAddress2,
			String physicalAddress3, String physicalAddress4, String practicalDriversTestComplete,
			String practicalDriversTestComments,String clientInterviewComplete, String clientInterviewComments,
			String maritalStatus, String dependants, String homeLanguage,String referenceChecksComments,String referenceChecksComplete,
			String workHistory1, String workHistory2, String workHistory3,String jobName,
			String workHistory4, String email, String passportNumber,String expiryDateOfPassport, String city, String tax_No,String country,int age,String dateOfBirth,String lastSmsDate, String stageInTheProcess, String applicantStatus,String smsGroup,int smsGroupCount,String applicantType,String nationality, String smsAccountActive) 
	{
		this.name = name;
		this.surname = surname;
		this.rsaCitizen = rsaCitizen;
		this.Id_Number = Id_Number;
		this.workPermitValidity = workPermitValidity;
		this.cellNumber = cellNumber;
		this.telephoneNumber = telephoneNumber;
		this.jobType = jobType;
		this.dateFirstIssueLicense = dateFirstIssueLicense;
		this.licenseCode = licenseCode;
		this.expiryDateOfLicense = expiryDateOfLicense;
		this.pdpExpiryDate = pdpExpiryDate;
		this.gender = gender;
		this.physicalAddress1 = physicalAddress1;
		this.physicalAddress2 = physicalAddress2;
		this.physicalAddress3 = physicalAddress3;
		this.physicalAddress4 = physicalAddress4;
		this.maritalStatus = maritalStatus;
		this.dependants = dependants;
		this.homeLanguage = homeLanguage;
		this.workHistory1 = workHistory1;
		this.workHistory2 = workHistory2;
		this.workHistory3 = workHistory3;
		this.workHistory4 = workHistory4;
		this.email = email;
		this.expiryDateOfPassport = expiryDateOfPassport;
		this.city = city;
		this.tax_No = tax_No;
		this.country = country;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
		this.lastSmsDate = lastSmsDate;
		this.jobName = jobName;
		this.stageInTheProcess = stageInTheProcess;
		this.applicantStatus = applicantStatus;
		this.smsGroup = smsGroup;
		this.smsGroupCount = smsGroupCount;
		this.applicantType = applicantType;
		this.nationality = nationality;
		this.macLabourInterviewComments = macLabourInterviewComments;
		this.macLabInterviewComplete = macLabInterviewComplete;
		this.practicalDriversTestComplete = practicalDriversTestComplete;
		this.practicalDriversTestComments = practicalDriversTestComments; 
		this.clientInterviewComments = clientInterviewComments ;
		this.clientInterviewComplete = clientInterviewComplete; 
		this.referenceChecksComments = referenceChecksComments;
		this.referenceChecksComplete = referenceChecksComplete;
		this.smsAccountActive = smsAccountActive;
	}

	public Integer getIdMacApplicants() {
		return this.idMacApplicants;
	}

	public void setIdMacApplicants(Integer idMacApplicants) {
		this.idMacApplicants = idMacApplicants;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRsaCitizen() {
		return this.rsaCitizen;
	}

	public void setRsaCitizen(String rsaCitizen) {
		this.rsaCitizen = rsaCitizen;
	}

	public String getIdNumber() {
		return this.Id_Number;
	}

	public void setIdNumber(String Id_Number) {
		this.Id_Number = Id_Number;
	}

	public String getWorkPermitValidity() {
		return this.workPermitValidity;
	}

	public void setWorkPermitValidity(String workPermitValidity) {
		this.workPermitValidity = workPermitValidity;
	}

	public String getCellNumber() {
		return this.cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getTelephoneNumber() {
		return this.telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getJobType() {
		return this.jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getDateFirstIssueLicense() {
		return this.dateFirstIssueLicense;
	}

	public void setDateFirstIssueLicense(String dateFirstIssueLicense) {
		this.dateFirstIssueLicense = dateFirstIssueLicense;
	}

	public String getLicenseCode() {
		return this.licenseCode;
	}

	public void setLicenseCode(String licenseCode) {
		this.licenseCode = licenseCode;
	}

	public String getExpiryDateOfLicense() {
		return this.expiryDateOfLicense;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getPassportNumber() {
		return this.passportNumber;
	}
	
	

	
	public String getExpiryDateOfPassport() {
		return this.expiryDateOfPassport;
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	public String getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	public String getJobName() {
		return this.jobName;
	}
	
	
	
	public void setExpiryDateOfPassport(String expiryDateOfPassport) {
		this.expiryDateOfPassport = expiryDateOfPassport;
	}
	
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	public void setExpiryDateOfLicense(String expiryDateOfLicense) {
		this.expiryDateOfLicense = expiryDateOfLicense;
	}

	public String getPdpExpiryDate() {
		return this.pdpExpiryDate;
	}

	public void setPdpExpiryDate(String pdpExpiryDate) {
		this.pdpExpiryDate = pdpExpiryDate;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhysicalAddress1() {
		return this.physicalAddress1;
	}

	public void setPhysicalAddress1(String physicalAddress1) {
		this.physicalAddress1 = physicalAddress1;
	}

	public String getPhysicalAddress2() {
		return this.physicalAddress2;
	}

	public void setPhysicalAddress2(String physicalAddress2) {
		this.physicalAddress2 = physicalAddress2;
	}

	public String getPhysicalAddress3() {
		return this.physicalAddress3;
	}

	public void setPhysicalAddress3(String physicalAddress3) {
		this.physicalAddress3 = physicalAddress3;
	}

	public String getPhysicalAddress4() {
		return this.physicalAddress4;
	}

	public void setPhysicalAddress4(String physicalAddress4) {
		this.physicalAddress4 = physicalAddress4;
	}

	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getDependants() {
		return this.dependants;
	}

	public void setDependants(String dependants) {
		this.dependants = dependants;
	}

	public String getHomeLanguage() {
		return this.homeLanguage;
	}

	public void setHomeLanguage(String homeLanguage) {
		this.homeLanguage = homeLanguage;
	}

	public String getWorkHistory1() {
		return this.workHistory1;
	}

	public void setWorkHistory1(String workHistory1) {
		this.workHistory1 = workHistory1;
	}

	public String getWorkHistory2() {
		return this.workHistory2;
	}

	public void setWorkHistory2(String workHistory2) {
		this.workHistory2 = workHistory2;
	}

	public String getWorkHistory3() {
		return this.workHistory3;
	}

	public void setWorkHistory3(String workHistory3) {
		this.workHistory3 = workHistory3;
	}

	public String getWorkHistory4() {
		return this.workHistory4;
	}

	public void setWorkHistory4(String workHistory4) {
		this.workHistory4 = workHistory4;
	}

	public void setEmail(String email) {
		// TODO Auto-generated method stub
		this.email = email;
		
	}

	public void setCity(String city) 
	{
		// TODO Auto-generated method stub
		this.city = city;
	}
	
	
	public String getCity() {
		return this.city;
	}

	public void setTaxNo(String tax_No) 
	{
		// TODO Auto-generated method stub
		this.tax_No = tax_No;
	}
	
	
	public String getTaxNo() {
		return this.tax_No;
	}

	public void setCountry(String country) 
	{
		// TODO Auto-generated method stub
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}

	public void setAge(int age) {
		// TODO Auto-generated method stub
		this.age = age;
	}

	public void setDateOfBirth(String dateOfBirth) 
	{
		// TODO Auto-generated method stub
		this.dateOfBirth = dateOfBirth;
		
	}

	public void setLastSmsDate(String lastSmsDate) 
	{
		// TODO Auto-generated method stub
		this.lastSmsDate = lastSmsDate;
	}

	public String getLastSmsDate() 
	{
		// TODO Auto-generated method stub
		return this.lastSmsDate;
	}

	public void setJobName(String job_Name) 
	{
		// TODO Auto-generated method stub
		this.jobName = job_Name;

		
	}
	
	public void setStageInTheProcess(String stageInTheProcess)
	{
		// TODO Auto-generated method stub
		this.stageInTheProcess = stageInTheProcess;
		
	}
	
	public String getStageInTheProcess() {
		return this.stageInTheProcess;
	}
	
	
	public void setApplicantStatus(String applicantStatus)
	{
		// TODO Auto-generated method stub
		this.applicantStatus = applicantStatus;
		
	}
	
	public String getApplicantStatus() {
		return this.applicantStatus;
	}
	
	public void setSmsGroup(String smsGroup)
	{
		// TODO Auto-generated method stub
		this.smsGroup = smsGroup;
		
	}
	
	public String getSmsGroup() 
	{
		return this.smsGroup;
	}

	public void setSmsGroupCount(int smsGroupCount)
	{
		// TODO Auto-generated method stub
		this.smsGroupCount = smsGroupCount;
		
	}
	
	public int getSmsGroupCount() 
	{
		return this.smsGroupCount;
	}
	
	public void setApplicantType(String applicantType)
	{
		// TODO Auto-generated method stub
		this.applicantType = applicantType;
		
	}
	
	public String getApplicantType() 
	{
		return this.applicantType;
	}
	
	public void setNationality(String nationality)
	{
		// TODO Auto-generated method stub
		this.nationality = nationality;
		
	}
	
	public String getNationality() 
	{
		return this.nationality;
	}
	
	
	public void setmacLabourInterviewComments(String macLabourInterviewComments)
	{
		// TODO Auto-generated method stub
		this.macLabourInterviewComments = macLabourInterviewComments;
		
	}
	
	public String getmacLabourInterviewComments() 
	{
		return this.macLabourInterviewComments;
	}

	public void setmacLabInterviewComplete(String macLabInterviewComplete)
	{
		// TODO Auto-generated method stub
		this.macLabInterviewComplete = macLabInterviewComplete;
		
	}
	
	public String getmacLabInterviewComplete() 
	{
		return this.macLabInterviewComplete;
	}

	public String getPracticalDriversTestComments() 
	{
		return this.practicalDriversTestComments;
	}

	public void setPracticalDriversTestComments(String practicalDriversTestComments) 
	{
		this.practicalDriversTestComments = practicalDriversTestComments;
	}
	
	
	public String getPracticalDriversTestComplete() 
	{
		return this.practicalDriversTestComplete;
	}

	public void setPracticalDriversTestComplete(String practicalDriversTestComplete) 
	{
		this.practicalDriversTestComplete = practicalDriversTestComplete;
	}
	
	
	public String getClientInterviewComplete() 
	{
		return this.clientInterviewComplete;
	}

	public void setClientInterviewComplete(String clientInterviewComplete) 
	{
		this.clientInterviewComplete = clientInterviewComplete;
	}
	
	public String getClientInterviewComments() 
	{
		return this.clientInterviewComments;
	}

	public void setClientInterviewComments(String clientInterviewComments) 
	{
		this.clientInterviewComments = clientInterviewComments;
	}
	
	public String getReferenceChecksComplete() 
	{
		return this.referenceChecksComplete;
	}
	
	public String getReferenceChecksComments() 
	{
		return this.referenceChecksComments;
	}

	public void setReferenceChecksComments(String referenceChecksComments) 
	{
		this.referenceChecksComments = referenceChecksComments;
	}
	
	public void setReferenceChecksComplete(String referenceChecksComplete) 
	{
		this.referenceChecksComplete = referenceChecksComplete;
	}
	
	
	public void setSmsAccountActive(String smsAccountActive) 
	{
		this.smsAccountActive = smsAccountActive;
	}
	
	public String getSmsAccountActive() 
	{
		return this.smsAccountActive;
	}
	

}
