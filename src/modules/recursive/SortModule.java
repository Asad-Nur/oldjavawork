package modules.recursive;

public class SortModule {

    private static int[] getFirstHalf(int[] data) {
        //TODO : update to get first half of array
        int[] result = new int[data.length / 2];
        for (int i = 0; i < result.length; i++) {
            result[i] = data[i];
        }
        return result;
    }


    private static int[] getSecondHalf(int[] data) {
        //TODO : update to get second half of array
        int[] result = new int[data.length - data.length / 2];
        for (int i = 0; i < result.length; i++) {
            result[i] = data[data.length / 2 + i];
        }
        return result;
    }


    private static void merge(int[] data, int[] left, int[] right) {
        //TODO : update to merge arrays
        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length){
            if (left[leftIndex] < right[rightIndex])
                data[index++] = left[leftIndex++];
            else
                data[index++] = right[rightIndex++];
        }
        while (leftIndex < left.length){
            data[index++] = left[leftIndex++];
        }
        while (rightIndex < right.length){
            data[index++] = right[rightIndex++];
        }
    }


    public static void mergeSort(int[] data) {
        //TODO : update with algorithm
        if (data.length > 1) {
            int[] left = getFirstHalf(data);
            int[] right = getSecondHalf(data);
            mergeSort(left);
            mergeSort(right);
            merge(data, left, right);
        }
    }


    private static int partition(int[] data, int low, int high) {
        //TODO: update with partition algorithm
        int midpoint = (low + high) / 2;
        int pivot = data[midpoint];
        boolean done = false;
        while (!done) {
            while (data[low] < pivot) { ++low; }
            while (pivot < data[high]) { --high; }
            if (low >= high) {
                done = true;
            } else {
                swap(data, low, high);
                        ++low;
                --high;
            }
        }
        return high;
    }


    public static void quickSort(int[] data) {
        //TODO : update to call helper method
        quickSort(data,0,data.length -1);
    }


    private static void quickSort(int[] data, int min, int max) {
        //TODO: update to partition list
        int mid;

        if (min >= max) { return;}

        mid = partition(data, min, max);
        quickSort(data, min, mid);
        quickSort(data, mid + 1, max);
    }


    public static void selectionSort(int[] data) {
        selectionSort(data, 0);
    }


    private static void selectionSort(int[] data, int start) {
        int minIndex;

        if(start < data.length - 1){
            minIndex = start;
            for (int i = start + 1; i < data.length; i++)
                if(data[i] < data[minIndex])
                    minIndex = i;

            swap(data, start, minIndex);
            selectionSort(data, start + 1);
        }
    }

    public static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a]  = data[b];
        data[b]  = temp;
    }
}
