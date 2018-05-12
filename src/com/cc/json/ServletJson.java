package com.cc.json;

import java.io.IOException;  
import java.io.OutputStream;  
import java.util.Date;  
  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

public class ServletJson extends HttpServlet{
///哈哈
	  private User buildUserDO(){  
	        User user = new User();  
	        user.setName("王二麻子");  
	        user.setPassword("sdgsgd");  
	        user.setAge(11);  
	        user.setBirthday(new Date());  
	          
	        return user;  
	    }  
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	        response.setContentType("application/json; charset=utf-8");  
	        response.setCharacterEncoding("UTF-8");  
	  
	        String userJson = JSON.toJSONString(buildUserDO());  
	        OutputStream out = response.getOutputStream();  
	        out.write(userJson.getBytes("UTF-8"));  
	        out.flush();  
	    }  
	  
	    
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
	    }  
}
