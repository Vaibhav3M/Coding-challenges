class InsertionSort(object):

    def sort(self, arr):

        for firstUnsortedIndex in range(1, len(arr)):

            currElement = arr[firstUnsortedIndex]
            i = firstUnsortedIndex

            while (i > 0 and arr[i-1] > currElement):
                arr[i] = arr[i-1]
                i-=1
            
            arr[i] = currElement

        return arr


arr = [20, 35, -15, 7, 55, 1, -22]
insertionSort = InsertionSort()

print(insertionSort.sort(arr))
