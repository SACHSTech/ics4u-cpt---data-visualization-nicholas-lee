package data_app;

public class Data_Interaction {
    
    // The methods below calculate the averages

    /**
    * Calculates the HDI average of all records in the data
    * @param theArray - the country array 
    * @return the average HDI of all the records
    */
    public static double totalAverage(Country[] theArray){
        double totalAverage = 0;
        
        // Adds all the HDI values from the array
        for (int i = 0; i < theArray.length; i++) {
            totalAverage = totalAverage + theArray[i].getHDI();
        }

        // Calculates the average and rounds it to three decimal places
        totalAverage = Math.round((totalAverage/theArray.length) * 1000);
        totalAverage = totalAverage/1000;

        // Returns the average
        return totalAverage;
    }

    /**
    * Calculates the HDI average of a specific year
    * @param theArray - the country array 
    * @param intYear - the year
    * @return the average HDI for that year
    */
    public static double yearAverage(Country[] theArray, int intYear){
        double totalAverage = 0;
        int intTheYear;
        
        // Runs through the whole array
        for (int i = 0; i < theArray.length; i++) {
            intTheYear = theArray[i].getYear();

            // Compares to see if the year of instance matches the year specified
            if (intTheYear == intYear) {
                totalAverage = totalAverage + theArray[i].getHDI();
            }
        }

        // Calculates the average and rounds it to three decimal places
        totalAverage = Math.round((totalAverage/147) * 1000);
        totalAverage = totalAverage/1000;

        // Returns the average
        return totalAverage;
    }

    // The methods below sort the data set

    /**
    * Sorts the data set from the lowest HDI value to the highest HDI value
    * @param theArray - the country array 
    * @return the sorted array
    */
    public static Country[] sortMinHDI(Country[] theArray){
        int currentMinIndex;

        // Sorts for the whole array minus one and sets the current min to the front of the unsorted list
        for (int i = 0; i < theArray.length - 1; i++) {
            currentMinIndex = i;

            // Finds the index of the minimum of the unsorted list
            for (int j = i + 1; j < theArray.length; j++) {
                // Checks to see if the HDI value is less than the current min
                if (theArray[j].getHDI() < theArray[currentMinIndex].getHDI()) {
                    currentMinIndex = j;
                }
            }

            // Swaps the elements 
            if (i != currentMinIndex) {
                Country temp = theArray[currentMinIndex];
                theArray[currentMinIndex] = theArray[i];
                theArray[i] = temp;
            }
        }

        // Returns the sorted array
        return theArray;
    }

    /**
    * Sorts the data set from the highest HDI value to the lowest HDI value
    * @param theArray - the country array 
    * @return the sorted array
    */
    public static Country[] sortMaxHDI(Country[] theArray){
        int currentMaxIndex;

        // Sorts for the whole array minus one
        for (int i = 0; i < theArray.length - 1; i++) {
            currentMaxIndex = i;

            for (int j = i + 1; j < theArray.length; j++) {
                // Checks to see if the HDI value is greater than the current max
                if (theArray[j].getHDI() > theArray[currentMaxIndex].getHDI()) {
                    currentMaxIndex = j;
                }
            }

            // Swaps the elements 
            if (i != currentMaxIndex) {
                Country temp = theArray[currentMaxIndex];
                theArray[currentMaxIndex] = theArray[i];
                theArray[i] = temp;
            }
        }

        // Returns the sorted array
        return theArray;
    }

    // The methods below search the data set  

    /**
    * Searchs the data set for a specified country name
    * @param theArray - the country array 
    * @param strKey - the name of the country
    * @return a message stating that the search results are printed above
    */
    public static String nameSearch(Country[] theArray, String strKey){
        String strElement;
  
        // Runs through the whole array
        for (int i = 0; i < theArray.length; i++) {
            strElement = theArray[i].getName();	
            
            // Checks to see if the name is found in the array
            if (strElement.equals(strKey)) {

                // Prints out the element of the array
                System.out.println(theArray[i].toString());
            }
        }

        // Returns a message
        return "\nThe search results are posted above";
      }
  
    /**
    * Searchs the data set for a specified year
    * @param theArray - the country array 
    * @param strKey - the year
    * @return a message that the data set has been filtered
    */
    public static String yearFilterSearch(Country[] theArray, int intKey) {
        int intElement;

        // Runs through the whole array
        for (int i = 0; i < theArray.length; i++) {
            intElement = theArray[i].getYear();	
            
            // Checks to see if the year is found in the array            
            if (intElement == intKey) {

                // Prints out the element of the array
                System.out.println(theArray[i].toString());
            }
        }

        // Returns blank if the year is not found
        return "\nThe data set has been filtered";
    }
  
    /**
    * Searchs the data set for a specified continent
    * @param theArray - the country array 
    * @param strKey - the continent
    * @return a message that the data set has been filtered
    */
    public static String contFilterSearch(Country[] theArray, String strKey){
        String strElement;

        // Runs through the whole array
        for (int i = 0; i < theArray.length; i++) {
            strElement = theArray[i].getCont();	

            // Checks to see if the continent is found in the array            
            if (strElement.equals(strKey)) {

                // Prints out the element of the array
                System.out.println(theArray[i].toString());
            }
        }

        // Returns a message
        return "\nThe data set has been filtered";
    }
  
    /**
    * Searchs the data set for a specified year and continent
    * @param theArray - the country array 
    * @param intYear - the year
    * @param strCont - the continent
    * @return  a message that the data set has been filtered
    */
    public static String twoFilterSearch(Country[] theArray, int intYear, String strCont){
        String strTheCont;
        int intTheYear;

        // Runs through the whole array
        for (int i = 0; i < theArray.length; i++) {
            intTheYear = theArray[i].getYear();
            strTheCont = theArray[i].getCont();
            
            // Checks to see if the continent and year is found in the array            
            if (strTheCont.equals(strCont) && intTheYear == intYear) {

                // Prints out the element of the array
                System.out.println(theArray[i].toString());
            }
        }

        // Returns a message
        return "\nThe data set has been filtered";
    }
  
    /**
    * Searchs the data set for an individual record
    * @param theArray - the country array 
    * @param strName - the country's name
    * @param intYear - the year
    * @return the element of array that is an individual country
    */
    public static String individualSearch(Country[] theArray, String strName, int intYear){
        String strTheName;
        int intTheYear;

        // Runs through the whole array
        for (int i = 0; i < theArray.length; i++) {
            intTheYear = theArray[i].getYear();
            strTheName = theArray[i].getName();	
            
            // Checks to see if the name and year is found in the array                       
            if (strTheName.equals(strName) && intTheYear == intYear) {

                // Prints out and returns the element of the array
                return theArray[i].toString();
            }
        }

        // Returns a message
        return "Not found in data set";
    }
  
    /**
    * Searchs the data set for a specific country's HDI
    * @param theArray - the country array 
    * @param strName - the country's name
    * @param intYear - the year
    * @return the HDI of the specific country
    */
    public static double individualHDISearch(Country[] theArray, String strName, int intYear){
        String strTheName;
        int intTheYear;

        // Runs through the whole array
        for (int i = 0; i < theArray.length; i++) {
            intTheYear = theArray[i].getYear();
            strTheName = theArray[i].getName();	

            // Checks to see if the name and year is found in the array
            if (strTheName.equals(strName) && intTheYear == intYear) {

                // Returns the HDI of the country
                return theArray[i].getHDI();
            }
        }

        // Returns -1 if the country is not found in the data set
        return -1;
    }
}
