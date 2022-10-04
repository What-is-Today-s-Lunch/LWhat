package lwhat.dao.impl.board;

import java.util.ArrayList;
import java.util.Map;

import lwhat.dao.impl.LWhatConnectionDAOImpl;
import lwhat.dto.board.GboardDTO;
import lwhat.service.board.BoardService;

public abstract class AbstractBoardDAOImpl extends LWhatConnectionDAOImpl implements BoardService {

	@Override
	public int writeBoard(GboardDTO gboardDTO, String memberID) throws Exception {
		return 0;	
	}

	@Override
	public int deleteBoard(int gPostingID) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(GboardDTO gboardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ArrayList<GboardDTO> listBoard(int pageNumber) throws Exception{
		return null;
	}
	@Override
	public ArrayList<GboardDTO> listBoard(String bdomain, Map<String, String> search) throws Exception{
		return null;
	}

	@Override
	public GboardDTO viewBoard(int gPostingID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int fileUploadBoard(String cImage, String sImage, int gPostingID) throws Exception {
		return 0;
	}


}
