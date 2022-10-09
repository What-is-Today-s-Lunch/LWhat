package lwhat.handler.qboard;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import lwhat.dao.impl.board.BoardFileUploadDAOImpl;
import lwhat.dao.impl.board.BoardWriteDAOImpl;
import lwhat.dto.board.QboardDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class QboardWriteBoardProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
request.setCharacterEncoding("UTF-8");
		
		// session
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");
		
		QboardDTO qboardDTO = new QboardDTO();
		qboardDTO.setTitle(request.getParameter("title") == null ? "" : request.getParameter("title"));
		qboardDTO.setContent(request.getParameter("content") == null ? "" : request.getParameter("content"));
		qboardDTO.setboardCategory(request.getParameter("boardCategory") == null ? "" : request.getParameter("boardCategory"));
	    
	    String realFolder = "";
	    String saveFolder = "C:/eclipse_workspace/LWhat/src/main/webapp/jsp/qupload";
	    String encType = "UTF-8";
	    int maxSize = 5*1024*1024;

	    MultipartRequest multipartRequest = new MultipartRequest(request, saveFolder, maxSize, encType, new DefaultFileRenamePolicy());

	    String file = multipartRequest.getOriginalFileName("filename");
	    String fileName = multipartRequest.getFilesystemName("filename");
	    
	    String files = multipartRequest.getOriginalFileName("filenames");
	    String fileNames = multipartRequest.getFilesystemName("filenames");
	    
	    //write 변수
	    String title = multipartRequest.getParameter("title");
	    String content = multipartRequest.getParameter("content");
	    String boardCategory = multipartRequest.getParameter("boardCategory");
	    String imageCategory = multipartRequest.getParameter("imageCategory"); 
	    
	    BoardService boardService = new BoardWriteDAOImpl();
	    //GboardDTO gboardDTO = new GboardDTO();
	    qboardDTO.setMemberID_FK(memberID);
	    qboardDTO.setboardCategory(boardCategory);
	    qboardDTO.setimageCategory(imageCategory);
	    qboardDTO.setTitle(title);
	    qboardDTO.setContent(content);
	    
	    request.setAttribute("boardService", boardService);
	    if(title == null || content == null){
			/*
			 * PrintWriter script = response.getWriter(); script.println("<script>");
			 * script.println("alert('입력이 안 된 사항이 있습니다.')");
			 * script.println("history.back()"); script.println("</script>");
			 */
	    }

	    int qPostingNum = boardService.writeQboard(qboardDTO, memberID); 

	    //int gPostindID = gboardDTO.getgPostingID();
	    BoardService boardFileService = new BoardFileUploadDAOImpl();
	    boardFileService.fileUploadQBoard(file, fileName, qPostingNum);
	    boardFileService.fileUploadQBoard(files, fileNames, qPostingNum);
	    request.setAttribute("boardFileService", boardFileService);
	    
	    if (fileName != null){
	    	File oldFile = new File(saveFolder + "\\" + fileName);
	    	File newFile = new File(saveFolder+ "\\" + (qPostingNum) + "file.jpg");
	    	oldFile.renameTo(newFile);
	    } 
	    
	    if (fileNames != null){
	    	File oldFiles = new File(saveFolder + "\\" + fileNames);
	    	File newFiles = new File(saveFolder+ "\\" + (qPostingNum) + "files.jpg");
	    	oldFiles.renameTo(newFiles);
	    } 
		
		
		
		return "/qboardlist.do";
	}

}
