package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.InputNegativeValueException;

public class InterfaceUser {
    Scanner scanner = new Scanner(System.in);

    //validation method
    private void validation(double value, String errorMessage) throws InputNegativeValueException{
        if (value <= 0) {
            throw new InputNegativeValueException(errorMessage);
        }
    }

    // input financing type method
    public int inputFinancingType(){
        int value = 0;
        do{
            System.out.println("""
                    Enter the Financing Type:\s
                    [1] APARTMENT
                    [2] HOUSE
                    [3] LAND
                    R:\s""");
            try{
                value = scanner.nextInt();
                validation(value, "Please enter 1, 2 or 3 for the Financing Type.");
            }catch (InputMismatchException exception){
                System.out.println("Invalid input. Please enter a numeric value for the Financing Type.");
                scanner.next();
            } catch (InputNegativeValueException exception) {
                System.out.println(exception.getMessage());
            }

        }while (value != 1 && value != 2 && value != 3);
        return value;
    }

    // input property value method (for all financing)
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

    // input financing term method (for all financing)
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

    // input annual interest rate method (for all financing)
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

    // input garage space method (only apartment)
    public int inputGarageSpace(){
        int value = 0;
        do{
            System.out.println("Enter the Garage Space: ");
            try{
                value = scanner.nextInt();
                validation(value, "Please enter a positive value for the Garage Space.");
            }catch (InputMismatchException exception){
                System.out.println("Invalid input. Please enter a numeric value for the Garage Space.");
                scanner.next();
            } catch (InputNegativeValueException exception) {
                System.out.println(exception.getMessage());
            }

        }while (value <= 0);
        return value;
    }

    // input floor number method (only apartment)
    public int inputFloorNumber(){
        int value = 0;
        do{
            System.out.println("Enter the Floor Number: ");
            try{
                value = scanner.nextInt();
                validation(value, "Please enter a positive value for the Floor Number.");
            }catch (InputMismatchException exception){
                System.out.println("Invalid input. Please enter a numeric value for the Floor Number.");
                scanner.next();
            } catch (InputNegativeValueException exception) {
                System.out.println(exception.getMessage());
            }

        }while (value <= 0);
        return value;
    }

    // input house area method (only house)
    public double inputHouseArea(){
        double value = 0;
        do{
            System.out.println("Enter the House Area: ");
            try{
                value = scanner.nextDouble();
                validation(value, "Please enter a positive value for the House Area.");
            }catch (InputMismatchException exception){
                System.out.println("Invalid input. Please enter a numeric value for the House Area.");
                scanner.next();
            } catch (InputNegativeValueException exception) {
                System.out.println(exception.getMessage());
            }

        }while (value <= 0);
        return value;
    }

    // input land area method (only house)
    public double inputLandArea(){
        double value = 0;
        do{
            System.out.println("Enter the Land Area: ");
            try{
                value = scanner.nextDouble();
                validation(value, "Please enter a positive value for the Land Area.");
            }catch (InputMismatchException exception){
                System.out.println("Invalid input. Please enter a numeric value for the Land Area.");
                scanner.next();
            } catch (InputNegativeValueException exception) {
                System.out.println(exception.getMessage());
            }

        }while (value <= 0);
        return value;
    }

    // input area type method (only land)
    public boolean inputAreaType(){
        int value = 0;
        do{
            System.out.println("""
                    Enter the Area Type:\s
                    [1] RESIDENTIAL
                    [2] COMMERCIAL
                    R:\s""");
            try{
                value = scanner.nextInt();
                validation(value, "Please enter 1 or 2 for the Area Type.");
            }catch (InputMismatchException exception){
                System.out.println("Invalid input. Please enter a numeric value for the Area Type.");
                scanner.next();
            } catch (InputNegativeValueException exception) {
                System.out.println(exception.getMessage());
            }

        }while (value != 1 && value != 2);
        return value == 1 ? true : false;
    }
}
