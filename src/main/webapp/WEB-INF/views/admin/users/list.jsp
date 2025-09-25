<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<h2>Danh sách Users</h2>
<a href="${pageContext.request.contextPath}/admin/users/create">+ Thêm mới</a>
<table border="1" cellspacing="0" cellpadding="6">
	<tr>
		<th>Username</th>
		<th>Fullname</th>
		<th>Email</th>
		<th>Phone</th>
		<th>Admin</th>
		<th>Active</th>
		<th>Action</th>
	</tr>
	<c:forEach var="u" items="${users}">
		<tr>
			<td>${u.username}</td>
			<td>${u.fullName}</td>
			<td>${u.email}</td>
			<td>${u.phone}</td>
			<td>${u.admin}</td>
			<td>${u.active}</td>
			<td>
				<a href="${pageContext.request.contextPath}/admin/users/edit?username=${u.username}">Sửa</a>
				|
				<a href="${pageContext.request.contextPath}/admin/users/delete?username=${u.username}" onclick="return confirm('Xóa user này?')">Xóa</a>
			</td>
		</tr>
	</c:forEach>
</table>

<div style="margin-top:10px;">
	<c:forEach begin="0" end="${totalPages-1}" var="i">
		<c:choose>
			<c:when test="${i == page}">
				<strong>[${i+1}]</strong>
			</c:when>
			<c:otherwise>
				<a href="${pageContext.request.contextPath}/admin/users?page=${i}">[${i+1}]</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>


