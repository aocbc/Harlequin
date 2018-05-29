package aoc.Harlequin.OBJs;

// Generated 21 May 2018 10:48:32 AM by Hibernate Tools 3.4.0.CR1

/**
 * ApplicantSmsHistory generated by hbm2java
 */
public class ApplicantSmsHistory implements java.io.Serializable {

	private Integer idApplicantSmsHistory;
	private Integer idMacApplicants;
	private String cellNumber;
	private String message;
	private String jobName;
	private String clientName;
	private String smsGroup;
	
	public ApplicantSmsHistory() {
	}

	public ApplicantSmsHistory(Integer idMacApplicants, String cellNumber,
			String message, String jobName, String clientName, String smsGroup) {
		this.idMacApplicants = idMacApplicants;
		this.cellNumber = cellNumber;
		this.message = message;
		this.jobName = jobName;
		this.clientName = clientName;
		this.smsGroup = smsGroup;
	}

	public Integer getIdApplicantSmsHistory() {
		return this.idApplicantSmsHistory;
	}

	public void setIdApplicantSmsHistory(Integer idApplicantSmsHistory) {
		this.idApplicantSmsHistory = idApplicantSmsHistory;
	}

	public Integer getIdMacApplicants() {
		return this.idMacApplicants;
	}

	public void setIdMacApplicants(Integer idMacApplicants) {
		this.idMacApplicants = idMacApplicants;
	}

	public String getCellNumber() {
		return this.cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getClientName() {
		return this.clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	public String getSmsGroup() {
		return this.smsGroup;
	}

	public void setSmsGroup(String smsGroup) {
		this.smsGroup = smsGroup;
	}


}