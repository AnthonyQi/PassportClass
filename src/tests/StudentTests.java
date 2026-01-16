package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import programs.Passport;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class StudentTests {
	/*
	 * Each method in a JUnit StudentTest class represents a test. You can write
	 * code in a method of this class as you do in the main method of a driver. 
	 * As you write your code, define methods in this class that test each of 
	 * the methods you need to implement. When you run a method you can have 
	 * System.out.println statements to see the results of your code. Using 
	 * this approach is simpler than defining driver classes.
	 * 
	 * For this project you don't need to worry about adding assertions (we will
	 * talk about them soon). If you don't add assertions, by default, every test
	 * will pass (so when you run your student tests you will see a green bar).  
	 * We have left two examples of tests below so you can see how you can test
	 * your code.
	 * 
	 * You can run a single test (e.g., testingtoString() below) by double-clicking
	 * on the method's name and selecting Run-->Run As-->JUnit Test.  You can also
	 * double-click on the method's name and select the white triangle that is inside
	 * of a green circle (under Navigate menu entry).
	 */
	
	@Test
	public void testingtoString() {
		System.out.println("\nTesting toString");
		System.out.println("--------------------------------------");
		Passport passport1 = new Passport("Rose", "Sanders");
		System.out.println(passport1.toString());
		String correct = "Sanders,Rose";
		assertTrue(correct.equals(passport1.toString()));
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	@Test
	public void testingPassport() {
		System.out.println("\nTesting passport(just the first and last name)");
		System.out.println("--------------------------------------");
	    Passport passport = new Passport("John", "Doe");
	    String correct = "Doe,John";
	    System.out.println(passport.toString());
	    assertTrue(passport.toString().equals(correct));
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	@Test
	public void testingPassport2() {
		System.out.println("\nTesting passport(3 instance variables)");
		System.out.println("--------------------------------------");
	    Passport passport = new Passport("John", "Wayne", "Doe");
	    System.out.println(passport.toString());
	    String correct = "Doe,John,Wayne";
	    assertTrue((passport.toString().equals(correct)));
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	@Test
	public void testingPassport3() {
		System.out.println("\nTesting passport(passport) method");
		System.out.println("--------------------------------------");
	    Passport passport = new Passport("John", "Wayne", "Doe");
	    Passport newPass = new Passport(passport);
	    System.out.println("Passport: " + passport + "\nNew Passport: "
	    		+ newPass);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	@Test
	public void testingDefaultPassport() {
		System.out.println("\nTesting default passport");
		System.out.println("--------------------------------------");
	    Passport passport = new Passport();
	    System.out.println(passport.toString());  
	    // Should print SAMPLELASTNAME,SAMPLEFIRSTNAME,SAMPLEMIDDLENAME
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	@Test
	public void testingSetSeparator1() {
		System.out.println("\nTesting setSeparator1");
		System.out.println("--------------------------------------");
		Passport passport1 = new Passport("Tom", "Johnson");
		System.out.println(passport1);
		
		passport1.setSeparator('#');
		System.out.println(passport1.toString());
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	@Test
	public void testingSetSeparator2() {
		System.out.println("\nTesting setSeparator2");
		System.out.println("--------------------------------------");
	    Passport passport = new Passport("QWERTY", "jOhnSon");
	    System.out.println(passport);  // Should print Smith,Tom
	    passport.setSeparator('@');
	    System.out.println(passport.toString());  // Should print Smith#Tom
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	@Test
	public void testingChangingLastname() {
		System.out.println("\nTesting changingLastName");
		System.out.println("--------------------------------------");
		String answer = "";
		Passport passport1 = new Passport("Robert", "", "ThomPSON");
		passport1.setSeparator(':');
		answer += passport1 +"\n";
		System.out.println(answer.equals("Thompson:Robert"));
		boolean changed = passport1.changeLastname("Smith");
		answer += "Changed: " + changed + "\n";
		answer += passport1 +"\n";
		changed = passport1.changeLastname("     ");
		answer += "Changed: " + changed + "\n";
		answer += passport1 +"\n";
		System.out.println(answer.equals("Smith:Robert"));
		System.out.println(answer);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	@Test
	public void testingObjectCount() {
		System.out.println("\nTesting getNumberOfPassportsObjects");
		System.out.println("--------------------------------------");
		Passport.resetNumberOfPassportObjects();
	    // Initialize or reset the object count if applicable
	    Passport passport1 = new Passport("aMy", "Smith");
	    Passport passport2 = new Passport("Jane", "Johnny", "Johnson");
	    passport1.equals(passport2);
	    // Get the current object count
	    int currentCount = Passport.getNumberOfPassportObjects();
	    //Assuming you have a method for this
	    // Assert the expected count
	    int expectedCount = 2;
	    assertEquals(expectedCount, currentCount); 
	    //Make sure expectedCount is defined correctly
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	@Test
	public void testingCompare() {
		System.out.println("\nTesting compareTo");
		System.out.println("--------------------------------------");
		boolean answer = true;
		Passport pass1 = new Passport("John", "Richard", "White");
		Passport pass2 = new Passport("James", "Sam", "Johnson");
		assertTrue(((pass1.compareTo(pass2)) > 0) == answer);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	@Test
	public void testingEquals() {
		System.out.println("\nTesting equalsTo");
		System.out.println("--------------------------------------");
		boolean answer = true;
		Passport passport1 = new Passport("jOHn", "Ivette", "Pork");
		Passport passport2 = new Passport("   jOHn  ", "Ivette", "Pork");
		Passport passport3 = new Passport("Antonee", "Rudifer");
		assertTrue(((passport1.equals(passport2)) == answer) 
				&& (passport1.equals(passport3)) != answer);
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	@Test
	public void testAddStamps1() {
		System.out.println("\nTesting addStamps1");
	    System.out.println("--------------------------------------");
	    Passport pass = new Passport("John", "Doe");
	    pass.addStamp("USA");
	    pass.addStamp("Canada");
	    String answer = "USACanada";
	    assertEquals(answer, pass.getStamps().toString());
	    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	@Test
	public void testingAddStamps2() {
		System.out.println("testing addStamps2");
		System.out.println("--------------------------------------");
		String answer = "TokyoShanghaiSeoul";
		Passport passport1 = new Passport("Flying", "Tom");
		passport1.addStamp("Tokyo");
		passport1.addStamp("Shanghai").addStamp("Seoul");
		assertEquals(answer, passport1.getStamps().toString());
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}
	@Test
	public void testingNormalize() {
		System.out.println("testing normalize");
		System.out.println("--------------------------------------");
		String testName = new Object() {
		}.getClass().getEnclosingMethod().getName();
		String answer = "";
		
		Passport passport1 = new Passport("Elizabeth", "IRIS", "ThomPSON");
		
		answer += passport1 + "\n";
		boolean uppercase = true;
		answer += Passport.normalize(passport1, uppercase) + "\n";
		uppercase = false;
		answer += Passport.normalize(passport1, uppercase) + "\n";
		passport1.setSeparator('<');
		answer += Passport.normalize(passport1, uppercase) + "\n";
		System.out.println
		(TestingSupport.isResultCorrect(testName, answer, true));
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	}

	
}