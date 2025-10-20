package org.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {


    public static ArrayList<String> groceryList = new ArrayList<>();

    // uygulmanin secenek kismii
    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("=== Market Uygulaması ===");
            System.out.println("0 - Çıkış");
            System.out.println("1 - Ürün Ekle");
            System.out.println("2 - Ürün Çıkar");
            System.out.print("Seçiminiz: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Uygulamadan çıkılıyor...");
                    break;
                case 1:
                    System.out.print("Eklemek istediğiniz elemanı/elemanları girin (virgülle ayırabilirsiniz): ");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    printSorted();
                    break;
                case 2:
                    System.out.print("Çıkarmak istediğiniz elemanı/elemanları girin (virgülle ayırabilirsiniz): ");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    printSorted();
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen 0, 1 veya 2 girin.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // liste elemean ekleyelimm
    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (!checkItemIsInList(item)) {
                groceryList.add(item);
                System.out.println(item + " listeye eklendi.");
            } else {
                System.out.println(item + " zaten listede mevcut.");
            }
        }
        Collections.sort(groceryList);
    }

    // Listtden eleman cikaralimmm
    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            item = item.trim();
            if (checkItemIsInList(item)) {
                groceryList.remove(item);
                System.out.println(item + " listeden çıkarıldı.");
            } else {
                System.out.println(item + " listede bulunamadı.");
            }
        }
        Collections.sort(groceryList);
    }

    // eleman listede mi kontrol edelim
    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    // lsiteyi siralayarrakk yazalimm
    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("=== Güncel Market Listesi ===");
        if (groceryList.isEmpty()) {
            System.out.println("Liste boş.");
        } else {
            for (String item : groceryList) {
                System.out.println("- " + item);
            }
        }
    }
}
