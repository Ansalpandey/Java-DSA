package Theory.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

	public Tree() {}

	static int idx = -1;

	public static class Node {
		private final int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	public int getValue(Node node) {
		return node.value;
	}

	public Node buildTree(int[] nodes) {
		idx++;
		if (nodes[idx] == -1) {
			return null;
		}
		Node newNode = new Node(nodes[idx]);
		newNode.left = buildTree(nodes);
		newNode.right = buildTree(nodes);
		return newNode;
	}

	public void preorder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.value + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public void inorder(Node root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.value + " ");
		inorder(root.right);
	}

	public void postorder(Node root) {
		if (root == null) {
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.value + " ");
	}

	public void levelOrder(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			Node curr = q.remove();
			if (curr == null) {
				System.out.println();
				//queue empty
				if (q.isEmpty()) {
					break;
				} else {
					q.add(null);
				}
			} else {
				System.out.print(curr.value + " ");
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
			}
		}
	}

	public int height(Node root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public int countOfNodes(Node root) {
		if (root == null) {
			return 0;
		}
		int leftNodes = countOfNodes(root.left);
		int rightNodes = countOfNodes(root.right);
		return leftNodes + rightNodes + 1;
	}

	public int sumOfNodes(Node root) {
		if (root == null) {
			return 0;
		}
		int leftSum = sumOfNodes(root.left);
		int rightSum = sumOfNodes(root.right);
		return leftSum + rightSum + root.value;
	}

	//O(n^2)
	public int diameter(Node root) {
		if (root == null) {
			return 0;
		}
		int diam1 = height(root.left) + height(root.right) + 1;
		int diam2 = diameter(root.left);
		int diam3 = diameter(root.right);
		return Math.max(diam1, Math.max(diam2, diam3));
	}

	public static class TreeInfo {
		int ht;
		int diam;

		TreeInfo(int ht, int diam) {
			this.ht = ht;
			this.diam = diam;
		}
	}

	public TreeInfo diameter2(Node root) {
		if (root == null) {
			return new TreeInfo(0, 0);
		}
		TreeInfo leftTI = diameter2(root.left);
		TreeInfo rightTI = diameter2(root.right);
		int myHeight = Math.max(leftTI.ht, rightTI.ht) + 1;
		int diam1 = leftTI.ht + rightTI.ht + 1;
		int diam2 = leftTI.diam;
		int diam3 = rightTI.diam;
		int myDiam = Math.max(diam1, Math.max(diam2, diam3));
		return new TreeInfo(myHeight, myDiam);
	}
}
