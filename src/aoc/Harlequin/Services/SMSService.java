package aoc.Harlequin.Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import aoc.Harlequin.DAOs.ClientDAO;
import aoc.Harlequin.DAOs.MacApplicantDAO;
import aoc.Harlequin.DAOs.SmsHistoryDAO;
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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		String CurrentDate = localDate.toString();
	
		JSONObject json = new JSONObject(jsonTextObject);
		
		System.out.println(json);
		
		JSONArray TotalApplicants = json.getJSONArray("Applicants");
		JSONArray Message = json.getJSONArray("SmsMessage");
		
		JSONObject SMSMessage = new JSONObject( Message.get(0).toString());
		
		
		for (int i = 0; i < TotalApplicants.length(); i++) 
		{
			
			JSONObject Applicants = new JSONObject( TotalApplicants.get(i).toString());
			System.out.println("Cell Number:"+Applicants.getString("Cell_Number").toString()+ "Message:"+ SMSMessage.getString("Message").toString());
			
			/////Sending the sms using bulk sms
			SMSSender sms = new SMSSender(Applicants.getString("Cell_Number").toString(),SMSMessage.getString("Message").toString());
		    sms.send();
		    
		    MacApplicantDAO Object  = new MacApplicantDAO();
		    
		    
		    //Checking the Sms Group Count
		    int SmsGroupCount = Applicants.getInt("Sms_Group_Count");
		    String SmsGroup = Applicants.getString("User_Sms_Group").toString();;
		    
		    System.out.println("SMSGROUPCOUNT:" + SmsGroupCount );
		    if(SmsGroupCount < 3)
		    {
		    	SmsGroupCount = SmsGroupCount + 1;
		    	
		    	SmsGroup = Applicants.getString("Sms_Group").toString() + "," + SmsGroup ;
		    	
		    	
		    	System.out.println("SMSGROUPCOUNT2:" + SmsGroupCount );
		    	//Updating the Applicants Last Sms Date and Sms Group Code			
				Object.UpdateAppplicantLastSmsDateById(Applicants.getInt("idMac_Applicants"),SmsGroup,SmsGroupCount);
				
		    	
		    }
		    else if(SmsGroupCount >= 3)
		    {
		    	
		    	SmsGroupCount = 1;
		    	
		    	
		    	System.out.println("SMSGROUPCOUNT3:" + SmsGroupCount );
		    	//Updating the Applicants Last Sms Date and Sms Group Code			
				Object.UpdateAppplicantLastSmsDateById(Applicants.getInt("idMac_Applicants"),SmsGroup,SmsGroupCount);
				
		    }
			
			
		    //Storing the info of the sms Sent
			SmsHistoryDAO smsHistory = new SmsHistoryDAO();
			smsHistory.AddSmsHistory(Applicants.getInt("idMac_Applicants"), Applicants.getString("Cell_Number"), SMSMessage.getString("Message").toString(), "N/A", "N/A", SmsGroup,CurrentDate);
		    
		    
		 }
		
		
		
		return "Sucessful";	
		
			
	}

}
