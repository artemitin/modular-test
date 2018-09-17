package com.tsystems.iot.sdk;

//service
public class EventApi {
    PlatformAdapter platformAdapter;

    public EventApi(PlatformAdapter adapter) {
        platformAdapter = adapter;
    }

    public void sendEvent(Event event) {
        //code
        platformAdapter.sendEvent(event);
        //code
    }

    //    other methods
}
