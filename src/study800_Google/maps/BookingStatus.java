package study800_Google.maps;

public enum BookingStatus {
    
    /**
     * Not specified.
     */
    BOOKING_STATUS_UNSPECIFIED,
    
    /**
     * Booking has been confirmed
     */
    CONFIRMED,
    
    /**
     * Booking is awaiting confirmation by the merchant before it can transition into CONFIRMED status
     */
    PENDING_MERCHANT_CONFIRMATION,
    
    /**
     * Booking is awaiting confirmation by the client before it can transition into CONFIRMED status
     */
    PENDING_CLIENT_CONFIRMATION,
    
    /**
     * Booking has been canceled on behalf of the user. If the cancelation occurs too late - after the expiration of the cancelation window - then no automatic refund will be initiated. The merchant can still trigger a manual refund.
     */
    CANCELED,
    
    /**
     * Client did not show for the appointment
     */
    NO_SHOW,
    
    /**
     * Client did not show for the appointment in violation of the cancellation policy.
     */
    NO_SHOW_PENALIZED,
    
    /**
     * Booking has been canceled on behalf of the merchant. An automatic refund of any provided payment will be initiated. Example use case: A gym class is canceled due to instructor illness.
     */
    CANCELED_AUTOMATIC_REFUND,
    
}