package com.example.rssongira.localbird2.data;

import org.json.JSONObject;

/**
 * Created by RSSongira on 3/22/2017.
 */
public class Units implements JSONPopulator{
    private  String temperature;
    // Faherenheit

    public String getTemperature()
    {
        return  temperature;
    }

    @Override
    public void populate(JSONObject data) {
        temperature=data.optString("temperature");
        // F

    }
}
