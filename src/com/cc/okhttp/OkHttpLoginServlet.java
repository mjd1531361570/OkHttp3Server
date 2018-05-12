package com.cc.okhttp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.SetOfIntegerSyntax;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.JSONSerializerMap;


/**
 * Servlet implementation class OkHttpLogin
 */
@WebServlet("/OkHttpLogin")
public class OkHttpLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OkHttpLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//处理客户端的post请求
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer=response.getWriter();
		String userName=request.getParameter("username");
		String userPassword=request.getParameter("password");
		System.out.println(userName);
		System.out.println(userPassword);
		
		if (userName.equals("123")&&userPassword.equals("123")){
			ResultEntity entity=new ResultEntity();
			entity.setResultCode(1);
			entity.setResultMsg("success");
			Map<String, ResultEntity> map=new HashMap<String,ResultEntity>();
			map.put("result", entity);
			String json_value=JSON.toJSONString(map);
			writer.print(json_value);   //表示将数据返回到客户端
			
		} 
		
		
		writer.flush();
		writer.close();
		
	}

}
