<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>上传图片</title>
</head>
<body>
<s:form action="upload" method="POST"
	enctype="multipart/form-data">
	<s:textfield name="FileNames" label="文件名"/>
	<s:file name="images" label="选择文件"/>
	<s:textfield name="FileNames" label="文件名"/>
	<s:file name="images" label="选择文件"/>
	<s:submit value="上传"/>
</s:form>
</body>
</html>