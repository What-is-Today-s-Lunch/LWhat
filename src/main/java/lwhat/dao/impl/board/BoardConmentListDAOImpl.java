package lwhat.dao.impl.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lwhat.dto.GeneralcommentDTO;

public class BoardConmentListDAOImpl extends AbstractBoardDAOImpl{
	private ResultSet rs;
	@Override
	public ArrayList<GeneralcommentDTO> conmentListBoard(int pageNumber) throws Exception{
		String SQL = " SELECT * FROM generalcomment WHERE gCommentID < ? order by gCommentID DESC LIMIT 5 ";
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
	
}
