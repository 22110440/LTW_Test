<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<h3>Category: <c:out value='${categoryName != null ? categoryName : categoryCode}'/></h3>

<c:forEach var="v" items="${videos}">
	<table border="1" width="100%" cellspacing="0" cellpadding="6" style="margin-bottom:10px;">
		<tr>
			<td width="30%" valign="top">
				<div style="width:100%;height:120px;background:#eee;text-align:center;line-height:120px;">[poster]</div>
			</td>
			<td valign="top">
				<div>Tiêu đề: <a href='${pageContext.request.contextPath}/video/detail?id=${v.videoId}'>${v.title}</a></div>
				<div>Mã video: ${v.videoId}</div>
				<div>Category name: <c:out value='${categoryCode}'/></div>
				<div>View: ${v.views}</div>
				<div>Share(10)</div>
				<div>Like(10)</div>
			</td>
		</tr>
	</table>
</c:forEach>


