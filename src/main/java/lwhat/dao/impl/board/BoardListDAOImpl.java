package lwhat.dao.impl.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lwhat.constants.BoardConstants;
import lwhat.dto.board.GboardDTO;
import lwhat.dto.board.QboardDTO;
import lwhat.util.ConnectionManager;

public class BoardListDAOImpl extends AbstractBoardDAOImpl {
	private ResultSet rs;

	// Gboard
	@Override
	public ArrayList<GboardDTO> listBoard(int pageNumber) throws Exception {

		ArrayList<GboardDTO> list = new ArrayList<GboardDTO>();
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt =conn
					.prepareStatement(BoardConstants.board.getProperty("GBOARD_LIST_SQL"));
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GboardDTO gboardDTO = new GboardDTO();
				gboardDTO.setgPostingID(rs.getInt(1));
				gboardDTO.setMemberID_FK(rs.getString(2));
				gboardDTO.setBoardCategory(rs.getString(3));
				gboardDTO.setTitle(rs.getString(4));
				gboardDTO.setContent(rs.getString(5));
				gboardDTO.setClickCount(rs.getInt("clickCount"));
				gboardDTO.setmDate(rs.getString("mDate"));
				list.add(gboardDTO);
				System.out.println(list);
				ConnectionManager.closeConnection(rs, pstmt, conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// Qboard
	@Override
	public ArrayList<QboardDTO> listQboard(int pageNumber) throws Exception {

		ArrayList<QboardDTO> list = new ArrayList<QboardDTO>();
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement(BoardConstants.board.getProperty("QBOARD_LIST_SQL"));
			pstmt.setInt(1, qboardGetNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				QboardDTO qboardDTO = new QboardDTO();
				qboardDTO.setqPostingID(rs.getInt(1));
				qboardDTO.setMemberID_FK(rs.getString(2));
				qboardDTO.setboardCategory(rs.getString(3));
				qboardDTO.setTitle(rs.getString(4));
				qboardDTO.setContent(rs.getString(5));
				qboardDTO.setClickCount(rs.getInt("clickCount"));
				qboardDTO.setmDate(rs.getString("mDate"));
				list.add(qboardDTO);
				System.out.println(list);
			}//while
			ConnectionManager.closeConnection(rs, pstmt, conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}//QboardList

	public boolean nextPage(int pageNumber) {

		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement(BoardConstants.board.getProperty("GBOARD_NEXT_PAGE"));
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				ConnectionManager.closeConnection(rs, pstmt, conn);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean qboardNextPage(int pageNumber) {

		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement(BoardConstants.board.getProperty("QBOARD_NEXT_PAGE"));
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				ConnectionManager.closeConnection(rs, pstmt, conn);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}//qboard nextpage

	// 검색 Gboard
	@Override
	public ArrayList<GboardDTO> listSearchBoard(String searchDomain, String searchText) throws Exception {
		ArrayList<GboardDTO> list = new ArrayList<GboardDTO>();
		String SQL = "select * from generalposting";
		String boardTitle = null;

		if (searchDomain.equals("title")) {
			boardTitle = " where title ";
		} else if (searchDomain.equals("memberID_FK")) {
			boardTitle = " where memberID_FK ";
		}
		SQL += (boardTitle + "like '%" + searchText + "%' ");
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		rs = pstmt.executeQuery();

		GboardDTO gboardDTO = null;
		while (rs.next()) {
			gboardDTO = new GboardDTO();
			gboardDTO.setgPostingID(rs.getInt(1));
			gboardDTO.setMemberID_FK(rs.getString(2));
			gboardDTO.setBoardCategory(rs.getString(3));
			gboardDTO.setTitle(rs.getString(4));
			gboardDTO.setContent(rs.getString(5));
			gboardDTO.setClickCount(rs.getInt("clickCount"));
			gboardDTO.setmDate(rs.getString("mDate"));
			list.add(gboardDTO);
		}
		ConnectionManager.closeConnection(rs, pstmt, conn);
		return list;
	}//Gboard search

	// 검색 Qboard
	@Override
	public ArrayList<QboardDTO> listSearchQBoard(String searchDomain, String searchText) throws Exception {
		ArrayList<QboardDTO> list = new ArrayList<QboardDTO>();
		String SQL = "select * from questionposting";
		String boardTitle = null;

		if (searchDomain.equals("title")) {
			boardTitle = " where title ";
		} else if (searchDomain.equals("memberID_FK")) {
			boardTitle = " where memberID_FK ";
		}
		SQL += (boardTitle + "like '%" + searchText + "%' ");
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		rs = pstmt.executeQuery();

		QboardDTO qboardDTO = null;
		while (rs.next()) {
			qboardDTO = new QboardDTO();
			qboardDTO.setqPostingID(rs.getInt(1));
			qboardDTO.setMemberID_FK(rs.getString(2));
			qboardDTO.setboardCategory(rs.getString(3));
			qboardDTO.setTitle(rs.getString(4));
			qboardDTO.setContent(rs.getString(5));
			qboardDTO.setClickCount(rs.getInt("clickCount"));
			qboardDTO.setmDate(rs.getString("mDate"));
			list.add(qboardDTO);
		}
		ConnectionManager.closeConnection(rs, pstmt, conn);
		return list;
	}//Qboard search

	public int getNext() {
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement(BoardConstants.board.getProperty("GBOARD_GETNEXT"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ConnectionManager.closeConnection(rs, pstmt, conn);
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int qboardGetNext() {
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement(BoardConstants.board.getProperty("QBOARD_GETNEXT"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ConnectionManager.closeConnection(rs, pstmt, conn);
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public String getNickName(String memberID) {
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement(BoardConstants.board.getProperty("NICKNAME_GET"));
			pstmt.setString(1, memberID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				ConnectionManager.closeConnection(rs, pstmt, conn);
				return rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}// getNickName

	public int getPostsCount(String board) {
		String sqlColumn = "";
		int result = 0;
		if (board.equals("generalposting")) {
			sqlColumn = "gPostingID";
		} else {
			sqlColumn = "qPostingID";
		}

		String sql = " select count(" + sqlColumn + ") from " + board;
		System.out.println("count Query loaded ................." + sql);
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			ConnectionManager.closeConnection(rs, pstmt, conn);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}// class
