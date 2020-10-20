<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="layout/header.jsp"%>
<main>
	<h1>게시글목록</h1>
	<hr />

	<table class="table">
		<thead>
			<tr class="s_tr">
				<td>ID</td>
				<td>TITLE</td>
				<td>CONTENT</td>
				<td>READCOUNT</td>
				<td>CREATEDATE</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board" items="${boards.content}">
				<tr>
					<td>${board.id }</td>
					<td><a href="/board/${board.id}">${board.title }</td>
					<td>${board.content }</td>
					<td>${board.readCount }</td>
					<td><fmt:formatDate value="${board.createDate }"
							pattern="yyyy.MM.dd" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<div>
		<ul class="nav justify-content-center">
			<c:choose>
				<c:when test="${boards.first }">
					<li class=" disable"><a
						href="list?page=${boards.pageable.pageNumber-1}">Prev </a></li>
				</c:when>
				<c:otherwise>
					<li><a href="list?page=${boards.pageable.pageNumber+1}">Next</a></li>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${boards.last }">
					<li><a href="list?page=${boards.pageable.pageNumber-1}">Prev</a></li>
				</c:when>
				<c:otherwise>
					<li class="disable"><a
						href="list?page=${boards.pageable.pageNumber+1}">Next</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</main>
<%@include file="layout/footer.jsp"%>
