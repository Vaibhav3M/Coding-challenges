

def branchSum(tree):
    result = []
    branchSumHelper(tree.root,0,result)

    return result

def branchSumHelper(node, currsum, result):

    if node is None:
        return
    
    currsum = currsum + node.val

    if node.left is None and node.right is None:
        result.append(currsum)

    branchSumHelper(node.left,currsum,result)
    branchSumHelper(node.right,currsum,result)



class Node:

    def __init__(self,val):
        self.val = val
        self.left = None
        self.right = None


class Tree:
 
    def __init__(self):
        self.root = None
    
    def insert_node(self,val):

        newNode = Node(val)

        if self.root == None:
            self.root = newNode
            return
        
        current = self.root
        parent = None

        while(True):
            parent = current

            if(val < current.val):
                current = current.left
                if (current == None):
                    parent.left = newNode
                    return
            else:
                current = current.right
                if(current == None):
                    parent.right = newNode;
                    return


t = Tree()
t.insert_node(5)
t.insert_node(4)
t.insert_node(8)
t.insert_node(11)
t.insert_node(13)
t.insert_node(4)
t.insert_node(7)
t.insert_node(2)
t.insert_node(1)


print(branchSum(t))