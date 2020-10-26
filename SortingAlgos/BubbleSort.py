class BubbleSort():

    def __init__(self):
        self.hello=None

    def sort(self,arr):

        return self.bubbleSortImpl(arr)

    def bubbleSortImpl(self,arr):

        lastUnsortedIndex = len(arr) - 1

        while(lastUnsortedIndex > 0):
            
            for i in range(lastUnsortedIndex):
                if arr[i] > arr[i+1]:
                    self.swap(arr,i,i+1)
            lastUnsortedIndex -= 1 

        return arr


    def swap(self, arr, i, j):
        
        if i == j:
            return
        
        temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp



arr = [20, 35, -15, 7, 55, 1, -22]
bubbleSort = BubbleSort()

print(bubbleSort.sort(arr))