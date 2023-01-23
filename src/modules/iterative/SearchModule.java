package modules.iterative;

/****************************************************************
 * This module implements modules iterative algorithms for array
 * data structures with integer precision.
 ****************************************************************/

public class SearchModule {

    //TODO: Complete this search algorithm to find an element location is in array
    //      use while loops here


    public static int binarySearch(int[] data, int target){
        //TODO: update with search algorithm
        int low;
        int mid;
        int high;

        low = 0;
        high = data.length - 1;

        while (high >= low) {
            mid = (high + low) / 2;
            if (data[mid] < target) {
                low = mid + 1;
            } else if (data[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }


    //TODO: Complete this search algorithm to check if an element is in array
   public static boolean contains(int[] data, int target) {
       for (int datum : data) {
           if (datum == target) {
               return true;
           }
       }
        return false;
    }


    //TODO: Complete this search algorithm to find an element location is in array
    //      use for loops here
    public static int indexOf(int[] data, int target) {
        int i;
        for( i = 0; i < data.length; i++){
            if(data[i] == target){
                return i;
            }
            }
        return -1;
    }

}
