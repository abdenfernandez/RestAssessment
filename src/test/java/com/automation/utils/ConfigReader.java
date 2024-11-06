package com.automation.utils;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {

    static Properties prop;

    public static void initConfig() {
        try {
            prop = new Properties();
            prop.load(new FileReader("src/test/resources/config/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void setProperty(String key, String value) {
        prop.setProperty(key, value);
    }






}
