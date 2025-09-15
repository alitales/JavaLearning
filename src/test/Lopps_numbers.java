package test;

public class Lopps_numbers {
    public static void main(String[] args){
        for (int sayi = 2; sayi <= 50; sayi++) {
            boolean asal = true;

            for (int bolen = 2; bolen <= sayi / 2; bolen++) {
                if (sayi % bolen == 0) {
                    asal = false;
                    break;
                }
            }

            if (asal) {
                System.out.println(sayi + " Bir asal sayıdır.");
            }else {
                System.out.println(sayi + " Bir asal sayı değildir.");
            }
        }
    }
}
