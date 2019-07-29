package tree.binarytree;

public class BinaryTreeManager {

    private BinaryNode root;

    public BinaryTreeManager(BinaryNode root) {
        this.root = root;
    }

    public boolean addNode(BinaryNode node) {
        return addNodeInternal(root,node);
    }

    private boolean addNodeInternal(BinaryNode root, BinaryNode node) {
        if (node.value > root.value) {
            if (root.right == null) {
                root.right = node;
                return true;
            } else {
                return addNodeInternal(root.right, node);
            }
        } else {
            if (root.left == null) {
                root.left = node;
                return true;
            } else {
                return addNodeInternal(root.left, node);
            }
        }
    }

    public boolean addValue(int value) {
        return addValueInternal(root, value);
    }

    private boolean addValueInternal(BinaryNode root, int value) {
        if (value > root.value) {
            if (root.right == null) {
                BinaryNode right = new BinaryNode(value);
                root.right = right;
                return true;
            } else {
                return addValueInternal(root.right, value);
            }
        } else {
            if (root.left == null) {
                BinaryNode left = new BinaryNode(value);
                root.left = left;
                return true;
            } else {
                return addValueInternal(root.left, value);
            }
        }
    }

    public void printTreeByLevel() {
        printBinaryTree(root, 0);
    }

    private void printBinaryTree(BinaryNode root, int level) {
        System.out.printf("level:%d,value:%d\n", level, root.value);
        if (root.left != null)
            printBinaryTree(root.left, level + 1);
        if (root.right != null)
            printBinaryTree(root.right, level + 1);
    }


}
