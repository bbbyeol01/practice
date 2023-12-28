/*
 * Service : DAO�� ȣ���ϴ� Ŭ����(�������̽�)
 * 			 ����ڰ� �䱸�� ����� �����ϴ� ����
 */

package goods;

import java.util.List;

public interface GoodsService {
//	������ ��� �� DB�� �����ϴ� ����̶�� DAO�� ȣ����(�޼��尡 DAO�� ������ �� ����. Service -> DAO -> DB)
	
//	1. ��ǰ ��ü ��� 
	List<GoodsBean> listAll();

//	2. ��ǰ �߰�
	int add(GoodsBean g);

//	3. ��ǰ ��ȸ(�⺻ Ű ��ȸ)
	GoodsBean selectOne(int gid);

//	4. ��ǰ ����
	int update(GoodsBean g);

//	5. ��ǰ ����(�⺻ Ű�� ����)
	int delete(int gid);
}
