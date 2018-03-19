package aoc.Harlequin.OBJs;

// Generated 19 Mar 2018 3:47:12 PM by Hibernate Tools 3.4.0.CR1

/**
 * SystemJob generated by hbm2java
 */
public class SystemJob implements java.io.Serializable {

	private Integer jobId;
	private String jobName;
	private String jobCode;
	private String jobClientName;
	private String jobDetails;
	private String jobComments;

	public SystemJob() {
	}

	public SystemJob(String jobName) {
		this.jobName = jobName;
	}

	public SystemJob(String jobName, String jobCode, String jobClientName,
			String jobDetails, String jobComments) {
		this.jobName = jobName;
		this.jobCode = jobCode;
		this.jobClientName = jobClientName;
		this.jobDetails = jobDetails;
		this.jobComments = jobComments;
	}

	public Integer getJobId() {
		return this.jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobCode() {
		return this.jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	public String getJobClientName() {
		return this.jobClientName;
	}

	public void setJobClientName(String jobClientName) {
		this.jobClientName = jobClientName;
	}

	public String getJobDetails() {
		return this.jobDetails;
	}

	public void setJobDetails(String jobDetails) {
		this.jobDetails = jobDetails;
	}

	public String getJobComments() {
		return this.jobComments;
	}

	public void setJobComments(String jobComments) {
		this.jobComments = jobComments;
	}

}
