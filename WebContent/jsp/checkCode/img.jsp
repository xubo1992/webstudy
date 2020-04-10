<%@page import="java.awt.Font"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.awt.Graphics"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="java.util.Random"%>
<%@page import="java.awt.Color"%>
<%@ page language="java" contentType="image/jpeg; charset=UTF-8"  pageEncoding="UTF-8"%>
<%!
	// 随机产生颜色值
	public Color getColor(){
		Random ran = new Random();
		int r = ran.nextInt(256);
		int g = ran.nextInt(256);
		int b = ran.nextInt(256);
		return new Color(r,g,b);
	}

	// 获取四位随机数当成验证码
	public String getCode(){
		int code = (int)(Math.random() * 9000) + 1000;
		return String.valueOf(code);
	}
%>
<%
	// 禁止缓存
	response.setHeader("Pragma","No-cache");  
	response.setHeader("Cache-Control","no-cache");  
	response.setDateHeader("Expires", 0);
	// 绘制验证码
	BufferedImage image = new BufferedImage(100,30,BufferedImage.TYPE_INT_RGB);
	// 画笔
	Graphics gs = image.getGraphics();
	gs.fillRect(0, 0, 100,30);
	// 在矩形中绘制多条线
	Random ran = new Random();
	for(int i = 0 ; i < 60 ; i++){
		int xBegin = ran.nextInt(100);
		int yBegin = ran.nextInt(30);
		int xEnd = ran.nextInt(xBegin+10);
		int yEnd = ran.nextInt(yBegin+10);
		gs.setColor(getColor());
		gs.drawLine(xBegin, yBegin, xEnd, yEnd);
	}
	StringBuffer sb = new StringBuffer();
	String code = getCode();
	for(int i = 0 ; i < code.length(); i++){
		sb.append(code.charAt(i) + " ");
	}
	// 绘制验证码
	gs.setColor(Color.BLACK);
	gs.setFont(new Font("宋体",Font.BOLD,20));
	gs.drawString(sb.toString(), 20, 20);
	image.flush();
	// 
	session.setAttribute("code", code);
	ImageIO.write(image, "jpeg", response.getOutputStream());
	out.clear();
	out = pageContext.pushBody();
%>