package hesapMakinesi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HesapMakinesi {


    public int toplama (int a ,int b){
        return a+b;
    }

    public int cikarma (int a ,int b){
        return a-b;
    }

    public int carpma (int a ,int b){
        return a*b;
    }

    public int bolme (int a ,int b){
        if (b==0)
        {
            try {
                throw new Exception("0'a bölünemez");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return a/b;
    }

    public int usAlma (int a,int b){

        int result = 1;

        for(int i = 0 ;i<b;i++){
            result*=a;
        }
        return result;
    }

    public int faktoriyel(int a){
        int result = 1;
        for(int i = a ; i>0;i--){
            result*=i;
        }
        return result;
    }

    public int mod (int a, int b){
        return a%b;
    }

    public int mutlakDeger (int a){
        if (a<0){
            a*=-1;
        }
        return a;
    }

    public static String turev (){
        Scanner scanner = new Scanner(System.in);

        List<Integer> katsayilar = new ArrayList<>();
        int katsayi = 0 ;
        System.out.print("Denklem Derecesini giriniz : ");
        int derece = scanner.nextInt();
        for (int i=derece ;i>=0;i--){
            System.out.print(i+" dereceli katsayıyı giriniz : ");
            katsayi = scanner.nextInt();
            katsayilar.add(katsayi);
        }

        String result = "";

        for (int j = derece;j>0;j--){
            int yeniKatsayi = katsayilar.get(derece-j) * j ;
            result += yeniKatsayi + "x^"+ (j-1) +  "+";
        }
        result = result.substring(0,result.length()-1);

        return result;

    }

    public static void main(String[] args) {
        System.out.println(turev());
    }



}
