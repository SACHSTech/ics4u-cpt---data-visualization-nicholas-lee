package data_app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

public class Main extends Application {

    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(Charts.theLineChart()));
        primaryStage.show();
    }

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

        if (strChoice.equals("3")) {
            System.out.println("Filter by year - 1 \nFilter by continent -2 \nFilter by both - 3");
            System.out.print("Enter Choice: ");
            String strFilterChoice = key.readLine();

            if (strFilterChoice.equals("1")) {
                System.out.print("Enter year (1997, 2007, or 2017): ");
                int intYear = Integer.parseInt(key.readLine());
                Searching.yearFilterSearch(countries, intYear);

            } else if (strFilterChoice.equals("2")) {
                System.out.print("Enter continent (Africa, Asia, Europe, North America, South America, Oceania): ");
                String strCont = key.readLine();
                Searching.contFilterSearch(countries, strCont);

            } else if (strFilterChoice.equals("3")) {
                System.out.print("Enter year (1997, 2007, or 2017): ");
                int intYear = Integer.parseInt(key.readLine());
                System.out.print("Enter continent (Africa, Asia, Europe, North America, South America, Oceania): ");
                String strCont = key.readLine();
                Searching.twoFilterSearch(countries, intYear, strCont);
            }
        }

        if (strChoice.equals("4")) {
            System.out.println("To view an individual record please enter the name of the country and year");
            System.out.print("Enter country name  (Case Sensitive - E.g. Canada): ");
            String strName = key.readLine();
            System.out.print("Enter year (1997, 2007, or 2017): ");
            int intYear = Integer.parseInt(key.readLine());
            Searching.individualSearch(countries, strName, intYear);
        }

        if (strChoice.equals("5")) {
            System.out.println("---------------Summary Report---------------");
            System.out.println("Total number of records: " + countries.length);
            System.out.println("Total number of countries: " + (countries.length/3));
            System.out.println("Average HDI (1997): " + Average.yearAverage(countries, 1997));
            System.out.println("Average HDI (2007): " + Average.yearAverage(countries, 2007));
            System.out.println("Average HDI (2017): " + Average.yearAverage(countries, 2017));
            System.out.println("Average HDI (All Three Years): " + Average.totalAverage(countries));
            Sorting.sortMaxHDI(countries);
            System.out.println("Highest HDI: " + countries[0]);
            Sorting.sortMinHDI(countries);
            System.out.println("Lowest HDI: " + countries[0]);
            System.out.println("Median: " + countries[countries.length/2]);
        }

        if (strChoice.equals("6")) {
            System.out.println("For bar chart - 1 \nFor line chart - 2");
            String strSearchChoice = key.readLine();
            if (strSearchChoice.equals("1")) {
                launch(args);
            }

            if (strSearchChoice.equals("2")) {

            }


        }

    }

}
