/*
 * ����� -> Controller ȣ��
 * Controller -> Service ȣ��
 * 
 */

package goods;

import java.util.List;

// Control
public class GoodsControl {
	GoodsService goodsService = new GoodsServiceImpl();
//	1. ��� ��ȸ
	
	public void listAll() {
		List<GoodsBean> list = goodsService.listAll();
		
		if(list.isEmpty()) {
			System.out.println("[��ȸ ������ �����ϴ�.]");
		}else {
			
			for(GoodsBean goodsBean : list) {
				System.out.println(goodsBean);
			}
		}
	}
	
	public void update(GoodsBean g) {
		int result = goodsService.update(g);
		if(result == 0) {
			System.out.println("[���� ����]");
		}else {
			System.out.println("[����]");
		}
	}

	public void add(GoodsBean g) {
		int result = goodsService.add(g);
		if(result == 0) {
			System.out.println("[����]");
		}else {
			System.out.println("[����]");
		}
	}
	
	public void delete(int gid) {
		if(goodsService.delete(gid) == 0) {
			System.out.println("[����]");
		}else {
			System.out.println("[����]");
		}
	}
	
	public void selectOne(int gid) {
		GoodsBean goodsBean = goodsService.selectOne(gid);
		if(goodsBean == null) {
			System.out.println("[��ȸ ������ �����ϴ�.]");
			return;
		}
		
		System.out.println(goodsBean);
	}
	
	
	
	
	
}