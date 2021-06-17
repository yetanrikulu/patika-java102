package listeSinifi;

import java.util.Arrays;

public class MyList<T> {

    private T[] liste;
    private int numberOfElement = 0;


    public MyList(){
        liste = (T[]) new Object[10];
    }

    public MyList(int capacity){
        liste = (T[]) new Object[capacity];

    }

    public int size(){
        return numberOfElement;
    }

    public int getCapacity(){
        return liste.length;
    }

    public void add(T data){

        if (size()==getCapacity()){
            liste = Arrays.copyOf(liste,getCapacity()*2);
        }

        liste[numberOfElement] = data;
        numberOfElement++;

    }

    public T get(int index){

        if (index>=0 && index < numberOfElement)
            return liste[index];
        else
            return null;

    }

    public void remove(int index){

        if (index>=0 && index < numberOfElement){

            for (int i = index; i <numberOfElement-1 ;i++)
            {
                liste[i] = liste[i+1];
            }
            numberOfElement--;
        }
        else
            System.out.println("null*");
    }

    public void set(int index, T data){
        liste[index] = data;
    }

    public String toString() {
        String str = "[";

        for (int i = 0 ;i<numberOfElement;i++){
            str += liste[i];
            if (i != numberOfElement-1)
            {
                str+=",";
            }
        }

        str+="]";
        return str;
    }

    public int indexOf(T data){
        for (int i = 0 ;i<numberOfElement;i++){
            if (liste[i].equals(data))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(T data){
        for (int i = numberOfElement-1 ; i>=0 ; i--){
            if (liste[i].equals(data))
                return i;
        }
        return -1;
    }

    public boolean isEmpty(){
        return numberOfElement==0;
    }

    public T[] toArray(){
        T[] array = (T[]) new Object[numberOfElement];

        for(int i = 0 ;i<numberOfElement; i++){
            array[i] = liste[i];
        }

        return array;

    }

    public void clear() {
        numberOfElement = 0;
    }

    public MyList<T> subList(int start, int finish){
        int numberOfElements = finish - start + 1 ;
        MyList<T> sublist = new MyList<>(numberOfElements);

        for(int i = start ; i<=finish ; i++){
            sublist.add(liste[i]);
        }

        return sublist;

    }

    public boolean contains (T data){

        for(int i=0;i<numberOfElement;i++)
        {
            if (liste[i].equals(data))
                return true;
        }

        return false;
    }

}
