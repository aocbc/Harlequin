package aoc.Harlequin.OBJs;

// Generated 19 Mar 2018 3:47:12 PM by Hibernate Tools 3.4.0.CR1

/**
 * SystemJob generated by hbm2java
 */
public class SystemJob implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3424364809718215072L;
	private Integer jobId;
	private String jobName;
	private String jobCode;
	private String jobClientName;
	private String jobDetails;
	private String jobComments;
	private String jobType;

	public SystemJob() {
	}

	public SystemJob(String jobName) {
		this.jobName = jobName;
	}

	public SystemJob(String jobName, String jobCode, String jobClientName,
			String jobDetails, String jobComments, String jobtype) {
		this.jobName = jobName;
		this.jobCode = jobCode;
		this.jobClientName = jobClientName;
		this.jobDetails = jobDetails;
		this.jobComments = jobComments;
		this.jobType = jobtype;
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
	
	public String getJobType() {
		return this.jobType;
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

	public void setJobType(String jobtype) {
		// TODO Auto-generated method stub
		this.jobType = jobtype;
		
	}

}
