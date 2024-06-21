package Model;

public class Home extends Financing {

    public Home(double propertyValue, int financingTerm, double annualInterestRate){
        super(propertyValue, financingTerm, annualInterestRate);
    }

    @Override
    public double calcMonthlyPayment(){
        return super.calcMonthlyPayment() + 80;
    }
}
