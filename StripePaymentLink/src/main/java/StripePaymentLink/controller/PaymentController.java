package StripePaymentLink.controller;


import StripePaymentLink.dtos.InitializePaymentRequestDto;
import StripePaymentLink.service.IPaymentService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    //Add your API here
    @PostMapping("/payment")
    public ResponseEntity<String> getPaymentLink(@RequestBody InitializePaymentRequestDto dto) throws StripeException {
        return ResponseEntity.ok(paymentService.getPaymentLink(dto.getAmount(),dto.getQuantity(),dto.getCallbackUrl(),dto.getProductName()));
    }
}
