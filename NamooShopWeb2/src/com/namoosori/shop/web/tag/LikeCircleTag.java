package com.namoosori.shop.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class LikeCircleTag extends SimpleTagSupport{

	private Integer count;
	
	public void setCount(Integer count) {
		this.count=count;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		// 
		JspWriter out = getJspContext().getOut();
		StringBuilder builder = new StringBuilder(5);
		for(int i=0; i<5; i++) {
			builder.append((i<count) ? "●" : "○");
		}
		out.println(builder.toString());
	}
	
	

}
