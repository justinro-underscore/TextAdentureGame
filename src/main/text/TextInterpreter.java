package main.text;

import java.util.Arrays;

/**
 * Name: Justin Roderman
 * File: TextInterpreter.java
 * Date: August 26, 2018
 * Desc: Object that makes passing commands easy. Used by TextInterpreter.java
 */

public class TextInterpreter
{
	/**
	 * Handles the input by parsing the message
	 * @param msg The raw string being input
	 * @return The CommandObj containing the necessary information
	 */
	public static CommandObj input(String msg)
	{
    	String cmd = "";
    	String[] objs = new String[0];

		String[] temp = msg.split(" ", 2);
		cmd = temp[0];
		if(temp.length > 1)
		{
			objs = temp[1].split(" ");
			// Remove empty strings
			Object[] emptyStrTemp = Arrays.stream(objs).filter(x -> !x.isEmpty()).toArray();
			objs = Arrays.copyOf(emptyStrTemp, emptyStrTemp.length, String[].class);
		}

		// Get the function to be used
		return new CommandObj(cmd, objs);
	}
}
