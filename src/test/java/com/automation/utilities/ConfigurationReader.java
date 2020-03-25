package com.automation.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties configFile;

        static {
        try {
            //location of properties file
            String path = System.getProperty("user.dir")+"/configuration.properties";
            //get that file as a stream
            FileInputStream input = new FileInputStream(path);
            //create object of Properties class
            configFile = new Properties();
            //load properties file into Properties object
            configFile.load(input);
            //close the input s
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file!");
        }

    }

    /**
     * This method returns property value from configuration.properties file
     * @param keyName property name
     * @return property value
     */
    public static String getProperty(String keyName) {
        return configFile.getProperty(keyName);
    }

}
/*
Creational patters
-- singleton
        This pattern involves a single class which is responsible to create an object
        while making sure that only single object gets created
            This class provides a way to access its only object which can be access directly without need to instantiate
            the object of the class
 the simplest design pattern


 scripts don't require design pattern

 Implementation


 public class SingleObject{
 // create an object of SingleObject
 private static SingleObject  instance = new SingleObject();

 // make the constructor private so that this class cannot be instantiated
 private SingleObject(){}

 // Get the only object available
 public static SingleObject getInstance(){
 return instance;
 }

 We need:
 1. static variable
 2. private constructor
 3.


 */