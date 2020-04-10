package com.xubo.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagIfDemo extends TagSupport{
	
	private boolean flag;
	
	
	public boolean isFlag() {
		return flag;
	}


	public void setFlag(boolean flag) {
		this.flag = flag;
	}


	@Override
	public int doStartTag() throws JspException {
		return flag?EVAL_BODY_INCLUDE:SKIP_BODY;
	}

}
