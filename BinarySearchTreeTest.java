import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
	
	@Test
    void search() {
        BinarySearchTree<Integer> binary = new BinarySearchTree<Integer>();
        for (int i = 0; i < 2; i++) {
            binary.add(i);
        }
        
        binary.contains(2);
    }
	
	@Test
	void add() {
		BinarySearchTree<Integer> binary = new BinarySearchTree<Integer>();
        for (int i = 0; i < 2; i++) {
            binary.add(i);
        }
        String tree=binary.treeString();
        System.out.println(tree);
        tree = binary.toString();
        System.out.println(tree);
    }
	

	
}