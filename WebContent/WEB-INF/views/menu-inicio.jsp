<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE>
<html>
<head>
  <meta charset="utf-8">
  <title>Inicio Spring MVC</title>

  <!-- Bootstrap CSS File -->
  <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body data-spy="scroll" data-offset="0">
<nav class="navbar fixed-top navbar-light bg-light">
  <span class="navbar-text">
           Usuario: <security:authentication property="principal.username" />
           Role(s): <security:authentication property="principal.authorities" />
  </span>
</nav>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Menu</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Inicio <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Formularios
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="taringuero/mostrarform">Taringuero</a>
          <a class="dropdown-item" href="#">Formulario 2</a>
          <a class="dropdown-item" href="#">Formulario 3</a>
        </div>
      </li>
    </ul>
      <form:form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/logout" method="POST">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Cerrar Sesion</button>
      </form:form>
  </div>
</nav>
  <!-- JavaScript Libraries -->
  <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>