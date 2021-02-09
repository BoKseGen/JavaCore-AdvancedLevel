package offline;

public class Main {

    public static boolean isDigit(String element, int i, int j) throws NumberFormatException, MyArrayDataException {
        try {
            Integer.parseInt(element);
            return true;
        } catch (NumberFormatException numberFormatException) {
            return false;
        }
    }


    public static int[][] changeArrayToInt(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int normSize = 4;
        try{
            int arraySize = array.length;
            if(arraySize != normSize){
                throw new MyArraySizeException("The size of input array doesn't equal 4");
            }
            int[][] changedArray = new int[arraySize][arraySize];
            for(int i = 0; i < arraySize; ++i){
                for(int j = 0; j < arraySize; ++j){
                    if(!isDigit(array[i][j], i, j)){
                        throw new MyArrayDataException(i, j, array[i][j]);
                    } else {
                        changedArray[i][j] = Integer.parseInt(array[i][j]);
                    }
                }
            }
            return changedArray;
        } catch (MyArraySizeException myArraySizeException){
            System.out.println("There was wrong size of array");
        } catch (MyArrayDataException myArrayDataException){
            System.out.println("There was wrong data in cell array[" + myArrayDataException.getRow() + "]["
                    + myArrayDataException.getColumn() + "] of input array. " +
                    "The value of cell was " + "'" + myArrayDataException.getValue() +"'");
        }

        return null;
    }

    public static void printArray(int[][] array){
        if (array != null) {
            for (int i = 0; i < array.length; ++i) {
                for (int j = 0; j < array.length; ++j) {
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("There is no array to print");
        }
        System.out.println();
    }

    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] normArray = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        String[][] wrongSizeArray = {{"9", "10", "11", "12", "7"}, {"1", "2", "3", "4", "5"}, {"5", "6", "7", "8", "3"}, {"9", "10", "11", "12", "7"}, {"13","12", "14", "15", "16"}};
        String[][] arrayWithText = {{"1", "2", "a", "4"}, {"5", "abcd12", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};
        printArray(changeArrayToInt(normArray));
        printArray(changeArrayToInt(wrongSizeArray));
        printArray(changeArrayToInt(arrayWithText));
    }
}
