package com.tsystems.iot.sdk;

//service
public class AlarmApi {
    PlatformAdapter platformAdapter;

    public AlarmApi(PlatformAdapter adapter) {
        platformAdapter = adapter;
    }

    public void sendAlarm(Alarm alarm) {
        //code
        platformAdapter.sendAlarm(alarm);
        //code
    }

//    other methods
}
