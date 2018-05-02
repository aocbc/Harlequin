package aoc.Harlequin.OBJs;

import java.util.Collection;

// Generated 24 Apr 2018 3:28:58 PM by Hibernate Tools 3.4.0.CR1

/**
 * JobHistory generated by hbm2java
 */
public class JobHistory implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idJobHistory;
	private String jobRole;
	private String jobDescription;
	private String employerContactPerson;
	private String employerContactNumber;
	private String employerIndustry;
	private String periodFrom;
	private String periodTo;
	private String idMacApplicants;
	private String name;
	private String surname;
	private String employerName;

	public JobHistory() {
	}

	public JobHistory(int idJobHistory, String idMacApplicants) {
		this.idJobHistory = idJobHistory;
		this.idMacApplicants = idMacApplicants;
	}

	public JobHistory(int idJobHistory, String jobRole, String jobDescription,
			String employerContactPerson, String employerContactNumber,
			String employerIndustry, String periodFrom, String periodTo,
			String idMacApplicants, String name, String surname,String employerName) {
		this.idJobHistory = idJobHistory;
		this.jobRole = jobRole;
		this.jobDescription = jobDescription;
		this.employerContactPerson = employerContactPerson;
		this.employerContactNumber = employerContactNumber;
		this.employerIndustry = employerIndustry;
		this.periodFrom = periodFrom;
		this.periodTo = periodTo;
		this.idMacApplicants = idMacApplicants;
		this.name = name;
		this.surname = surname;
		this.employerName = employerName;
	}

	public int getIdJobHistory() {
		return this.idJobHistory;
	}

	public void setIdJobHistory(int idJobHistory) {
		this.idJobHistory = idJobHistory;
	}

	public String getJobRole() {
		return this.jobRole;
	}

	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}

	public String getJobDescription() {
		return this.jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getEmployerContactPerson() {
		return this.employerContactPerson;
	}

	public void setEmployerContactPerson(String employerContactPerson) {
		this.employerContactPerson = employerContactPerson;
	}

	public String getEmployerContactNumber() {
		return this.employerContactNumber;
	}

	public void setEmployerContactNumber(String employerContactNumber) {
		this.employerContactNumber = employerContactNumber;
	}

	public String getEmployerIndustry() {
		return this.employerIndustry;
	}

	public void setEmployerIndustry(String employerIndustry) {
		this.employerIndustry = employerIndustry;
	}

	public String getPeriodFrom() {
		return this.periodFrom;
	}

	public void setPeriodFrom(String periodFrom) {
		this.periodFrom = periodFrom;
	}

	public String getPeriodTo() {
		return this.periodTo;
	}

	public void setPeriodTo(String periodTo) {
		this.periodTo = periodTo;
	}

	public String getIdMacApplicants() {
		return this.idMacApplicants;
	}

	public void setIdMacApplicants(String idMacApplicants) {
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
	
	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getEmployerName() {
		// TODO Auto-generated method stub
		return this.employerName;
	}

}
