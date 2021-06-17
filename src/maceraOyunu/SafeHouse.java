package maceraOyunu;

public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player ) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {

        System.out.println("Güvenli evdesiniz !");

        if (this.getPlayer().isFood()  && this.getPlayer().isFirewood() && this.getPlayer().isWater())
        {
            this.getPlayer().setWin(true);

            System.out.println("**** Oyunu Bitirdiniz ****");
            System.out.println("**** !! TEBRİKLER !! ****");
            return true;
        }

        System.out.println("Canınız yenilendi");
        this.getPlayer().setHealth(this.getPlayer().getOriginalHealth());
        return true;
    }
}
