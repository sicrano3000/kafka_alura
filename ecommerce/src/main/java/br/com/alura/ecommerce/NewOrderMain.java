package br.com.alura.ecommerce;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try(var dispatcher = new KafkaDispatcher()) {
            var key = UUID.randomUUID().toString();
            var email = "Thank you for your order! We are processing your order!";
            var value = key + ", 456456, 789789, 963963";

            dispatcher.send("ECOMMERCE_NEW_ORDER", key, email);
            dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);
        }
    }

}
