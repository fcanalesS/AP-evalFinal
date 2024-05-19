<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cta.Corriente</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class='container-fluid'>
		<div class='row'>
			<div class='col-md-4'>
				<h1>Listado de Transacciones</h1>
			</div>
		</div>
		<hr>
		<div class='row'>
			<div class='col-md-4'>
				<form action="RegistrarTransaccion" method="post">
			        Rut Cliente: <input class="form-control" type="text" name="rutCliente" id="rutCliente"><br>
			        Rut Dueño: <input class="form-control" type="text" name="rutDueno" id="rutDueno"><br>
			        ID Cuenta: <input class="form-control" type="number" name="idCuenta" id="idCuenta"><br>
			        Monto Transferencia: <input class="form-control" type="number" step="0.01" name="montoTransferencia" id="montoTransferencia"><br>
			        Cuenta Transferencia: <input class="form-control" type="number" name="cuentaTransferencia" id="cuentaTransferencia"><br>
			        Tipo Cuenta: <input class="form-control" type="text" name="tipoCuenta" id="tipoCuenta"><br>
			        <input type="submit" value="Registrar Transacción" class='btn btn-success' id='btnRegistrarTransaccion'>
			    </form>
			</div>
		</div>
		 <c:if test="${not empty mensaje}">
	        <div class="${mensaje.startsWith('Error') ? 'error' : 'message'}">
	            ${mensaje}
	        </div>
	    </c:if>
		<hr />
		<div class='row'>
			<div class='col'>
			    <table class='table table-striped table-hover'>
			        <tr>
			            <th>ID</th>
			            <th>Rut Cliente</th>
			            <th>Rut Dueño</th>
			            <th>ID Cuenta</th>
			            <th>Monto Transferencia</th>
			            <th>Cuenta Transferencia</th>
			            <th>Tipo Cuenta</th>
			        </tr>
			        <c:forEach var="transaccion" items="${transacciones}">
			            <tr>
			                <td>${transaccion.id}</td>
			                <td>${transaccion.rutCliente}</td>
			                <td>${transaccion.rutDueno}</td>
			                <td>${transaccion.idCuenta}</td>
			                <td>${transaccion.montoTransferencia}</td>
			                <td>${transaccion.cuentaTransferencia}</td>
			                <td>${transaccion.tipoCuenta}</td>
			            </tr>
			        </c:forEach>
			    </table>
			</div>
		</div>
		
	</div>
</body>
</html>