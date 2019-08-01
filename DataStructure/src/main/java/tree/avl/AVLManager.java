package tree.avl;

import org.omg.CORBA.NO_IMPLEMENT;

public class AVLManager {

    private Node root;

    public AVLManager(Node root) {
        this.root = root;
    }

    public boolean addValue(int value) {
        Node node = new Node(value);
        return addNode(node);
    }

    public boolean addNode(Node node) {
        return (root = addNodeInternal(root, node)) != null;
    }


    private Node addNodeInternal(Node root, Node node) {
        if (root == null) {
            root = new Node(node.value);
            return root;
        }
        if (root.value < node.value)
            root.left = addNodeInternal(root.left, node);
        else if (root.value > node.value)
            root.right = addNodeInternal(root.right, node);
        else
            return root;

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int balance = getBalanceFactor(root);
        if (balance > 1 && node.value < root.left.value)
            return rightRotation(root);

        if (balance < -1 && node.value > root.right.value)
            return leftRotation(root);

        if (balance > 1 && node.value > root.left.value) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }

        if (balance < -1 && node.value < root.right.value) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root;
    }


    public boolean deleteValue(int value) {
        return false;
    }

    //左旋
    private Node leftRotation(Node node) {
        Node y = node.right;
        Node T2 = y.right;
        y.left = node;
        node.right = T2;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    //右旋
    private Node rightRotation(Node node) {
        Node x = node.left;
        Node T2 = x.right;
        x.right = node;
        node.left = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return x;
    }

    //查找节点高度
    private int findHeight(Node node) {
        if (node == null)
            return 0;
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    public void printTreeByPreOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root != null)
            System.out.printf("%d--", root.value);
        preOrder(root.left);
        preOrder(root.right);
    }

}
