package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class Conexion {
	
	private Connection con = null;
	
	Conexion(){
		
		String db = "soxstyle_bd";
		String url = "jdbc:mysql://localhost:3306/"+db;
		String user = "root";
		String pass = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public Connection getConnection() {
        return con;
    }
    
    public void cerrar() {
        try {
            con.close();
        } catch (SQLException e) {
            System.out.println("Error en cerrar : "+e);
        }
         
    } 
    
    public ResultSet consultar(String sql) {

        ResultSet resultado=null;
        try {
            Statement sentencia;
            sentencia = con.createStatement();
            resultado = sentencia.executeQuery(sql);
           
        } catch (SQLException error) {
            error.printStackTrace();
            System.out.println("Error en la consulta : "+error);
        }
        return resultado;
    }

    public boolean ejecutar(String sql) {
        boolean var;
        try {
            Statement sentencia;
            sentencia = getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            if(sentencia.executeUpdate(sql)==0)
                var=false;
            else            
                var = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error en ejecuci�n : "+e);
            var = false;
        }
        return var;        
    }
    

    
}
