public class Financing {
    double propertyValue;
    int financingTerm;
    double annualInterestRate;

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
}
