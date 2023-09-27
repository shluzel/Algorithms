package HW04;

public class TreePrinter {
    public static void print(Node node, String sp) {
        if (node != null) {
            System.out.println(sp + node.value + " " + node.color);
            print(node.leftChild, sp + "   ");
            print(node.rightChild, sp + "   ");
        }
    }
}
