package co.yedam.membermanger.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.membermanger.command.BorderList;
import co.yedam.membermanger.command.Indexdo;
import co.yedam.membermanger.command.Login;
import co.yedam.membermanger.command.LoginForm;
import co.yedam.membermanger.command.Logout;
import co.yedam.membermanger.common.Command;

/**
 * Servlet implementation class Fcontroller
 */
@WebServlet("/Fcontroller")
public class Fcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = null;

	public Fcontroller() {
		super();

	}

	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, Command>();
		map.put("/Index.do", new Indexdo());
		map.put("/LoginForm.do", new LoginForm());
		map.put("/Login.do", new Login());
		map.put("/Logout.do", new Logout());
		map.put("/BorderList.do", new BorderList());
		// command 추가
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());

		Command command = map.get(path); //인터페이스 통해 서비스 구현
		command.excute(request, response);
	}

}
