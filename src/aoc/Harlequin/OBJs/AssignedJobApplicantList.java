package aoc.Harlequin.OBJs;

// Generated 13 Jul 2018 2:39:07 PM by Hibernate Tools 3.4.0.CR1

/**
 * AssignedJobApplicantList generated by hbm2java
 */
public class AssignedJobApplicantList implements java.io.Serializable {

	private int idAssignedJobApplicantList;
	private int jobId;
	private String jobName;
	private String jobCode;
	private String jobClientName;
	private String jobDetails;
	private String jobComments;
	private String jobType;
	private String idMacApplicants;
	private String name;
	private String surname;

	private String stageInProcess;
	private String stageStatus;
	
	private String macLabourInterviewComments;
	private String macLabInterviewComplete;
	
	private String practicalDriversTestComplete;
	private String practicalDriversTestComments;
	
	private String clientInterviewComplete;
	private String clientInterviewComments;
	
	private String referenceChecksComplete;
	private String referenceChecksComments;
	
	private String RoadTestPassed;
	private String ParkingTestPassed;
	
	
	

	
	
	public AssignedJobApplicantList() {
	}

	public AssignedJobApplicantList(int idAssignedJobApplicantList, int jobId, String jobName) {
		this.idAssignedJobApplicantList = idAssignedJobApplicantList;
		this.jobId = jobId;
		this.jobName = jobName;
	}

	public AssignedJobApplicantList(int idAssignedJobApplicantList, int jobId, String jobName, String jobCode, String jobClientName, String jobDetails,
			String jobComments, String jobType, String idMacApplicants,
			String name, String surname, String stageInProcess, String stageStatus,String macLabourInterviewComments, String macLabInterviewComplete, 
			String practicalDriversTestComplete, String practicalDriversTestComments,String clientInterviewComplete, String clientInterviewComments,
			String referenceChecksComplete, String referenceChecksComments, String RoadTestPassed , String ParkingTestPassed  ) 
	{
		this.idAssignedJobApplicantList = idAssignedJobApplicantList;
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobCode = jobCode;
		this.jobClientName = jobClientName;
		this.jobDetails = jobDetails;
		this.jobComments = jobComments;
		this.jobType = jobType;
		this.idMacApplicants = idMacApplicants;
		this.name = name;
		this.surname = surname;
		this.stageInProcess = stageInProcess;
		this.stageStatus = stageStatus;
		
		this.macLabourInterviewComments = macLabourInterviewComments;
		this.macLabInterviewComplete = macLabInterviewComplete;
		
		this.clientInterviewComplete = clientInterviewComplete;
		this.clientInterviewComments = clientInterviewComplete;
		
		this.referenceChecksComplete = referenceChecksComplete;
		this.referenceChecksComments = referenceChecksComments;
		
		this.practicalDriversTestComments = practicalDriversTestComments;
		this.practicalDriversTestComplete = practicalDriversTestComplete;
		
		this.RoadTestPassed = RoadTestPassed;
		this.ParkingTestPassed = ParkingTestPassed;
		
		
	}


	
	/////////////////////////////////////////////////////////////////////////////
	public String getRoadTestPassed() 
	{
		return this.RoadTestPassed;
	}
	
	public void setRoadTestPassed(String RoadTestPassed) 
	{
		this.RoadTestPassed = RoadTestPassed;
	}
	/////////////////////////////////////////////////////////////////////////////
	public String getParkingTestPassed() 
	{
		return this.ParkingTestPassed;
	}
	
	public void setParkingTestPassed(String ParkingTestPassed) 
	{
		this.ParkingTestPassed = ParkingTestPassed;
	}
	////////////////////////////////////////////////////////////////////////////
		
	public String getClientInterviewComments() 
	{
		return this.clientInterviewComments;
	}
	
	public void setClientInterviewComments(String clientInterviewComments) 
	{
		this.clientInterviewComments = clientInterviewComments;
	}

	////////////////////////////////////////////////////////////////////////////
		
	public String getPracticalDriversTestComplete() 
	{
		return this.practicalDriversTestComplete;
	}
	
	public void setPracticalDriversTestComplete(String practicalDriversTestComplete) 
	{
		this.practicalDriversTestComplete = practicalDriversTestComplete;
	}
	
	/////////////////////////////////////////////////////////////////////////////
	public String getPracticalDriversTestComments() 
	{
		return this.practicalDriversTestComments;
	}
	
	public void setPracticalDriversTestComments(String practicalDriversTestComments) 
	{
		this.practicalDriversTestComments = practicalDriversTestComments;
	}
	
	
	////////////////////////////////////////////////////////////////////////////
	
	public String getReferenceChecksComplete() 
	{
		return this.referenceChecksComplete;
	}

	public void setReferenceChecksComplete(String referenceChecksComplete) 
	{
		this.referenceChecksComplete = referenceChecksComplete;
	}
	////////////////////////////////////////////////////////////////////////////
		
	public String getReferenceChecksComments() 
	{
		return this.referenceChecksComments;
	}
	
	public void setReferenceChecksComments(String referenceChecksComments) 
	{
		this.referenceChecksComments = referenceChecksComments;
	}
	//////////////////////////////////////////////////////////////////////////
	public String getClientInterviewComplete() 
	{
		return this.clientInterviewComplete;
	}

	public void setClientInterviewComplete(String clientInterviewComplete) 
	{
		this.clientInterviewComplete = clientInterviewComplete;
	}
	
	////////////////////////////////////////////////////////////////////////////
	public String getMacLabInterviewComplete() 
	{
		return this.macLabInterviewComplete;
	}

	public void setMacLabInterviewComplete(String macLabInterviewComplete) 
	{
		this.macLabInterviewComplete = macLabInterviewComplete;
	}
	/////////////////////////////////////////////////////////////////////////////
	public String getMacLabourInterviewComments() 
	{
		return this.macLabourInterviewComments;
	}

	public void setMacLabourInterviewComments(String macLabourInterviewComments) 
	{
		this.macLabourInterviewComments = macLabourInterviewComments;
	}
	///////////////////////////////////////////////////////////////////////////
	
	
	public int getIdAssignedJobApplicantList() 
	{
		return this.idAssignedJobApplicantList;
	}

	public void setIdAssignedJobApplicantList(int idAssignedJobApplicantList) 
	{
		this.idAssignedJobApplicantList = idAssignedJobApplicantList;
	}
	
	

	public int getJobId() {
		return this.jobId;
	}

	public void setJobId(int jobId) {
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

	public String getJobType() {
		return this.jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
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

	
	public String getStageInProcess() {
		return this.stageInProcess;
	}

	public void setStageInProcess(String stageInProcess) {
		this.stageInProcess = stageInProcess;
	}
	
	
	public String getStageStatus() {
		return this.stageStatus;
	}

	public void setStageStatus(String stageStatus) {
		this.stageStatus = stageStatus;
	}
	
}
