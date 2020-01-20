package aoc.Harlequin.Services;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import aoc.Harlequin.OBJs.SystemClient;

@Path("Client")
public class ClientService {
	
	@Path("/GetClientbyid/{idClient}")
	@GET
	@Produces("text/plain")
	public String GET(@PathParam("idClient") int idClient ) throws Exception
	{
		
		ClientDAO clientDao  = new ClientDAO();
		SystemClient client  = clientDao.getClientInfoById(idClient);
		JSONObject jsonObject = new JSONObject();
		
		jsonObject.put("idClient", client.getIdClient());
		jsonObject.put("Client_Name", client.getClientName());
		jsonObject.put("Client_E_Mail", client.getClientEMail());
		jsonObject.put("Client_Contact_Name", client.getClientContactName());
		jsonObject.put("Client_Contact_Number", client.getClientContactNumber());		
		jsonObject.put("Client_Address_1", client.getClientAddress1());
		jsonObject.put("Client_Address_2", client.getClientAddress2());
		jsonObject.put("Client_Address_3", client.getClientAddress3());
		jsonObject.put("Client_Address_4", client.getClientAddress4());
		jsonObject.put("Client_Vat_Number", client.getClientVatNumber());
		jsonObject.put("Client_Comments", client.getClientComments());
		jsonObject.put("Last_Used_Date", client.getLastUsedDate());

		return jsonObject.toString();
	}
	
	@Path("/UpdateClientInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String update(String jsonTextObject) throws JSONException
	{
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		ClientDAO clientDao = new ClientDAO();
		JSONObject jsonObject = new JSONObject(jsonTextObject);

		SystemClient client  = clientDao.getClientInfoById(jsonObject.getInt("idClient"));

		client.setClientName(jsonObject.getString("Client_Name"));
		client.setClientEMail(jsonObject.getString("Client_E_Mail"));
		client.setClientContactNumber(jsonObject.getString("Client_Contact_Number"));
		client.setClientContactName(jsonObject.getString("Client_Contact_Name"));
		client.setClientAddress1(jsonObject.getString("Client_Address_1"));
		client.setClientAddress2(jsonObject.getString("Client_Address_2"));
		client.setClientAddress3(jsonObject.getString("Client_Address_3"));
		client.setClientAddress4(jsonObject.getString("Client_Address_4"));
		client.setClientVatNumber(jsonObject.getString("Client_Vat_Number"));
		client.setClientComments(jsonObject.getString("Client_Comments"));
		client.setLastUsedDate(dateFormat.format(date));
		
		clientDao.update(client);
			
		return "Updated";
	}
	
	
	@Path("/DeleteClient/{id}")
	@GET
	@Produces("text/plain")
	public String Delete( @PathParam("id") int id) throws Exception
	{
		
		ClientDAO clientDao  = new ClientDAO();
		
		clientDao.delete(clientDao.getClientInfoById(id));
	    
		return "Successful";
	}
	
	
	@Path("/GetAllClients")
	@GET
	@Produces("text/plain")
	public String GETClients( ) throws Exception
	{
		
		ClientDAO clientDao  = new ClientDAO();
		List<SystemClient> clients = clientDao.ReadAllClients();
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < clients.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("idClient", clients.get(i).getIdClient());
			jsonObject.put("Client_Name", clients.get(i).getClientName());
			jsonObject.put("Client_E_Mail", clients.get(i).getClientEMail());
			jsonObject.put("Client_Contact_Name", clients.get(i).getClientContactName());
			jsonObject.put("Client_Contact_Number", clients.get(i).getClientContactNumber());		
			jsonObject.put("Client_Address_1", clients.get(i).getClientAddress1());
			jsonObject.put("Client_Address_2", clients.get(i).getClientAddress2());
			jsonObject.put("Client_Address_3", clients.get(i).getClientAddress3());
			jsonObject.put("Client_Address_4", clients.get(i).getClientAddress4());
			jsonObject.put("Client_Vat_Number", clients.get(i).getClientVatNumber());
			jsonObject.put("Client_Comments", clients.get(i).getClientComments());
			jsonObject.put("Last_Used_Date", clients.get(i).getLastUsedDate());
			
			jsonArray.put(jsonObject);
		}
		
   
		return jsonArray.toString();
	}
	
	
	
	
	@Path("/GetClientInfo/{client_Name}")
	@GET
	@Produces("text/plain")
	public String GET1(@PathParam("client_Name") String clientName ) throws Exception
	{	
		ClientDAO clientDao  = new ClientDAO();
		List<SystemClient> client = clientDao.GetClientInfoByName(clientName);
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < client.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Client_Name", client.get(i).getClientName());
			jsonObject.put("Client_Contact_Name", client.get(i).getClientContactName());
			jsonObject.put("Client_Contact_Number", client.get(i).getClientContactNumber());
			jsonObject.put("Client_Address_1", client.get(i).getClientAddress1());
			jsonObject.put("Client_Address_3", client.get(i).getClientAddress3());
			jsonObject.put("Last_Used_Date", client.get(i).getLastUsedDate());
			
			jsonArray.put(jsonObject);
		}
		

		return jsonArray.toString();
	}
	
	
	@Path("/SaveClientInfo")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{

		JSONObject jsonObject = new JSONObject(jsonTextObject);	
	
		ClientDAO clientDao  = new ClientDAO();
		clientDao.AddClientInformation(jsonObject.getString("Client_Name"), jsonObject.getString("Client_E_Mail"), jsonObject.getString("Client_Contact_Name"), jsonObject.getString("Client_Contact_Number"), jsonObject.getString("Client_Address_1"), jsonObject.getString("Client_Address_2"), jsonObject.getString("Client_Address_3"), jsonObject.getString("Client_Address_4"), jsonObject.getString("Client_Vat_Number"), jsonObject.getString("Client_Comments"));
		return "Sucessful";	
		
			
	}
	
	
	

}
