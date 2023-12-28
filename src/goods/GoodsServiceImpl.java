package goods;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
	
	GoodsDAO dao = new GoodsDAOImpl();

	@Override
	public List<GoodsBean> listAll() {
		return dao.listAll();
	}

	@Override
	public int add(GoodsBean g) {
		return dao.add(g);
	}

	@Override
	public GoodsBean selectOne(int gid) {
		return dao.selectOne(gid);
	}

	@Override
	public int update(GoodsBean g) {
		return dao.update(g);
	}

	@Override
	public int delete(int gid) {
		return dao.delete(gid);
	}

}
