class ShellSort(object):

    def sort(self, arr):

        gap = len(arr) // 2

        while(gap > 0):
            for j in range(gap, len(arr)):
                curr = arr[j]
                i = j

                while(i>=gap and arr[i-gap] > curr):
                    arr[i] = arr[i-gap]
                    i = i - gap
                
                arr[i] = curr
            gap = gap // 2

        return arr


arr = [20, 35, -15, 7, 55, 1, -22]
shellSort = ShellSort()

print(shellSort.sort(arr))