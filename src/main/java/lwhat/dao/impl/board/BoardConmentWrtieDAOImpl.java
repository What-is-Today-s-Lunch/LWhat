package lwhat.dao.impl.board;

import java.sql.PreparedStatement;

import lwhat.dto.GeneralcommentDTO;
import lwhat.util.ConnectionManager;

public class BoardConmentWrtieDAOImpl extends AbstractBoardDAOImpl{
	@Override
	public int conmentWriteBoard(GeneralcommentDTO generalcommentDTO ,String memberID,String boardCategory ,int gPostingID) throws Exception{
		String SQL = " INSERT INTO generalcomment (memberID_FK, gPostingID_FK ,boardCategory, content, wDate, mDate) VALUES(?, ? ,?, ?, now(), now()) ";
		
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
			pstmt.setString(1, memberID);
			pstmt.setInt(2, gPostingID);
			pstmt.setString(3, boardCategory);
			pstmt.setString(4, generalcommentDTO.getContent());
			
			int result = pstmt.executeUpdate();
			ConnectionManager.closeConnection(pstmt ,getConnection());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	
}
