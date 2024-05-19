<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio Sesión - CtaCorriente</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class='container-fluid'>
		<div class='row'>
			<div class='col'>
				<h1>Inicio de Sesión</h1>
			</div>
		</div>
		<hr>
		<div class='row'>
			<div class='col'>
				<form method='POST' action='Login'>
					<div class="mb-3">
					  <label class="form-label">Usuario</label>
					  <input type="text" class="form-control" id="username" name='username' class='lusername' placeholder="Nombre de Usuario">
					</div>
					<div class="mb-3">
					  <label class="form-label">Contraseña</label>
					  <input type="password" class="form-control" id="password" name='password' class='password' placeholder="Contraseña">
					</div>
					 <div class="col-auto">
					 	<button type="submit" class="btn btn-primary mb-3" id='btnIngresar' class='btnIngresar' value='Iniciar'>Iniciar Sesión</button>
					 </div>
				</form>
			</div>
		</div>
		<div class='row'>
			<div class='col'>
				<% if (request.getAttribute("error") != null) { %>
			        <p id='mensajeError' style="color: red;"><%= request.getAttribute("error") %></p>
			    <% } %>
							
				
			</div>
		</div>
	</div>
</body>
</html>