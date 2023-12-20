package hotelPractice;

public class CheckStringNumber {
	
	public static boolean isNum(String s) {
		char ch = ' ';

		boolean isNumber = false;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (!('0' <= ch && ch <= '9')) {
				isNumber = false;
				break;
			} else {
				isNumber = true;
			}
		} // end of for

		return isNumber;

	}
}
