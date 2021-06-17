package maceraOyunu;

public class River extends BattleLoc{
    public River(Player player) {
        super(player, "Nehir", new Bear(), "water",2);
    }

    public void getFinalAward(){

        this.getPlayer().setWater(true);
    }
}
