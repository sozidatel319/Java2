package lesson1.maraphon.competitors;

public class Team {
    private String teamName;
    private Competitor[] competitors;

    private final String s = "Участник № ";

    public Team(String teamName, Competitor... competitors) {
        this.teamName = teamName;
        this.competitors = competitors;

        for (int i = 0; i < competitors.length; i++) {
            if (competitors[i] instanceof Animal){
                ((Animal)competitors[i]).setTeam(teamName);
                ((Animal)competitors[i]).setTeamMemberNumber(i);
            }
            else {
                ((Human)competitors[i]).setTeam(teamName);
                ((Human)competitors[i]).setTeamMemberNumber(i);
            }
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
            if (competitors[i] instanceof Animal) {
                name = ((Animal) competitors[i]).getName();
                type = " " + ((Animal) competitors[i]).type;
            } else {
                name = ((Human) competitors[i]).getName();
                type = " Гуманоид";
            }
            if (competitors[i].isDistance()) {
                suscess = " прошел ";
            } else {
                suscess = " не прошел ";
            }
            result = s + i + " из команды " + teamName + type + " "+ name + suscess + "полосу препятствий";
            System.out.println(result);
        }
        System.out.println("");
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }
}

