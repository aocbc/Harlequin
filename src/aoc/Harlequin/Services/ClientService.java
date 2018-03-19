package aoc.Harlequin.Services;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import aoc.Harlequin.DAOs.ClientDAO;
import aoc.Harlequin.DAOs.SystemUserDAO;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemUser;




@Path("Client")
public class ClientService {
	
	@Path("/GetClientInfo")
	@GET
	@Produces("text/plain")
	public String GET( ) throws Exception
	{
		
		ClientDAO Object  = new ClientDAO();
		SystemClient Client  = Object.getClientInfoById(1);
		
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("idClient", Client.getIdClient());
		jsonObject.put("Client_Name", Client.getClientName());
		jsonObject.put("Client_E_Mail", Client.getClientEMail());
		jsonObject.put("Client_Contact_Name", Client.getClientContactName());
		jsonObject.put("Client_Contact_Number", Client.getClientContactNumber());		
		jsonObject.put("Client_Address_1", Client.getClientAddress1());
		jsonObject.put("Client_Address_2", Client.getClientAddress2());
		jsonObject.put("Client_Address_3", Client.getClientAddress3());
		jsonObject.put("Client_Address_4", Client.getClientAddress4());
		jsonObject.put("Client_Vat_Number", Client.getClientVatNumber());
		jsonObject.put("Client_Comments", Client.getClientComments());
		
		
		System.out.println(jsonObject.toString());
	    
		return jsonObject.toString();
	}
	
	@Path("/GetAllClients")
	@GET
	@Produces("text/plain")
	public String GETClients( ) throws Exception
	{
		
		ClientDAO Object  = new ClientDAO();
		
		List<SystemClient> Clients = Object.ReadAllClients();
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Clients.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("idClient", Clients.get(i).getIdClient());
			jsonObject.put("Client_Name", Clients.get(i).getClientName());
			jsonObject.put("Client_E_Mail", Clients.get(i).getClientEMail());
			jsonObject.put("Client_Contact_Name", Clients.get(i).getClientContactName());
			jsonObject.put("Client_Contact_Number", Clients.get(i).getClientContactNumber());		
			jsonObject.put("Client_Address_1", Clients.get(i).getClientAddress1());
			jsonObject.put("Client_Address_2", Clients.get(i).getClientAddress2());
			jsonObject.put("Client_Address_3", Clients.get(i).getClientAddress3());
			jsonObject.put("Client_Address_4", Clients.get(i).getClientAddress4());
			jsonObject.put("Client_Vat_Number", Clients.get(i).getClientVatNumber());
			jsonObject.put("Client_Comments", Clients.get(i).getClientComments());
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
	    
		return JsonArray.toString();
	}
	
	
	@Path("/GetUser/{Username}/{Password}")
	@GET
	@Produces("text/plain")
	public String GET1(@PathParam("Username") String Username,@PathParam("Password") String Password ) throws Exception
	{
		
		String Matched = "false";
		String PasswordUser = "";
		
		SystemUserDAO Object  = new SystemUserDAO();
		
		List<SystemUser> User = Object.CheckUserPassword(Username, Password);
		
		if(User.size() != 0)
		{
			PasswordUser = User.get(0).getUserPassword().toString();
			if(Password.equals(PasswordUser.trim()))
			{
				Matched = "true";
			}
		}
		
		System.out.println("Password:" + Password + ", UserPassword:" + PasswordUser) ;
		
		
		
		
		
		return Matched;
	}
	
	
	@Path("/SaveClientInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		
		System.out.println(jsonTextObject);
		JSONObject r = new JSONObject(jsonTextObject);	
	
		
		System.out.println("WRITING TO DATABASE:"+ r.getString("Client_Name"));
			
		ClientDAO Object  = new ClientDAO();
		Object.AddClientInformation(r.getString("Client_Name"), r.getString("Client_E_Mail"), r.getString("Client_Contact_Name"), r.getString("Client_Contact_Number"), r.getString("Client_Address_1"), r.getString("Client_Address_2"), r.getString("Client_Address_3"), r.getString("Client_Address_4"), r.getString("Client_Vat_Number"), r.getString("Client_Comments"));
		return "Sucessful";	
		
			
	}
	
	
	

}
