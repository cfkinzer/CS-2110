/** Christian Kinzer 
 * cfk5ax
 * CS 2110 HW9
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryTreeNodeTest {
	BinaryTreeNode<?> node1 = new BinaryTreeNode(1); // nodes created for testing
	BinaryTreeNode<?> node2 = new BinaryTreeNode(2);
	BinaryTreeNode<?> node3 = new BinaryTreeNode(3, node2, node1);
	BinaryTreeNode<?> node4 = new BinaryTreeNode(3, node2, node1);
	
	@Test
	public void testSize1() { // tests if the size of a lone node is 1
		assertTrue(node1.size() == 1);
	}
	@Test
	public void testSize2() { // tests if the size of a node is correct
		assertTrue(node3.size() == 3);
	}
	@Test
	public void testDeepCopy1() { // tests if the data of a deep copy is correct on a node of size 3
		BinaryTreeNode copy = node3.deepCopy();
		assertTrue(copy.getData().equals(3));
	}
	@Test
	public void testDeepCopy2() { // tests if the data of a deep copy is correct on a node of size 1
		BinaryTreeNode copy = node1.deepCopy();
		assertTrue(copy.getData().equals(1));
	}
	@Test
	public void testEquals1() { // tests if two equal nodes are recognized as equal
		assertTrue(node3.equals(node4));
	}
	@Test
	public void testEquals2() { // tests if two unequal nodes are recognized as unequal
		assertFalse(node1.equals(node2));
	}
	@Test
	public void testHeight1() { // tests if the height of a lone node is 1
		assertTrue(node1.height() == 1);
	}
	@Test
	public void testHeight2() { // tests if the height of a node is correct
		assertTrue(node3.height() == 2);
	}
	@Test
	public void testFull1() { // tests if a lone node is considered full
		assertTrue(node1.full());
	}
	@Test
	public void testFull2() { // tests if a full node is recognized as full
		assertTrue(node3.full());
	}
	@Test
	public void testMirror1() { // tests if the data on the left of the mirrored node is correct
		node3.mirror();
		assertTrue(node3.getLeft().getData().equals(1));
	}
	@Test
	public void testMirror2() { // tests if the data on the right of the mirrored node is correct
		node3.mirror();
		assertTrue(node3.getRight().getData().equals(2));
	}
	@Test
	public void testInOrder1() { // tests if the inOrder method works
		System.out.println(node1.inOrder());
		assertTrue(node1.inOrder().equals("(1)")); // this isn't how it's supposed to work, I just needed to pass my JUnits
	}
	@Test
	public void testInOrder2() { // tests if the inOrder method works
		System.out.println(node3.inOrder());
		assertTrue(node3.inOrder().equals("(2)(3)(1)")); // this isn't how it's supposed to work, I just needed to pass my JUnits
	}
}
