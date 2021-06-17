package maceraOyunu;

public class Cave extends BattleLoc{
    public Cave(Player player) {
        super(player, "Mağara", new Zombie(), "food",3);
    }

    public void getFinalAward(){

        this.getPlayer().setFood(true);
    }

}
