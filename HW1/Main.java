package homework;

import homework.actions.*;
import homework.patricipants.*;
import homework.barriers.*;


public class Main {

    public static void main(String[] args) {
        Actions[] participants = {new Cat(5, 500), new Human(2, 900), new Robot(1000, 3000) };

        Barrier[] barriers = {new Wall(1), new RunTrack(750), new Wall(90), new RunTrack(2500)};

        for(Barrier barrier : barriers){
            if(barrier instanceof Wall)
                barrier.printBarrierInfo("wall");
            if(barrier instanceof RunTrack)
                barrier.printBarrierInfo("run track");
            int barrierLimit = barrier.getBarrierLimit();
            for(Actions participant : participants){
                if(participant.getIsTakePart()){
                    if(barrier instanceof Wall)
                        participant.jump(barrierLimit);
                    if(barrier instanceof RunTrack)
                        participant.run(barrierLimit);
                }
            }
        }
    }
}
