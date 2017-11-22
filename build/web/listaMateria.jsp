<%--
    Document   : index
    Created on : 25/09/2017, 21:31:52
    Author     : ra21652435
--%>
<%@page import="Model.Presencial"%>
<%@page import="Model.EAD"%>
<%@page import="Model.Materia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"; integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
</head>
<body>
<div class="header clearfix">
    <h3 class="text-muted"></h3>
</div>
<div class="container">
      <jsp:include page="menu.jsp"/>
  <div class="header clearfix">
    <h3 class="text-muted">2ª Avaliação - 2º Semestre</h3>
  </div>

  <div class="jumbotron">
    <h1 class="display-5">Hoff Silva - 21652435</h1>
    <p></p>
    <p></p>
    <h3 class="display-5">Lista de Matérias</h3>
  </div>

  <div class="table-responsive">
    <table class="table table-striped">
      <thead>
      <tr>
        <th>Curso</th>
        <th>Matéria</th>
        <th>Tipo</th>
      </tr>
      </thead>
      <tbody>
      <%
        EAD materia = null;
        Presencial presencial = null;
        if ((materia = (EAD) request.getAttribute("ead")) != null) {
      %>
      <tr>
        <tr>
            <td><%= materia.getCurso().getNome()%></td>
            <td><%= materia.getNome()%></td>
            <td><%= materia.toString()%></td>
        </tr>
        
      </tr>
      <%} else if ((presencial = (Presencial) request.getAttribute("presencial")) != null) {%>
        <tr>
        <tr>
            <td><%= presencial.getCurso().getNome()%></td>
            <td><%= presencial.getNome()%></td>
            <td><%= presencial.toString()%></td>
        </tr>
        
      </tr>
      
      <%} else {%>
      <div class="alert alert-danger">
        Materia não cadastrado.
      </div>

      
      <%}%>
      </tbody>
    </table>
  </div>
</body>
</html>



