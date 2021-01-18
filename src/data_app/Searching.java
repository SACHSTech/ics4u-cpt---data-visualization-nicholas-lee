package data_app;

public class Searching {
    
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

    public static String yearSearch(Country[] theArray, int intKey){
        int intElement;
  
          for(int i = 0; i < theArray.length; i++){
              intElement = theArray[i].getYear();				
              if(intElement == intKey){
                  System.out.println(theArray[i].toString());
              }
          }
          return " ";
  
    }

    public static String contSearch(Country[] theArray, String strKey){
        String strElement;
  
          for(int i = 0; i < theArray.length; i++){
              strElement = theArray[i].getCont();				
              if(strElement.equals(strKey)){
                  System.out.println(theArray[i].toString());
              }
          }
          return " ";
  
    }

    public static String bothSearch(Country[] theArray, int intYear, String strCont){
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

}
