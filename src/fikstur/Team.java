package fikstur;

import java.util.ArrayList;
import java.util.List;

public class Team {
    String name;
    List<String> opponent = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
}
