import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {
    public static void main(){

    }

    public static void sort(int[] arr, int lo, int hi){
        StdRandom.shuffle(arr);
        if(hi<=lo){
            return;
        }
        int j = partition(arr, lo, hi);
        sort(arr,lo,j);
        sort(arr,j+1,hi);
    }

    public static int partition(int[] arr, int lo, int hi){
        int i=lo, j=hi;
        while(true){
            while(arr[++i]<arr[lo]){
                if(i==hi){
                    break;
                }
            }
            while(arr[--j]>arr[lo]){
                if(j==lo){
                    break;
                }
            }
            if(i>=j) {
                break;
            }
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
