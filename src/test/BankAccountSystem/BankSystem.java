package test.BankAccountSystem;

import java.util.Scanner;

public class BankSystem {
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
