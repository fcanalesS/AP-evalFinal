package com.platinum.Controllers;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.platinum.Conector.ConectorDB;
import com.platinum.DAO.UsuarioDAO;
import com.platinum.DTO.Usuario;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
        String password = request.getParameter("password");

        Usuario usuario;
		try {
			usuario = UsuarioDAO.getUsuarioByUsernameAndPassword(username, password);
			if (usuario == null) {
	            request.setAttribute("error", "Usuario no existe o no está registrado");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        } else {
	            HttpSession session = request.getSession();
	            session.setAttribute("usuario", usuario);
	            response.sendRedirect("Inicio"); // Redirecciona a una página de bienvenida
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 response.sendRedirect("login.jsp"); // Redirecciona a una página de bienvenida
		}

        
	}

}
