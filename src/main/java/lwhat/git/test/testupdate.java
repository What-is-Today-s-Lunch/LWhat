package lwhat.git.test;

import lwhat.dao.impl.board.BoardUpdateDAOImpl;
import lwhat.dto.board.GboardDTO;
import lwhat.service.board.BoardService;

public class testupdate {
	public static void main(String[] args) {
		BoardService updateService = new BoardUpdateDAOImpl();
		try {
			GboardDTO gboardDTO = new GboardDTO();
			
			gboardDTO.setBoardCategory("음식");
			gboardDTO.setImageCategory(null);
			gboardDTO.setTitle("11515");
			gboardDTO.setContent("!111515");
//			gboardDTO.setmDate(null);
			gboardDTO.setgPostingID(35);
			
			updateService.updateBoard(gboardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
