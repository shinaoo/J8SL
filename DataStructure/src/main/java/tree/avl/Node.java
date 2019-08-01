package tree.avl;

public class Node {
    public int value;
    public Node left,right;
    public int height;

    public Node(int value) {
        this.value = value;
        this.height = 1;
    }
}
