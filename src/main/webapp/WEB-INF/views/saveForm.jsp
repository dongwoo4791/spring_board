<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="layout/header.jsp"%>

<main>
	<h1>글쓰기 페이지</h1>
	<hr />
		제목 : <input type = "text" name = "title" id="title"/>
		<textarea id="summernote" name="content"></textarea>
		<button class="btn btn-secondary" onclick="writerBoard()">글쓰기 완료</button>
</main>

<script>
    	function writerBoard(){
		//id, title, content
		let title_el = document.querySelector("#title");
		let content_el = document.querySelector("#summernote");
		let title= title_el.value;
		let content= content_el.value;

	console.log('#title',title);
	console.log('#content',content);

	let board ={
		title:title,
		content:content
			};

	fetch("/save",{
		method:"post",
		headers:{
			'Content-Type': 'application/json; charset=utf-8',
			},
			body: JSON.stringify(board)
		}).then(res=> res.text())

		.then(res=> {
			console.log("ddd"+res)
			if(res=="ok"){
				alert("등록완료");
				location.href="/list";
				}else{
				alert("등록실패");
				}
			});
	
		}
</script>

<script>
$(document).ready(function() {
  $('#summernote').summernote();
});
</script>
<script>
      $('#summernote').summernote({
        placeholder: '내용 입력',
        tabsize: 2,
        height: 200
      });
    </script>
    
<%@include file="layout/footer.jsp"%>
