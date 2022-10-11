package lwhat.dao.impl.board;

import java.sql.Connection;
import java.sql.DriverManager;
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
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstants.board.getProperty("GBOARD_WRITE_SQL"));
		Connection conn2 = getConnection();
		try {
			conn.setAutoCommit(false);
			pstmt.setString(1, getMemberFK(memberID));
			pstmt.setString(2, gboardDTO.getBoardCategory());
			pstmt.setString(3, gboardDTO.getTitle());
			pstmt.setString(4, gboardDTO.getContent());

			pstmt.executeUpdate();
			
			PreparedStatement pstmt2 = conn2
					.prepareStatement(BoardConstants.board.getProperty("GBOARD_IMG_WRITE_GET_POSTINGID"));
			rs = pstmt2.executeQuery();

			int resultId = 0;
			if (rs != null && rs.next()) {
				resultId = rs.getInt("gPostingID");
				conn.commit();
				closeConnection(pstmt, conn);
				closeConnection(rs, pstmt2, conn2);
				return resultId;
			}
			
		} catch (Exception sqle) {
			sqle.printStackTrace();
			conn.rollback();
		}


		ConnectionManager.closeConnection(rs,pstmt, conn);
		return 0;
	}

	// Qboard
	@Override
	public int writeQboard(QboardDTO qboardDTO, String memberID) throws Exception {
		Connection conn = getConnection();
		Connection conn2 = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(BoardConstants.board.getProperty("QBOARD_WRITE_SQL"));
		
		try {
			conn.setAutoCommit(false);
			pstmt.setString(1, getMemberFK(memberID));
			pstmt.setString(2, qboardDTO.getboardCategory());
			pstmt.setString(3, qboardDTO.getTitle());
			pstmt.setString(4, qboardDTO.getContent());

			pstmt.executeUpdate();

			PreparedStatement pstmt2 = conn
					.prepareStatement(BoardConstants.board.getProperty("QBOARD_IMG_WRITE_GET_POSTINGID"));
			rs = pstmt2.executeQuery();
			
			int resultId = 0;
			if (rs != null && rs.next()) {
				resultId = rs.getInt("qPostingID");
				conn.commit();
				closeConnection(pstmt, conn);
				closeConnection(rs, pstmt2, conn2);
				return resultId;
			}
			
		} catch (Exception sqle) {
			sqle.printStackTrace();
			conn.rollback();
		}
	
		ConnectionManager.closeConnection(pstmt, getConnection());

		return 0;
	}
	
	public String getMemberFK(String memberID) {
		Connection conn = getConnection();
		String member = "";
		try {
			PreparedStatement pstmt = conn.prepareStatement(BoardConstants.board.getProperty("MEMBER_GET"));
			pstmt.setString(1, memberID);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				member = rs.getString(1);
				ConnectionManager.closeConnection(rs, pstmt, conn);
				return member;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "";
	}

}
