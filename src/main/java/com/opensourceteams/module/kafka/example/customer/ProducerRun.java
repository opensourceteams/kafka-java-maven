package com.opensourceteams.module.kafka.example.customer;

import com.opensourceteams.module.kafka.example.producterconsumer.KafkaProperties;

public class ProducerRun {

    public static void main(String[] args) throws InterruptedException {
        boolean isAsync = true;
        Producer producerThread = new Producer(KafkaProperties.TOPIC, isAsync,20);
        producerThread.start();


        Thread.sleep(2 * 1000l);
    }
}
