package fikstur;

import java.util.ArrayList;
import java.util.List;

public class Round {

    int number;
    List<String> homeTeams = new ArrayList<>();
    List<String>  awayTeam = new ArrayList<>();

    public Round(int number) {
        this.number = number;
    }
}
