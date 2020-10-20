<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp"%>
<main>
	<div class="table-responsive">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>TITLE</th>
					<th>READCOUNT</th>
					<th>CREATEDATE</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${board.id }</td>
					<td><input id="title" type="text" value="${board.title }" /></td>
					<td>${board.readCount }</td>
					<td><fmt:formatDate value="${board.createDate }"
							pattern="yyyy.MM.dd" /></td>
				</tr>
			</tbody>
		</table>
		
	</div >
	<h2>내용</h2>
	<textarea id="summernote" name="content" >${board.content }</textarea>
	<div class="nav justify-content-center">
	<button class="btn btn-secondary" onclick="deleteBoard(${board.id})">삭제</button>
	<button class="btn btn-secondary" onclick="updateBoard(${board.id})">수정</button>
	</div>
</main>

<script>
	function updateBoard(id){
		//id, title, content

		let title_el = document.querySelector("#title");
		let content_el = document.querySelector("#content");
		let title=title_el.value;
		let content=content_el.value;

	console.log("id",id);
	console.log("title",title);
	console.log("content",content);

	let board ={
		title:title,
		content:content
			};

	fetch("/board/"+id,{
		method:"put",
		headers:{
			'Content-Type': 'application/json; charset=utf-8',
			},
			body: JSON.stringify(board)
		}).then(res=> res.text())
		.then(res=> {
			console.log(res);
			if(res=="ok"){
				alert("수정완료");
				location.reload();
				}else{
				alert("수정실패");
				}
			});
	
	console.log(board);
		}

	function deleteBoard(id){
		fetch("/board/"+id,{
				method:"delete"
			}).then(res=>res.text())
			.then(res=>{
				if(res=="ok"){
				alert("삭제성공");
					location.href="/list";
				}else{
					alert("삭제실패");
					}
	});
	}

	$(document).ready(function() {
		  $('#summernote').summernote();
		});
	
</script>

<%@include file="layout/footer.jsp"%>
