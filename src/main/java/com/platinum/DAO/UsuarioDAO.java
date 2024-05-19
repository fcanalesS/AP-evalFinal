package com.platinum.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.platinum.Conector.ConectorDB;
import com.platinum.DTO.Usuario;

public class UsuarioDAO {
	public static Usuario getUsuarioByUsernameAndPassword(String username, String password) throws SQLException {
        Usuario usuario = null;
        Connection con = ConectorDB.getConnection();
        try {
            
            PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario WHERE nombreUsuario = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario = new Usuario(rs.getInt("id"), rs.getString("nombreUsuario"), rs.getString("password"));
            }
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
