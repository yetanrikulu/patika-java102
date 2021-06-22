package sigortaYonetimSistemi;

import java.util.Scanner;

public class SigortaYonetimSistemi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AccountManager accountManager = new AccountManager();

        String email,sifre;

        System.out.println("Email giriniz : ");
        email = scanner.next();
        System.out.println("Şifre giriniz : ");
        sifre = scanner.next();

        try {
            accountManager.login(email,sifre);
        }
        catch (InvalidAuthenticationException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
