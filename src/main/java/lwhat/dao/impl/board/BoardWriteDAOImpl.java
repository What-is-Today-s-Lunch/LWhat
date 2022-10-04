package lwhat.dao.impl.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lwhat.dto.board.GboardDTO;
import lwhat.util.ConnectionManager;

public class BoardWriteDAOImpl extends AbstractBoardDAOImpl {
	
	private ResultSet rs;
	
	@Override
	public int writeBoard(GboardDTO gboardDTO) throws Exception {
		Connection conn = getConnection();
		System.out.println(gboardDTO);

		String SQL = " insert into generalposting ( memberID_FK, boardCategory, imageCategory, title, content, wdate, mdate) values ( ?, ?, ?, ?, ?, now(), now()) ";
		PreparedStatement pstmt = conn.prepareStatement(SQL);
//		pstmt.setInt(1, getNext());
		pstmt.setString(1, getMemberFK());
		pstmt.setString(2, gboardDTO.getBoardCategory());
		pstmt.setString(3, gboardDTO.getImageCategory());
		pstmt.setString(4, gboardDTO.getTitle());
		pstmt.setString(5, gboardDTO.getContent());
		
		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt, getConnection());
		return result;
	}
	
	 public String getDate() {	 
		 String sql = " SELECT NOW() ";
		 try {
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if( rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return "";
	 }
	 
	 public int getNext() {	 
		 String sql = " SELECT gPostingID FROM generalposting ORDER BY gPostingID DESC ";
		 try {
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if( rs.next()) {
				return rs.getInt(1)+1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 return -1;
	 }
	 
	 public String getMemberFK() {
		 String sql = " SELECT * FROM memberinfo WHERE memberID= 'test' ";
		 try {
			 PreparedStatement pstmt = getConnection().prepareStatement(sql);
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
