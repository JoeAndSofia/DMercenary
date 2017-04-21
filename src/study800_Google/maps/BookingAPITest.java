package study800_Google.maps;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.groovy.GJson;
import net.sf.json.groovy.JsonSlurper;
import basic.Basic;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.mapsbooking.v1alpha.GoogleMapsBookingAPI;
import com.google.api.services.mapsbooking.v1alpha.model.Booking;

public class BookingAPITest extends Basic{

//	private static String JSON_CREDS = "/home/imaginato/Desktop/Work/qraved/Topic/GoogleReservation/GoogleAccountJoeTest/My Project-c2f79ef6ac4b.json";
	private static String JSON_CREDS = "/home/imaginato/Desktop/Work/qraved/Topic/2017-GoogleReservation/GoogleAccountQravedTest/Qraved-id/Qraved-dc8629e377cd.json";
	
//	private static String APPLICATION_NAME = "TestApp";
	private static String APPLICATION_NAME = "Qraved";
	
	private static String BOOKING_SCOPE = "https://www.googleapis.com/auth/mapsbooking";
	
	public static void main(String[] args){
		try{
//			notifyBookingChange01();
			Map updateMask = new HashMap();
			updateMask.put("status", BookingStatus.PENDING_CLIENT_CONFIRMATION);
			notifyBookingChange02("123456",updateMask);
//			testEnum();			
		}catch(Exception e){
//			StackTraceElement[] steArr = e.getStackTrace();
//			for(StackTraceElement ste : steArr){
//				pl(ste);
//			}
			e.printStackTrace();
		}

		
	}
	
	public static void notifyBookingChange01() throws Exception{
		GoogleCredential credential;
		try{
			credential = GoogleCredential
					.fromStream(new FileInputStream(JSON_CREDS))
					.createScoped(Collections.singleton(BOOKING_SCOPE));
		}catch(FileNotFoundException e){
			System.out.println(String.format("Could not locate credentials [%s] : $s", JSON_CREDS, e.getMessage()));
			return;
		}catch(IOException e){
			System.out.println(String.format("Could not read credentials [%s] : %s", JSON_CREDS, e.getMessage()));
			return;
		}
		
		GoogleMapsBookingAPI stub;
		try {
	    	stub = new GoogleMapsBookingAPI.Builder(GoogleNetHttpTransport.newTrustedTransport(), new JacksonFactory(), credential)
	    	.setApplicationName(APPLICATION_NAME)
	    	.build();
		} catch (GeneralSecurityException | IOException e) {
			System.out.println("Error: " + e.getMessage());
			return;
		}
		Booking booking = new Booking();
		try {
			// Example call
			Booking b = stub.notification()
			.partners()
			.bookings()
			.patch("partners/123456/bookings/123456", booking)
			.execute();
			
			pl(b);
		}catch (IOException e) {
			System.out.println("RPC error: " + e.getMessage());
			return;
		}
	}
	
	public static void notifyBookingChange02(String bookingId, Map<String, String> updateMask) throws Exception{
		String partnerId = "10000020";
		String apiPath = "https://mapsbooking.googleapis.com/v1alpha/notification";
//		String apiPath = "https://mapsbooking.googleapis.com";
		
		if(updateMask.size()>0){
			StringBuffer requestUrl = new StringBuffer()
			.append(apiPath)
			.append("/partners/")
			.append(partnerId)
			.append("/bookings/")
			.append(bookingId)
			.append("?updateMask=");
			for(Map.Entry<String, String> property : updateMask.entrySet()){
				requestUrl.append(property.getKey()+",");
			}
			requestUrl.setLength(requestUrl.length()-1);
			
			HttpURLConnection con = getHttpURLConnection(requestUrl.toString(), "POST", true, true);
			con.setRequestProperty("x-http-method-override", "PATCH");
			con.setRequestProperty("Content-Type",  "application/json");
			String updateMaskStr = JSONObject.fromObject(updateMask).toString();
			pl(updateMaskStr);
			con.setRequestProperty("Content-Length", updateMaskStr.getBytes().length+"");
			con.setRequestProperty("connection", "Keep-Alive");
			con.connect();
			
			
			OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream());
			osw.write(updateMaskStr);
			osw.flush();
			osw.close();
			
			JSON result = receiveDataInJson(con);
			pl(result.toString());
		}

		
		
	}
	
	
	public static void testEnum() throws Exception{
		pl(BookingStatus.BOOKING_STATUS_UNSPECIFIED.toString());
	}
	
	
	public static HttpURLConnection getHttpURLConnection(String requestUrl, String requestMethod, boolean doOutput, boolean doInput) throws Exception{
		pl(requestUrl);
		URL httpUrl = new URL(requestUrl);
		HttpURLConnection httpCon = (HttpURLConnection)httpUrl.openConnection();
		httpCon.setRequestMethod(requestMethod);
		httpCon.setDoOutput(doOutput);
		httpCon.setDoInput(doInput);
		return httpCon;
	}
	
	public static JSON receiveDataInJson(HttpURLConnection con) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuffer responseSb = new StringBuffer();
		String line = null;
		while((line = br.readLine())!=null){
			responseSb.append(line);
		}
		JsonSlurper converter = new JsonSlurper();
		String responseStr = responseSb.toString();
		pl(responseStr);
		JSON result = converter.parseText(responseStr);
		return result;
	}
}
