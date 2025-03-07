package StripePaymentLink.service;

import com.stripe.exception.StripeException;

public interface IPaymentService {
    String getPaymentLink(Long amount, Long quantity, String callbackUrl, String productName) throws StripeException;
}
