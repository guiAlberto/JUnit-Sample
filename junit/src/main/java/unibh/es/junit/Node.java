package unibh.es.junit;

/**
 * The Node class wraps the Integer value of a node, as well as its right and
 * left children nodes.
 *
 */
public class Node {

	private Integer value;
	private Node left;
	private Node right;

	public Node(Integer value) {
		this.value = value;
	}

	/**
	 * Returns true if the node does not contains child.
	 * 
	 * @return true if the node does not contains child.
	 */
	public Boolean isLeaf() {
		return left == null && right == null;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return value.toString();
	}
}