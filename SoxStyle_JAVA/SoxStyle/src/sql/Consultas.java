package sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import modelo.Productos;
import modelo.Usuario;




public class Consultas {
	
	
// esta consulta es para buscar datos de la tabla	
	  public DefaultTableModel buscarproductos(String buscar) {
		  Conexion conexion = new Conexion();
		  	String []  nombresColumnas = {"id","nombre","precio","descuento","categoria", "descripcion", "estado"};//Indica el nombre de las columnas en la tabla
	        String [] registros = new String[7];
	        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
	        String sql = "SELECT * FROM productos WHERE nombre LIKE '%"+buscar+"%' OR precio LIKE '%"+buscar+"%'  OR descripcion LIKE '%"+buscar+"%' OR categoria LIKE '%"+buscar+"%'"; 
	      
	        ResultSet rs = null;                         

	        try {               
	        	  rs = conexion.consultar(sql);
	        	  if (rs.next()){
	        		  		
	        		      registros[0] = rs.getString("id");
          
	            		  registros[1] = rs.getString("nombre");
			                
			              registros[2] = rs.getString("precio");
			               
			              registros[3] = rs.getString("descuento");        
			                
			              registros[4] = rs.getString("categoria");  
			              
			              registros[5] = rs.getString("descripcion"); 

			              registros[6] = rs.getString("estado");  
			                
			                modelo.addRow(registros);
	            	}
	                                  
	        } catch(SQLException e) {            
	            System.out.println("Error al realizar la consulta: " + e.getMessage());           
	        } finally {
	            if (rs != null) {
				    conexion.cerrar();
				}
	        }
	        return modelo;
	    }
	  
	
	// consulta para llamar los datos de la tabla, ahi datos que se deben cambiar segun la base de datos y los datos de las tablas
	  public DefaultTableModel  listar1() {

			Conexion conectar = new Conexion();
			String []  nombresColumnas = { "nombre","precio","descuento","descripcion","calificacion", "n_p_calificaron", "categoria",  "id_user", "estado"};
		    String[] registros = new String[9];
		    DefaultTableModel model = new DefaultTableModel(null, nombresColumnas);
			ResultSet st; 
			String sql= "SELECT * FROM productos";
			st = conectar.consultar(sql); 
			
			try {
			
				
				
				while (st.next()) {
					registros[0]=st.getString(1);
					registros[1]=st.getString(2);
					registros[2]=st.getString(3);
					registros[3]=st.getString(4);
					registros[4]=st.getString(5);
					registros[5]=st.getString(6);
					registros[6]=st.getString(7);
					registros[7]=st.getString(8);
					registros[8]=st.getString(9);
					model.addRow(registros);
					
				}
				
			}catch(SQLException e) {            
	            System.out.println("Error al realizar la consulta: " + e.getMessage());           
	        } finally {
	            if (st != null) {
				    conectar.cerrar();
				}
	        }
	        return model;
		}
	
	public int idProductos(Productos p) {
		Conexion conectar = new Conexion();
		ResultSet rs; 
		String sql= "SELECT id FROM productos WHERE id = '" + p.getId() + "'";
		rs = conectar.consultar(sql);
		int id = 0;
		try {	
            if (rs.next()) {
                id = rs.getInt("id");
            }
			
		}catch(SQLException e) {            
            System.out.println("Error al realizar la consulta: " + e.getMessage());           
        } finally {
            if (rs != null) {
			    conectar.cerrar();
			}
        }
		return id;
	}
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
	
	 public void eliminarProducto(Productos p) {
		    Conexion conexion = new Conexion();
		    String sql = "UPDATE productos SET estado = 'desactivado' WHERE id = " + p.getId();
		    boolean ejecucionExitosa = conexion.ejecutar(sql);
		    if (ejecucionExitosa) {
		        System.out.println("Producto eliminado correctamente.");
		    } else {
		        System.out.println("No se encontró ningún producto con el ID especificado.");
		    }
		    conexion.cerrar();
		}

	  public boolean cambiarEstadoProducto(Productos p, String nuevoEstado) {
		    Conexion conexion = new Conexion();
		    String sql = "UPDATE productos SET estado = '" + nuevoEstado + "' WHERE id = " + p.getId();
		    return conexion.ejecutar(sql);
		}

}
