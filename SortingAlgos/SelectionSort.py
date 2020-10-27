class SelectionSort(object):
    
    def sort(self, arr):
        return self.selectionSort(arr)

    def selectionSort(self, arr) -> list:

        lastUnsortedIndex = len(arr)-1

        while (lastUnsortedIndex >= 0):
            largest = 0
            for i in range(lastUnsortedIndex+1):
                if arr[i] > arr[largest]:
                    largest = i
            
            self.swap(arr,lastUnsortedIndex,largest)
            lastUnsortedIndex -= 1

        return arr
    

    def swap(self, arr, i, j):
        
        if i == j:
            return
            
        temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp



arr = [20, 35, -15, 7, 55, 1, -22]
selectionSort = SelectionSort()

print(selectionSort.sort(arr))