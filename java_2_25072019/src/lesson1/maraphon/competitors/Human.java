package lesson1.maraphon.competitors;

public class Human implements Competitor {

    String name;
    String team;
    String success = "";
    int teamMemberNumber;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean onDistance;

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 3000;
        this.maxJumpHeight = 2;
        this.maxSwimDistance = 100;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        String result = team == null ? "" : "Участник № " + teamMemberNumber + " из команды " + team + " ";
        if (dist <= maxRunDistance) {
            success = " справился с кроссом";
        } else {
            success = " провалил кросс";
            onDistance = false;
        }
        System.out.println(result + "Гуманоид" + " " + name + success);
    }

    @Override
    public void jump(int height) {
        String result = team == null ? "" : "Участник № " + teamMemberNumber + " из команды " + team + " ";
        if (height <= maxJumpHeight) {
            success = " справился с прыжком";
        } else {
            success = " провалил прыжок";
            onDistance = false;
        }
        System.out.println(result + "Гуманоид" + " " + name + success);
    }

    @Override
    public void swim(int dist) {
        String result = team == null ? "" : "Участник № " + teamMemberNumber + " из команды " + team + " ";
        if (maxSwimDistance == 0) {
            success = " плавать не умеет";
            onDistance = false;
            return;
        }
        if (dist <= maxSwimDistance) {
            success = " проплыл удачно";
        } else {
            success = " не смог проплыть";
            onDistance = false;
        }
        System.out.println(result + "Гуманоид" + " " + name + success);
    }

    @Override
    public boolean isDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        String result = team == null ? "" : "Участник № " + teamMemberNumber + " из команды " + team + " ";
        System.out.println(result + "Гуманоид" + " " + name + " На дистанции: " + onDistance);
    }

    public String getName() {
        return name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setTeamMemberNumber(int teamMemberNumber) {
        this.teamMemberNumber = teamMemberNumber;
    }
}
