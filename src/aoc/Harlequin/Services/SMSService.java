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
		
		System.out.println(jsonTextObject);
		
		
				

		JSONObject json = new JSONObject(jsonTextObject);
		
		System.out.println(json);
		
		JSONArray TotalApplicants = json.getJSONArray("Applicants");
		JSONArray Message = json.getJSONArray("SmsMessage");
		
		JSONObject SMSMessage = new JSONObject( Message.get(0).toString());
		
		
		for (int i = 0; i < TotalApplicants.length(); i++) 
		{
			
			JSONObject Applicants = new JSONObject( TotalApplicants.get(i).toString());
			System.out.println("Cell Number:"+Applicants.getString("Cell_Number").toString()+ "Message:"+ SMSMessage.getString("Message").toString());
			
			SMSSender sms = new SMSSender(Applicants.getString("Cell_Number").toString(),SMSMessage.getString("Message").toString());
		    sms.send();
			
			
		 }
		
		
		
		return "Sucessful";	
		
			
	}

}
