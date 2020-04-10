package com.xubo.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LoginTag extends SimpleTagSupport{
	
	@Override
	public void doTag() throws JspException, IOException {
		PageContext context = (PageContext)getJspContext();
		String uname = (String)context.getSession().getAttribute("uname");
		if(uname != null) {
			getJspBody().invoke(null);
		}
	}
}
