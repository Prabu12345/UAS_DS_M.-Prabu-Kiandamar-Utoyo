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
        
        int angka[] = {1,7,4,2,3,6,2,1,6,3,4,32,46,34,2,32,1,23,64,23,43,31,23};
        
        for (int i = 0; i < angka.length; i++) {
            tree.insert(angka[i]);
        }
        System.out.println("Traversal Inorder Output");
        tree.inorder();
        System.out.println("\nTraversal Preorder Output");
        tree.preorder();
        System.out.println("\nTraversal Postorder Output");
        tree.postorder();
    
        System.out.println("\nSize of the tree: " + tree.size());
        System.out.println("Maximum value in the tree: " + tree.maxValue());
        System.out.println("Minimum value in the tree: " + tree.minValue());
    }
}
