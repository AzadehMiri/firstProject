package org.example;

import org.example.controller.Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        final String DIRECTORY = "E:\\PROGRAMING\\JAVA\\firstProject\\src\\main\\resources\\Deposits.xml";
        Controller.depositController(DIRECTORY);
    }
}
