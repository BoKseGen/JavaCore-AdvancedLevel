package Offline;

public class Main {

    private static final int size = 10000000;

    public static float countNewValue(float element, int i){
        return (float)(element * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    public static long changeWithoutThreads(float[] array){
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < array.length; ++i)
            array[i] = countNewValue(array[i], i);
        long endTime = System.currentTimeMillis() - startTime;
        return endTime;
    }

    private static long changeWithThreads(float[] array){
        float[] subArray1 = new float[size / 2];
        float[] subArray2 = new float[size / 2];

        System.arraycopy(array, 0, subArray1,0,size / 2);
        System.arraycopy(array, size / 2, subArray2, 0, size / 2);

        long startTime = System.currentTimeMillis();
        ArrayChangeThread thread1 = new ArrayChangeThread(subArray1, 0);
        ArrayChangeThread thread2 = new ArrayChangeThread(subArray2, size / 2);
        thread1.start();
        thread2.start();
        long endTime = 0;
        try{
            thread1.join();
            thread2.join();
            System.arraycopy(subArray1, 0, array, 0,size / 2);
            System.arraycopy(subArray2, 0, array, size / 2, size / 2);
            endTime = System.currentTimeMillis() - startTime;
        } catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }
        return endTime;

    }

    public static void main(String[] args) {
        float[] array = new float[size];
        for(float element : array)
            element = 1;
        System.out.println("Method without threads worked for " + changeWithoutThreads(array) + " ms");

        for(float element : array)
            element = 1;
        System.out.println("Method with threads worked for " + changeWithThreads(array) + " ms");
    }
}
