package lwhat.dao.impl.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lwhat.dto.board.GboardDTO;
import lwhat.util.ConnectionManager;

public class BoardFileUploadDAOImpl extends AbstractBoardDAOImpl {
	private ResultSet rs;
	@Override
	public int fileUploadBoard(String cImage, String sImage, int gPostingID) throws Exception {
		String SQL = " INSERT INTO generalimage (gPostingID_FK, imageCategory,cImage, sImage) VALUES (?, ? ,? ,?) ";
		
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
			pstmt.setInt(1, getgPostingID(gPostingID));
			pstmt.setString(2, "testCategory");
			pstmt.setString(3, cImage);
			pstmt.setString(4, sImage);
			int result = pstmt.executeUpdate();
			ConnectionManager.closeConnection(pstmt, getConnection());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int getgPostingID(int gPostingID) {
		 String sql = " SELECT gPostingID FROM generalposting WHERE gPostingID= ? ";
		 try {
	
			 PreparedStatement pstmt = getConnection().prepareStatement(sql);
			 pstmt.setInt(1,gPostingID );
			 rs = pstmt.executeQuery();
			 if(rs.next()) {
				 return rs.getInt(1);
			 }
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 return 0;
	 }

}
