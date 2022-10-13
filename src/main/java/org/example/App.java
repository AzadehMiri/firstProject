package org.example;

import org.example.controller.Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        final String DIRECTORY = "C:/Users/Eniac/Desktop/Deposits.xml";
        Controller.depositController(DIRECTORY);
    }
}
