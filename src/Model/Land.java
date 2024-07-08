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

    @Override
    public double calcTotalPayment(){
        return calcMonthlyPayment() * getFinancingTerm() * 12;
    }

    @Override
    public void printFinancingData(){
        System.out.println("Type  of financing: Land");
        System.out.println("Area type: " + getAreaType());
        System.out.println("Property value: R$ " + NumberFormat.getCurrencyInstance().format(getPropertyValue()));
        System.out.println("Financing term: " + getFinancingTerm()  + " year(s)");
        System.out.println("Annual interest rate: " +  getAnnualInterestRate() + '%'); //NumberFormat.getPercentInstance().format(this.annualInterestRate)
        System.out.println("Monthly payment of financing: R$ " + NumberFormat.getCurrencyInstance().format(calcMonthlyPayment()));
        System.out.println("Total payment of financing: R$ " + NumberFormat.getCurrencyInstance().format(calcTotalPayment()));
    }

    // string builder method to file writer
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type  of financing: Land\n");
        stringBuilder.append("Area type: ").append(getAreaType()).append('\n');
        stringBuilder.append("Property value: R$ ").append(NumberFormat.getCurrencyInstance().format(getPropertyValue())).append('\n');
        stringBuilder.append("Financing term: ").append(getFinancingTerm()).append(" year(s)\n");
        stringBuilder.append("Annual interest rate: ").append(getAnnualInterestRate()).append("%\n");
        stringBuilder.append("Monthly payment of financing: R$ ").append(NumberFormat.getCurrencyInstance().format(calcMonthlyPayment())).append("\n");
        stringBuilder.append("Total payment of financing: R$ ").append(NumberFormat.getCurrencyInstance().format(calcTotalPayment())).append("\n").append("\n");

        return stringBuilder.toString();
    }
}
