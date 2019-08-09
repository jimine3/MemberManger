package co.yedam.membermanger.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.membermanger.common.Command;
import co.yedam.membermanger.common.HttpRes;

public class Logout implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession(true);
			String sname = (String) session.getAttribute("sname"); //기존 세션값을 얻는것
			session.invalidate(); //세션삭제  
			request.setAttribute("sname", sname); //기존의 세션값을 다시 실어보냄
			String viewPage = "jsp/logout.jsp";
			HttpRes.forward(request, response, viewPage);

	}

}
