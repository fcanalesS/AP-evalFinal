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

public class ConectorDBTest extends TestCase {
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
    public void testConnectionNotNull() throws SQLException {
		conn = ConectorDB.getConnection();
		assertTrue("La conexión debería ser válida", conn.isValid(5));
    }

    @Test
    public void testMultipleConnections() throws SQLException {
    	Connection anotherConn = ConectorDB.getConnection();
        assertNotNull("Debería haber obtenido una segunda conexión", anotherConn);
        assertTrue("La segunda conexión debería ser válida", anotherConn.isValid(5));
        anotherConn.close();
    }

    
	
}
