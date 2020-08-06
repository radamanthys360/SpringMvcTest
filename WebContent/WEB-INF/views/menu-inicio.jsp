<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<div class="container">
        <div class="row">
            <div class="col-md-12 well"><h2>Spring MVC Test - Pagina de inicio </h2></div>
        </div>
</div>
<hr>

			<div class="container">
				<div class="row">
					<div class="col-md-12 well">
						<a href="taringuero/mostrarform">Formulario Taringuero</a>
					</div>
				</div>
			</div>
<hr>
  <!-- JavaScript Libraries -->
  <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>