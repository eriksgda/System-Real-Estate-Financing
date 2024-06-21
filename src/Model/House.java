package Model;

public class House extends Financing {


    public House(double propertyValue, int financingTerm, double annualInterestRate){
        super(propertyValue, financingTerm, annualInterestRate);
    }

    @Override
    public double calcMonthlyPayment(){
        return super.calcMonthlyPayment() + 80;
    }
}
