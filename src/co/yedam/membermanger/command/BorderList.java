package co.yedam.membermanger.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.membermanger.common.Command;
import co.yedam.membermanger.common.HttpRes;
import co.yedam.membermanger.dao.BorderDao;
import co.yedam.membermanger.dto.BorderDto;

public class BorderList implements Command {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BorderDao dao = new BorderDao();
		ArrayList<BorderDto> list = new ArrayList<BorderDto>();
		list = dao.select();
		request.setAttribute("list", list);
		String viewPage = "jsp/borderlist.jsp";
		HttpRes.forward(request, response, viewPage);
		
	}
}
