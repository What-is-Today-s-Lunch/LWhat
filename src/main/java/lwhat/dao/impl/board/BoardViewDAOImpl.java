package lwhat.dao.impl.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lwhat.constants.BoardConstants;
import lwhat.dto.board.GboardDTO;
import lwhat.dto.board.QboardDTO;

public class BoardViewDAOImpl extends AbstractBoardDAOImpl {
	private ResultSet rs;

	// Gboard
	@Override
	public GboardDTO viewBoard(int gPostingID) throws Exception {

		try {
			PreparedStatement pstmt = getConnection()
					.prepareStatement(BoardConstants.board.getProperty("GBOARD_VIEW_SQL"));
			pstmt.setInt(1, gPostingID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				GboardDTO gboardDTO = new GboardDTO();
				gboardDTO.setgPostingID(rs.getInt(1));
				gboardDTO.setMemberID_FK(rs.getString(2));
				gboardDTO.setBoardCategory(rs.getString(3));
				gboardDTO.setTitle(rs.getString(4));
				gboardDTO.setContent(rs.getString(5));
				gboardDTO.setmDate(rs.getString("mDate"));
				gboardDTO.setClickCount(rs.getInt(6));
				updateReadCount(gPostingID);

				return gboardDTO;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// Qboard
	@Override
	public QboardDTO viewQboard(int qPostingID) throws Exception {

		try {
			PreparedStatement pstmt = getConnection()
					.prepareStatement(BoardConstants.board.getProperty("QBOARD_VIEW_SQL"));
			pstmt.setInt(1, qPostingID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				QboardDTO qboardDTO = new QboardDTO();
				qboardDTO.setqPostingID(rs.getInt(1));
				qboardDTO.setMemberID_FK(rs.getString(2));
				qboardDTO.setboardCategory(rs.getString(3));
				qboardDTO.setTitle(rs.getString(4));
				qboardDTO.setContent(rs.getString(5));
				qboardDTO.setmDate(rs.getString("mDate"));
				qboardDTO.setClickCount(rs.getInt(8));
				updateReadCountQboard(qPostingID);

				return qboardDTO;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int updateReadCount(int gPostingID) {

		try {
			PreparedStatement pstmt = getConnection()
					.prepareStatement(BoardConstants.board.getProperty("GBOARD_UPDATE_READ_COUNT"));
			pstmt.setInt(1, gPostingID);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int updateReadCountQboard(int qPostingID) {

		try {
			PreparedStatement pstmt = getConnection()
					.prepareStatement(BoardConstants.board.getProperty("QBOARD_UPDATE_READ_COUNT"));
			pstmt.setInt(1, qPostingID);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}
	

}
