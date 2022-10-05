package lwhat.dao.impl.board;

import java.sql.PreparedStatement;

import lwhat.util.ConnectionManager;

public class BoardConmentDeleteDAOImpl extends AbstractBoardDAOImpl {
	@Override
	public int conmentDeleteBoard(int gCommentID) throws Exception{
		String SQL = " DELETE FROM generalcomment where gCommentID=? ";
		PreparedStatement pstmt = getConnection().prepareStatement(SQL);
		pstmt.setInt(1, gCommentID);
		
		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt, getConnection());
		
		
		return result;
	}
}
