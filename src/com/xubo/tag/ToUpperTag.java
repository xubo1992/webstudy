package com.xubo.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;


public class ToUpperTag extends BodyTagSupport{
	
	@Override
	public int doEndTag() throws JspException {
		String str = getBodyContent().getString().toUpperCase();
		try {
			bodyContent.getEnclosingWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		};
		return super.doEndTag();
	}
}
