package com.platinum.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.platinum.DAO.TransaccionDAO;
import com.platinum.DTO.Transaccion;

/**
 * Servlet implementation class RegistrarTransaccion
 */
public class RegistrarTransaccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarTransaccion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rutCliente = request.getParameter("rutCliente");
        String rutDueno = request.getParameter("rutDueno");
        int idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
        double montoTransferencia = Double.parseDouble(request.getParameter("montoTransferencia"));
        int cuentaTransferencia = Integer.parseInt(request.getParameter("cuentaTransferencia"));
        String tipoCuenta = request.getParameter("tipoCuenta");
        
        Transaccion nuevaTransaccion = new Transaccion(0, rutCliente, rutDueno, idCuenta, montoTransferencia, cuentaTransferencia, tipoCuenta);
        
        boolean resultado = TransaccionDAO.insertarTransaccion(nuevaTransaccion);
		 if (resultado) {
		     request.setAttribute("mensaje", "La transacción fue registrada con éxito.");
		 } else {
		     request.setAttribute("mensaje", "Error al registrar la transacción.");
		 }
        
		//doGet(request, response);
		 request.getRequestDispatcher("Inicio").forward(request, response);
	}

}
