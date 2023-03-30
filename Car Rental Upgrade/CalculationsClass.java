//this class does the bulk of calculations for the project
public class CalculationsClass{
    //declare class variables
    //private because we want them to belong only to this class
    private double dblstartMiles, dblendMiles, dbldaysRented, dblCost;
    //private static double dayRate = 0.12;
    private double miles;
    private static double numProcessedInt = 0;
    private static double total;
    private static double avg;
  
    //create a class constructor. it's the first method/function that runs in the class. it basically just sets everything up. the constructor has the same name as the class
  
    CalculationsClass(double startMiles, double endMiles, double daysRented){
      dblstartMiles = startMiles;
      dblendMiles = endMiles;
      dbldaysRented = daysRented;

    }

    private void CalculateCost(){

      //get the # of miles entered by the user, calculate the cost, and increment the total number of people
      miles = getMiles();
      dblCost = 15.00 * dbldaysRented + 0.12 * miles;
      numProcessedInt = (numProcessedInt + 1);
    }

    public double getCost(){

      //return the cost
      CalculateCost();
      return dblCost;
    }

    public double getMiles(){

      //calculate and return miles travelled
      miles = dblendMiles - dblstartMiles;
      return miles;
    }

    public double getEmployeeCount(){
      
      //get the total number of ppl ***actually think this might be redundant
      return numProcessedInt;
    }

    public double getTotal(){

      //calculate total expenditures by customers
      total+=dblCost;
      return total;
    }

    public double getAvg(){

      //calculate and return the average
      avg = total / numProcessedInt;
      return avg;
    }
  }