<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="padding: 5px; text-align: center;">
	<a href="" class="active">  </a>
	<a href="${pageContext.request.contextPath}/adminHome">Trang
		chủ</a> | <a
		href="${pageContext.request.contextPath }/adminOrderList/waiting" >Các
		đơn hàng chưa xác nhận</a> | <a
		href="${pageContext.request.contextPath }/adminOrderList/delivering">Các
		đơn hàng đang chờ giao</a> | <a
		href="${pageContext.request.contextPath }/adminOrderList/delivered">Các
		đơn hàng đã giao</a> | <a
		href="${pageContext.request.contextPath }/adminOrderList/reject">Các
		đơn hàng khách trả lại</a>
</div>
<style>
.active {
	color: red; /* Đổi màu tùy chọn cho liên kết đã chọn */
}
</style>
<script>
    // Lấy tất cả các liên kết
    var links = document.querySelectorAll('a');

    // Lặp qua mỗi liên kết và thêm sự kiện click
    links.forEach(function(link) {
        link.addEventListener('click', function() {
            // Xóa lớp 'active' từ tất cả các liên kết
            links.forEach(function(otherLink) {
                otherLink.classList.remove('active');
            });
            
            // Thêm lớp 'active' vào liên kết đã nhấp vào
            this.classList.add('active');

            // Lưu trạng thái của liên kết đã chọn vào sessionStorage
            sessionStorage.setItem('selectedLink', this.getAttribute('href'));
        });
    });

    // Kiểm tra nếu có liên kết được lưu trong sessionStorage
    var selectedLink = sessionStorage.getItem('selectedLink');
    if (selectedLink) {
        // Tìm liên kết tương ứng và thêm lớp 'active'
        var link = document.querySelector('a[href="' + selectedLink + '"]');
        if (link) {
            link.classList.add('active');
        } else {
            // Nếu không tìm thấy liên kết, hãy xóa trạng thái đã lưu khỏi sessionStorage
            sessionStorage.removeItem('selectedLink');
        }
    }
</script>





