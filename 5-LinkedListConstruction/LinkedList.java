public class LinkedList {

    Node head;
    Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;

    }

    public void setHead(Node node) {

        if (this.head == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        insertBefore(this.head, node);

    }

    public void setTail(Node node) {

        if (this.tail == null) {
            this.head = node;
            this.tail = node;
            return;
        }
        insertAfter(this.tail, node);

    }

    public void insertBefore(Node node, Node nodeToInsert) {

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

    public void insertAfter(Node node, Node nodeToInsert) {

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

    public void insertAtPosition(int position, Node nodeToInsert) {

        if (position == 1) {
            this.setHead(nodeToInsert);
        }

        Node node = this.head;
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

    public void removeNodesWithValue(int value) {

        Node node = this.head;

        while (node != null) {
            Node nodeToRemove = node;
            node = node.next;
            if (nodeToRemove.value == value) {
                this.remove(nodeToRemove);
            }
        }
    }

    public void remove(Node node) {

        if (node == this.head) {
            this.head = this.head.next;
        }
        if (node == this.tail) {
            this.tail = this.tail.prev;
        }

        this.removeNodeBindings(node);
    }

    public boolean containsNodeWithValue(int value) {

        Node node = this.head;

        while (node != null) {
            if (node.value == value)
                return true;
            node = node.next;
        }

        return false;

    }

    public void removeNodeBindings(Node node) {

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

class Node {
    int value;
    Node next;
    Node prev;

    public Node(int value) {
        this.value = value;
    }

}
