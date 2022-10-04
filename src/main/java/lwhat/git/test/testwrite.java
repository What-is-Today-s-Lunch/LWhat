package lwhat.git.test;

import lwhat.dao.impl.board.BoardWriteDAOImpl;
import lwhat.dto.board.GboardDTO;
import lwhat.service.board.BoardService;

public class testwrite {
	public static void main(String[] args) {
		BoardService boardService = new BoardWriteDAOImpl();
		GboardDTO gboardDTO = new GboardDTO();
		
		//gboardDTO.setgPostingID(11);
		//gboardDTO.setMemberID_FK("111");
		gboardDTO.setTitle("test1");
		gboardDTO.setContent("test1");
		//gboardDTO.setmDate(null);
		
		try {
			boardService.writeBoard(gboardDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
