package main.text;

import java.util.Arrays;

/**
 * Name: Justin Roderman
 * File: CommandObj.java
 * Date: August 26, 2018
 * Desc: Object that makes passing commands easy. Used by TextInterpreter.java
 */

public class CommandObj
{
	final String cmd;
	final String[] obj;

	/**
	 * Creates the CommandObj, initializing the variables
	 * @param cmd The command being run by the player
	 * @param obj The object(s) being affected by the command
	 */
	public CommandObj(String cmd, String[] obj)
	{
		this.cmd = cmd;
		this.obj = obj;
	}

	public String getCmd()
	{
		return this.cmd;
	}

	public String[] getObj()
	{
		return this.obj;
	}

	@Override
	public String toString()
	{
		return this.cmd + " : " + Arrays.toString(this.obj);
	}
}
