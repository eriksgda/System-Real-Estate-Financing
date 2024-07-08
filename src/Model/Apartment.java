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

    @Override
    public double calcTotalPayment(){
        return calcMonthlyPayment() * getFinancingTerm() * 12;
    }

    @Override
    public void printFinancingData(){
        System.out.println("Type  of financing: Apartment");
        System.out.println("Floor number: " + getFloorNumber());
        System.out.println("Number of garage space: " + getGarageSpace());
        System.out.println("Property value: " + NumberFormat.getCurrencyInstance().format(getPropertyValue()));
        System.out.println("Financing term: " + this.financingTerm  + " year(s)");
        System.out.println("Annual interest rate: " +  this.annualInterestRate + '%'); //NumberFormat.getPercentInstance().format(this.annualInterestRate)
        System.out.println("Monthly payment of financing: " + NumberFormat.getCurrencyInstance().format(calcMonthlyPayment()));
        System.out.println("Total payment of financing: " + NumberFormat.getCurrencyInstance().format(calcTotalPayment()));
    }

    // string builder method to file writer
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Type  of financing: Apartment\n");
        stringBuilder.append("Floor number: ").append(getFloorNumber()).append('\n');
        stringBuilder.append("Number of garage space: ").append(getGarageSpace()).append('\n');
        stringBuilder.append("Property value: ").append(NumberFormat.getCurrencyInstance().format(getPropertyValue())).append('\n');
        stringBuilder.append("Financing term: ").append(getFinancingTerm()).append(" year(s)\n");
        stringBuilder.append("Annual interest rate: ").append(getAnnualInterestRate()).append("%\n");
        stringBuilder.append("Monthly payment of financing: ").append(NumberFormat.getCurrencyInstance().format(calcMonthlyPayment())).append("\n");
        stringBuilder.append("Total payment of financing: ").append(NumberFormat.getCurrencyInstance().format(calcTotalPayment())).append("\n").append("\n");

        return stringBuilder.toString();
    }
}
