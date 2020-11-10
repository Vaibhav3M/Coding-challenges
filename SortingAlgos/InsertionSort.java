package SortingAlgos;

public class InsertionSort {

    public static int[] sort(int[] arr) {

        // time O(n^2)
        // Stable
        // inplace

        // we grow the sorted partition from left to right
        // we compare firstUnsorted index to sorted partition till we find correct
        // position

        // issue: involves alot of shifting, so solution shell Sort

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {

            int currentElement = arr[firstUnsortedIndex];

            int j = firstUnsortedIndex;

            while (j > 0 && arr[j - 1] > currentElement) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = currentElement;
        }

        return arr;
    }

}

class testInsertion {

    public static void main(String args[]) {

        int[] arr = { 20, 35, -11, 7, 55, 1, -22 };

        InsertionSort.sort(arr);

        for (int i : arr) {
            System.out.print(i + ", ");
        }

        System.out.println();

    }
}
