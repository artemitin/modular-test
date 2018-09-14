package com.amitin.test.axonize;


import com.amitin.test.api.AdapterApi;

/**
 * @author Artem Mitin
 * @since 13.09.2018
 */
public class AxonizeAdapterImpl implements AdapterApi {

    @Override
    public void sayHello(String name) {
        System.out.println("AX: Hello to " + name);
    }
}