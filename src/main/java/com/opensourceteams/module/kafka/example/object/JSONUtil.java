package com.opensourceteams.module.kafka.example.object;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.util.Date;

public class JSONUtil {

    /**
     *
     * @param count 发几条消息
     * @param showCount 第几批
     * @return
     * @throws ParseException
     */
    public static String getJsonData(Integer count,String showCount) throws ParseException {
        //String data_string = "2019-01-01 02:00:00";
        String data_string = DateUtil.getStringByDate(DateUtil.calTime(new Date(),-2,null,null));


        JSONArray jsonArray = new JSONArray();

        for(int i = 1 ;i <= count ;i++){

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("no",i);
            jsonObject.put("message",showCount +"_message_" + i);

            Date date = DateUtil.calTime(DateUtil.getDateByString(data_string),null,null,1);
            String new_date_string = DateUtil.getStringByDate(date);
            jsonObject.put("send_data_string",DateUtil.getStringByDate(new Date()));
            jsonObject.put("extract_data_time",new_date_string);
            jsonObject.put("data_time",date.getTime());

            data_string = new_date_string;
           // System.out.println(jsonObject.toJSONString());
            jsonArray.add(jsonObject);

        }
       // System.out.println();
       // System.out.println();
        return jsonArray.toString();
    }

    public static String getJSONData(String date_string,Integer key,String message) throws ParseException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("no",key);
        jsonObject.put("message",message);
        jsonObject.put("send_data_string",DateUtil.getStringByDate(new Date()));
        jsonObject.put("extract_data_time",date_string);
        Date date = DateUtil.getDateByString(date_string);
        jsonObject.put("data_time",date.getTime());

        return jsonObject.toJSONString();
    }
}
