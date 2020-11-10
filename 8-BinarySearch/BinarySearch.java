
public class BinarySearch {

    private static int binarySearch(int[] arr, int val) {
        // time O(longn)
        // space O(logn) -> because recursion
        return helper(arr, val, 0, arr.length - 1);
    }

    private static int helper(int[] arr, int val, int left, int right) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;

        if (val < arr[mid]) {
            return helper(arr, val, left, mid - 1);
        } else if (val > arr[mid]) {
            return helper(arr, val, mid + 1, right);
        } else {
            return mid;
        }
    }

    public static void main(String args[]) {
        
        int[] arr = {0,1,3, 20, 32, 44, 65, 70};

        System.out.println(binarySearch(arr, 3));
    }

}
