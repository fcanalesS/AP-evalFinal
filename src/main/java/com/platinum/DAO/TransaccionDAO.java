package com.platinum.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.platinum.Conector.ConectorDB;
import com.platinum.DTO.Transaccion;

public class TransaccionDAO {
	 public static List<Transaccion> obtenerTodasLasTransacciones() {
        List<Transaccion> transacciones = new ArrayList<>();
        String sql = "SELECT * FROM transaccion";

        
		try {
			Connection con = ConectorDB.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Transaccion transaccion = new Transaccion(
                    resultSet.getInt("id"),
                    resultSet.getString("rutCliente"),
                    resultSet.getString("rutDueno"),
                    resultSet.getInt("idCuenta"),
                    resultSet.getDouble("montoTransferencia"),
                    resultSet.getInt("cuentaTransferencia"),
                    resultSet.getString("tipoCuenta")
                );
                transacciones.add(transaccion);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transacciones;
    }
	 
	public static boolean insertarTransaccion(Transaccion transaccion) {
		String sql = "INSERT INTO Transaccion (rutCliente, rutDueno, idCuenta, montoTransferencia, cuentaTransferencia, tipoCuenta) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			Connection con = ConectorDB.getConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, transaccion.getRutCliente());
            statement.setString(2, transaccion.getRutDueno());
            statement.setInt(3, transaccion.getIdCuenta());
            statement.setDouble(4, transaccion.getMontoTransferencia());
            statement.setInt(5, transaccion.getCuentaTransferencia());
            statement.setString(6, transaccion.getTipoCuenta());

            int affectedRows = statement.executeUpdate();
            statement.close();
            return affectedRows > 0;
            
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
