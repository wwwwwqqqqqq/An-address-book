package AnAddressBook;

/**
 * An iterator over a binary tree.
 * @author Qin Weiwei
 * @version 2.0
 */

import java.util.LinkedList;
import java.lang.UnsupportedOperationException;

public class TreeIterator<T> implements java.util.Iterator<T>{
	/**
	 * The collection traversed by this iterator
	 */
	private BinaryTreeBasis<T> tree;
    /**
     * An ordered list of nodes traversed by this iterator. 
     * Empty queue indicates no traversal type currently selected or 
     * end of current traversal has been reached
     */
	private LinkedList<TreeNode<T>> queue;
	
	/**
	 * Constructs an iterator over a binary tree. 
	 * @param tree A reference to a binary tree
	 */
	public TreeIterator(BinaryTreeBasis<T> tree) {
		this.tree = tree;
		this.queue = new LinkedList<TreeNode<T>>();
	}
	
	/**
	 * Returns the next element in the iteration.
	 * @return the next element in the iteration
	 */
	public T next() {
		return this.queue.remove().getElement();
	}
	
	/**
	 * Returns true if the iteration has more elements. 
	 * (In other words, returns true if next() would return an element rather than throwing an exception.)
	 * @return A boolean value specifying if there is an element to be returned
	 */
	public boolean hasNext() {
		return !this.queue.isEmpty();
	}
	
	/**
	 * Removes from the underlying binary tree the last element returned by this iterator (optional operation). 
	 * It can be called only once per call to next() method. The behavior of an iterator is unspecified if the underlying 
	 * collection is modified while the iteration is in progress in any way other than by calling this method.
	 * @throws UnsupportedOperationException if the remove operation is not supported by this iterator
	 * @throws IllegalStateException if the next method has not yet been called, or the remove method has already been 
	 *                               called after the last call to the next method
	 */
	public void remove() throws UnsupportedOperationException{
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Sets the traversal type to be preorder.
	 */
	public void setPreorder() {
		this.queue.clear();
		this.preorder(this.tree.root);
	}
	
	/**
	 * Sets the traversal type to be inorder.
	 */
	public void setInorder() {
		this.queue.clear();
		this.inorder(this.tree.root);
	}
	
	/**
	 * Sets the traversal type to be postorder.
	 */
	public void setPostOrder() {
		this.queue.clear();
		this.postorder(this.tree.root);
	}
	
	/**
	 * Traverses in preorder. 
	 * @param node A reference to a tree node
	 */
	public void preorder(TreeNode<T> node) {
		if(node != null) {
			this.queue.add(node);
			preorder(node.getLeft());
			preorder(node.getRight());
		}
	}
	
	/**
	 * Traverses in inorder. 
	 * @param node A reference to a tree node
	 */
	public void inorder(TreeNode<T> node) {
		if(node != null) {
			inorder(node.getLeft());
			this.queue.add(node);
			inorder(node.getRight());
		}
	}
	
    /**
	 * Traverses in postorder. 
	 * @param treeNode A reference to a tree node
	 */
	public void postorder(TreeNode<T> node) {
		if(node != null) {
			postorder(node.getLeft());
			postorder(node.getRight());
			this.queue.add(node);
		}
	}
}