/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author admin
 */
public class XDate {

    static SimpleDateFormat format = new SimpleDateFormat();

    //chuyển đổi từ String sang Date
    //date là String cần chuyển
    //pattern là định dạng thời gian
    public static Date toDate(String date, String pattern) {
        try {
            format.applyPattern(pattern);
            return format.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //chuyển đổi từ Date sang String
    //date là Date cần chuyển
    //pattern là định dạng thời gian
    public static String toString(Date date, String pattern) {
        format.applyPattern(pattern);
        return format.format(date);
    }

    //thời gian hiện tại
    public static Date now() {
        return new Date();
    }

    //Bổ sung số ngày vào thời gian
    //date là thời gian hiện có
    //days là số ngày cần bổ sung vào date
    public static Date addDays(Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }
}
