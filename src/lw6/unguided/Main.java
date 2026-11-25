package src.lw6.unguided;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        // Write your main code here

        BinarySearchTree bst = new BinarySearchTree();
        String [] numbers = read.nextLine().split(" ");
        int target = read.nextInt();
        
        for (String number : numbers) {
            int data = Integer.parseInt(number);
            bst.insert(data);
        }

        System.out.print("Preorder : ");
        bst.preOrderHelper (bst.root);
        System.out.println();

        System.out.print("Inorder : ");
        bst.inOrderHelper(bst.root);
        System.out.println();

        System.out.print("Postorder : ");
        bst.postOrderHelper(bst.root);
        System.out.println();
        
        System.out.println("Search " + target + " : " + bst.search(target));

        System.out.println("Total nodes: " + bst.countNodes());
        System.out.println("Total leaves: " + bst.countLeaves());
        
         read.close();
        }




       
    }
