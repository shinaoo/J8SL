package tree.multitree;

import java.util.LinkedList;
import java.util.List;

public class TreeManager {

    private MultiNode root;

    public TreeManager(MultiNode root) {
        this.root = root;
    }

    public boolean addValue(int value){
        return addValueInternal(root,value,0);
    }

    //对10求余..余数是哪一层就留在哪一层,当没有该层,是在当时多叉树的最底层
    private boolean addValueInternal(MultiNode root,int value,int level){
        if (value % 10 == level){
            root.children.add(new MultiNode(value));
            return true;
        }else{
            if (root.children.size() == 0){
                root.children.add(new MultiNode(value));
                return true;
            }else{
                return addValueInternal(root.children.get(0),value,level+1);
            }
        }
    }

    public boolean addMultiNode(MultiNode node){
        return addMultiNodeInternal(root,node,0);
    }

    private boolean addMultiNodeInternal(MultiNode root,MultiNode node,int level){
        if (node.value % 10 == level){
            root.children.add(node);
            return true;
        }else{
            if (root.children.size() == 0){
                root.children.add(node);
                return true;
            }else{
                return addMultiNodeInternal(root.children.get(0),node,level+1);
            }
        }
    }

    public void printMultiNodeByLevel(){
        List<List<MultiNode>> nodes = new LinkedList<>();
        getNodeByLevel(root,0,nodes);
        nodes.forEach(list->{
            list.forEach(node->{
                System.out.printf("%d",node.value);
            });
            System.out.println("--------------------------");
        });
    }

    private void getNodeByLevel(MultiNode root,int level,List<List<MultiNode>> nodes){
        if (nodes.size() <= level){
            List<MultiNode> tmp = new LinkedList<>();
            nodes.add(tmp);
        }
        nodes.get(level).add(root);
        root.children.forEach(node -> {
            getNodeByLevel(node,level+1,nodes);
        });
    }



}
