function activeAsLink(link) {
	window.location = link;
}

function onClickDeleteBook(title, bookId) {
	// Xác nhận xóa và tạo form để gửi dữ liệu về servlet
	var confirmation = confirm("Bạn có chắc chắn muốn xóa cuốn sách '" + title + "' không?");
	if (confirmation) {
		var form = document.createElement("form");
		form.setAttribute("method", "post");
		form.setAttribute("action", "${pageContext.request.contextPath}/deleteBook");

		var inputBookId = document.createElement("input");
		inputBookId.setAttribute("type", "hidden");
		inputBookId.setAttribute("name", "bookId");
		inputBookId.setAttribute("value", bookId);

		form.appendChild(inputBookId);
		document.body.appendChild(form);

		form.submit();
	}
}
var request;

function searchBooks(keyword) {
	if (window.XMLHttpRequest) {
		request = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		request = new ActiveXObject("Microsoft.XMLHTTP");
	}

	var url = request.getContextPath() + "/search?keyword=" + encodeURIComponent(keyword);

	try {
		request.onreadystatechange = function() {
			if (request.readyState == 4) {
				if (request.status == 200) {
					var val = request.responseText;
					document.getElementById('searchResultArea').innerHTML = val;
				} else {
					alert("Error: " + request.status + " " + request.statusText);
				}
			}
		};
		request.open("GET", url, true);
		request.send();
	} catch (e) {
		alert("Unable to connect to server");
	}
}