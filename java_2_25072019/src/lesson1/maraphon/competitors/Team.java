package lesson1.maraphon.competitors;

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

            if (competitors[i] instanceof Animal) {

                if (dist <= ((Animal) competitors[i]).maxRunDistance) {
                    System.out.println(s + i + ((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " справился с кроссом");
                } else {
                    System.out.println(s + i +((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " не справился с кроссом");
                    ((Animal) competitors[i]).onDistance = false;
                }
            }else {
                if (dist <= ((Human)competitors[i]).maxRunDistance){
                    System.out.println(s + i +((Human) competitors[i]).name + " справился с кроссом");
                }else {
                    System.out.println(s + i +((Human) competitors[i]).name + "не справился с кроссом");
                    ((Human)competitors[i]).active = false;
                }
            }
        }

    }


    @Override
    public void jump(int height) {

        for (int i = 0; i < competitors.length; i++) {

            if (competitors[i] instanceof Animal) {

                if (height <= ((Animal) competitors[i]).maxJumpHeight) {
                    System.out.println(s + i +((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " справился с прыжком");
                } else {
                    System.out.println(s + i +((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " провалил прыжок");
                    ((Animal) competitors[i]).onDistance = false;
                }
            }else {
                if (height <= ((Human)competitors[i]).maxJumpHeight){
                    System.out.println(s + i +((Human) competitors[i]).name + " справился с прыжком");
                }else {
                    System.out.println(s + i +((Human) competitors[i]).name + " провалил прыжок");
                    ((Human)competitors[i]).active = false;
                }
            }
        }
    }

    @Override
    public void swim(int dist) {

        for (int i = 0; i < competitors.length; i++) {

            if (competitors[i] instanceof Animal) {

                if (dist <= ((Animal) competitors[i]).maxSwimDistance) {
                    System.out.println( s + i + ((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " справился с прыжком");
                } else {
                    System.out.println(s + i +((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " провалил прыжок");
                    ((Animal) competitors[i]).onDistance = false;
                }
            }else {
                if (dist <= ((Human)competitors[i]).maxSwimDistance){
                    System.out.println(s + i +((Human) competitors[i]).name + " проплыл удачно");
                }else {
                    System.out.println(s + i +((Human) competitors[i]).name + " не смог проплыть");
                    ((Human)competitors[i]).active = false;
                }
            }
        }

    }

    @Override
    public boolean isDistance() {
        return false;
    }

    @Override
    public void info() {

    }
}
