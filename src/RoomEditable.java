import java.util.List;

public interface RoomEditable {
	Room add(List<Room> roomList);
	Room edit(List<Room> roomList);
	void delete(List<Room> roomList);
	void printAll(List<Room> roomList);
	Room insertRoomInfo();
	void init(List<Room> roomList);
}
