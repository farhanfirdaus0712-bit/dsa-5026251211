import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
 
public class Main {

    public static void main(String[] args) throws Exception {
 
        LinkedList<String[]> transactions = new LinkedList<>();
 
        LinkedList<String[]> customers = new LinkedList<>();
 
    
        Scanner fileScanner = new Scanner(new java.io.File("transactions.txt"));
 
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine().trim();
 
            if (line.isEmpty()) {
                continue; 
            }
 
            String[] parts = line.split(" ");
            String name = parts[0];
            String type = parts[1];
            String amount = parts[2];
 
            transactions.add(new String[]{name, type, amount});
 
            boolean sudahAda = false;
            for (String[] customer : customers) {
                if (customer[0].equals(name)) {
                    sudahAda = true;
                    break;
                }
            }

            if (!sudahAda) {
                customers.add(new String[]{name, "0"});
            }
        }
 
        fileScanner.close();
 
        // ---- Pindahkan semua transaksi dari LinkedList ke Queue (FIFO) ----
        Queue<String[]> transactionQueue = new LinkedList<>();
        transactionQueue.addAll(transactions);
 
        // ---- Stack untuk menyimpan transaksi WITHDRAW yang gagal ----
        Stack<String[]> failedTransactions = new Stack<>();
 
        // ---- Proses setiap transaksi dalam antrian, urutan FIFO ----
        while (!transactionQueue.isEmpty()) {
            String[] transaction = transactionQueue.poll();
 
            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);
 
            // cari customer yang sesuai di LinkedList customers
            String[] customer = null;
            for (String[] c : customers) {
                if (c[0].equals(name)) {
                    customer = c;
                    break;
                }
            }
 
            int balance = Integer.parseInt(customer[1]);
 
            if (type.equals("DEPOSIT")) {
                balance = balance + amount;
                customer[1] = String.valueOf(balance);
 
            } else if (type.equals("WITHDRAW")) {
                if (amount > balance) {
                    // saldo tidak cukup -> transaksi gagal, saldo tidak berubah
                    failedTransactions.push(transaction);
                } else {
                    balance = balance - amount;
                    customer[1] = String.valueOf(balance);
                }
            }
        }
 
        // ---- Tampilkan saldo akhir setiap customer ----
        System.out.println("=== Final Balances ===");
        for (String[] customer : customers) {
            System.out.println(customer[0] + " : " + customer[1]);
        }
 
        // ---- Tampilkan transaksi yang gagal, urutan LIFO dari Stack ----
        System.out.println("=== Failed Transactions ===");
        while (!failedTransactions.isEmpty()) {
            String[] failed = failedTransactions.pop();
            System.out.println(failed[0] + " " + failed[1] + " " + failed[2]);
        }
    }
}