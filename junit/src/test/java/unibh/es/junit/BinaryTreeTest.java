package unibh.es.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

	private BinaryTree populatedTree;
	private BinaryTree emptyTree;

	/**
	 * Sets up a populated tree.
	 */
	@Before
	public void setUp() {
		populatedTree = new BinaryTree();
		populatedTree.setRoot(new Node(5));
		populatedTree.getRoot().setLeft(new Node(2));
		populatedTree.getRoot().setRight(new Node(7));
		populatedTree.getRoot().getLeft().setLeft(new Node(1));
		populatedTree.getRoot().getLeft().setRight(new Node(3));
		populatedTree.getRoot().getRight().setRight(new Node(9));

		emptyTree = new BinaryTree();
	}

	/**
	 * Test the method BinaryTree.add() with the values 5, 2, 7, 1, 3 and 9, in
	 * this order. Does not make sense for an empty tree, once it's not
	 * populated.
	 */
	@Test
	public void addTest() {
		BinaryTree expected = new BinaryTree();
		expected.add(5);
		expected.add(2);
		expected.add(7);
		expected.add(1);
		expected.add(3);
		expected.add(9);

		assertEquals(expected, populatedTree);
	}

	/**
	 * Test the method BinaryTree.size() from a populated tree.
	 */
	@Test
	public void populatedTreeSizeTest() {
		assertEquals(new Integer(6), populatedTree.size());
	}

	/**
	 * Test the method BinaryTree.size() from a empty tree.
	 */
	@Test
	public void emptyTreeSizeTest() {
		assertEquals(new Integer(0), emptyTree.size());
	}

	/**
	 * Test if the method Binarytree.add() sets the root of a tree. It's not a
	 * method to test BinaryTree.getRoot(), once it'd be testing getter and
	 * setter.
	 */
	@Test
	public void populatedTreeRootTest() {
		populatedTree = new BinaryTree();
		populatedTree.add(5);

		assertEquals(new Node(5), populatedTree.getRoot());

		setUp();
	}

	/**
	 * Test the method BinaryTree.getRoot() from a empty tree. Does not make
	 * sense for a populated tree, once it'd be testing getter and setter.
	 */
	@Test
	public void emptyTreeRootTest() {
		assertNull(emptyTree.getRoot());
	}

	/**
	 * Test the method BinaryTree.getHeight() from a populated tree.
	 */
	@Test
	public void populatedTreeHeightTest() {
		assertEquals(new Integer(3), populatedTree.getHeight());
	}

	/**
	 * Test the method BinaryTree.getHeight() from a empty tree.
	 */
	@Test
	public void emptyTreeHeightTest() {
		assertEquals(new Integer(0), emptyTree.getHeight());
	}

	/**
	 * Test the method BinaryTree.isEmpty() from a populated tree.
	 */
	@Test
	public void populatedTreeIsEmptyTest() {
		assertFalse(populatedTree.isEmpty());
	}

	/**
	 * Test the method BinaryTree.isEmpty() from a empty tree.
	 */
	@Test
	public void emptyTreeIsEmptyTest() {
		assertTrue(emptyTree.isEmpty());
	}

	/**
	 * Test the method BinaryTree.reomve(), removing the node with value 7.
	 * Therefore, it's child with the value 9 comes up. Does not make sense for
	 * an empty tree, once it's not populated.
	 */
	@Test
	public void removeTest() {
		populatedTree.remove(7);

		BinaryTree expected = new BinaryTree();
		Node node5 = new Node(5);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node1 = new Node(1);
		Node node9 = new Node(9);

		expected.setRoot(node5);
		expected.getRoot().setLeft(node2);
		expected.getRoot().getLeft().setLeft(node1);
		expected.getRoot().getLeft().setRight(node3);
		expected.getRoot().setRight(node9);

		assertEquals(expected, populatedTree);

		setUp();
	}

	/**
	 * Test the method BinaryTree.reomve(), trying to remove a node that does
	 * not exist into a tree. It shall launch a IllegalArgumentException.
	 * 
	 * @throws IllegalArgumentException
	 */
	@Test(expected = IllegalArgumentException.class)
	public void invalidRemovalTest() throws IllegalArgumentException {
		populatedTree.remove(10);
	}

	/**
	 * Test the method BinaryTree.getMinValue() from a populated tree.
	 * 
	 * @throws Exception
	 */
	@Test
	public void populatedTreeGetMinValueTest() throws Exception {
		assertEquals(new Integer(1), populatedTree.getMinValue());
	}

	/**
	 * Test the method BinaryTree.getMinValue() from a empty tree. It shall
	 * launch a Exception.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void emptyTreeGetMinValueTest() throws Exception {
		emptyTree.getMinValue();
	}

	/**
	 * Test the method BinaryTree.getMaxValue() from a populated tree.
	 * 
	 * @throws Exception
	 */
	@Test
	public void populatedTreeGetMaxValueTest() throws Exception {
		assertEquals(new Integer(9), populatedTree.getMaxValue());
	}

	/**
	 * Test the method BinaryTree.getMaxValue() from a empty tree. It shall
	 * launch a Exception.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void emptyTreeGetMaxValueTest() throws Exception {
		emptyTree.getMaxValue();
	}

}