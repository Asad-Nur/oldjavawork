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

        int min = 0;
        int max = data.length - 1;

        while (max >= min) {
            int mid = (max + min) / 2;
            if (data[mid] < target) {
                min = mid + 1;
            } else if (data[mid] > target) {
                max = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }


    //TODO: Complete this search algorithm to check if an element is in array
   public static boolean contains(int[] data, int target) {
       for (int i = 0; i < data.length; i++) {
           if (data[i] == target) {
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
