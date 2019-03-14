package org.jbpm;

import java.sql.*;
import java.util.*;

public class Clientes {
	
	private final String SQL_SELECT = "SELECT id_persona, nome, apelido FROM persona ORDER BY id_persona";
	 
	public ArrayList<String> select(){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<String> clientes = new ArrayList<String>();
        
        try{
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
            	String cliente = rs.getString(2);
            	clientes.add(cliente);
            }
        } catch(SQLException sqle){
            sqle.printStackTrace();
        } finally{
            Conexion.clse(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return clientes;
    } 

}
