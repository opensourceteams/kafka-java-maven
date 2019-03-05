package com.opensourceteams.module.kafka.example.customer;

import com.opensourceteams.module.kafka.example.producterconsumer.KafkaProperties;

public class ProducerRun {

    public static void main(String[] args) {
        boolean isAsync = false;
        Producer producerThread = new Producer(KafkaProperties.TOPIC, isAsync,5);
        producerThread.start();


    }
}
