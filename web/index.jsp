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
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Dropdown
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="#">Action</a>
                        <a class="dropdown-item" href="#">Another action</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="#">Something else here</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">Disabled</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </nav>
  <div class="header clearfix">
    <h3 class="text-muted">2ª Avaliação - 2º Semestre</h3>
  </div>

  <div class="jumbotron">
    <h1 class="display-5">Hoff Silva - 21652435</h1>
    <p></p>
    <p></p>
    <h3 class="display-5">Cadastro de Matéria</h3>
    <form action="Controller" method="POST">
      <div class="form-group">
        <label for="">Digite o Nome da Matéria</label>
        <input class="form-control" type="text" name="nomeMateria" placeholder="Nome da Materia">
      </div>
      <div class="form-group">
          
       <div class="form-group">
        <label for="">Digite o Nome do Curso</label>
        <input class="form-control" type="text" name="nomeCurso" placeholder="Nome do Curso">
      </div>
          
          <div class="form-group">
            <label for="">Selecione o Tipo da Matéria (Presencial ou EAD)</label>
            <select class="form-control" id="tipoDeMateria" name="tipoDeMateria">
                <option value="Presencial">Presencial</option>
                <option value="EAD">EAD</option>
            </select>
        </div>
      <div class="form-group">
        <input type="submit" value="Cadastrar" class="btn btn-primary">
      </div>
    </form>
  </div>

  <div class="table-responsive">
    <table class="table table-striped">
      <thead>
      <tr>
        <th>Curso</th>
        <th>Matéria</th>
        <th>Tipo (1 - Presencial | 2 - EAD)</th>
      </tr>
      </thead>
      <tbody>
      <%
        EAD materia = null;
        Presencial presencial = null;
        if ((materia = (EAD) request.getAttribute("materia")) != null) {
      %>
      <tr>
        <tr>
            <td><%= materia.getCurso().getNome()%></td>
            <td><%= materia.getNome()%></td>
            <td><%= materia.getSala()%></td>
        </tr>
        
      </tr>
      <%} else if ((presencial = (Presencial) request.getAttribute("materia")) != null) {%>
        <tr>
        <tr>
            <td><%= presencial.getCurso().getNome()%></td>
            <td><%= presencial.getNome()%></td>
            <td><%= presencial.getCodigo()%></td>
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



