public class Main {
    public static void main(String[] args) {
        InterfaceUser interfaceUser = new InterfaceUser();

        double propertyValue = interfaceUser.getPropertyValue();
        int financingTerm = interfaceUser.getFinancingTerm();
        double annualInterestRate = interfaceUser.getAnnualInterestRate();

        Financing financing = new Financing(propertyValue, financingTerm, annualInterestRate);

        double monthlyPayment = financing.calcMonthlyPayment();
        double totalPayment = financing.calcTotalPayment();

        System.out.println("Monthly payment: " + monthlyPayment);
        System.out.println("Total payment: " + totalPayment);
    }
}