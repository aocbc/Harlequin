package aoc.Harlequin.Services;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.json.JSONObject;

import aoc.Harlequin.DAOs.SystemUserDAO;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemUser;




@Path("User")
public class SystemUserService {
	
	@Path("/GetUserInfo")
	@GET
	@Produces("text/plain")
	public String GET( ) throws Exception
	{
		
		SystemUserDAO Object  = new SystemUserDAO();
		SystemUser User  = Object.getUserInfoById(1);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("idSystem_User", User.getIdSystemUser());
		jsonObject.put("User_Name", User.getUserName());
		jsonObject.put("Name", User.getName());
		jsonObject.put("Surname", User.getSurname());
		jsonObject.put("E_Mail", User.getEMail());		
		jsonObject.put("Cell_Number", User.getCellNumber());
		jsonObject.put("Tell_Number", User.getTellNumber());
		jsonObject.put("User_Password", User.getUserPassword());
		
		
		
	    
		return jsonObject.toString();
	}
	

}
