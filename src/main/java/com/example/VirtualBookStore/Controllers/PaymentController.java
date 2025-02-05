//package com.example.VirtualBookStore.Controllers;
//
//import com.example.VirtualBookStore.Services.PaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/v1/payments")
//public class PaymentController {
//
//    @Autowired
//    private PaymentService paymentService;
//
//    @PostMapping("/create")
//    public ResponseEntity<String> createPayment(@RequestParam double amount){
//        String orderResponse = paymentService.createOrder(amount);
//        return ResponseEntity.ok(orderResponse);
//    }
//
//    @PostMapping("/verify")
//    private ResponseEntity<String> verifyPayment(@RequestParam String reazorpayPaymentid, @RequestParam String razorpayOrderid, @RequestParam String razorpaySignature){
//        boolean isDone = paymentService.verifyPayment(reazorpayPaymentid, razorpayOrderid, razorpaySignature);
//        if(isDone){
//            return new ResponseEntity<>("Payment Succesfully done", HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Payment Failed ", HttpStatus.PAYMENT_REQUIRED);
//    }
//}
