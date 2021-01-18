package data_app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException{

        BufferedReader data = new BufferedReader(new FileReader("HDI.csv"));
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));

		String strLine = "";
        String splitBy = ",";

        String name;
        String cont;
        int year;
        double HDI;
        Country country;

        int intCount = 0;

        Country[] countries = new Country[441];

        while(intCount < 441){

            strLine = data.readLine();
            String[] elements = strLine.split(splitBy);

            name = elements[0];
            cont = elements[1];
            year = Integer.parseInt(elements[2]);
            HDI = Double.parseDouble(elements[3]);

            country = new Country(name, cont, year, HDI);
            countries[intCount] = country;

            intCount++;
        }
        data.close();


        System.out.println("\nWelcome to the Human Development Index (HDI) App");
        System.out.println("Please select one of the options below: ");
        System.out.println("\nView Data Sorted by HDI Value - 1");
        System.out.println("Search and View a Data Entry Based on a Key - 2");
        System.out.println("View Data with Filters - 3");
        System.out.println("View an Individual Record - 4");
        System.out.println("View Summary Report - 5");
        System.out.println("View Charts - 6");

        System.out.print("Enter Choice: ");
        String strChoice = key.readLine();

        if (strChoice.equals("1")) {
            System.out.println("For lowest to highest HDI Value - 1 \nFor highest to lowest HDI Value - 2");
            String strSearchChoice = key.readLine();

            if (strSearchChoice.equals("1")) {
                Sorting.sortMinHDI(countries);
                System.out.println("\n Name   Continent  Year  HDI");
                for (int i = 0; i < countries.length; i++) {
                    System.out.println(countries[i]);
                }
            }

            if (strSearchChoice.equals("2")) {
                Sorting.sortMaxHDI(countries);
                System.out.println("\n Name   Continent  Year  HDI");
                for (int i = 0; i < countries.length; i++) {
                    System.out.println(countries[i]);
                }
            }
        }

        if (strChoice.equals("2")) {
            System.out.println("Please enter the name of the country (Case Sensitive - E.g. Canada)");
            System.out.print("Enter Key: ");
            String strKey = key.readLine();
            Searching.nameSearch(countries, strKey);
        }


    }

}
