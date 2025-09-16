////package test;
////System.out.println("Array'deki notlar: ");
////        for (int i = 0; i < puanlar.length; i++) {
////        System.out.println(puanlar[i]);
////        }
////
////        ArrayList<Integer> yeniNotlar = new ArrayList<>();
////        // Array elemanlarını tek tek ekliyoruz
////        for (int n : puanlar) {
////
////import java.util.ArrayList;
////
////public class List {
////    int[] puanlar = {20, 35, 56, 78, 98};
////
////    System.out.println("Arraydaki notlar: ");
////
////    for (int i = 0; i < puanlar.length; i++) {
////        System.out.println(puanlar[i]);
////    }
////
////    ArrayList<Integer> yeniNotlar = new ArrayList<>();
////    yeniNotlar.add(puanlar);
////    yeniNotlar.add(85);
////    yeniNotlar.add(54);
////    yeniNotlar.add(67);
////
////    for(int i = 0; i < yeniNotlar.size(); i++) {
////        System.out.println(yeniNotlar.get(i));
////    }
////
////    int toplamArray = 0;
////    for (int n : puanlar){
////        toplamArray += n;
////    }
////    double ortArray = toplamArray/puanlar.length;
////
////    int toplamlist = 0;
////    for (int n : yeniNotlar) {
////        toplamlist += n;
////    }
////    double ortList = (double) toplamList / yeniNotlar.size();
////
////        System.out.println("\nArray ortalaması: " + ortArray);
////        System.out.println("ArrayList ortalaması: " + ortList);
////}
//
//
//package test;
//
//import java.util.ArrayList;
//
//public class List {
//    public static void main(String[] args) {
//        int[] puanlar = {20, 35, 56, 78, 98};
//
//            yeniNotlar.add(n);
//        }
//        yeniNotlar.add(85);
//        yeniNotlar.add(54);
//        yeniNotlar.add(67);
//
//        System.out.println("\nArrayList'teki notlar:");
//        for (int i = 0; i < yeniNotlar.size(); i++) {
//            System.out.println(yeniNotlar.get(i));
//        }
//
//        int toplamArray = 0;
//        for (int n : puanlar) {
//            toplamArray += n;
//        }
//        double ortArray = (double) toplamArray / puanlar.length;
//
//        int toplamList = 0;
//        for (int n : yeniNotlar) {
//            toplamList += n;
//        }
//        double ortList = (double) toplamList / yeniNotlar.size();
//
//        System.out.println("\nArray ortalaması: " + ortArray);
//        System.out.println("ArrayList ortalaması: " + ortList);
//    }
//}

package test;
import java.util.ArrayList;

public class List {
    public static void main(String[] args) {
        // 1. Başlangıçta 5 öğrencinin notları array içinde
        int[] notlar = {80, 90, 75, 60, 85};

        System.out.println("Array’deki notlar:");
        for (int i = 0; i < notlar.length; i++) {
            System.out.println(notlar[i]);
        }

        // 2. Yeni öğrenciler geldikçe notları ArrayList'e ekleyelim
        ArrayList<Integer> yeniNotlar = new ArrayList<>();
        yeniNotlar.add(95);
        yeniNotlar.add(70);
        yeniNotlar.add(100);

        System.out.println("\nArrayList’teki notlar:");
        for (int i = 0; i < yeniNotlar.size(); i++) {
            System.out.println(yeniNotlar.get(i));
        }

        // 3. Ortalamaları hesapla
        int toplamArray = 0;
        for (int n : notlar) {
            toplamArray += n;
        }
        double ortArray = (double) toplamArray / notlar.length;

        int toplamList = 0;
        for (int n : yeniNotlar) {
            toplamList += n;
        }
        double ortList = (double) toplamList / yeniNotlar.size();

        System.out.println("\nArray ortalaması: " + ortArray);
        System.out.println("ArrayList ortalaması: " + ortList);
    }
}
