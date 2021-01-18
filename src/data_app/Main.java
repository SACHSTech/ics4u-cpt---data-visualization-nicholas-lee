package data_app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws IOException{

        BufferedReader data = new BufferedReader(new FileReader("HDI2.csv"));

		String strLine = "";
        String splitBy = ",";

        String name;
        String cont;
        int year;
        double HDI;

        Country country;

        int intCount = 0;

        Country[] countries = new Country[4];

        while(intCount < 4){

            strLine = data.readLine();
            String[] elements = strLine.split(splitBy);

            name = elements[0];
            cont = elements[1];
            year = Integer.parseInt(elements[2]);
            HDI = Double.parseDouble(elements[3]);

            country = new Country(name, cont, year, HDI);

            countries[intCount] = country;

            //System.out.println(countries[intCount]);

            intCount++;
        }
        data.close();

        //System.out.println(Arrays.toString(sort(countries)));
        Sorting.sortMinHDI(countries);
        System.out.println(countries[0]);

        System.out.println("Welcome to the Human Development Index (HDI) App");
        System.out.println("Please select one of the options below: ");


    }

}
