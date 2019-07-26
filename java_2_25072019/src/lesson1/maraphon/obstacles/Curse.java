package lesson1.maraphon.obstacles;


import lesson1.maraphon.competitors.Competitor;
import lesson1.maraphon.competitors.Team;

public class Curse {
    private Obstacle[] obstacles;

    public void doIt(Team team) {

        for (Obstacle o : obstacles) {
            for (Competitor com : team.getCompetitors()) {
                if (com.isDistance()) {
                    o.doIt(com);
                }
            }
        }
    }

    public Curse(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }
}
