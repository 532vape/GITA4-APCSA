public class sequentialSearch {
    int tries;
    public void sequentialsearch(int array[], int target){

        for (int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random() * 5000 + 1);
        }

        for (int i = 0; i < array.length; i++){
            if(array[i] == target){
                tries += i;
            }
        }
    }

    public int returnTries(){
        return tries;
    }
}
