/* 
 * DAO(Data Access Object): 데이터베이스에 접근하는 클래스(인터페이스)
 * 
 * 1. 상품 전체 목록 
 * 		List<GoodsBean> listAll();	리턴 타입: List<GoodsBean> / 매개변수: 없음
 * 2. 상품 추가
 * 		int add(GoodsBean g);	리턴 타입: int(성공/실패 여부 확인) or void / 매개변수: GoodsBean
 * 3. 상품 조회(기본 키 조회)
 * 		GoodsBean selectOne(int gid);	리턴 타입: GoodsBean / 매개변수: int gid(상품 기본 키)
 * 4. 상품 수정
 * 		int update(GoodsBean g);	리턴 타입: int(성공/실패 여부 확인) or void / 매개변수: GoodsBean
 * 5. 상품 삭제(기본 키로 삭제)
 * 		int delete(int gid);	리턴 타입: int(성공/실패 여부 확인) or void / 매개변수: int gid(상품 기본 키)
 * 
 */

package goods;

import goods.GoodsBean;

import java.util.List;

// 메서드는 반드시 추상 메서드. public abstract 생략 가능
// 필드는 반드시 클래스(정적) 상수. public static final
public interface GoodsDAO {
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
