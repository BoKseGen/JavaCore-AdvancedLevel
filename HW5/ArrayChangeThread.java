package Offline;

public class ArrayChangeThread extends Thread{

    private static float[] array;
    private static int trueIndex;
    ArrayChangeThread(float[] array, int index){
        this.array = array;
        this.trueIndex = index;
    }

    @Override
    public void run(){
        for(int i = 0; i < array.length; ++i)
            array[i] = Main.countNewValue(array[i], i + trueIndex);
    }
}
