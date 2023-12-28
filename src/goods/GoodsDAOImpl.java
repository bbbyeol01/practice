package goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static goods.JDBCTemplate.*;

public class GoodsDAOImpl implements GoodsDAO {

	Connection con = getConnection();
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";

	@Override
	public List<GoodsBean> listAll() {
		List<GoodsBean> list = new ArrayList<>();
		sql = "select gid, gname, gcontent, gcnt, getc from goods";

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new GoodsBean(rs.getInt("gid"), rs.getString("gname"), rs.getString("gcontent"),
						rs.getInt("gcnt"), rs.getString("getc")));
			}

		} catch (SQLException e) {
			System.out.println("[SQL문이 올바르지 않습니다.]");
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(con);
		}

		return list;
	}
	

	@Override
	public int add(GoodsBean g) {
		sql = "insert into goods (gname, gcontent, gcnt, getc) values (?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, g.getGname());
			pstmt.setString(2, g.getGcontent());
			pstmt.setInt(3, g.getGcnt());
			pstmt.setString(4, g.getGetc());
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		
	}

	@Override
	public GoodsBean selectOne(int gid) {
		
		GoodsBean goodsBean = null;
		
		sql = "select gid, gname, gcontent, gcnt, getc from goods where gid = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gid);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				goodsBean = new GoodsBean(rs.getInt("gid"), rs.getString("gname"), rs.getString("gcontent"),
						rs.getInt("gcnt"), rs.getString("getc"));
			}
			
			return goodsBean;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			close(rs);
			close(pstmt);
			close(con);
		}
	}

	@Override
	public int update(GoodsBean g) {
		sql = "update goods set gname = ?, gcontent = ?, gcnt = ?, getc = ? where gid = ?";
	
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, g.getGname());
			pstmt.setString(2, g.getGcontent());
			pstmt.setInt(3, g.getGcnt());
			pstmt.setString(4, g.getGetc());
			pstmt.setInt(5, g.getGid());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		
	}

	@Override
	public int delete(int gid) {
		sql = "delete from goods where gid = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, gid);

			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}finally {
			close(rs);
			close(pstmt);
			close(con);
		}
		
	}

}
