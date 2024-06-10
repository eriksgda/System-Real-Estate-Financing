package Main;

import Model.Financing;
import Util.InterfaceUser;

public class Main {
    public static void main(String[] args) {
        InterfaceUser interfaceUser = new InterfaceUser();

        double propertyValue = interfaceUser.inputPropertyValue();
        int financingTerm = interfaceUser.inputFinancingTerm();
        double annualInterestRate = interfaceUser.inputAnnualInterestRate();

        Financing financing = new Financing(propertyValue, financingTerm, annualInterestRate);

        double monthlyPayment = financing.calcMonthlyPayment();
        double totalPayment = financing.calcTotalPayment();

        System.out.println("Monthly payment: " + monthlyPayment);
        System.out.println("Total payment: " + totalPayment);
    }
}