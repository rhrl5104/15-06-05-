<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="board.dto.*" %>
<!DOCTYPE html>

<html>
	<head>
		<title>JSP/Servlet Example</title>
		<link rel="Stylesheet" type="text/css" href="./css/bootstrap.css"></link>
	</head>
	
	<body>
		<!-- 메뉴 시작  -->
		<nav class="navbar navbar-default">
		  <div class="container-fluid">
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">게시판관리</a>
		    </div>
		
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="#">글쓰기<span class="sr-only">(current)</span></a></li>
		        <li><a href="list.board">리스트</a></li>
		      </ul>
		    </div>
		  </div>
		</nav>
		
		<!-- 게시판 상세보기 시작  -->
		<%
			Board board = (Board)request.getAttribute("board"); //
		%>
		
		<form class="form-horizontal">
		  <fieldset>
		    <legend>게시판 내용  </legend>
		    
		    <div class="form-group">
		      <label for="inputEmail" class="col-lg-2 control-label">이름 : </label>
		      <div class="col-lg-10">
		        <%= board.getName() %>
		      </div>
		    </div>
		    
		    <div class="form-group">
		      <label for="inputEmail" class="col-lg-2 control-label">제목 : </label>
		      <div class="col-lg-10">
		        <%= board.getTitle()%>
		      </div>
		    </div>
		    
		    <div class="form-group">
		      <label for="inputEmail" class="col-lg-2 control-label">파일 : </label>
		      <div class="col-lg-10">
		        <a href="./upload/<%= board.getAttachment()%>"><%= board.getAttachment()%></a>
		      </div>
		    </div>
		   
		    <div class="form-group">
		      <label for="textArea" class="col-lg-2 control-label">내용 : </label>
		      <div class="col-lg-10">
		        <%= board.getContent() %>
		      </div>
		    </div>
		    <div class="form-group">
		      <div class="col-lg-10 col-lg-offset-2">
		        <a href="update.board" class="btn btn-default">수정하기</a>
		        <a href="delete.board" class="btn btn-primary">삭제하기</a>
		      </div>
		    </div>
		  </fieldset>
		</form>
	</body>
</html>