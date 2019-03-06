package com.opensourceteams.module.kafka.example.object;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensourceteams.module.kafka.example.producterconsumer.KafkaProperties;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.text.ParseException;
import java.util.Properties;

public class Producer extends Thread {
    private final KafkaProducer<Integer, String> producer;
    private final String topic;
    private final Boolean isAsync;
    private final Integer dataCount;

    public Producer(String topic, Boolean isAsync,Integer dataCount) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaProperties.KAFKA_SERVER_URL + ":" + KafkaProperties.KAFKA_SERVER_PORT);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "DemoProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
       // props.put("group.id", "test");
        producer = new KafkaProducer<>(props);
        this.topic = topic;
        this.isAsync = isAsync;
        this.dataCount = dataCount;
    }


    public void run() {

        int showCount = 1;
        while (true){
            sendData(" " + showCount);
            showCount++;
            try {
                Thread.sleep(2 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     *
     * @param showCount 第几批数据
     */
    public void sendData(String  showCount){

        JSONArray jsonArray = null;
        try {
            jsonArray = JSONArray.parseArray(JSONUtil.getJsonData(dataCount,showCount));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        for(int i =0; i< jsonArray.size();i++){

            JSONObject jsonObject = JSONObject.parseObject(jsonArray.get(i).toString());



            if (isAsync) { // Send asynchronously
                producer.send(new ProducerRecord<>(topic,
                        jsonObject.getInteger("no"),
                        jsonObject.toJSONString()), new Callback() {
                    @Override
                    public void onCompletion(RecordMetadata metadata, Exception exception) {

                        if (metadata != null) {
                            System.out.println(
                                    "message("  + jsonObject.toJSONString() + ") sent to partition(" + metadata.partition() +
                                            "), " +
                                            "offset(" + metadata.offset() + ")  " );
                        } else {
                            exception.printStackTrace();
                        }
                    }
                });
            }

        }

        System.out.println("\n\n");


    }
}

