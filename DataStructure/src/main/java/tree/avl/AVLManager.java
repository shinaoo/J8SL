package tree.avl;

public class AVLManager {

    private Node root;

    public AVLManager(Node root) {
        this.root = root;
    }

    public boolean addValue(int value) {
        return false;
    }

    public boolean deleteValue(int value) {
        return false;
    }

    private Node findMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    //左旋
    private Node leftRotation(Node node) {
        Node tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        return tmp;
    }

    //右旋
    private Node rightRotation(Node node) {
        Node tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        return tmp;
    }

    private Node leftRightRotation(Node node){
        node = leftRotation(node);
        return rightRotation(node);
    }

    private Node rightLeftRotation(Node node){
        node = rightRotation(node);
        return leftRotation(node);
    }

    //查找节点高度
    private int findHeight(Node node) {
        if (node == null)
            return 0;
        int leftHeight = findHeight(node.left);
        int rightHeight = findHeight(node.right);
        return Math.max(leftHeight,rightHeight) + 1;
    }


}
