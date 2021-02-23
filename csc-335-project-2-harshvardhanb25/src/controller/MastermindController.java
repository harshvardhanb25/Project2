package controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.MastermindModel;

/**
 * 
 * @author Harshvardhan Bhatnagar
 *
 */
public class MastermindController {
	
	
	private char[] ans;
	/**
	 * Constructor for the controller, takes the model 
	 * as a parameter and generates the answer again
	 * for easy computations as char[].
	 * @param model
	 */
	public MastermindController(MastermindModel model) {
		ans= new char[4];
		for (int i=0; i<4; i++) {
			ans[i]=model.getColorAt(i);
		}
	}
 
	/**
	 * Takes the guess as a parameter and returns true if
	 * it matches the correct answer. Returns false otherwise.
	 * @param guess
	 * @return
	 */
    public boolean isCorrect(String guess) {
    	return Arrays.equals(guess.toCharArray(), ans); 
    	}

    /**
     * Takes the guess as a parameter, generates its char[] and
     * then returns the number of colors guessed correctly 
     * including position.
     * @param guess
     * @return
     */
    public int getRightColorRightPlace(String guess) {
    	int count=0;
    	for (int i=0; i<4; i++) {
    		if (guess.charAt(i)==ans[i]) {
    			count++;
    		}
    	}
    	return count; //Just something for now to make sure the code compiles
    }

    /**
     * Takes the guess as a parameter and returns the number
     * of colors guessed correctly without position.
     * @param guess
     * @return
     */
    public int getRightColorWrongPlace(String guess) {
    	List<Integer> indexesUsedAns= new ArrayList<>();
    	List<Integer> indexesUsedGuess=new ArrayList<>();
    	int count=0;
    	for (int i=0; i<4; i++) {
    		if (ans[i]==guess.charAt(i)) {
    			indexesUsedAns.add(i);
    			indexesUsedGuess.add(i);
    		}
    	}
    	for (int i=0; i<4 ; i++) {
    		if (!indexesUsedAns.contains(i)) {
    		for (int j=0; j<4 ; j++) {
    			if (ans[i]==guess.charAt(j) && !indexesUsedGuess.contains(j)) {
    				indexesUsedAns.add(i);
    				indexesUsedGuess.add(j);
    				count++;
    			}
    		}
    	}
    	}
    	return count; //Just something for now to make sure the code compiles
    }

    // Create as many private methods as you like

    
}
