package homework.patricipants;

import homework.actions.Actions;

public class Robot implements Actions {

    private int jumpLimit;
    private int runLimit;

    private boolean isTakePart = true;

    public Robot(int jumpLimit, int runLimit){
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    public boolean getIsTakePart(){
        return isTakePart;
    }

    @Override
    public boolean jump(int jumpDistance){
        if (!isTakePart) return false;
        isTakePart = (jumpLimit >= jumpDistance);
        System.out.println((jumpLimit >= jumpDistance) ? "Robot has jumped" : "Robot hasn't jumped");
        return jumpLimit >= jumpDistance;
    }

    @Override
    public boolean run(int runDistance){
        if (!isTakePart) return false;
        isTakePart = (runLimit >= runDistance);
        System.out.println((runLimit >= runDistance) ? "Robot has run" : "Robot hasn't run");
        return runLimit >= runDistance;
    }
}
