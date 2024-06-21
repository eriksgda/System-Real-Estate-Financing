package Model;

import java.text.NumberFormat;

public class Apartment extends Financing {
    // attributes
    private int garageSpace;
    private int floorNumber;

    // constructor
    public Apartment(double propertyValue, int financingTerm, double annualInterestRate, int garageSpace, int floorNumber){
        super(propertyValue, financingTerm, annualInterestRate);
        this.garageSpace = garageSpace;
        this.floorNumber = floorNumber;
    }

    // getters
    public int getGarageSpace() {
        return this.garageSpace;
    }

    public int getFloorNumber() {
        return this.floorNumber;
    }

    // other methods
    @Override
    public double calcMonthlyPayment(){
        double months = getFinancingTerm() * 12;
        double monthInterestRate = (getAnnualInterestRate() / 100) /12;

        return (getPropertyValue() * monthInterestRate) / (1 - Math.pow((1 + monthInterestRate), -months));
    }

    public double calcTotalPayment(){
        return calcMonthlyPayment() * getFinancingTerm() * 12;
    }

    public void printFinancingData(){
        System.out.println("Type  of financing: Apartment");
        System.out.println("Floor number: " + getFloorNumber());
        System.out.println("Number of garage space: " + getGarageSpace());
        System.out.println("Property value: R$ " + NumberFormat.getCurrencyInstance().format(getPropertyValue()));
        System.out.println("Financing term: " + this.financingTerm  + " year(s)");
        System.out.println("Annual interest rate: " +  this.annualInterestRate + '%'); //NumberFormat.getPercentInstance().format(this.annualInterestRate)
        System.out.println("Monthly payment of financing: R$ " + NumberFormat.getCurrencyInstance().format(calcMonthlyPayment()));
        System.out.println("Total payment of financing: R$ " + NumberFormat.getCurrencyInstance().format(calcTotalPayment()));
    }
}
