import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class User implements ReserveInfoEditable {

	String id;
	String password;

	User(String id, String password) {
		this.id = id;
		this.password = password;
	}

	Scanner scan = new Scanner(System.in);

	public ReserveInfo reserve(Room selectedRoom, ReserveInfo reserveInfo, User user) {

//		기본 정보 입력
		reserveInfo = insertInfo(selectedRoom, user);
//		룸 상태 예약가능 -> 예약됨		
		selectedRoom.setStatus(true);
//		해당 룸 정보 예약 정보에 등록
		reserveInfo.setReserveRoom(selectedRoom);

//		받아온 예약 데이터에 예약 번호 추가
		reserveInfo.setReserveNumber(roomCheckNumber(selectedRoom));

//		초과 인원 1명당 추가 금액
//		extraCharge = 유저 인원 - 기본 인원 > 0 ? (유저 인원 - 기본 인원) * 추가 금액
//		payment = 방 금액 + extraCharge
		int extraCharge = 0;
		int totalPayment = 0;
		extraCharge = reserveInfo.getParty() - reserveInfo.getReserveRoom().getParty() > 0
				? (reserveInfo.getParty() - reserveInfo.getReserveRoom().getParty())
						* (reserveInfo.getReserveRoom().getPartyExtraCharge())
				: 0;

		totalPayment = reserveInfo.getReserveRoom().getPrice() + extraCharge;
		reserveInfo.setPayment(totalPayment);

		return reserveInfo;

	}

	public void cancel(ReserveInfo reserveInfo, List<ReserveInfo> reserveList, List<ReserveInfo> cancelList) {

		// 예약 정보의 예약방 상태 = false
		reserveInfo.getReserveRoom().setStatus(false);
		// 취소 리스트에 추가
		cancelList.add(reserveInfo);

		// 예약 정보가 예약 리스트의 정보와 일치하면 삭제
		for (int i = 0; i < reserveList.size(); i++) {
			if (reserveList.get(i).getCode() == reserveInfo.getCode()) {
				reserveList.remove(i);
				break;
			}
		}

		System.out.println("[취소가 완료되었습니다.]");
		System.out.println();

	}

	public void checkReserve(ReserveInfo reserveInfo) {
		System.out.println();
		System.out.println("==========================");
		System.out.println("[예약번호] " + reserveInfo.getReserveNumber());
		System.out.println();
		System.out.println("[예약자명] " + reserveInfo.getName());
		System.out.println("[룸] " + reserveInfo.getReserveRoom().getName());
		System.out.println("[인원] " + reserveInfo.getParty());
		System.out.println("[연락처] " + reserveInfo.getPhone());
		System.out.println("==========================");
		System.out.println("[확인(Enter)]");
		scan.nextLine();
		System.out.println();
	}

//	기본 정보 입력
//	예약자명
//	연락처 & 연락처 패턴 검사
//	인원 & 최대 인원보다 적게 입력
//	비밀번호
//	전체 정보 공백 검사
	public ReserveInfo insertInfo(Room selectedRoom, User user) {

		String phoneNumberPattern = "^(010)+-?+(\\d{3,4})+-?+(\\d{3,4})$";
		ReserveInfo reserveInfo = new ReserveInfo();
		Room room = (Room) selectedRoom;
		
		reserveInfo.setUser(user);
		
		System.out.println();
		System.out.println("[선택하신 룸] " + selectedRoom.getName());
		System.out.println("[호수] " + selectedRoom.getRoomNumber());
		System.out.println("[인원] " + selectedRoom.getParty());
		System.out.println();

//		예약자명 공백 검사
		do {
			System.out.print("[예약자명을 입력하세요.]: ");
			reserveInfo.setName(scan.nextLine());
			if (!(reserveInfo.getName().length() > 0)) {
				System.out.println("[잘못된 입력입니다.]");
			}
		} while (!(reserveInfo.getName().length() > 0));

//		연락처 패턴 검사
		do {
			System.out.print("[연락처를 입력하세요.]: ");
			reserveInfo.setPhone(scan.nextLine());
			if (!Pattern.matches(phoneNumberPattern, reserveInfo.getPhone())) {
				System.err.println("[입력이 올바르지 않습니다.]");
			}
		} while (!Pattern.matches(phoneNumberPattern, reserveInfo.getPhone()));

		String tmp = "";
//		최대 인원보다 많이 입력하면 오류
		do {
//			인원 공백 검사
			do {
				System.out.print("[인원을 입력하세요]: ");
				tmp = scan.nextLine();
				if (!(tmp.length() > 0)) {
					System.out.println("[잘못된 입력입니다.]");
				}
			} while (!(tmp.length() > 0));

			reserveInfo.setParty(tmp.length() > 2 ? Integer.parseInt(tmp.substring(0, 2)) : Integer.parseInt(tmp));

			if (reserveInfo.getParty() > room.getMaxParty()) {
				System.out.println("[최대 인원은 " + room.getMaxParty() + "명입니다.]");
			}

			if (reserveInfo.getParty() == 0) {
				System.out.println("[0은 입력할 수 없습니다.]");
			}
		} while (reserveInfo.getParty() > room.getMaxParty() || reserveInfo.getParty() == 0);

		return reserveInfo;
	}

	public String roomCheckNumber(Room selectedRoom) {

		Room room = (Room) selectedRoom;
		Calendar cal = Calendar.getInstance();
		Date day = cal.getTime();
		SimpleDateFormat roomCheckNumberFormat = new SimpleDateFormat("yyMMdd-HHmmss");

		String roomCheckNumber = "";
		roomCheckNumber += roomCheckNumberFormat.format(day);
		roomCheckNumber += room.getNumber();
		roomCheckNumber += (String.valueOf(room.getNumber())).charAt(0);

		return roomCheckNumber;

	}// roomCheckNumber

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void search(List<Room> roomList) {

		System.out.println();
		String tmp = "";
		int cnt = 0;
		String status = "";
		System.out.print("[검색]: ");
		tmp = scan.nextLine();

		System.out.println();
		System.out.println("==========================");
		for (int i = 0; i < roomList.size(); i++) {
			if (roomList.get(i).getName().contains(tmp)) {
				if (roomList.get(i).isReserved()) {
					status = "●예약됨●";
				} else {
					status = "○예약가능○";
				}
				System.out.println(
						"   " + roomList.get(i).getRoomNumber() + "호  " + roomList.get(i).getName() + "   " + status);
				cnt++;
			}
		}
		System.out.println("==========================");

		if (cnt == 0) {
			System.out.println("[검색 결과가 없습니다.]");
			System.out.println();
		}

		System.out.println();
		System.out.println("[총 " + cnt + "건의 검색 결과가 있습니다.]");
		System.out.println();
		System.out.println("[확인(Enter)]");
		scan.nextLine();

	}

	@Override
	public String typeSelect() {
		int idx = -1;
		String tmp = "";
		String selectType = null;

		System.out.println();
		System.out.println("==========================");
		int i = 1;
		for (Room.RoomType type : Room.RoomType.values()) {
			System.out.printf("      %8s\n", type.getValue());
			i++;
		}
		System.out.println("==========================");

		do {
			System.out.print("[타입 선택]: ");
			selectType = scan.nextLine();
			if (selectType.length() < 3) {
				System.out.println("[타입을 입력하세요.]");
			}
		} while (selectType.length() < 3);

		System.out.println();

		return selectType;
	}

	@Override
	public int roomSelect(List<Room> roomList, String selectedType) {
		int idx = -1;
		int selectRoom = -1;
		String tmp = "";

		
		System.out.print("[방 선택(호실)]: ");
		tmp = scan.nextLine();

		selectRoom = CheckStringNumber.isNum(tmp)
				? (tmp.length() < 5 ? Integer.parseInt(tmp) : Integer.parseInt(tmp.substring(0, 5)))
				: -1;

		for (int i = 0; i < roomList.size(); i++) {
			if (roomList.get(i).getRoomNumber() == selectRoom) {
				idx = i;
				break;
			}
		}

		return idx;
	}

}
