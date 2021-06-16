package maceraOyunu;

import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner (System.in);

    //oyunun başladığı yer
    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        //System.out.print("Lütfen bir isim giriniz : ");
        //String playerName = input.nextLine();

        Player player = new Player("emre");
        System.out.println("Sayın " + player.getName() + " bu karanlık ve sisli adaya hoşgeldiniz ! Burada yaşananların hepsi gerçek !");

        System.out.println("Lütfen bir karakter seçiniz ! ");
        player.selectChar();

        Location location = null;

        while(true)
        {
            player.printInfo();
            System.out.println();
            System.out.println("######Bölgeler######");
            System.out.println();
            System.out.println("1 - Güvenli Ev");
            System.out.println("2 - Mağaza");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = input.nextInt();

            location = switch (selectLoc) {
                case 1 -> new SafeHouse(player);
                case 2 -> new ToolStore(player);
                default -> new SafeHouse(player);
            };

            if(!location.onLocation()){
                System.out.println("GAME OVER !");
                break;
            }
        }


    }
}
