package maceraOyunu;

import java.util.Scanner;

public class Player {

    private int damage;
    private int health;
    private int originalHealth;
    private int money;
    private String charName;
    private String name;
    private Inventory inventory;

    private boolean isFood=false;
    private boolean isFirewood=false;
    private boolean isWater=false;
    private boolean isWin = false;

    public void setWin(boolean win) {
        isWin = win;
    }

    public boolean isWin() {
        return isWin;
    }

    public boolean isFood() {
        return isFood;
    }

    public void setFood(boolean food) {
        isFood = food;
    }

    public boolean isFirewood() {
        return isFirewood;
    }

    public void setFirewood(boolean firewood) {
        isFirewood = firewood;
    }

    public boolean isWater() {
        return isWater;
    }

    public void setWater(boolean water) {
        isWater = water;
    }

    private Scanner input = new Scanner (System.in);


    public Player (String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar(){

        GameChar[] charList = {new Samurai(),new Archer(),new Knight()};
        System.out.println("------------------------------");
        for (GameChar gameChar: charList) {
            System.out.println("ID : " +gameChar.getId() +
                    "\tKarakter : " + gameChar.getName() +
                    "\t Hasar: " + gameChar.getDamage() +
                    "\t Sağlık: "+gameChar.getHealth()+
                    "\t Para :" + gameChar.getMoney());
        }
        System.out.println("------------------------------");
        System.out.print("Lütfen bir karakter seçiniz : ");
        int selectChar=input.nextInt();
        switch (selectChar) {
            case 1 :
                initPlayer(new Samurai());
                break;
            case 2 :
                initPlayer(new Archer());
                break;
            case 3 :
                initPlayer(new Knight());
                break;
            default :
                initPlayer(new Samurai());
        }
        /*System.out.println("Karakter : " + this.getCharName() +
                ", Hasar :  "+ this.getDamage() +
                ", Sağlık : " + this.getHealth() +
                ", Para : " +this.getMoney());*/
    }

    public void selectLoc(){

    }

    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOriginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println(
                "Silah : " + this.getInventory().getWeapon().getName() +
                ", Zırh :  "+ this.getInventory().getArmor().getName() +
                ", Bloklama :  "+ this.getInventory().getArmor().getBlock() +
                ", Hasar :  "+ this.getTotalDamage() +
                ", Sağlık : " + this.getHealth() +
                ", Para : " +this.getMoney());
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        if (health<0){
            health = 0 ;
        }
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
