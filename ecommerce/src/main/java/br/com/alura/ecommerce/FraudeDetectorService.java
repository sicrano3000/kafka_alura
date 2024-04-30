package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class FraudeDetectorService {

    public static void main(String[] args) {
        var fraudeService = new FraudeDetectorService();
        var service = new KafkaService(FraudeDetectorService.class.getSimpleName(), "ECOMMERCE_NEW_ORDER", fraudeService::parse);
        service.run();
    }

    private void parse(ConsumerRecord<String, String> record) {
        System.out.println("----------------------------------------");
        System.out.println("Processing new order, checking for fraud");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // ignoring
            e.printStackTrace();
        }
    }

}
