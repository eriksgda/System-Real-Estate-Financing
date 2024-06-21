package Model;

public class Apartment extends Financing {

    public Apartment(double propertyValue, int financingTerm, double annualInterestRate){
        super(propertyValue, financingTerm, annualInterestRate);
    }

    @Override
    public double calcMonthlyPayment(){
        double months = getFinancingTerm() * 12;
        double monthInterestRate = (getAnnualInterestRate() / 100) /12;

        // return (getPropertyValue() * Math.pow((1+monthInterestRate), months))/Math.pow((1+monthInterestRate), months - 1);
        return (getPropertyValue() * monthInterestRate) / (1 - Math.pow((1 + monthInterestRate), -months));
    }
}
