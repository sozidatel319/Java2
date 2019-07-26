package lesson1.maraphon.obstacles;

import lesson1.maraphon.competitors.Competitor;

public class Curse extends Obstacle {
    Obstacle [] obstacles;

    @Override

    public void doIt(Competitor competitor) {
        for (int i = 0; i < obstacles.length; i++) {
            obstacles[i].doIt(competitor);
        }
    }

    public Curse(Obstacle... obstacles){
        this.obstacles = obstacles;
    }
}
