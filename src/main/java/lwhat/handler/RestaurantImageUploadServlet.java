//package lwhat.handler;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//
//import org.apache.commons.lang3.RandomStringUtils;
//
//import com.oreilly.servlet.MultipartRequest;
//import com.oreilly.servlet.MultipartResponse;
//
//import lwhat.constants.LwhatConstants;
//
//public class RestaurantImageUploadServlet extends HttpServlet {
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	doPost(req,resp);
//	}//doGet
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	
//		process(req,resp,"/jsp/restaurantJoinProc.jsp");
//
//	
//	}//doPost
//
//	public void process(MultipartRequest req, MultipartResponse resp , String dispatchURI) {
//		String sqlFileUpload = " update foodimage set  cImage=?, sImage=?, content=? where restaurantID_FK=? ";
//		String sqlFileUploadDir = "C:/eclipse_workspace/LWhat/src/main/webapp/restaurantupload";
//		try {
//			File file1 = req.getFile("file1");
//			File file2 = req.getFile("file2");
//
//	         List<String> sImageList = new ArrayList<String>();
//	         List<String> contentList = new ArrayList<String>();
//	         
//	         for (Part part : parts) {//날짜별 폴더에 저장하겠다는거. 
//	            if (part.getHeader("Content-Disposition").contains("filename=") && part.getSize()>0)  {
//	               File uploadDir = new File(
//	                 sqlFileUploadDir+"/"
//	                     + new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()))+".jpg"
//	               );
//	               if (!uploadDir.exists()) uploadDir.mkdir();//폴더 없으면 하나 생성해줌 
//	               System.out.println("여기는 오니?");
//	               //파일 이름 
//	               String uploadFileName = "";
//	               uploadFileName = uploadDir.getPath() + "/" + RandomStringUtils.random(100, true, true);
//	              
//	               
//	               //리스트에 파일 갯수만큼 더함 
//	               sImageList.add(uploadFileName);
//	               contentList.add(part.getContentType());
//	               
//	               part.write(uploadFileName);
//	               part.delete();
//	            } // outter if
//	         } // for
//	         
//	         req.setAttribute("sImage", sImageList);
//	         req.setAttribute("contentList", contentList);
//	         
//	         RequestDispatcher dispatcher = req.getRequestDispatcher(dispatchURI);
//	         dispatcher.forward(req, resp);   
//	         
//	      } catch (Exception ex) {
//	         ex.printStackTrace();
//	      }
//	   } // process 
//	
//}//class
