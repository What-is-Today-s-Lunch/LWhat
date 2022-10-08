package lwhat.dao.impl.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lwhat.dto.GeneralcommentDTO;
import lwhat.dto.QuestioncommentDTO;

public class BoardConmentListDAOImpl extends AbstractBoardDAOImpl{
	private ResultSet rs;
	//Gboard
	@Override
	public ArrayList<GeneralcommentDTO> conmentListBoard(int pageNumber) throws Exception{
		String SQL = " SELECT * FROM generalcomment WHERE gCommentID < ?  order by gCommentID DESC LIMIT 5 ";
		ArrayList<GeneralcommentDTO> list = new ArrayList<GeneralcommentDTO>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber-1) * 5);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				GeneralcommentDTO generalcommentDTO = new GeneralcommentDTO();
				generalcommentDTO.setgCommentID(rs.getInt(1));
				generalcommentDTO.setMemberID_FK(rs.getString(2));
				generalcommentDTO.setPostingID_FK(rs.getInt(3));
				generalcommentDTO.setBoardCategory(rs.getString(4));
				generalcommentDTO.setContent(rs.getString(5));
				generalcommentDTO.setmDate(rs.getString("mDate"));
				list.add(generalcommentDTO);
				//System.out.println("test " + list);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//Qboard
		@Override
		public ArrayList<QuestioncommentDTO> conmentListQboard(int pageNumber) throws Exception{
			String SQL = " SELECT * FROM questioncomment WHERE qCommentID < ?  order by qCommentID DESC LIMIT 5 ";
			ArrayList<QuestioncommentDTO> list = new ArrayList<QuestioncommentDTO>();
			try {
				PreparedStatement pstmt = getConnection().prepareStatement(SQL);
				pstmt.setInt(1, getNextq() - (pageNumber-1) * 5);
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					QuestioncommentDTO questioncommentDTO = new QuestioncommentDTO();
					questioncommentDTO.setqCommentID(rs.getInt(1));
					questioncommentDTO.setMemberID_FK(rs.getString(2));
					questioncommentDTO.setqPostingID_FK(rs.getInt(3));
					questioncommentDTO.setContent(rs.getString(4));
					questioncommentDTO.setwDate(rs.getString("wDate"));
					list.add(questioncommentDTO);
					//System.out.println("test " + list);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}
	
	
	public int getNext() {
		String sql = " SELECT gCommentID FROM generalcomment ORDER BY gCommentID DESC ";
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
	
	public int getNextq() {
		String sql = " SELECT qCommentID FROM questioncomment ORDER BY qCommentID DESC ";
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
	
	
	public boolean nextPage (int pageNumber) {
		String SQL = " SELECT * FROM generalcomment WHERE gCommentID < ? ";

		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean nextPageq (int pageNumber) {
		String SQL = " SELECT * FROM questioncomment WHERE qCommentID < ? ";

		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
}
