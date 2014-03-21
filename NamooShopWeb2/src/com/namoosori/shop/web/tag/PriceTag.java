package com.namoosori.shop.web.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class PriceTag extends SimpleTagSupport{
	
	private Integer value;
	
	public void setValue(Integer value) {
		this.value=value;
	}
	
	StringWriter sw = new StringWriter();

	@Override
	public void doTag() throws JspException, IOException {
		// 
		JspWriter out = getJspContext().getOut();
		StringBuilder builder = new StringBuilder();

		builder.append(String.format("%,d", value));
		out.println(builder.toString());
	}
	
	

}
