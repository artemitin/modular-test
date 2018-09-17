package com.tsystems.iot.sdk;

import com.tsystems.iot.sdk.Alarm;
import com.tsystems.iot.sdk.Event;
import com.tsystems.iot.sdk.Measurement;

public interface PlatformAdapter {

    //    methods compatible with cumulocity api:
    void sendAlarm(Alarm alarm);
    void sendMeasurement(Measurement measurement);
    void sendEvent(Event event);
}
