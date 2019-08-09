package co.yedam.membermanger.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.membermanger.common.Command;
import co.yedam.membermanger.common.HttpRes;
import co.yedam.membermanger.dao.MemberDao;
import co.yedam.membermanger.dto.MemberDto;

public class LoginForm implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewPage = "jsp/loginform.jsp";
		HttpRes.forward(request, response, viewPage);

	}

}
