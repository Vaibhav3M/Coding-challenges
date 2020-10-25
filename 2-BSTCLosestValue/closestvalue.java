
public class closestvalue {

    private static int findClosest(Tree tree, int val) {
        //time complexity logn
        //worst case n, if only one branch
        //space logn if use recurssion
        return helper(tree.root, val, Integer.MAX_VALUE);
    }

    private static int helper(Node n, int target, int closest) {

        if (n == null) {
            return closest;
        }

        if (Math.abs(n.value - target) < Math.abs(target - closest)) {

            closest = n.value;
        }

        if (target < n.value) {
            //no need to check right subtree
            return helper(n.left, target, closest);
        } else if (target > n.value) {
            //no need to check left subtree
            return helper(n.right,target,closest);
        } else {
            //means exact match found  
            return closest;
        }
    }

    public static void main(String args[]) {
        Tree t = new Tree();
        t.insert(10);
        t.insert(5);
        t.insert(15);
        t.insert(2);
        t.insert(5);
        t.insert(13);
        t.insert(22);
        t.insert(14);
        t.insert(1);

        // System.out.println(t.traversePreOrder(t.root));

        System.out.println(findClosest(t, 13));
    }
}

class Tree {

    Node root;

    public Tree() {
        root = null;
    }

    public void insert(int data) {
        // Create a new node
        Node newNode = new Node(data);

        // Check whether tree is empty
        if (root == null) {
            root = newNode;
            return;
        } else {
            // current node point to root of the tree
            Node current = root, parent = null;

            while (true) {
                // parent keep track of the parent node of current node.
                parent = current;

                // If data is less than current's data, node will be inserted to the left of
                // tree
                if (data < current.value) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                }
                // If data is greater than current's data, node will be inserted to the right of
                // tree
                else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    public void traverseNodes(StringBuilder sb, String padding, String pointer, Node node, boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.value);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.right != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
        }
    }

    public String traversePreOrder(Node root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.value);

        String pointerRight = "└──";
        String pointerLeft = (root.right != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        traverseNodes(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }

}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int val) {
        this.value = val;
        this.left = null;
        this.right = null;
    }

    public Node(int val, Node left, Node right) {

        this.value = val;
        this.left = left;
        this.right = right;
    }
}
