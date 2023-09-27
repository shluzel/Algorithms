package HW04;

import HW04.Node;

public class RedandBlackTree {

    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public boolean add(int value) {
        if(root != null) {
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node(value);
            root.color = Color.BLACK;
            return true;
        }
    }

    private boolean addNode(Node node, int value) {
        if(node.value == value) {
            return false;
        } else {
            if(value < node.value) {
                if(node.leftChild != null) {
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                } else {
                    node.leftChild = new Node(value);
                    return true;
                }
            } else {
                if(node.rightChild != null) {
                    boolean result = addNode(node.rightChild, value);
                    node.rightChild = rebalance(node.rightChild);
                    return result;
                } else {
                    node.rightChild = new Node(value);
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if(result.rightChild != null && result.rightChild.color == Color.RED &&
                (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                    needRebalance = true;
                    result = rightSwap(result);
            }
            if(result.leftChild != null && result.leftChild.color == Color.RED &&
                result.leftChild.leftChild != null && result.leftChild.leftChild.color == Color.RED) {
                    needRebalance = true;
                    result = leftSwap(result);
            }
            if(result.leftChild != null && result.leftChild.color == Color.RED &&
                result.rightChild != null && result.rightChild.color == Color.RED) {
                    needRebalance = true;
                    colorSwap(result);
            }
        } while(needRebalance);
        return result;
    }

    private Node leftSwap(Node node) {
        if(node != null) {
            Node leftChild = node.leftChild;
            Node middleChild = leftChild.rightChild;
            leftChild.rightChild = node;
            node.leftChild = middleChild;
            leftChild.color = node.color;
            node.color = Color.RED;
            return leftChild;
        } 
        return node;
    }

    private Node rightSwap(Node node) {
        if(node != null) {
            Node rightChild = node.rightChild;
            Node middleChild = rightChild.leftChild;
            rightChild.leftChild = node;
            node.rightChild = middleChild;
            rightChild.color = node.color;
            node.color = Color.RED;
            return rightChild;
        } 
        return node;
    }

    private void colorSwap(Node node) {
        node.leftChild.color = Color.BLACK;
        node.rightChild.color = Color.BLACK;
        node.color = Color.RED;
    }

    public Node searchNode(int value) {
        Node node = root;
        while (node != null) {
            if (node.value == value) {
                return node;
            } else if (value < node.value) {
                node = node.leftChild;
            } else {
                node = node.rightChild;
            }
        }
        return null;
    }
}
