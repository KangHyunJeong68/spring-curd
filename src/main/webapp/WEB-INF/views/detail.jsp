<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>게시글 상세</title>
</head>
<body>
<h2> 게시글 상세 </h2>

<div class="container">
    <form action="/update/${detail.idx}" method="post">
        <div class="form-group">
            <label>제목</label>
            <p>${detail.subject}</p>
        </div>
        <div class="form-group">
            <label>작성자</label>
            <p>${detail.name}</p>
        </div>
        <div class="form-group">
            <label>ip</label>
            <p>${detail.ip}</p>
        </div>
        <div class="form-group">
            <label>작성날짜</label>
            <p>${detail.regDate}</p>
        </div>
        <div class="form-group">
            <label>내용</label>
            <p>${detail.content}</p>
        </div>
        <button type="submit" class="btn btn-primary">수정</button>
    </form>
</div>
<%@ include file="bootstrap.jsp" %>
</body>
</html>

