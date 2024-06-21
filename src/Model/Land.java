package Model;

import java.text.NumberFormat;

public class Land extends Financing{
    // attributes
    private String areaType;

    // constructor
    public Land(double propertyValue, int financingTerm, double annualInterestRate, String areaType){
        super(propertyValue, financingTerm, annualInterestRate);
        this.areaType = areaType;
    }

    // getters
    public String getAreaType() {
        return areaType;
    }

    // other methods
    @Override
    public double calcMonthlyPayment(){
        return super.calcMonthlyPayment() * 1.02;
    }

    public double calcTotalPayment(){
        return calcMonthlyPayment() * getFinancingTerm() * 12;
    }

    public void printFinancingData(){
        System.out.println("Type  of financing: Land");
        System.out.println("Area type: " + getAreaType());
        System.out.println("Property value: R$ " + NumberFormat.getCurrencyInstance().format(getPropertyValue()));
        System.out.println("Financing term: " + this.financingTerm  + " year(s)");
        System.out.println("Annual interest rate: " +  this.annualInterestRate + '%'); //NumberFormat.getPercentInstance().format(this.annualInterestRate)
        System.out.println("Monthly payment of financing: R$ " + NumberFormat.getCurrencyInstance().format(calcMonthlyPayment()));
        System.out.println("Total payment of financing: R$ " + NumberFormat.getCurrencyInstance().format(calcTotalPayment()));
    }
}
