

import sys

def closest_value(t, target):
    print(closest_helper(t.root,target,sys.maxsize))


def closest_helper(node,target,closest):

    if node == None:
        return closest
    
    if abs(node.val - target) < abs(target - closest):
        closest = node.val
    

    if (target < node.val):
        return closest_helper(node.left, target, closest)
    elif (target > node.val):
        return closest_helper(node.right, target, closest)
    else:
        return closest
    

def closest_helper_recursive(node,target,closest):
    
    while node != None:

        if abs(node.val - target) < abs(target - closest):
            closest = node.val

        if (target < node.val):
            node = node.left
        elif (target > node.val):
            node = node.right
        else:
            break
            
    return closest



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
t.insert_node(10)
t.insert_node(5)
t.insert_node(15)
t.insert_node(2)
t.insert_node(5)
t.insert_node(13)
t.insert_node(22)
t.insert_node(14)
t.insert_node(1)

closest_value(t,12)