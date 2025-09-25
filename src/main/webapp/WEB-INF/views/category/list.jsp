<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Danh mục</h2>
<ul class="list-group">
	<c:forEach var="citem" items="${categories}">
		<li class="list-group-item d-flex justify-content-between align-items-center">
			<a href="${pageContext.request.contextPath}/video/by-category?code=${citem.categoryCode}"
			   class="text-decoration-none fw-bold">
					${citem.categoryName}
			</a>
			<span class="badge bg-primary rounded-pill">${citem.videoCount}</span>
		</li>
	</c:forEach>
</ul>
