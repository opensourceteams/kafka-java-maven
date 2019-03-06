package com.opensourceteams.module.kafka.common.producer;

import com.opensourceteams.module.kafka.example.producterconsumer.KafkaProperties;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ProducerUtil {


    private static  KafkaProducer<Integer, String> producer = null ;

    static {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.KAFKA_SERVER_URL + ":" + KafkaProperties.KAFKA_SERVER_PORT);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "DemoProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producer = new KafkaProducer<>(props);
    }

    /**
     * 发送消息
     * @param topic
     * @param key
     * @param value
     */
    public static void  sendMessage(String topic,Integer key,String value){

        producer.send(new ProducerRecord<>(topic,
                key,
                value), new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {

                if (metadata != null) {
                    System.out.println(
                            "message("  + key + ":" + value + ") sent to partition(" + metadata.partition() +
                                    "), " +
                                    "offset(" + metadata.offset() + ")  " );
                } else {
                    exception.printStackTrace();
                }
            }
        });

    }


}
