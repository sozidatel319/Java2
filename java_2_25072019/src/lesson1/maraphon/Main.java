package lesson1.maraphon;

import lesson1.maraphon.competitors.*;
import lesson1.maraphon.obstacles.*;

public class Main {
    public static void main(String[] args) {


        Competitor[] competitors = {
                new Human("Bob"),
                new Cat("Barsik"),
                new Dog("Jack"),
                new Dog("Тузик")};
        Obstacle[] obstacles = {
                new Cross(80),
                new Wall(2),
                new Wall(1),
                new Water(10)};

        for (Competitor c : competitors) {
            for (Obstacle o : obstacles) {
                o.doIt(c);
                if (!c.isDistance()) break;
            }
        }

        for (Competitor c : competitors) {
            c.info();
        }



        Team team = new Team("Везучие", new Cat("Барсик"), new Dog("Jack"), new Human("Борис"));
        Curse curse = new Curse(new Cross(80), new Wall(2), new Water(10));

        curse.doIt(team);
        team.info();
        team.showResults();
    }
}
