<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Trang giỏ hàng</title>
</head>
<body>
	<div class="center">
		<h3>Các cuốn sách có trong giỏ hàng</h3>
		<form action="removeFromCart" id="removedBookFromCartFrom"
			method="POST">
			<input type="hidden" name="bookId" id="removedBookFromCart" />
		</form>
		<table border="1">
			<tr>
				<th>Tiêu đề</th>
				<th>Tác giả</th>
				<th>Giá tiền</th>
				<th>Số lượng mua</th>
				<th>Tổng thành phần</th>
				<th>Thao tác</th>
			</tr>
			<c:forEach items="${cartOfCustomer.cartItemList }" var="entry">
				<tr>
					<td>${entry.value.selectedBook.title }</td>
					<td>${entry.value.selectedBook.author }</td>
					<td><fmt:formatNumber maxFractionDigits="0" type="number"
							value="${entry.value.selectedBook.price }" /><sup>đ</sup></td>
					<td><img alt="remove-icon"
						src="${pageContext.request.contextPath }/img/icon-remove.png"
						onclick="minusValueAndUpdateCart('quantity${entry.value.selectedBook.bookId}');"
						width="20px" height="20px"> <input type="text"
						value="${entry.value.selectedBook.quantity }" size="2"
						style="line-height: 20px"
						onchange="validateValueAndUpdateCart(this,${entry.value.selectedBook.quantityInStock})" />
						<img alt="plus-icon"
						src="${pageContext.request.contextPath }/img/icon-add.svg"
						onclick="plusValueAndUpdateCart('quantity${entry.value.selectedBook.bookId}');"
						width="20px" height="20px"></td>
					<td><fmt:formatNumber maxFractionDigits="0" type="number"
							value="${entry.value.selectedBook.price * entry.value.quantity}" /><sup>đ</sup>
					</td>
					<td>
						<button type="button"
							onclick="onClickRemoveBook('${entry.value.selectedBook.title}',${entry.value.selectedBook.bookId})">Loại
							khỏi giỏ hàng</button>
					</td>

				</tr>
			</c:forEach>
		</table>
		<br> <a href="${pageContext.request.contextPath }/clientHome">/Tiếp
			tục chọn sách</a>&nbsp;&nbsp; Tổng số tiền: <b> <span id="total">
				<fmt:formatNumber maxFractionDigits="0" type="number"
					value="${cartOfCustomer.totalCost}" /><sup>đ</sup>
		</span>
		</b>
	</div>
</body>
</html>
