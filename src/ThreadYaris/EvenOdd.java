package ThreadYaris;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class EvenOdd implements Runnable{

    List<Integer> oddList = new ArrayList<>();
    List<Integer> evenList = new ArrayList<>();
    List<Integer> wholeList;
    int id=1;
    final static Object LOCK = new Object();

    public EvenOdd(List<Integer> wholeList) {
        this.wholeList = wholeList;
    }

    @Override
    public void run() {

        int firstIndex;
        int lastIndex;

        synchronized (LOCK){
            firstIndex = (id-1)*2500+1;
            lastIndex = id*2500+1;
            System.out.println(Thread.currentThread().getName() + " First : " + firstIndex + " last : " +lastIndex);

            id++;
        }

        List<Integer> sublist = new ArrayList<>();
        sublist=wholeList.subList(firstIndex,lastIndex);
        System.out.println(Thread.currentThread().getName() + " sublist : " + sublist);

        for (Integer i : sublist){
            if (i%2==0)
                synchronized (LOCK){
                    evenList.add(i);
                }
            else
                synchronized (LOCK){
                    oddList.add(i);
                }
        }


    }
}
