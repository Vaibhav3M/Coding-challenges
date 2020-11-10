package SortingAlgos;

public class BubbleSort {

    public static int[] sort(int[] arr) {

        return bubbleSort(arr);
    }

    public static int[] sort(int[] arr, boolean ascending){
        // time O(n^2)
        // stable 
        // inplace
        if (ascending){
            return bubbleSort(arr);
        }
       

        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--) {

            for (int i = 0; i < lastSortedIndex; i++) {
                if (arr[i+1] > arr[i]) {
                    swap(arr, i, i + 1);
                }     
           }
        }
    
            return arr;
        
    }

    private static int[] bubbleSort(int[] arr) {

        for (int lastSortedIndex = arr.length - 1; lastSortedIndex > 0; lastSortedIndex--) {

            for (int i = 0; i < lastSortedIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
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

class test {

    public static void main(String args[]) {

        int[] arr = { 20, 35, -15, 7, 55, 1, -22 };

        BubbleSort.sort(arr,false);

        for (int i : arr) {
            System.out.print(i + ", ");
        }

    }
}
