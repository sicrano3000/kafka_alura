package br.com.alura.ecommerce;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try(var dispatcher = new KafkaDispatcher<Order>()) {
            try(var emailDispatcher = new KafkaDispatcher<String>()) {
                var userId = UUID.randomUUID().toString();
                var orderId = UUID.randomUUID().toString();
                var amount = BigDecimal.valueOf(Math.random() * 5000 + 1);
                var order = new Order(userId, orderId, amount);

                var email = "Thank you for your order! We are processing your order!";

                dispatcher.send("ECOMMERCE_NEW_ORDER", userId, order);
                emailDispatcher.send("ECOMMERCE_NEW_ORDER", userId, email);
            }
        }
    }

}
