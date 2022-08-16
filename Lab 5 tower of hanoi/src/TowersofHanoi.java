import java.util.Scanner;		//import the Scanner library which will be used to get input from the user

// Towers of Hanoi solution source code in Java
// Uses recursion
public class TowersofHanoi {	//class name is TowersofHanoi

    //Constant values - meaning it will never be changed
    public static final String SOURCE_PEG = "Source";	//constant string word 'Source'
    public static final String TARGET_PEG = "Target"; 	//constant string word 'Target'
    public static final String SPARE_PEG = "Spare";		//constant string word 'Spare'

    //the main method where the application will start to run
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);				//initialize a Scanner object to be used to get input from the user
        System.out.println("Please enter number of discs:");	//Displays the text 'Please enter number of discs:'
        int numberOfDiscs = scanner.nextInt();					//user enters an integer and will be stored in the variable numberOfDiscs
        solveTowersOfHanoi(numberOfDiscs, SOURCE_PEG, TARGET_PEG, SPARE_PEG);	//calls the method solveTowersOfHanoi and passing the values numberOfDiscs and the 3 constant string values
        scanner.close();										//to avoid memory leak, close the scanner since it has already been done using in this program
    }

    // Solve towers of hanoi puzzle using recursion
    // Note the change roles of pegs internally
    private static void solveTowersOfHanoi(int numberOfDiscs, String sourcePeg, String targetPeg, String sparePeg) {
        //The method solveTowersOfHanoi is a recursive method, meaning the method is calling itself
        //So to make sure that we wont have an infinite loop due to recursion,
        //there must be a condition in place that will stop the loop at a given scenario
        //In this case, the way to stop the loop is if the numberOfDiscs is already equal to 1
        //Notice in the ELSE block, that it is calling its own method, but the numberOfDiscs is being subtracted by 1 each time
        if (numberOfDiscs == 1) {													//if numberOfDiscs is equal to 1
            System.out.println(sourcePeg + " => " + targetPeg);						//Displays the text based on the value passed
        } else {																	//if numberOfDics is NOT equal to 1
            solveTowersOfHanoi(numberOfDiscs - 1, sourcePeg, sparePeg, targetPeg);	//calls its own method, but this time the sparePeg becomes the targetPeg and targetPeg becomes the sparePeg
            System.out.println(sourcePeg + " => " + targetPeg);						//Displays the text based on the value passed
            solveTowersOfHanoi(numberOfDiscs - 1, sparePeg, targetPeg, sourcePeg);	//calls its own method, but this time the sparePeg becomes the sourcePeg and sourcePeg becomes the sparePeg
        }
    }

}