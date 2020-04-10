package com.xubo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = (String)request.getParameter("uname");
		String upwd = (String)request.getParameter("upwd");
		if("zs".equals(uname)&&"123".equals(upwd)) {
			request.getSession().setAttribute("uname", uname);
			request.getRequestDispatcher("/jsp/tagDemo/show.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/jsp/tagDemo/error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
