package lesson1.maraphon.competitors;

public class Team {
    private String teamName;
    private Competitor[] competitors;

    private final String s = "Участник № ";

    public Team(String teamName, Competitor... competitors) {
        this.teamName = teamName;
        this.competitors = competitors;

        for (int i = 0; i < competitors.length; i++) {

            competitors[i].setTeam(teamName);
            competitors[i].setTeamMemberNumber(i);
        }
    }

    public void info() {
        System.out.println("");
        for (int i = 0; i < competitors.length; i++) {
            competitors[i].info();
        }
        System.out.println("");
    }

    public void showResults() {

        String result;
        String type;
        String suscess = "";
        String name;
        for (int i = 0; i < competitors.length; i++) {
            name = competitors[i].getName();
            type = competitors[i].getType();
            if (competitors[i].isDistance()) {
                suscess = " прошел ";
            } else {
                suscess = " не прошел ";
            }
            result = s + i + " из команды " + teamName + " " + type + " " + name + suscess + "полосу препятствий";
            System.out.println(result);
        }
        System.out.println("");
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }
}

