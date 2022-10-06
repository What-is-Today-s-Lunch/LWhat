package lwhat.service.board;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;

import javax.websocket.Encoder.BinaryStream;

import lwhat.dto.GeneralcommentDTO;
import lwhat.dto.board.GboardDTO;

public interface BoardService {
public abstract int writeBoard(GboardDTO gboardDTO, String memberID) throws Exception;
public abstract int deleteBoard(int gPostingID) throws Exception;
public abstract int updateBoard(GboardDTO gboardDTO, String memberID) throws Exception;
public abstract ArrayList<GboardDTO> listBoard(int pageNumber) throws Exception;
public abstract ArrayList<GboardDTO> listBoard(String bdomain, Map<String, String> search) throws Exception;
public abstract GboardDTO viewBoard(int gPostingID) throws Exception;
public abstract int fileUploadBoard(String cImage, String sImage, int gPostingID) throws Exception;
public abstract int fileUploadBoardDB(String cImage, String sImage,FileInputStream content ,int gPostingID) throws Exception;
public abstract int conmentWriteBoard(GeneralcommentDTO generalcommentDTO ,String memberID, String boardCategory, int gPostingID) throws Exception;
public abstract int conmentDeleteBoard(int gCommentID) throws Exception;
public abstract int conmentUpdateBoard(GeneralcommentDTO generalcommentDTO, String memberID_FK) throws Exception;
public abstract ArrayList<GeneralcommentDTO> conmentListBoard(int pageNumber) throws Exception;
public abstract int conmentViewBoard() throws Exception;
}
