package lwhat.dao.impl.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lwhat.constants.BoardConstants;
import lwhat.dto.board.GeneralcommentDTO;
import lwhat.dto.board.QuestioncommentDTO;
import lwhat.util.ConnectionManager;

public class BoardConmentListDAOImpl extends AbstractBoardDAOImpl {
	private ResultSet rs;

	// Gboard
	@Override
	public ArrayList<GeneralcommentDTO> conmentListBoard(int pageNumber) throws Exception {
		ArrayList<GeneralcommentDTO> list = new ArrayList<GeneralcommentDTO>();
		try {
			PreparedStatement pstmt = getConnection()
					.prepareStatement(BoardConstants.board.getProperty("GBOARD_COMMENT_LIST_SQL"));
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GeneralcommentDTO generalcommentDTO = new GeneralcommentDTO();
				generalcommentDTO.setgCommentID(rs.getInt(1));
				generalcommentDTO.setMemberID_FK(rs.getString(2));
				generalcommentDTO.setPostingID_FK(rs.getInt(3));
				generalcommentDTO.setBoardCategory(rs.getString(4));
				generalcommentDTO.setContent(rs.getString(5));
				generalcommentDTO.setmDate(rs.getString("mDate"));
				list.add(generalcommentDTO);
			}
			ConnectionManager.closeConnection(rs, pstmt, getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// Qboard
	@Override
	public ArrayList<QuestioncommentDTO> conmentListQboard(int pageNumber) throws Exception {
		ArrayList<QuestioncommentDTO> list = new ArrayList<QuestioncommentDTO>();
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement(BoardConstants.board.getProperty("QBOARD_COMMENT_LIST_SQL"));
			pstmt.setInt(1, getNextq() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				QuestioncommentDTO questioncommentDTO = new QuestioncommentDTO();
				questioncommentDTO.setqCommentID(rs.getInt(1));
				questioncommentDTO.setMemberID_FK(rs.getString(2));
				questioncommentDTO.setqPostingID_FK(rs.getInt(3));
				questioncommentDTO.setContent(rs.getString(4));
				questioncommentDTO.setwDate(rs.getString("wDate"));
				list.add(questioncommentDTO);
			}
			ConnectionManager.closeConnection(rs, pstmt, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public int getNext() {
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(BoardConstants.board.getProperty("GBOARD_COMMENT_GETNEXT"));
			rs = pstmt.executeQuery();
			int result = 0;
			if (rs.next()) {
				result = rs.getInt(1) + 1;
				ConnectionManager.closeConnection(rs, pstmt, conn);
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public int getNextq() {
		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(BoardConstants.board.getProperty("QBOARD_COMMENT_GETNEXT"));
			rs = pstmt.executeQuery();
			int result = 0;
			if (rs.next()) {
				result = rs.getInt(1) + 1;
				ConnectionManager.closeConnection(rs, pstmt, conn);
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean nextPage(int pageNumber) {

		try {
			Connection conn = getConnection();

			PreparedStatement pstmt = conn
					.prepareStatement(BoardConstants.board.getProperty("GBOARD_COMMENT_NEXT_PAGE"));
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				ConnectionManager.closeConnection(rs, pstmt, conn);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean nextPageq(int pageNumber) {

		try {
			Connection conn = getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement(BoardConstants.board.getProperty("QBOARD_COMMENT_NEXT_PAGE"));
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				ConnectionManager.closeConnection(rs, pstmt, conn);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
