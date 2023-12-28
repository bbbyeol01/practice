/*
 * 1. ��ü �帧�� ���� ���� ���
 * 		void displayMenu()
 * 2. �޴��� �����ְ� �Է� �ޱ�(��� ����)
 * 		int menuView() �޴��� �����ְ� �ٷ� ���� ����� �Է� ����	���� ��: int
 * 3. ��ǰ ������ �Է��ϴ� ȭ��
 * 		GoodsBean add()	���� ��: GoodsBean
 * 4. ��ǰ ��ȣ�� �Է��ϴ� ȭ��		
 * 		int goodsId()		���� ��: int
 * 5. ��ǰ ������ �����ϴ� ȭ��
 * 		GoodsBean update()	���� ��: GoodsBean
 * 
 * �Է� : �ܼ� (or ��, ��, ���ڵ�...)
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
				case 1: // ��ǰ �߰�
					System.out.println("[��ǰ �߰�]");
					new GoodsControl().add(add());
					break;
				case 2: // ��ǰ ����
					System.out.println("[��ǰ ����]");
					new GoodsControl().update(update());
					break;
				case 3: // ��ǰ ��ü ��ȸ
					System.out.println("[��ǰ ��ü ��ȸ]");
					new GoodsControl().listAll();
					break;
				case 4: // ��ǰ ��ȣ�� ��ȸ
					System.out.println("[��ǰ ��ȸ]");
					new GoodsControl().selectOne(goodsId());
					break;
				case 5: // ��ǰ ����
					System.out.println("[��ǰ ����]");
					new GoodsControl().delete(goodsId());
					break;
				case 999: // ����
					System.out.println("[���α׷��� �����մϴ�.]");
					return;
				default:
					System.out.println("[�߸��� �Է��Դϴ�.]");
			}// switch
		} // while(true)
	}// displayMenu()

	public int menuView() {

		System.out.println("========== �޴� ==========");
		System.out.println("      1. ��ǰ �߰�");
		System.out.println("      2. ��ǰ ����");
		System.out.println("      3. ��ü ��ǰ ��ȸ");
		System.out.println("      4. ��ǰ ��ȸ");
		System.out.println("      5. ��ǰ ����");
		System.out.println("========================");

		System.out.print("[�޴� ����]: ");
		String tmp = scan.nextLine();

		return tmp.length() > 3 ? Integer.parseInt(tmp.substring(0, 3)) : Integer.parseInt(tmp);
	}

	public GoodsBean add() {
		int cnt = 0;

		GoodsBean goodsBean = new GoodsBean();
		System.out.print("[��ǰ��]: ");
		goodsBean.setGname(scan.nextLine());
		System.out.print("[��ǰ ����]: ");
		goodsBean.setGcontent(scan.nextLine());
		while (cnt < 1) {
			System.out.print("[����]: ");
			String tmp = scan.nextLine();
			cnt = CheckStringNumber.isNum(tmp) ? Integer.parseInt(tmp) : 0;
			if (cnt < 1) {
				System.out.println("[�߸��� �Է��Դϴ�.]");
			}
		}
		goodsBean.setGcnt(cnt);
		System.out.print("[���]: ");
		goodsBean.setGetc(scan.nextLine());

		return goodsBean;
	}

	public int goodsId() {

		int gid = 0;

		while (gid < 1) {
			System.out.print("[��ǰ ��ȣ �Է�]: ");
			String tmp = scan.nextLine();
			gid = CheckStringNumber.isNum(tmp) ? Integer.parseInt(tmp) : 0;
			if (gid < 1) {
				System.out.println("[�߸��� �Է��Դϴ�.]");
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

		// Menu -> Controller ȣ��
		// menu���� control �޼��� ȣ��
		//
		// Control -> Service ȣ��
		// control �޼��忡�� service �޼��� ȣ��

		// Service -> DAO ȣ��
		// service �޼��尡 DAO ȣ��
		//

	}

}
