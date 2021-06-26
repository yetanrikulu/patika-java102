package ThreadYaris;

import java.util.ArrayList;
import java.util.List;

public class ThreadYarisMain {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> liste = new ArrayList<>();

        for (int i =0; i<=10000 ; i++){
            liste.add(i);
        }

        EvenOdd evenOdd = new EvenOdd(liste);

        Thread t1 = new Thread(evenOdd);
        Thread t2 = new Thread(evenOdd);
        Thread t3 = new Thread(evenOdd);
        Thread t4 = new Thread(evenOdd);

        t1.join();
        t2.join();
        t3.join();
        t4.join();

        t1.start();
        t2.start();
        t3.start();
        t4.start();




    }
}
