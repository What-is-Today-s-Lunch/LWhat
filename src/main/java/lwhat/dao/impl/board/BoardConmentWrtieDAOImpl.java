package lwhat.dao.impl.board;

import java.sql.PreparedStatement;

import lwhat.constants.BoardConstants;
import lwhat.dto.board.GeneralcommentDTO;
import lwhat.dto.board.QuestioncommentDTO;
import lwhat.util.ConnectionManager;

public class BoardConmentWrtieDAOImpl extends AbstractBoardDAOImpl {
	// Gboard
	@Override
	public int conmentWriteBoard(GeneralcommentDTO generalcommentDTO, String memberID, String boardCategory,
			int gPostingID) throws Exception {

		try {
			PreparedStatement pstmt = getConnection()
					.prepareStatement(BoardConstants.board.getProperty("GBOARD_COMMENT_WRITE_SQL"));
			pstmt.setString(1, memberID);
			pstmt.setInt(2, gPostingID);
			pstmt.setString(3, boardCategory);
			pstmt.setString(4, generalcommentDTO.getContent());
			System.out.println(BoardConstants.board.getProperty("GBOARD_COMMENT_WRITE_SQL")+" 아니이거 이그노어 아님??");
			int result = pstmt.executeUpdate();
			ConnectionManager.closeConnection(pstmt, getConnection());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// Qboard
	@Override
	public int conmentWriteQboard(QuestioncommentDTO questioncommentDTO, String memberID, int qPostingID)
			throws Exception {

		try {
			PreparedStatement pstmt = getConnection()
					.prepareStatement(BoardConstants.board.getProperty("QBOARD_COMMENT_WRITE_SQL"));
			pstmt.setString(1, memberID);
			pstmt.setInt(2, qPostingID);
			pstmt.setString(3, questioncommentDTO.getContent());

			int result = pstmt.executeUpdate();
			ConnectionManager.closeConnection(pstmt, getConnection());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
