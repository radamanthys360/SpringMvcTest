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

<c:if test="${not empty guardar}">
<div class="alert alert-primary alert-dismissible fade show" role="alert">
  <strong>Importante : </strong> ${mensaje}
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
</c:if>

<c:if test="${not empty error}">
<div class="alert alert-danger alert-dismissible fade show" role="alert">
  <strong>Importante : </strong> ${mensaje}
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
</c:if>

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
					<form:options items="${getgenero}" />
				</form:select>
				<form:errors path="genero" class="alert-danger" />
            </div>
        </div>
        
        <div class="form-group row">
			<label for="versiones" class="col-sm-12 col-form-label">¿Versiones de Taringa que has visto?</label>
			<div class="col-sm-12">
			  <div class="custom-control custom-checkbox custom-control-inline">
                <form:checkboxes cssStyle="custom-control-input" items="${getversiones}" path="versiones" />
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

<nav class="navbar navbar-light bg-light justify-content-between">
  <a class="navbar-brand"></a>
  <form:form class="form-inline" action="busquedaTabla">
    <input name="buscar" class="form-control mr-sm-2" type="search" placeholder="Buscar" aria-label="Buscar" required="required">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
    <a href="mostrarform" class="btn btn-outline-success my-2 my-sm-0" role="button">Limpiar</a>
 </form:form>
</nav>


<div class="table-responsive">
  <table class="table table-hover">
  <thead class="thead-dark">
	<tr>
	<th scope="col">Nombre Usuario</th>
    <th scope="col">Edad</th>
    <th scope="col">Genero</th>
    <th scope="col">Sigo Virgo</th>
    <th scope="col">El facha Tenia Razon</th>
    <th scope="col">Versiones de Taringa</th>
	</tr>
   </thead>
   <tbody>	
	<c:forEach items="${tabladata}" var="fila" >
		<tr>
			<td>${fila.nombreUsuario}</td>
	        <td>${fila.edad}</td>
	        <td>${fila.genero}</td>
	        <td>${fila.sigoVirgo}</td>
	        <td>${fila.facha}</td>
	        <td>${fila.versionestexto}</td>
		</tr>
	</c:forEach>
	</tbody>
   </table>

		<div class="col-sm-12">
				<nav aria-label="Page navigation example">
					<ul class="pagination justify-content-center">
						<c:forEach items="${paginador}" var="pag">
						   <c:if test="${param.pagg == pag}">
                               <li class="page-item active"><a class="page-link"
								href="mostrarformP?pagg=${pag}&tipo=${busqueda}&bus=${bus}">
								${pag}</a></li>
                           </c:if>
                           <c:if test="${param.pagg != pag}">
                               <li class="page-item"><a class="page-link"
								href="mostrarformP?pagg=${pag}&tipo=${busqueda}&bus=${bus}">
								${pag}</a></li>
                           </c:if>
						</c:forEach>
					</ul>
				</nav>
		</div>
</div>

<div class="col-sm-12">
			<nav class="navbar navbar-light bg-light">
				<span class="navbar-text">${mensajeP}</span>
			</nav>
</div>

  <!-- JavaScript Libraries -->
  <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>