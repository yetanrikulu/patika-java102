package maceraOyunu;

public class Forrest extends  BattleLoc{
    public Forrest(Player player) {
        super(player, "Orman", new Vampire(), "firewood",3);
    }

    public void getFinalAward(){

        this.getPlayer().setFirewood(true);
    }
}
