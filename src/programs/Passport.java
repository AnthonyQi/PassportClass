package programs;
import java.lang.Object;
/**
 * This class represents a person's passport. It has three instance variables
 * representing the first, last and middle name (all are String variables). A
 * character instance variable representing a separator (to be used for
 * formatting purposes) is also part of the class. In addition, the class has a
 * StringBuffer instance variable that represents the passport stamps the person
 * has received.
 * 
 * For this class you need to define and use a private method called
 * validateAndFormat that takes a character as a parameter.
 * 
 * The class will keep track of the number of instances created by using a
 * private static field called objectCount.
 * 
 * @author CS
 *
 */
public class Passport {
	//Variables
	private String first, middle, last;
	private char separator = ',';
	private StringBuffer stamps;
	private static int objectCount = 0;
	
	//constructor
	public Passport(String firstname, String middlename, String lastname) {
		// Validate first and last name
        this.first = validateAndFormat(firstname);
        if (this.first == null) {
            return; // Exit the constructor if the first name is invalid
        }
        this.last = validateAndFormat(lastname);
        if (this.last == null) {
            return; // Exit the constructor if the last name is invalid
        }
        // Handle the middle name
        if (middlename == null || middlename.isBlank()) {
            this.middle = ""; // Set to empty string if blank
        } else {
            this.middle = validateAndFormat(middlename);
            if (this.middle == null) {
                return; // Exit the constructor if the middle name is invalid
            }
        }
        // Initialize stamps as an empty StringBuffer
        this.stamps = new StringBuffer();
        // Increment the object count
        objectCount += 1;
	}//should work as intended
	public Passport(String firstname, String lastname) {
		this(firstname, "", lastname);
	}//this should work as intended
	public Passport() {
		this("SAMPLEFIRSTNAME", "SAMPLEMIDDLENAME", "SAMPLELASTNAME");
	}//done
	public Passport(Passport passport) {
		this.first = passport.first;
		this.middle = passport.middle;
		this.last = passport.last;
		this.stamps = new StringBuffer(passport.stamps);
	}	
	//methods
	public Passport addStamp(String stamp) {
	    // Check if the stamp is null or blank
	    if (stamp == null || stamp.isBlank()) {
	        return this; //Return the current object without modifying anything
	    }
	    // Append the stamp to the stamps buffer
	    this.stamps.append(stamp);
	    // Return the current object
	    return this;
	}
	public StringBuffer getStamps() {
	    return new StringBuffer(this.stamps.toString());
	}
	public char getSeparator() {
		return this.separator;
	}
	public boolean setSeparator(char separator) {
		if(Character.isLetter(separator) ||
				Character.isSpaceChar(separator) || separator == '@') {
			return false;
		}
		//check to see if they are already equal
		if(this.separator == separator) {
			return true;
		}
		this.separator = separator;
		return true;
	}
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;  // Same object
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;  // Not the same class
	    }
	    Passport other = (Passport) obj;
	    // Compare first, middle, and last names ignoring separator
	    return this.first.equals(other.first)
	        && this.middle.equals(other.middle)
	        && this.last.equals(other.last);
	}
	public int compareTo(Passport passport) {
		//find out the value of the comparison of the last names.
		int compareLast = this.last.compareTo(passport.last);
		if(compareLast != 0) return compareLast; 
		//this will check if the last names are equal
		//if not it will move on to comparing first names
		int compareFirst = this.first.compareTo(passport.first);
		if(compareFirst != 0) return compareFirst;
		//finally check for middle name
		int compareMiddle = this.middle.compareTo(passport.middle);
		return compareMiddle;
	}
	public static int getNumberOfPassportObjects() {
		return objectCount;
	}
	public static void resetNumberOfPassportObjects() {
		objectCount = 0;
	}
	public static Passport normalize(Passport passport, boolean uppercase) {
		if(passport == null) {return null;}
		Passport normalizedPassport = new Passport(passport);
		normalizedPassport.setSeparator(passport.getSeparator());
		if(uppercase) {
			normalizedPassport.first = passport.first.toUpperCase();
			normalizedPassport.middle = passport.middle.toUpperCase();
			normalizedPassport.last = passport.last.toUpperCase();
		}
		else {
			normalizedPassport.first = passport.first.toLowerCase();
			normalizedPassport.middle = passport.middle.toLowerCase();
			normalizedPassport.last = passport.last.toLowerCase();
		}
        return normalizedPassport;
    }
	public boolean changeLastname(String lastname) {
		String formatLast = validateAndFormat(lastname);
		if(formatLast != null) {
			this.last = formatLast;
			return true;
		}
		//if invalid return false.
		return false;
	}
	public String toString() {
		//combine first and last name
        String result = last + separator + first;
        // If middle name exists (not null and not empty), append it
        if (middle != null && !middle.isEmpty()) {
            result += this.separator + this.middle;
        }
        return result;
	}
	/*
	 * This method will generate and return a formatted string in lowercase with the
	 * first character in uppercase. The parameter is valid if it is not null and it
	 * is not blank according to the string method isBlank(). If the parameter is
	 * invalid, the method will return null and perform no further processing. If
	 * the parameter is valid, spaces surrounding the parameter will be removed, the
	 * string will be converted to lowercase, and the first character of the string
	 * (after spaces have been removed) will be in upper case. The following methods
	 * can be helpful during the implementation of this method:
	 * Character.toUpperCase, and the string methods charAt and substring.
	 * 
	 * You can test this method by initially defining it public; once you have
	 * tested it, make it private.
	 * 
	 */
	private static String validateAndFormat(String name) {
		// Check if name is null or blank
	    if (name == null || name.isBlank()) {
	        return null; // Invalid, return null
	    }
	    //removes whitespace from beginning and end
	    name = name.trim();
	    // Convert to lowercase.
	    name = name.toLowerCase();
	    // Capitalize the first letter
	    String formattedName = 
	    		Character.toUpperCase(name.charAt(0)) + name.substring(1);
	    //separates first letter and sets it to uppercase
	    //appends rest of string to it
	    return formattedName;
	}
}