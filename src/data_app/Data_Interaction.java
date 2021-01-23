package data_app;

public class Data_Interaction {
    
    //Averages
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

    // Sorting
    public static Country[] sortMinHDI(Country[] theArray){

        int currentMinIndex;

        for (int i = 0; i < theArray.length - 1; i++) {
            currentMinIndex = i;

            for (int j = i + 1; j < theArray.length; j++) {
                if (theArray[j].getHDI() < theArray[currentMinIndex].getHDI()) {
                    currentMinIndex = j;
                }
            }

            if (i != currentMinIndex){
                Country temp = theArray[currentMinIndex];
                theArray[currentMinIndex] = theArray[i];
                theArray[i] = temp;
            }
        }

        return theArray;

    }

    public static Country[] sortMaxHDI(Country[] theArray){

        int currentMinIndex;

        for (int i = 0; i < theArray.length - 1; i++) {
            currentMinIndex = i;

            for (int j = i + 1; j < theArray.length; j++) {
                if (theArray[j].getHDI() > theArray[currentMinIndex].getHDI()) {
                    currentMinIndex = j;
                }
            }

            if (i != currentMinIndex){
                Country temp = theArray[currentMinIndex];
                theArray[currentMinIndex] = theArray[i];
                theArray[i] = temp;
            }
        }

        return theArray;

    }

    // Searching 

    public static String nameSearch(Country[] theArray, String strKey){
        String strElement;
  
          for(int i = 0; i < theArray.length; i++){
              strElement = theArray[i].getName();				
              if(strElement.equals(strKey)){
                  System.out.println(theArray[i].toString());
              }
          }
          return " ";
  
      }
  
      public static String yearFilterSearch(Country[] theArray, int intKey){
          int intElement;
    
            for(int i = 0; i < theArray.length; i++){
                intElement = theArray[i].getYear();				
                if(intElement == intKey){
                    System.out.println(theArray[i].toString());
                }
            }
            return " ";
    
      }
  
      public static String contFilterSearch(Country[] theArray, String strKey){
          String strElement;
    
            for(int i = 0; i < theArray.length; i++){
                strElement = theArray[i].getCont();				
                if(strElement.equals(strKey)){
                    System.out.println(theArray[i].toString());
                }
            }
            return " ";
    
      }
  
      public static String twoFilterSearch(Country[] theArray, int intYear, String strCont){
          String strTheCont;
          int intTheYear;
    
            for(int i = 0; i < theArray.length; i++){
                intTheYear = theArray[i].getYear();
                strTheCont = theArray[i].getCont();				
                if(strTheCont.equals(strCont) && intTheYear == intYear){
                    System.out.println(theArray[i].toString());
                }
            }
            return " ";
    
      }
  
      public static String individualSearch(Country[] theArray, String strName, int intYear){
          String strTheName;
          int intTheYear;
    
            for(int i = 0; i < theArray.length; i++){
                intTheYear = theArray[i].getYear();
                strTheName = theArray[i].getName();				
                if(strTheName.equals(strName) && intTheYear == intYear){
                    System.out.println(theArray[i].toString());
                    return theArray[i].toString();
                }
            }
            return "Not found in data set";
      }
  
      public static double individualHDISearch(Country[] theArray, String strName, int intYear){
          String strTheName;
          int intTheYear;
    
            for(int i = 0; i < theArray.length; i++){
                intTheYear = theArray[i].getYear();
                strTheName = theArray[i].getName();				
                if(strTheName.equals(strName) && intTheYear == intYear){
                    return theArray[i].getHDI();
                }
            }
            return -1;
      }

}
