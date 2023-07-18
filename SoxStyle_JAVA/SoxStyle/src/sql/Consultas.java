package sql;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.MdlSlider;
import modelo.Productos;
import modelo.Usuario;
import java.io.File;
import java.io.IOException;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.mime.MultipartEntityBuilder;
//import org.apache.http.entity.mime.content.FileBody;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.util.EntityUtils;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;




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
			String []  nombresColumnas = {"id","nombre", "precio"	, "descuento" ,"descripcion" , "calificacion" ,"n_p_calificaron" ,"categoria", "id_user", "estados_id",	"created_at" ,"updated_at"};
		    String[] registros = new String[12];
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
					registros[9]=st.getString(10);
					registros[10]=st.getString(11);
					registros[11]=st.getString(12);
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
        String sql = "SELECT * FROM Users WHERE correo = '" + u.getCorreo()+ "'";
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
        String sql = "SELECT * FROM Users WHERE correo = '" + u.getCorreo()+ "'";
        ResultSet rs;
        boolean numero = false;
        try {
        	
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
                     u.setId(rs.getInt("id"));
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
        String sql = "SELECT * FROM Users WHERE correo = '" + u.getCorreo()+ "' AND estados_id =2";
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
        String sql = "SELECT * FROM Users WHERE correo = '" + u.getCorreo()+ "' AND id_rol = 1";
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
	        String sql = "INSERT INTO Users (nombre, correo,contrasena, identificacion, N_Identificacion, id_rol, estados_id) VALUES ("
	        		+ "'"+ u.getNombre()+"',"
	        		+ "'"+ u.getCorreo()+"',"
	        		+ "'"+ u.getContrasena()+"',"
	        		+"'" +"CC" + "',"
	        		+ "'"+u.getCedula()+"',"
	        		+ " 1 ,"
	        		+ "1)" ;
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
	
	//------ Parte de Productos-----------------------------------
	
	  public boolean insertarProductos(Productos producto) {	
			
	        Conexion conectar = new Conexion();
	        String sql = "INSERT INTO productos  (nombre, precio, descripcion, categoria, descuento, id_user , estados_id) VALUES ("
	        		+ "'"+ producto.getNombre() +"',"
	        		+ "'"+ producto.getPrecio() +"',"
	        		+ "'"+ producto.getDescripcion() +"',"
	        		+ "'"+ producto.getCategoria() +"',"
	        		+ "'"+ producto.getDescuento() +"',"
	        		+ ""+ producto.getId() +","
	        		+ "1)";
	        boolean numero = false;
	        try {
	            
	            if(conectar.ejecutar(sql)){
	                numero = true;
	            }
	        } catch (Exception e) {
	            System.out.println("Error al insertar(controlador user): " + e);
	        }
	        conectar.cerrar();
	        return numero;
			
		}
	  
		public boolean TraerCategoria(Productos producto) {
	        Conexion conectar = new Conexion();
	        String sql = "SELECT * FROM categorias WHERE categoria = '" + producto.getNombre_Categoria()+"'";
	        ResultSet rs;
	        boolean numero = false;
	        try {
	        	
	            rs = conectar.consultar(sql);
	            if(rs.next()){
	                    producto.setCategoria(rs.getInt("id"));
	                 }
	            else {
	            }
	        } catch (Exception e) {
	       System.out.println("Error en comparar clave(controlador user): " + e);
	        }
	        conectar.cerrar();
	        return numero;
	    }
		
		public boolean TraerId_Producto(Productos producto) {
	        Conexion conectar = new Conexion();
	        String sql = "SELECT * FROM productos where nombre = '"+producto.getNombre()+"'";
	        ResultSet rs;
	        boolean numero = false;
	        try {
	        	
	            rs = conectar.consultar(sql);
	            while(rs.next()){
	                    producto.setId_Producto(rs.getInt("id"));
	                 }
	        } catch (Exception e) {
	       System.out.println("Error en comparar clave(controlador user): " + e);
	        }
	        conectar.cerrar();
	        return numero;
	    }
	  public boolean insertarImagen(Productos producto) {	
			
	        Conexion conectar = new Conexion();
	        String sql = "INSERT INTO Imagenes_productos (imagen, id_producto, estados_id) VALUES ("
	        		+ "'"+ producto.getImagen() +"',"
	        		+ ""+ producto.getId_Producto() +","
	        		+ "1)";
	        boolean numero = false;
	        try {
	            
	            if(conectar.ejecutar(sql)){
	                numero = true;
	            }
	        } catch (Exception e) {
	            System.out.println("Error al insertar(controlador user): " + e);
	        }
	        conectar.cerrar();
	        return numero;
			
		}
	  
	  public static void comboBox(JComboBox<String> comboBox) {
	    	
	    	Connection con;
	    	Conexion cn = new Conexion();
	    	PreparedStatement ps;
	    	ResultSet rs;
			
			String sql = "SELECT categoria  FROM categorias";
			try {
				con = cn.getConnection();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					comboBox.addItem(rs.getString("categoria"));
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	  
	  //---------------------------------------------------------------------
	
	 public void eliminarProducto(Productos p) {
		    Conexion conexion = new Conexion();
		    String sql = "UPDATE productos SET estados_id=2 WHERE id = " + p.getId();
		    boolean ejecucionExitosa = conexion.ejecutar(sql);
		    if (ejecucionExitosa) {
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
	  //---------- consultas de la parte de productos Nuevos y Antiguos ------
	  
	  
		//consulta_para_mostrar_en_la_tableNuevos_solo_los_registros_nuevos
		public boolean mostrarpdNuevos(JTable tblPdnuevos) {
			
			Conexion conn = new Conexion();
			String sql = "SELECT*FROM productos WHERE estados_id=1 ORDER BY id DESC LIMIT 5";
			
			ResultSet st;  
			
			 
			DefaultTableModel model = new DefaultTableModel();
			
			model.addColumn("Id");
			model.addColumn("Nombre");
			model.addColumn("Precio");
			model.addColumn("Descuento");
			model.addColumn("Descripcion");
			model.addColumn("Categoria");
			model.addColumn("Id_User");
			model.addColumn("Estados_id");
			model.addColumn("Created_at");
			model.addColumn("Updated_at");		
			
			/*
			 * se_necesita_el_setModel_para_indicar_que_estos_campos
			 * y_los_datos_traidos_del_array_se_muestren_en_esa_JTable
			 * en_especifico
			 * sin_esto_no_apareceran_los_datos_y_no_sabra_ha_donde
			 * debe_enviar_la_informacion
			 */
			
			tblPdnuevos.setModel(model);

			 
			String[] info = new String[12];
			
			 boolean numero = false;
		        try {
		            st = conn.consultar(sql);
		            while(st.next()) {
		            	info[0]=st.getString(1);
		            	info[1]=st.getString(2);
		            	info[2]=st.getString(3);
		            	info[3]=st.getString(4);
		            	info[4]=st.getString(5);
		            	info[5]=st.getString(8);
		            	info[6]=st.getString(9);
		            	info[7]=st.getString(10);
		            	info[8]=st.getString(11);
		            	info[9]=st.getString(12);
		            	model.addRow(info);            	
		            }
		        } catch (Exception e) {
		            System.out.println("Error al llamar(No se pudo traer los datos): " + e);
		        }
		        conn.cerrar();
		        return numero; 
		}
		
		
		//consulta_para_mostrar_en_la_tableAntiguos_solo_los_registros
		//anteriores_a_los_nuevos
			public boolean mostrarpdAntiguos(JTable tblPdantiguos) {
				
				
				Conexion conn = new Conexion();
				String sql = "SELECT * FROM productos  WHERE estados_id=1 ORDER BY id DESC LIMIT 18446744073709551615 OFFSET 5";
				
				ResultSet st;  
				
				 
				DefaultTableModel model = new DefaultTableModel();
				
				model.addColumn("Id");
				model.addColumn("Nombre");
				model.addColumn("Precio");
				model.addColumn("Descuento");
				model.addColumn("Descripcion");
				model.addColumn("Categoria");
				model.addColumn("Id_User");
				model.addColumn("Estados_id");
				model.addColumn("Created_at");
				model.addColumn("Updated_at");
				
				
				/*
				 * se_necesita_el_setModel_para_indicar_que_estos_campos
				 * y_los_datos_traidos_del_array_se_muestren_en_esa_JTable
				 * en_especifico
				 * sin_esto_no_apareceran_los_datos_y_no_sabra_ha_donde
				 * debe_enviar_la_informacion
				 */
				tblPdantiguos.setModel(model);

				 
				String[] info = new String[12];
				
				 boolean numero = false;
			        try {
			            st = conn.consultar(sql);
			            while(st.next()) {
			            	info[0]=st.getString(1);
			            	info[1]=st.getString(2);
			            	info[2]=st.getString(3);
			            	info[3]=st.getString(4);
			            	info[4]=st.getString(5);
			            	info[5]=st.getString(8);
			            	info[6]=st.getString(9);
			            	info[7]=st.getString(10);
			            	info[8]=st.getString(11);
			            	info[9]=st.getString(12);
			            	model.addRow(info);	
			            }
			        } catch (Exception e) {
			            System.out.println("Error al llamar(No se pudo traer los datos): " + e);
			        }
			        conn.cerrar();
			        return numero; 
			}
			
			
			public boolean InsertarImagen(String imagePath) {
				
		        Conexion conectar = new Conexion();
		        String sql = "INSERT INTO imagenes_productos (imagen, estado) VALUES ("
		        		+ "'"+imagePath+"',"
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
			

			public boolean InsertarSlider(MdlSlider slider) {
				
		        Conexion conectar = new Conexion();
		        String sql = "INSERT INTO slider (nombre, info, imagen, estados_id) VALUES ("
		        		+ "'"+slider.getNombre()+"',"
		        		+ "'"+slider.getInfo()+"',"
		        		+ "'"+slider.getImagen()+"',"
		        		+ "1)" ;
		        
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
			
			
			public boolean mostrarImagen(JTable table) {
				Conexion conectar = new Conexion();
				String sql = "SELECT*FROM imagenes_productos";
				ResultSet st; 
				
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Id");
				model.addColumn("Imagen");
				model.addColumn("id_producto");
				model.addColumn("Estado");
				table.setModel(model); 
				
				String[] info = new String[4];
				 boolean numero = false;
			        try {
			            st = conectar.consultar(sql);
			            while(st.next()) {
			            	info[0]=st.getString(1);
			            	info[1]=st.getString(2);
			            	info[2]=st.getString(3);
			            	info[3]=st.getString(4);
			            	model.addRow(info);
			            }
			        } catch (Exception e) {
			            System.out.println("Error al llamar(No se pudo traer los datos): " + e);
			        }
			        conectar.cerrar();
			        return numero; 
			}

//			 public void saveImageToServer(File imageFile) {
//			        // Aquí debes proporcionar la ubicación del servidor donde deseas guardar la imagen
//			        String serverDirectory = "http://localhost/aquiimagen/";
//			        
//			        try {
//			            // Crear una instancia del cliente HTTP
//			            HttpClient httpClient = HttpClientBuilder.create().build();
//			            
//			            // Crear una solicitud HTTP POST
//			            HttpPost httpPost = new HttpPost(SERVER_UPLOAD_URL);
//			            
//			            // Construir el cuerpo de la solicitud con la imagen seleccionada
//			            MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
//			            entityBuilder.addPart("image", new FileBody(imageFile));
//			            HttpEntity entity = entityBuilder.build();
//			            httpPost.setEntity(entity);
//			            
//			            // Ejecutar la solicitud y obtener la respuesta
//			            HttpResponse response = httpClient.execute(httpPost);
//			            
//			            // Procesar la respuesta
//			            int statusCode = response.getStatusLine().getStatusCode();
//			            if (statusCode == 200) {
//			                JOptionPane.showMessageDialog(null, "La imagen se ha guardado en el servidor correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
//			            } else {
//			                JOptionPane.showMessageDialog(null, "Error al guardar la imagen en el servidor. Código de estado: " + statusCode, "Error", JOptionPane.ERROR_MESSAGE);
//			            }
//			            
//			            // Consumir y cerrar la entidad de respuesta
//			            EntityUtils.consume(response.getEntity());
//			        } catch (IOException e) {
//			            JOptionPane.showMessageDialog(null, "Error al guardar la imagen en el servidor: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//			        }
//			    }
			 
			
			public boolean MostrarSlider(JTable table) {
				Conexion conectar = new Conexion();
				String sql = "SELECT*FROM slider";
				ResultSet st; 
				
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Id");
				model.addColumn("NOMBRE");
				model.addColumn("INFORMACION");
				model.addColumn("IMAGEN");
				model.addColumn("ESTADO");
				table.setModel(model); 
				
				String[] info = new String[5];
				 boolean numero = false;
			        try {
			            st = conectar.consultar(sql);
			            while(st.next()) {
			            	info[0]=st.getString(1);
			            	info[1]=st.getString(2);
			            	info[2]=st.getString(3);
			            	info[3]=st.getString(4);
			            	info[4]=st.getString(5);
			            	model.addRow(info);
			            }
			        } catch (Exception e) {
			            System.out.println("Error al llamar(No se pudo traer los datos): " + e);
			        }
			        conectar.cerrar();
			        return numero; 
			}

}
