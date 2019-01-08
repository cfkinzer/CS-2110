/** Christian Kinzer 
 * cfk5ax
 * CS 2110 HW9
 */

public class BinaryTree<T> {

	private BinaryTreeNode<T> root; // each BinaryTree has one field, a BinaryTreeNode that serves as the root

	public BinaryTree() { // constructs a null BinaryTree (null root)
		this(null);
	}

	public BinaryTree(BinaryTreeNode<T> newRoot) { // constructs a BinaryTree from a root
		this.root = newRoot;
	}
	
	public BinaryTreeNode<T> getRoot() { // getter for the root
		return root;
	}

	public void setRoot(BinaryTreeNode<T> root) { // setter for the root
		this.root = root;
	}

	@Override
	public boolean equals(Object o) { // returns true if the calling and passing BinaryTree are the same
		boolean flag = false; // uses a flag to keep track of whether they are the same or not
		if (o instanceof BinaryTree) { // if the param is a BinaryTree...
			BinaryTree<T> copy = (BinaryTree<T>) o; // make a copy and cast it as a BinaryTree
			if (this.getRoot() == null && copy.getRoot() == null) { // if both roots are null...
				flag = true; // set the flag to true
			}
			if (this.getRoot() == null && copy.getRoot() != null) { // if one is null and the either isn't
				flag = false; // set the flag to false
			}
			if (this.getRoot() != null && copy.getRoot() == null) { // if one is null and the other isn't
				flag = false; // set the flag to false
			}
			if (this.getRoot() != null && copy.getRoot() != null) { // if both roots are not null...
				flag = this.getRoot().equals(copy.getRoot()); // recursive call on the root
			}
		}
		return flag; // return the flag value
	}

	public BinaryTree<T> deepCopy() { // creates a deep copy of the calling BinaryTree
		BinaryTreeNode<T> rootHolder = this.getRoot(); // make a node that holds the value of the root
		return new BinaryTree<T>(rootHolder); // construct a new BinaryTree from the copied node
	}

	public BinaryTree<T> combine(BinaryTreeNode<T> newRoot, BinaryTree<T> t, boolean left) { // combines two BinaryTrees
		BinaryTree<T> tree = new BinaryTree<T>(); // create a null tree
		tree.setRoot(newRoot.deepCopy()); // set the root to the param node
		if (left) { // if the param left is true...
			tree.root.setLeft(this.getRoot().deepCopy()); // set the left of the root of the copied tree to the root of the calling tree
			tree.root.setRight(t.getRoot().deepCopy()); // set the right of the root of the copied tree to to the root of the param tree
		}
		else if (!left) { // if the param left is false...
			tree.root.setLeft(t.getRoot().deepCopy()); // set the left of the root of the copied tree to the root of the param tree
			tree.root.setRight(this.getRoot().deepCopy()); // set the right of the root of the copied tree to the root of the calling tree
		}
		return tree; // return the tree
	}
	
	public int size(){ // returns the number of nodes in a tree
		if (this.getRoot() == null) { // if the root is null...
			return 0; // return 0
		}
		else { // otherwise...
			return this.getRoot().size(); // call the node method size() on the root
		}
	}
	
	public int height(){ // returns the number of nodes in the longest path from the root to a leaf
		if (this.getRoot() == null) { // if the root is null...
			return 0; // return 0
		}
		else { // otherwise...
			return this.getRoot().height(); // call the node method height() on the root
		}
	}
	
	public boolean full(){ // returns whether or not the tree is full
		return this.getRoot().full(); // call the node method full on the root
	}
	
	public void mirror(){ // changes a tree to its mirror image
		if (this.getRoot() != null) { // if the root is not null...
			this.getRoot().mirror(); // call the node method mirror() on the root
		}
	}
	
	public String inOrder(){ // supposed to return a string of the inOrder traversal of the tree, however I could not get this to work
		String s = ""; // create an empty string
		if (this.getRoot() != null) { // if the root is not null
			s += this.getRoot().inOrder(); // call the node method inOrder on the root and add it to the string
			return s; // return the string
		}
		else { // otherwise...
			return null; // return null
		}
	}
}
