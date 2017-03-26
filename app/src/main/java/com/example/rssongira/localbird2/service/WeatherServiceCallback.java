package com.example.rssongira.localbird2.service;

import com.example.rssongira.localbird2.data.Channel;

/**
 * Created by RSSongira on 3/22/2017.
 */
public interface WeatherServiceCallback {
    // Check for channel type
    void ServiceSuccess(Channel channel);
    void ServiceFailure(Exception exception);

}
