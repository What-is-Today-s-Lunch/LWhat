package lwhat.dao.board;

import java.util.ArrayList;

import lwhat.dto.board.GboardDTO;
import lwhat.service.board.BoardService;

public interface BoardDAO extends BoardService{

	@Override
	default int writeBoard(GboardDTO gboardDTO) throws Exception {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	default int deleteBoard(int gPostingID) throws Exception {
		// TODO Auto-generated method stub
		return 0;
		
	}

	@Override
	default int updateBoard(GboardDTO gboardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	default ArrayList<GboardDTO> listBoard(int pageNumber) throws Exception{
		return null;
	}

	@Override
	default GboardDTO viewBoard(int gPostingID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default int fileUploadBoard(String cImage, String sImage, int gPostingID) throws Exception {
		return 0;
		
	}

}
