/*
 * 1. 전체 흐름을 보기 위한 기능
 * 		void displayMenu()
 * 2. 메뉴를 보여주고 입력 받기(기능 선택)
 * 		int menuView() 메뉴를 보여주고 바로 선택 기능을 입력 받음	리턴 값: int
 * 3. 상품 정보를 입력하는 화면
 * 		GoodsBean add()	리턴 값: GoodsBean
 * 4. 상품 번호를 입력하는 화면		
 * 		int goodsId()		리턴 값: int
 * 5. 상품 정보를 수정하는 화면
 * 		GoodsBean update()	리턴 값: GoodsBean
 * 
 * 입력 : 콘솔 (or 웹, 앱, 바코드...)
 * 
 */

package goods;

import java.util.Scanner;

import hotelPractice.CheckStringNumber;
import goods.*;

// View
public class GoodsMenu {
	Scanner scan = new Scanner(System.in);
	GoodsControl goodsControl = null;

	public void displayMenu() {
		while (true) {
			int sel = menuView();
			// goodsControl = new GoodsControl();

			switch (sel) {
				case 1: // 상품 추가
					System.out.println("[상품 추가]");
					new GoodsControl().add(add());
					break;
				case 2: // 상품 수정
					System.out.println("[상품 수정]");
					new GoodsControl().update(update());
					break;
				case 3: // 상품 전체 조회
					System.out.println("[상품 전체 조회]");
					new GoodsControl().listAll();
					break;
				case 4: // 상품 번호로 조회
					System.out.println("[상품 조회]");
					new GoodsControl().selectOne(goodsId());
					break;
				case 5: // 상품 삭제
					System.out.println("[상품 삭제]");
					new GoodsControl().delete(goodsId());
					break;
				case 999: // 종료
					System.out.println("[프로그램을 종료합니다.]");
					return;
				default:
					System.out.println("[잘못된 입력입니다.]");
			}// switch
		} // while(true)
	}// displayMenu()

	public int menuView() {

		System.out.println("========== 메뉴 ==========");
		System.out.println("      1. 상품 추가");
		System.out.println("      2. 상품 수정");
		System.out.println("      3. 전체 상품 조회");
		System.out.println("      4. 상품 조회");
		System.out.println("      5. 상품 삭제");
		System.out.println("========================");

		System.out.print("[메뉴 선택]: ");
		String tmp = scan.nextLine();

		return tmp.length() > 3 ? Integer.parseInt(tmp.substring(0, 3)) : Integer.parseInt(tmp);
	}

	public GoodsBean add() {
		int cnt = 0;

		GoodsBean goodsBean = new GoodsBean();
		System.out.print("[상품명]: ");
		goodsBean.setGname(scan.nextLine());
		System.out.print("[상품 설명]: ");
		goodsBean.setGcontent(scan.nextLine());
		while (cnt < 1) {
			System.out.print("[수량]: ");
			String tmp = scan.nextLine();
			cnt = CheckStringNumber.isNum(tmp) ? Integer.parseInt(tmp) : 0;
			if (cnt < 1) {
				System.out.println("[잘못된 입력입니다.]");
			}
		}
		goodsBean.setGcnt(cnt);
		System.out.print("[비고]: ");
		goodsBean.setGetc(scan.nextLine());

		return goodsBean;
	}

	public int goodsId() {

		int gid = 0;

		while (gid < 1) {
			System.out.print("[상품 번호 입력]: ");
			String tmp = scan.nextLine();
			gid = CheckStringNumber.isNum(tmp) ? Integer.parseInt(tmp) : 0;
			if (gid < 1) {
				System.out.println("[잘못된 입력입니다.]");
			}
		}
		return gid;
	}

	public GoodsBean update() {

		int gid = goodsId();
		GoodsBean goodsBean = add();
		goodsBean.setGid(gid);
		return goodsBean;

		// Menu -> Control -> Service -> DAO

		// Menu -> Controller 호출
		// menu에서 control 메서드 호출
		//
		// Control -> Service 호출
		// control 메서드에서 service 메서드 호출

		// Service -> DAO 호출
		// service 메서드가 DAO 호출
		//

	}

}
