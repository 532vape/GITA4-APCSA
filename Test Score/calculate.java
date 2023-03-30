
public class calculate {
    //create variables
    char letterGrade;
    private static float avg;
    private static float ppl;
    private static float topScore;
    private static float total;
    private float percent;
    private float pointsEarned, pointsTotal;

    //increment counter for each person calculated
    calculate(float points, float total){
        ppl++;
        pointsEarned = points;
        pointsTotal = total;
        percentage();
        getGrade();
    }

    //calculate the decimal percentage of the score inputted
    private void percentage(){
        //get decimal percentage of the score
        percent = pointsEarned/pointsTotal;
        total += percent;
        if (percent > topScore){
            topScore = percent;
        }
        avg = total / ppl;
    }

    //based off of the first character in the 
    private void getGrade(){
        String percentString = Float.toString(percent);
        char firstDigit = percentString.charAt(2);
        // System.out.println(firstDigit);
        //determine grades based off the 2nd character in the percent string
        switch(firstDigit){  
            case '9':
                letterGrade = 'A';
                break;
            case '8':
                letterGrade = 'B';
                break;
            case '7':
                letterGrade = 'C';
                break;
            case '6':
                letterGrade = 'D';
                break;
            case '5':
                letterGrade = 'F';
                break;
            case '4':
                letterGrade = 'F';
                break;
            case '3':
                letterGrade = 'F';
                break;
            case '2':
                letterGrade = 'F';
                break;
            case '1':
                letterGrade = 'F';
                break;
            case '0':
                letterGrade = 'F';
        }
    }

    public float getAvg(){
        return avg;
    }

    public float getTotal(){
        return total;
    }

    public float getTopScore(){
        //topscore starts at 0, and as scores are calculated that are higher than 0, those become the new top score
        return topScore;
    }

    public float getPercent(){
        return percent;
    }

    public char getLetterGrade(){
        return letterGrade;
    }

}
