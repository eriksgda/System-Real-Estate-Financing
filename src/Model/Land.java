package Model;

public class Land extends Financing{

    public Land(double propertyValue, int financingTerm, double annualInterestRate){
        super(propertyValue, financingTerm, annualInterestRate);
    }

    @Override
    public double calcMonthlyPayment(){
        return super.calcMonthlyPayment() * 1.02;
    }
}
