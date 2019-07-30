package tree.multitree;

import java.util.LinkedList;
import java.util.List;

public class MultiNode {
    public int value;
    public List<MultiNode> children = new LinkedList<>();

    public MultiNode(int value) {
        this.value = value;
    }

    public MultiNode() {
    }
}
