class DoublyLinkedList(object):

    def __init__(self, value):
        self.head = None
        self.tail = None

    # time O(1) | space O(1)
    def setHead(self, node):
        if self.head is None:
            self.head = node
            self.tail = node
            return

        self.insertBefore(self.head,node)

    # time O(1) | space O(1)
    def setTail(self, node):
        
        if self.tail is node:
            self.head = node
            self.tail = node
            return

        self.insertAfter(self.tail,node)

    # time O(1) | space O(1)
    def insertBefore(self, node, nodeToInsert):
        if nodeToInsert == self.head and nodeToInsert == self.prev:     # single node case
            return 
        self.remove(nodeToInsert)               # if node exists then moving it to new location
        
        nodeToInsert.prev = node.prev
        nodeToInsert.next = node
        if node.prev is None:
            self.head = nodeToInsert
        else:
            node.prev.next = nodeToInsert
        node.prev = nodeToInsert

    # time O(1) | space O(1)
    def insertAfter(self, node, nodeToInsert):

        if nodeToInsert == self.head and nodeToInsert == self.tail:
            return
        self.remove(nodeToInsert)     

        nodeToInsert.next = node.next
        nodeToInsert.prev = node

        if node.next is None:
            self.tail = nodeToInsert
        else:
            node.next.prev = nodeToInsert
        node.next = nodeToInsert
        
    # time O(position) | space O(p)
    def insertAtPosition(self, position, nodeToInsert):

        if position == 1:
            self.setHead(nodeToInsert)
            return

        node = self.head 
        currPosition = 1
        while node is not None and currPosition != position:
            node = node.next
            currPosition += 1
        
        if node is None:
            self.setTail(nodeToInsert)
        else:
            self.insertBefore(node,nodeToInsert)
        
    # time O(n) | space O(1)
    def removeNodesWithValue(self, value):
        node = self.head
        while node is not None:
            nodeToRemove = node
            node = node.next
            if nodeToRemove.value == value:
                self.remove(nodeToRemove)

        
    # time O(1) | space O(1)
    def remove(self, node):
        if node == self.head:
            self.head = self.head.next
        if node == self.tail:
            self.tail = self.tail.prev
        # both ifs to cover single node case

        self.removeNodeBindings(node)

    # time O(n) | space O(1)
    def containsNodeWithValue(self, value):
        node = self.head
        while node is not None and node.value != value:
            node = node.next

        return node is not None

    # time O(1) | space O(1)
    def removeNodeBindings(self, node):
        if node.prev is not None:
            node.prev.next = node.next

        if node.next is not None:
            node.next.prev = node.prev

        node.prev = None
        node.next = None

