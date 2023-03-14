package com.example.demo.business.viewbinding_activity_demo.model;

import com.example.demo.service.demo.DemoService;
import com.example.mvp.model.IModel;

import java.util.Locale;

public class DemoModel implements IModel {
    private DemoService demoService;

    public DemoModel() {
        demoService = new DemoService();
    }

    public String getCurrentDateTimeString() {
        Locale locale = Locale.CHINA;
        return demoService.getCurrentDateTimeString(locale);
    }
}
