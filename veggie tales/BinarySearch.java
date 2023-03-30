class BinarySearch {

    // Returns index of x if it is present in arr[],
    // else return -1
    int result;
    static int binarySearch(String[] arr, String x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = x.compareTo(arr[m]);

            // Check if x is present at mid
            if (res == 0)
                return m;

            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;

            // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        return -1;
    }

    // Driver method to test above
    public void main(String[] arr, String target)
    {
        // String[] arr = { "contribute", "geeks", "ide", "practice"};
        // String x = "ide";
        result = binarySearch(arr, target);

        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at "
                              + "index " + result);
    }

    int returnResult(){
        return result;
    }
}
