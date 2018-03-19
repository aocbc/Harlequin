package aoc.Harlequin.OBJs;

// Generated 06 Mar 2018 11:04:37 AM by Hibernate Tools 3.4.0.CR1

/**
 * SystemClient generated by hbm2java
 */
public class SystemClient implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idClient;
	private String clientName;
	private String clientEMail;
	private String clientContactName;
	private String clientContactNumber;
	private String clientAddress1;
	private String clientAddress2;
	private String clientAddress3;
	private String clientAddress4;
	private String clientVatNumber;
	private String clientComments;

	public SystemClient() 
	{
	
	}

	public SystemClient(String clientName, String clientEMail,String clientContactName, String clientContactNumber) 
	{
		this.clientName = clientName;
		this.clientEMail = clientEMail;
		this.clientContactName = clientContactName;
		this.clientContactNumber = clientContactNumber;
	}

	public SystemClient(String clientName, String clientEMail,String clientContactName, String clientContactNumber,	String clientAddress1, String clientAddress2,String clientAddress3, String clientAddress4,String clientVatNumber, String clientComments) 
	{
		this.clientName = clientName;
		this.clientEMail = clientEMail;
		this.clientContactName = clientContactName;
		this.clientContactNumber = clientContactNumber;
		this.clientAddress1 = clientAddress1;
		this.clientAddress2 = clientAddress2;
		this.clientAddress3 = clientAddress3;
		this.clientAddress4 = clientAddress4;
		this.clientVatNumber = clientVatNumber;
		this.clientComments = clientComments;
	}

	public Integer getIdClient() 
	{
		return this.idClient;
	}

	public void setIdClient(Integer idClient) 
	{
		this.idClient = idClient;
	}

	public String getClientName() 
	{
		return this.clientName;
	}

	public void setClientName(String clientName) 
	{
		this.clientName = clientName;
	}

	public String getClientEMail() 
	{
		return this.clientEMail;
	}

	public void setClientEMail(String clientEMail) 
	{
		this.clientEMail = clientEMail;
	}

	public String getClientContactName() 
	{
		return this.clientContactName;
	}

	public void setClientContactName(String clientContactName) 
	{
		this.clientContactName = clientContactName;
	}

	public String getClientContactNumber() 
	{
		return this.clientContactNumber;
	}

	public void setClientContactNumber(String clientContactNumber) 
	{
		this.clientContactNumber = clientContactNumber;
	}

	public String getClientAddress1() {
		return this.clientAddress1;
	}

	public void setClientAddress1(String clientAddress1) {
		this.clientAddress1 = clientAddress1;
	}

	public String getClientAddress2() {
		return this.clientAddress2;
	}

	public void setClientAddress2(String clientAddress2) {
		this.clientAddress2 = clientAddress2;
	}

	public String getClientAddress3() {
		return this.clientAddress3;
	}

	public void setClientAddress3(String clientAddress3) {
		this.clientAddress3 = clientAddress3;
	}

	public String getClientAddress4() {
		return this.clientAddress4;
	}

	public void setClientAddress4(String clientAddress4) {
		this.clientAddress4 = clientAddress4;
	}

	public String getClientVatNumber() {
		return this.clientVatNumber;
	}

	public void setClientVatNumber(String clientVatNumber) {
		this.clientVatNumber = clientVatNumber;
	}

	public String getClientComments() {
		return this.clientComments;
	}

	public void setClientComments(String clientComments) {
		this.clientComments = clientComments;
	}

}
