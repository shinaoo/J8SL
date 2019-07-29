package tree.binarytree;

public class BinaryTreeMain {

    public static void main(String[] args){
        BinaryNode root = new BinaryNode(20);
        BinaryTreeManager manager = new BinaryTreeManager(root);
        manager.printTreeByLevel();

        System.out.printf("------------------------------------------");

        manager.addValue(10);
        manager.addValue(30);
        manager.printTreeByLevel();

        System.out.printf("------------------------------------------");

        manager.addNode(new BinaryNode(15));
        manager.addNode(new BinaryNode(40));
        manager.printTreeByLevel();



    }
}
