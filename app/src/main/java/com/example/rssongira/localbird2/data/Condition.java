package com.example.rssongira.localbird2.data;

import org.json.JSONObject;

/**
 * Created by RSSongira on 3/22/2017.
 */
public class Condition  implements JSONPopulator{
    private int code;
    private int temperature;
    private String description;

    public int getCode()
    {
        return  code;

    }
    public int getTemperature()
    {
        return  temperature;

    }
    public String getDescription()
    {
        return  description;

    }

    @Override
    public void populate(JSONObject data) {
        code = data.optInt("code");
        temperature=data.optInt("temp");
        description = data.optString("text");

    }
}
