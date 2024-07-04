package Model;

import java.text.NumberFormat;

public class House extends Financing {
    // attributes
    private double houseArea;
    private double landArea;

    // constructor
    public House(double propertyValue, int financingTerm, double annualInterestRate, double houseArea, double landArea){
        super(propertyValue, financingTerm, annualInterestRate);
        this.houseArea = houseArea;
        this.landArea = landArea;
    }

    // getters
    public double getHouseArea() {
        return this.houseArea;
    }

    public double getLandArea() {
        return this.landArea;
    }

    // other methods
    @Override
    public double calcMonthlyPayment(){
        return super.calcMonthlyPayment() + 80;
    }

    @Override
    public double calcTotalPayment(){
        return calcMonthlyPayment() * getFinancingTerm() * 12;
    }

    @Override
    public void printFinancingData(){
        System.out.println("Type  of financing: House");
        System.out.println("House area: " + getHouseArea() + "m²");
        System.out.println("Number of garage space: " + getLandArea() + "m²");
        System.out.println("Property value: R$ " + NumberFormat.getCurrencyInstance().format(getPropertyValue()));
        System.out.println("Financing term: " + this.financingTerm  + " year(s)");
        System.out.println("Annual interest rate: " +  this.annualInterestRate + '%'); //NumberFormat.getPercentInstance().format(this.annualInterestRate)
        System.out.println("Monthly payment of financing: R$ " + NumberFormat.getCurrencyInstance().format(calcMonthlyPayment()));
        System.out.println("Total payment of financing: R$ " + NumberFormat.getCurrencyInstance().format(calcTotalPayment()));
    }
}
