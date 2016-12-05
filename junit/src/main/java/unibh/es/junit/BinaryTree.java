package unibh.es.junit;

/**
 * The BinaryTree class wraps information about the root node of a tree.
 */
public class BinaryTree {

	private Node root;

	/**
	 * Add a value to the tree.
	 * 
	 * @param value
	 *            Integer value to be inserted into the tree.
	 */
	public void add(Integer value) {
		this.add(this.root, value);
	}

	private void add(Node node, Integer value) {
		if (this.root == null) {
			this.root = new Node(value);
		} else {
			if (value < node.getValue()) {
				if (node.getLeft() != null) {
					this.add(node.getLeft(), value);
				} else {
					node.setLeft(new Node(value));
				}
			} else if (value > node.getValue()) {
				if (node.getRight() != null) {
					this.add(node.getRight(), value);
				} else {
					// Se nodo direito vazio insere o novo no aqui
					node.setRight(new Node(value));
				}
			}
		}
	}

	/**
	 * Returns the number of nodes into the tree.
	 * 
	 * @return the number of nodes into the tree.
	 */
	public Integer size() {
		return size(this.root);
	}

	private Integer size(Node node) {
		if (node == null) {
			return 0;
		}
		int leftSize = this.size(node.getLeft());
		int rightSize = this.size(node.getRight());
		return leftSize + rightSize + 1;
	}

	/**
	 * Returns the root node of the tree.
	 * 
	 * @return the root node of the tree.
	 */
	public Node getRoot() {
		return this.root;
	}

	void setRoot(Node root) {
		this.root = root;
	}

	/**
	 * Returns the height of the tree.
	 * 
	 * @return the height of the tree.
	 */
	public Integer getHeight() {
		return this.getHeight(this.root);
	}

	private Integer getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = getHeight(node.getLeft());
		int rightHeight = getHeight(node.getRight());
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}

	/**
	 * Returns true if the tree is empty.
	 * 
	 * @return true if the tree is empty.
	 */
	public Boolean isEmpty() {
		if (this.root == null) {
			return true;
		}
		return false;
	}

	/**
	 * Removes a value from the tree.
	 * 
	 * @param value
	 *            Integer value to be removed from the tree.
	 * @throws IllegalArgumentException
	 *             in case of the tree does not contains the value.
	 */
	public void remove(Integer value) throws IllegalArgumentException {
		if (!this.contains(value)) {
			throw new IllegalArgumentException("Tree does not contains this value");
		}
		remove(this.root, value);

	}

	private Boolean contains(Integer value) {
		return contains(this.root, value);
	}
	
	private Boolean contains(Node node, Integer value){
		if(node.getValue().equals(value)){
			return true;
		} else if(value < node.getValue() && node.getLeft() != null){
			return contains(node.getLeft(), value);
		} else if(value > node.getValue() && node.getRight() != null){
			return contains(node.getRight(), value);
		} else {
			return false;
		}
	}

	private Node remove(Node node, Integer value) {
		if (value < node.getValue()) {
			node.setLeft(remove(node.getLeft(), value));
		} else if (value > node.getValue()) {
			node.setRight(remove(node.getRight(), value));
		} else if (node.getLeft() != null && node.getRight() != null) {
			node.setValue(findMin(node.getRight()).getValue());
			node.setRight(removeMin(node.getRight()));
		} else {
			node = (node.getLeft() != null) ? node.getLeft() : node.getRight();
		}
		return node;

	}

	private Node findMin(Node node) {
		if (node != null) {
			while (node.getLeft() != null) {
				node = node.getLeft();
			}
		}
		return node;
	}

	private Node findMax(Node node) {
		if (node != null) {
			while (node.getRight() != null) {
				node = node.getRight();
			}
		}
		return node;
	}

	private Node removeMin(Node node) {
		if (node.getLeft() != null) {
			node.setLeft(removeMin(node.getLeft()));
			return node;
		} else {
			return node.getRight();
		}
	}

	/**
	 * Returns the minimul value from the tree.
	 * 
	 * @return the minimum value from the tree.
	 */
	public Integer getMinValue() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Tree is empty");
		}
		return this.findMin(this.root).getValue();
	}

	/**
	 * Returns the maximum value from the tree.
	 * 
	 * @return the maximum value from the tree.
	 */
	public Integer getMaxValue() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Tree is empty");
		}
		return this.findMax(this.root).getValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((root == null) ? 0 : root.hashCode());
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
		BinaryTree other = (BinaryTree) obj;
		if (root == null) {
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		return true;
	}

}