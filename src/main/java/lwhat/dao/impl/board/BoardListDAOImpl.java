package lwhat.dao.impl.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lwhat.constants.BoardConstants;
import lwhat.dto.board.GboardDTO;
import lwhat.dto.board.QboardDTO;

public class BoardListDAOImpl extends AbstractBoardDAOImpl {
	private ResultSet rs;
	//Gboard
	@Override
	public ArrayList<GboardDTO> listBoard(int pageNumber) throws Exception {

		ArrayList<GboardDTO> list = new ArrayList<GboardDTO>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(BoardConstants.board.getProperty("GBOARD_LIST_SQL"));
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GboardDTO gboardDTO = new GboardDTO();
				gboardDTO.setgPostingID(rs.getInt(1));
				gboardDTO.setMemberID_FK(rs.getString(2));
				gboardDTO.setBoardCategory(rs.getString(3));
				gboardDTO.setImageCategory(rs.getString(4));
				gboardDTO.setTitle(rs.getString(5));
				gboardDTO.setContent(rs.getString(6));
				gboardDTO.setClickCount(rs.getInt("clickCount"));
				gboardDTO.setmDate(rs.getString("mDate"));
				list.add(gboardDTO);
				System.out.println(list);
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
			PreparedStatement pstmt = getConnection().prepareStatement(BoardConstants.board.getProperty("QBOARD_LIST_SQL"));
			pstmt.setInt(1, qboardGetNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				QboardDTO qboardDTO = new QboardDTO();
				qboardDTO.setqPostingID(rs.getInt(1));
				qboardDTO.setMemberID_FK(rs.getString(2));
				qboardDTO.setboardCategory(rs.getString(3));
				qboardDTO.setimageCategory(rs.getString(4));
				qboardDTO.setTitle(rs.getString(5));
				qboardDTO.setContent(rs.getString(6));
				qboardDTO.setClickCount(rs.getInt("clickCount"));
				qboardDTO.setmDate(rs.getString("mDate"));
				list.add(qboardDTO);
				System.out.println(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean nextPage(int pageNumber) {

		try {
			PreparedStatement pstmt = getConnection().prepareStatement(BoardConstants.board.getProperty("GBOARD_NEXT_PAGE"));
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean qboardNextPage(int pageNumber) {

		try {
			PreparedStatement pstmt = getConnection().prepareStatement(BoardConstants.board.getProperty("QBOARD_NEXT_PAGE"));
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//검색 
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
		
		PreparedStatement pstmt = getConnection().prepareStatement(SQL);
		rs = pstmt.executeQuery();
		
		GboardDTO gboardDTO = null;
		while (rs.next()) {
			gboardDTO = new GboardDTO();
			gboardDTO.setgPostingID(rs.getInt(1));
			gboardDTO.setMemberID_FK(rs.getString(2));
			gboardDTO.setBoardCategory(rs.getString(3));
			gboardDTO.setImageCategory(rs.getString(4));
			gboardDTO.setTitle(rs.getString(5));
			gboardDTO.setContent(rs.getString(6));
			gboardDTO.setClickCount(rs.getInt("clickCount"));
			gboardDTO.setmDate(rs.getString("mDate"));
			list.add(gboardDTO);
		} 
		return list; 
	}

	public int getNext() {
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(BoardConstants.board.getProperty("GBOARD_GETNEXT"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int qboardGetNext() {
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(BoardConstants.board.getProperty("QBOARD_GETNEXT"));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
