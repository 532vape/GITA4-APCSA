public class roll {
    private int sum;
    private static int point;
    private static Boolean gameStatus = true;
    private static int rolls;
    private String winLose = "";

    roll(int rollsum){
        sum = rollsum;
        game();
        
    }
    private void game(){
            //first roll
            if (rolls <= 1){
                if (sum == 7 || sum == 11){
                    winLose = "YOU WON";
                    Main.counter++;
                    Main.gameswon++;
                    rolls = 0;
                }
                else if (sum == 2 || sum == 3 || sum == 7){
                    winLose = "YOU LOST";
                    Main.counter++;
                    rolls = 0;
                }
                else{
                    point = sum;
                }
                
            }
            
            else if (rolls > 1){
                //after first roll

                
                //win: roll your point
                if (sum == point){
                    winLose = "YOU WON";
                    Main.counter++;
                    Main.gameswon++;
                    rolls = 0;
                }
                //lose: roll a 7
                else if (sum == 7){
                    winLose = "YOU LOST";
                    Main.counter++;
                    rolls = 0;
                }

            }
            rolls+=1;
        }

    public String getGameStatus(){
        return winLose;
    }

    public int returnPoints(){
        return point;
    }

    public static boolean returnGameState(){
        return gameStatus;
    }
}
