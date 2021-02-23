package model;

import java.util.Random;

/**
 * 
 * @author Harshvardhan Bhatnagar
 *
 */


public class MastermindModel {
	//private variable(s) to store the answer
	private char[] ans;
	private char[] colors= {'r','o','y','g','b','p'};
	
	
	/**
	 * Constructor for the mastermind model. Generates 
	 * the new color selection randomly. 
	 */
    public MastermindModel() { 
    	ans= new char[4];
    	
    	Random random= new Random();
    	for (int i=0; i<4; i++) {
    			int num= random.nextInt(6);
    			ans[i]=colors[num];
    	}
    }
    
    /**
     * This method is a special constructor to allow us to use JUnit to test our model.
     * 
     * Instead of creating a random solution, it allows us to set the solution from a 
     * String parameter.
     * 
     * 
     * @param answer A string that represents the four color solution
     */
    public MastermindModel(String answer) {
    	// TODO Take answer and somehow store it as your answer. Make sure the getColorAt method 
    	// still works
    	ans=answer.toCharArray();
    }


   /**
    * Returns the color at the given position (char).
    * @param index
    * @return
    */
    public char getColorAt(int index) {
          /* Return color at position index as a char
           (first converted if stored as a number) */
    	
    	return ans[index]; //Just returning something to make sure the code compiles
    }
    
    // Create as many private methods as you like

}
