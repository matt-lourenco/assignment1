/****************************************************************************
 *
 * Created by: Matthew Lourenco
 * Created on: Feb 2018
 * This program takes a string and scans for any integers. If it
 *     finds and integers it will replace them with the next character
 *     multiplied by the value of the integer
 *
 ****************************************************************************/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringBlowup {

	public static void main(String[] args) {
		// Replaces numbers in a string with the following character
		// multiplied by the number that was replaced.
		
		String userString = "";
		String finalString = "";
		
		BufferedReader reader = new BufferedReader(new InputStreamReader
				(System.in));
		System.out.println("Enter the string you want to be blown up: ");
		try {
			//Get user input
			userString = reader.readLine();
		} catch (IOException noInput) {
			noInput.printStackTrace();
		}
		
		// Check each character in the string
		for(int character=0; character<userString.length()-1; character++) {
			// Check if the selected character is a number
			if(Character.isDigit(userString.charAt(character))) {
				// Duplicate the characters
				for(int repeat=0; repeat<Character.getNumericValue(
						userString.charAt(character)); repeat++) {
					finalString = finalString + userString.charAt(character+1);
				}
			} else {
				finalString = finalString + userString.charAt(character);
			}
		}
		//Check if last character needs to be removed
		if(Character.isLetter(userString.charAt(userString.length()-1))) {
			finalString = finalString + userString.charAt(userString.length()-1);
		}
		System.out.println("The blown up string is: " + finalString);
	}

}
