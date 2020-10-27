class SelectionSort {

    public static int[] sort(int[] arr) {
        return selectionSort(arr);
    }

    public static int[] selectionSort(int[] arr) {
        // time O(n^2)
        // un-stable
        // inplace
        
        for (int lastUnsortedIndex = arr.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            int largestIndex = 0;

            for (int j = 1; j <= lastUnsortedIndex; j++) {
                if (arr[j] > arr[largestIndex]) {
                    largestIndex = j;
                }
                swap(arr, largestIndex, lastUnsortedIndex);
            }
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j) {

        if (i == j) {
            return;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

class testSelection {

    public static void main(String args[]) {

        int[] arr = { 20, 35, -11, 7, 55, 1, -22 };

        SelectionSort.sort(arr);

        for (int i : arr) {
            System.out.print(i + ", ");
        }

        System.out.println();

    }
}