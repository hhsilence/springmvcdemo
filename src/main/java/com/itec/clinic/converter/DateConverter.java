package com.itec.clinic.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date>{
    private String datepattern;

    public DateConverter(String datepattern){
        this.datepattern = datepattern;
    }

    @Override
    public Date convert(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(datepattern); //将datepattern这样形式的字符串转换成Date
        dateFormat.setLenient(false);//是否严格解析字符串
        try {
            Date date = dateFormat.parse(s);//将String型转换为特定格式的Date类型
            //System.out.println("111111111111111111111111111111");
            return date;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
