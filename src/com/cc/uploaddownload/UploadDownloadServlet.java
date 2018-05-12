package com.cc.uploaddownload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class UploadDownloadServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = req.getParameter("method");
		if (method.equals("download")) {
			this.download(req,resp);
		}
		if (method.equals("upload")) {
			this.upload(req, resp);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}

	private void upload(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("text/html;charset=UTF-8");
		// 获取上传文件域
		Part part = request.getPart("headShot");
		// 获取上传文件名称
		String fileName = part.getSubmittedFileName();
		// 为防止上传文件重名，对文件重新命名
		String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		// 将上传的文件保存在服务器发布路径的application/images路径下
		// String filePath =
		// getServletContext().getRealPath("/application/images");
		String filePath = "D:/application/files";
		System.out.println(filePath);
		File f = new File(filePath);
		if (!f.exists()) {
			f.mkdirs();
		}
		part.write(filePath + "/" + newFileName);
		RequestDispatcher dispatcher = request.getRequestDispatcher("updown.jsp");
		dispatcher.forward(request, response);

	}

	private void download(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		//得到工程的绝对路径  http://localhost:8080/UpDown
//		String path = request.getServletContext().getRealPath("/")+"images\\";
//		String path1 = request.getServletContext().getContextPath();
//		String path2 = request.getServletPath();
//		String path3 = request.getRequestURI();
//		System.out.println(path);
//		System.out.println("2:"+path1);
//		System.out.println("3:"+path2);
//		System.out.println("4:"+path3);
		
		String filename = "file.png";
		File file = new File("D:\\application\\files\\1.png");
		if (file.exists()) {
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition", "attachment;filename=\"" + filename + "\"");
			InputStream inputStream = new FileInputStream(file);
			OutputStream outputStream = response.getOutputStream();
			byte[] b = new byte[1024]; 
			int n ;
			while((n = inputStream.read(b))!=-1){
				outputStream.write(b, 0, n);
			}
			outputStream.close();
			inputStream.close();
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("updown.jsp");
			dispatcher.forward(request, response);
		}
	}

}
