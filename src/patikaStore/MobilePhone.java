package patikaStore;

public class MobilePhone extends Product{
    int memory;
    double screenSize;
    int batteryPower;
    int Ram;
    int camera;
    String color;


    public MobilePhone(int id, double price, String name, Brand brand, int memory, double screenSize, int camera, int batteryPower, int ram, String color) {
        super(id, price, name, brand);
        this.memory = memory;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        Ram = ram;
        this.color = color;
        this.camera=camera;
    }

    @Override
    public void print(){
        System.out.printf("| %d  | %-30s|%.1f     | %-10s|%7d    |  %6.1f   |%7d    |%7d    |%7d    |%-11s| \n",this.id,this.name,this.price,this.brand.name,this.memory,this.screenSize,this.camera,this.batteryPower,this.Ram,this.color);
    }
}
