package com.opensourceteams.module.kafka.common.producer;

import com.opensourceteams.module.kafka.example.object.DateUtil;
import com.opensourceteams.module.kafka.example.object.JSONUtil;
import com.opensourceteams.module.kafka.example.producterconsumer.KafkaProperties;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class ProducerUtilTest {

    @Test
    public void sendMessage() throws InterruptedException, ParseException {
        Integer i = 10060;
        String date_String = "2019-03-06 13:51:01" ;
        String message = JSONUtil.getJSONData(date_String,i,i + "  " + date_String);
        ProducerUtil.sendMessage(KafkaProperties.TOPIC,i,message) ;

        Thread.sleep(1 * 1000L);
    }



    @Test
    public void sendMessageMany2() throws InterruptedException, ParseException {
        String date_String = "2019-03-06 11:40:38" ;

        for( int i = 0 ;i < 1000;i++){
            String message = JSONUtil.getJSONData(date_String,i,i + "  " + date_String);
            ProducerUtil.sendMessage(KafkaProperties.TOPIC,i,message) ;

            date_String = DateUtil.getStringByDate(DateUtil.calTime(DateUtil.getDateByString(date_String),null,null,1));


            Thread.sleep(4 * 1000L);
        }



    }

    @Test
    public void sendMessageMany() throws InterruptedException, ParseException {
        String date_String = "2019-03-06 11:24:38" ;

        int i = 1;
       while (true){

           String message = JSONUtil.getJSONData(date_String,i,i + "  " + date_String);
           ProducerUtil.sendMessage(KafkaProperties.TOPIC,i,message) ;

           Thread.sleep(2 * 1000L);
           i++;
       }


    }


    /**
     * 每次多发几条数据
     * @throws InterruptedException
     * @throws ParseException
     */

    @Test
    public void sendMessageManyMany() throws InterruptedException, ParseException {
        String date_String = "2019-03-06 13:35:38" ;

        int i = 1;
        while (true){

            String date_String_temp = date_String;
            for( int j = 1;j <= 2;j++){
                String message = JSONUtil.getJSONData(date_String_temp,i,j + "  " + date_String_temp);
                ProducerUtil.sendMessage(KafkaProperties.TOPIC,i,message) ;
                date_String_temp = DateUtil.getStringByDate(DateUtil.calTime(DateUtil.getDateByString(date_String_temp),null,null,1));

                Thread.sleep(1 * 1000L);

                i++;
            }

            date_String = DateUtil.getStringByDate(DateUtil.calTime(DateUtil.getDateByString(date_String),null,null,1));

            Thread.sleep(2 * 1000L);

        }


    }
}