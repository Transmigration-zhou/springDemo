package com.yi.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonUtils {
    public static String getJson(Object object) throws JsonProcessingException {
        return getJson(object, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getJson(Object object, String dateFormat) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //不使用，默认的时间转换（时间戳:1970~现在时间的毫秒数）
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        //创建时间解析器对象
        SimpleDateFormat dateFormat1 = new SimpleDateFormat(dateFormat);
        //引入时间解析器
        mapper.setDateFormat(dateFormat1);

        //解析内容并返回
        return mapper.writeValueAsString(object);
    }
}
