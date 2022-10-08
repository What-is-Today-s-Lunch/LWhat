package lwhat.dao.impl.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lwhat.dto.QboardDTO;
import lwhat.dto.board.GboardDTO;

public class BoardListDAOImpl extends AbstractBoardDAOImpl {
	private ResultSet rs;

	@Override
	public ArrayList<GboardDTO> listBoard(int pageNumber) throws Exception {

		String SQL = " SELECT * FROM generalposting WHERE gPostingID < ? order by gPostingID DESC LIMIT 5 ";
		ArrayList<GboardDTO> list = new ArrayList<GboardDTO>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
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
	//문의게시판 impl
	@Override
	public ArrayList<QboardDTO> listQboard(int pageNumber) throws Exception {

		String SQL = " SELECT * FROM questionposting WHERE qPostingID < ? order by qPostingID DESC LIMIT 5 ";
		ArrayList<QboardDTO> list = new ArrayList<QboardDTO>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
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
		String SQL = " SELECT * FROM generalposting WHERE gPostingID < ? ";

		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
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
		String SQL = " SELECT * FROM questionposting WHERE qPostingID < ? ";

		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
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
	
	

	@Override
	public ArrayList<GboardDTO> listBoard(String title, String searchText) throws Exception {
		ArrayList<GboardDTO> list = new ArrayList<GboardDTO>();
		String SQL = "select * from generalposting";
		String boardTitle = null;
		//System.out.println("-----------------" + title);
		
		if (title.equals("title")) {
			boardTitle = " where title ";
		} else if (title.equals("memberID_FK")) {
			boardTitle = "where memberID_FK ";
		}
		SQL += (boardTitle + "like '%" + searchText + "%' ");
		
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
		}catch (Exception e) {
			
		}

		return null;
	}

	public int getNext() {
		String sql = " SELECT gPostingID FROM generalposting ORDER BY gPostingID DESC ";
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
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
		String sql = " SELECT qPostingID FROM questionposting ORDER BY qPostingID DESC ";
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
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
