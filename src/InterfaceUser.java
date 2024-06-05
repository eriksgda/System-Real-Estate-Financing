import java.util.Scanner;

public class InterfaceUser {
    Scanner scanner = new Scanner(System.in);

    public double getPropertyValue(){
        System.out.println("Enter the Property Value: ");
        return scanner.nextDouble();
    }

    public int getFinancingTerm(){
        System.out.println("Enter the Financing Term: ");
        return scanner.nextInt();
    }

    public double getAnnualInterestRate(){
        System.out.println("Enter the Annual Interest Rate: ");
        return scanner.nextDouble();
    }
}
