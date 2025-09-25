<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<h2><c:out value='${pageTitle}'/></h2>
<c:if test='${not empty error}'>
	<div style='color:red'><c:out value='${error}'/></div>
</c:if>
<form method="post" action="">
	<div>
		<label>Username</label>
		<input name="username" value="${item.username}" ${item.username != null ? 'readonly' : ''} required />
	</div>
	<div>
		<label>Password</label>
		<input name="password" type="password" />
		<c:if test='${item.username == null}'>
			<span>(bắt buộc khi tạo mới)</span>
		</c:if>
	</div>
	<div>
		<label>Họ tên</label>
		<input name="fullName" value="${item.fullName}" required />
	</div>
	<div>
		<label>Email</label>
		<input name="email" type="email" value="${item.email}" required />
	</div>
	<div>
		<label>Điện thoại</label>
		<input name="phone" value="${item.phone}" />
	</div>
	<div>
		<label>Admin</label>
		<input type="checkbox" name="admin" ${item.admin ? 'checked' : ''} />
	</div>
	<div>
		<label>Active</label>
		<input type="checkbox" name="active" ${item.active ? 'checked' : ''} />
	</div>
	<button type="submit">Lưu</button>
	<a href='${pageContext.request.contextPath}/admin/users'>Hủy</a>
</form>


