package com.xubo.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MySimpleTag extends SimpleTagSupport{
	
	private int num ;
	
	
	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	@Override
	public void doTag() throws JspException, IOException {
		for(int i = 0; i < num; i++) {
			getJspBody().invoke(null);
		}
	}
}
