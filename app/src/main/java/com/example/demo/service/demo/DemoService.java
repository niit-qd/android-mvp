package com.example.demo.service.demo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class DemoService {
    public String getCurrentDateTimeString(Locale locale) {
        Date date = new Date();
        System.out.println("date = " + date);
        DateFormat dateDateFormat = null;
        DateFormat timeDateFormat = null;
        if (null == locale) {
            dateDateFormat = DateFormat.getDateInstance(DateFormat.FULL);
            timeDateFormat = DateFormat.getTimeInstance(DateFormat.FULL);
        } else {
            dateDateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
            timeDateFormat = DateFormat.getTimeInstance(DateFormat.FULL, locale);
        }
        String str = dateDateFormat.format(date) + " " + timeDateFormat.format(date);
        return str;
    }
}
