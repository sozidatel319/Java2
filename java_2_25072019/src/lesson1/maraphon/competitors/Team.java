package lesson1.maraphon.competitors;

public class Team {
    private String teamName;
    private Competitor[] competitors;
    private final String s = "Участник № ";

    public Team(String teamName, Competitor... competitors) {
        this.teamName = teamName;
        this.competitors = competitors;
    }

    public void info() {
        System.out.println("");
        for (int i = 0; i < competitors.length; i++) {
            System.out.print(s + i + " из команды " + teamName + " ");
                competitors[i].info();
            System.out.println("");
        }
        System.out.println("");
    }

    public void showResults() {

        String type;

        for (int i = 0; i < competitors.length; i++) {
            if (competitors[i] instanceof Animal) type = " " + ((Animal) competitors[i]).type;
            else type = " Человек";
            if (competitors[i].isDistance()) {
                System.out.println(s + i + " из команды " + teamName + type + " прошел полосу препятсвий");
            }else{System.out.println(s + i + " из команды " + teamName + type + " провалил полосу препятсвий");}
        }
    }
    public Competitor[] getCompetitors() {
        return competitors;
    }
}

