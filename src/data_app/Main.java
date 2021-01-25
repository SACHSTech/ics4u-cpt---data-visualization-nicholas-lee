package data_app;

// Import statements
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    // Initialize static variables for charts
    static int intChart;
    static double dblCan1997;
    static double dblCan2007;
    static double dblCan2017;
    static double dblWorld1997;
    static double dblWorld2007;
    static double dblWorld2017;

    public static void main(String[] args) throws IOException {

        // Initialize variables
        String strLine = "";
        String splitBy = ",";
        String name;
        String cont;
        String strChoice = "1";
        int year;
        int intCount = 0;
        double HDI;
        Country country;

        // Array that holds the country instances
        Country[] countries = new Country[441];

        // Allows for the reading of the CSV file
        BufferedReader data = new BufferedReader(new FileReader("HDI.csv"));

        // Allows for input to be taken from the user
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));

        // The while loop runs for the whole data set
        while (intCount < 441) {

            // Reads the CSV file and creates an array
            strLine = data.readLine();
            String[] elements = strLine.split(splitBy);

            // Each element from the array represents an attribute of a country
            name = elements[0];
            cont = elements[1];
            year = Integer.parseInt(elements[2]);
            HDI = Double.parseDouble(elements[3]);

            // Creates a country object and puts the object into an array
            country = new Country(name, cont, year, HDI);
            countries[intCount] = country;

            intCount++;
        }

        // Closes file
        data.close();

        // Main menu options are presented
        System.out.println("\nWelcome to the Human Development Index (HDI) App");
        System.out.println("Please select one of the options below: ");
        System.out.println("\nView Data Sorted by HDI Value - 1");
        System.out.println("Search and View a Data Entry Based on a Key - 2");
        System.out.println("View Data with Filters - 3");
        System.out.println("View an Individual Record - 4");
        System.out.println("View Summary Report - 5");
        System.out.println("View Charts - 6");
        System.out.println("\nEnter any other key to exit");

        // Allows the user to select and view the options as many times as they want
        while (strChoice.equals("1") || strChoice.equals("2") || strChoice.equals("3")|| strChoice.equals("4") || strChoice.equals("5") || strChoice.equals("6")) {
            System.out.print("\nEnter Menu Choice: ");
            strChoice = key.readLine();

            // Allows the user to view data sorted by HDI value
            if (strChoice.equals("1")) {
                System.out.println("For lowest to highest HDI Value - 1 \nFor highest to lowest HDI Value - 2");
                String strSearchChoice = key.readLine();
    
                // Sorts data from lowest to highest HDI value and prints out the array
                if (strSearchChoice.equals("1")) {
                    Data_Interaction.sortMinHDI(countries);
                    System.out.println("\n Name   Continent  Year  HDI");

                    for (int i = 0; i < countries.length; i++) {
                        System.out.println(countries[i]);
                    }
                }
    
                // Sorts data from highest to lowest HDI value and prints out the array
                if (strSearchChoice.equals("2")) {
                    Data_Interaction.sortMaxHDI(countries);
                    System.out.println("\n Name   Continent  Year  HDI");

                    for (int i = 0; i < countries.length; i++) {
                        System.out.println(countries[i]);
                    }
                }
            }
    
            // Allows the user to search for a data entry based on the name of the country
            if (strChoice.equals("2")) {
                // Using the key entered by the user, the program searches for the key in the array
                System.out.println("Please enter the name of the country (Case Sensitive - E.g. Canada)");
                System.out.print("Enter Key: ");
                String strKey = key.readLine();

                System.out.println(Data_Interaction.nameSearch(countries, strKey));
            }
    
            // Allows the user to view the data with filters applied
            if (strChoice.equals("3")) {
                System.out.println("Filter by year - 1 \nFilter by continent -2 \nFilter by both - 3");
                System.out.print("Enter Choice: ");
                String strFilterChoice = key.readLine();
    
                // Filters by the year that the user inputs
                if (strFilterChoice.equals("1")) {
                    System.out.print("Enter year (1997, 2007, or 2017): ");
                    int intYear = Integer.parseInt(key.readLine());

                    System.out.println(Data_Interaction.yearFilterSearch(countries, intYear));
    
                // Filters by the continent that the user inputs
                } else if (strFilterChoice.equals("2")) {
                    System.out.print("Enter continent (Africa, Asia, Europe, North America, South America, Oceania): ");
                    String strCont = key.readLine();

                    System.out.println(Data_Interaction.contFilterSearch(countries, strCont));
    
                // Filters by the both the year and continent that is inputted
                } else if (strFilterChoice.equals("3")) {
                    System.out.print("Enter year (1997, 2007, or 2017): ");
                    int intYear = Integer.parseInt(key.readLine());

                    System.out.print("Enter continent (Africa, Asia, Europe, North America, South America, Oceania): ");
                    String strCont = key.readLine();

                    System.out.println(Data_Interaction.twoFilterSearch(countries, intYear, strCont));
                }
            }
    
            // Allows the user to view an individual record 
            if (strChoice.equals("4")) { 
                System.out.println("To view an individual record please enter the name of the country and year");

                System.out.print("Enter country name (Case Sensitive - E.g. Canada): ");
                String strName = key.readLine();

                System.out.print("Enter year (1997, 2007, or 2017): ");
                int intYear = Integer.parseInt(key.readLine());

                // Searches the array for the inputted name and year
                System.out.println(Data_Interaction.individualSearch(countries, strName, intYear));
            }
    
            // Allows the user to view a summary report of the data set
            if (strChoice.equals("5")) {
                System.out.println("---------------Summary Report---------------");
                // Prints out the number of records and number of countries
                System.out.println("Total number of records: " + countries.length);
                System.out.println("Total number of countries: " + (countries.length / 3));

                // Prints out the average HDI from each year and overall
                System.out.println("Average HDI (1997): " + Data_Interaction.yearAverage(countries, 1997));
                System.out.println("Average HDI (2007): " + Data_Interaction.yearAverage(countries, 2007));
                System.out.println("Average HDI (2017): " + Data_Interaction.yearAverage(countries, 2017));
                System.out.println("Average HDI (All Three Years): " + Data_Interaction.totalAverage(countries));

                // Searches and prints out the country with the highest HDI
                Data_Interaction.sortMaxHDI(countries);
                System.out.println("Highest HDI: " + countries[0]);

                // Searches and prints out the country with the lowest HDI
                Data_Interaction.sortMinHDI(countries);
                System.out.println("Lowest HDI: " + countries[0]);

                // Prints out the median which is the country in the middle of the sorted array
                System.out.println("Median: " + countries[countries.length / 2]);
            }
    
            // Allows the user to view two different charts based on the data
            if (strChoice.equals("6")) {
                System.out.println("For bar chart - 1 \nFor line chart - 2");
                System.out.println("*Note you can only view one chart at a time");
                String strChartChoice = key.readLine();

                // Allows the user to view a bar chart about Canada's HDI vs the World's HDI
                if (strChartChoice.equals("1")) {
                    // Gets the HDI for Canada for all three years
                    dblCan1997 = Data_Interaction.individualHDISearch(countries, "Canada", 1997);
                    dblCan2007 = Data_Interaction.individualHDISearch(countries, "Canada", 2007);
                    dblCan2017 = Data_Interaction.individualHDISearch(countries, "Canada", 2017);

                    // Gets the HDI for the World for all three years
                    dblWorld1997 = Data_Interaction.yearAverage(countries, 1997);
                    dblWorld2007 = Data_Interaction.yearAverage(countries, 2007);
                    dblWorld2017 = Data_Interaction.yearAverage(countries, 2017);   

                    // Allows for the bar chart to launch
                    intChart = 1;
                    launch(args);
                }
    
                // Allows the user to view a line chart about Canada's HDI vs the World's HDI
                if (strChartChoice.equals("2")) {
                    // Gets the HDI for Canada for all three years
                    dblCan1997 = Data_Interaction.individualHDISearch(countries, "Canada", 1997);
                    dblCan2007 = Data_Interaction.individualHDISearch(countries, "Canada", 2007);
                    dblCan2017 = Data_Interaction.individualHDISearch(countries, "Canada", 2017);

                    // Gets the HDI for the World for all three years
                    dblWorld1997 = Data_Interaction.yearAverage(countries, 1997);
                    dblWorld2007 = Data_Interaction.yearAverage(countries, 2007);
                    dblWorld2017 = Data_Interaction.yearAverage(countries, 2017);

                    // Allows for the line chart to launch
                    intChart = 0; 
                    launch(args);
                }
                // The program ends after viewing the chart
                strChoice = "0";
            }
        }
    }

    // Runs the chart that is chosen by the user
    public void start(Stage primaryStage) throws Exception {
        // Runs the bar chart
        if (intChart == 1) {
            primaryStage.setScene(new Scene(Charts.theBarChart(dblCan1997, dblCan2007, dblCan2017, dblWorld1997, dblWorld2007, dblWorld2017)));
        } 
        
        // Runs the line chart
        else {
            primaryStage.setScene(new Scene(Charts.theLineChart(dblCan1997, dblCan2007, dblCan2017, dblWorld1997, dblWorld2007, dblWorld2017)));
        }
        primaryStage.show();
    }
}