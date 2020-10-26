import java.util.ArrayList;
import java.util.Stack;

public class BranchSum {

    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert(5);
        t.insert(4);
        t.insert(8);
        t.insert(11);
        t.insert(13);
        t.insert(4);
        t.insert(7);
        t.insert(2);
        t.insert(1);

        System.out.println(branchSum(t));
    }

    private static ArrayList<Integer> branchSum(Tree t) {

        // time O(n)
        // space O(n)
        ArrayList<Integer> sums = new ArrayList<>();
        branchSumHelper(t.root, 0, sums);
        //branchSumHelperIterative(t.root, 0, sums);
        return sums;
    }

    private static void branchSumHelper(Node node, int currsum, ArrayList<Integer> sums) {

        if (node == null) {
            return;
        }
        
        currsum = currsum + node.value;

        if (node.left == null && node.right == null) {
            sums.add(currsum);
            return;
        }

        branchSumHelper(node.left, currsum , sums);
        branchSumHelper(node.right, currsum , sums);

    }

    private static ArrayList<Integer> branchSumHelperIterative(Node node, int currsum, ArrayList<Integer> sums) {
       

        // TODO : complete this soution
    
        Stack<Node> stack = new Stack<>();

        stack.push(node);

        while(!stack.isEmpty()){
            
            Node currNode = stack.pop();
            currsum = currsum + currNode.value;

            if (currNode.left == null && currNode.right == null){
                sums.add(currsum);
                currsum = currsum - currNode.value;
            }

            if(currNode.left != null){
                stack.push(currNode.left);
            }

            if(currNode.right != null){
                stack.push(currNode.right);
            }
           
        }
        return sums;
    }

}