package lesson1.maraphon;

import lesson1.maraphon.competitors.*;
import lesson1.maraphon.obstacles.Cross;
import lesson1.maraphon.obstacles.Obstacle;
import lesson1.maraphon.obstacles.Wall;
import lesson1.maraphon.obstacles.Water;

public class Main {
    public static void main(String[] args) {

        Team team = new Team("Везучие", new Cat("Барсик"));


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


        for (Obstacle o : obstacles) {
            o.doIt(team);
        }


        for (Competitor c : competitors) {
            c.info();
        }
    }
}
