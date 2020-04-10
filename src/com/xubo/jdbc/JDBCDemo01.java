package com.xubo.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.xubo.util.JDBCUtil;

public class JDBCDemo01 {
	private static Connection con = JDBCUtil.getConnection("mysql");
	private static PreparedStatement pstmt = null;
	
	public static void main(String[] args) {
//		queryStudent();
//		addStudent();
//		deleteStudent();
//		updateStudent();
		callProcudure();
	}
	// 新增
	public static void addStudent() {
		String sql = "insert into student(ID,NAME,AGE,ADDRESS) values(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,6);
			pstmt.setString(2,"王晴雯");
			pstmt.setInt(3,6);
			pstmt.setString(4,"咸宁");
			int count = pstmt.executeUpdate();
			if(count > 0) {
				System.out.println("新增成功");
			}else {
				System.out.println("新增失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection(con,pstmt,null);
		}
	}
	
	// 删除
	public static void deleteStudent() {
		String sql = "delete from student where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,2);
			int count = pstmt.executeUpdate();
			if(count > 0) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection(con,pstmt,null);
		}
	}
	// 修改
	public static void updateStudent() {
		String sql = "update student set age = ? where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,25);
			pstmt.setInt(2,6);
			int count = pstmt.executeUpdate();
			if(count > 0) {
				System.out.println("修改成功");
			}else {
				System.out.println("修改失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection(con,pstmt,null);
		}
	}
	// 查询
	public static void queryStudent() {
		
		ResultSet rs = null;
		String sql = "select * from student where id = 5";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				String address = rs.getString("address");
				System.out.println(name+","+address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection(con,pstmt,rs);
		}
		
		System.out.println("----------------以上为查询----------------");
	}
	/*
	 * 结果一直是0，不清楚问题出在哪
	 */
	
	public static void callProcudure() {
		CallableStatement cstmt = null;
		String sql = "{call addTwoNum(?,?,?)}";
		try {
			cstmt = con.prepareCall(sql);
			// 设置输入参数
			cstmt.setInt(1, 30);
			cstmt.setInt(2, 40);
			// 设置输出参数
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.execute();
			int result = cstmt.getInt(3);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(cstmt!=null)cstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			JDBCUtil.closeConnection(con, null,null);
		}
	}
}
