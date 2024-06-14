package Model;

import java.text.NumberFormat;

public class Financing {
    private double propertyValue;   // valor do imóvel
    private int financingTerm;  // prazo do financiamento
    private double annualInterestRate;  // taxa de juros anual

    public double getPropertyValue(){
        return this.propertyValue;
    }

    public int getFinancingTerm(){
        return this.financingTerm;
    }

    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }

    public Financing(double propertyValue, int financingTerm, double annualInterestRate){
        this.propertyValue = propertyValue;
        this.financingTerm = financingTerm;
        this.annualInterestRate = annualInterestRate;
    }

    public double calcMonthlyPayment(){
        return (this.propertyValue / (this.financingTerm * 12)) * (1 + this.annualInterestRate / 12);
        //return this.propertyValue / (this.financingTerm * 12) * (1 + (this.annualInterestRate / 100) / 12);
    }

    public double calcTotalPayment(){
        return this.calcMonthlyPayment() * this.financingTerm * 12;
    }

    public void showFinancingData(){
        System.out.println("Property value: R$ " + NumberFormat.getCurrencyInstance().format(this.propertyValue));
        System.out.println("Financing term: " + this.financingTerm  + " year(s)");
        System.out.println("Annual interest rate: " +  this.annualInterestRate + '%'); //NumberFormat.getPercentInstance().format(this.annualInterestRate)
        System.out.println("Monthly payment of financing: R$ " + NumberFormat.getCurrencyInstance().format(calcMonthlyPayment()));
        System.out.println("Total payment of financing: R$ " + NumberFormat.getCurrencyInstance().format(calcTotalPayment()));
    }
}
