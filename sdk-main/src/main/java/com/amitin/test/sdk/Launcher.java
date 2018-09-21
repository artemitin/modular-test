package com.amitin.test.sdk;

import com.amitin.test.api.AdapterApi;

/**
 * @author Artem Mitin
 * @since 13.09.2018
 */
public class Launcher {

    public static void main(String... args) {
        AdapterApi adapter = AdaptersProvider.getInstance().serviceImpl();
        adapter.sayHello("Artem");
    }
}

