package hotelPractice;

public interface MainController {

	void printAdminMenu();

	boolean checkAdminPassword(Admin admin);

	void printMsg(ReserveInfo reserveInfo, String func);

	boolean checkUserPassword(ReserveInfo reserveInfo);
	
	void printMenu();
	
}
