package StripePaymentLink.service;

import StripePaymentLink.client.StripePaymentGateway;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private StripePaymentGateway stripePaymentGateway;

    public String getPaymentLink(Long amount, Long quantity, String callbackUrl, String productName) throws StripeException {
        //Add your implementation here

        return stripePaymentGateway.getPaymentLink(amount,quantity,callbackUrl,productName);
    }
}

