package sql;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;




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

}
