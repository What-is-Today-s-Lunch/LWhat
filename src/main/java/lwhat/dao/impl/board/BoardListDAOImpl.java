package lwhat.dao.impl.board;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import lwhat.dto.board.GboardDTO;

public class BoardListDAOImpl extends AbstractBoardDAOImpl{
	private ResultSet rs;

	@Override
	public ArrayList<GboardDTO> listBoard(int pageNumber) throws Exception{
		
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
	// 검색기능
//	@Override
//	   public ArrayList<GboardDTO> listBoard(String searchText, Map<String, String> searchMap) throws Exception{
//	         String prependSQL ="select * from generalposting";
//	         String appendSQL ="order by gPostingID desc";
//	         String whereSQL = "";
//	         
//	         if(searchText!=null) {
//	            if(searchText.equals("")) // 맵의 정보가 비어있는지 여부(비어있으면 true)
//	            {
//	               whereSQL += "where 1=1"; // gPostingID가 없을 경우 
//	            }else {
//	               whereSQL += "where memberID_FK='"+searchText+"'";
//	               //gPostingID가 있을경우
//	            }
//	         }
//	         
//	         if(searchMap!=null && !searchMap.isEmpty()) // true(내용이 있을경우)&&true(텅비어있지 않을 경우)
//	         {
//	            String searchgPostingIDValue = searchMap.get("searchDomain");//내용을 가져옴
//	            String searchTextValue = searchMap.get("title");// 타이틀을 가져옴
//	            whereSQL += " and "+searchgPostingIDValue+"like '%"+searchTextValue+"%' ";
//	         }                     // (내용이 있을경우) and+내용+like %'타이틀'+%
//	         String searchSQL = prependSQL + whereSQL + appendSQL;
//	         // select * from generalposting where memberID_FK= "gPostingID" order by gPostingID desc
//	         return null;
//	      }
//	     // select * from generalposting where memberID_FK= 'searchText'  and 내용 + like % 타이틀 % order by gPostingID desc
//	
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
		@Override
		public ArrayList<GboardDTO> listBoard(String title, String searchText) throws Exception{
			 String sql = "select * from generalposting";
			 String boardTitle = null;
			 System.out.println("-----------------"+title);
			 if (title.equals("title")) {
				boardTitle = " where title ";
			 }
			 else if (title.equals("memberID_FK")) {
				 boardTitle = "where memberID_FK ";
			 }
			 sql+=(boardTitle+"like '%"+searchText+"%' ");
			 System.out.println("-----------쿼리문이요------------"+sql);
			 
			 
			 return null;
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
