package lwhat.dao.impl.board;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;

import javax.websocket.Encoder.BinaryStream;

import lwhat.dao.impl.LWhatConnectionDAOImpl;
import lwhat.dto.GeneralcommentDTO;
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
	public int updateBoard(GboardDTO gboardDTO, String memberID) throws Exception {
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
	
	@Override
	public int fileUploadBoardDB(String cImage, String sImage,FileInputStream content ,int gPostingID) throws Exception{
		return 0;
	}
	
	//conment
	@Override
	public int conmentWriteBoard(GeneralcommentDTO generalcommentDTO ,String memberID, String boardCategory,int gPostingID) throws Exception{
		return 0;
	}
	@Override
	public int conmentDeleteBoard(int gCommentID) throws Exception{
		return 0;
	}
	@Override
	public int conmentUpdateBoard(GeneralcommentDTO generalcommentDTO, String memberID_FK) throws Exception{
		return 0;
	}
	@Override
	public ArrayList<GeneralcommentDTO> conmentListBoard(int pageNumber) throws Exception{
		return null;
	}
	@Override
	public int conmentViewBoard() throws Exception{
		return 0;
	}
	


}
