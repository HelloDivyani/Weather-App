package com.example.rssongira.localbird2.data;

import org.json.JSONObject;

/**
 * Created by RSSongira on 3/22/2017.
 */
public class Item implements JSONPopulator{
    private  Condition condition;
    public Condition getCondition()
    {
     return  condition;
    }

    @Override

    public void populate(JSONObject data) {
    condition  = new Condition();
        condition.populate(data.optJSONObject("condition"));

    }
}

