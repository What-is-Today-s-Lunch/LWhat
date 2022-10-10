package lwhat.dao.impl.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lwhat.constants.BoardConstants;
import lwhat.dto.board.GboardDTO;
import lwhat.dto.board.QboardDTO;
import lwhat.util.ConnectionManager;

public class BoardUpdateDAOImpl extends AbstractBoardDAOImpl {

	private ResultSet rs;

	// Gboard
	@Override
	public int updateBoard(GboardDTO gboardDTO, String memberID) throws Exception {
		PreparedStatement pstmt = getConnection()
				.prepareStatement(BoardConstants.board.getProperty("GBOARD_UPDATE_SQL"));

		pstmt.setString(1, gboardDTO.getBoardCategory());
		pstmt.setString(2, gboardDTO.getTitle());
		pstmt.setString(3, gboardDTO.getContent());
		pstmt.setInt(4, gboardDTO.getgPostingID());
		pstmt.setString(5, memberID);

		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt, getConnection());

		return result;
	}

	// Qboard
	@Override
	public int updateQboard(QboardDTO qboardDTO, String memberID) throws Exception {
		PreparedStatement pstmt = getConnection()
				.prepareStatement(BoardConstants.board.getProperty("QBOARD_UPDATE_SQL"));

		pstmt.setString(1, qboardDTO.getboardCategory());
		pstmt.setString(2, qboardDTO.getTitle());
		pstmt.setString(3, qboardDTO.getContent());
		pstmt.setInt(4, qboardDTO.getqPostingID());
		pstmt.setString(5, memberID);

		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt, getConnection());

		return result;
	}

}
