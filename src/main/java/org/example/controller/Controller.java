package org.example.controller;

import org.example.service.DepositService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Controller {
    public static void depositController(String filePath) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        DepositService.calculationDeposits(filePath);
    }
}
