package Model;

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
        return propertyValue / (financingTerm * 12) * (1 + annualInterestRate / 12);
    }

    public double calcTotalPayment(){
        return this.calcMonthlyPayment() * financingTerm * 12;
    }

    public void showFinancingData(){
        System.out.println("Property value: " + this.propertyValue);
        System.out.println("Financing term: " + this.financingTerm);
        System.out.println("Annual interest rate: " + this.annualInterestRate);
        System.out.println("Monthly payment of financing: " + calcMonthlyPayment());
        System.out.println("Total payment of financing: " + calcTotalPayment());
    }
}
