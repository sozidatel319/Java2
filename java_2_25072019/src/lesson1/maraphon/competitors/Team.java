package lesson1.maraphon.competitors;

public class Team {
    String teamName;
    Competitor[] competitors;
    final String s = "Участник № ";

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

        for (int i = 0; i < competitors.length; i++) {
            if (competitors[i] instanceof Animal) {
                if (((Animal) competitors[i]).onDistance) {
                    System.out.println(s + i + " из команды " + teamName + " прошел полосу препятсвий");
                } else {
                    System.out.println(s + i + " команды " + teamName + " " + ((Animal) competitors[i]).type + " " + ((Animal) competitors[i]).name + " провалил полосу препятсвий");
                }

            } else if (competitors[i] instanceof Human) {
                if (((Human) competitors[i]).onDistance) {
                    System.out.println(s + i + " из команды " + teamName + " прошел полосу препятсвий");
                } else {
                    System.out.println(s + i + " из команды " + teamName + " провалил полосу препятсвий");
                }
            }
        }
    }

    public Competitor[] Competitor() {
        return this.competitors;
    }
}

