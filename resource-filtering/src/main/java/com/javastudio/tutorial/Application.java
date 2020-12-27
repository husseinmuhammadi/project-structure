package com.javastudio.tutorial;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println();
        // dumpSystemProperties();
        dumpReleaseSpecifications();
    }

    private static void dumpReleaseSpecifications() {
        try (InputStream resource = Application.class.getClassLoader().getResourceAsStream("version.properties")) {
            Properties p = new Properties();
            p.load(resource);
            System.out.println(p.getProperty("release.artifactId"));
            System.out.println(p.getProperty("release.version"));
            System.out.println(p.getProperty("java.version"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void dumpSystemProperties() {
        Properties p = System.getProperties();
        Set set = p.entrySet();

        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            Map.Entry entry = (Map.Entry) itr.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
