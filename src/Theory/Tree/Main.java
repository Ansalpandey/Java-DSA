package Theory.Tree;

public class Main {
	public static void main(String[] args) {
		int[] nodes = {19, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		Tree tree = new Tree();
		Tree.Node root = tree.buildTree(nodes);
		System.out.println(tree.getValue(root));
		tree.inorder(root);
		System.out.println();
		tree.preorder(root);
		System.out.println();
		tree.postorder(root);
		System.out.println();
		tree.levelOrder(root);
		System.out.println(tree.height(root));
		System.out.println(tree.diameter2(root).diam);
		System.out.println(tree.diameter2(root).ht);
	}
}
