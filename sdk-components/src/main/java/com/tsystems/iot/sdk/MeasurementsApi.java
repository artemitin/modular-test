package com.tsystems.iot.sdk;

//service
public class MeasurementsApi {
    PlatformAdapter platformAdapter;

    public MeasurementsApi(PlatformAdapter adapter) {
        platformAdapter = adapter;
    }

    public void sendMeasurement(Measurement measurement) {
        //code
        platformAdapter.sendMeasurement(measurement);
        //code
    }

    //    other methods
}
