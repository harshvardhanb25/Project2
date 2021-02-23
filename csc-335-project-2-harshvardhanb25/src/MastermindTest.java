


import static org.junit.jupiter.api.Assertions.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.jupiter.api.Test;


/**
 * This class collects all of the test methods for our controller.
 * 
 * In eclipse, running it should run it under JUnit. Running the Mastermind class (since
 * it is our main class) will actually run the program. If you're not using eclipse,
 * you'll need to run this under JUnit 5. 
 * 
 * @author YOUR NAME HERE
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class MastermindTest {

	/**
	 * Test method for {@link MastermindController#isCorrect(java.lang.String)}.
	 */
	@Test
	void testIsCorrect() {
		//Build a model with a known answer, using our special testing constructor
		model.MastermindModel answer = new model.MastermindModel("rrrr");
		//Build the controller from the model
		controller.MastermindController controllerUnderTest = new 
				controller.MastermindController(answer);
		
		//For a properly working controller, this should return true
		assertTrue(controllerUnderTest.isCorrect("rrrr"));
		//For a properly working controller, this should be false
		assertFalse(controllerUnderTest.isCorrect("oooo"));
		assertFalse(controllerUnderTest.isCorrect("rorg"));
		assertFalse(controllerUnderTest.isCorrect("rrrrr"));
		assertFalse(controllerUnderTest.isCorrect("ra"));
		assertFalse(controllerUnderTest.isCorrect("rrr"));
		assertFalse(controllerUnderTest.isCorrect("rrrg"));
		//Make as many more assertions as you feel you need to test the MastermindController.isCorrect method
	}

	/**
	 * Test method for {@link MastermindController#getRightColorRightPlace(java.lang.String)}.
	 */
	@Test
	void testGetRightColorRightPlace() {
		//Build a model with a known answer, using our special testing constructor
		model.MastermindModel answer = new model.MastermindModel("rrrr");
		//Build the controller from the model
		controller.MastermindController controllerUnderTest = new 
				controller.MastermindController(answer);
		
		//For a properly working controller, this should return 4
		assertEquals(controllerUnderTest.getRightColorRightPlace("rrrr"), 4);
		
		//For a properly working controller, this should return 0
		assertEquals(controllerUnderTest.getRightColorRightPlace("oooo"), 0);
		assertEquals(controllerUnderTest.getRightColorRightPlace("rorr"), 3);
		assertEquals(controllerUnderTest.getRightColorRightPlace("rror"), 3);
		assertEquals(controllerUnderTest.getRightColorRightPlace("ooro"), 1);
		assertEquals(controllerUnderTest.getRightColorRightPlace("rooo"), 1);
		assertEquals(controllerUnderTest.getRightColorRightPlace("roro"), 2);
		
		
		//You'll need lots more of these to convince yourself your implementation is right
	}

	/**
	 * Test method for {@link MastermindController#getRightColorWrongPlace(java.lang.String)}.
	 */
	@Test
	void testGetRightColorWrongPlace() {
		//TODO this one you're all on your own 
		model.MastermindModel answer= new model.MastermindModel("rbgo");
		controller.MastermindController controllerUnderTest= new
				controller.MastermindController(answer);
		
		//For a properly working controller this should return 0
		assertEquals(controllerUnderTest.getRightColorWrongPlace("rbgo"),0);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("yyyy"),0);
		
		assertEquals(controllerUnderTest.getRightColorWrongPlace("rgbo"),2);
		assertEquals(controllerUnderTest.getRightColorWrongPlace("rgbr"),2);
		
	}

	@Test
	void testPlay() throws FileNotFoundException {
		String[] args= null;
		final InputStream original=System.in;
		final InputStream fileIn= new FileInputStream(
				new File("playTest.txt"));
		System.setIn(fileIn);
		Mastermind.main(args);
		System.setIn(original);
	}
/*
	@Test
	void testPlayErrors2() throws FileNotFoundException {
		String[] args= null;
		final InputStream original=System.in; 
		final InputStream fileIn= new FileInputStream(
			new File("playTest.txt"));
		System.setIn(fileIn);
		assertThrows(
		           MastermindIllegalLengthException.class,
		           () -> (Mastermind.main(args)),
		           "Expected doThing() to throw, but it didn't"
		    );
		
		System.setIn(original);
	}
	*/
}
