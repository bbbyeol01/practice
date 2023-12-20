import java.util.List;
import java.util.Scanner;

public class Admin implements RoomEditable {
	
	String id;
	String password;

	Scanner scan = new Scanner(System.in);
	
	Admin(String id, String password){
		this.id = id;
		this.password = password;
	}
	
	@Override
	public Room add(List<Room> hotel) {

		Room room = null;
		room = insertRoomInfo();

		System.out.print("[등록하시겠습니까?(y/n)]: ");
		String answer = scan.nextLine();

		if (answer.equalsIgnoreCase("y")) {
			hotel.add(room);
			System.out.println("[등록이 완료되었습니다.]");
			System.out.println();
		} else {
			System.out.println("[취소]");
		}

		return room;
	}

	@Override
	public Room edit(List<Room> hotel) {

		Room room = null;
		String tmp = "";
		int idx = -1;

		printAll(hotel);
		System.out.print("[수정할 룸 선택]: ");
		tmp = scan.nextLine();
		idx = tmp.length() > 5 ? Integer.parseInt(tmp.substring(0, 5)) : Integer.parseInt(tmp);

		System.out.println("[선택하신 룸]");
		System.out.println(hotel.get(idx - 1));

		room = insertRoomInfo();

		System.out.print("[등록하시겠습니까?(y/n)]: ");
		String answer = scan.nextLine();

		if (answer.equalsIgnoreCase("y")) {
			hotel.set(idx - 1, room);
			System.out.println("[등록이 완료되었습니다.]");
			System.out.println();
		} else {
			System.out.println("[취소]");
		}

		System.out.println();
		return room;
	}

	@Override
	public void delete(List<Room> roomList) {

		String tmp = "";
		int idx = -1;

		printAll(roomList);
		System.out.print("[삭제할 룸 선택]: ");
		tmp = scan.nextLine();
		idx = tmp.length() > 5 ? Integer.parseInt(tmp.substring(0, 5)) : Integer.parseInt(tmp);

		if (idx == -1) {
			System.out.println("[잘못된 입력입니다.]");
			return;
		}

		System.out.println("[선택하신 룸]");
		System.out.println(roomList.get(idx - 1));
		System.out.print("[삭제하시겠습니까?(y/n)]: ");
		String answer = scan.nextLine();

		if (answer.equalsIgnoreCase("y")) {
			roomList.remove(idx - 1);
			System.out.println("[삭제가 완료되었습니다.]");
			System.out.println();
		} else {
			System.out.println("[취소]");
			System.out.println();
		}

	}

	@Override
	public void printAll(List<Room> roomList) {
		System.out.println();
		for (int i = 0; i < roomList.size(); i++) {
			System.out.println("[" + (i + 1) + "] " + roomList.get(i));
		}
	}

	@Override
	public Room insertRoomInfo() {

		Room room = new Room();
		String tmp = "";

		// 이름 공백 검사
		do {
			System.out.print("[룸 이름을 입력하세요]: ");
			tmp = scan.nextLine();
			if (!(tmp.length() > 0)) {
				System.out.println("[잘못된 입력입니다.]");
			}
		} while (!(tmp.length() > 0));
		room.setName(tmp);

//		타입 공백 검사
		do {
			System.out.println("[타입]");
			for (Room.RoomType type : Room.RoomType.values()) {
				System.out.println(type);
			}
			System.out.print("[룸 타입을 입력하세요]: ");
			tmp = scan.nextLine();
			tmp = tmp.toUpperCase();
			if (!(tmp.length() > 0)) {
				System.out.println("[잘못된 입력입니다.]");
			}
		} while (!(tmp.length() > 0));
		room.setType(Room.RoomType.valueOf(tmp));

//		룸 번호 공백 검사
		do {
			System.out.print("[호실을 입력하세요]: ");
			tmp = scan.nextLine();
			if (tmp.length() == 0 || !CheckStringNumber.isNum(tmp)) {
				System.out.println("[잘못된 입력입니다.]");
			}
		} while (tmp.length() == 0 || !CheckStringNumber.isNum(tmp));
		room.setRoomNumber(Integer.parseInt(tmp));

		// 가격 공백 검사
		do {
			System.out.print("[가격을 입력하세요]: ");
			tmp = scan.nextLine();
			if (!(tmp.length() > 0)) {
				System.out.println("[잘못된 입력입니다.]");
			}
		} while (!(tmp.length() > 0));
		room.setPrice(tmp.length() > 9 ? Integer.parseInt(tmp.substring(0, 9)) : Integer.parseInt(tmp));

		// 인원 공백 검사
		do {
			System.out.print("[인원을 입력하세요]: ");
			tmp = scan.nextLine();
			if (!(tmp.length() > 0)) {
				System.out.println("[잘못된 입력입니다.]");
			}
		} while (!(tmp.length() > 0));
		room.setParty(tmp.length() > 2 ? Integer.parseInt(tmp.substring(0, 5)) : Integer.parseInt(tmp));

		// 최대 인원 공백 검사
		do {
			System.out.print("[최대 인원을 입력하세요]: ");
			tmp = scan.nextLine();
			if (!(tmp.length() > 0)) {
				System.out.println("[잘못된 입력입니다.]");
			}
		} while (!(tmp.length() > 0));
		room.setMaxParty(tmp.length() > 2 ? Integer.parseInt(tmp.substring(0, 5)) : Integer.parseInt(tmp));

		// 추가 금액 공백 검사
		do {
			System.out.print("[추가 금액을 입력하세요]: ");
			tmp = scan.nextLine();
			if (!(tmp.length() > 0)) {
				System.out.println("[잘못된 입력입니다.]");
			}
		} while (!(tmp.length() > 0));
		room.setPartyExtraCharge(tmp.length() > 8 ? Integer.parseInt(tmp.substring(0, 8)) : Integer.parseInt(tmp));

		System.out.println();
		System.out.println("[입력 정보]");
		System.out.println("[타입] " + room.getType());
		System.out.println("[이름] " + room.getName());
		System.out.println("[가격] " + room.getPrice());
		System.out.println("[인원] " + room.getParty());
		System.out.println("[최대 인원] " + room.getMaxParty());
		System.out.println("[추가 금액] " + room.getPartyExtraCharge());

		return room;
	}

	@Override
	public void init(List<Room> roomList) {
		roomList.add(new Room(Room.RoomType.SINGLE, 101, "싱글룸", 150000, 2, 3, 30000));
		roomList.add(new Room(Room.RoomType.SINGLE, 102, "싱글룸", 150000, 2, 3, 30000));
		roomList.add(new Room(Room.RoomType.SINGLE, 103, "싱글룸", 150000, 2, 3, 30000));
		roomList.add(new Room(Room.RoomType.TWIN, 104, "트윈룸", 200000, 2, 3, 30000));
		roomList.add(new Room(Room.RoomType.DOUBLE, 105, "더블룸", 250000, 2, 4, 30000));
		roomList.add(new Room(Room.RoomType.SUITE, 106, "스위트룸", 400000, 2, 4, 50000));
		roomList.add(new Room(Room.RoomType.STUDIO, 107, "스튜디오룸", 550000, 5, 7, 50000));
	}


}
