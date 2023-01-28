class Node {
    int data;
    Node left;
    Node right;
 
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
 
class BinaryTree {
    Node root;
 
    public BinaryTree() {
        root = null;
    }
 
    public void insert(int data) {
        root = insertRec(root, data);
    }
 
    Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
 
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
 
        return root;
    }
 
    public void inorder()  {
       inorderRec(root);
    }
 
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
 
    public void preorder() {
        preorderRec(root);
    }
 
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
 
    public void postorder()  {
        postorderRec(root);
    }
 
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }
 
    public int size() {
        return size(root);
    }
 
    int size(Node root) {
        if (root == null)
            return 0;
        else
            return (size(root.left) + 1 + size(root.right));
    }
 
    public int maxValue() {
        return maxValue(root);
    }
 
    int maxValue(Node root) {
        int max = Integer.MIN_VALUE;
        if (root != null) {
            int left = maxValue(root.left);
            int right = maxValue(root.right);
            if (left > right)
                max = left;
            else
                max = right;
            if (root.data > max)
                max = root.data;
        }
        return max;
    }
 
    public int minValue() {
        return minValue(root);
    }
 
    int minValue(Node root) {
        int min = Integer.MAX_VALUE;
        if (root != null) {
            int left = minValue(root.left);
            int right = minValue(root.right);
            if (left < right)
                min = left;
            else
                min = right;
            if (root.data < min)
                min = root.data;
        }
        return min;
    }
}
    
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
    
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
    
        System.out.println("Inorder traversal of the given tree");
        tree.inorder();
        System.out.println("\nPreorder traversal of the given tree");
        tree.preorder();
        System.out.println("\nPostorder traversal of the given tree");
        tree.postorder();
    
        System.out.println("\nSize of the tree: " + tree.size());
        System.out.println("\nMaximum value in the tree: " + tree.maxValue());
        System.out.println("\nMinimum value in the tree: " + tree.minValue());
    }
}