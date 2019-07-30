package tree.binarytree;

public class BinaryTreeMain {

    public static void main(String[] args){
        BinaryNode root = new BinaryNode(20);
        BinaryTreeManager manager = new BinaryTreeManager(root);
//        manager.printTreeNodesByLevel();
//
//        System.out.printf("------------------------------------------\n");
//
//        manager.addValue(10);
//        manager.addValue(30);
//        manager.printTreeNodesByLevel();
//
//        System.out.printf("------------------------------------------\n");
//
//        manager.addNode(new BinaryNode(15));
//        manager.addNode(new BinaryNode(40));
//        manager.addNode(new BinaryNode(25));
////        manager.printTreeByLevel();
//        manager.printTreeNodesByLevel();

        manager.addValue(15);
        manager.addValue(30);
        manager.addValue(40);
        manager.addValue(25);
        manager.addValue(13);
        manager.addValue(18);
        manager.addValue(17);
        manager.addValue(19);
        manager.addValue(14);
        manager.addValue(12);

        manager.printTreeNodesByLevel();

        manager.deleteNodeByValue(15);

        manager.printTreeNodesByLevel();



    }
}
