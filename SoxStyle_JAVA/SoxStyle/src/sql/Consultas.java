package sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import modelo.Usuario;




public class Consultas {
	
	
// esta consulta es para buscar datos de la tabla	
//	  public DefaultTableModel buscarPersonas(String buscar) {
//		  Conexion conexion = new Conexion();
//		  	String []  nombresColumnas = {"Nombre","Precio","Descuento","Categoria", "Descripcion", "Imagen del producto", "Estado"};//Indica el nombre de las columnas en la tabla
//	        String [] registros = new String[7];
//	        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
//	        String sql = "SELECT * FROM usuario WHERE Nombre LIKE '%"+buscar+"%' OR Precio LIKE '%"+buscar+"%'  OR Descripcion LIKE '%"+buscar+"%' OR Descuento LIKE '%"+buscar+"%'"; 
//	      
//	        ResultSet rs = null;                         
//
//	        try {               
//	        	  rs = conexion.consultar(sql);
//	        	  if (rs.next()){
//          
//	            		  registros[0] = rs.getString("Nombre");
//			                
//			              registros[1] = rs.getString("Precio");
//			               
//			              registros[2] = rs.getString("Descuento");        
//			                
//			              registros[3] = rs.getString("Descripcion");  
//			              
//			              registros[4] = rs.getString("Categoria");  
//			              
//			              registros[5] = rs.getString("Imagen del producto");  
//			              
//			              registros[6] = rs.getString("Estado");  
			                
//			                modelo.addRow(registros);
//	            	}
//	                                  
//	        } catch(SQLException e) {            
//	            System.out.println("Error al realizar la consulta: " + e.getMessage());           
//	        } finally {
//	            if (rs != null) {
//				    conexion.cerrar();
//				}
//	        }
//	        return modelo;
//	    }
	
	// consulta para llamar los datos de la tabla, ahi datos que se deben cambiar segun la base de datos y los datos de las tablas
//	  public DefaultTableModel  listar1() {
//
//			Conexion conectar = new Conexion();
//			String[] nombresColumnas = {"id","nombre","email","rol"};
//		    String[] registros = new String[4];
//		    DefaultTableModel model = new DefaultTableModel(null, nombresColumnas);
//			ResultSet st; 
//			String sql= "SELECT * FROM usuario";
//			st = conectar.consultar(sql); 
//			
//			try {
//			
//				
//				
//				while (st.next()) {
//					registros[0]=st.getString(1);
//					registros[1]=st.getString(2);
//					registros[2]=st.getString(3);
//					registros[3]=st.getString(4);
//					model.addRow(registros);
//					
//				}
//				
//			}catch(SQLException e) {            
//	            System.out.println("Error al realizar la consulta: " + e.getMessage());           
//	        } finally {
//	            if (st != null) {
//				    conectar.cerrar();
//				}
//	        }
//	        return model;
//		}
	
	
	public boolean ingreso(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE correo = '" + u.getCorreo()+ "'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
             
                     u.setContrasena(rs.getString("contrasena"));
                 }
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean ConsultarUsuario(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE correo = '" + u.getCorreo()+ "'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
                 }
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean EstadoUsuario(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE correo = '" + u.getCorreo()+ "' AND estado ='inactivo'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
                 }
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean ConsultarRolUsuario(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * FROM users WHERE correo = '" + u.getCorreo()+ "' AND id_rol = 1";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
                 }
            else {
            }
        } catch (Exception e) {
       System.out.println("Error en comparar clave(controlador user): " + e);
        }
        conectar.cerrar();
        return numero;
    }
	
	public boolean InsertarUsuario(Usuario u) {
		
	        Conexion conectar = new Conexion();
	        String sql = "INSERT INTO users (nombre, correo,contrasena, identificacion, N_Identificacion, id_rol, estado) VALUES ("
	        		+ "'"+ u.getNombre()+"',"
	        		+ "'"+ u.getCorreo()+"',"
	        		+ "'"+ u.getContrasena()+"',"
	        		+"'" +"CC" + "',"
	        		+ "'"+u.getCedula()+"',"
	        		+ " 1 ,"
	        		+ "'activo')" ;
	        boolean numero = false;
	        try {
	            
	            if(conectar.ejecutar(sql)){
	                numero = true;
	            }
	        } catch (Exception e) {
	            System.out.println("Error al insertar(controlador USERS): " + e);
	            numero = true;
	        }
	        conectar.cerrar();
	        return numero;
			
		}

}
