package lwhat.dao.impl.board;

import java.sql.PreparedStatement;

import lwhat.constants.BoardConstants;
import lwhat.util.ConnectionManager;

public class BoardDeleteDAOImpl extends AbstractBoardDAOImpl {
	
	//Gboard
	@Override
	public int deleteBoard(int gPostingID) throws Exception {
		PreparedStatement pstmt = getConnection()
				.prepareStatement(BoardConstants.board.getProperty("GBOARD_DELETE_SQL"));

		pstmt.setInt(1, gPostingID);

		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt, getConnection());

		return result;
	}

	//Qboard
	@Override
	public int deleteQboard(int qPostingID) throws Exception {
		PreparedStatement pstmt = getConnection()
				.prepareStatement(BoardConstants.board.getProperty("QBOARD_DELETE_SQL"));

		pstmt.setInt(1, qPostingID);

		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt, getConnection());

		return result;
	}

}
