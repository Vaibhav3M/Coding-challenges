public class LinkedList {

    NodeC head;
    NodeC tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;

    }

    public void setHead(NodeC node) {

        if (this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        insertBefore(this.head, node);

    }

    public void setTail(NodeC node) {

        if (this.tail == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        insertAfter(this.tail, node);

    }

    public void insertBefore(NodeC node, NodeC nodeToInsert) {

        if (nodeToInsert == this.head && nodeToInsert == this.tail) {
            return;
        }
        this.remove(nodeToInsert);

        nodeToInsert.next = node;
        nodeToInsert.prev = node.prev;

        if (nodeToInsert.prev == null) {
            this.head = nodeToInsert;
        } else {
            node.prev.next = nodeToInsert;
        }
        node.prev = nodeToInsert;

    }

    public void insertAfter(NodeC node, NodeC nodeToInsert) {

        if (nodeToInsert == this.head && nodeToInsert == this.tail) {
            return;
        }
        this.remove(nodeToInsert);

        nodeToInsert.prev = node;
        nodeToInsert.next = node.next;

        if (node.next == null) {
            this.tail = nodeToInsert;
        } else {
            node.next.prev = nodeToInsert;
        }
        node.next = nodeToInsert;

    }

    public void insertAtPosition(int position, NodeC nodeToInsert) {

        if (position == 1) {
            this.setHead(nodeToInsert);
        }

        NodeC node = this.head;
        int currPosition = 1;

        while (node != null && position != currPosition) {
            node = node.next;
            currPosition++;
        }

        if (node != null) {
            this.insertAfter(node, nodeToInsert);
        } else {
            this.setTail(nodeToInsert);
        }

    }

    public void removeNodeCsWithValue(int value) {

        NodeC node = this.head;

        while (node != null) {
            NodeC nodeToRemove = node;
            node = node.next;
            if (nodeToRemove.value == value) {
                this.remove(nodeToRemove);
            }
        }
    }

    public void remove(NodeC node) {

        if (node == this.head) {
            this.head = this.head.next;
        }
        if (node == this.tail) {
            this.tail = this.tail.prev;
        }

        this.removeNodeBindings(node);
    }

    public boolean containsNodeWithValue(int value) {

        NodeC node = this.head;

        while (node != null) {
            if (node.value == value)
                return true;
            node = node.next;
        }

        return false;

    }

    public void removeNodeBindings(NodeC node) {

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }

        node.next = null;
        node.prev = null;
    }

}

class NodeC {
    int value;
    NodeC next;
    NodeC prev;

    public NodeC(int value) {
        this.value = value;
    }

}

class testLinkedList{


    public static void main(String[] args){

        LinkedList list = new LinkedList();

        NodeC n1 = new NodeC(1);
        NodeC n2 = new NodeC(2);
        NodeC n3 = new NodeC(3);
        NodeC n4 = new NodeC(4);
        NodeC n5 = new NodeC(5);
        NodeC n6 = new NodeC(6);

        list.setHead(n1);
        list.setTail(n6);

        n1.next = n2;
        n2.prev = n1;

        n2.next = n3;
        n3.prev = n2;

        n3.next = n4;
        n4.prev = n3;

        n4.next = n5;
        n5.prev = n4;

        n5.next = n6;
        n6.prev = n5;
        

        System.out.println(list.containsNodeWithValue(5));

    }
}