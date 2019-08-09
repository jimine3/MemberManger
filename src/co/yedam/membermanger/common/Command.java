package co.yedam.membermanger.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {  //메소드 원형만 정의
	public void excute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
