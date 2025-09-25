<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
	<meta charset="UTF-8">
	<title>${category.categoryName}</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container py-4">
	<h2 class="mb-4">${category.categoryName} (${totalVideos} video)</h2>

	<div class="row">
		<c:forEach var="v" items="${videos}">
			<div class="col-md-4 mb-4">
				<div class="card h-100 shadow-sm">
					<!-- ảnh poster -->
					<img src="${v.poster}" alt="${v.title}"
						 class="card-img-top" style="height:200px; object-fit:cover;">

					<div class="card-body">
						<h5 class="card-title">${v.title}</h5>
						<p class="card-text text-truncate">${v.description}</p>
						<small class="text-muted">${v.views} lượt xem</small>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>

</body>
</html>
