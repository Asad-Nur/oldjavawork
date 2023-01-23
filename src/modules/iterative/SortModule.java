package modules.iterative;

/****************************************************************
 * This module implements modules iterative algorithms for array
 * data structures with integer precision.
 ****************************************************************/

public class SortModule {

    //TODO: Update/Complete the following bubbleSort algorithm
    //      using for loops and swap method (see below)
    public static void bubbleSort(int[] data) {
        //TODO: Complete Body

        for (int i=0; i < data.length - 1; i++){
            for(int j= 0; j < data.length - i -1; j++){
                if ( data[j] >data[j+1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j + 1] = temp;

                }
            }

        }

    }


    //TODO: Update/Complete the following insertionSort algorithm
    //      using for loops
    public static void insertionSort(int[] data) {
        //TODO: Complete Body
        int i;
        int j;
        int temp;

        for (i = 1; i < data.length; ++i){

            j=i;

            while (j > 0 && data[j] < data[j - 1]){

                temp = data[j-1];
                data[j] = data[j-1];
                data[j-1] = temp;
                --j;
            }

        }
    }


    // This is an example of "finding the run time function"
    // for a maximum value algorithm
    public static int max(int[] data){
        int n   = data.length;          // (1)      data size
        int max = data[0];              // (1)

        //       (1)
        for(int i = 0; i < n; i++)     // n times
            // (1  + 1)
            if(max < data[i])               // (1)
                max = data[i];              // (1)
        // (1)      terminates loop
        return max;                     // (1)

        // run time function f(n) = 1 + 1 + 1 + n(2 + 1 + 1)
        //                   f(n) = 4n + 5
    }


    //TODO: Update/Complete the following selectionSort algorithm
    //      using for loops and swap method (see below)
    public static void selectionSort(int[] data) {
        //TODO: Complete Body
        int i;
        int j;
        int indexSmallest;
        int temp;

        for (i = 0; i < data.length - 1; ++i){
            indexSmallest = i;
            for (j= i + 1; j < data.length; ++j){
                if ( data[j] < data[indexSmallest]){
                    indexSmallest = j;
                }
            }
            temp = data[i];
            data[i] = data[indexSmallest];
            data[indexSmallest] = temp;
        }
    }


    //TODO: Update/Complete the following swap method
    public static void swap(int[] data, int a, int b) {
        //TODO: Complete Body
    }
}
