package tree.binarytree;

import java.util.LinkedList;
import java.util.List;

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


    public boolean deleteNodeByValue(int value){
        return deleteNodeByValueInternal(root,value) != null ;
    }

    private BinaryNode deleteNodeByValueInternal(BinaryNode root,int value){
        if (root == null){
            return root;
        }
        if (root.value > value){
            root.left = deleteNodeByValueInternal(root.left,value);
        }else if (root.value < value){
            root.right = deleteNodeByValueInternal(root.right,value);
        }else{
            if (root.left != null && root.right != null){
                BinaryNode tmp = null;
                tmp = findMin(root.right);
                root.value = tmp.value;
                root.right = deleteNodeByValueInternal(root.right,root.value);
            }else{
//                tmp = root;
                if (root.left == null){
                    root = root.right;
                }else if (root.right == null){
                    root = root.left;
                }
            }
        }
        return root;
    }

    private BinaryNode findMin(BinaryNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
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

    public void printTreeNodesByLevel(){
        //以List方式获取结点再打印
        List<List<BinaryNode>> nodes = new LinkedList<>();

        getNodeByLevel(root,0,nodes);
        nodes.forEach(list ->{
            list.forEach(node ->{
                System.out.printf("%d---",node.value);
            });
            System.out.println("");
        });
    }

    private void getNodeByLevel(BinaryNode root,int level,List<List<BinaryNode>> nodes){
        if (nodes.size() <= level){
            List<BinaryNode> tmp = new LinkedList<>();
            nodes.add(tmp);
        }
        nodes.get(level).add(root);
        if (root.left != null)
            getNodeByLevel(root.left,level+1,nodes);
        if (root.right != null)
            getNodeByLevel(root.right,level+1,nodes);
    }


}
