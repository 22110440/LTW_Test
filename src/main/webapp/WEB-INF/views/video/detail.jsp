<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:choose>
	<c:when test="${video != null}">
		<table border="1" width="100%" cellspacing="0" cellpadding="6">
			<tr>
				<td width="30%" valign="top">
					<div style="width:100%;height:200px;background:#eee;text-align:center;line-height:200px;">
						<c:out value="[poster]"/>
					</div>
				</td>
				<td valign="top">
					<div>Tiêu đề: <strong>${video.title}</strong></div>
					<div>Mã video: ${video.videoId}</div>
					<div>Category name: <c:out value='${category.categoryName}'/></div>
					<div>View: ${video.views}</div>
					<div>Share(${shareCount})</div>
					<div>Like(${likeCount})</div>
				</td>
			</tr>
			<tr>
				<td colspan="2">${video.description}</td>
			</tr>
		</table>
	</c:when>
	<c:otherwise>
		<div>Video không tồn tại.</div>
	</c:otherwise>
</c:choose>


