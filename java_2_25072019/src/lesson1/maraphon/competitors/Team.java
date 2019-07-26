package lesson1.maraphon.competitors;

import java.util.ArrayList;

public class Team implements Competitor {
    String teamName;
    Competitor[] competitors;
    final String s = "Участник № ";

    public Team(String teamName, Competitor... competitors) {
        this.teamName = teamName;
        this.competitors = competitors;
    }

    @Override
    public void run(int dist) {
        for (int i = 0; i < competitors.length; i++) {

            if (competitors[i].isDistance()) {
                if (competitors[i] instanceof Animal) {

                    if (dist <= ((Animal) competitors[i]).maxRunDistance) {
                        System.out.println(s + i + " " + ((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " справился с кроссом");
                    } else {
                        System.out.println(s + i + " " + ((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " не справился с кроссом");
                        ((Animal) competitors[i]).onDistance = false;
                    }
                } else {

                    if (dist <= ((Human) competitors[i]).maxRunDistance) {
                        System.out.println(s + i + " Человек по имени " + ((Human) competitors[i]).name + " справился с кроссом");
                    } else {
                        System.out.println(s + i + " Человек по имени " + ((Human) competitors[i]).name + "не справился с кроссом");
                        ((Human) competitors[i]).active = false;
                    }
                }
            }

        }
    }

    @Override
    public void jump(int height) {

        for (int i = 0; i < competitors.length; i++) {

            if (competitors[i].isDistance()) {
                if (competitors[i] instanceof Animal && competitors[i].isDistance()) {

                    if (height <= ((Animal) competitors[i]).maxJumpHeight) {
                        System.out.println(s + i + " " + ((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " справился с прыжком");
                    } else {
                        System.out.println(s + i + " " + ((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " провалил прыжок");
                        ((Animal) competitors[i]).onDistance = false;
                    }
                } else {
                    if (height <= ((Human) competitors[i]).maxJumpHeight) {
                        System.out.println(s + i + " Человек по имени " + ((Human) competitors[i]).name + " справился с прыжком");
                    } else {
                        System.out.println(s + i + " Человек по имени " + ((Human) competitors[i]).name + " провалил прыжок");
                        ((Human) competitors[i]).active = false;
                    }
                }
            }
        }
    }

    @Override
    public void swim(int dist) {

        for (int i = 0; i < competitors.length; i++) {

            if (competitors[i].isDistance()) {
                if (competitors[i] instanceof Animal) {

                    if (dist <= ((Animal) competitors[i]).maxSwimDistance) {
                        System.out.println(s + i + " " + ((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " проплыл удачно");
                    } else {
                        System.out.println(s + i + " " + ((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " не смог проплыть");
                        ((Animal) competitors[i]).onDistance = false;
                    }
                } else {
                    if (dist <= ((Human) competitors[i]).maxSwimDistance) {
                        System.out.println(s + i + " Человек по имени " + ((Human) competitors[i]).name + " проплыл удачно");
                    } else {
                        System.out.println(s + i + " Человек по имени " + ((Human) competitors[i]).name + " не смог проплыть");
                        ((Human) competitors[i]).active = false;
                    }
                }
            }
        }

    }

    @Override
    public boolean isDistance() {

        //return ((Animal)competitors[]).onDistance;

        for (int i = 0; i < competitors.length; i++) {
            if (competitors[i] instanceof Animal) return ((Animal) competitors[i]).onDistance;
            else return ((Human) competitors[i]).active;

        }
        return false;
    }

    @Override
    public void info() {

        for (int i = 0; i < competitors.length; i++) {
            if (competitors[i] instanceof Animal) {
                System.out.println(((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " На дистанции: " + ((Animal) competitors[i]).onDistance);
            } else {
                System.out.println(((Human) competitors[i]).name + " На дистанции: " + ((Human) competitors[i]).active);
            }

        }
    }

    public void showResults() {

        for (int i = 0; i < competitors.length; i++) {
            if (competitors[i] instanceof Animal) {
                if (((Animal) competitors[i]).onDistance) {
                    System.out.println(s + i + " из команды " + teamName + " прошел полосу препятсвий");
                } else {
                    System.out.println(s + i + " команды " + teamName + " " + ((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " провалил полосу препятсвий");
                }

            } else if (competitors[i] instanceof Human) {
                if (((Human) competitors[i]).active) {
                    System.out.println(s + i + " из команды " + teamName + " прошел полосу препятсвий");
                } else {
                    System.out.println(s + i + " из команды " + teamName + " провалил полосу препятсвий");
                }
            }
        }
    }
}

