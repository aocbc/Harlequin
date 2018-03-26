package aoc.Harlequin.Services;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import aoc.Harlequin.DAOs.ClientDAO;
import aoc.Harlequin.message.SMSSender;


@Path("SMS")
public class SMSService 
{
	
	@Path("/SendSms")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces("text/plain")
	public  String create(String jsonTextObject) throws JSONException
	{
		
		
		
		JSONObject json = new JSONObject(jsonTextObject);
		JSONArray Applicants = new JSONArray(json.getJSONArray("Applicants").toString());
		JSONArray Message = new JSONArray(json.getJSONArray("SmsMessage").toString());
		
		
		//System.out.println(Applicants.toString());
		
		
		
		for (int i = 0; i < Applicants.length(); i++) {
		    JSONObject jsonobject1 = Applicants.getJSONObject(i);
		    JSONObject jsonobject2 = Message.getJSONObject(0);
		    String sMessage = jsonobject2.getString("Message");
		    sMessage = sMessage.substring(0, 156);
		    System.out.println("Applicant: "+jsonobject1.getString("Name")+ ", Number:"+jsonobject1.getString("Cell_Number")+", Message:" + sMessage);
		    SMSSender sms = new SMSSender(jsonobject1.getString("Cell_Number"),sMessage);
		    sms.send();
		}
		
		
		
		return "Sucessful";	
		
			
	}

}
