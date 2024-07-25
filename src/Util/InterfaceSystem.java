package Util;

import java.util.InputMismatchException;
import java.util.Scanner;

import Exceptions.InputNegativeValueException;

public class InterfaceSystem {
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
                    [4] EXIT
                    R:\s""");
            try{
                value = scanner.nextInt();
                validation(value, "Please enter 1, 2, 3 or 4 for the Financing Type.");
            }catch (InputMismatchException exception){
                System.out.println("Invalid input. Please enter a numeric value for the Financing Type.");
                scanner.next();
            } catch (InputNegativeValueException exception) {
                System.out.println(exception.getMessage());
            }

        }while (value != 1 && value != 2 && value != 3 && value != 4);
        return value;
    }
}