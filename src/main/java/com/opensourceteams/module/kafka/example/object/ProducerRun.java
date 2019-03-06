package com.opensourceteams.module.kafka.example.object;

import com.opensourceteams.module.kafka.example.producterconsumer.KafkaProperties;

public class ProducerRun {

    public static void main(String[] args) throws InterruptedException {



        boolean isAsync = true;
        Producer producerThread = new Producer(KafkaProperties.TOPIC, isAsync,5);
        producerThread.start();
        Thread.sleep(2 * 1000l);

    }
}
