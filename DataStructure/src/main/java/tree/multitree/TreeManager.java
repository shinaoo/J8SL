package tree.multitree;

import java.util.LinkedList;
import java.util.List;

public class TreeManager {

    private MultiNode root;

    public TreeManager(MultiNode root) {
        this.root = root;
    }

    //添加规则是按10求余安置层数，如果没有该层就都位于最底层
    public boolean addValue(int value){
        return addValueInternal(root,value,0);
    }

    private boolean addValueInternal(MultiNode root,int value,int level){
        return false;
    }


    public boolean addMultiNode(MultiNode node){
        return false;
    }

    private boolean addMultiNodeInternal(MultiNode root,MultiNode node){
        return false;
    }

    public void printMultiNodeByLevel(){
        List<List<MultiNode>> nodes = new LinkedList<>();
        getNodeByLevel(root,0,nodes);
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
