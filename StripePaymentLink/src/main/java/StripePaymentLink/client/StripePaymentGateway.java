package StripePaymentLink.client;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StripePaymentGateway {

    @Value("${stripe.key}")
    public String apiKey;

    public String getPaymentLink(Long amount, Long quantity, String callbackUrl, String productName) throws StripeException {
        //Add your implementation here
        Stripe.apiKey=apiKey;
       // Step 1: Create Product
        ProductCreateParams productParams = ProductCreateParams.builder()
                .setName(productName)
                .build();
        Product product = Product.create(productParams);

        // Step 2: Create Price
        PriceCreateParams priceParams = PriceCreateParams.builder()
                .setCurrency("usd")
                .setUnitAmount(amount*100) // Amount should be in cents
                .setProduct(product.getId()) // Link price to product
                .build();
        Price price = Price.create(priceParams);

        // Step 3: Create Payment Link
        PaymentLinkCreateParams linkParams = PaymentLinkCreateParams.builder()
                .addLineItem(PaymentLinkCreateParams.LineItem.builder()
                        .setPrice(price.getId()) // Use the created price ID
                        .setQuantity(quantity)
                        .setAdjustableQuantity(PaymentLinkCreateParams.LineItem.AdjustableQuantity.builder()
                                .setEnabled(true) // Allow users to adjust quantity
                                .setMinimum(1l)
                                .setMaximum(10l)
                                .build())
                        .build())
                .setAfterCompletion(PaymentLinkCreateParams.AfterCompletion.builder()
                        .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                        .setRedirect(PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                .setUrl(callbackUrl) // No need to append extra space
                                .build())
                        .build())
                .build();

        PaymentLink paymentLink = PaymentLink.create(linkParams);
        return paymentLink.getUrl();
    }
}

