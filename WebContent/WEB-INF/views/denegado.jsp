<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
  <meta charset="utf-8">
  <title>Spring MVC</title>

  <!-- Bootstrap CSS File -->
  <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body data-spy="scroll" data-offset="0">
<hr>
<div class="container">
        <div class="row justify-content-center">
            <div class="col-md-12">
            <h3 class="row justify-content-center">Su usuario no posee los permisos para acceder al recurso </h3>
            </div>
            <br>
            <a href="${pageContext.request.contextPath}/">Regresar a menu principal</a>
        </div>
</div>
<hr>
  <!-- JavaScript Libraries -->
  <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>