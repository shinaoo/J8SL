package tree.avl;

public class AVLManager {

    private Node root;

    public AVLManager(Node root) {
        this.root = root;
    }

    public boolean addValue(int value){
        return false;
    }

    public boolean deleteValue(int value){
        return false;
    }

    private Node findMax(Node node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }

    private Node findMin(Node node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }
}
