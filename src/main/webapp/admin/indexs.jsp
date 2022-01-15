<!DOCTYPE html>
<html>
<head>
<title>JSP-Servlet Upload file</title>
</head>
<body>
	<h2>Demo JSP-Servlet Upload File</h2>

	<form method="post" action="${pageContext.request.contextPath}/admin/uploadfile" enctype="multipart/form-data">

		Select file to upload: <input type="file" name="file" size="60" /><br /><br /> 
		<input type="submit" value="Upload" />
	</form>

</body>
</html>