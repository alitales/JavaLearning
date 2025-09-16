package test.BankAccountSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Informations {
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

    static class Giris {
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

    static class BankApp {
        public void menu(Informations kullanici, Giris giris, Scanner sc) {
            boolean devam = true;

            while (devam) {
                System.out.println("\n1- Para Yatır\n2- Para Çek\n3- Havale/EFT\n4- Çıkış");
                System.out.print("Seçiminiz: ");
                int secim = sc.nextInt();
                sc.nextLine();

                switch (secim) {
                    case 1:
                        System.out.print("Yatırmak istediğiniz tutar: ");
                        double yatir = sc.nextDouble();
                        sc.nextLine();
                        if (yatir > 0) {
                            kullanici.setBakiye(kullanici.getBakiye() + yatir);
                            System.out.println("Yeni bakiye: " + kullanici.getBakiye());
                        } else {
                            System.out.println("Pozitif bir tutar girin!");
                        }
                        break;

                    case 2:
                        System.out.print("Çekmek istediğiniz tutar: ");
                        double cek = sc.nextDouble();
                        sc.nextLine();
                        if (cek > 0 && cek <= kullanici.getBakiye()) {
                            kullanici.setBakiye(kullanici.getBakiye() - cek);
                            System.out.println("Yeni bakiye: " + kullanici.getBakiye());
                        } else {
                            System.out.println("Yetersiz bakiye veya geçersiz tutar!");
                        }
                        break;

                    case 3:
                        System.out.print("Havale yapılacak hesap numarası: ");
                        String hedefHesap = sc.nextLine();
                        System.out.print("Gönderilecek tutar: ");
                        double tutar = sc.nextDouble();
                        sc.nextLine();

                        boolean bulundu = false;
                        for (Informations kisi : giris.getKullanicilar()) {
                            if (kisi.getHesapNo().equals(hedefHesap)) {
                                if (tutar > 0 && tutar <= kullanici.getBakiye()) {
                                    kullanici.setBakiye(kullanici.getBakiye() - tutar);
                                    kisi.setBakiye(kisi.getBakiye() + tutar);
                                    System.out.println("Havale başarılı! Yeni bakiyeniz: " + kullanici.getBakiye());
                                } else {
                                    System.out.println("Yetersiz bakiye veya geçersiz tutar!");
                                }
                                bulundu = true;
                                break;
                            }
                        }
                        if (!bulundu) {
                            System.out.println("Hedef hesap bulunamadı!");
                        }
                        break;

                    case 4:
                        devam = false;
                        System.out.println("Çıkış yapılıyor...");
                        break;

                    default:
                        System.out.println("Geçersiz seçim!");
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Giris giris = new Giris();
        BankApp app = new BankApp();

        System.out.println("Bankamıza hoşgeldiniz!");
        System.out.println("Daha önce kayıt oldunuz mu? [E/H]");
        String cevap = sc.nextLine();

        if (cevap.equalsIgnoreCase("H")) {
            giris.kayitOl(sc);
        }

        Informations kullanici = giris.girisYap(sc);
        app.menu(kullanici, giris, sc);

        sc.close();
    }
}
