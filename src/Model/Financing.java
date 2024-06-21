package Model;

public abstract class Financing {
    protected double propertyValue;   // valor do imóvel
    protected int financingTerm;  // prazo do financiamento
    protected double annualInterestRate;  // taxa de juros anual

    // constructor
    public Financing(double propertyValue, int financingTerm, double annualInterestRate){
        this.propertyValue = propertyValue;
        this.financingTerm = financingTerm;
        this.annualInterestRate = annualInterestRate;
    }

    // getters
    public double getPropertyValue(){
        return this.propertyValue;
    }

    public int getFinancingTerm(){
        return this.financingTerm;
    }

    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }

    // other methods
    public double calcMonthlyPayment(){
        return (getPropertyValue() / (getFinancingTerm() * 12)) * (1 + (getAnnualInterestRate() / 100) / 12);
    }

    public abstract double calcTotalPayment();

    public abstract void printFinancingData();
}
