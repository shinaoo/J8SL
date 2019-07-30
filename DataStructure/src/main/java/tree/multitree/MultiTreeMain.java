package tree.multitree;

public class MultiTreeMain {
    public static void main(String[] args){

        MultiNode root = new MultiNode(20);
        TreeManager treeManager = new TreeManager(root);

        treeManager.addValue(40);
        treeManager.addValue(30);
        treeManager.addValue(10);
        treeManager.addMultiNode(new MultiNode(50));
        treeManager.addValue(25);
        treeManager.printMultiNodeByLevel();

    }
}
