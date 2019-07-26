package lesson1.maraphon.obstacles;

import lesson1.maraphon.competitors.Competitor;

public class Curse {
    Obstacle[] obstacles;


    public void doIt(Competitor[] teammember) {

        for (int i = 0; i < obstacles.length; i++) {
            for (int j = 0; j < teammember.length; j++) {
                if (!teammember[j].isDistance()) break;
                obstacles[i].doIt(teammember[j]);
            }


        }
    }

    public Curse(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }
}
