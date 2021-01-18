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

}
