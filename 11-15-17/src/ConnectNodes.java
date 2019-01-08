
public class ConnectNodes {
	int node1 = 1;
	int node2 = 2;
	int node3 = 3;
	int node4 = 4;
	int node5 = 5;
	int node6 = 6;
	int node7 = 7;
	int node8 = 8;
	
	BinaryTreeNode first = new BinaryTreeNode(node1);
	BinaryTreeNode three = new BinaryTreeNode(first);
	BinaryTreeNode two = new BinaryTreeNode(first);
	BinaryTreeNode four = new BinaryTreeNode(two);
	BinaryTreeNode five = new BinaryTreeNode(two);
	BinaryTreeNode six = new BinaryTreeNode(four);
	BinaryTreeNode seven = new BinaryTreeNode(five);
	BinaryTreeNode eight = new BinaryTreeNode(five);
	
	public static void main(String[] args) {
		System.out.println(eight.postOrder());
	}
}
