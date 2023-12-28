/*
 * 사용자 -> Controller 호출
 * Controller -> Service 호출
 * 
 */

package goods;

import java.util.List;

// Control
public class GoodsControl {
	GoodsService goodsService = new GoodsServiceImpl();
//	1. 목록 조회
	
	public void listAll() {
		List<GoodsBean> list = goodsService.listAll();
		
		if(list.isEmpty()) {
			System.out.println("[조회 정보가 없습니다.]");
		}else {
			
			for(GoodsBean goodsBean : list) {
				System.out.println(goodsBean);
			}
		}
	}
	
	public void update(GoodsBean g) {
		int result = goodsService.update(g);
		if(result == 0) {
			System.out.println("[수정 실패]");
		}else {
			System.out.println("[성공]");
		}
	}

	public void add(GoodsBean g) {
		int result = goodsService.add(g);
		if(result == 0) {
			System.out.println("[실패]");
		}else {
			System.out.println("[성공]");
		}
	}
	
	public void delete(int gid) {
		if(goodsService.delete(gid) == 0) {
			System.out.println("[실패]");
		}else {
			System.out.println("[성공]");
		}
	}
	
	public void selectOne(int gid) {
		GoodsBean goodsBean = goodsService.selectOne(gid);
		if(goodsBean == null) {
			System.out.println("[조회 정보가 없습니다.]");
			return;
		}
		
		System.out.println(goodsBean);
	}
	
	
	
	
	
}
