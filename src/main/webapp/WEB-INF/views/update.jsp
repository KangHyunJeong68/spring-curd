<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h2> 게시글 수정 </h2>

<div class="container">
    <form action="/updateProc" method="post">
        <input type="hidden" name="idx" id="idx" value="${data.idx}">
        <div class="form-group">
            <label for="subject">제목</label>
            <input type="text" class="form-control" id="subject" name="subject" value="${data.subject}">
        </div>
        <div class="form-group">
            <label for="password">작성자</label>
            <input type="text" class="form-control" id="writer" name="writer" value="${data.name}">
        </div>
        <div class="form-group">
            <label for="writer">비밀번호</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <div class="form-group">
            <label for=content">내용</label>
            <textarea class="form-control" id="content" name="content" rows="3">${data.content}</textarea>
        </div>
        <button type="submit" class="btn btn-primary">수정</button>
    </form>
</div>

<%@ include file="bootstrap.jsp" %>
</body>
</html>

