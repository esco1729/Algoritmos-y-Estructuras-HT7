// An implementation of nodes for use in binary trees.
// (c) 2007 duane a. bailey LIBRO DE TEXTO

import java.lang.Math;
import java.util.Iterator;

public class BinaryTree<E>{
    protected E val; // value associated with node
    protected BinaryTree<E> parent; // parent of node
    protected BinaryTree<E> left, right; // children of node


    public BinaryTree(){
        val = null;
        parent = null; left = right = this;
    }

    /**
     * Constructs a tree node with no children.  Value of the node
     * and subtrees are provided by the user
     */
    public BinaryTree(E value)
    {
        //Assert.pre(value != null, "Tree values must be non-null.");
        val = value;
        right = left = new BinaryTree<E>();
        setLeft(left);
        setRight(right);
    }

    /**
     * Constructs a tree node with two children.  Value of the node
     * and subtrees are provided by the user.
     */
    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right){
        //Assert.pre(value != null, "Tree values must be non-null.");
        val = value;
        if (left == null) { left = new BinaryTree<E>(); }
        setLeft(left);
        if (right == null) { right = new BinaryTree<E>(); }
        setRight(right);
    }

    /**
     * Get left subtree of current node
     */
    public BinaryTree<E> left(){
        return left;
    }

    /**
     * Get right subtree of current node
     */
    public BinaryTree<E> right(){
        return right;
    }

    /**
     * Get reference to parent of this node
     */
    public BinaryTree<E> parent(){
        return parent;
    }
    
    /**
     * Update the left subtree of this node.  Parent of the left subtree
     * is updated consistently.  Existing subtree is detached
     */
    public void setLeft(BinaryTree<E> newLeft){
        if (isEmpty()) return;
        if (left != null && left.parent() == this) left.setParent(null);
        left = newLeft;
        left.setParent(this);
    }

    /**
     * Update the right subtree of this node.  Parent of the right subtree
     * is updated consistently.  Existing subtree is detached
     */
    public void setRight(BinaryTree<E> newRight){
        if (isEmpty()) return;
        if (right != null && right.parent() == this) right.setParent(null);
        right = newRight;
        right.setParent(this);
    }

    /**
     * Update the parent of this node
     */
    protected void setParent(BinaryTree<E> newParent){
        if (!isEmpty()) {
            parent = newParent;
        }
    }

    /**
     * Returns the number of descendants of node
     */
    public int size(){
        if (isEmpty()) return 0;
        return left().size() + right().size() + 1;
    }

    /**
     * Returns reference to root of tree containing n
     */
    public BinaryTree<E> root(){
        if (parent() == null) return this;
        else return parent().root();
    }

    /**
     * Returns true if tree is empty.
     */
    public boolean isEmpty(){
        return val == null;
    } 

    /**
     * Determine if this node is a left child
     */
    public boolean isLeftChild()
    {
        if (parent() == null) return false;
        return this == parent().left();
    }

    /**
     * Determine if this node is a right child
     */
    public boolean isRightChild(){
        if (parent() == null) return false;
        return this == parent().right();
    }

    /**
     * Returns value associated with this node
     */
    public E value(){
        return val;
    }

    /**
     * Set's value associated with this node
     */
    public void setValue(E value){
        val = value;
    }

    /**
     * @post return sum of hashcodes of the contained values
     */
    public int hashCode(){
        if (isEmpty()) return 0;
        int result = left().hashCode() + right().hashCode();
        if (value() != null) result += value().hashCode();
        return result;
    }
    
	/**
     * Compute the depth of a node.  The depth is the path length
     * from node to root
     */
    public int depth(){
        if (parent() == null) return 0;
        return 1 + parent.depth();
    }
	
    /**
     * Returns a string representing the tree rooted at this node.
     * <font color="#FF0000">WARNING</font> this can be a very long string.
     */
    public String treeString(){
        String s = "";
        for (int i=0; i < this.depth(); i++){
            s += "\t|";
        }
        
        s += ("<" + val + " : " + getHand() + ">\n");
        
        if (!left.isEmpty()) s += left.treeString();
        if (!right.isEmpty()) s += right.treeString();

        return s;
    }
    
    /**
     * Support method for {@link #toString}. Returns R if this is node 
     * is a right child, L if this node is a left child and Root if this
     * node is the root.
     */
    private String getHand(){
        if (isRightChild()) return "R";
        if (isLeftChild()) return "L";
        return "Root";  
    }
    
    
    /**
     * Returns a representation the subtree rooted at this node
     */
    public String toString(){
        if (isEmpty()) return "<BinaryTree: empty>";
        StringBuffer s = new StringBuffer();
        s.append("<BinaryTree "+value());
        if (!left().isEmpty()) s.append(" "+left());
        else s.append(" -");
        if (!right().isEmpty()) s.append(" "+right());
        else s.append(" -");
        s.append('>');
        return s.toString();
    }
    
    public static void add(BinaryTree Ac, BinaryTree Ne) {

        if (Ac.value().toString().compareTo(Ne.value().toString()) > 0) {
            if (Ac.left().value() == null) {
                Ac.setLeft(Ne);
            } else {
                add(Ac.left(), Ne);
            }
        } else if (Ac.value().toString().compareTo(Ne.value().toString()) < 0) {
            if (Ac.right().value() == null) {
                Ac.setRight(Ne);
            } else {
                add(Ac.right(), Ne);
            }
        }
    }
    
    public String inOrder(BinaryTree bt) {
        String arbol = "";
        if (bt.val != null) {
            arbol += inOrder(bt.left);
            arbol += bt.value();
            arbol += inOrder(bt.right);
        }
        return arbol;
    }

    public String buscar(String Wr) {
        Wr = Wr.toLowerCase();

        if (this.val == null) {
            return null;
        } else if (((Association) this.val).theKey.toString().equals(Wr)) {
            return (String) ((Association) this.val).theValue;
        } else if (((Association) this.val).theKey.toString().compareTo(Wr) > 0) {
            return this.left.buscar(Wr);
        } else if (((Association) this.val).theKey.toString().compareTo(Wr) < 0) {
            return this.right.buscar((Wr));
        }
        return null;

    }
}