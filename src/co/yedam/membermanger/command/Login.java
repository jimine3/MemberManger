package co.yedam.membermanger.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import co.yedam.membermanger.common.Command;
import co.yedam.membermanger.common.HttpRes;
import co.yedam.membermanger.dao.MemberDao;
import co.yedam.membermanger.dto.MemberDto;

public class Login implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDao dao = new MemberDao();
		MemberDto dto = new MemberDto();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		dto = dao.login(id, pw);
		
		HttpSession session = request.getSession(true);
		session.setAttribute("sid", dto.getmId());
		session.setAttribute("sname", dto.getmName());
		session.setAttribute("sgrant", dto.getmGrant());
		String viewPage = "jsp/loginOk.jsp";
		HttpRes.forward(request, response, viewPage);
	}	
}