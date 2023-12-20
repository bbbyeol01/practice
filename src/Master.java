import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Master implements MainController{
	
	Scanner scan = new Scanner(System.in);

	@Override
	public void printAdminMenu() {
		System.out.println("========== 관리자 ==========");
		System.out.println("       1. 방 추가");
		System.out.println("       2. 방 수정");
		System.out.println("       3. 방 삭제");
		System.out.println("       4. 방 조회");
		System.out.println("       5. 방 전체 조회");
		System.out.println("       6. 전체 예약 조회");
		System.out.println("       7. 전체 취소 조회");
		System.out.println("       8. 예약 조회");
		System.out.println("       9. 예약 수정");
		System.out.println("       10. 예약 취소");
		System.out.println("       11. 초기화");
		System.out.println("       99. 나가기");
		System.out.println("==========================");

	}
	
	@Override
	public boolean checkAdminPassword(Admin admin) {

		String inputPassword = "";
		System.out.print("[비밀번호를 입력하세요]: ");
		inputPassword = scan.nextLine();

		if (!inputPassword.equals(admin.password)) {
			System.out.println("[비밀번호가 올바르지 않습니다.]");
			return false;
		}

		return true;
	}
	
	@Override
	public void printMenu() {
		System.out.println("=========== 메뉴 ===========");
		System.out.println("        1. 예약");
		System.out.println("        2. 취소");
		System.out.println("        3. 예약 현황");
		System.out.println("        4. 예약 확인");
		System.out.println("        5. 검색");
		System.out.println("==========================");

	}
	
	@Override
	public void printMsg(ReserveInfo reserveInfo, String func) {

		Calendar cal = Calendar.getInstance();
		Date day = cal.getTime();
		SimpleDateFormat roomCheckDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 HH시 mm분");

		System.out.println();
		System.out.println("==========================");
		System.out.println();
		System.out.println("[금액] " + reserveInfo.getPayment());
		if (reserveInfo.getPayment() - reserveInfo.getReserveRoom().getPrice() > 0) {
			System.out.println("[기본 금액] " + reserveInfo.getReserveRoom().getPrice());
			System.out.println("[추가 금액] " + (reserveInfo.getPayment() - reserveInfo.getReserveRoom().getPrice()));
		}
		System.out.println();

//		TODO 결제 확인하는 메서드 추가~!
//		if(!결제됐니?) {
//			System.out.println("[결제 실패]");
//			return;
//		}

		System.out.println("[" + func + "이 완료되었습니다.]");
		System.out.println();
		System.out.println("[예약일시] " + roomCheckDateFormat.format(day));
		System.out.println("[예약번호] " + reserveInfo.getReserveNumber());
		System.out.println();
		System.out.println("[예약자명] " + reserveInfo.getName());
		System.out.println("[룸] " + reserveInfo.getReserveRoom().getName());
		System.out.println("[인원] " + reserveInfo.getParty());
		System.out.println("[연락처] " + reserveInfo.getPhone());
		System.out.println();
		System.out.println("==========================");
		System.out.println();
		System.out.println("[예약번호 분실 시 조회/취소할 수 없습니다.]");
		System.out.println("[확인(Enter)]");
		scan.nextLine();
	}

	@Override
	public boolean checkUserPassword(ReserveInfo reserveInfo) {
		
		User user = reserveInfo.getUser();
		String inputPassword = "";
		System.out.print("[비밀번호를 입력하세요.]: ");
		inputPassword = scan.nextLine();
		
		if (!inputPassword.equals(user.getPassword())) {
			return false;
		}

		return true;
	}

	
	
}
