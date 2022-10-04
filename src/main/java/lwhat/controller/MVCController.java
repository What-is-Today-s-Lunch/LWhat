package lwhat.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lwhat.handler.CommandHandler;

public class MVCController extends HttpServlet implements Serializable {

	public static final long serialVersionUID = 348234934982349L;

	Map<String, Object> commandMap = null;

	public void init() throws ServletException {
		String commandFile = getInitParameter("commandFile");
		Properties prop = new Properties();
		String commandFilePath = getServletContext().getRealPath(commandFile);
		FileReader fr = null;
		try {
			fr = new FileReader(commandFilePath);
			prop.load(fr);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// @SuppressWarnings()
		Iterator<Object> it = prop.keySet().iterator();

		commandMap = new HashMap<String, Object>();

		while (it.hasNext()) {
			String command = (String) it.next();
			String handlerClassStr = prop.getProperty(command);
			try {
				Class<?> handlerClass = Class.forName(handlerClassStr);
				@SuppressWarnings("deprecation")
				CommandHandler handlerObj = (CommandHandler) handlerClass.newInstance();
				commandMap.put(command, handlerObj);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} // while

	} // int()

	protected void doGet(HttpServletRequest req, HttpServletResponse resp, HttpSession sess) throws ServletException, IOException {
		processRequest(req, resp, sess);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp, HttpSession sess) throws ServletException, IOException {
		processRequest(req, resp, sess);
	}

	public void processRequest(HttpServletRequest req, HttpServletResponse resp, HttpSession sess) throws ServletException, IOException {
		String command = req.getRequestURI();
		if (command.indexOf(req.getContextPath()) == 0) {
			command = command.substring(req.getContextPath().length() + 1);
		}
		CommandHandler handler = (CommandHandler) commandMap.get(command);
		String viewPage = null;
		try {
			viewPage = handler.process(req, resp, sess);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (viewPage != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, resp);
		}
	}
} // class
