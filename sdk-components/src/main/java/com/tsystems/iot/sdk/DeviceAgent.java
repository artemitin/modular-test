package com.tsystems.iot.sdk;

import java.util.UUID;

//agent run on the device
public class DeviceAgent {

    MeasurementsApi measurementsApi;
    EventApi eventApi;
    AlarmApi alarmApi;

    //        TODO startup actions: call DRS, set platform adapter, init services, etc...
    public void onStart() {
        PlatformAdapter adapter = null;
        //TODO ask DRS:
        String adapterType = UUID.randomUUID().toString();
        if ("axonize".equals(adapterType)) {
            adapter = new AxonizeAdapter();
        } else if ("cumulocity".equals(adapterType)) {
            adapter = new CumulocityAdapter();
        }
        measurementsApi = new MeasurementsApi(adapter);
        eventApi = new EventApi(adapter);
        alarmApi = new AlarmApi(adapter);
    }

    public void run() {
//        TODO device runtime logic
        measurementsApi.sendMeasurement(new Measurement());
        eventApi.sendEvent(new Event());
        alarmApi.sendAlarm(new Alarm());
    }

    public void onStop() {
//        TODO device shutdown actions
    }
}
