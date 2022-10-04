package lwhat.dao.impl.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lwhat.dto.board.GboardDTO;
import lwhat.util.ConnectionManager;

public class BoardUpdateDAOImpl extends AbstractBoardDAOImpl {

	private ResultSet rs;
	
	@Override
	public int updateBoard(GboardDTO gboardDTO) throws Exception {
		String SQL = " UPDATE generalposting SET boardCategory=?, title=?, content=?, mDate= now() WHERE gPostingID=?";
		PreparedStatement pstmt = getConnection().prepareStatement(SQL);
		
		pstmt.setString(1, gboardDTO.getBoardCategory());
		pstmt.setString(2, gboardDTO.getTitle());
		pstmt.setString(3, gboardDTO.getContent());
		//pstmt.setString(4, getDate());
		pstmt.setInt(4, gboardDTO.getgPostingID());
		
		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt,getConnection());
		
		return result;
	}
	
	public String getDate() {
		String sql = " SELECT NOW() ";
		 try {
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if( rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

}
