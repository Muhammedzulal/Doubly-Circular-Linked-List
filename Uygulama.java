package LinkedList4;

import java.util.Scanner;

public class Uygulama {
    public static void main(String[] args) {
        Liste liste = new Liste();
        Scanner sc = new Scanner(System.in);
        int choose = -1;
        while (choose != 0) {
            System.out.println("1-Başa ekle");
            System.out.println("2-Sona ekle");
            System.out.println("3-Araya ekle");
            System.out.println("4-Baştan sil");
            System.out.println("5-Sondan sil");
            System.out.println("6-Aradan sil");
            System.out.println("0-Çıkış");
            System.out.println();
            System.out.print("Seçim :");
            choose = sc.nextInt();
            if (choose == 1) {
                System.out.print("Data :");
                int data = sc.nextInt();
                liste.basaEkle(data);
            } else if (choose == 2) {
                System.out.print("Data :");
                int data = sc.nextInt();
                liste.sonaEkle(data);
            } else if (choose == 3) {
                System.out.print("Index :");
                int index = sc.nextInt();
                System.out.print("Data :");
                int data = sc.nextInt();
                liste.arayaEkle(index, data);
            } else if (choose == 4) {
                liste.bastanSil();
            } else if (choose == 5) {
                liste.sondanSil();
            } else if (choose == 6) {
                System.out.print("Index :");
                int index = sc.nextInt();
                liste.aradanSil(index);
            } else {
                if (choose != 0)
                    System.out.println("Hatalı seçim!!!!");
            }
            System.out.println();
            liste.yazdir();
            System.out.println();
        }
        sc.close();
    }
}
