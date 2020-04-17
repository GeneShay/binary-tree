package test;

import main.BinaryTree;
import org.junit.Test;

public class BinaryTreeTest {

    @Test
    public void testBinaryTree(){
        BinaryTree<Integer> tree = new BinaryTree<>();
        Integer[] integers = {1,5,2,3,8,6,4};
        for(int i : integers) {
            tree.add(i);
        }

        assert tree.isNodeAvailable(4);
    }
}