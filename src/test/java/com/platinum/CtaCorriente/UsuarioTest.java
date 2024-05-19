package com.platinum.CtaCorriente;

import junit.framework.TestCase;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.platinum.Conector.ConectorDB;
import com.platinum.DAO.UsuarioDAO;
import com.platinum.DTO.Usuario;

public class UsuarioTest extends TestCase {
	private static UsuarioDAO usuarioDAO;
    private static Connection conn;
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() throws SQLException {
	}
	
	@Before
	public void setUp() {}	
	
	@After
	public void tearDown() {}
	
	@Test
    public void testLoginCorrecto() throws SQLException {
		Usuario result = usuarioDAO.getUsuarioByUsernameAndPassword("user1", "pass1");
		assertEquals(result.getNombreUsuario(), "user1");
		assertEquals(result.getPassword(), "pass1");
		
        
    }

    @Test
    public void testLoginIncorrecto() throws SQLException {
    	Usuario result = usuarioDAO.getUsuarioByUsernameAndPassword("user1", "incorrectPassword");
        assertNull("No se debería encontrar usuario con credenciales incorrectas", result);
    }

    
	
}
