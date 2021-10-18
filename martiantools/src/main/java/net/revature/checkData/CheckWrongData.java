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
		final String WHITE_TEXT = "\u001B[37m";
		final String BLUE_BACKGROUND = "\u001B[44m";
		final String TEXT_COLOR_RESET = "\u001B[0m";
		final String BG_COLOR_RESET = "\u001B[47m"; 

		System.out.print(WHITE_TEXT + BLUE_BACKGROUND);
		System.out.println("extra color");
		System.out.print(TEXT_COLOR_RESET + BG_COLOR_RESET);

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
