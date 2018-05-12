<%@ page language="java" contentType="text/html; charset=GB18030"
	pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>Insert title here</title>
</head>
<body>
	<form action="UploadDownloadServlet?method=upload" method="post"
		enctype="multipart/form-data">
		<input name="headShot" id="headShot" type="file"> <input
			type="submit" value="Ìá½»">
	</form>
	<br /> ÏÂÔØ£º
	<a href="UploadDownloadServlet?method=download">Í¼Æ¬</a>
</body>
</html>