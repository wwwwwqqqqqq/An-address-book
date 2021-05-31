package AnAddressBook;

/**
 * Represents a binary tree.
 * @author Qin Weiwei
 * @version 2.0
 */

import java.io.*;

import AnAddressBook.AddressBook;
import AnAddressBook.TreeNode;

public class BinarySearchTree<T> extends BinaryTreeBasis<T> {
	private TreeNode<T> root;
	private BinaryTreeBasis<T> tree = new BinaryTreeBasis<T>();

	/**
	 * Creates an empty binary tree.
	 */
	public BinarySearchTree() {
		super();
	}

	/**
	 * Creates a binary tree with root.
	 * @param rootNode A reference to a node
	 */
	public BinarySearchTree(BinaryTreeBasis<T> tree) {
		this.root = tree.root;
	}

	/**
	 * Search the person.
	 * @param key The tree node
	 * @return A boolean value if has the person,the value is ture
	 */
	public boolean search(T key) throws TreeException {
		TreeNode<T> perNode = root;
		TreeNode<T> newNode = null;
		
		if (perNode == null) {
			throw new TreeException("TreeException:Empty tree.");
		}
		
		while (perNode != null) {
			if (((String) key).compareTo((String) perNode.getKey()) == 0) {
				newNode = perNode;
				break;
			} else if (((String) key).compareTo((String) perNode.getKey()) < 0) {
				perNode = perNode.getLeft();
			} else if (((String) key).compareTo((String) perNode.getKey()) > 0) {
				perNode = perNode.getRight();
			}
		}
		
		if (newNode == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Insert a node to the tree.
	 * @param key A node
	 * @param element A value
	 * @return A boolean value if insert the node,the value is ture
	 */
	public boolean insert(T key,T element) {
		TreeNode<T> node1 = root;
		TreeNode<T> node = root;
		boolean isLeftChild = true;
		
		if (root == null) {
			root = new TreeNode<T>(key,element);
			return true;
		}
		
		while (node1 != null) {
			node = node1;
			if (((String)key).compareTo((String)node1.getKey()) < 0) {
				node1 = node1.getLeft();
				isLeftChild = true;
			} else if (((String)key).compareTo((String)node1.getKey()) > 0) {
				node1 = node1.getRight();
				isLeftChild = false;
			} else if (((String)key).compareTo((String)node1.getKey()) == 0) {
				return false;
			}
		}
		
		TreeNode<T> newNode = new TreeNode<T>(key,element);
		if (isLeftChild) {
			node.setLeft(newNode);
		} else {
			node.setRight(newNode);
		}
		return true;
	}

	/**
	 * Delete the node from the tree.
	 * @param key The node
	 * @return A boolean value if has delete the node,the value is ture
	 * @throws TreeException
	 */
	public boolean delete(T key) throws TreeException {
		TreeNode currentNode = root;
		TreeNode<T> parentNode = root;
		TreeNode<T> finalNode = null;
		boolean isLeftChild = true;
		
		if (currentNode == null) {
			throw new TreeException("TreeException:Empty tree.");
		}
		
		while (currentNode != null) {
			if (((String)key).compareTo((String)currentNode.getKey()) == 0) {
				finalNode = currentNode;
				break;
			}
			
			parentNode = currentNode;
			if (((String)key).compareTo((String)currentNode.getKey()) < 0) {
				currentNode = currentNode.getLeft();
				isLeftChild = true;
			} else if (((String)key).compareTo((String)currentNode.getKey()) > 0) {
				currentNode = currentNode.getRight();
				isLeftChild = false;
			}
		}
		
		if (finalNode == null) {
			return false;
		}
		
		if (currentNode.getLeft() == null && currentNode.getRight() == null) {
			if (currentNode == root) {
				root = null;
			} else if (isLeftChild) {
				parentNode.setLeft(null);
			} else {
				parentNode.setRight(null);
			}
		} else if (currentNode.getRight() == null) {
			if (currentNode == root) {
				root = currentNode.getLeft();
			} else if (isLeftChild) {
				parentNode.setLeft(currentNode.getLeft());
			} else {
				parentNode.setRight(currentNode.getLeft());
			}
		} else if (currentNode.getLeft() == null) {
			if (currentNode == root) {
				root = currentNode.getRight();
			} else if (isLeftChild) {
				parentNode.setLeft(currentNode.getRight());
			} else {
				parentNode.setRight(currentNode.getRight());
			}
		} else {
			TreeNode<T> directPostNode = getDeleteNode(currentNode);
			currentNode.setKey(directPostNode.getKey());
			currentNode.setElement(directPostNode.getElement());
		}
		return true;
	}

	/**
	 * Get the node which will be deleted.
	 * @param node The delete node
	 * @return the node
	 */
	private TreeNode<T> getDeleteNode(TreeNode<T> node) {

		TreeNode<T> parentNode = node;
		TreeNode<T> postNode = node;
		TreeNode<T> tempNode = node.getRight();
		while (tempNode != null) {
			parentNode = postNode;
			postNode = tempNode;
			tempNode = tempNode.getLeft();
		}
		if (postNode != node.getRight()) {
			parentNode.setLeft(postNode.getRight());
			postNode.setRight(null);
		}
		return postNode;

	}

	/**
	 * Iterator the tree.
	 * @return the iterator
	 */
	public TreeIterator<T> iterator() {
		return new TreeIterator<T>(this);
	}

	/**
	 * Output the tree in inorder.
	 * @param node
	 */
	public void inorder(TreeNode<T> node) {
		if (node != null) {
			inorder(node.getLeft());
			System.out.println(node.getKey() + " " + node.getElement());
			inorder(node.getRight());
		}
	}

	/**
	 * Print the node.
	 * @param tree
	 */
	public void print(BinarySearchTree<T> tree) {
		tree.inorder(tree.root);
	}
}


/*package AnAddressBook;
*//**
 * Represents a binary tree.
 * @author Qin Weiwei
 * @version 2.0
 *//*
import java.io.*;

import AnAddressBook.AddressBook;
import AnAddressBook.TreeNode;

public class BinarySearchTree<T> extends BinaryTreeBasis<T>{
	private TreeNode<T> root;
	private BinaryTreeBasis<T> tree = new BinaryTreeBasis<T>();
	
	*//**
	 * Creates an empty binary tree.
	 *//*
	public BinarySearchTree() {
		super();
	}
	
	*//**
	 * Creates a binary tree with root.
	 * @param rootNode A reference to a node
	 *//*
	public BinarySearchTree(TreeNode<T> rootNode) {
		   this.root = rootNode; 
	}  

	 *//**
     * Replaces the data item in the root of a binary tree with new item, if the tree is not empty. If the
     * tree is empty, creates a root node whose data item is newItem and inserts the new node into the tree.
     * @param newItem A reference to a new root item
     *//*
	public void setRoot(T key,T newItem) {
		 if (this.root != null) {
		    this.root.setElement(newItem);
		 }else {
		    this.root = new TreeNode<T>(key,newItem, null, null);
		 }
		}
	
	*//**
	 * Search the person.
	 * @param person The tree node
	 * @return A boolean value if has the person,the value is ture
	 *//*
	public boolean search(T person) throws TreeException{
		TreeNode<T> node1 = root;
		TreeNode<T> node2 = null;
		
		if(node1 == null) {
			throw new TreeException("The tree is empty.");
		}
		
		while(node1 != null) {
			if (((String) person).compareTo((String) node1.getKey()) == 0) {
				node2 = node1;
				break;
			} else if (((String) person).compareTo((String) node1.getKey()) < 0) {
				node1 = node1.getLeft();
			} else if (((String) person).compareTo((String) node1.getKey()) > 0) {
				node1 = node1.getRight();
			}
		}
		
		if(node1 == null) {
			return false;
		}
		return true;
}
		System.out.print("Input the name: ");
		if(((BinaryTreeBasis<T>) a).isEmpty()) {
			return false;
		}
		return true;
}
}
	*//**
	 * Insert a node to the tree.
	 * @param newItem A node
	 * @return A boolean value if insert the node,the value is ture
	 *//*
	public boolean insert(T key,T newItem) {
		if(newItem != null) {
			if(!isEmpty() && this.root.getLeft() == null){
				  this.root.setLeft(new TreeNode<T>(key,newItem, null, null));
			  }else if(isEmpty()){
				  throw new TreeException("The tree is empty, and can not be attached.");
			  }else if(this.root.getLeft() != null){
				  throw new TreeException("A left child is existed.");
			  }
			if(!isEmpty() && this.root.getRight() == null){
				  this.root.setRight(new TreeNode<T>(key,newItem, null, null));
			  }else if(isEmpty()){
				  throw new TreeException("The tree is empty, and can not be attached.");
			  }else if(this.root.getRight() != null){
				  throw new TreeException("A right child is existed.");
			  } 
		}
		return true;
	}
	
	*//**
	 * Delete the node from the tree.
	 * @param key The node
	 * @return A boolean value if has delete the node,the value is ture
	 * @throws TreeException
	 *//*
	public boolean delete(T key) throws TreeException{
		TreeNode currentNode = root;
		TreeNode parentNode = root;
		boolean isLeftchild = true;
		while(currentNode != null && currentNode.getLeft() != key) {
			parentNode = currentNode;
			if(!key.equals(currentNode.getLeft())) {
				currentNode = currentNode.getLeft();
				isLeftchild = true;
			}else {
				currentNode = currentNode.getRight();
				isLeftchild = false;
			}
		}
		if(currentNode == null) {
			return false;
		}
		if(currentNode.getLeft() == null && currentNode.getRight() == null) {
			if(currentNode == root) {
				root = null;
			}else if(isLeftchild){
				parentNode.getLeft();
			}else {
				parentNode.getRight();
			}
		}
		else if (currentNode.getRight() == null) {
			if (currentNode == root)
              root = currentNode.getLeft();
	         else if (isLeftchild)
	              parentNode.setLeft(currentNode.getLeft());
	         else
	              parentNode.setLeft(currentNode.getLeft());
	      } else if (currentNode.getLeft() == null) {
	         if (currentNode == root)
	             root = currentNode.getRight();
	         else if (isLeftchild)
	             parentNode.setLeft(currentNode.getRight());
	         else
	             parentNode.setRight(currentNode.getRight());
	      }
		return false;
	}

	*//**
	 * Iterator the tree.
	 * @return the iterator
	 *//*
	public TreeIterator<T> iterator(){
		TreeIterator<T> tree = ;
		if(root == null) {
			System.out.println("Empty root.");
			return tree;
		}
		return new TreeIterator<T>(this);
	}
	
	public void print(BinarySearchTree<T> tree) {
		tree.Inorder(tree.root);
	}
	
	public void Inorder(TreeNode<T> node) {
		if (node != null) {
			Inorder(node.getLeft());
			System.out.println("the key is: " + node.getKey() + " " + "the value is: " + node.getKey());
			Inorder(node.getRight());
		}
	}
}

public class BinarySearchTree<T> extends BinaryTreeBasis<T>{
	private TreeNode<T> root;
	public BinarySearchTree() {
	    super();
	}

	public BinarySearchTree(T p) {
	    super();
	    root = new TreeNode<T>(p);
	}

	public void insert(TreeNode<T> p){
	    insert(p, root);
	}

	public BinaryTreeBasis<T> get(String key) {
		TreeNode<T> node = root;
	    while (node != null) {
	        if (key.compareTo(node.getSearch()) == 0) {
	            return node.getElement();
	        }
	        if (key.compareTo(node.getSearch()) < 0) {
	            node = node.getLeft();
	        } else {
	            node = node.getRight();
	        }
	    }
	    return null;
	}

	protected TreeNode<T> insert(T p,TreeNode<T> node) {
	    if (node == null) {
	        return new TreeNode<T>(p);
	    }
	    if (p.getTheKey().compareTo(node.getKey()) == 0) {
	        return new TreeNode<T>(p,null,node.getLeft(), node.getRight());
	    } else {
	        if (p.getTheKey().compareTo(node.getKey()) < 0) {    // add to left subtree
	            insert(p, node.getLeft());
	        } else {                                                // add to right subtree
	            insert(p, node.getRight());
	        }
	    }
	    return node;
	}

	public void delete(String key) {
	    delete(key, root);
	}

	protected TreeNode<T> delete(String k,TreeNode<T> node) {
	    if (node == null) { // key not in tree
	        return null;
	    }
	    if (k.compareTo(node.getKey().toString()) == 0) { // remove this node
	        if (node.getLeft() == null) { // replace this node with right child
	            return node.getRight();
	        } else if (node.getRight() == null) { // replace with left child
	            return node.getLeft();
	        } else {
	            // replace the value in this node with the value in the
	            // rightmost node of the left subtree
	            node = getRightmost(node.getLeft());
	            // now remove the rightmost node in the left subtree,
	            // by calling "remove" recursively
	            remove(node.getKey(), node.getLeft());
	            // return node;  -- done below
	        }
	    } else {        // remove from left or right subtree
	        if (k.compareTo(node.getKey()) < 0) {
	            // remove from left subtree
	            delete(k, node.getLeft());
	        } else {        // remove from right subtree
	            delete(k, node.getRight());
	        }
	    }
	    return node;
	}

	protected TreeNode<T> getRightmost(TreeNode<T> node) {
	    assert(node != null);
	    TreeNode<T> right = node.getRight();
	    if (right == null) {
	        return node;
	    } else {
	        return getRightmost(right);
	    }
	}

	protected String toString(TreeNode<T> node) {
	    if (node == null) {
	        return "";
	    }
	    return node.getData().toString() + "(" + toString(node.getLeft()) + ", " +
	        toString(node.getRight()) + ")";
	}

}



package AnAddressBook;
*//**
 * Represents a binary tree.
 * @author Qin Weiwei
 * @version 2.0
 *//*
import java.io.*;

import AnAddressBook.AddressBook;
import AnAddressBook.TreeNode;
import AnAddressBook.TreeIterator;

public class BinarySearchTree<T> extends BinaryTreeBasis<T>{
	private TreeNode<T> root;
	
	*//**
	 * Creates an empty binary tree.
	 *//*
	public BinarySearchTree() {
		super();
	}
	
	*//**
	 * Creates a binary tree with root.
	 * @param rootNode A reference to a node
	 *//*
	public BinarySearchTree(T rootNode) {
		   super(rootNode); 
	}  

	 *//**
     * Replaces the data item in the root of a binary tree with new item, if the tree is not empty. If the
     * tree is empty, creates a root node whose data item is newItem and inserts the new node into the tree.
     * @param newItem A reference to a new root item
     *//*
	public void setRoot(T newItem) throws UnsupportedOperationException{
		 if (this.root == null) {
		    this.root.setElement(newItem);
		 }else {
		    this.root = new TreeNode<T>(newItem, null, null);
		 }
		}
	
	*//**
	 * Search the person.
	 * @param person The tree node
	 * @return A boolean value if has the person,the value is ture
	 *//*
	public boolean search(String person){
		if(node == null) {
			return false;
		}else if(node.getElement() == null) {
			return false;
		}else
			return true;
	}
		TreeNode<T> node1 = root;
		TreeNode<T> node2 = null;
		
		if(node1 == null) {
			throw new TreeException("The tree is empty.");
		}
		
		while(node1 != null) {
			if (((String) person).compareTo((String) node1.getElement()) == 0) {
				node2 = node1;
				break;
			} else if (((String) person).compareTo((String) node1.getElement()) < 0) {
				node1 = node1.getLeft();
			} else if (((String) person).compareTo((String) node1.getElement()) > 0) {
				node1 = node1.getRight();
			}
		}
		if(node1 == null) {
			return false;
		}
		return true;
		
		if(node1 == null) {
			return false;
		}
		return true;
}
		System.out.print("Input the name: ");
		if(((BinaryTreeBasis<T>) a).isEmpty()) {
			return false;
		}
		return true;
		
}

	*//**
	 * Insert a node to the tree.
	 * @param newItem A node
	 * @return A boolean value if insert the node,the value is ture
	 *//*
	public boolean insert(T key,T newItem) {
		if(node == null)
		{
			node = new TreeNode<T>(newItem,null,null);
			return true;
		}
		else if(node.getitem() == null)
		{
			node.setitem(newItem);
			return true;
		}
		else if(newItem.getKey().compareTo(node.getitem().getKey()) == 0)
		{
			System.out.println("");
			System.out.println("This person is exist.");
			System.out.println("Save false!");
			return true;
		}
		else if(newItem.getKey().compareTo(node.getElement().getKey()) < 0)
		{
			TreeNode<T> subtree = insert(node.getLeft(),newItem);
			node.setLeft(subtree);
			return true;
		}
		else
		{
			TreeNode<T> subtree = insert(node.getRight(),newItem);
			node.setRight(subtree);
			return true;
		}
	}
		if(key != null) {
			if(!isEmpty() && key.getLeft() == null){
				  key.setLeft(new TreeNode<T>(newItem));
			  }else if(isEmpty()){
				  throw new TreeException("The tree is empty, and can not be attached.");
			  }else if(key.getLeft() != null){
				  throw new TreeException("A left child is existed.");
			  }
			if(!isEmpty() && key.getRight() == null){
				  key.setRight(new TreeNode<T>(newItem));
			  }else if(isEmpty()){
				  throw new TreeException("The tree is empty, and can not be attached.");
			  }else if(key.getRight() != null){
				  throw new TreeException("A right child is existed.");
			  } 
		}
		return true;
		if (root == null) {
			root = new TreeNode<T>(key);
			return true;
		}
		TreeNode<T> tempNode = root;
		TreeNode<T> parentNode = root;
		boolean isLeftChild = true;
		while (tempNode != null) {
			parentNode = tempNode;
			if (((String) key).compareTo((String) tempNode.getElement()) < 0) {
				tempNode = tempNode.getLeft();
				isLeftChild = true;
			} else if (((String) key).compareTo((String) tempNode.getElement()) > 0) {
				tempNode = tempNode.getRight();
				isLeftChild = false;
			} else if (((String) key).compareTo((String) tempNode.getElement()) == 0) {
				return false;
			}
		}
		TreeNode<T> newNode = new TreeNode<T>(key);
		if (isLeftChild) {
			parentNode.setLeft(newNode);
		} else {
			parentNode.setRight(newNode);
		}
		return true;
	}
	
	*//**
	 * Delete the node from the tree.
	 * @param key The node
	 * @return A boolean value if has delete the node,the value is ture
	 * @throws TreeException
	 *//*
	public boolean delete(T key) throws TreeException{
		TreeNode<T> currentNode = root;
		TreeNode<T> parentNode = root;
		boolean isLeftchild = true;
		
		while(currentNode != null && currentNode.getLeft() != key) {
			parentNode = currentNode;
			if(!key.equals(currentNode.getLeft())) {
				currentNode = currentNode.getLeft();
				isLeftchild = true;
			}else {
				currentNode = currentNode.getRight();
				isLeftchild = false;
			}
		}
		if(currentNode == null) {
			return false;
		}
		if(currentNode.getLeft() == null && currentNode.getRight() == null) {
			if(currentNode == root) {
				root = null;
			}else if(isLeftchild){
				parentNode.getLeft();
			}else {
				parentNode.getRight();
			}
		}
		else if (currentNode.getRight() == null) {
			if (currentNode == root)
              root = currentNode.getLeft();
	         else if (isLeftchild)
	              parentNode.setLeft(currentNode.getLeft());
	         else
	              parentNode.setLeft(currentNode.getLeft());
	      } else if (currentNode.getLeft() == null) {
	         if (currentNode == root)
	             root = currentNode.getRight();
	         else if (isLeftchild)
	             parentNode.setLeft(currentNode.getRight());
	         else
	             parentNode.setRight(currentNode.getRight());
	      }
		return true;
	}

	*//**
	 * Iterator the tree.
	 * @return the iterator
	 *//*
	public TreeIterator<T> iterator(){
		BinaryTreeBasis<T> tree;
		TreeIterator<T> iterator = new TreeIterator<T>(tree);
		iterator.setInorder();
		BinaryTreeBasis<T> list = new BinaryTreeBasis<T>();
		while(iterator.hasNext())
		{
			iterator.add(iterator.next());
		}
		return iterator;
		if(root == null) {
			System.out.println("Empty root.");
		}
		return new TreeIterator<T>(this);
	}
}*/