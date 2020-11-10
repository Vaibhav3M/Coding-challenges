

def BinarySearchIter(arr, val):

    left = 0
    right = len(arr) - 1

    while( left <= right ):

        mid = (left + right) // 2

        if val < arr[mid]:
            right = mid -1
        elif val > arr[mid]:
            left = mid + 1
        else:
            return mid 
            
    return -1




arr = [0, 1, 3, 20, 32, 44, 65, 70]

print(BinarySearchIter(arr, 23))

    