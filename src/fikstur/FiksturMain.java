package fikstur;

import java.util.*;

public class FiksturMain {
    public static void main(String[] args) {

        Random rand = new Random();

        List<Team> takimlar = new ArrayList<>();
        List<Team> tempTakimlar = new ArrayList<>();
        List<Round> rounds = new ArrayList<>();

        Team homeTeam,awayTeam;

        takimlar.add(new Team("Galatasaray"));
        takimlar.add(new Team("Bursaspor"));
        takimlar.add(new Team("Fenerbahçe"));
        takimlar.add(new Team("Beşiktaş"));
        takimlar.add(new Team("Başakşehir"));
        takimlar.add(new Team("Trabzonspor"));

        if (takimlar.size() % 2 ==1 )
            takimlar.add(new Team("Bay"));


        int birDevreMacSayisi = takimlar.size()-1;
        int ilkDevreMacSayisi = takimlar.size()-1;
        int round=1;

        while (ilkDevreMacSayisi>0){

            tempTakimlar.clear();
            tempTakimlar.addAll(takimlar);
            Round r = new Round(round);

            while (tempTakimlar.size()>0){
                int random = rand.nextInt(tempTakimlar.size());

                homeTeam = tempTakimlar.get(random);
                tempTakimlar.remove(random);
                random = rand.nextInt(tempTakimlar.size());

                while (true){
                    awayTeam = tempTakimlar.get(random);
                    if (!homeTeam.opponent.contains(awayTeam.name)){
                        homeTeam.opponent.add(awayTeam.name);
                        tempTakimlar.remove(awayTeam);
                        r.homeTeams.add(homeTeam.name);
                        r.awayTeam.add(awayTeam.name);
                        break;
                    }
                    else{
                        tempTakimlar.add(homeTeam);
                        break;
                    }
                }


            }

            ilkDevreMacSayisi--;
            round++;
            rounds.add(r);
        }

        for(Round r : rounds){
            System.out.println("Round : " + r.number);
            for (int i = 0; i<r.awayTeam.size();i++)
                System.out.println(r.homeTeams.get(i) + " vs " + r.awayTeam.get(i));
            System.out.println();
        }
        for(Round r : rounds){
            System.out.println("Round : " + (r.number+birDevreMacSayisi));
            for (int i = 0; i<r.awayTeam.size();i++)
                System.out.println(r.awayTeam.get(i) + " vs " + r.homeTeams.get(i));
            System.out.println();
        }

    }
}
