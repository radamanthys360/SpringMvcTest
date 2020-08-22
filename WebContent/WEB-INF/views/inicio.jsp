<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
  <meta charset="utf-8">
  <title>Identificate</title>

  <!-- Bootstrap CSS File -->
  <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body data-spy="scroll" data-offset="0">
<div class="container">
        <div class="row">
            <div class="col-md-12 well"><h2>Login </h2></div>
        </div>
</div>
<c:if test="${not empty error}">
<div class="alert alert-danger alert-dismissible fade show" role="alert">
  <strong>Importante : </strong> ${mensaje}
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
</c:if>
<hr>
	<div class="container">
	<div class="row justify-content-center">
		<form:form action="login" modelAttribute="loginDto">
			<div class="form-group row">
				<div class="col-sm-12">
				<form:input path="usuario" class="form-control form-control-lg" 
				    placeholder=" Digite su Usuario " required="required"/>
				    <form:errors path="usuario" class="alert-danger" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-12">
				<form:password path="clave" class="form-control form-control-lg" 
				    placeholder=" Digite su Clave " required="required"/>
				    <form:errors path="clave" class="alert-danger" />
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-12">
                   <button class="btn btn-primary btn-lg btn-block" type="submit">Entrar</button>
				</div>
			</div>
		</form:form>
		</div>
</div>
	<hr>
  <!-- JavaScript Libraries -->
  <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>