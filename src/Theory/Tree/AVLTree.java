package Theory.Tree;

// Class for AVL Tree Implementation
public class AVLTree {

	// Static inner class representing a node in the AVL tree
	public static class Node {
		private int value; // Value of the node
		private Node left; // Reference to the left child node
		private Node right; // Reference to the right child node
		private int height; // Height of the node

		// Constructor to initialize the node with a value
		public Node(int value) {
			this.value = value;
		}

		// Getter method to retrieve the value of the node
		public int getValue() {
			return value;
		}
	}

	private Node root; // Root node of the AVL tree

	// Constructor to initialize an empty AVL tree
	public AVLTree() {}

	// Public method to get the height of the tree
	public int height() {
		return height(root); // Call the private height method with the root node
	}

	// Private helper method to get the height of a node
	private int height(Node node) {
		if (node == null) {
			return -1; // Return -1 if the node is null
		}
		return node.height; // Return the height of the node
	}

	// Public method to insert a value into the AVL tree
	public void insert(int value) {
		root = insert(value, root); // Call the private insert method starting from the root
	}

	// Private helper method to insert a value into the tree
	private Node insert(int value, Node node) {
		if (node == null) {
			node = new Node(value); // Create a new node if the current node is null
			return node;
		}

		if (value < node.value) {
			node.left = insert(value, node.left); // Insert into the left subtree if the value is smaller
		}

		if (value > node.value) {
			node.right = insert(value, node.right); // Insert into the right subtree if the value is larger
		}

		// Update the height of the current node after insertion
		node.height = Math.max(height(node.left), height(node.right)) + 1;

		// Check and perform rotations to maintain balance
		return rotate(node);
	}

	// Private method to perform rotations if the tree becomes unbalanced
	private Node rotate(Node node) {
		// Check for left-heavy condition
		if (height(node.left) - height(node.right) > 1) {
			if (height(node.left.left) - height(node.left.right) > 0) {
				// Left-Left (LL) case: Perform right rotation
				return rightRotate(node);
			}
			if (height(node.left.left) - height(node.left.right) < 0) {
				// Left-Right (LR) case: Perform left rotation on left child, then right rotation
				node.left = leftRotate(node.left);
				return rightRotate(node);
			}
		}

		// Check for right-heavy condition
		if (height(node.left) - height(node.right) < -1) {
			if (height(node.right.left) - height(node.right.right) < 0) {
				// Right-Right (RR) case: Perform left rotation
				return leftRotate(node);
			}
			if (height(node.right.left) - height(node.right.right) > 0) {
				// Right-Left (RL) case: Perform right rotation on right child, then left rotation
				node.right = rightRotate(node.right);
				return leftRotate(node);
			}
		}

		return node; // Return the node if no rotations are needed
	}

	// Perform a right rotation
	public Node rightRotate(Node p) {
		Node c = p.left; // Set the left child as the new root
		Node t = c.right; // Temporary storage for the right subtree of the left child

		c.right = p; // Set the current node as the right child of its left child
		p.left = t; // Attach the stored subtree as the left child of the current node

		// Update the heights of the nodes
		p.height = Math.max(height(p.left), height(p.right) + 1);
		c.height = Math.max(height(c.left), height(c.right) + 1);

		return c; // Return the new root
	}

	// Perform a left rotation
	public Node leftRotate(Node c) {
		Node p = c.right; // Set the right child as the new root
		Node t = p.left; // Temporary storage for the left subtree of the right child

		p.left = c; // Set the current node as the left child of its right child
		c.right = t; // Attach the stored subtree as the right child of the current node

		// Update the heights of the nodes
		p.height = Math.max(height(p.left), height(p.right) + 1);
		c.height = Math.max(height(c.left), height(c.right) + 1);

		return p; // Return the new root
	}

	// Populate the tree with an array of integers
	public void populate(int[] nums) {
		for (int num : nums) {
			this.insert(num); // Insert each element into the tree
		}
	}

	// Populate the tree with a sorted array to maintain balance
	public void populatedSorted(int[] nums) {
		populatedSorted(nums, 0, nums.length); // Call the private method with the full array
	}

	// Private helper method for balanced insertion from a sorted array
	private void populatedSorted(int[] nums, int start, int end) {
		if (start >= end) {
			return; // Base case: Stop when the range is invalid
		}

		int mid = (start + end) / 2; // Find the middle element

		this.insert(nums[mid]); // Insert the middle element
		populatedSorted(nums, start, mid); // Recursively populate the left half
		populatedSorted(nums, mid + 1, end); // Recursively populate the right half
	}

	// Display the AVL tree
	public void display() {
		display(this.root, "Root Node: "); // Start from the root node
	}

	// Private helper method to display the tree
	private void display(Node node, String details) {
		if (node == null) {
			return; // Stop if the node is null
		}
		System.out.println(details + node.value); // Print the current node
		display(node.left, "Left child of " + node.value + " : "); // Display the left subtree
		display(node.right, "Right child of " + node.value + " : "); // Display the right subtree
	}

	// Check if the tree is empty
	public boolean isEmpty() {
		return root == null; // Return true if the root is null
	}

	// Check if the tree is balanced
	public boolean balanced() {
		return balanced(root); // Call the private method starting from the root
	}

	// Private helper method to check if a subtree is balanced
	private boolean balanced(Node node) {
		if (node == null) {
			return true; // A null node is balanced
		}
		return Math.abs(height(node.left) - height(node.right)) <= 1
			&& balanced(node.left)
			&& balanced(node.right); // Check height difference and recursively check subtrees
	}
}
