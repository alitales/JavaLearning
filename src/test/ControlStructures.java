package test;

public class ControlStructures {
    public static void main(String[] args) {
        double ilkVize = 75;
        double ikinciVize = 64.3;
        double fnal = 43.6;
        double ortalama = (ilkVize * 0.30) + (ikinciVize * 0.30) + (fnal * 0.40);
        String ad = "Ali";

        if (ortalama >= 60) {
            System.out.println(ad + " Bey, Ortalamanız: " + ortalama + "'dır. Tebrikler, geçtiniz!");
        } else if (ortalama >= 57 && ortalama <= 59.9) {
            System.out.println(ad + " Bey, Ortalamanız: " + ortalama + "'dır. Hocaya gidip yalvarabilirsiniz.");
        } else {
            System.out.println(ad + " Bey, Ortalamanız: " + ortalama + "'dır. Maalesef kaldınız.");
        }
    }
}


