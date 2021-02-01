package homework.barriers;

public class Barrier {

    protected int barrierLimit;

    Barrier(int barrierLimit){
        this.barrierLimit = barrierLimit;
    }

    public void printBarrierInfo(String barrierType){
        System.out.println("It's a " + barrierType + " with limit " + barrierLimit);
    }

    public int getBarrierLimit() {
        return barrierLimit;
    }
}
