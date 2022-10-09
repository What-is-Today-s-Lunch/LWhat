package lwhat.dao.impl.board;

import java.sql.PreparedStatement;

import lwhat.constants.BoardConstants;
import lwhat.dto.board.GeneralcommentDTO;
import lwhat.dto.board.QuestioncommentDTO;
import lwhat.util.ConnectionManager;

public class BoardConmentUpdateDAOImpl extends AbstractBoardDAOImpl {
	// Gboard
	@Override
	public int conmentUpdateBoard(GeneralcommentDTO generalcommentDTO, String memberID_FK) throws Exception {
		PreparedStatement pstmt = getConnection()
				.prepareStatement(BoardConstants.board.getProperty("GBOARD_COMMENT_UPDATE_SQL"));

		pstmt.setString(1, generalcommentDTO.getContent());
		pstmt.setInt(2, generalcommentDTO.getgCommentID());
		pstmt.setString(3, memberID_FK);

		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt, getConnection());

		return result;
	}

	// Qboard
	@Override
	public int conmentUpdateQboard(QuestioncommentDTO questioncommentDTO, String memberID_FK) throws Exception {
		PreparedStatement pstmt = getConnection()
				.prepareStatement(BoardConstants.board.getProperty("QBOARD_COMMENT_UPDATE_SQL"));

		pstmt.setString(1, questioncommentDTO.getContent());
		pstmt.setInt(2, questioncommentDTO.getqCommentID());
		pstmt.setString(3, memberID_FK);

		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt, getConnection());

		return result;
	}
}
