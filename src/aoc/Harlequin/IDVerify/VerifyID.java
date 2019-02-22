package aoc.Harlequin.IDVerify;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;



import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class VerifyID {
	
	public static String sendReq(String IDNumber)
	{
		String ResponseFromService ="";
		HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://www.verifyid.co.za/webservice/said_verification");

        // Create some NameValuePair for HttpPost parameters
        List<NameValuePair> arguments = new ArrayList<>(3);
        arguments.add(new BasicNameValuePair("id_number", IDNumber));
        //arguments.add(new BasicNameValuePair("api_key", "9ba8c0fe88e24f0e6493bfe248cd35f52a5a9421")); //AOC Account
        arguments.add(new BasicNameValuePair("api_key", "2a1a2a497a92974eef4ec48cbf8faaf13c513e87")); // MacLabour Account
        

        try {
            post.setEntity(new UrlEncodedFormEntity(arguments));
            HttpResponse response = client.execute(post);

            // Print out the response message
            ResponseFromService= EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
		return ResponseFromService;
		
	  }
	
	
	
	public static void main(String[] args) {
		
        System.out.println(sendReq("9112135069080"));
    }

}
