package com.amitin.test.sdk;

import com.amitin.test.api.AdapterApi;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.ServiceLoader;

/**
 * @author Artem Mitin
 * @since 13.09.2018
 */
public class AdaptersProvider {
    private static AdaptersProvider provider;
    private ServiceLoader<AdapterApi> loader;

    private AdaptersProvider() throws MalformedURLException {
        File loc = new File("plugins");

        File[] flist = loc.listFiles(file -> file.getPath().toLowerCase().endsWith(".jar"));

        URL[] urls = new URL[Objects.requireNonNull(flist).length];

        for (int i = 0; i < flist.length; i++)
            urls[i] = flist[i].toURI().toURL();

        URLClassLoader ucl = new URLClassLoader(urls);

        loader = ServiceLoader.load(AdapterApi.class, ucl);
    }

    public static AdaptersProvider getInstance() {
        if (provider == null) {
            try {
                provider = new AdaptersProvider();
            } catch (MalformedURLException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        return provider;
    }

    public AdapterApi serviceImpl() {
        AdapterApi adapter = loader.iterator().next();
        if (adapter != null) {
            return adapter;
        } else {
            throw new NoSuchElementException("No implementation for AdaptersProvider");
        }
    }
}

