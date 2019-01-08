/** Christian Kinzer 
 * cfk5ax
 * CS 2110 HW9
 */

public class BinaryTreeNode<T> {

	private BinaryTreeNode<T> left; // field that is the node on the left
	private BinaryTreeNode<T> right; // field that is the node on the right
	private T data; // field that is the data stored on the node
	// private String s; // used for inOrder

	public BinaryTreeNode(){ // constructs a null node
		this(null,null,null);
	}

	public BinaryTreeNode(T theData){ // constructs a node with data but null children
		this(theData,null,null);
	}

	public BinaryTreeNode(T theData, BinaryTreeNode<T> leftChild, BinaryTreeNode<T> rightChild){ // constructs a node with data and children
		data = theData;
		left = leftChild;
		right = rightChild;
	}

	public int size(){ // written by 2110 instructors
		int size = 0; //the size of the tree

		//The size of the tree rooted at this node is one more than the
		//sum of the sizes of its children.
		if(left != null){
			size = size + left.size();
		}
		if(right != null){
			size = size + right.size();
		}
		return size + 1; //add one to account for the current node
	}
 
	public BinaryTreeNode<T> getLeft() { // getter for the left node
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) { // setter for the left node
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() { // getter for the right node
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) { // setter for the right node
		this.right = right;
	}

	public T getData() { // getter for the data
		return data;
	}

	public void setData(T data) { // setter for the data
		this.data = data;
	}


	public BinaryTreeNode<T> deepCopy(){ // returns a deep copy of a node
		T dataHolder = this.getData(); // holder for the data
		BinaryTreeNode<T> leftHolder = this.getLeft(); // holder for the left
		BinaryTreeNode<T> rightHolder = this.getRight(); // holder for the right
		return new BinaryTreeNode<T>(dataHolder, leftHolder, rightHolder); // construct from the holders
	}

	@Override
	public boolean equals(Object o){ // returns true if two nodes are equal
		if (o instanceof BinaryTreeNode<?>) { // if the param object is a node...
			BinaryTreeNode<?> copy = (BinaryTreeNode<?>) o; // cast it as a node
			boolean rootEqual = false; // flag for whether the data are equal
			boolean lEqual = false; // flag for whether the lefts are equal
			boolean rEqual = false; // flag for whether the rights are equal
			rootEqual = this.getData().equals(copy.getData()); // compare the data and adjust the flag
			if (this.getLeft() != null && copy.getLeft() != null) { // if both lefts are not null
				lEqual = this.getLeft().equals(copy.getLeft()); // recursive call and adjust the flag
			}
			else if (this.getLeft() == null && copy.getLeft() == null) { // if both lefts are null
				lEqual = true; // flag is true
			}
			if (this.getRight() != null && copy.getRight() != null) { // if both rights are not null
				rEqual = this.getRight().equals(copy.getRight()); // recursive call and adjust the flag
			}
			else if (this.getRight() == null && copy.getRight() == null) { // if both rights are null
				rEqual = true; // flag is true
			}
			return (rootEqual && rEqual && lEqual); // return true only if all flags are true
		}
		return false; // if o is not a node, return false
	}

	public int height() { // returns the height of a node's subtree
		int h = 1; // initial height = 1
		int lh = 0; // height of the left is 0
		int rh = 0; // height of the right is 0
		if (this.getLeft() == null && this.getRight() == null) { // if both left and right are null
			return h; // return h
		}
		if (this.getLeft() != null) { // if left is not null
			lh = this.getLeft().height(); // set lh to the recursive call
		}
		if (this.getRight() != null) { // if right is not null
			rh = this.getRight().height(); // set rh to the recursive call
		}
		return h + Math.max(lh, rh); // return h + the larger value between rh and lh
	}

	public boolean full() { // returns whether a node's subtree is full
		if (this.getLeft() == null && this.getRight() == null) { // if left and right are null
			return true; // full
		}
		if (this.getLeft() != null && this.getRight() == null) { // if left is not and right is null
			return false; // not full
		}
		if (this.getLeft() == null && this.getRight() != null) { // if left is null and right is not
			return false; // not full
		}
		if (this.getLeft() != null && this.getRight() != null) { // if both are null
			return this.getLeft().full() && this.getRight().full(); // recursive call on both the left and right
		}
		else { // catch all else
			return false; // not full
		}
	}

	public void mirror() { // changes a node's subtree to its mirror image
		if (this.getLeft() == null && this.getRight() == null) { // if left and right are null
			return; // break
		}
		if (this.getLeft() != null) { // if left is not null
			this.getLeft().mirror(); // recursive call on the left
		}
		if (this.getRight() != null) { // if the right is not null
			this.getRight().mirror(); // recursive call on the right
		}
		BinaryTreeNode<T> nR = this.getLeft(); // holder for the new right subtree
		this.left = this.getRight(); // set the left to the right
		this.right = nR; // set the right to the holder
	}

	public String inOrder() { // should return a string of the inOrder traversal, however, I couldn't get this to work
		String s = "";
		if (this.getLeft() != null) { // if left is not null
			s += this.getLeft().inOrder(); // add the recursive call on the left to the string
		}
		s += "(" + this.getData() + ")"; // add data to the field string 
		if (this.getRight() != null) { // if right is not null
			s += this.getRight().inOrder(); // add the recursive call on the left to the string
		}
		return s; // return the string
	}
	
}
