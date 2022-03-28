protected BinaryTree<E> parent;
protected BinaryTree<E> left, right;

public class BinarySearchTree<E> {

	public BinaryTree() {
		val = null;
		parent = null; 
		left = right = this;
	}
	
	public BinaryTree(E value) {
		val = value;
		right = left = new BinaryTree<E>();
		setLeft(left);
		setRight(right);
	}
	
	
}
