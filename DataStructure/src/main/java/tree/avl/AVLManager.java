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

    //左旋
    private Node leftRotation(Node node){
        Node self = node;
        Node tmp = node.right.left;
        node = node.right;
        node.left = self;
        self.right = tmp;
        return node;
    }

    //右旋
    private Node rightRotation(Node node){
        Node self = node;
        Node tmp = node.left.right;
        node = node.left;
        node.right = self;
        self.left = tmp;
        return node;
    }
}
