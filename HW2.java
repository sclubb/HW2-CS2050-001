/*
 * Steven Clubb
 * 9/8/2017
 * CS2050-001
 */
package hw2;

import java.io.FileNotFoundException;
import java.io.File;
import java.net.URL;
import java.util.Scanner;

/**
 * <h1>H2 - Homework assignment for CS2050</h1>
 * This program will first create a linkedlist with data from the given file,
 * then it will create an array matching the length of the linked list.
 * After it will populate the array with the data from the linked list and use 
 * the array to find the necessary data to display.
 * 
 * @author Steven Clubb
 * @since 9/8/2017
 */
public class HW2 {

    private static final int POPULATION_LIMIT = 35000000;

    Countries[] countryArray;
    CountryLL countryLL;

    /**
     * Main method for HW2
     * @param args Calling arguments
     */
    public static void main(String[] args) {
        //Create a new object of HW2 to reference non static methods.
        HW2 hw = new HW2();
        int chosenNum = hw.inputFromUser();
        while (chosenNum != 5) {
            //After recieving number from user, number will determine which case is used.
            switch (chosenNum) {
                case 1:
                    hw.readCountries();
                    break;
                case 2:
                    hw.outputBorderingCountries();
                    break;
                case 3:
                    hw.outputExceedsPopulation(POPULATION_LIMIT);
                    break;
                case 4:
                    hw.outputBorderingExceedsPopulation(POPULATION_LIMIT);
                    break;
                default:
                    break;
            }
            //Loops back to prompt user
            chosenNum = hw.inputFromUser();

        }
    }

    /**
     * Reads (imports) countries from a file
     */
    private void readCountries() {
        try {
            //this will try to obtain file through a search, and with file name.
            URL url = getClass().getResource("countries_data.txt");
            File file = new File(url.getPath());
            //Make file the input scanner
            Scanner f = new Scanner(file);
            //Loop through file using a seperater and will assign values from file to array.
            while (f.hasNextLine()) {

                String line = f.nextLine();
                String[] items = line.split(", ");
                Countries country = new Countries();
                country.countryName = items[0];
                country.latitude = items[1];
                country.longitude = items[2];
                country.countryArea = Integer.parseInt(items[3]);
                country.countryPopulation = Integer.parseInt(items[4]);
                country.countryGDP = Double.parseDouble(items[5]);
                country.countryYear = Integer.parseInt(items[6]);
                
                //Sets the null linkedlist to new data incoming 
                //After it's no longer null, the next time around it will add 
                //new data to the next linkedlist.
                if (countryLL == null) {
                    countryLL = new CountryLL(country);
                } else {
                    countryLL = countryLL.add(country);
                }
            }

            //Count the linkedlist, create new array with length of linked list
            //then populate new array with data from linkedlist
            int num = countryLL.countItems();
            this.countryArray = new Countries[num];
            CountryLL ll = countryLL;
            for (int i = 0; i < num; i++) {
                countryArray[i] = ll.country;
                ll = ll.next;
            }
        } 
        catch (FileNotFoundException e) {
        }
    }

    /**
     * Prompt from user
     * Gives options to user and will return number entered by user.
     * @return 
     */
    int inputFromUser() {

        int choice = 0;
        Scanner kb = new Scanner(System.in);
        while (choice < 1 || choice > 5) {
            System.out.println("Please choose one of the following options.");
            System.out.println("1. Import the data");
            System.out.println("2. Display list of all countries that border Germany");
            System.out.println("3. Display list of all countries that have a population greater than 35 million");
            System.out.println("4. Display list of all countries that border Germany AND"
                    + "have a population greater than 35 million");
            System.out.println("5. Quit the program");

            choice = kb.nextInt();
            if (choice > 5 || choice < 1) {
                System.out.println("Please enter a valid number. 1 - 5");
            }
        }
        return choice;
    }

    //Method prints out countries that border Germany, and that have over 35 million population
    void outputBorderingExceedsPopulation(int population) {
        boolean doesBorder;
        Borders b = new Borders();
        for (Countries cntry : countryArray) {
            doesBorder = b.isBordering("Germany", cntry.countryName);
            if (doesBorder && cntry.countryPopulation > population) {
                System.out.println(cntry.countryName + "  " + cntry.countryPopulation);
            }
        }
        //Clean output
        System.out.print("\n");
    }

    //Method to find countries with over 35 million population
    void outputExceedsPopulation(int population) {
        for (Countries cntry : countryArray) {
            if (cntry.countryPopulation > population) {
                System.out.println(cntry.countryName + "  " + cntry.countryPopulation);
            }
        }
        //To make output look cleaner.
        System.out.print("\n");
    }

    //Method to display countries that border Germany
    void outputBorderingCountries() {
        boolean doesBorder;
        Borders b = new Borders();

        for (Countries cntry : countryArray) {
            doesBorder = b.isBordering("Germany", cntry.countryName);
            if (doesBorder) {
                System.out.println(cntry.countryName);
            }
        }
        //Clean output
        System.out.print("\n");
    }

}
