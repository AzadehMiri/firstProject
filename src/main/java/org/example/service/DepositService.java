package org.example.service;

import org.example.model.Deposit;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepositService {
    /**
     * @param interestRate   The interest rate of each type of deposit.
     * @param durationInDays The number of days of the interval.
     * @param depositBalance The balance of the deposit is in riyals.
     * @return The amount of interest paid to the customer in a certain period of time.
     */
    public static BigDecimal calculatePi(String interestRate, String durationInDays, BigDecimal depositBalance) {
        BigDecimal db = new BigDecimal(durationInDays);
        BigDecimal ir = new BigDecimal(interestRate);
        BigDecimal p = (db.multiply(ir)).multiply(depositBalance);
        int a = 36500;
        return p.divide(BigDecimal.valueOf(a), MathContext.DECIMAL32);
    }

    /**
     * First, by calling the reader method, it reads the XML file and puts it in a list.
     * Calculates interest per deposit
     * Sets the amount of interest calculated
     * Sorts the list in descending order
     * First, by calling the reader method, it reads the XML file and puts it in a list.
     * Calculates interest per deposit
     * Sets the amount of interest calculated
     * Sorts the list in descending order
     * By calling the writer method, it pours the sorted information into the created txt file
     *
     * @param filepath an absolute URL giving the base location of the xml-file.
     */
    public static void calculationDeposits(String filepath) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Deposit> depositList = XmlFileReader.reader(filepath);
        List<String> resultList = new ArrayList<>();

        for (Deposit deposit : depositList) {
            BigDecimal interestPayed = calculatePi(deposit.getInterestRate(), deposit.getDurationInDays(), deposit.getDepositBalance());
            deposit.setInterestPayed(interestPayed);
        }
        Collections.sort(depositList);

        for (Deposit deposit : depositList) {
            String result = deposit.getCustomerNumber() + "#" + deposit.getInterestPayed();
            resultList.add(result);
        }
        //Calling the method using reflection
        //Calling the method without using reflection: XmlFileWriter.writer(resultList);
        Class xmlFileWriterClass = XmlFileWriter.class;
        Method setter = xmlFileWriterClass.getMethod("writer", List.class);
        setter.invoke(null, resultList);
    }
}
