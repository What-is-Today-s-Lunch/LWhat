package lwhat.dao.impl.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lwhat.dto.board.GboardDTO;

public class BoardViewDAOImpl extends AbstractBoardDAOImpl {
	private ResultSet rs;
	@Override
	public GboardDTO viewBoard(int gPosingID) throws Exception {
		
		String SQL = " SELECT * FROM generalposting WHERE gPostingID = ? ";
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
			pstmt.setInt(1, gPosingID);
			rs = pstmt.executeQuery();
			if( rs.next()) {
				GboardDTO gboardDTO = new GboardDTO();
				gboardDTO.setgPostingID(rs.getInt(1));
				gboardDTO.setMemberID_FK(rs.getString(2));
				gboardDTO.setBoardCategory(rs.getString(3));
				gboardDTO.setImageCategory(rs.getString(4));
				gboardDTO.setTitle(rs.getString(5));
				gboardDTO.setContent(rs.getString(6));
				gboardDTO.setmDate(rs.getString("mDate"));
				gboardDTO.setClickCount(rs.getInt(7));
				updateReadCount(gPosingID);
				
				return gboardDTO;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
public int updateReadCount(int gPostingID) {
		
		String SQL = " UPDATE generalposting SET clickCount = clickCount + 1 WHERE gPostingID = ? ";
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
			pstmt.setInt(1, gPostingID);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

}
