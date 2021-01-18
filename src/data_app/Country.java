package data_app;

public class Country {
    
    private String name;
    private String continent;
    private int year;
    private double HDI;

    public Country(String theName, String theCont, int theYear, double theHDI){

        this.name = theName;
        this.continent = theCont;
        this.year = theYear;
        this.HDI = theHDI;

    }

    public String getName(){
        return name;
    }

    public String getCont(){
        return continent;
    }

    public int getYear(){
        return year;
    }

    public double getHDI(){
        return HDI;
    }

    public void setHDI(double newHDI){
        this.HDI = newHDI;
    }

    public String toString(){
        return this.name + " " + this.continent + " " + this.year + " " + this.HDI;
    }


}
