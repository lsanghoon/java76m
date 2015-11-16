package java76.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java76.pms.annotation.Component;
import java76.pms.domain.Board;
import java76.pms.exception.DaoException;
import java76.pms.util.DBConnectionPool;

@Component
public class BoardDao {
	DBConnectionPool dbPool;

	public void setDbConnectionPool(DBConnectionPool dbPool) {
		this.dbPool = dbPool;
	}

	public BoardDao() {}

	public List<Board> selectList() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Board> list = new ArrayList<>();
		try {
			con = dbPool.getConnection();
			
			stmt = con.createStatement();
			rs = stmt.executeQuery("select bno,title,content,views,cr_dt,pw from board");

			Board board = null;
			while (rs.next()) {
				board = new Board();
				board.setNo(rs.getInt("bno"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setViews(rs.getInt("views"));
				board.setCreatedDate(rs.getDate("cr_dt"));
				board.setPassword(rs.getString("pw"));
				list.add(board);
			}
			return list;

		} catch (Exception e) {
			throw new DaoException(e);
			
		} finally {
			try {rs.close();} catch (Exception e) {}
			try {stmt.close();} catch (Exception e) {}
			dbPool.returnConnection(con);
		}
	}

	public int insert(Board board) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dbPool.getConnection();

			stmt = con.prepareStatement(
					"insert into board(title,content,cr_dt,pw) values(?,?,?,?)");

			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getContent());
			stmt.setDate(3, board.getCreatedDate());
			stmt.setString(4, board.getPassword());

			return stmt.executeUpdate();

		} catch (Exception e) {
			throw new DaoException(e);

		} finally {
			try {stmt.close();} catch (Exception e) {}
			dbPool.returnConnection(con);
		}
	}

	public int delete(int no) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dbPool.getConnection();
			
			stmt = con.prepareStatement("delete from board where pno=?");

			stmt.setInt(1, no);

			return stmt.executeUpdate();

		} catch (Exception e) {
			throw new DaoException(e);

		} finally {
			try {stmt.close();} catch (Exception e) {}
			dbPool.returnConnection(con);
		}
	}

	public int update(Board board) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dbPool.getConnection();

			stmt = con.prepareStatement(
					"update board set title=?, content=?, cr_dt=? "
					+ "where bno=? and (pw is null or pw=?");

			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getContent());
			stmt.setDate(3, board.getCreatedDate());
			stmt.setString(4, board.getPassword());
			stmt.setInt(5, board.getNo());

			// update 실행
			return stmt.executeUpdate();

		} catch (Exception e) {
			throw new DaoException(e);
			
		} finally {
			try {stmt.close();} catch (Exception e) {}
			dbPool.returnConnection(con);
		}
	}
}
