package com.game.spring.mail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.spring.serive.impl.GameServiceImpl;
import com.game.spring.service.GameService;

@WebServlet("/ActiveServlet")
public class ActiveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code=request.getParameter("code");
		GameService GameService=new GameServiceImpl();
		if(GameService.activeUser(code)){
			request.getRequestDispatcher("/welcome.jsp").forward(request, response);
		} else if(GameService.checkUser(code)) {
			request.getRequestDispatcher("/login/get").forward(request, response);
			//response.sendRedirect("http://localhost:8080/Resetpass?username="+code);
		}else{
			request.getRequestDispatcher("/fail.jsp").forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
