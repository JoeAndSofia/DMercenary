package study_Google.maps;

/*
 * Copyright 2018, Google Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.mapsbooking.v1alpha.GoogleMapsBookingAPI;
import com.google.api.services.mapsbooking.v1alpha.model.Booking;
import com.google.api.services.mapsbooking.v1alpha.model.ClientInformation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
/**
 * Java client example using the Booking Notification API to notify Google of changes to an existing
 * booking
 */
public class BookingNotification {
	private static final String MAPS_BOOKING_SCOPE = "https://www.googleapis.com/auth/mapsbooking";
	private static HttpTransport httpTransport;
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static GoogleMapsBookingAPI googleMapsBookingAPI;
	// TODO(partner): step1. put your partner_id here
	private static final String PARTNER_ID = "{your partner_id}";
	public static void main(String[] args) {
		try {
			try {
				// get Credential through your Service Account
				// TODO(partner): step2. put the path&file of your private key (JSON format) that you
				// obtained from your service account into 'FileInputStream'
				GoogleCredential credential =
						GoogleCredential.fromStream(new FileInputStream("src/your-private-key.json"))
						.createScoped(Collections.singleton(MAPS_BOOKING_SCOPE));
				// get the service object to make requests to the API service
				httpTransport = GoogleNetHttpTransport.newTrustedTransport();
				// TODO(partner): step3. put your application name into 'setApplicationName'
				googleMapsBookingAPI =
						new GoogleMapsBookingAPI.Builder(httpTransport, JSON_FACTORY, credential)
				.setApplicationName("PartnerBookingNotificationExample")
				.build();
				// TODO(partner): step5. call the methods you implement below to make
				// booking changes notificatons
				updateBooking();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.exit(1);
	}
	// TODO(partner): step4. implement this method with your data to make the updateBooking call
	public static void updateBooking() throws IOException {
		// example -> cancel a booking:
		Booking updatedBooking = new Booking()
		.setName("partners/" + PARTNER_ID + "/bookings/" + "{your booking id}")
		.setMerchantId("{your merchant Id}")
		.setServiceId("{your service Id}")
		.setStatus("CANCELED")
		.setStartTime("2018-01-02T10:00:00Z")
		.setDuration("3600s")
		.setClientInformation(new ClientInformation());	//TODO	optional, client information
		Booking testUpdatedBooking = updateBooking(updatedBooking, "status");
		System.out.println("updated booking:");
		System.out.println(testUpdatedBooking);
	}
	/**
	 * Updates an existing Booking.
	 *
	 * @param content The booking object contains the updated booking content. @Param updateMask The
	 *     specific fields to update for the booking.
	 * @return the updated instance of Booking.
	 */
	private static Booking updateBooking(Booking content, String updateMask) throws IOException {
		String name = content.getName();
		return googleMapsBookingAPI
				.notification()
				.partners()
				.bookings()
				.patch(name, content)
				.setUpdateMask(updateMask)
				.execute();
	}
}