package com.amitin.test.cumulocity;

import com.amitin.test.api.AdapterApi;

/**
 * @author Artem Mitin
 * @since 13.09.2018
 */
public class CumulocityAdapterImpl implements AdapterApi {

    @Override
    public void sayHello(String name) {
        System.out.println("CUM: Hello to " + name);
    }
}