<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
	<meta charset="UTF-8">
	<title>Trang chủ</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body class="bg-light">

<nav class="navbar navbar-expand-lg navbar-dark bg-primary shadow">
	<div class="container">
		<a class="navbar-brand" href="${pageContext.request.contextPath}/home">
			<i class="bi bi-play-circle-fill"></i> Video Portal
		</a>
		<div class="collapse navbar-collapse">
			<ul class="navbar-nav ms-auto">
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/login">Đăng nhập</a></li>
				<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/register">Đăng ký</a></li>
			</ul>
		</div>
	</div>
</nav>

<header class="bg-primary text-white text-center py-5">
	<div class="container">
		<h1 class="display-4">Chào mừng đến với Video Portal</h1>
		<p class="lead">Khám phá và thưởng thức những video mới nhất</p>
	</div>
</header>

<div class="container py-5">
	<div class="row">
		<c:forEach var="video" items="${videos}">
			<div class="col-md-4 mb-4">
				<div class="card h-100 shadow-sm">
					<img src="${video.poster}" class="card-img-top" alt="${video.title}">
					<div class="card-body">
						<h5 class="card-title">${video.title}</h5>
						<p class="card-text text-truncate">${video.description}</p>
						<a href="${pageContext.request.contextPath}/video/detail?id=${video.videoId}" class="btn btn-primary btn-sm">
							<i class="bi bi-play-fill"></i> Xem ngay
						</a>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

</body>
</html>
