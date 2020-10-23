import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

import apple.laf.JRSUIUtils.Tree;

class ArraySum {

public static void main(String[] args){
    
    System.out.println("I started..!!");
    int[] arr = {3,5,-4,8,11,1,-1,-16};
    int sum = 10; //19
    one(arr,sum);
    second(arr, sum);
    third(arr, sum);
}

    private static void third(int[] arr, int sum){

        //using sorting and 2 pointers
        //time nlogn, space c

        Arrays.sort(arr);

        int i =0;
        int j = arr.length-1;

        while( i<j ){

            int curr = arr[i] + arr[j];

            if(curr == sum){
                System.out.println(arr[i] + " " + arr[j]);
                break;
            }
            else if(curr < sum){
                i++;
            }
            else{
                j--;
            }
        }

    }

    private static void second(int[] arr, int sum){

        //using hashmap
        //time n, space n

        Map<Integer,Boolean> map = new Hashtable<>();

        for(int i:arr){

            if (map.containsKey(sum - i)){
                System.out.println(i + " , "  + (sum-i));
            }
            else{
                map.put(i, true);
            }

        }

    }

    private static void one(int[] arr, int sum) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {

                if (arr[i] + arr[j] == sum) {
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }

    }

}