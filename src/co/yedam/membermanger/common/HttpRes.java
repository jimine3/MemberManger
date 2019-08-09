package co.yedam.membermanger.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpRes { //처리 결과를 도렬주는 클래스
	  public static void forward(HttpServletRequest request, HttpServletResponse response, String viewPage) throws ServletException, IOException {
		   // static : 선언하지 않고 사용 가능
		      RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		      dispatcher.forward(request, response);
		   }
		
}
