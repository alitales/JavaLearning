package test.BankAccountSystem;

import java.util.Scanner;

public class BankApp {

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
