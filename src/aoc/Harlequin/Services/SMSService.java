package aoc.Harlequin.Services;

import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import aoc.Harlequin.DAOs.BlockedNumbersDAO;
import aoc.Harlequin.DAOs.ClientDAO;
import aoc.Harlequin.DAOs.MacApplicantDAO;
import aoc.Harlequin.DAOs.PracticalDrivingAssessmentDAO;
import aoc.Harlequin.DAOs.SmsHistoryDAO;
import aoc.Harlequin.OBJs.ApplicantSmsHistory;
import aoc.Harlequin.OBJs.BlockedNumberList;
import aoc.Harlequin.OBJs.PracticalDriversAssessment;
import aoc.Harlequin.message.SMSSender;
import aoc.Harlequin.message.VodaSms;


@Path("SMS")
public class SMSService 
{
	
	
	
	
	@Path("/GetAllHistory")
	@GET
	@Produces("text/plain")
	public String GETAllHistory( ) throws Exception
	{
		SmsHistoryDAO smsHistoryDAO  = new SmsHistoryDAO();
		List<ApplicantSmsHistory> smsHistory = smsHistoryDAO.ReadAllSmsHistory();
		JSONArray JsonArray = new JSONArray();
		
		for(int i = 0; i < smsHistory.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("idApplicant_Sms_History", smsHistory.get(i).getIdApplicantSmsHistory());
			jsonObject.put("idMac_Applicants", smsHistory.get(i).getIdMacApplicants());
			jsonObject.put("Cell_Number", smsHistory.get(i).getCellNumber());
			jsonObject.put("Message", smsHistory.get(i).getMessage());
			jsonObject.put("Job_Name",smsHistory.get(i).getJobName());		
			jsonObject.put("Client_Name", smsHistory.get(i).getClientName());
			jsonObject.put("Sms_Group", smsHistory.get(i).getSmsGroup());
			jsonObject.put("Sms_Date", smsHistory.get(i).getSmsDate());
			
			JsonArray.put(jsonObject);
		}
		
		return JsonArray.toString();
	}
	
	@Path("/DeleteGroup/{GroupCode}")
	@GET
	@Produces("text/plain")
	public String GETdelete( @PathParam("GroupCode") String GroupCode) throws Exception
	{
		
		SmsHistoryDAO smsHistoryDAO  = new SmsHistoryDAO();
		List<ApplicantSmsHistory> SmsGroups = smsHistoryDAO.ReadGroupHistory(GroupCode);
		
		for(int i = 0; i < SmsGroups.size();i++)
		{
			smsHistoryDAO.delete(SmsGroups.get(i));
		}
	    
		return "Deleted";
	}
	
	@Path("/GetAllGroups")
	@GET
	@Produces("text/plain")
	public String GETAllAssessments( ) throws Exception
	{
		
		SmsHistoryDAO smsHistoryDao  = new SmsHistoryDAO();
		List<ApplicantSmsHistory> SmsGroups = smsHistoryDao.ReadSMSGroups();
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < SmsGroups.size();i++)
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("Sms_Group", SmsGroups.get(i));
			jsonArray.put(jsonObject);
		}
		
		return jsonArray.toString();
	}
	
	
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
		
	
		JSONArray TotalApplicants = json.getJSONArray("Applicants");
		JSONArray Message = json.getJSONArray("SmsMessage");
		
		JSONObject SMSMessage = new JSONObject( Message.get(0).toString());
		
		VodaSms x = new VodaSms();
		for (int i = 0; i < TotalApplicants.length(); i++) 
		{
			
			JSONObject Applicants = new JSONObject( TotalApplicants.get(i).toString());
		
			//Adding country code +27 to beginning of every cell number and removing first 0
			String cell_Number = Applicants.getString("Cell_Number").toString();
			cell_Number = cell_Number.replaceFirst("0", "+27");
			/////Sending the sms using bulk sms
    		//SMSSender sms = new SMSSender(cell_Number,SMSMessage.getString("Message").toString());
     	    //sms.send();
			try 
		    {	
				//System.out.println(x.SendHttpRequest("https://xml2sms.gsm.co.za/send/?username=maclabour&password=th3unis1&number="+cell_Number+"&message="+ URLEncoder.encode(SMSMessage.getString("Message").toString(), "UTF-8") +"&ems=1"));
				
				
				    BlockedNumbersDAO Object  = new BlockedNumbersDAO();
					
					List<BlockedNumberList> BlockedNumbers = Object.ReadAllBlockedNumbers();
					
					
					boolean isBlocked = false;
					
					for(int j = 0; j < BlockedNumbers.size();j++)
					{
						if(BlockedNumbers.get(j).getCellNumber().trim().replaceFirst("0", "+27").equals(cell_Number.trim()))
						{
							System.out.println("Blocked Number:"+ BlockedNumbers.get(i).getCellNumber().trim().replaceFirst("0", "+27")+", SmsCellNumber:"+ cell_Number.trim() );
							isBlocked = true;
						}	
						
						
					}
					
					if(!isBlocked)
					{
						
						System.out.println(x.SendHttpRequest("https://xml2sms.gsm.co.za/send/?username=maclabour&password=th3unis1&number="+cell_Number+"&message="+ URLEncoder.encode(SMSMessage.getString("Message").toString(), "UTF-8") +"&ems=1"));
						
					}
					
					
				
			} catch (Exception e) 
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		    MacApplicantDAO Object  = new MacApplicantDAO();
		    
		    
		    //Checking the Sms Group Count
		    int SmsGroupCount = Applicants.getInt("Sms_Group_Count");
		    String SmsGroup = Applicants.getString("User_Sms_Group").toString();
		    String HistorySmsGroup = Applicants.getString("User_Sms_Group").toString();
		    
		    
		    if(SmsGroupCount < 3)
		    {
		    	SmsGroupCount = SmsGroupCount + 1;
		    	
		    	SmsGroup = Applicants.getString("Sms_Group").toString() + " ," + SmsGroup ;
		    	
		    	//Updating the Applicants Last Sms Date and Sms Group Code			
				Object.UpdateAppplicantLastSmsDateById(Applicants.getInt("idMac_Applicants"),SmsGroup,SmsGroupCount);
				
		    	
		    }
		    else if(SmsGroupCount >= 3)
		    {
		    	
		    	SmsGroupCount = 1;
		    	
		    	
		    	//Updating the Applicants Last Sms Date and Sms Group Code			
				Object.UpdateAppplicantLastSmsDateById(Applicants.getInt("idMac_Applicants"),SmsGroup,SmsGroupCount);
				
		    }
			
			
		    //Storing the info of the sms Sent
			SmsHistoryDAO smsHistory = new SmsHistoryDAO();
			smsHistory.AddSmsHistory(Applicants.getInt("idMac_Applicants"), Applicants.getString("Cell_Number"), SMSMessage.getString("Message").toString(), "N/A", "N/A", HistorySmsGroup,CurrentDate);
		    
		    
		 }
		
		
		
		return "Sucessful";	
		
			
	}

}
