<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h3>Chỉnh sửa thông tin sách</h3>
		<p style="color: red">${errors }</p>
		<c:if test="${not empty book}">
			<div align="center">
				<input type="hidden" name="bookId" value="${book.bookId }" />
				<table>
					<tr>
						<td>Tiêu đề</td>
						<td>${book.title }</td>
					</tr>
					<tr>
						<td>Tác giả</td>
						<td>${book.author }</td>
					</tr>
					<tr>
						<td>Giá tiền</td>

						<td> 
							<fmt:formatNumber type="number" value="${book.price }" /><sup>đ</sup>
						</td>
					</tr>
					<tr>
						<td>Số lượng có trong kho</td>
						<td>${book.quantityInStock }</td>
					</tr>
					<tr align="center">
						<td> <a href="adminHome">Bỏ qua</a></td>
					</tr>
				</table>
			</div>
		</c:if>
	</div>
</body>
</html>