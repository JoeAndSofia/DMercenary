package study800_Google.maps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.mapsbooking.v1alpha.GoogleMapsBookingAPI;
import com.google.api.services.mapsbooking.v1alpha.model.Booking;

public class BookingAPITest {

//	private static String JSON_CREDS = "/home/imaginato/Desktop/Work/qraved/Topic/GoogleReservation/GoogleAccountJoeTest/My Project-c2f79ef6ac4b.json";
	private static String JSON_CREDS = "/home/imaginato/Desktop/Work/qraved/Topic/GoogleReservation/GoogleAccountQravedTest/Qraved-id/Qraved-dc8629e377cd.json";
	
//	private static String APPLICATION_NAME = "TestApp";
	private static String APPLICATION_NAME = "Qraved";
	
	private static String BOOKING_SCOPE = "https://www.googleapis.com/auth/mapsbooking";
	
	public static void main(String[] args){
		notifyBookingChange();
		
	}
	
	public static void notifyBookingChange(){
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
		}catch (IOException e) {
			System.out.println("RPC error: " + e.getMessage());
			return;
		}
	}
}
