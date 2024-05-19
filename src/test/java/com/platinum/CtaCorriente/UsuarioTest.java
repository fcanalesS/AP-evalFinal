package com.platinum.CtaCorriente;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.sql.Connection;
import java.sql.SQLException;

import com.platinum.DAO.UsuarioDAO;
import com.platinum.DTO.Usuario;

public class UsuarioTest {
	
	
	public UsuarioTest() {
		String testName;
	}

	private static UsuarioDAO usuarioDAO;
    private static Connection conn;
	
	@Test
    public void testLoginCorrecto() throws SQLException {
		Usuario result = usuarioDAO.getUsuarioByUsernameAndPassword("user1", "pass1");
		AssertJUnit.assertEquals(result.getNombreUsuario(), "user1");
		AssertJUnit.assertEquals(result.getPassword(), "pass1");
		
        
    }

    @Test
    public void testLoginIncorrecto() throws SQLException {
    	Usuario result = usuarioDAO.getUsuarioByUsernameAndPassword("user1", "incorrectPassword");
        AssertJUnit.assertNull("No se debería encontrar usuario con credenciales incorrectas", result);
    }

    
	
}
