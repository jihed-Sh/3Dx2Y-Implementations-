package algorithms;

public class JoeBinarySearch {


    //this is on a sorted array

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    //this is the recursive approach
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (high < low) return -1;
        int mid = low + ((high - low) >> 1);
        if (arr[mid] == target) return mid;
        if (arr[mid] < target) return binarySearchRecursive(arr, target, mid + 1, high);
        return binarySearchRecursive(arr, target, low, mid - 1);
    }

    public static void main(String[] args) {
    }
}
