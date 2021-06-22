package sigortaYonetimSistemi;

import java.util.Date;

public abstract class Insurance {

    String isim;
    Double ucret;
    Date baslangic;
    Date bitis;

    public abstract void calculate();
}
