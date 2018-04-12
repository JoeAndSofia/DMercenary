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
import com.google.api.services.mapsbooking.v1alpha.model.Availability;
import com.google.api.services.mapsbooking.v1alpha.model.BatchReplaceServiceAvailabilityRequest;
import com.google.api.services.mapsbooking.v1alpha.model.BatchReplaceServiceAvailabilityResponse;
import com.google.api.services.mapsbooking.v1alpha.model.Empty;
import com.google.api.services.mapsbooking.v1alpha.model.ExtendedServiceAvailability;
import com.google.api.services.mapsbooking.v1alpha.model.GeoCoordinates;
import com.google.api.services.mapsbooking.v1alpha.model.Merchant;
import com.google.api.services.mapsbooking.v1alpha.model.PostalAddress;
import com.google.api.services.mapsbooking.v1alpha.model.ReplaceServiceAvailabilityRequest;
import com.google.api.services.mapsbooking.v1alpha.model.Service;
import com.google.api.services.mapsbooking.v1alpha.model.ServiceAvailability;
import com.google.api.services.mapsbooking.v1alpha.model.TaxRate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Java client example using the Inventory Update API to provide real-time updates for invenotry
 * changes
 */
public class InventoryUpdate {
	private static final String MAPS_BOOKING_SCOPE = "https://www.googleapis.com/auth/mapsbooking";
	private static HttpTransport httpTransport;
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static GoogleMapsBookingAPI googleMapsBookingAPI;
	// TODO(partner): step1. put your partner_id here
	private static final String PARTNER_ID = "{your partner_id}";
	public static void main(String[] args) {
		try {
			try {
				// get Credential via your Service Account
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
				.setApplicationName("PartnerInventoryUpdateExample")
				.build();
				// TODO(partner): step12. call the methods you implement below to make inventory updates
				createMerchant();
				createService();
				updateMerchant();
				updateService();
				updateAvailability();
				batchUpdateAvailability();
				deleteService();
				deleteMerchant();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		} catch (Throwable t) {
			t.printStackTrace();
		}
		System.exit(1);
	}
	// TODO(partner): step4. implement this method with your data to make the createMerchant call
	public static void createMerchant() throws IOException {
		// for example
		PostalAddress postalAddress = new PostalAddress()
			.setAddressCountry("US")
			.setAddressLocality("WA")
			.setAddressRegion("Kirkland")
			.setPostalCode("98XXX")
		.setStreetAddress("1111 11th Ave NE");
		GeoCoordinates geo = new GeoCoordinates()
			.setLatitude(47.67)
			.setLongitude(-122.21)
			.setAddress(postalAddress);
		TaxRate taxRate = new TaxRate().setMicroPercent(0);
		String merchantId = "sampleMerchant1";
		Merchant merchant = new Merchant()
			.setName("partners/" + PARTNER_ID + "/merchants/" + merchantId)
			.setMerchantName("Test Create Merchant")
			.setTelephone("206-888-8888")
			.setUrl("www.****.com")
			.setGeo(geo)
			.setCategory("Fitness")
			.setNumBookings30d((long)1000.00)
			.setTaxRate(taxRate);
		Merchant CreatedMerchant = createMerchant(merchant);
		System.out.println("created merchant:");
		System.out.println(CreatedMerchant);
	}
	// TODO(partner): step5. implement this method with your data to make the updateMerchant call
	public static void updateMerchant() throws IOException {
		// for example
		PostalAddress postalAddress = new PostalAddress()
			.setAddressCountry("US")
			.setAddressLocality("WA")
			.setAddressRegion("Kirkland")
			.setPostalCode("98XXX")
			.setStreetAddress("1111 11th Ave NE");
		GeoCoordinates geo = new GeoCoordinates()
			.setLatitude(47.67)
			.setLongitude(-122.21)
			.setAddress(postalAddress);
		TaxRate taxRate = new TaxRate().setMicroPercent(0);
		String merchantId = "sampleMerchant1";
		Merchant merchantUpdate = new Merchant()
			.setName("partners/" + PARTNER_ID + "/merchants/" + merchantId)
			.setMerchantName("Test Update Merchant")
			.setTelephone("206-666-6666")
			.setUrl("www.****.com")
			.setGeo(geo)
			.setCategory("Fitness")
			.setNumBookings30d((long)1000.00)
			.setTaxRate(taxRate);
		Merchant updatedMerchant =
				updateMerchant(merchantUpdate, "merchantName,telephone");
		System.out.println("updated merchant:");
		System.out.println(updatedMerchant);
	}
	// TODO(partner): step6. implement this method with your data to make the deleteMerchant call
	public static void deleteMerchant() throws IOException {
		// for example
		String merchantId = "sampleMerchant1";
		Empty deletedMerchant = deleteMerchant(merchantId);
		System.out.println("deleted merchant:");
		System.out.println(deletedMerchant);
	}
	// TODO(partner): step7. implement this method with your data to make the createService call
	public static void createService() throws IOException {
		//for example
		String merchantId = "sampleMerchant1";
		String serviceId = "sampleService1";
		Service service = new Service()
			.setName("partners/" + PARTNER_ID + "/merchants/" + merchantId + "/services/" + serviceId)
			.setServiceName("Yoga 101")
			.setDescription("The entry-level Yoga course");
		Service CreatedService = createService(service);
		System.out.println("created service:");
		System.out.println(CreatedService);
	}
	// TODO(partner): step8. implement this method with your data to make the updateService call
	public static void updateService() throws IOException {
		//for example
		String merchantId = "sampleMerchant1";
		String serviceId = "sampleService1";
		Service service = new Service()
			.setName("partners/" + PARTNER_ID + "/merchants/" + merchantId + "/services/" + serviceId)
			.setServiceName("Yoga 201")
			.setDescription("The mid-level Yoga course");
		Service updatedService = updateService(service, "");
		System.out.println("updated service:");
		System.out.println(updatedService);
	}
	// TODO(partner): step9. implement this method with your data to make the deleteService call
	public static void deleteService() throws IOException {
		// for example
		String merchantId = "sampleMerchant1";
		String serviceId = "sampleService1";
		Empty deletedService = deleteService(merchantId, serviceId);
		System.out.println("deleted service:");
		System.out.println(deletedService);
	}
	// TODO(partner): step10. implement this method with your data to make the
	// replaceServiceAvailability call
	public static void updateAvailability() throws IOException {
		// for example
		String merchantId = "sampleMerchant1";
		String serviceId = "sampleService1";
		Availability availability1 = new Availability()
			.setStartTime("2018-01-02T09:00:00Z")
			.setDuration("3600s")
			.setSpotsTotal((long) 30)
			.setSpotsOpen((long) 20);
		Availability availability2 = new Availability()
			.setStartTime("2018-01-02T13:00:00Z")
			.setDuration("3600s")
			.setSpotsTotal((long) 30)
			.setSpotsOpen((long) 25);
		List<Availability> availabilities1 = new ArrayList<Availability>();
		availabilities1.add(availability1);
		availabilities1.add(availability2);
		ServiceAvailability serviceAvailability = new ServiceAvailability()
			.setName("partners/" + PARTNER_ID + "/merchants/" + merchantId + "/services/" + serviceId)
			.setAvailability(availabilities1)
			.setStartTimeRestrict("2018-01-02T00:00:00Z")
			.setEndTimeRestrict("2018-01-02T23:30:00Z");
		ServiceAvailability updatedAvailability = replaceServiceAvailability(serviceAvailability);
		System.out.println("updated availability:");
		System.out.println(updatedAvailability);
	}
	// TODO(partner): step11. implement this method with your data to make the
	// batchReplaceServiceAvailability call
	public static void batchUpdateAvailability() throws IOException {
		// for example
		String merchantId1 = "sampleMerchant1";
		String merchantId2 = "sampleMerchant2";
		String serviceId1 = "sampleService1";
		String serviceId2 = "sampleService2";
		List<Availability> availabilities1 = new ArrayList<Availability>();// {your first batch of availabilities};
		List<Availability> availabilities2 = new ArrayList<Availability>();// {your second batch of availabilities};
		ExtendedServiceAvailability extendedServiceAvailability1 = new ExtendedServiceAvailability()
			.setMerchantId(merchantId1)
			.setServiceId(serviceId1)
			.setAvailability(availabilities1)
			.setStartTimeRestrict("2018-01-02T00:00:00Z")
			.setEndTimeRestrict("2018-01-03T23:30:00Z");
		ExtendedServiceAvailability extendedServiceAvailability2 = new ExtendedServiceAvailability()
			.setMerchantId(merchantId2)
			.setServiceId(serviceId2)
			.setAvailability(availabilities2)
			.setStartTimeRestrict("2018-01-02T00:00:00Z");
		List<ExtendedServiceAvailability> extendedServiceAvailabilities = new ArrayList<ExtendedServiceAvailability>();
		extendedServiceAvailabilities.add(extendedServiceAvailability1);
		extendedServiceAvailabilities.add(extendedServiceAvailability2);
		BatchReplaceServiceAvailabilityResponse batchUpdatedAvailability =
				batchReplaceServiceAvailability(extendedServiceAvailabilities);
		System.out.println("batch updated availabilities:");
		System.out.println(batchUpdatedAvailability);
	}
	/**
	 * Creates a new Merchant managed by the specified partner, and returns it.
	 *
	 * @param content The merchant object to create.
	 * @return the newly created instance of Merchant.
	 */
	private static Merchant createMerchant(Merchant content) throws IOException {
		String merchantId = content.getName().split("/")[3];
		String parent = "partners/" + PARTNER_ID;
		return googleMapsBookingAPI
			.inventory()
			.partners()
			.merchants()
			.create(parent, content)
			.setMerchantId(merchantId)
			.execute();
	}
	/**
	 * Deletes an existing Merchant managed by the specified partner. All the merchant's services and
	 * availability will be disabled.
	 *
	 * @param merchantId The merchant_id of the merchant to delete.
	 * @return the empty object.
	 */
	private static Empty deleteMerchant(String merchantId) throws IOException {
		String name = "partners/" + PARTNER_ID + "/merchants/" + merchantId;
		return googleMapsBookingAPI.inventory().partners().merchants().delete(name).execute();
	}
	/**
	 * Updates an existing Merchant managed by the specified partner, and returns it.
	 *
	 * @param content The merchant object contains the updated merchant content. @Param updateMask The
	 *     specific fields to update for the merchant.
	 * @return the updated instance of Merchant.
	 */
	private static Merchant updateMerchant(Merchant content, String updateMask) throws IOException {
		String name = content.getName();
		return googleMapsBookingAPI
			.inventory()
			.partners()
			.merchants()
			.patch(name, content)
			.setUpdateMask(updateMask)
			.execute();
	}
	/**
	 * Creates a new Service of a merchant managed by the specified partner, and returns it.
	 *
	 * @param content The service object to create.
	 * @return the newly created instance of Service.
	 */
	private static Service createService(Service content) throws IOException {
		String[] name = content.getName().split("/");
		String merchantId = name[3];
		String serviceId = name[5];
		String parent = "partners/" + PARTNER_ID + "/merchants/" + merchantId;
		return googleMapsBookingAPI
			.inventory()
			.partners()
			.merchants()
			.services()
			.create(parent, content)
			.setServiceId(serviceId)
			.execute();
	}
	/**
	 * Deletes an existing Service of a merchant managed by the specified partner. All the service's
	 * availablity will be disabled.
	 *
	 * @param merchantId The merchant_id of the merchant who provides the to be deleted service.
	 * @param serviceId The service_id of the service to delete.
	 * @return the empty object.
	 */
	private static Empty deleteService(String merchantId, String serviceId) throws IOException {
		String name = "partners/" + PARTNER_ID + "/merchants/" + merchantId + "/services/" + serviceId;
		return googleMapsBookingAPI
				.inventory()
				.partners()
				.merchants()
				.services()
				.delete(name)
				.execute();
	}
	/**
	 * Updates an existing Service of a merchant managed by the specified partner, and returns it.
	 *
	 * @param content The service object contains the updated service content. @Param updateMask The
	 *     specific fields to update for the service.
	 * @return the updated instance of Service.
	 */
	private static Service updateService(Service content, String updateMask) throws IOException {
		String name = content.getName();
		return googleMapsBookingAPI
				.inventory()
				.partners()
				.merchants()
				.services()
				.patch(name, content)
				.setUpdateMask(updateMask)
				.execute();
	}
	/**
	 * Replaces the Availability of an existing Service of a merchant managed by the specified
	 * partner, and returns it.
	 *
	 * @param serviceAvailability The service availability that is used to replace the existing ones.
	 * @return the successfully updated ServiceAvailability.
	 */
	private static ServiceAvailability replaceServiceAvailability(
			ServiceAvailability serviceAvailability) throws IOException {
		String name = serviceAvailability.getName();
		ReplaceServiceAvailabilityRequest replaceServiceAvailabilityRequest =
				new ReplaceServiceAvailabilityRequest().setServiceAvailability(serviceAvailability);
		return googleMapsBookingAPI
				.inventory()
				.partners()
				.merchants()
				.services()
				.availability()
				.replace(name, replaceServiceAvailabilityRequest)
				.execute();
	}
	/**
	 * Replaces the Availability of existing Services. This batch call does not guarantee atomicity.
	 * Only successfully updated availability slots will be returned.
	 *
	 * @param extendedServiceAvailabilities The list of extended service availability that is used to
	 *     replace the existing availability slots.
	 * @return response containing successfully updated availability slots.
	 */
	private static BatchReplaceServiceAvailabilityResponse batchReplaceServiceAvailability(
			List<ExtendedServiceAvailability> extendedServiceAvailabilities) throws IOException {
		String parent = "partners/" + PARTNER_ID;
		BatchReplaceServiceAvailabilityRequest batchReplaceServiceAvailabilityRequest =
				new BatchReplaceServiceAvailabilityRequest()
		.setExtendedServiceAvailability(extendedServiceAvailabilities);
		return googleMapsBookingAPI
				.inventory()
				.partners()
				.availability()
				.replace(parent, batchReplaceServiceAvailabilityRequest)
				.execute();
	}
}