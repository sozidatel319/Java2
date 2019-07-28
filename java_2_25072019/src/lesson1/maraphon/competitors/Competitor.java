package lesson1.maraphon.competitors;

public interface Competitor {
    void run(int dist);
    void jump(int height);
    void swim(int dist);
    boolean isDistance();
    void info();
    String getType();
    String getName();
    void setTeam(String team);
    void setTeamMemberNumber(int teamMemberNumber);
}
