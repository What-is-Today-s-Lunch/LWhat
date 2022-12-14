package lwhat.dao.impl.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lwhat.constants.BoardConstants;
import lwhat.util.ConnectionManager;

public class BoardFileUploadDAOImpl extends AbstractBoardDAOImpl {
	private ResultSet rs;
	
	//Gboard
	@Override
	public int fileUploadBoard(String cImage, String sImage, int gPostingID) throws Exception {
		Connection conn = getConnection();
		int result=0;
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(BoardConstants.board.getProperty("GBOARD_FILE_SQL"));
			pstmt.setInt(1, getgPostingID(gPostingID));
			pstmt.setString(2, getBoardCategory(gPostingID));
			pstmt.setString(3, cImage);
			pstmt.setString(4, sImage);
			result = pstmt.executeUpdate();
			
			ConnectionManager.closeConnection(pstmt, conn);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	//Qboard
		@Override
		public int fileUploadQBoard(String cImage, String sImage, int qPostingID) throws Exception {
			int result = 0;
			try {
				PreparedStatement pstmt = getConnection().prepareStatement(BoardConstants.board.getProperty("QBOARD_FILE_SQL"));
				pstmt.setInt(1, getqPostingID(qPostingID));
				pstmt.setString(2, getQboardCategory(qPostingID));
				pstmt.setString(3, cImage);
				pstmt.setString(4, sImage);
				result = pstmt.executeUpdate();
				
				ConnectionManager.closeConnection(pstmt, getConnection());
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return -1;
		}
	
	
	
	public int getgPostingID(int gPostingID) {
		 try {
			 Connection conn = getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(BoardConstants.board.getProperty("GBOARD_GET_POSTINGID"));
			 pstmt.setInt(1,gPostingID );
			 rs = pstmt.executeQuery();
			 int result = 0;
			 if(rs.next()) {
				 result = rs.getInt(1);
				 ConnectionManager.closeConnection(rs, pstmt, conn);
				 return result;
			 }
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 return 0;
	 }

	public int getqPostingID(int qPostingID) {
		 try {
			 Connection conn = getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(BoardConstants.board.getProperty("QBOARD_GET_POSTINGID"));
			 pstmt.setInt(1,qPostingID );
			 rs = pstmt.executeQuery();
			 int result = 0;
			 if(rs.next()) {
				 result = rs.getInt(1);
				 ConnectionManager.closeConnection(rs, pstmt, conn);
				 return result;
			 }
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 return 0;
	 }
	
	public String getBoardCategory(int gPostingID) throws Exception {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstants.board.getProperty("GBOARD_IMG_WRITE_GET_BOARDCATEGORY"));
		pstmt.setInt(1, gPostingID);
		rs = pstmt.executeQuery();
		String result = "";
		if(rs.next()) {
			result = rs.getString(1);
			ConnectionManager.closeConnection(rs, pstmt, conn);
			return result;
		}
		return "";
	}
	
	public String getQboardCategory(int qPostingID) throws Exception {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstants.board.getProperty("QBOARD_IMG_WRITE_GET_BOARDCATEGORY"));
		pstmt.setInt(1, qPostingID);
		rs = pstmt.executeQuery();
		String result = "";
		if(rs.next()) {
			result = rs.getString(1);
			ConnectionManager.closeConnection(rs, pstmt, conn);
			return result;
		}
		return "";
	}
	
}
