package com.xubo.tag;

import javax.servlet.jsp.tagext.TagSupport;

public class MyTag extends TagSupport{
	private int num;
	public void setNum(int num) {
		this.num = num;
	}
	public int doStartTag() {
		return EVAL_BODY_INCLUDE;
	}
	public int doAfterBody() {
		num--;
		return num>0?EVAL_BODY_AGAIN:EVAL_PAGE;
	}
}
