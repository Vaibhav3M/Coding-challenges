class ShellSort{

    public static int[] sort(int[] arr){

        // improvement over interstion sort

        // unstable, O(n2)

        
        for (int gap = arr.length/2; gap > 0; gap/=2){
            for (int firstSortedIndex = gap; firstSortedIndex < arr.length; firstSortedIndex++){

                int curr = arr[firstSortedIndex];
                int i = firstSortedIndex;

                while (i>=gap && arr[i-gap] > curr ){
                    arr[i] = arr[i-gap];
                    i-=gap;
                }
                arr[i] = curr;
            }
        }
        return arr;
    }


    public static void main(String args[]){
        
        int[] arr = { 20, 35, -11, 7, 55, 1, -22 };

        int[] sorted_arr = sort(arr);

        for (int i : sorted_arr) {
            System.out.print(i + ", ");
        }

        System.out.println();

    }
    
}