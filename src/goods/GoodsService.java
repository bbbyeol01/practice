/*
 * Service : DAO를 호출하는 클래스(인터페이스)
 * 			 사용자가 요구한 기능을 수행하는 역할
 */

package goods;

import java.util.List;

public interface GoodsService {
//	수행할 기능 중 DB와 접근하는 기능이라면 DAO를 호출함(메서드가 DAO와 동일할 수 있음. Service -> DAO -> DB)
	
//	1. 상품 전체 목록 
	List<GoodsBean> listAll();

//	2. 상품 추가
	int add(GoodsBean g);

//	3. 상품 조회(기본 키 조회)
	GoodsBean selectOne(int gid);

//	4. 상품 수정
	int update(GoodsBean g);

//	5. 상품 삭제(기본 키로 삭제)
	int delete(int gid);
}
