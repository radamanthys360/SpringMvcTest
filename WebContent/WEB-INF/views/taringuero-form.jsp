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
            <div class="col-md-12 well"><h2>Formulario Taringuero Ario </h2></div>
        </div>
</div>
<hr>
<form:form action="procesarform" modelAttribute="taringueroDto">
	<div class="container">
		<div class="form-group row">
			<label for="nombreUsuario" class="col-sm-2 col-form-label">Nombre Usuario (*)</label>
			<div class="col-sm-10">
			     <form:input path="nombreUsuario" class="form-control" placeholder="Usuario" required="required"/>
			     <form:errors path="nombreUsuario" class="alert-danger" />
<%-- 			   <form:input path="nombreUsuario" class="form-control" placeholder="Usuario" required="required"/> --%>
			</div>
		</div>
		
		<div class="row">
            <div class="col-md-6 well">
               <label for="edad">Edad</label>
            	<form:input path="edad" type="number" class="form-control" placeholder="Edad" />
            </div>
            <div class="col-md-6 well">
                <label for="genero">Genero (*)</label>
                <form:select path="genero" class="custom-select browser-default" required="required">
<%-- 			    <form:select path="genero" class="custom-select browser-default" required="required"> --%>
					<form:options items="${taringueroDto.generoOptions}" />
				</form:select>
				<form:errors path="genero" class="alert-danger" />
            </div>
        </div>
        
        <div class="form-group row">
			<label for="versiones" class="col-sm-12 col-form-label">¿Versiones de Taringa que has visto?</label>
			<div class="col-sm-12">
			  <div class="custom-control custom-checkbox custom-control-inline">
                <form:checkboxes cssStyle="custom-control-input" items="${taringueroDto.versionesData}" path="versiones" />
              </div>
			</div>
		</div>
		
		<div class="form-group row">
			<label for="virgo" class="col-sm-12 col-form-label">Sigo virgo (pagando no se vale, con primas si) (*)</label>
			<div class="col-sm-12">
				<div class="form-check form-check-inline">
				  <form:radiobutton path="sigoVirgo" value="S" class="form-check-input" required="required"/>
<%-- 				  <form:radiobutton path="sigoVirgo" value="S" class="form-check-input" required="required"/> --%>
				  <label class="form-check-label" for="inlineRadio1">Si</label>
				</div>
				<div class="form-check form-check-inline">
				  <form:radiobutton path="sigoVirgo" value="N" class="form-check-input" required="required"/>
<%-- 				  <form:radiobutton path="sigoVirgo" value="N" class="form-check-input" required="required"/> --%>
				  <label class="form-check-label" for="inlineRadio2">No</label>
				</div>
				<form:errors path="sigoVirgo" class="alert-danger" />
			</div>
		</div>
		
		<div class="form-group row">
			<label for="virgo" class="col-sm-12 col-form-label">El Facha tenia razon</label>
			<div class="col-sm-12">
				<div class="form-check form-check-inline">
				  <form:radiobutton path="facha" value="S" class="form-check-input"/>
				  <label class="form-check-label" for="inlineRadio1">Si</label>
				</div>
				<div class="form-check form-check-inline">
				  <form:radiobutton path="facha" value="N" class="form-check-input"/>
				  <label class="form-check-label" for="inlineRadio2">No</label>
				</div>
			</div>
		</div>
		
		<div class="form-group row">
			<div class="col-sm-6">
                <button class="btn btn-primary" type="submit">Aceptar</button>
                <button type="reset" class="btn btn-warning" type="reset" value="Reset">Cancelar</button>
			</div>
		</div>
        
	</div>
</form:form>
<hr>
  <!-- JavaScript Libraries -->
  <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>