package aoc.Harlequin.message;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

//import org.apache.tomcat.util.codec.binary.Base64;

public class VodaSms {
	
	public void send()
	{
		
	}
	
	/*public String getHttpResponse(String address, String username, String password) throws Exception {
		  URL url = new URL(address);
		  URLConnection conn = url.openConnection();
		  conn.setConnectTimeout(30000); // 30 seconds time out
		 
		  if (username != null && password != null){
		    String user_pass = username + ":" + password;
		    String encoded = Base64.encodeBase64String( user_pass.getBytes() );
		    conn.setRequestProperty("Authorization", "Basic " + encoded);
		  }
		 
		  String line = "";
		  StringBuffer sb = new StringBuffer();
		  BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()) );
		  while((line = input.readLine()) != null)
		    sb.append(line);
		  input.close();
		  return sb.toString();
		}
	*/
	
	public String SendHttpRequest(String urlToRead) throws Exception 
	{
	      StringBuilder result = new StringBuilder();
	      URL url = new URL(urlToRead);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         result.append(line);
	      }
	      rd.close();
	      return result.toString();
			//return urlToRead;
	   }


}
