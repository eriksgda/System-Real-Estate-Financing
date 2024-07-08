package Main;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;

import Model.*;
import Util.*;

// Professor, estava tentando fazer com o objectInputStream e o append = true, porém dava erro na leitura, a forma que encontrei para
// arrumar me pareceu longo demais (https://www.geeksforgeeks.org/how-to-fix-java-io-streamcorruptedexception-invalid-type-code-in-java/),
// então, optei por fazer sem o append = true, passando os dados do arquivo pra uma arraylist e depois sobrescrevendo por cima,
// ou seja, peguei os dados adicionei os novos e escrevi todos desde o começo no mesmo arquivo. Acredito que não é a melhor forma, já
// que quando se inicializa o programa, caso não exista o arquivo, vai dar o erro de FileNotFoundException, ainda assim, acredito
// que cumpra todos os requisitos pedidos no projeto.

public class Main {
    // write method (ObjectOutputStream)
    public static void writeFinancing(String fileName, ArrayList<Financing> financingList){
        ObjectOutputStream outputStream;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(fileName));

            for (Financing financing : financingList){
                outputStream.writeObject(financing);
            }

            outputStream.flush();
            outputStream.close();
        } catch(IOException exception){
            System.out.println(exception.getMessage());
        }
    }
    // read method (ObjectInputStream)
    public static ArrayList<Financing> readFinancing(String fileName) {
        ObjectInputStream inputStream;
        ArrayList<Financing> financingList = new ArrayList<>();

        try {
            inputStream = new ObjectInputStream(new FileInputStream(fileName));
            Object supportObject;

            while ((supportObject = inputStream.readObject()) != null) {
                if (supportObject instanceof Financing) {
                    financingList.add((Financing) supportObject);
                }
            }
            inputStream.close();

        } catch (EOFException | FileNotFoundException exception) {
            System.out.println();
        } catch (ClassNotFoundException | IOException exception) {
            System.out.println(exception.getMessage());
        }

        return financingList;
    }

    // write method (FileWriter)
    public static void writeFile(String fileName, Financing financing){
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(fileName, true);

            fileWriter.write(financing.toString());

            fileWriter.flush();
            fileWriter.close();
        }catch (IOException exception){
            System.out.println();
        }
    }

    // read method (FileReader)
    public static void readFile(String fileName){
        FileReader fileReader;
        try {
            fileReader = new FileReader(fileName);
            int counter;
            while((counter = fileReader.read()) != -1){
                System.out.print((char)counter);
            }

            fileReader.close();
        } catch (FileNotFoundException exception){
            System.out.println();
        } catch (IOException exception){
            System.out.println(exception.getMessage());
        }

    }

    public static void createSomeFinancing(ArrayList<Financing> financingList){
        Financing secondApartmentFinancing = new Apartment(1000000,15,
                10, 50, 13);
        financingList.add(secondApartmentFinancing);

        Financing firstHomeFinancing = new House(500000, 10, 10, 80, 165.3);
        financingList.add(firstHomeFinancing);

        Financing secondHomeFinancing = new House(1500000, 5, 12, 44, 97.6);
        financingList.add(secondHomeFinancing);

        Financing firstLandFinancing = new Land(2000000, 22,20, "Commercial");
        financingList.add(firstLandFinancing);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Financing Simulator!");

        //variables
        String fileName = "src/financing.test";
        String fileNameTxt = "src/financing.txt";
        double totalPropertyValue = 0;
        double totalFinancingValue = 0;
        double propertyValue;
        int financingTerm;
        double annualInterestRate;

        ArrayList<Financing> financingList = readFinancing(fileName); // Arraylist for .test
        ArrayList<Financing> financingListTxt = new ArrayList<>(); // ArrayList for .txt

        InterfaceUser interfaceUser = new InterfaceUser();

        int financingType = interfaceUser.inputFinancingType();
        switch (financingType){
            case 1: // apartment
                propertyValue = interfaceUser.inputPropertyValue();
                financingTerm = interfaceUser.inputFinancingTerm();
                annualInterestRate = interfaceUser.inputAnnualInterestRate();
                int garageSpace = interfaceUser.inputGarageSpace();
                int floorNumber = interfaceUser.inputFloorNumber();

                Financing apartmentFinancing = new Apartment(propertyValue, financingTerm, annualInterestRate, garageSpace, floorNumber);
                financingList.add(apartmentFinancing);
                financingListTxt.add(apartmentFinancing);

                break;
            case 2: // house
                propertyValue = interfaceUser.inputPropertyValue();
                financingTerm = interfaceUser.inputFinancingTerm();
                annualInterestRate = interfaceUser.inputAnnualInterestRate();
                double houseArea = interfaceUser.inputHouseArea();
                double landArea = interfaceUser.inputLandArea();

                Financing houseFinancing = new House(propertyValue, financingTerm, annualInterestRate, houseArea, landArea);
                financingList.add(houseFinancing);
                financingListTxt.add(houseFinancing);
                break;
            case 3: // land
                propertyValue = interfaceUser.inputPropertyValue();
                financingTerm = interfaceUser.inputFinancingTerm();
                annualInterestRate = interfaceUser.inputAnnualInterestRate();
                boolean areaType = interfaceUser.inputAreaType();

                Financing landFinancing = new Land(propertyValue, financingTerm, annualInterestRate, (areaType ? "Residential" : "Commercial"));
                financingList.add(landFinancing);
                financingListTxt.add(landFinancing);
                break;
        }

        createSomeFinancing(financingList);
        createSomeFinancing(financingListTxt);

        // Object Input/Output Stream
        writeFinancing(fileName, financingList);
        ArrayList<Financing> financingListData = readFinancing(fileName);

        System.out.println("-> Print with Object Input Stream (.test):\n");

        for (Financing financing : financingListData){
            financing.printFinancingData();
            System.out.println();

            totalPropertyValue += financing.getPropertyValue();
            totalFinancingValue += financing.calcTotalPayment();
        }

        // File Writer/Reader
        System.out.println("-> Print with File Reader (.txt): \n");

        for (Financing financing : financingListTxt){
            writeFile(fileNameTxt, financing);
        }

        readFile(fileNameTxt);

        System.out.printf("\nTotal property value: %s Total Financing Value: %s",
                NumberFormat.getCurrencyInstance().format(totalPropertyValue),
                NumberFormat.getCurrencyInstance().format(totalFinancingValue));

    }
}