package tree.avl;

public class AVLMain {

    //AVL本身首先是一颗二叉查找树
    //带有平衡条件:每个节点的左右子树高度之差的绝对值最多为1
    //其实可以看出只是一个带有平衡功能的二叉查找树
    public static void main(String[] args){
        Node root = new Node(10);
        AVLManager manager = new AVLManager(root);

        manager.addValue(20);
        manager.addValue(30);
        manager.addValue(40);
        manager.addValue(50);
        manager.addValue(25);
        manager.printTreeByPreOrder();
    }
}
