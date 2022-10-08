package lwhat.dao.impl.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lwhat.dto.QboardDTO;
import lwhat.dto.board.GboardDTO;
import lwhat.util.ConnectionManager;

public class BoardUpdateDAOImpl extends AbstractBoardDAOImpl {

	private ResultSet rs;
	
	@Override
	public int updateBoard(GboardDTO gboardDTO, String memberID) throws Exception {
		String SQL = " UPDATE generalposting SET boardCategory=?, title=?, content=?, mDate= now() WHERE gPostingID=? AND memberID_FK=?";
		PreparedStatement pstmt = getConnection().prepareStatement(SQL);
		
		pstmt.setString(1, gboardDTO.getBoardCategory());
		pstmt.setString(2, gboardDTO.getTitle());
		pstmt.setString(3, gboardDTO.getContent());
		//pstmt.setString(4, getDate());
		pstmt.setInt(4, gboardDTO.getgPostingID());
		pstmt.setString(5, memberID);
		
		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt,getConnection());
		
		return result;
	}
	
	@Override
	public int updateQboard(QboardDTO qboardDTO, String memberID) throws Exception {
		String SQL = " UPDATE questionposting SET boardCategory=?, title=?, content=?, mDate= now() WHERE qPostingID=? AND memberID_FK=?";
		PreparedStatement pstmt = getConnection().prepareStatement(SQL);
		
		pstmt.setString(1, qboardDTO.getboardCategory());
		pstmt.setString(2, qboardDTO.getTitle());
		pstmt.setString(3, qboardDTO.getContent());
		pstmt.setInt(4, qboardDTO.getqPostingID());
		pstmt.setString(5, memberID);
		
		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt,getConnection());
		
		return result;
	}
	

}
