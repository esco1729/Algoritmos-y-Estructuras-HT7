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
	
	public void setLeft(BinaryTree<E> newLeft) {
		if(isEmpty()) return;
		if(left!= null && left.parent() == this) left.setParent(null);
		left = newLeft;
		left.setParent(this);
	}
	
    public BinaryTree<E> left()
    {
        return left;
    }
	
    protected void setParent(BinaryTree<E> newParent)
    {
        if (!isEmpty()) {
            parent = newParent;
        }
    }
    
    public void setRight(BinaryTree<E> newRight)
    {
        if (isEmpty()) return;
        if (right != null && right.parent == this) right.setParent(null);//si no esta vacio lo re ingresa
        right = newRight;
        right.setParent(this);
    }
}
