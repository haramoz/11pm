import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        System.out.println("Inorder DFS traversal");
        inorderDFS(root);

        System.out.println("\nPreorder DFS traversal ");
        preorderDFS(root);

        System.out.println("\nPostorder DFS traversal");
        postorderDFS(root);

        System.out.println("\nLevelorder BFS traversal");
        levelOrderBFS(root);
    }

    static void preorderDFS(TreeNode treeNode) {
        if (treeNode == null)
            return;

        // Traverse root
        System.out.print(treeNode.data + " ");
        // Traverse left
        preorderDFS(treeNode.left);
        // Traverse right
        preorderDFS(treeNode.right);
    }

    static void inorderDFS(TreeNode treeNode) {
        if (treeNode == null)
            return;

        // Traverse left
        inorderDFS(treeNode.left);
        // Traverse root
        System.out.print(treeNode.data + " ");
        // Traverse right
        inorderDFS(treeNode.right);
    }

    static void postorderDFS(TreeNode treeNode) {
        if (treeNode == null)
            return;

        // Traverse left
        postorderDFS(treeNode.left);
        // Traverse right
        postorderDFS(treeNode.right);
        // Traverse root
        System.out.print(treeNode.data + " ");
    }

    static void levelOrderBFS(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeNode);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }

    }
}