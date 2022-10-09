package lwhat.dao.impl.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lwhat.constants.BoardConstants;
import lwhat.dto.board.GboardDTO;
import lwhat.dto.board.QboardDTO;
import lwhat.util.ConnectionManager;

public class BoardWriteDAOImpl extends AbstractBoardDAOImpl {

	private ResultSet rs;

	// Gboard
	@Override
	public int writeBoard(GboardDTO gboardDTO, String memberID) throws Exception {

		PreparedStatement pstmt = getConnection()
				.prepareStatement(BoardConstants.board.getProperty("GBOARD_WRITE_SQL"));
		pstmt.setString(1, getMemberFK(memberID));
		pstmt.setString(2, gboardDTO.getBoardCategory());
		pstmt.setString(3, gboardDTO.getImageCategory());
		pstmt.setString(4, gboardDTO.getTitle());
		pstmt.setString(5, gboardDTO.getContent());

		pstmt.executeUpdate();

		PreparedStatement pstmt2 = getConnection()
				.prepareStatement(BoardConstants.board.getProperty("GBOARD_IMG_WRITE_GET_POSTINGID"));
		rs = pstmt2.executeQuery();
		int resultId = 0;
		if (rs != null && rs.next()) {
			resultId = rs.getInt("gPostingID");
		}

		ConnectionManager.closeConnection(pstmt, getConnection());

		return resultId;
	}

	// Qboard
	@Override
	public int writeQboard(QboardDTO qboardDTO, String memberID) throws Exception {

		PreparedStatement pstmt = getConnection()
				.prepareStatement(BoardConstants.board.getProperty("QBOARD_WRITE_SQL"));
		pstmt.setString(1, getMemberFK(memberID));
		pstmt.setString(2, qboardDTO.getboardCategory());
		pstmt.setString(3, qboardDTO.getimageCategory());
		pstmt.setString(4, qboardDTO.getTitle());
		pstmt.setString(5, qboardDTO.getContent());

		pstmt.executeUpdate();

		PreparedStatement pstmt2 = getConnection()
				.prepareStatement(BoardConstants.board.getProperty("QBOARD_IMG_WRITE_GET_POSTINGID"));
		rs = pstmt2.executeQuery();
		int resultId = 0;
		if (rs != null && rs.next()) {
			resultId = rs.getInt("qPostingID");
		}
		ConnectionManager.closeConnection(pstmt, getConnection());

		return resultId;
	}

	public String getMemberFK(String memberID) {
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(BoardConstants.board.getProperty("MEMBER_GET"));
			pstmt.setString(1, memberID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

}
