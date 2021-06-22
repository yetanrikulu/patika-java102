package sigortaYonetimSistemi;

public class AddressManager {

    public static User addAddress (User user, Address address){
        user.adresListesi.add(address);
        return user;
    }

    public static User removeAddress (User user, Address address){
        user.adresListesi.remove(address);
        return user;
    }
}
