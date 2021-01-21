package data_app;

public class Average {
    
    public static double totalAverage(Country[] theArray){
        double totalAverage = 0;
        
        for (int i = 0; i < theArray.length; i++) {
            totalAverage = totalAverage + theArray[i].getHDI();
        }

        totalAverage = Math.round((totalAverage/theArray.length) * 1000);
        totalAverage = totalAverage/1000;

        return totalAverage;
    }

    public static double yearAverage(Country[] theArray, int intYear){
        double totalAverage = 0;
        int intTheYear;
        
        for (int i = 0; i < theArray.length; i++) {
            intTheYear = theArray[i].getYear();
            if (intTheYear == intYear) {
                totalAverage = totalAverage + theArray[i].getHDI();
            }
        }

        totalAverage = Math.round((totalAverage/147) * 1000);
        totalAverage = totalAverage/1000;

        return totalAverage;
    }

}
