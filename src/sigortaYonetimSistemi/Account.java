package sigortaYonetimSistemi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public abstract class Account implements Comparable<Account> {

    User user;
    List<Insurance> insuranceList = new ArrayList<>();
    AuthenticationStatus authenticationStatus = AuthenticationStatus.FAIL;


    final void showUserInfo(){
        System.out.println("İsim : " + user.isim + " Soyisim : "+ user.soyisim + " Email : " + user.email +
                " Şifre : " + user.sifre + " Meslek : " + user.meslek + " Yaş : "+ user.yas);
    }

    public void login(String email,String password) throws InvalidAuthenticationException {

        if (email.equals(user.email) && password.equals(user.sifre)){
            authenticationStatus = AuthenticationStatus.SUCCESS;
        }
        else{
            throw new InvalidAuthenticationException("Giriş Yapılamadı !");
        }
    }

    public void addAddress(Address address){
        user.adresListesi.add(address);

    }
    public void removeAddress(Address address){ user.adresListesi.remove(address);
    }
    public AuthenticationStatus getAuthenticationStatus() {return authenticationStatus;
    }

    public abstract void addInsurance (Insurance insurance);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(user, account.user) && Objects.equals(insuranceList, account.insuranceList) && authenticationStatus == account.authenticationStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, insuranceList, authenticationStatus);
    }
}
