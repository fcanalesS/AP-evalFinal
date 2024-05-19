package com.platinum.CtaCorriente;

import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.SQLException;

import com.platinum.Conector.ConectorDB;

public class ConectorDBTest {
	
	
	public ConectorDBTest() {
		String testName;
	}

	private static Connection conn;
	
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
