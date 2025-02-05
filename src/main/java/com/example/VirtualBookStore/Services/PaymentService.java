//package com.example.VirtualBookStore.Services;
//
//import com.razorpay.Order;
//import com.razorpay.RazorpayClient;
//import com.razorpay.RazorpayException;
//import com.razorpay.Utils;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PaymentService {
//
//    @Value("${razorpay.api.key}")
//    private String key;
//
//    @Value("${razoprpay.api.secret}")
//    private String secret;
//
//    public String createOrder(double amount){
//        try {
//            RazorpayClient razorPay = new RazorpayClient(key, secret);
//            JSONObject orderRequest = new JSONObject();
//            orderRequest.put("amount", (int) (amount * 100));
//            orderRequest.put("currency", "INR");
//            orderRequest.put("receipt", "txn_123456");
//
//            Order order = razorPay.orders.create(orderRequest);
//            return order.toString();
//        } catch (RazorpayException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public boolean verifyPayment(String razorpayPaymentId, String razorpayOrderId, String razorpaySignature) {
//        try {
//            RazorpayClient razorpay = new RazorpayClient(key, secret);
//
//            JSONObject options = new JSONObject();
//            options.put("razorpay_payment_id", razorpayPaymentId);
//            options.put("razorpay_order_id", razorpayOrderId);
//            options.put("razorpay_signature", razorpaySignature);
//
//            boolean isValid = Utils.verifyPaymentSignature(options, secret);
//            return isValid;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//}
