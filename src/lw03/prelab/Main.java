package src.lw03.prelab;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.LinkedHashMap;


public class Main {
    public static void main(String[] args) {
        //problem 1
        System.out.println("==== Problem 1 ====");
        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        List <String> list = new ArrayList<>();

        while (sc1.hasNext()){
            String lists1 = sc1.next();

            if (lists1.equals("ADD")){
                String add1 = sc1.nextLine();
                list.add(add1);
            } else if (lists1.equals("INSERT")){
                int index = sc1.nextInt();
                String add2 = sc1.nextLine();

                list.add(index, add2);
            } else {
                String remove = sc1.nextLine();
                list.remove(remove);
            }
        }
            System.out.println("Total Song : " + list.size());
            for (int i = 0; i < list.size(); i++){
                System.out.println((i + 1) + ". " + list.get(i));
        }
        
        System.out.println();
        System.out.println("==== Problem 2 ====");
        //problem 2
        Scanner sc = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        Set <String> nama = new LinkedHashSet<>();
        int dupe = 0;
        int unik = 0;
        int nomor = 1;

        while (sc.hasNext()) {
            String lists = sc.next();
            if (nama.contains(lists)){
                dupe++;
            }else {
                unik++;
                System.out.println((nomor++) + ". " + lists);
            }
            nama.add(lists);
        }
        System.out.println("Unique Registration = " + unik);
        System.out.println("Duplicate Registration = " + dupe);;

        System.out.println();
        System.out.println("===== Problem 3 =====");
        // problem 3
        Scanner sc3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedSales = 0;

        while (sc3.hasNextLine()) {
            String line = sc3.nextLine().trim();
            if (line.isEmpty()) continue; // lewati baris kosong

            String[] parts = line.split("\\s+");
            if (parts.length < 3) continue;

            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (type.equals("ADD")) {
                inventory.put(product, inventory.getOrDefault(product, 0) + quantity);
            } else if (type.equals("SELL")) {
                int currentStock = inventory.getOrDefault(product, 0);

                if (inventory.containsKey(product) && currentStock >= quantity) {
                    inventory.put(product, currentStock - quantity);
                } else {
                    failedSales++;
                }
            }
        }
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + failedSales);
    }
}

        

    
