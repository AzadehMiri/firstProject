package org.example.service;

import org.example.exception.DaysNumberException;
import org.example.exception.DepositTypeException;
import org.example.exception.ExceptionBalance;
import org.example.model.Deposit;
import org.example.model.LongTermDeposit;
import org.example.model.QarzolHasaneDeposit;
import org.example.model.ShortTermDeposit;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The deposit information is in the form of an XML file.
 * Deposit information includes: customer number, deposit type, balance in Rials and the number of days of the desired period.
 * This class reads the input file(XML-File).
 * @author AzadehMiri
 */
public class XmlFileReader {
    /**
     * takes the address of an xml file as a parameter.
     * Reads the requested information from the file.
     * Pours the read information into a list.
     * @param filePath an absolute URL giving the base location of the xml-file.
     * @return Deposit information in the form of a list.
     */
    public static List<Deposit> reader(String filePath) {
        List<Deposit> depositList = new ArrayList<>();
        try {
            File fXmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("deposit");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Deposit deposit = new Deposit();
                    Element eElement = (Element) nNode;
                    String customerNumber = eElement.getElementsByTagName("customerNumber").item(0).getTextContent();
                    deposit.setCustomerNumber(customerNumber);
                    String depositType = eElement.getElementsByTagName("depositType").item(0).getTextContent();
                    deposit.setDepositType(depositType);
                    String depositBalance = eElement.getElementsByTagName("depositBalance").item(0).getTextContent();
                    if (new BigDecimal(depositBalance).compareTo(BigDecimal.ZERO) < 0) {
                        throw new ExceptionBalance(depositBalance);
                    }
                    deposit.setDepositBalance(new BigDecimal(depositBalance));
                    String durationInDays = eElement.getElementsByTagName("durationInDays").item(0).getTextContent();
                    if (Integer.parseInt(durationInDays) == 0 || Integer.parseInt(durationInDays) < 0) {
                        throw new DaysNumberException(durationInDays);
                    }
                    deposit.setDurationInDays(durationInDays);
                    Deposit depositRate;
                    switch (depositType) {
                        case "LongTerm":
                            depositRate = new LongTermDeposit();
                            break;
                        case "ShortTerm":
                            depositRate = new ShortTermDeposit();
                            break;
                        case "Qarz":
                            depositRate = new QarzolHasaneDeposit();
                            break;
                        default:
                            throw new DepositTypeException(depositType);
                    }
                    deposit.setInterestRate(depositRate.getInterestRate());
                    depositList.add(deposit);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return depositList;
    }
}
