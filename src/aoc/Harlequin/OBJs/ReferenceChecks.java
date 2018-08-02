package aoc.Harlequin.OBJs;

// Generated 01 Aug 2018 5:33:20 PM by Hibernate Tools 3.4.0.CR1

/**
 * ReferenceChecks generated by hbm2java
 */
public class ReferenceChecks implements java.io.Serializable {

	private int idReferenceChecks;
	private int idMacApplicants;
	private String applicantName;
	private String applicantSurname;
	private String idNumber;
	private String allReferenceChecksPassed;
	private String applicantsOverallReference;
	private String criminalCheckPassed;
	private String applicantsCriminalChecksCriteria;
	private String exitMedicalDone;
	private String referenceCheckComplete;
	private String lastUsedDate;
	private String username;
	private String usersurname;
	private String jobName;

	public ReferenceChecks() {
	}

	public ReferenceChecks(int idReferenceChecks, int idMacApplicants) {
		this.idReferenceChecks = idReferenceChecks;
		this.idMacApplicants = idMacApplicants;
	}

	public ReferenceChecks(int idReferenceChecks, int idMacApplicants,
			String applicantName, String applicantSurname, String idNumber,
			String allReferenceChecksPassed, String applicantsOverallReference,
			String criminalCheckPassed,
			String applicantsCriminalChecksCriteria, String exitMedicalDone,
			String referenceCheckComplete, String lastUsedDate,
			String username, String usersurname, String jobName) {
		this.idReferenceChecks = idReferenceChecks;
		this.idMacApplicants = idMacApplicants;
		this.applicantName = applicantName;
		this.applicantSurname = applicantSurname;
		this.idNumber = idNumber;
		this.allReferenceChecksPassed = allReferenceChecksPassed;
		this.applicantsOverallReference = applicantsOverallReference;
		this.criminalCheckPassed = criminalCheckPassed;
		this.applicantsCriminalChecksCriteria = applicantsCriminalChecksCriteria;
		this.exitMedicalDone = exitMedicalDone;
		this.referenceCheckComplete = referenceCheckComplete;
		this.lastUsedDate = lastUsedDate;
		this.username = username;
		this.usersurname = usersurname;
		this.jobName = jobName;
	}

	
	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	
	public int getIdReferenceChecks() {
		return this.idReferenceChecks;
	}

	public void setIdReferenceChecks(int idReferenceChecks) {
		this.idReferenceChecks = idReferenceChecks;
	}

	public int getIdMacApplicants() {
		return this.idMacApplicants;
	}

	public void setIdMacApplicants(int idMacApplicants) {
		this.idMacApplicants = idMacApplicants;
	}

	public String getApplicantName() {
		return this.applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getApplicantSurname() {
		return this.applicantSurname;
	}

	public void setApplicantSurname(String applicantSurname) {
		this.applicantSurname = applicantSurname;
	}

	public String getIdNumber() {
		return this.idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getAllReferenceChecksPassed() {
		return this.allReferenceChecksPassed;
	}

	public void setAllReferenceChecksPassed(String allReferenceChecksPassed) {
		this.allReferenceChecksPassed = allReferenceChecksPassed;
	}

	public String getApplicantsOverallReference() {
		return this.applicantsOverallReference;
	}

	public void setApplicantsOverallReference(String applicantsOverallReference) {
		this.applicantsOverallReference = applicantsOverallReference;
	}

	public String getCriminalCheckPassed() {
		return this.criminalCheckPassed;
	}

	public void setCriminalCheckPassed(String criminalCheckPassed) {
		this.criminalCheckPassed = criminalCheckPassed;
	}

	public String getApplicantsCriminalChecksCriteria() {
		return this.applicantsCriminalChecksCriteria;
	}

	public void setApplicantsCriminalChecksCriteria(
			String applicantsCriminalChecksCriteria) {
		this.applicantsCriminalChecksCriteria = applicantsCriminalChecksCriteria;
	}

	public String getExitMedicalDone() {
		return this.exitMedicalDone;
	}

	public void setExitMedicalDone(String exitMedicalDone) {
		this.exitMedicalDone = exitMedicalDone;
	}

	public String getReferenceCheckComplete() {
		return this.referenceCheckComplete;
	}

	public void setReferenceCheckComplete(String referenceCheckComplete) {
		this.referenceCheckComplete = referenceCheckComplete;
	}

	public String getLastUsedDate() {
		return this.lastUsedDate;
	}

	public void setLastUsedDate(String lastUsedDate) {
		this.lastUsedDate = lastUsedDate;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsersurname() {
		return this.usersurname;
	}

	public void setUsersurname(String usersurname) {
		this.usersurname = usersurname;
	}

}
