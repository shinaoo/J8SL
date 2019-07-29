package tree.binarytree;

public class BinaryTreeMain {

    public static void main(String[] args){
        BinaryNode root = new BinaryNode(20);
        BinaryTreeManager manager = new BinaryTreeManager(root);
        manager.printTreeNodesByLevel();

        System.out.printf("------------------------------------------\n");

        manager.addValue(10);
        manager.addValue(30);
        manager.printTreeNodesByLevel();

        System.out.printf("------------------------------------------\n");

        manager.addNode(new BinaryNode(15));
        manager.addNode(new BinaryNode(40));
        manager.addNode(new BinaryNode(25));
//        manager.printTreeByLevel();
        manager.printTreeNodesByLevel();



    }
}
