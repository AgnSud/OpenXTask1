import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Tree createTree(int[] values, int[] idOfParents){
        List<Node> treeNodes = new ArrayList<>();

        for (int i : values){
            Node node = new Node(treeNodes.size(), i);
            treeNodes.add(node);
        }

        Tree tree = new Tree(treeNodes.get(0));
        for (int i = 1; i < values.length; i++){
            tree.insert(treeNodes.get(idOfParents[i]), treeNodes.get(i));
        }
        return tree;
    }

    private static boolean firstTestOfNumberOfLeafs(Tree testTree){
        return testTree.getNumberOfNodesWithoutChildren() == 5;
    }

    private static boolean secondTestOfNumberOfLeafs(){
        int[] values = {5};
        int[] idOfParents = {-1};
        Tree onlyRootTree = createTree(values, idOfParents);

        return onlyRootTree.getNumberOfNodesWithoutChildren() == 1;
    }
    private static boolean thirdTestOfNumberOfLeafs(){
        int[] values = {0, 1, 2, 3, 4, 5, 6};
        int[] idOfParents = {-1, 0, 1, 2, 3, 4, 5};
        Tree pathTree = createTree(values, idOfParents);

        return pathTree.getNumberOfNodesWithoutChildren() == 1;
    }

    private static boolean firstTestOfLongestDistFromRoot(Tree testTree){
        return testTree.getLongestDistFromRoot() == 4;
    }

    private static boolean secondTestOfLongestDistFromRoot(){
        int[] values = {5};
        int[] idOfParents = {-1};
        Tree onlyRootTree = createTree(values, idOfParents);

        return onlyRootTree.getLongestDistFromRoot() == 0;
    }

    private static boolean thirdTestOfLongestDistFromRoot(){
        int[] values = {0, 1, 2, 3, 4, 5, 6};
        int[] idOfParents = {-1, 0, 1, 2, 3, 4, 5};
        Tree pathTree = createTree(values, idOfParents);

        return pathTree.getLongestDistFromRoot() == 6;
    }

    private static boolean firstTestOfEqualityOfTrees(Tree testTree, int[] values1){
        int[] idOfParents2 = {-1, 0, 1, 2, 0, 4, 4, 6, 6, 8};
        Tree treeWithSamePreOrderButDiffIdOfParentsList = createTree(values1, idOfParents2);

        return !testTree.isEqual(testTree.getRoot(), treeWithSamePreOrderButDiffIdOfParentsList.getRoot());
    }

    private static boolean secondTestOfEqualityOfTrees(Tree testTree){
        int[] values = {5, 3, 5, 2, 7, 1, 0, 8, 5, 2};
        int[] idOfParents = {-1, 0, 1, 1, 0, 4, 4, 6, 7, 6};
        Tree treeWithSameChildrenButDiffPreOrder = createTree(values, idOfParents);

        return testTree.isEqual(testTree.getRoot(), treeWithSameChildrenButDiffPreOrder.getRoot());
    }

    private static boolean thirdTestOfEqualityOfTrees(Tree testTree){
        int[] values = {5};
        int[] idOfParents = {-1};
        Tree onlyRootTree = createTree(values, idOfParents);

        return !testTree.isEqual(testTree.getRoot(), onlyRootTree.getRoot());
    }

    private static boolean fourthTestOfEqualityOfTrees(Tree testTree, int[] idOfParents){
        int[] values = {5, 30, 5, 2, 7, 1, 0, 8, 5, 2};
        Tree treeWithSameShapeButDiffValues = createTree(values, idOfParents);

        return !testTree.isEqual(testTree.getRoot(), treeWithSameShapeButDiffValues.getRoot());
    }

    private static boolean fifthTestOfEqualityOfTrees(){
        int[] values1 = {0, 1, 2, 3, 4, 5};
        int[] idOfParents1 = {-1, 0, 1, 1, 3, 3};

        int[] values2 = {0, 1, 2, 4, 5, 3};
        int[] idOfParents2 = {-1, 0, 1, 2, 2, 1};

        Tree tree1 = createTree(values1, idOfParents1);
        Tree tree2 = createTree(values2, idOfParents2);

        return !tree1.isEqual(tree1.getRoot(), tree2.getRoot());
    }

    private static boolean sixthTestOfEqualityOfTrees(){
        int[] values = {1, 1, 1, 1, 1};
        int[] idOfParents1 = {-1, 0, 0, 1, 1};
        int[] idOfParents2 = {-1, 0, 1, 0, 3};

        Tree tree1 = createTree(values, idOfParents1);
        Tree tree2 = createTree(values, idOfParents2);

        return !tree1.isEqual(tree1.getRoot(), tree2.getRoot());
    }


    public static void main(String[] args) {
//        tree in next test: 5 - 7 - 0 - 8 - 5
//                                     - 2
//                                 - 1
//                             - 3 - 5
//                                 - 2
        int[] values1 = {5, 3, 2, 5, 7, 1, 0, 2, 8, 5}; //pre-order values1
        int[] idOfParents1 = {-1, 0, 1, 1, 0, 4, 4, 6, 6, 8}; //unique id of parent for each value from values1 (-1 means root)
        Tree testTree = createTree(values1, idOfParents1);

        System.out.println("Test of number of leafs in tree from task: " +
                (firstTestOfNumberOfLeafs(testTree) ? "passed" : "NOT PASSED"));
        //tree in next test: 5
        System.out.println("Test of number of leafs in tree with only root in it: " +
                (secondTestOfNumberOfLeafs() ? "passed" : "NOT PASSED"));
        //tree in next test: 0 - 1 - 2 - 3 - 4 - 5 - 6
        System.out.println("Test of number of leafs in tree which has one path: " +
                (thirdTestOfNumberOfLeafs() ? "passed" : "NOT PASSED"));


        System.out.println();
        System.out.println("Test of longest distance from root in tree from task: " +
                (firstTestOfLongestDistFromRoot(testTree) ? "passed" : "NOT PASSED"));
        //tree in next test: 5
        System.out.println("Test of longest distance from root in tree with only root in it: " +
                (secondTestOfLongestDistFromRoot() ? "passed" : "NOT PASSED"));
        //tree in next test: 0 - 1 - 2 - 3 - 4 - 5 - 6
        System.out.println("Test of longest distance from root in tree which has one path: " +
                (thirdTestOfLongestDistFromRoot() ? "passed" : "NOT PASSED"));

        System.out.println();
//        tree in next test: 5 - 7 - 0 - 8 - 5
//                                     - 2
//                                 - 1
//                             - 3 - 2 - 5
        System.out.println("Test of equality of trees with same pre-order, but different Id of parents list (should not be equal): "+
                (firstTestOfEqualityOfTrees(testTree, values1) ? "passed" : "NOT PASSED"));
//        tree in next test: 5 - 7 - 0 - 2
//                                     - 8 - 5
//                                 - 1
//                             - 3 - 2
//                                 - 5
        System.out.println("Test of equality of trees with same values and children, but different pre-order list (should be equal): " +
                (secondTestOfEqualityOfTrees(testTree) ? "passed" : "NOT PASSED"));
        //tree in next test: 5
        System.out.println("Test of equality of trees with different number of nodes (should not be equal): " +
                (thirdTestOfEqualityOfTrees(testTree) ? "passed" : "NOT PASSED"));
//        tree in next test: 5 - 7 - 0 - 2
//                                     - 8 - 5
//                                 - 1
//                             - 30 - 2
//                                 - 5
        System.out.println("Test of equality of trees with same shape, but different values of nodes (should not be equal): " +
                (fourthTestOfEqualityOfTrees(testTree, idOfParents1) ? "passed" : "NOT PASSED"));

//        tree1 in next test: 0 - 1 - 3 - 4
//                                      - 5
//                                  - 2
//        tree1 in next test: 0 - 1 - 3
//                                  - 2 - 5
//                                      - 4
        System.out.println("Test of equality of trees with same shape, but different children (should not be equal): " +
                (fifthTestOfEqualityOfTrees() ? "passed" : "NOT PASSED"));

//        tree1 in next test: 1 - 1
//                              - 1 - 1
//                                  - 1
//        tree1 in next test: 1 - 1 - 1
//                              - 1 - 1
        System.out.println("Test of equality of trees with same values of every node, but different size (should not be equal): " +
                (sixthTestOfEqualityOfTrees() ? "passed" : "NOT PASSED"));

    }
}