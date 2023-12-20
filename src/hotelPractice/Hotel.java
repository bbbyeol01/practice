package hotelPractice;

import hotelPractice.Room.RoomType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Hotel implements HotelEditable {

	Scanner scan = new Scanner(System.in);

//	이름 ex) 신라호텔
	private String name;
//	등급	1~5
	private Grade grade;
	List<Room> roomList = new ArrayList<>();
	List<ReserveInfo> reserveList = new LinkedList<>();
	List<ReserveInfo> cancelList = new ArrayList<>();

	Hotel() {
//		기본 세팅
//		주석 처리 후 admin(888) -> 11(초기화) 진행 시 동일 목록으로 초기화
		roomList.add(new Room(RoomType.SINGLE, 101, "싱글룸", 150000, 2, 3, 30000));
		roomList.add(new Room(RoomType.SINGLE, 102, "싱글룸", 150000, 2, 3, 30000));
		roomList.add(new Room(RoomType.SINGLE, 103, "싱글룸", 150000, 2, 3, 30000));
		roomList.add(new Room(RoomType.TWIN, 104, "트윈룸", 200000, 2, 3, 30000));
		roomList.add(new Room(RoomType.DOUBLE, 105, "더블룸", 250000, 2, 4, 30000));
		roomList.add(new Room(RoomType.SUITE, 106, "스위트룸", 400000, 2, 4, 50000));
		roomList.add(new Room(RoomType.STUDIO, 107, "스튜디오룸", 550000, 5, 7, 50000));
	}

	Hotel(String name, Grade grade) {
		this();
		this.name = name;
		this.grade = grade;
	}

	enum Grade {
		ONE(1, "1성"), TWO(2, "2성"), THREE(3, "3성"), FOUR(4, "4성"), FIVE(5, "5성");

		private final int gradeNum;
		private final String gradeName;

		Grade(int gradeNum, String gradeName) {
			this.gradeNum = gradeNum;
			this.gradeName = gradeName;
		}

		public String getGrade() {
			return this.gradeName;
		}
	}

	@Override
	public void currentStatus() {
		System.out.println();
		System.out.println("==========================");
		for (int i = 0; i < roomList.size(); i++) {

			String roomCheckStatus = "";
			if (!roomList.get(i).isReserved()) {
				roomCheckStatus = "○예약가능○";
			} else {
				roomCheckStatus = "●예약됨●";
			}

			System.out.printf("  %8s    %6s\n", roomList.get(i).getName(), roomCheckStatus);
		}
		System.out.println("==========================");
		System.out.println();
		System.out.print("[확인(Enter)]");
		scan.nextLine();
		System.out.println();
	}// roomReservedCheck

	@Override
	public void reserveStatus(List<ReserveInfo> reserveList) {
		if (reserveList.isEmpty()) {
			System.out.println();
			System.out.println("[등록된 내역이 없습니다.]");
			System.out.println("[확인(Enter)]");
			scan.nextLine();
			System.out.println();
		}

		System.out.println();
		for (int i = 0; i < reserveList.size(); i++) {
			System.out.println("==========================");
			System.out.println("[" + (i + 1) + "] " + "\n" + reserveList.get(i));
		}

		System.out.println("==========================");
		System.out.println();

		System.out.println("[확인(Enter)]");
		scan.nextLine();
		System.out.println();

	}

	@Override
	public void cancelStatus(List<ReserveInfo> cancelList) {
		reserveStatus(reserveList);
	}

	@Override
	public void printRoom(String selectedType) {
		System.out.println("==========================");
		for (int i = 0; i < roomList.size(); i++) {
			if (roomList.get(i).getType().equals(selectedType)) {
				System.out.println("           " + roomList.get(i).getRoomNumber());
			}
		}
		System.out.println("==========================");
	}

	@Override
	public int checkReserveNumber() {
		String inputReserveNumber = "";
		System.out.print("[예약번호를 입력하세요.]: ");
		inputReserveNumber = scan.nextLine();
		int idx = -1;
		for (int i = 0; i < reserveList.size(); i++) {
			if (inputReserveNumber.equals(reserveList.get(i).getReserveNumber())) {
				return i;
			}
		}

		return idx;
	}

}
