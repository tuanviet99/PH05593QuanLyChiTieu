package com.example.admin.ph05593quanlychitieu.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Common {


    public static String convertDate(String dateTime) {
        Date date = new Date(dateTime);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }

}
