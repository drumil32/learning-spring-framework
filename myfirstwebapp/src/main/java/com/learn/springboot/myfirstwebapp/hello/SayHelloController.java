package com.learn.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello!how are you?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My first html page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>My first html page</h1>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
//		return "<html>\r\n"
//				+ "	<head>\r\n"
//				+ "		<title>My first html page</title>\r\n"
//				+ "	</head>\r\n"
//				+ "	<body>\r\n"
//				+ "		<h1>My first html page</h1>\r\n"
//				+ "	</body>\r\n"
//				+ "</html>";
	}
}
