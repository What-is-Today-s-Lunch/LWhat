package lwhat.dao.impl.board;

import java.sql.PreparedStatement;

import lwhat.constants.BoardConstants;
import lwhat.util.ConnectionManager;

public class BoardConmentDeleteDAOImpl extends AbstractBoardDAOImpl {
	// Gboard
	@Override
	public int conmentDeleteBoard(int gCommentID) throws Exception {
		PreparedStatement pstmt = getConnection()
				.prepareStatement(BoardConstants.board.getProperty("GBOARD_COMMENT_DELETE_SQL"));
		pstmt.setInt(1, gCommentID);

		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt, getConnection());

		return result;
	}

	// Qboard
	@Override
	public int conmentDeleteQboard(int qCommentID) throws Exception {
		PreparedStatement pstmt = getConnection()
				.prepareStatement(BoardConstants.board.getProperty("QBOARD_COMMENT_DELETE_SQL"));
		pstmt.setInt(1, qCommentID);
		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt, getConnection());

		return result;
	}
}
