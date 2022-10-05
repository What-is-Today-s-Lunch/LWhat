package lwhat.dao.impl.board;

import java.sql.PreparedStatement;

import lwhat.dto.GeneralcommentDTO;
import lwhat.util.ConnectionManager;

public class BoardConmentUpdateDAOImpl extends AbstractBoardDAOImpl{
	@Override
	public int conmentUpdateBoard(GeneralcommentDTO generalcommentDTO, String memberID_FK) throws Exception{
		String SQL = " UPDATE generalcomment SET content=?, mDate= now() WHERE gCommentID=? AND memberID_FK=? ";
		PreparedStatement pstmt = getConnection().prepareStatement(SQL);
		
		pstmt.setString(1, generalcommentDTO.getContent());
		pstmt.setInt(2, generalcommentDTO.getgCommentID());
		pstmt.setString(3, memberID_FK);
		
		int result = pstmt.executeUpdate();
		ConnectionManager.closeConnection(pstmt, getConnection());
		
		return result;
	}
}
