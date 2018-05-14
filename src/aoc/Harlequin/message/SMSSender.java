package aoc.Harlequin.message;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SMSSender
{
	String message;

	String number;

	public SMSSender(String number, String message)
	{
		this.number = number;
		this.message = message;
	}
	
	public void sendx()
	{
		
	}
	
	public void send()
	{
		URLConnection conn = null;

		try
		{
			// Construct data
			String data = "";
			/*
			 * Note the suggested encoding for certain parameters, notably the
			 * username, password and especially the message. ISO-8859-1 is
			 * essentially the character set that we use for message bodies,
			 * with a few exceptions for e.g. Greek characters. For a full list,
			 * see:
			 * http://developer.bulksms.com/eapi/submission/character-encoding/
			 */
			data += "username=" + URLEncoder.encode("aocbc", "ISO-8859-1");
			data += "&password=" + URLEncoder.encode("xxxxx1000", "ISO-8859-1");
			data += "&message=" + URLEncoder.encode(message, "ISO-8859-1");
			data += "&allow_concat_text_sms=1";
			data += "&concat_text_sms_max_parts=20";
			data += "&want_report=1";
			data += "&msisdn=" + number;

			System.out.println("\n\n\n" + data + "\n\n\n");

			// Send data
			// Please see the FAQ regarding HTTPS (port 443) and HTTP (port
			// 80/5567)
			URL url = new URL("http://bulksms.2way.co.za/eapi/submission/send_sms/2/2.0");

			conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();

			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null)
			{
				// Print the response output...
				System.out.println(line);
			}
			wr.close();
			rd.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			// close
		}
	}
	
	static public String stringToHex(String s)
	{
		char[] chars = s.toCharArray();
		String next;
		StringBuffer output = new StringBuffer();
		for (int i = 0; i < chars.length; i++)
		{
			next = Integer.toHexString((int) chars[i]);
			// Unfortunately, toHexString doesn't pad with zeroes, so we have
			// to.
			for (int j = 0; j < (4 - next.length()); j++)
			{
				output.append("0");
			}
			output.append(next);
		}
		return output.toString();
	}
}
