package lesson1.maraphon.competitors;

public class Animal implements Competitor {
    String type;
    String name;
    String team;
    int teamMemberNumber;

    int maxRunDistance;
    int maxJumpHeight;
    int maxSwimDistance;

    boolean onDistance;

    public Animal(String type, String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        String result = team == null ? "" : "Участник № " + teamMemberNumber + " из команды " + team + " ";
        String success = "";
        if (dist <= maxRunDistance) {
            success = " справился с кроссом";
        } else {
            success = " провалил кросс";
            onDistance = false;
        }
        System.out.println(result + type + " " + name + success);
    }

    @Override
    public void jump(int height) {
        String result = team == null ? "" : "Участник № " + teamMemberNumber + " из команды " + team + " ";
        String success = "";
        if (height <= maxJumpHeight) {
            success = " справился с прыжком";
        } else {
            success = " провалил прыжок";
            onDistance = false;
        }
        System.out.println(result + type + " " + name + success);
    }

    @Override
    public void swim(int dist) {
        String result = team == null ? "" : "Участник № " + teamMemberNumber + " из команды " + team + " ";
        String success = "";
        if (maxSwimDistance == 0) {
            success = " плавать не умеет";
            System.out.println(result + type + " " + name + success);
            onDistance = false;
            return;
        }
        if (dist <= maxSwimDistance) {
            success = " проплыл удачно";
        } else {
            success = " не смог проплыть";
            onDistance = false;
        }
        System.out.println(result + type + " " + name + success);
    }

    @Override
    public boolean isDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        String result = team == null ? "" : "Участник № " + teamMemberNumber + " из команды " + team + " ";
        System.out.println(result + type + " " + name + " На дистанции: " + onDistance);
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
