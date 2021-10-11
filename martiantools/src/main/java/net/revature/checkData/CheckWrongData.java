package net.revature.checkData;

/** 
 * Checks if the input of things are correct for their fields. 
 *  **/
public class CheckWrongData {
	/** 
	 * Checks if any number of strings are empty
	 * @param strings - any number of strings
	 *  @return TRUE if any of the strings are empty.
	 *  **/
	public static boolean isEmptyString(String... strings) {
		for(String tempo : strings)
			if(tempo == null || tempo.isEmpty())
				return true;
		return false;
	}

	/** @return TRUE if all of the strings can be parsed as an Integer **/
	public static boolean canParseAsInteger(String... isInt) {
		if(isEmptyString(isInt))
			return false;
		for(String tempo : isInt)
			try {
				Integer.parseInt(tempo);
			} catch(NumberFormatException e) {
				e.printStackTrace();
				return false;
			}
		return true;
	}

	/** @return TRUE if all of the strings can be parsed as a Boolean **/
	public static boolean canParseAsBoolean(String... isBool) {
		if(isEmptyString(isBool))
			return false;
		for(String tempo : isBool)
			try {
				Boolean.parseBoolean(tempo);
			} catch(NumberFormatException e) {
				e.printStackTrace();
				return false;
			}
		return true;
	}
}
