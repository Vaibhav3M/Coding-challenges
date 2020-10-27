class Node:

    def __init__(self,value):
        self.value = value
        self.children = []

    def addChild(self,node):
        self.children.append(node)

    
    def DFS(self):
        results = []
        return self.DFSHelper(results)

    
    def DFSHelper(self,results):

        results.append(self)

        for child in self.children:
            child.DFSHelper(results)
        
        return results



n1 = Node(1)
n2 =  Node(2)
n3 =  Node(3)
n4 =  Node(4)
n5 =  Node(5)
n6 =  Node(6)
n7 =  Node(7)
n8 =  Node(8)

n1.addChild(n2)
n1.addChild(n3)

n2.addChild(n4)

n3.addChild(n5)
n3.addChild(n6)

n6.addChild(n7)
n8.addChild(n7)


for n in n1.DFS():
    print(n.value)
