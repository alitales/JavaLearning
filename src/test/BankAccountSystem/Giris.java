package test.BankAccountSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Giris {
    private ArrayList<Informations> kullanicilar = new ArrayList<>();

    public void kayitOl(Scanner sc) {
        System.out.print("Adınızı girin: ");
        String ad = sc.nextLine();
        System.out.print("Soyadınızı girin: ");
        String soyad = sc.nextLine();
        System.out.print("Hesap numarası oluşturun: ");
        String hesapNo = sc.nextLine();
        System.out.print("Şifrenizi girin: ");
        String sifre = sc.nextLine();
        System.out.print("Başlangıç bakiyesi: ");
        double bakiye = sc.nextDouble();
        sc.nextLine();

        kullanicilar.add(new Informations(ad, soyad, hesapNo, sifre, bakiye));
        System.out.println("Kayıt başarılı!");
    }

    public Informations girisYap(Scanner sc) {
        Informations kullanici = null;

        while (kullanici == null) {
            System.out.print("Kullanıcı adınızı girin: ");
            String kullaniciAdi = sc.nextLine();
            System.out.print("Şifrenizi girin: ");
            String sifre = sc.nextLine();

            for (Informations kisi : kullanicilar) {
                if (kisi.getAd().equalsIgnoreCase(kullaniciAdi) && kisi.getSifre().equals(sifre)) {
                    kullanici = kisi;
                    System.out.println("Giriş başarılı, hoşgeldiniz " + kisi.getAd());
                    break;
                }
            }

            if (kullanici == null) {
                System.out.println("Kullanıcı adı veya şifre yanlış, tekrar deneyin.");
            }
        }

        return kullanici;
    }

    public ArrayList<Informations> getKullanicilar() {
        return kullanicilar;
    }
}
