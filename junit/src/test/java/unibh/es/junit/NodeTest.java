package unibh.es.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {

	private Node node;
	private Integer value;

	/**
	 * Sets up a node with a random positive value
	 */
	@Before
	public void setUp() {
		this.value = (int) Math.abs(Math.random() * Integer.MAX_VALUE);
		this.node = new Node(value);
	}

	/**
	 * Test if a node is leaf when it has no child.
	 */
	@Test
	public void isLeafTest() {
		assertTrue(node.isLeaf());
	}

	/**
	 * Test if a node is not leaf when has a right child.
	 */
	@Test
	public void isNotLeafWhenHasRightChildTest() {
		node.setRight(new Node(this.value + 1));
		assertFalse(node.isLeaf());
		setUp();
	}

	/**
	 * Test if a node is not leaf when has a left child.
	 */
	@Test
	public void isNotLeafWhenHasLeftChildTest() {
		node.setLeft(new Node(this.value - 1));
		assertFalse(node.isLeaf());
		setUp();
	}

	/**
	 * Test if a node is not leaf when has both children.
	 */
	@Test
	public void isNotLeafWhenHasBothChildrenTest() {
		node.setLeft(new Node(this.value - 1));
		node.setRight(new Node(this.value + 1));
		assertFalse(node.isLeaf());
		setUp();
	}

}
