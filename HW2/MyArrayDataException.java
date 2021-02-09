package offline;

public class MyArrayDataException extends Exception{
    private static int row;
    private static int column;
    private static String value;
    MyArrayDataException(int row, int col, String value){
        this.row = row;
        this.column = col;
        this.value = value;
    }

    public static int getColumn() {
        return column;
    }

    public static int getRow() {
        return row;
    }

    public static String getValue(){
        return value;
    }
}
