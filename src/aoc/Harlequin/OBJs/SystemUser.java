package aoc.Harlequin.OBJs;

// Generated 06 Mar 2018 11:04:37 AM by Hibernate Tools 3.4.0.CR1

/**
 * SystemUser generated by hbm2java
 */
public class SystemUser implements java.io.Serializable {

	private int idSystemUser;
	
	private String userName;
	private String name;
	private String surname;
	private String EMail;
	private String cellNumber;
	private String tellNumber;
	private String userPassword;
	private String authorizationLevel;

	public SystemUser() 
	{
	
	
	}

	public SystemUser(int idSystemUser, String userName, String name,String surname, String EMail, String cellNumber, String userPassword,String authorizationLevel) 
	{
		this.idSystemUser = idSystemUser;
		this.userName = userName;
		this.name = name;
		this.surname = surname;
		this.EMail = EMail;
		this.cellNumber = cellNumber;
		this.userPassword = userPassword;
		this.authorizationLevel = authorizationLevel;
	}

	

	public int getIdSystemUser() 
	{
		return this.idSystemUser;
	}

	public void setIdSystemUser(int idSystemUser) 
	{
		this.idSystemUser = idSystemUser;
	}

	public String getUserName() 
	{
		return this.userName;
	}

	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getName() 
	{
		return this.name;
	}
	
	public String getAuthorizationLevel() 
	{
		return this.authorizationLevel;
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

	public String getEMail() {
		return this.EMail;
	}

	public void setEMail(String EMail) {
		this.EMail = EMail;
	}

	public String getCellNumber() {
		return this.cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getTellNumber() {
		return this.tellNumber;
	}

	public void setTellNumber(String tellNumber) {
		this.tellNumber = tellNumber;
	}

	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setAuthorizationLevel(String authorizationLevel) 
	{
		// TODO Auto-generated method stub
		this.authorizationLevel = authorizationLevel;
	}

	

}
