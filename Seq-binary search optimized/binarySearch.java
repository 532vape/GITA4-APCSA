import java.util.Arrays;

public class binarySearch {
    int binarySuccess;
    public void binarysearch(int sortedarray[], int target){
        for (int i = 0; i < 5000; i++){
            sortedarray[i] = (int)(Math.random() * 5000 + 1);
        }
        
        Arrays.sort(sortedarray);
        // System.out.println(Arrays.toString(sortedArray));
        int left = 0, right = sortedarray.length - 1, middle;
        int counter = 0;
        while (left <= right){
            middle = (left + right) / 2;
            if(target > sortedarray[middle]){
                left = middle + 1;
            }
            else if(target < sortedarray[middle]){  //basically just compareTo()
                right = middle - 1;
            }
            else if (target == sortedarray[middle]){
                binarySuccess += counter;
                break;
            }
            counter++;
        }
    }

    public int returnCounter(){
        return binarySuccess;
    }
}
