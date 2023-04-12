
public class Tree {
    private final Node root;
    private int numberOfNodesWithoutChildren;
    private int longestDistFromRoot;

    public Tree(Node node){
        root = node;
        numberOfNodesWithoutChildren = 1;
        root.setDistFromRoot(0);
        longestDistFromRoot = 0;
    }

    public void insert(Node parent, Node child){
        child.setParent(parent);
        if (parent.getNumberOfChildren() == 0)
            numberOfNodesWithoutChildren -= 1;

        parent.addChild(child);
        if (child.getNumberOfChildren() == 0)
            numberOfNodesWithoutChildren += 1;

        child.setDistFromRoot(parent.getDistFromRoot() + 1);
        int dist = child.getDistFromRoot();
        if (dist > longestDistFromRoot)
            longestDistFromRoot = dist;
    }

    public boolean isEqual(Node current, Node secondTreeCurrent){
        if (current.getValue() != secondTreeCurrent.getValue())
            return false;
        if (current.getNumberOfChildren() != secondTreeCurrent.getNumberOfChildren())
            return false;

        if (current.getNumberOfChildren() != 0){
            for (Node children : current.getChildren()){
                if (secondTreeCurrent.getChildren().stream().noneMatch(o -> o.getValue() == children.getValue()))
                    return false;
                Node stc = secondTreeCurrent.getChildren().stream().filter(o -> o.getValue() == children.getValue()).findFirst().get();
                return isEqual(children, stc);
            }
        }
        return true;
    }

    public Node getRoot() {
        return root;
    }

    public int getLongestDistFromRoot() {
        return longestDistFromRoot;
    }

    public int getNumberOfNodesWithoutChildren(){
        return numberOfNodesWithoutChildren;
    }
}
