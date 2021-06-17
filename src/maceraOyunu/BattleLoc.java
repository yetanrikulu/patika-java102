package maceraOyunu;

import java.util.Random;

import javax.lang.model.util.ElementScanner6;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class BattleLoc extends Location{

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle =maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikktali Ol! Burada " + obsNumber +" tane " +this.getObstacle().getName() + " yaşıyor !");
        System.out.print("<S>avaş veya <K>aç : ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if(selectCase.equals("S") && combat(obsNumber)){
                System.out.println(this.getName() + " tüm düşmanları yendiniz !");
                getFinalAward();
                return true;
        }

        if(this.getPlayer().getHealth()<=0){
            System.out.println("Öldünüz !");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber) {

        for (int i = 1;i<=obsNumber;i++) {
            this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
            if (this.getObstacle().getId() == 4){
                Random random =  new Random();
                int randomDamage = random.nextInt(4)+3;
                this.getObstacle().setDamage(randomDamage);
            }

            playerStats();
            obstacleStats(i);

            while(this.getPlayer().getHealth()>0 && this.getObstacle().getHealth()>0) {
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat =input.nextLine().toUpperCase();
                if(selectCombat.equals("V")){

                    Random rand = new Random();

                    int whoFirst = rand.nextInt(2);

                    if (whoFirst == 0)
                        playerFirstHit();            
                    else
                        obstacleFirstHit();        
                    
                }
                else{
                    return false;
                }
            }

            if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
                System.out.println("Düşmanı Yendiniz !");
                if (this.getObstacle().getId() !=4){
                    System.out.println(this.getObstacle().getAward() + " para kazandınız");                    
                }
                else{
                    snakeAwardSystem();
                }
                this.getPlayer().setMoney(this.getPlayer().getMoney()+ this.getObstacle().getAward());
                System.out.println("Güncel Paranız " + this.getPlayer().getMoney());
            }
            else{
                return false;
            }

        }

        return true;
    }


    private void snakeAwardSystem(){

        Random rand = new Random();
        int randAwardChance = rand.nextInt(100);

        if (randAwardChance<15){
            int randWeapon = rand.nextInt(100);
            if (randWeapon <20){
                System.out.println("Tüfek Kazandınız ! ");
                this.getPlayer().getInventory().setWeapon(Weapon.weapons()[2]);
            }
            else if (randWeapon<50){
                System.out.println("Kılıç Kazandınız ! ");
                this.getPlayer().getInventory().setWeapon(Weapon.weapons()[1]);
            }
            else {
                System.out.println("Tabanca Kazandınız ! ");
                this.getPlayer().getInventory().setWeapon(Weapon.weapons()[0]);
            }
        }
        else if (randAwardChance<30){
            int randArmor = rand.nextInt(100);
            if (randArmor<20){
                System.out.println("Ağır Zırh Kazandınız ! ");
                this.getPlayer().getInventory().setArmor(Armor.armors()[2]);
            }
            else if(randArmor<50){
                System.out.println("Orta Zırh Kazandınız ! ");
                this.getPlayer().getInventory().setArmor(Armor.armors()[1]);
            } 
            else {
                System.out.println("Hafif Zırh Kazandınız ! ");
                this.getPlayer().getInventory().setArmor(Armor.armors()[0]);
            }

        }
        else if (randAwardChance<55){
            int randMoney = rand.nextInt(100);
            if (randMoney<20){
                System.out.println("10 Para Kazandınız !");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+ 10);
            }
            else if(randMoney<50){
                System.out.println("5 Para Kazandınız !");                
                this.getPlayer().setMoney(this.getPlayer().getMoney()+ 5);

            } 
            else {
                System.out.println("1 Para Kazandınız !");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+ 1);
            }
        }
        

    }


    private void playerFirstHit(){
        
        System.out.println("Siz vurdunuz");
        this.getObstacle().setHealth(this.getObstacle().getHealth()- this.getPlayer().getTotalDamage());
        afterHit();

        if(this.getObstacle().getHealth()>0){
            System.out.println();
            System.out.println("Canavar Size Vurdu !");
            int obstacleDamage = this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
            if(obstacleDamage<0)
                obstacleDamage=0;
            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
            afterHit();
        }
    }

    private void obstacleFirstHit(){
        
        System.out.println("Canavar Size Vurdu !");
        int obstacleDamage = this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
        if(obstacleDamage<0)
            obstacleDamage=0;
        this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
        afterHit();
        
        if (this.getPlayer().getHealth()>0)
        {
            System.out.println("Siz vurdunuz");
            this.getObstacle().setHealth(this.getObstacle().getHealth()- this.getPlayer().getTotalDamage());
            afterHit();
        }        
        
    }

    public void afterHit(){
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println("--------------");
    }

    public void playerStats(){
        System.out.println("Oyuncu Değerleri");
        System.out.println("---------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney());

    }

    public void obstacleStats(int i){
        System.out.println(i + ". " + this.obstacle.getName() + " Degerleri");
        System.out.println("---------------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getAward());

    }

    public int randomObstacleNumber()
    {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public void getFinalAward(){};

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
