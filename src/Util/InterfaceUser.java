package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUser {
    Scanner scanner = new Scanner(System.in);

    public double inputPropertyValue(){
        double value = 0;
        do{
            System.out.println("Enter the Property Value: ");
            try{
                value = scanner.nextDouble();
                if (value <= 0) {
                    System.out.println("Please enter a positive value for the Property Value.");
                }
            }catch (InputMismatchException exception){
                System.out.println("Invalid input. Please enter a numeric value for the Property Value.");
                scanner.next();
            }
        }while (value <= 0);
        return value;
    }

    public int inputFinancingTerm(){
        int term = 0;
        do{
            System.out.println("Enter the Financing Term: ");
            try {
                term = scanner.nextInt();
                if (term <= 0){
                    System.out.println("Please enter a positive value for the Financing Term.");
                }
            } catch (InputMismatchException exception){
                System.out.println("Invalid input. Please enter an integer value for the Financing Term.");
                scanner.next();
            }
        } while (term <= 0);
        return term;
    }

    public double inputAnnualInterestRate(){
        double rate = 0;
        do {
            System.out.println("Enter the Annual Interest Rate: ");
            try {
                rate = scanner.nextDouble();
                if (rate <= 0){
                    System.out.println("Please enter a positive value for the Annual Interest Rate.");
                }
            } catch (InputMismatchException exception){
                System.out.println("Invalid input. Please enter a numeric value for the Annual Interest Rate.");
                scanner.next();
            }
        } while (rate <= 0);
        return rate;
    }
}
