package lwhat.dao.impl.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lwhat.dto.board.GboardDTO;
import lwhat.dto.board.QboardDTO;
import lwhat.util.ConnectionManager;

public class BoardWriteDAOImpl extends AbstractBoardDAOImpl {
	
	private ResultSet rs;
	
	// Gboard
	@Override
	public int writeBoard(GboardDTO gboardDTO, String memberID) throws Exception {
		Connection conn = getConnection();
		//System.out.println(gboardDTO);

		String SQL = " insert into generalposting ( memberID_FK, boardCategory, imageCategory, title, content, wdate, mdate) values ( ?, ?, ?, ?, ?, now(), now()) ";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
//		pstmt.setInt(1, getNext());
		pstmt.setString(1, getMemberFK(memberID));
		pstmt.setString(2, gboardDTO.getBoardCategory());
		pstmt.setString(3, gboardDTO.getImageCategory());
		pstmt.setString(4, gboardDTO.getTitle());
		pstmt.setString(5, gboardDTO.getContent());
		
		pstmt.executeUpdate();
		
		String SQLIMG = " SELECT gPostingID FROM generalposting ORDER BY gPostingID DESC LIMIT 1 ";
		PreparedStatement pstmt2 = getConnection().prepareStatement(SQLIMG);
		rs = pstmt2.executeQuery();
		int resultId = 0;
		if (rs!=null && rs.next()) {
			resultId = rs.getInt("gPostingID");
		}
		
		ConnectionManager.closeConnection(pstmt, getConnection());
		
		return resultId;
	}
	
	// Qboard
		@Override
		public int writeQboard(QboardDTO qboardDTO, String memberID) throws Exception {
			Connection conn = getConnection();
			//System.out.println(qboardDTO);

			String SQLIMG = " insert into questionposting ( memberID_FK, boardCategory, imageCategory, title, content, wdate, mdate) values ( ?, ?, ?, ?, ?, now(), now()) ";
			PreparedStatement pstmt = conn.prepareStatement(SQLIMG);
//			pstmt.setInt(1, getNext());
			pstmt.setString(1, getMemberFK(memberID));
			pstmt.setString(2, qboardDTO.getboardCategory());
			pstmt.setString(3, qboardDTO.getimageCategory());
			pstmt.setString(4, qboardDTO.getTitle());
			pstmt.setString(5, qboardDTO.getContent());
			
			//recent id select sql
			pstmt.executeUpdate();
			
			String SQL2 = " SELECT qPostingID FROM questionposting ORDER BY qPostingID DESC LIMIT 1 ";
			PreparedStatement pstmt2 = getConnection().prepareStatement(SQL2);
			rs = pstmt2.executeQuery();
			int resultId = 0;
			if (rs!=null && rs.next()) {
				resultId = rs.getInt("qPostingID");
			}
			ConnectionManager.closeConnection(pstmt, getConnection());
			
			return resultId;
		}

	 
	 public String getMemberFK(String memberID) {
		 String sql = " SELECT * FROM memberinfo WHERE memberID= ? ";
		 try {
			 PreparedStatement pstmt = getConnection().prepareStatement(sql);
			 pstmt.setString(1, memberID);
			 rs = pstmt.executeQuery();
			 if(rs.next()) {
				 return rs.getString(1);
			 }
		 } catch (SQLException e) {
			e.printStackTrace();
		}
		 return "";
	 }



}
