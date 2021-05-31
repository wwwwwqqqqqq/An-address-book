package AnAddressBook;

/**
 * Represents a node in a binary tree. Each tree node contains a data portion - a name 
 * and two references, one for each of the node's children.
 * @author Qin Weiwei
 * @version 2.0
 */

public class TreeNode<T> {
		/**
		 * The key of this node
		 */
		private T key;
		/**
		 * The element of this node
		 */
		private T element;
		/**
		 * The reference to left child of this node
		 */
		private TreeNode<T> left;
		
		/**
		 * The TreeNode<T> to right child of this node
		 */
		private TreeNode<T> right;

		/**
		 * Constructs an empty node.
		 */
		public TreeNode() {
			this(null,null, null, null);
		}
		
		/**
		 * Constructs a node.
		 * @param element A reference to the item of this node
		 */
		public TreeNode(T key,T element) {
			this(key,element,null,null);
		}

		/**
		 * Constructs a node with an element and two descendant nodes. 
		 * @param key A reference to the key of this node
		 * @param element A reference to the data of this node
		 * @param left A reference to the left child of this node
		 * @param right A reference to the right child of this node
		 */
		public TreeNode(T key,T element,TreeNode<T> left,TreeNode<T> right) {
			this.key = key;
			this.element = element;
			this.left = left;
			this.right = right;
		}
		/**
		 * Returns the key of the node.
		 * @return A reference to the key of the node
		 */
		public T getKey() {
			return this.key;
		}
		/**
		 * Set the key of the node.
		 * @param key the key of the node
		 */
		public void setKey(T key) {
			this.key = key;
		}

		/**
		 * Returns the element of the node.
		 * @return A reference to the element of the node
		 */
		public T getElement() {
			return this.element;
		}

		/**
		 * Set the element of the node.
		 * @param element The element of the node
		 */
		public void setElement(T element) {
			this.element = element;
		}

		/**
		 * Returns the left child of the node.
		 * @return A reference to the left child of the node
		 */
		public TreeNode<T> getLeft() {
			return this.left;
		}

		/**
		 * Set the left child of the node.
		 * @param leftChild A reference to the left child of the node
		 */
		public void setLeft(TreeNode<T> left) {
			this.left = left;
		}

		/**
		 * Returns the right child of the node. 
		 * @return A reference to the tight child of the node
		 */
		public TreeNode<T> getRight() {
			return this.right;
		}

		/**
		 * Set the right child of the node. 
		 * @param rightChild A reference to the right child of the node
		 */
		public void setRight(TreeNode<T> right) {
			this.right = right;
		}
}


/*package AnAddressBook;
*//**
 * Represents a node in a binary tree. Each tree node contains a data portion - a name 
 * and two references, one for each of the node's children.
 * @author Qin Weiwei
 * @version 2.0
 *//*
public class TreeNode<T> {
	*//**
	 * The data portion of this node
	 *//*
	private T element;
	*//**
	 * The reference to left child of this node
	 *//*
	private TreeNode<T> left;
	*//**
	 * The TreeNode<T> to right child of this node
	 *//*
	private TreeNode<T> right;
	
	*//**
	 * Constructs a default node.
	 *//*
	public TreeNode() {
		this(null,null,null);
	}
	
	*//**
	 * Constructs an empty node.
	 * @param element A reference to the item of this node
	 *//*
	public TreeNode(T element){
		this(element,null,null);
	}
	
	*//**
	 * Constructs a node with an element and two descendant nodes. 
	 * @param element A reference to the data of this node
	 * @param left Reference to the left child of this node
	 * @param right Reference to the right child of this node
	 *//*
	public TreeNode(T element, TreeNode<T> left, TreeNode<T> right) {
		this.element = element;
		this.left = left;
		this.right = right;
	}

	*//**
	 * Returns the element of this node.
	 * @return A reference to the element of this node
	 *//*
	public T getElement(){
		return this.element;
	}
	
	*//**
	 * Changes the element of this node.
	 * @param element The element of this node
	 *//*
	public void setElement(T element){
		this.element = element;
	}
	
	*//**
	 * Returns the right child of this node. 
	 * @return A reference to the tight child of this node
	 *//*
	public TreeNode<T> getRight(){
		return this.right;
	}
	
	*//**
	 * Changes the right child of this node. 
	 * @param rightChild A reference to the right child of this node
	 *//*
	public void setRight(TreeNode<T> right){
		this.right = right;
	}
	
	*//**
	 * Returns the left child of this node.
	 * @return A reference to the left child of this node
	 *//*
	public TreeNode<T> getLeft(){
		return this.left;
	}
	
	*//**
	 * Changes the left child of this node.
	 * @param leftChild A reference to the left child of this node
	 *//*
    public void setLeft(TreeNode<T> left){
    	this.left = left;
	}
}
*/