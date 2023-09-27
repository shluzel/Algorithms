package HW04;

public class Node {
    int value;
    Node leftChild;
    Node rightChild;
    Color color;

    public Node(int value) {
        this.value = value;
        this.color = Color.RED;
    }
}
