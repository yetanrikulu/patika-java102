package patikaStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class StoreMain {
    public static void main(String[] args) {


        List<Brand> brandList = new ArrayList<>();

        List<Product> notebookList = new ArrayList<>();
        List<Product> mobilePhoneList = new ArrayList<>();

        {
            brandList.add(new Brand(brandList.size() + 1, "Samsung"));
            brandList.add(new Brand(brandList.size() + 1, "Lenovo"));
            brandList.add(new Brand(brandList.size() + 1, "Apple"));
            brandList.add(new Brand(brandList.size() + 1, "Huawei"));
            brandList.add(new Brand(brandList.size() + 1, "Casper"));
            brandList.add(new Brand(brandList.size() + 1, "Asus"));
            brandList.add(new Brand(brandList.size() + 1, "HP"));
            brandList.add(new Brand(brandList.size() + 1, "Xiaomi"));
            brandList.add(new Brand(brandList.size() + 1, "Monster"));


            notebookList.add(new Notebook(notebookList.size() + 1, 7000, "HUAWEI Matebook 14", brandList.get(3), 16, 512, 14.0));
            notebookList.add(new Notebook(notebookList.size() + 1, 3699, "LENOVO V14 IGL", brandList.get(1), 8, 1024, 14.0));
            notebookList.add(new Notebook(notebookList.size() + 1, 8199, "ASUS Tuf Gaming", brandList.get(5), 32, 2048, 15.6));

            mobilePhoneList.add(new MobilePhone(mobilePhoneList.size() + 1, 3199, "SAMSUNG GALAXY A51", brandList.get(0), 128, 6.5, 32, 4000, 6, "Siyah"));
            mobilePhoneList.add(new MobilePhone(mobilePhoneList.size() + 1, 7379, "iPhone 11 64 GB", brandList.get(2), 64, 6.1, 5, 3046, 6, "Mavi      "));
            mobilePhoneList.add(new MobilePhone(mobilePhoneList.size() + 1, 4012, "Redmi Note 10 Pro 8GB", brandList.get(7), 128, 6.5, 35, 4000, 12, "Beyaz"));

        }



        System.out.println("PatikaStore Ürün yönetim Paneli !");
        int menuSelection = 1;
        while (menuSelection !=0){

            menuSelection = printMenu();

            switch (menuSelection){
                case 1:
                    printNotebooks(notebookList);
                    break;
                case 2:
                    printMobile(mobilePhoneList);
                    break;
                case 3:
                    printBrands(brandList);
                    break;
                default:
                    System.out.println("Hatalı bir seçim yaptınız !");



            }


        }


    }

    private static void printBrands(List<Brand> brandList){
        brandList.sort(new BrandNameComparator());
        System.out.println("------------------------------------------------");
        for(Brand i : brandList){
            System.out.println("- " + i.name);
        }
        System.out.println("------------------------------------------------");

    }

    private static int printMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 - Notebook İşlemleri");
        System.out.println("2 - Cep Telefoun İşlemleri");
        System.out.println("3 - Marka Listele");
        System.out.println("0 - Çıkış Yap");
        System.out.print("Tercihiniz : ");

        int selection = scanner.nextInt();
        return selection;
    }

    private static void printNotebooks(List<Product> notebookList){

        System.out.println("Notebook Listesi");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | RAM    |");

        for(Product p : notebookList)
            p.print();
        System.out.println("-----------------------------------------------------------------------------------------------");

    }

    private static void printMobile(List<Product> mobileList){

        System.out.println("Cep Telefonu Listesi");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Depolama  | Ekran     | Kamera    | Pil       | RAM       | Renk      |");

        for(Product p : mobileList)
            p.print();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");

    }


}
