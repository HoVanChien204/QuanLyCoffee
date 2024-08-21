/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.coffeesys.utils;
import java.text.*;
import java.util.Date;
/**
 *
 * @author VAN GIAU
 */
public class XDate {
    static SimpleDateFormat fomater = new SimpleDateFormat("dd-MM-yyyy");
   /*
    chuyển đổi String sang Date
    date là string cần chuyển
    pattern là định dạng thời gian
    */
    public static Date toDate(String date,String... pattern){
        try {
            if (pattern.length > 0) {
                 fomater.applyPattern(pattern[0]);
            }
            if (date == null) {
                return XDate.now();
            }
            return fomater.parse(date);
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }
    // chuyển đổi Date sang String
    public static String toString(Date date, String... pattern){
        try {
            if (pattern.length > 0) {
                   fomater.applyPattern(pattern[0]);
            }
            if (date == null) {
                date = XDate.now();
            }
            return fomater.format(date);
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }
    public static Date now(){
        return new Date();
    }
    /*
    Bổ sung số ngày vào thời gian
    date thời gian hiện có
    days số ngày cần bổ sung vào date
    return Date kết quả
    */
    public static Date addDays(Date date, long days){
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }
    
    public static Date add(int days) {
        Date now = XDate.now();
        now.setTime(now.getTime() + days * 24 * 60 * 60 *1000);
        return now;
    }
}
