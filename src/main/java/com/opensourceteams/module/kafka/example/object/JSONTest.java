package com.opensourceteams.module.kafka.example.object;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;

public class JSONTest {

    public static void main(String[] args) throws ParseException {




        JSONArray jsonArray = JSONArray.parseArray(JSONUtil.getJsonData(10,"a"));

        for(int i =0; i< jsonArray.size();i++){
            System.out.println(jsonArray.get(i));
        }



        for(int i =0; i< jsonArray.size();i++){

            System.out.println(JSONObject.parseObject(jsonArray.get(i).toString()).getString("data_string")   );
        }



    }


}
