import java.util.Arrays;

public class Insert {
    private int index;
    public static boolean proceed = true;
    private int[] output;

    public void Main(int[] arr, int numtoFind){
        checkArray(arr, numtoFind);
        if (proceed == true){
            output = insert(arr.length, arr, numtoFind, index);
        }
        System.out.println(Arrays.toString(output));
        
    }
    
    private void checkArray(int[] arr, int numtoFind){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > numtoFind){
                index = i + 1;
                break;
            }
            else if (arr[i] == numtoFind){
                proceed = false;
                break;
            }
        }
        // System.out.println(Arrays.toString(output));
    }

    private static int[] insert(int n, int arr[], int x, int pos){
        int i;
        int newarr[] = new int[n+1];

        for (i = 0; i < n + 1; i ++){
            if (i < pos - 1){
                newarr[i] = arr[i];
            }
            else if (i == pos - 1){
                newarr[i] = x;
            }
            else{
                newarr[i] = arr[i-1];
            }
        }
        return newarr;

    }

    public int[] returnNewarr(){
        return output;
    }
}
