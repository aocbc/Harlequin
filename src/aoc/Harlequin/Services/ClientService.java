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
import aoc.Harlequin.DAOs.JobDAO;
import aoc.Harlequin.DAOs.SystemUserDAO;
import aoc.Harlequin.OBJs.SystemClient;
import aoc.Harlequin.OBJs.SystemUser;




@Path("Client")
public class ClientService {
	
	@Path("/GetClientbyid/{idClient}")
	@GET
	@Produces("text/plain")
	public String GET(@PathParam("idClient") int idClient ) throws Exception
	{
		
		ClientDAO Object  = new ClientDAO();
		SystemClient Client  = Object.getClientInfoById(idClient);
		
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
	
	@Path("/UpdateClientInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String update(String jsonTextObject) throws JSONException
	{
		
		ClientDAO t = new ClientDAO();
		
		
		JSONObject test = new JSONObject(jsonTextObject);
		
		System.out.println("CLIENT ID:"+jsonTextObject);
		
		
		SystemClient Client  = t.getClientInfoById(test.getInt("idClient"));
				
		
		Client.setClientName(test.getString("Client_Name"));
		Client.setClientEMail(test.getString("Client_E_Mail"));
		Client.setClientContactNumber(test.getString("Client_Contact_Number"));
		Client.setClientContactName(test.getString("Client_Contact_Name"));
		Client.setClientAddress1(test.getString("Client_Address_1"));
		Client.setClientAddress1(test.getString("Client_Address_2"));
		Client.setClientAddress1(test.getString("Client_Address_3"));
		Client.setClientAddress1(test.getString("Client_Address_4"));
		Client.setClientAddress1(test.getString("Client_Vat_Number"));
		Client.setClientAddress1(test.getString("Client_Comments"));
		
		t.update(Client);
		
		
		
		return "Updated";
	}
	
	
	@Path("/DeleteClient/{Id}")
	@GET
	@Produces("text/plain")
	public String Delete( @PathParam("Id") int Id) throws Exception
	{
		
		ClientDAO Object  = new ClientDAO();
		
		Object.delete(Object.getClientInfoById(Id));
	    
		return "Successful";
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
	
	
	
	
	@Path("/GetClientInfo/{Client_Name}")
	@GET
	@Produces("text/plain")
	public String GET1(@PathParam("Client_Name") String Client_Name ) throws Exception
	{
		
		
		
		ClientDAO Object  = new ClientDAO();
		
		List<SystemClient> Client = Object.GetClientInfoByName(Client_Name);
		
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < Client.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			
			jsonObject.put("Client_Name", Client.get(i).getClientName());
			jsonObject.put("Client_Contact_Name", Client.get(i).getClientContactName());
			jsonObject.put("Client_Contact_Number", Client.get(i).getClientContactNumber());
			jsonObject.put("Client_Address_1", Client.get(i).getClientAddress1());
			jsonObject.put("Client_Address_3", Client.get(i).getClientAddress3());
			
			JsonArray.put(jsonObject);
		}
		
		
		
		
		
		
		System.out.println(JsonArray.toString());
		
		
		
		return JsonArray.toString();
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
