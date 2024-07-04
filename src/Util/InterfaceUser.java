package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.InputNegativeValueException;

public class InterfaceUser {
    Scanner scanner = new Scanner(System.in);

    private void validation(double value, String errorMessage) throws InputNegativeValueException{
        if (value <= 0) {
            throw new InputNegativeValueException(errorMessage);
        }
    }

    public double inputPropertyValue(){
        double value = 0;
        do{
            System.out.println("Enter the Property Value: ");
            try{
                value = scanner.nextDouble();
                validation(value, "Please enter a positive value for the Property Value.");
            }catch (InputMismatchException exception){
                System.out.println("Invalid input. Please enter a numeric value for the Property Value.");
                scanner.next();
            } catch (InputNegativeValueException exception) {
                System.out.println(exception.getMessage());
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
                validation(term, "Please enter a positive value for the Financing Term.");
            } catch (InputMismatchException exception){
                System.out.println("Invalid input. Please enter an integer value for the Financing Term.");
                scanner.next();
            } catch (InputNegativeValueException exception) {
                System.out.println(exception.getMessage());
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
                validation(rate, "Please enter a positive value for the Annual Interest Rate.");
            } catch (InputMismatchException exception){
                System.out.println("Invalid input. Please enter a numeric value for the Annual Interest Rate.");
                scanner.next();
            } catch (InputNegativeValueException exception) {
                System.out.println(exception.getMessage());
            }

        } while (rate <= 0);
        return rate;
    }
}
