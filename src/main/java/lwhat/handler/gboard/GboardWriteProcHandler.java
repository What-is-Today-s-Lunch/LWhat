package lwhat.handler.gboard;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import lwhat.dao.impl.board.BoardFileUploadDAOImpl;
import lwhat.dao.impl.board.BoardWriteDAOImpl;
import lwhat.dto.board.GboardDTO;
import lwhat.handler.CommandHandler;
import lwhat.service.board.BoardService;

public class GboardWriteProcHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		
		// session
		HttpSession session = request.getSession();
		String memberID = (String) session.getAttribute("memberID");
		
		GboardDTO gboardDTO = new GboardDTO();
	    gboardDTO.setTitle(request.getParameter("title") == null ? "" : request.getParameter("title"));
	    gboardDTO.setContent(request.getParameter("content") == null ? "" : request.getParameter("content"));
	    gboardDTO.setBoardCategory(request.getParameter("boardCategory") == null ? "" : request.getParameter("boardCategory"));
	    
	    String realFolder = "";
	    String saveFolder = "C:/eclipse_workspace/LWhat/src/main/webapp/jsp/upload";
	    String encType = "UTF-8";
	    int maxSize = 5*1024*1024;

	    MultipartRequest multipartRequest = new MultipartRequest(request, saveFolder, maxSize, encType, new DefaultFileRenamePolicy());

	    String file = multipartRequest.getOriginalFileName("filename");
	    String fileName = multipartRequest.getFilesystemName("filename");
	    
	    //write 변수
	    String title = multipartRequest.getParameter("title");
	    String content = multipartRequest.getParameter("content");
	    String boardCategory = multipartRequest.getParameter("boardCategory");
	    String imageCategory = multipartRequest.getParameter("imageCategory"); 
	    
	    BoardService boardService = new BoardWriteDAOImpl();
	    //GboardDTO gboardDTO = new GboardDTO();
	    gboardDTO.setMemberID_FK(memberID);
	    gboardDTO.setBoardCategory(boardCategory);
	    gboardDTO.setImageCategory(imageCategory);
	    gboardDTO.setTitle(title);
	    gboardDTO.setContent(content);
	    
	    request.setAttribute("boardService", boardService);
	    if(title == null || content == null){
			/*
			 * PrintWriter script = response.getWriter(); script.println("<script>");
			 * script.println("alert('입력이 안 된 사항이 있습니다.')");
			 * script.println("history.back()"); script.println("</script>");
			 */
	    }

	    int gPostingNum = boardService.writeBoard(gboardDTO, memberID); 

	    //int gPostindID = gboardDTO.getgPostingID();
	    BoardService boardService2 = new BoardFileUploadDAOImpl();
	    boardService2.fileUploadBoard(file, fileName, gPostingNum);
	    request.setAttribute("boardService2", boardService2);
	    
	    if (fileName != null){
	    	File oldFile = new File(saveFolder + "\\" + fileName);
	    	File newFile = new File(saveFolder+ "\\" + (gPostingNum) + "file.jpg");
	    	oldFile.renameTo(newFile);
	    } 
	  


		return "/gboardlist.do";
	}

}
