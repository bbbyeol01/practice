package goods2;

public class CheckStringNumber {
	
//		char[] numstr = s.toCharArray();
//		
//		for(int num : numstr) {
//		//	if('0' <= num && num <= '9'){	
//			if(Character.isDigit(num)) {
//				return true;
//			}	//	end of if
//		}	//	end of for
//		
//		return false;
	public static boolean isNum(String s) {
		char ch = ' ';

		boolean isNumber = false;
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);
			if (!('0' <= ch && ch <= '9')) {
				return false;
			} else {
				isNumber = true;
			}
		} // end of for

		return isNumber;

	}
}
