import java.util.Arrays;
import java.util.Scanner;

import controller.MastermindController;
import model.MastermindModel;

/**
 * 
 * @author Harshvardhan Bhatnagar
 * 
 */
public class Mastermind {

	/**
	 * Main method that runs the mastermind game. 
	 * Checks if the player wants to play after 
	 * every game.
	 * @param args
	 */
	
	private static char[] colors= {'r','o','y','g','b','p'};
	public static void main(String[] args) {
		
		System.out.println("Welcome to Mastermind!");
		
		
		Scanner in= new Scanner(System.in);
		System.out.print("Would you like to play? ");
		while (in.nextLine().equals("yes")){
			play(in);
			System.out.print("Would you like to play? ");
		}
		return;
		}
		
	
	/**
	 * This method is used for each iteration of the game 
	 * generates new model and the corresponding controller
	 * It then iterates ten times or until the player wins the
	 * game.
	 * @param in
	 * @throws MastermindIllegalLengthException 
	 */
	private static void play(Scanner in) {
		MastermindModel model= new MastermindModel();
		MastermindController control= new MastermindController(model);
		String guess="";
		for (int i=1; i<=10; i++) {
			System.out.println("");
			System.out.println("Enter guess number "+i+": ");
			
			guess= in.nextLine();
			
			while (true) {
				try {
					checkLength(guess);
					break;
				}catch(MastermindIllegalLengthException e) {
					e.printStackTrace();
					System.out.println("Illegal length, try again. (Expected 4)");
					System.out.println("Enter guess number "+i+": ");
					guess= in.nextLine();
				}
				
			}
			
			while (true) {
				try {
					checkColor(guess);
					break;
				}catch(MastermindIllegalColorException e) {
					e.printStackTrace();
					System.out.println("Illegal color used, try again.");
					System.out.println("Enter guess number "+i+": ");
					guess= in.nextLine();
				}
			}
			
			if (control.isCorrect(guess)) {
				System.out.println("You win!");
				return;
			}else {
				System.out.println("Colors in the correct place: "+
			control.getRightColorRightPlace(guess));
				System.out.println("Colors correct but in wrong position: "+
			control.getRightColorWrongPlace(guess));
			}
		
	}
		System.out.println("You lose!");
	}
	
	public static void checkLength(String guess) throws MastermindIllegalLengthException {
		if (!(guess.length()==4)){
			throw new MastermindIllegalLengthException();
		}
	}
	
	public static void checkColor(String guess) throws MastermindIllegalColorException {
		int count=0;
		for (char color: guess.toCharArray()) {
			for (char valid: colors) {
				if (color==valid) {
					count++;
				}
			}
		}
		if (count<4) {
			throw new MastermindIllegalColorException();
		}
	}
}
