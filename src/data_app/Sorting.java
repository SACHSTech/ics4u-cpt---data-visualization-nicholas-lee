package data_app;

public class Sorting {
    
    public static Country[] sortMinHDI(Country[] theArray){

        int currentMinIndex;

        for (int i = 0; i < 4 - 1; i++) {
            currentMinIndex = i;

            for (int j = i + 1; j < 4; j++) {
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

}
