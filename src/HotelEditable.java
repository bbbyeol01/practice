import java.util.List;

public interface HotelEditable {

	void reserveStatus(List<ReserveInfo> reserveList);

	void cancelStatus(List<ReserveInfo> reserveList);

	void printRoom(String selectedType);

	void currentStatus();

	int checkReserveNumber();

}
