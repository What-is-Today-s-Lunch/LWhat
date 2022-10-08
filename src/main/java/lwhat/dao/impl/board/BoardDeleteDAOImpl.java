package lwhat.dao.impl.board;

import java.sql.PreparedStatement;

import lwhat.dao.impl.LWhatConnectionDAOImpl;
import lwhat.util.ConnectionManager;

public class BoardDeleteDAOImpl extends AbstractBoardDAOImpl {

	@Override
	public int deleteBoard(int gPostingID) throws Exception {
		PreparedStatement pstmt 
		= getConnection().prepareStatement(" delete from generalposting where gPostingID=? ");
		
		pstmt.setInt(1, gPostingID);
		
		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt, getConnection());
		
		return result;
	}
	
	@Override
	public int deleteQboard(int qPostingID) throws Exception {
		PreparedStatement pstmt 
		= getConnection().prepareStatement(" delete from questionposting where qPostingID=? ");
		
		pstmt.setInt(1, qPostingID);
		
		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt, getConnection());
		
		return result;
	}

}
