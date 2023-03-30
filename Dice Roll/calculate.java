import java.text.DecimalFormat;
public class calculate {
    private int introll1, introll2;
    private int rollsum;
    private static float rolls;
    private String[] probabilities = {"", "","","","","","","","","",""}; //each index represents the % of a sum
    private static float[] rollCount = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}; //each index represents the # of times a sum was rolled
    DecimalFormat f = new DecimalFormat("##.00"); //format numbers into a string decimal
    
    calculate(int iroll1, int iroll2){
        //track number of times rolled
        rolls++;
        //integers for sum calculation
        introll1 = iroll1;
        introll2 = iroll2;
        //calculate probabilities of each sum | [] out of 36 total combinations
        //for loop to iterate thru list so no need for 9+ if statements
        rollSum();
        calculateProbability();
    }

    private void rollSum(){
        //get the sum of each roll and increment the count of each sum
        rollsum = introll1 + introll2;
        for (int i = 0; i < 11; i ++){
            if (rollsum == i + 2){
            rollCount[i] += 1;
            }
        }
    }

    private void calculateProbability(){
        //string array to eliminate need for numerous if statements
        for (int i=0; i < 11; i ++){
            //format the result of probability calculation
            probabilities[i] = i + 2 + ": " + f.format(rollCount[i] / rolls * 100f) + "%";
        }
    }

    public int getSum(){
        return rollsum;
    }

    public String[] returnArray(){
        return probabilities;
    }

    public float getRolls(){
        return rolls;
    }

    public float[] returnRollCount(){
        return rollCount;
    }
}

