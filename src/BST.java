/** A simple binary search tree of ints. Duplicate values are ignored. */
public class BST {

    private static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    /** Adds value to the tree (does nothing if it is already there). */
    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    /** Searches for value and returns how many nodes were visited to find it. */
    public int find(int value) {
        int count = 0;
        Node current = root;
        while (current != null) {
            count++;
            if (value == current.value) {
                return count;
            }
            current = (value < current.value) ? current.left : current.right;
        }
        return count;
    }

    /** Height of the tree: a single node has height 0, an empty tree -1. */
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
