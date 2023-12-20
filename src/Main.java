import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Hotel hotel = new Hotel("신라호텔", Hotel.Grade.FIVE);
//		방 정보 : hotel.roomlist.get(int n)

		User user = new User("byeol", "0123");
		Admin admin = new Admin("admin", "1234");
		Master master = new Master();

		int menuSel = -1;

		String selectedType = "";
		int roomSel = -1;

		int adminSel = -1;
		
		while (true) {
//			메뉴 선택
			master.printMenu();
			System.out.print("[메뉴 선택]: ");
			String tmp = scan.nextLine();
//			parseInt 오류 방지(잘라내기)
			menuSel = CheckStringNumber.isNum(tmp)
					? (tmp.length() > 5 ? Integer.parseInt(tmp.substring(0, 5)) : Integer.parseInt(tmp))
					: -1;

			switch (menuSel) {
//			예약하기
			case 1:
//				방 선택
				do {
					selectedType = user.typeSelect();
					hotel.printRoom(selectedType);
					roomSel = user.roomSelect(hotel.roomList, selectedType);
				} while (roomSel < 0);

				if (roomSel < 0) {
					System.out.println("[잘못된 입력입니다.]");
					break;
				}

				if (hotel.roomList.get(roomSel).isReserved()) {
					System.out.println("[이미 예약된 방입니다.]");
				} else {
					ReserveInfo reserveInfo = user.reserve(hotel.roomList.get(roomSel), new ReserveInfo(), user);
					hotel.reserveList.add(reserveInfo);
					master.printMsg(reserveInfo, "예약");
				}

				break;
//			예약 취소
			case 2:
				int idx = -1;
				idx = hotel.checkReserveNumber();
				if (idx == -1) {
					System.out.println("[예약번호가 올바르지 않습니다.]");
					break;
				}

				if (master.checkUserPassword(hotel.reserveList.get(idx))) {
					System.out.print("[정말로 취소하시겠습니까?(y/n)]: ");
					String answer = scan.nextLine();
					System.out.println();
					if (!answer.equalsIgnoreCase("y")) {
						System.out.println("[중단]");
						break;
					}
					user.cancel(hotel.reserveList.get(idx), hotel.reserveList, hotel.cancelList);
				} else {
					System.out.println("[비밀번호가 올바르지 않습니다.]");
				}

				break;
//			예약 현황
			case 3:
				hotel.currentStatus();
				break;
//			예약 확인
			case 4:
				idx = hotel.checkReserveNumber();
				if (idx == -1) {
					System.out.println("[예약번호가 올바르지 않습니다.]");
					break;
				}

				if (master.checkUserPassword(hotel.reserveList.get(idx))) {
					user.checkReserve(hotel.reserveList.get(idx));
				} else {
					System.out.println("[비밀번호가 올바르지 않습니다.]");
				}
				break;
			case 5:
//				방 검색
				user.search(hotel.roomList);
				break;
//			관리자모드
			case 888:
				boolean adminModeStop = true;
				if (!master.checkAdminPassword(admin)) {
					break;
				}

				adminModeStop = false;

				while (!adminModeStop) {
//					관리자 메뉴 선택
					master.printAdminMenu();
					System.out.print("[메뉴 선택]: ");
					tmp = scan.nextLine();
//					parseInt 오류 방지(잘라내기)
					adminSel = tmp.length() > 5 ? Integer.parseInt(tmp.substring(0, 5)) : Integer.parseInt(tmp);

					switch (adminSel) {
					case 1:
//						방 추가
						admin.add(hotel.roomList);
						break;
					case 2:
//						방 수정
						admin.edit(hotel.roomList);
						break;
					case 3:
//						방 삭제
						admin.delete(hotel.roomList);
						break;
					case 4:
//						방 검색
						user.search(hotel.roomList);
						break;
					case 5:
//						방 전체 조회
						admin.printAll(hotel.roomList);
						System.out.println();
						System.out.println("[확인(Enter)]");
						scan.nextLine();
						System.out.println();
						break;
					case 6:
//						전체 예약 조회
						hotel.reserveStatus(hotel.reserveList);
						break;
					case 7:
//						전체 취소 조회
						hotel.cancelStatus(hotel.cancelList);
						break;
					case 8:
//						예약 조회
						idx = hotel.checkReserveNumber();
						if (idx == -1) {
							System.out.println("[예약번호가 올바르지 않습니다.]");
							break;
						}
						user.checkReserve(hotel.reserveList.get(idx));
						break;
					case 9:
//						예약 수정
//						방 선택
						do {
							selectedType = user.typeSelect();
							hotel.printRoom(selectedType);
							roomSel = user.roomSelect(hotel.roomList, selectedType);
						} while (roomSel < 0);

						if (roomSel < 0) {
							System.out.println("[잘못된 입력입니다.]");
							break;
						}

//						수정(해당 인덱스에 새 정보 덮어씌움)
						if (hotel.roomList.get(roomSel).isReserved()) {
							ReserveInfo reserveInfo = user.reserve(hotel.roomList.get(roomSel), new ReserveInfo(), user);
							hotel.reserveList.set(roomSel, reserveInfo);
							master.printMsg(reserveInfo, "예약 변경");
						}

						break;
					case 10:
//						예약 취소
						idx = -1;
						idx = hotel.checkReserveNumber();
						if (idx == -1) {
							System.out.println("[예약번호가 올바르지 않습니다.]");
							break;
						}

						System.out.print("[정말로 취소하시겠습니까?(y/n)]: ");
						String answer = scan.nextLine();
						if (answer.equalsIgnoreCase("y")) {
							user.cancel(hotel.reserveList.get(idx), hotel.reserveList, hotel.cancelList);
						} else {
							System.out.println("[중단]");
						}

						break;
					case 11:
//						초기화(기본 세팅)

						System.out.println("[기본 세팅으로 초기화합니다.]");
						System.out.println("[기존 정보를 잃을 수 있습니다.]");
						System.out.print("[초기화를 진행하시겠습니까?(y/n)]: ");
						answer = scan.nextLine();

						if (!answer.equalsIgnoreCase("y")) {
							System.out.println("[초기화가 중단되었습니다.]");
							break;
						}

						admin.init(hotel.roomList);
						System.out.println("[초기화가 완료되었습니다.]");
						System.out.println();
						break;
					case 99:
//						관리자 모드 종료
						System.out.print("[관리자 모드를 종료하시겠습니까?(y/n)]: ");
						answer = scan.nextLine();
						if (answer.equalsIgnoreCase("y")) {
							System.out.println("[관리자 모드를 종료합니다.]");
							System.out.println();
							adminModeStop = true;
						} else {
							System.out.println("[취소]");
						}

						break;
					} // 관리자 switch
				}
				break;
			default:
				System.out.println("[잘못된 입력입니다.]");
			} // switch

		} // while(true)
		
	}
}
