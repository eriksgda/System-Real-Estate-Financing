package Main;

import java.text.NumberFormat;
import java.util.ArrayList;

import Model.Financing;
import Util.InterfaceUser;


public class Main {
    public static void main(String[] args) {
        ArrayList<Financing> financingList = new ArrayList<>();

        InterfaceUser interfaceUser = new InterfaceUser();

        double propertyValue = interfaceUser.inputPropertyValue();
        int financingTerm = interfaceUser.inputFinancingTerm();
        double annualInterestRate = interfaceUser.inputAnnualInterestRate();
        Financing firstApartmentFinancing = new Model.Apartment(propertyValue, financingTerm, annualInterestRate);
        financingList.add(firstApartmentFinancing);

        Financing secondApartmentFinancing = new Model.Apartment(1000000,15,10);
        financingList.add(secondApartmentFinancing);

        Financing firstHomeFinancing = new Model.Home(500000, 10, 10);
        financingList.add(firstHomeFinancing);

        Financing secondHomeFinancing = new Model.Home(1500000, 5, 12);
        financingList.add(secondHomeFinancing);

        Financing firstLandFinancing = new Model.Land(2000000, 22,20);
        financingList.add(firstLandFinancing);

        for (Financing financing : financingList){
            System.out.println();
            financing.printFinancingData();
            System.out.println("-------");
        }

        double totalPropertyValue = 0;
        double totalFinancingValue = 0;

        for (Financing financing : financingList) {
            totalPropertyValue += financing.getPropertyValue();
            totalFinancingValue += financing.calcTotalPayment();
        }

        System.out.printf("\nTotal property value: R$ %s Total Financing Value: R$ %s",
                NumberFormat.getCurrencyInstance().format(totalPropertyValue),
                NumberFormat.getCurrencyInstance().format(totalFinancingValue));
    }
}