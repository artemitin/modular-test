package com.amitin.test.sdk;

import com.amitin.test.api.AdapterApi;

import java.util.NoSuchElementException;
import java.util.ServiceLoader;

/**
 * @author Artem Mitin
 * @since 13.09.2018
 */
public class PlatformProvider {
    private static PlatformProvider provider;
    private ServiceLoader<AdapterApi> loader;

    private PlatformProvider() {
        loader = ServiceLoader.load(AdapterApi.class);
    }

    public static PlatformProvider getInstance() {
        if (provider == null) {
            provider = new PlatformProvider();
        }
        return provider;
    }

    public AdapterApi serviceImpl() {
        AdapterApi adapter = loader.iterator().next();
        if (adapter != null) {
            return adapter;
        } else {
            throw new NoSuchElementException(
                    "No implementation for PlatformProvider");
        }
    }
}

