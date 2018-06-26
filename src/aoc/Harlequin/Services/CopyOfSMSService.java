package aoc.Harlequin.Services;

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

import aoc.Harlequin.DAOs.ClientDAO;
import aoc.Harlequin.DAOs.JobDAO;
import aoc.Harlequin.DAOs.MacApplicantDAO;
import aoc.Harlequin.DAOs.PracticalDrivingAssessmentDAO;
import aoc.Harlequin.DAOs.SmsHistoryDAO;
import aoc.Harlequin.OBJs.ApplicantSmsHistory;
import aoc.Harlequin.OBJs.PracticalDriversAssessment;
import aoc.Harlequin.OBJs.SystemJob;
import aoc.Harlequin.message.SMSSender;
import aoc.Harlequin.message.VodaSms;


@Path("SMStest")
public class CopyOfSMSService 
{
	
	@Path("/sendsms")
	@GET
	@Produces("text/plain")
	public String GET( @PathParam("Id") int Id) throws Exception
	{
		
		
		VodaSms x = new VodaSms();
		
		/*System.out.println("SMS Response:"+x.getHttpResponse("https://xml2sms.gsm.co.za/send/?number=+27721234567&message=Message+Test", "maclabour", "th3unis1"));*/
		//System.out.println("SMS Response:"+x.getHttpResponse("https://xml2sms.gsm.co.za/send/?username=maclabour&password=th3unis1&number=27823353359&message=Testing%20XML2SMS", "maclabour", "th3unis1"));
		System.out.println("SMS Response:"+x.SendHttpRequest("https://xml2sms.gsm.co.za/send/?username=maclabour&password=th3unis1&number=27823353359&message=Testing%20XML2SMS"));
		
	    
		return "";
	}
	
	
	

}
