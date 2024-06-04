<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File</title>
</head>
<body>
	<h1>File</h1>
	<form action="/file-upload" method="POST" enctype="multipart/form-data">
		<input type="file" name="file"><br />
		<input type="submit" value="업로드">
	</form>
	<hr />
	<a href="" >File Download</a>
</body>
</html>