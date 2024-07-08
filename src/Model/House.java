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
        System.out.println("Land area: " + getLandArea() + "m²");
        System.out.println("Property value: R$ " + NumberFormat.getCurrencyInstance().format(getPropertyValue()));
        System.out.println("Financing term: " + this.financingTerm  + " year(s)");
        System.out.println("Annual interest rate: " +  this.annualInterestRate + '%'); //NumberFormat.getPercentInstance().format(this.annualInterestRate)
        System.out.println("Monthly payment of financing: R$ " + NumberFormat.getCurrencyInstance().format(calcMonthlyPayment()));
        System.out.println("Total payment of financing: R$ " + NumberFormat.getCurrencyInstance().format(calcTotalPayment()));
    }

    // string builder method to file writer
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type  of financing: Land\n");
        stringBuilder.append("House area: ").append(getHouseArea()).append("m²\n");
        stringBuilder.append("Land area: ").append(getLandArea()).append("m²\n");
        stringBuilder.append("Property value: R$ ").append(NumberFormat.getCurrencyInstance().format(getPropertyValue())).append('\n');
        stringBuilder.append("Financing term: ").append(getFinancingTerm()).append(" year(s)\n");
        stringBuilder.append("Annual interest rate: ").append(getAnnualInterestRate()).append("%\n");
        stringBuilder.append("Monthly payment of financing: R$ ").append(NumberFormat.getCurrencyInstance().format(calcMonthlyPayment())).append("\n");
        stringBuilder.append("Total payment of financing: R$ ").append(NumberFormat.getCurrencyInstance().format(calcTotalPayment())).append("\n").append("\n");

        return stringBuilder.toString();
    }
}
