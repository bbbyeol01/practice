/* 
 * DAO(Data Access Object): �����ͺ��̽��� �����ϴ� Ŭ����(�������̽�)
 * 
 * 1. ��ǰ ��ü ��� 
 * 		List<GoodsBean> listAll();	���� Ÿ��: List<GoodsBean> / �Ű�����: ����
 * 2. ��ǰ �߰�
 * 		int add(GoodsBean g);	���� Ÿ��: int(����/���� ���� Ȯ��) or void / �Ű�����: GoodsBean
 * 3. ��ǰ ��ȸ(�⺻ Ű ��ȸ)
 * 		GoodsBean selectOne(int gid);	���� Ÿ��: GoodsBean / �Ű�����: int gid(��ǰ �⺻ Ű)
 * 4. ��ǰ ����
 * 		int update(GoodsBean g);	���� Ÿ��: int(����/���� ���� Ȯ��) or void / �Ű�����: GoodsBean
 * 5. ��ǰ ����(�⺻ Ű�� ����)
 * 		int delete(int gid);	���� Ÿ��: int(����/���� ���� Ȯ��) or void / �Ű�����: int gid(��ǰ �⺻ Ű)
 * 
 */

package goods;

import goods.GoodsBean;

import java.util.List;

// �޼���� �ݵ�� �߻� �޼���. public abstract ���� ����
// �ʵ�� �ݵ�� Ŭ����(����) ���. public static final
public interface GoodsDAO {
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
