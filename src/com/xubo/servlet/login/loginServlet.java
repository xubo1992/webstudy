package com.xubo.servlet.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xubo.util.JDBCUtil;
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String)request.getParameter("username");
		String pwd = (String)request.getParameter("pwd");
		String code = (String)request.getParameter("code");
		String code2 = (String)request.getSession().getAttribute("code");
		int count = -1;
		if(!code.equals(code2)) {
			count = 0;
		}
		Connection con = JDBCUtil.getConnection("mysql");
		String sql = "select * from cap_user where user_id = ? and password = ?";
		try {
			PreparedStatement pstt = con.prepareStatement(sql);
			pstt.setString(1, username);
			pstt.setString(2, pwd);
			ResultSet rs = pstt.executeQuery();
			while(rs.next()) {
				count = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
