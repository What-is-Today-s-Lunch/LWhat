package lwhat.dao.impl.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lwhat.dto.QboardDTO;
import lwhat.dto.board.GboardDTO;

public class BoardViewDAOImpl extends AbstractBoardDAOImpl {
	private ResultSet rs;

	// Gboard
	@Override
	public GboardDTO viewBoard(int gPostingID) throws Exception {

		String SQL = " SELECT * FROM generalposting WHERE gPostingID = ? ";
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
			pstmt.setInt(1, gPostingID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				GboardDTO gboardDTO = new GboardDTO();
				gboardDTO.setgPostingID(rs.getInt(1));
				gboardDTO.setMemberID_FK(rs.getString(2));
				gboardDTO.setBoardCategory(rs.getString(3));
				gboardDTO.setImageCategory(rs.getString(4));
				gboardDTO.setTitle(rs.getString(5));
				gboardDTO.setContent(rs.getString(6));
				gboardDTO.setmDate(rs.getString("mDate"));
				gboardDTO.setClickCount(rs.getInt(7));
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

		String SQL = " SELECT * FROM questionposting WHERE qPostingID = ? ";
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
			pstmt.setInt(1, qPostingID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				QboardDTO qboardDTO = new QboardDTO();
				qboardDTO.setqPostingID(rs.getInt(1));
				qboardDTO.setMemberID_FK(rs.getString(2));
				qboardDTO.setboardCategory(rs.getString(3));
				qboardDTO.setimageCategory(rs.getString(4));
				qboardDTO.setTitle(rs.getString(5));
				qboardDTO.setContent(rs.getString(6));
				qboardDTO.setmDate(rs.getString("mDate"));
				qboardDTO.setClickCount(rs.getInt(9));
				updateReadCountQboard(qPostingID);

				return qboardDTO;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public int updateReadCount(int gPostingID) {

		String SQL = " UPDATE generalposting SET clickCount = clickCount + 1 WHERE gPostingID = ? ";
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
			pstmt.setInt(1, gPostingID);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

	public int updateReadCountQboard(int qPostingID) {

		String SQL = " UPDATE questionposting SET clickCount = clickCount + 1 WHERE qPostingID = ? ";
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
			pstmt.setInt(1, qPostingID);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return -1;
	}

}
