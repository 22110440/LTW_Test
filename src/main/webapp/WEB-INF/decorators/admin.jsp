<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>Admin - ${requestScope.pageTitle}</title>
	<style>
		body { font-family: Arial, sans-serif; margin: 0; }
		header, footer { background:#222; color:#fff; padding: 12px; }
		nav a { margin-right: 10px; color:#fff; }
		main { padding: 16px; }
	</style>
</head>
<body>
<header>
	<nav>
		<a href="${pageContext.request.contextPath}/">Trang Chủ</a>
		<a href="${pageContext.request.contextPath}/categories">Video</a>
		<a href="${pageContext.request.contextPath}/admin">Trang quản trị</a>
		<a href="${pageContext.request.contextPath}/logout">Đăng xuất</a>
	</nav>
</header>

<main>
	<jsp:include page="${requestScope.view}" />
</main>

<footer>
	<div>Họ tên: Hoàng Thanh Trí | MSSV: 22110440 | Mã đề: 6</div>
</footer>
</body>
</html>


