package HW04;

import HW04.RedandBlackTree;

public class HW04 {
    public static void main(String[] args) {

        RedandBlackTree tree = new RedandBlackTree();
        tree.add(24);
        tree.add(5);
        TreePrinter.print(tree.getRoot(), "");
        
        if(tree.add(5)) { 
            TreePrinter.print(tree.getRoot(), "");
        } 
        else {
            System.out.println("Error: this value already exists in tree");
        }                      

        tree.add(1);
        System.out.println("-----------");
        TreePrinter.print(tree.getRoot(), "");
        
        tree.add(15);
        System.out.println("-----------");
        TreePrinter.print(tree.getRoot(), "");
        
        tree.add(3);
        System.out.println("-----------");
        TreePrinter.print(tree.getRoot(), "");
        
        tree.add(8);
        System.out.println("-----------");
        TreePrinter.print(tree.getRoot(), "");

        tree.add(13);
        System.out.println("-----------");
        TreePrinter.print(tree.getRoot(), "");

        tree.add(16);
        System.out.println("-----------");
        TreePrinter.print(tree.getRoot(), "");
        }
}

