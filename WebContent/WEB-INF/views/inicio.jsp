<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE>
<html>
<head>
  <meta charset="utf-8">
  <title>Identificate</title>

  <!-- JavaScript Libraries -->
  <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

  <!-- Bootstrap CSS File -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
  <link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet">
</head>
<body data-spy="scroll" data-offset="0">
	<div class="card text-center">
		<div class="card-header">Entrar</div>
		<div class="card-body">
			<h5 class="card-title">Ingresa tus credenciales</h5>
			<c:if test="${param.error != null}">
				<div class="alert alert-danger alert-dismissible fade show"
					role="alert">
					<strong>Importante : </strong> Usuario y clave no existen
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
			
			<c:if test="${param.logout != null}">
				<div class="alert alert-primary alert-dismissible fade show"
					role="alert">
					<strong>Importante : </strong> Has cerrado sesion!!
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</c:if>
			<div class="container">
				<div class="row justify-content-center">
					<form:form
						action="${pageContext.request.contextPath}/authenticateTheUser">
						<div class="form-group row">
							<div class="col-sm-12">
								<button type="button" class="btn btn-dark btn-block" disabled>
								<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-circle" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
								  <path d="M13.468 12.37C12.758 11.226 11.195 10 8 10s-4.757 1.225-5.468 2.37A6.987 6.987 0 0 0 8 15a6.987 6.987 0 0 0 5.468-2.63z"/>
								  <path fill-rule="evenodd" d="M8 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
								  <path fill-rule="evenodd" d="M8 1a7 7 0 1 0 0 14A7 7 0 0 0 8 1zM0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8z"/>
								</svg>
								</button>
								<input type="text"
									name="username" placeholder=" Digite su Usuario " required
									class="form-control form-control-lg" />
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-12">
								<button type="button" class="btn btn-dark btn-block" disabled>
									<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-file-lock-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
									  <path fill-rule="evenodd" d="M12 0H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2zM7 6a1 1 0 0 1 2 0v1H7V6zm3 0v1.076c.54.166 1 .597 1 1.224v2.4c0 .816-.781 1.3-1.5 1.3h-3c-.719 0-1.5-.484-1.5-1.3V8.3c0-.627.46-1.058 1-1.224V6a2 2 0 1 1 4 0zM6 8.3c0-.042.02-.107.105-.175A.637.637 0 0 1 6.5 8h3a.64.64 0 0 1 .395.125c.085.068.105.133.105.175v2.4c0 .042-.02.107-.105.175A.637.637 0 0 1 9.5 11h-3a.637.637 0 0 1-.395-.125C6.02 10.807 6 10.742 6 10.7V8.3z"/>
									</svg>
								</button>
								<input type="password" name="password"
									placeholder=" Digite su Clave " required
									class="form-control form-control-lg" />
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-12">
								<button class="btn btn-primary btn-lg btn-block" type="submit">Entrar
								</button>
							</div>
						</div>
					</form:form>
				</div>
			</div>

		</div>
		<div class="card-footer text-muted"></div>
	</div>
</body>
</html>