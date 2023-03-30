public class Main{
    public static void main(String[] args) throws Exception{
        sequentialSearch sequential = new sequentialSearch();
        binarySearch binary = new binarySearch();
        int[] sequentialArray = new int[5000];
        int target = (int)(Math.random() * 5000 + 1);
        
        for (int i = 0; i < 5000; i++){
            sequential.sequentialsearch(sequentialArray, target);
            
            binary.binarysearch(sequentialArray, target);
        }
        System.out.println(sequential.returnTries()/5000);
        System.out.println(binary.returnCounter()/5000);
    }

}