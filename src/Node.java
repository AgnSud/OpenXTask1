import java.util.ArrayList;
import java.util.List;

public class Node {
    private final int value;
    private final int nodeID;
    private Node parent;
    private final List<Node> children;
    private int distFromRoot;

    public Node(int id, int val){
        nodeID = id;
        value = val;
        this.children = new ArrayList<>();
    }

    public void addChild(Node node){
        if (!this.children.contains(node) && node != null) {
            this.children.add(node);
        }
    }

    public int getNumberOfChildren() {
        return children.size();
    }

    public int getValue() {
        return value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

    public int getParentID() {
        return parent.getParentID();
    }

    public int getNodeID() {
        return nodeID;
    }

    public int getDistFromRoot() {
        return distFromRoot;
    }

    public void setDistFromRoot(int distFromRoot) {
        this.distFromRoot = distFromRoot;
    }
}
