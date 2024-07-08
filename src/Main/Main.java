package Main;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;

import Model.*;
import Util.*;


public class Main {
    // write method
    public static void writeFinancing(String fileName, ArrayList<Financing> financingList){
        ObjectOutputStream outputStream;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(fileName));

            for (Financing financing : financingList){
                outputStream.writeObject(financing);
            }

            outputStream.flush();
            outputStream.close();
        } catch(IOException exception){
            System.out.println(exception.getMessage());
        }
    }
    // read method
    public static ArrayList<Financing> readFinancing(String fileName) {
        ObjectInputStream inputStream;
        ArrayList<Financing> financingList = new ArrayList<>();

        try {
            inputStream = new ObjectInputStream(new FileInputStream(fileName));
            Object supportObject;

            while ((supportObject = inputStream.readObject()) != null) {
                if (supportObject instanceof Financing) {
                    financingList.add((Financing) supportObject);
                }
            }
            inputStream.close();

        } catch (EOFException | FileNotFoundException exception) {
            System.out.println();
        } catch (ClassNotFoundException | IOException exception) {
            System.out.println(exception.getMessage());
        }

        return financingList;
    }

    public static void createSomeFinancing(ArrayList<Financing> financingList){
        Financing secondApartmentFinancing = new Apartment(1000000,15,
                10, 50, 13);
        financingList.add(secondApartmentFinancing);

        Financing firstHomeFinancing = new House(500000, 10, 10, 80, 165.3);
        financingList.add(firstHomeFinancing);

        Financing secondHomeFinancing = new House(1500000, 5, 12, 44, 97.6);
        financingList.add(secondHomeFinancing);

        Financing firstLandFinancing = new Land(2000000, 22,20, "Commercial");
        financingList.add(firstLandFinancing);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the financing simulator!");

        String fileName = "src/financing.test";
        double propertyValue;
        int financingTerm;
        double annualInterestRate;

        ArrayList<Financing> financingList = readFinancing(fileName);

        InterfaceUser interfaceUser = new InterfaceUser();

        int financingType = interfaceUser.inputFinancingType();
        switch (financingType){
            case 1: // apartment
                propertyValue = interfaceUser.inputPropertyValue();
                financingTerm = interfaceUser.inputFinancingTerm();
                annualInterestRate = interfaceUser.inputAnnualInterestRate();
                int garageSpace = interfaceUser.inputGarageSpace();
                int floorNumber = interfaceUser.inputFloorNumber();

                Financing apartmentFinancing = new Apartment(propertyValue, financingTerm, annualInterestRate, garageSpace, floorNumber);
                financingList.add(apartmentFinancing);
                break;
            case 2: // house
                propertyValue = interfaceUser.inputPropertyValue();
                financingTerm = interfaceUser.inputFinancingTerm();
                annualInterestRate = interfaceUser.inputAnnualInterestRate();
                double houseArea = interfaceUser.inputHouseArea();
                double landArea = interfaceUser.inputLandArea();

                Financing houseFinancing = new House(propertyValue, financingTerm, annualInterestRate, houseArea, landArea);
                financingList.add(houseFinancing);
                break;
            case 3: // land
                propertyValue = interfaceUser.inputPropertyValue();
                financingTerm = interfaceUser.inputFinancingTerm();
                annualInterestRate = interfaceUser.inputAnnualInterestRate();
                boolean areaType = interfaceUser.inputAreaType();

                Financing landFinancing = new Land(propertyValue, financingTerm, annualInterestRate, (areaType ? "Residential" : "Commercial"));
                financingList.add(landFinancing);
                break;
        }

        createSomeFinancing(financingList);

        writeFinancing(fileName, financingList);
        ArrayList<Financing> financingListData = readFinancing(fileName);

        double totalPropertyValue = 0;
        double totalFinancingValue = 0;
        for (Financing financing : financingListData){
            financing.printFinancingData();
            System.out.println();

            totalPropertyValue += financing.getPropertyValue();
            totalFinancingValue += financing.calcTotalPayment();
        }

        System.out.printf("\nTotal property value: R$ %s Total Financing Value: R$ %s",
                NumberFormat.getCurrencyInstance().format(totalPropertyValue),
                NumberFormat.getCurrencyInstance().format(totalFinancingValue));

    }
}