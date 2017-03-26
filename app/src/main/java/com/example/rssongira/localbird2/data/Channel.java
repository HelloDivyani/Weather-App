package com.example.rssongira.localbird2.data;

import org.json.JSONObject;

/**
 * Created by RSSongira on 3/22/2017.
 */
public class Channel implements JSONPopulator{
    private  Item item;
    private  Units unit;

    public Item getItem() {
        return item;
    }
    public Units getUnits() {
        return unit;
    }

    @Override
    public void populate(JSONObject data) {
        // Interface Method
        unit = new Units();
        unit.populate(data.optJSONObject("units"));
        // units json data match
        item = new Item();
        item.populate(data.optJSONObject("item"));

    }


}

