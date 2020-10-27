import java.util.ArrayList;

class NodeDFS {

    int value;
    ArrayList<NodeDFS> children;

    public NodeDFS(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(NodeDFS n) {
        this.children.add(n);
    }

    public ArrayList<NodeDFS> DFS() {
        // time O(E+V)
        // space O(V)
        ArrayList<NodeDFS> result = new ArrayList<>();

        return DFSHelper(result);
    }

    public ArrayList<NodeDFS> DFSHelper(ArrayList<NodeDFS> path) {

        path.add(this);

        for (NodeDFS child : this.children) {
            child.DFSHelper(path);
        }

        return path;
    }

}

class testDFS {

    public static void main(String args[]) {
        
        NodeDFS n1 = new NodeDFS(1);
        NodeDFS n2 = new NodeDFS(2);
        NodeDFS n3 = new NodeDFS(3);
        NodeDFS n4 = new NodeDFS(4);
        NodeDFS n5 = new NodeDFS(5);
        NodeDFS n6 = new NodeDFS(6);
        NodeDFS n7 = new NodeDFS(7);
        NodeDFS n8 = new NodeDFS(8);

        n1.addChild(n2);
        n1.addChild(n3);

        n2.addChild(n4);

        n3.addChild(n5);
        n3.addChild(n6);

        n6.addChild(n7);
        n8.addChild(n7);

        for (NodeDFS node : n1.DFS()) {
            System.out.print(node.value + " ");
        }
        System.out.println();
    }
}
