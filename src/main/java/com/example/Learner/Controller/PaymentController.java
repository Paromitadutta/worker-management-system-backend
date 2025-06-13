//package com.example.demo.controller;
//
//import com.google.gson.JsonObject;
//import okhttp3.*;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.io.IOException;
//
//@RestController
//@CrossOrigin(origins = "https://worker-management-system.vercel.app")
//public class PaymentController {
//
//    @PostMapping("/create-order")
//    public String createOrder(@RequestBody AmountRequest amountRequest) throws IOException {
//        String keyId = "rzp_test_mufoltUfznOxOQ";
//        String keySecret = "NUIYYDYGzpAmhBmK0FZrNGU0";
//
//        OkHttpClient client = new OkHttpClient();
//
//        MediaType mediaType = MediaType.parse("application/json");
//        JsonObject json = new JsonObject();
//        json.addProperty("amount", (int)(amountRequest.getAmount() * 100)); // amount in paise
//        json.addProperty("currency", "INR");
//        json.addProperty("receipt", "receipt#1");
//
//        // Use full class name to avoid conflict with Spring's @RequestBody annotation
//        okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType, json.toString());
//
//        Request request = new Request.Builder()
//                .url("https://api.razorpay.com/v1/orders")
//                .post(body)
//                .addHeader("Authorization", Credentials.basic(keyId, keySecret))
//                .addHeader("Content-Type", "application/json")
//                .build();
//
//        Response response = client.newCall(request).execute();
//        return response.body().string();
//    }
//
//    static class AmountRequest {
//        private double amount;
//
//        public double getAmount() {
//            return amount;
//        }
//
//        public void setAmount(double amount) {
//            this.amount = amount;
//        }
//    }
//}
package com.example.Learner.Controller;

import com.example.Learner.model.Payment;
import com.example.Learner.Service.PaymentService;
import com.google.gson.JsonObject;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "https://worker-management-system.vercel.app")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create-order")
    public String createOrder(@RequestBody AmountRequest amountRequest) throws IOException {
        String keyId = "rzp_test_mufoltUfznOxOQ";
        String keySecret = "NUIYYDYGzpAmhBmK0FZrNGU0";

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        JsonObject json = new JsonObject();
        json.addProperty("amount", (int) (amountRequest.getAmount() * 100)); // amount in paise
        json.addProperty("currency", "INR");
        json.addProperty("receipt", "receipt#1");

        okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType, json.toString());

        Request request = new Request.Builder()
                .url("https://api.razorpay.com/v1/orders")
                .post(body)
                .addHeader("Authorization", Credentials.basic(keyId, keySecret))
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    @PostMapping("/save-payment")
    public Payment savePayment(@RequestBody Payment payment) {
        return paymentService.savePayment(payment);
    }

    static class AmountRequest {
        private double amount;

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
