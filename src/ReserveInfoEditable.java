import java.util.List;

public interface ReserveInfoEditable {
	String typeSelect();
	int roomSelect(List<Room> roomList, String selectedType);
}
