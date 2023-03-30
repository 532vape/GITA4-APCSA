class SelectionSort {
    static String[] output;
    // Sorts an array of strings
    static String[] selectionSort(String[] arr, int n) {
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {

            // Find the minimum element in unsorted array
            int min_index = i;
            String minStr = arr[i];
            for (int j = i + 1; j < n; j++) {

                /*
                 * compareTo() will return a -ve value,
                 * if string1 (arr[j]) is smaller than string2 (minStr)
                 */
                // If arr[j] is smaller than minStr

                if (arr[j].compareTo(minStr) < 0) {
                    // Make arr[j] as minStr and update min_idx
                    minStr = arr[j];
                    min_index = j;
                }
            }

            // Swapping the minimum element
            // found with the first element.
            if (min_index != i) {
                String temp = arr[min_index];
                arr[min_index] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    // Driver code
    public static void main(String[] arr) {
        int n = arr.length;
        // System.out.println("Given array is");

        // Printing the array before sorting
        // for (int i = 0; i < n; i++) {
        //     System.out.println(i + ": " + arr[i]);
        // }
        // System.out.println();

        output = selectionSort(arr, n);
    }

    public static String[] output(){
        return output;
    }
}
