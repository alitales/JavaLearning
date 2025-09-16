package test.BankAccountSystem;

public class Informations {
    private String ad;
    private String soyad;
    private String hesapNo;
    private String sifre;
    private double bakiye;

    public Informations(String ad, String soyad, String hesapNo, String sifre, double bakiye) {
        this.ad = ad;
        this.soyad = soyad;
        this.hesapNo = hesapNo;
        this.sifre = sifre;
        this.bakiye = bakiye;
    }

    public String getAd() { return ad; }
    public String getSoyad() { return soyad; }
    public String getHesapNo() { return hesapNo; }
    public String getSifre() { return sifre; }
    public double getBakiye() { return bakiye; }
    public void setBakiye(double bakiye) { this.bakiye = bakiye; }
}
