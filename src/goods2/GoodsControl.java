/*
 * 사용자 -> Controller 호출
 * Controller -> Service 호출
 * 
 */

package goods2;

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
	
//	result 값이 0이면 DAO가 실패했다는 뜻
//	1나 row값이 나오면 성공
	public void update(GoodsBean g) {
		
		if(g == null) {
			return;
		}
		
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
	
	public int selectOne(int gid) {
		GoodsBean goodsBean = goodsService.selectOne(gid);
		if(goodsBean == null) {
			System.out.println("[존재하지 않는 상품입니다.]");
			return 0;
		}
		
		System.out.println(goodsBean);
		return 1;
	}
	
	
	
	
	
}
