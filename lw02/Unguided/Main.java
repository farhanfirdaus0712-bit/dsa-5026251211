import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
 

public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner (Main.class.getResourceAsStream("orders.txt"));
    
        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> foodStock = new LinkedList<>();
        LinkedList<String[]> drinkStock = new LinkedList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
 
            if (line.isEmpty()) {
                continue; 
            }

        
            String[] parts = line.split(" ");
            String name = parts[0];
            String sideDish= parts[1];
            String drink = parts[2];
            String table = parts[3];
            orders.add(new String[]{name, sideDish, drink, table}); 

            foodStock.add(new String[]{"Bakso", "2"});
            foodStock.add(new String[]{"Sate", "1"});
            foodStock.add(new String[]{"Soto", "2"});
            
            drinkStock.add(new String[]{"EsTeh", "4"});
            drinkStock.add(new String[]{"Bakso", "2"});

            Queue<String[]> ordersQueue = new LinkedList<>();
        ordersQueue.addAll(orders);
        Stack<String[]> failedTransactions = new Stack<>();

            while (!ordersQueue.isEmpty()) {    
            String[] oStrings = ordersQueue.poll();

            String nameString = orders[0];
            String sideDishString = orders[1];
            String drinkString = orders[2];
            int table = Integer.parseInt(orders[3]);

                 String[] ordeStrings = null;
            for (String[] c : ordeStrings{
                if (c[0].equals(name)) {
                    orders = c;
                    break;
                }
            }

        }
        if (type.equals("MAKANAN")) {
                balance = name + sideDish + drink + table;
                orders [1] = String.valueOf(b);
    }

             









    }
    
}
