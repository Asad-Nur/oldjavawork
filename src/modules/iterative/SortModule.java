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
                    swap(data, j, j+1);

                }
            }

        }

    }


    //TODO: Update/Complete the following insertionSort algorithm
    //      using for loops
    public static void insertionSort(int[] data) {
        int i;
        int j;
        int temp;

        for (i = 1; i < data.length; ++i){

            j=i;

            while (j > 0 && data[j] < data[j - 1]){

                temp = data[j];
                data[j] = data[j-1];
                data[j-1] = temp;
                --j;
            }

        }
    }



    //TODO: Update/Complete the following selectionSort algorithm
    //      using for loops and swap method (see below)
    public static void selectionSort(int[] data) {
        //TODO: Complete Body
        int i;
        int j;
        int indexSmallest;

        for (i = 0; i < data.length - 1; ++i){
            indexSmallest = i;
            for (j= i + 1; j < data.length; ++j){
                if ( data[j] < data[indexSmallest]){
                    indexSmallest = j;
                }
            }
            swap(data, i, indexSmallest);
        }
    }


    //TODO: Update/Complete the following swap method
    public static void swap(int[] data, int a, int b) {
        //TODO: Complete Body
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
