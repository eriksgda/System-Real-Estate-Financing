package Main;

import java.text.NumberFormat;
import java.util.ArrayList;

import Model.Financing;
import Util.InterfaceUser;


public class Main {
    public static void main(String[] args) {
        ArrayList<Financing> financingList = new ArrayList<>();

        InterfaceUser interfaceUser = new InterfaceUser();

        for (int i = 0; i < 4; i++){
            double propertyValue = interfaceUser.inputPropertyValue();
            int financingTerm = interfaceUser.inputFinancingTerm();
            double annualInterestRate = interfaceUser.inputAnnualInterestRate();

            Financing financing = new Financing(propertyValue, financingTerm, annualInterestRate);
            financingList.add(financing);
        }

        for (Financing financing : financingList){
            System.out.println();
            financing.showFinancingData();
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