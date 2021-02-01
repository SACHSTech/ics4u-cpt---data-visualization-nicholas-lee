package data_app;

public class Country {
    
    // Initialize instance variables
    private String name;
    private String continent;
    private int year;
    private double HDI;

    /**
    * Constructor - creates a new country instance
    * @param theName - the country's name
    * @param theCont - the continent of the country
    * @param theYear - the year
    * @param theHDI - the HDI
    */
    public Country(String theName, String theCont, int theYear, double theHDI) {
        this.name = theName;
        this.continent = theCont;
        this.year = theYear;
        this.HDI = theHDI;
    }

    /**
    * Getter method for country's name
    * @return country's name
    */
    public String getName() {
        return name;
    }

    /**
    * Getter method for the continent
    * @return the continent
    */
    public String getCont() {
        return continent;
    }

    /**
    * Getter method for the year
    * @return the year
    */
    public int getYear() {
        return year;
    }

    /**
    * Getter method for country's HDI
    * @return country's HDI
    */
    public double getHDI() {
        return HDI;
    }

    /**
    * String representation of a country 
    * @return all the attributes regarding a country
    */
    public String toString() {
        return this.name + " | " + this.continent + " | " + this.year + " | " + this.HDI;
    }
}
