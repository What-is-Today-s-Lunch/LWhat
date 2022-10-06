package lwhat.dao.impl.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lwhat.constants.LwhatConstants;
import lwhat.dto.board.GboardDTO;

public class BoardListDAOImpl extends AbstractBoardDAOImpl {
	private ResultSet rs;

	@Override
	public ArrayList<GboardDTO> listBoard(int pageNumber) throws Exception {
		
		String SQL = " SELECT * FROM generalposting WHERE gPostingID < ? order by gPostingID DESC LIMIT 5 ";
		ArrayList<GboardDTO> list = new ArrayList<GboardDTO>();
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				GboardDTO gboardDTO = new GboardDTO();
				gboardDTO.setgPostingID(rs.getInt(1));
				gboardDTO.setMemberID_FK(rs.getString(2));
				gboardDTO.setBoardCategory(rs.getString(3));
				gboardDTO.setImageCategory(rs.getString(4));
				gboardDTO.setTitle(rs.getString(5));
				gboardDTO.setContent(rs.getString(6));
				gboardDTO.setClickCount(rs.getInt("clickCount"));
				gboardDTO.setmDate(rs.getString("mDate"));
				list.add(gboardDTO);
				System.out.println(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public ArrayList<GboardDTO> listBoard(String gPostingID, Map<String, String> search) throws Exception{
	      String prependSQL = LwhatConstants.querys.getProperty(" select * from generalposting ");
	      String appendSQL = LwhatConstants.querys.getProperty(" order by gPostingID desc ");
	      String whereSQL = "";
	      
	      if(gPostingID!=null) {
	         if(gPostingID.equals("")) {
	            whereSQL += " where 1=1 ";
	         }else {
	            whereSQL += " where memberID_FK='"+gPostingID+"' ";
	         }
	      }
	      
	      if(search!=null && !search.isEmpty()) {
	         String searchgPostingIDValue = search.get("searchDomain");
	         String searchTextValue = search.get("title");
	         whereSQL += " and "+searchgPostingIDValue+"like '%"+searchTextValue+"%' ";
	      }
	      
	      String searchSQL = prependSQL + whereSQL + appendSQL;
	      return null;
	      
	   }
	
	public boolean nextPage (int pageNumber) {
		String SQL = " SELECT * FROM generalposting WHERE gPostingID < ? ";

		try {
			PreparedStatement pstmt = getConnection().prepareStatement(SQL);
			pstmt.setInt(1, getNext() - (pageNumber - 1) * 5);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	

	public int getNext() {
		String sql = " SELECT gPostingID FROM generalposting ORDER BY gPostingID DESC ";
		try {
			PreparedStatement pstmt = getConnection().prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
}
