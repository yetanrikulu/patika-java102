package quickSort;

public class QuickSort {

    public void sort(int arr[], int start , int end){
        if (start<end){
            int index = partition(arr,start,end);
            sort (arr,start,index-1);
            sort(arr,index+1,end);
        }

    }

    private int partition(int[] arr, int start, int end) {

        int pivot = arr[end];
        int i = start - 1;

        for (int j = start ;j<end;j++){
            if (arr[j]<=pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;


        return i+1;



    }

}
