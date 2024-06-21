package Model;

import java.text.NumberFormat;

public class Financing {
    protected double propertyValue;   // valor do imóvel
    protected int financingTerm;  // prazo do financiamento
    protected double annualInterestRate;  // taxa de juros anual

    public Financing(double propertyValue, int financingTerm, double annualInterestRate){
        this.propertyValue = propertyValue;
        this.financingTerm = financingTerm;
        this.annualInterestRate = annualInterestRate;
    }

    public double getPropertyValue(){
        return this.propertyValue;
    }

    public int getFinancingTerm(){
        return this.financingTerm;
    }

    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }

    public double calcMonthlyPayment(){
        return (getPropertyValue() / (getFinancingTerm() * 12)) * (1 + (getAnnualInterestRate() / 100) / 12);
    }

    public double calcTotalPayment(){
        return calcMonthlyPayment() * getFinancingTerm() * 12;
    }

    public void printFinancingData(){
        System.out.println("Property value: R$ " + NumberFormat.getCurrencyInstance().format(getPropertyValue()));
        System.out.println("Financing term: " + this.financingTerm  + " year(s)");
        System.out.println("Annual interest rate: " +  this.annualInterestRate + '%'); //NumberFormat.getPercentInstance().format(this.annualInterestRate)
        System.out.println("Monthly payment of financing: R$ " + NumberFormat.getCurrencyInstance().format(calcMonthlyPayment()));
        System.out.println("Total payment of financing: R$ " + NumberFormat.getCurrencyInstance().format(calcTotalPayment()));
    }
}
