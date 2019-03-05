package com.opensourceteams.module.kafka.example.producterconsumer;

import com.opensourceteams.module.kafka.example.producterconsumer.producter.Producer ;
import com.opensourceteams.module.kafka.example.producterconsumer.consumer.Consumer;

public class Run {

    public static void main(String[] args) {
        boolean isAsync = false;
        Producer producerThread = new Producer(KafkaProperties.TOPIC, isAsync);
        producerThread.start();

        Consumer consumerThread = new Consumer(KafkaProperties.TOPIC);
        consumerThread.start();

    }
}
