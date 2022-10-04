package lwhat.service.board;

import java.util.ArrayList;
import java.util.Map;

import lwhat.dto.board.GboardDTO;

public interface BoardService {
public abstract int writeBoard(GboardDTO gboardDTO) throws Exception;
public abstract int deleteBoard(int gPostingID) throws Exception;
public abstract int updateBoard(GboardDTO gboardDTO) throws Exception;
public abstract ArrayList<GboardDTO> listBoard(int pageNumber) throws Exception;
public abstract ArrayList<GboardDTO> listBoard(String bdomain, Map<String, String> search) throws Exception;
public abstract GboardDTO viewBoard(int gPostingID) throws Exception;
public abstract int fileUploadBoard(String cImage, String sImage, int gPostingID) throws Exception;

}
