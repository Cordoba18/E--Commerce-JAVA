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
	
	
	PreparedStatement PS;
// esta consulta es para buscar datos de la tabla	
	  public DefaultTableModel buscarproductos(String buscar) {
		  Conexion conexion = new Conexion();
		  	String []  nombresColumnas = {"id","nombre", "precio"	, "descuento" ,"descripcion" , "calificacion" ,"n_p_calificaron" ,"categoria", "id_user", "estados_id",	"created_at" };//Indica el nombre de las columnas en la tabla
	        String [] registros = new String[11];
	        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
	        String sql = "SELECT * FROM productos WHERE nombre LIKE '%"+buscar+"%' OR precio LIKE '%"+buscar+"%'  OR descripcion LIKE '%"+buscar+"%' OR categoria LIKE '%"+buscar+"%' OR estados_id LIKE '%"+buscar+"%' "; 
	      
	        ResultSet rs = null;                         

	        try {               
	        	  rs = conexion.consultar(sql);
	        	  if (rs.next()){
	        		  		
	        		      registros[0] = rs.getString("id");
          
	            		  registros[1] = rs.getString("nombre");
			                
			              registros[2] = rs.getString("precio");
			              registros[3] = rs.getString("descuento");
			              registros[4] = rs.getString("descripcion");
			              registros[5] = rs.getString("calificacion");
			              registros[6] = rs.getString("n_p_calificaron");
			              registros[7] = rs.getString("categoria");
			              registros[8] = rs.getString("id_user");
			              registros[9] = rs.getString("estados_id");
			              registros[10] = rs.getString("created_at");
			            
			               
			             
			                
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
	
	public boolean TraerDatosUsuario(Usuario u) {
        Conexion conectar = new Conexion();
        String sql = "SELECT * "
        		+ "FROM Users "
        		+ "WHERE id = "+u.getId()+"";
        ResultSet rs;
        boolean numero = false;
        try {
            rs = conectar.consultar(sql);
            if(rs.next()){
                     numero = true;
                     u.setNombre(rs.getString("nombre"));
                     u.setCorreo(rs.getString("correo"));
                     u.setContrasena(rs.getString("contrasena"));
                     u.setTelefono(rs.getString("telefono"));
                     u.setDireccion(rs.getString("direccion"));
                     u.setCedula(rs.getString("N_identificacion"));
      
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
	
	  public static void CargarDepartamentos(JComboBox<String> comboBox) {
	    	
	    	Connection con;
	    	Conexion cn = new Conexion();
	    	PreparedStatement ps;
	    	ResultSet rs;
			comboBox.removeAllItems();
			String sql = "SELECT * FROM Departamento";
			try {
				con = cn.getConnection();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				comboBox.addItem("SELECCIONE UN DEPARTAMENTO");
				while(rs.next()) {
					comboBox.addItem(rs.getString("departamento"));
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	  
	  public static void CargarCiudades(JComboBox<String> comboBox, String departamento) {
	    	
	    	Connection con;
	    	Conexion cn = new Conexion();
	    	PreparedStatement ps;
	    	ResultSet rs;
	    	comboBox.removeAllItems();
			String sql = "SELECT c.ciudades FROM Ciudad c INNER JOIN Departamento D ON c.id_departamento = D.id"
					+ " WHERE D.departamento ='"+departamento+"'";
			try {
				con = cn.getConnection();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()) {
					comboBox.addItem(rs.getString("ciudades"));
		
				}
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	  
		public boolean TraerIdCiudad(Usuario u) {
	        Conexion conectar = new Conexion();
	        String sql = "SELECT * FROM Ciudad WHERE ciudades = '"+ u.getCiudad()+"'";
	        ResultSet rs;
	        boolean numero = false;
	        try {
	        	
	            rs = conectar.consultar(sql);
	            if(rs.next()){
	                    u.setId_ciudad(rs.getInt("id"));
	                 }
	            else {
	            }
	        } catch (Exception e) {
	       System.out.println("Error en comparar clave(controlador user): " + e);
	        }
	        conectar.cerrar();
	        return numero;
	    }
		
		
		public int EditarUsuario(Usuario u) {
			
		    Conexion conectar = new Conexion();
		    String sql;
		 
		    if (u.getId_ciudad() == 0) {
		    	sql = "UPDATE `Users` SET `nombre`='"+u.getNombre()+"',`telefono`='"+u.getTelefono()+"',`direccion`='"+u.getDireccion()+"',`N_Identificacion`='"+u.getCedula()+"'"
			    		+ " WHERE id = "+u.getId()+"";
			} else {
				sql = "UPDATE `Users` SET `nombre`='"+u.getNombre()+"',`telefono`='"+u.getTelefono()+"',`direccion`='"+u.getDireccion()+"',`N_Identificacion`='"+u.getCedula()+"',`id_ciudad`="+u.getId_ciudad()+""
			    		+ " WHERE id = "+u.getId()+"";
			}
		    int rs = 0;
		    try {
		        PS = conectar.getConnection().prepareStatement(sql);
		        rs = PS.executeUpdate();
		        
		    } catch (Exception e) {
		   System.out.println("Error en comparar clave(controlador Users): " + e);
		    }finally {
		    	PS = null;
		    	conectar.cerrar();
			}
		    
		    return rs;
		}
		
public int EliminarImagen(Productos p) {
			
		    Conexion conectar = new Conexion();
		    String sql;
		 
				sql = "UPDATE `Imagenes_productos` SET `estados_id`=2"
			    		+ " WHERE id = "+p.getId_imagen()+"";
			
		    int rs = 0;
		    try {
		        PS = conectar.getConnection().prepareStatement(sql);
		        rs = PS.executeUpdate();
		        
		    } catch (Exception e) {
		   System.out.println("Error en comparar clave(controlador Users): " + e);
		    }finally {
		    	PS = null;
		    	conectar.cerrar();
			}
		    
		    return rs;
		}
			
		public int EditarSlider(MdlSlider slider) {
			
		    Conexion conectar = new Conexion();
		    String sql;
		 
		    if (slider.getImagen().equals("")) {
		    	sql = "UPDATE `slider` SET `nombre`='"+slider.getNombre()+"',`info`='"+slider.getInfo()+"'"
			    		+ " WHERE id = "+slider.getId()+"";
			} else {
				sql = "UPDATE `slider` SET `nombre`='"+slider.getNombre()+"',`info`='"+slider.getInfo()+"' ,`imagen`='"+slider.getImagen()+"'"
			    		+ " WHERE id = "+slider.getId()+"";
			}
		    int rs = 0;
		    try {
		        PS = conectar.getConnection().prepareStatement(sql);
		        rs = PS.executeUpdate();
		        
		    } catch (Exception e) {
		   System.out.println("Error en comparar clave(controlador Slider): " + e);
		    }finally {
		    	PS = null;
		    	conectar.cerrar();
			}
		    
		    return rs;
		}
	public int EliminarSlider(MdlSlider slider) {
			
		    Conexion conectar = new Conexion();
		    String sql= "UPDATE `slider` SET `estados_id`=2"
			    		+ " WHERE id = "+slider.getId()+"";
		    int rs = 0;
		    try {
		        PS = conectar.getConnection().prepareStatement(sql);
		        rs = PS.executeUpdate();
		        
		    } catch (Exception e) {
		   System.out.println("Error en comparar clave(controlador Slider): " + e);
		    }finally {
		    	PS = null;
		    	conectar.cerrar();
			}
		    
		    return rs;
		}
		
		
public int EditarContraseña(String contrasena, String id) {
			
		    Conexion conectar = new Conexion();
		    String sql;
		 
				sql = "UPDATE `Users` SET `contrasena`='"+contrasena+"'"
			    		+ " WHERE id = "+id+"";
			
		    int rs = 0;
		    try {
		        PS = conectar.getConnection().prepareStatement(sql);
		        rs = PS.executeUpdate();
		        
		    } catch (Exception e) {
		   System.out.println("Error en comparar clave(controlador Users): " + e);
		    }finally {
		    	PS = null;
		    	conectar.cerrar();
			}
		    
		    return rs;
		}
			
		

public boolean BuscarUsuarios(JTable table, String busqueda, String id) {
	Conexion conectar = new Conexion();
	String sql = "";
	try {
		int busqueda_numerica = Integer.parseInt(busqueda);
		sql = "SELECT*FROM Users WHERE id <> "+id+" AND id="+busqueda_numerica+" OR N_Identificacion="+busqueda_numerica+"";
	} catch (Exception e) {
		if (busqueda.equals("")) {
			sql = "SELECT*FROM Users WHERE id <> "+id+"";
		}else {
			sql = "SELECT*FROM Users WHERE id <> "+id+" AND nombre LIKE '%"+busqueda+"%' OR correo LIKE '%"+busqueda+"%'";
		}
	}
	
	
	ResultSet st; 
	
	DefaultTableModel model = new DefaultTableModel();
	model.addColumn("Id");
	model.addColumn("NOMBRE");
	model.addColumn("CORREO");
	model.addColumn("FECHA NACIMIENTO");
	model.addColumn("TELEFONO");
	model.addColumn("DIRECCION");
	model.addColumn("ID_ROL");
	model.addColumn("IDENTIFICACION");
	model.addColumn("N_IDENTIFICACION");
	model.addColumn("ID_CIUDAD");
	model.addColumn("ESTADOS_ID");
	table.setModel(model); 
	
	String[] info = new String[11];
	 boolean numero = false;
        try {
            st = conectar.consultar(sql);
            while(st.next()) {
            	info[0]=st.getString(1);
            	info[1]=st.getString(2);
            	info[2]=st.getString(3);
            	info[3]=st.getString(5);
            	info[4]=st.getString(6);
            	info[5]=st.getString(7);
            	info[6]=st.getString(9);
            	info[7]=st.getString(10);
            	info[8]=st.getString(11);
            	info[9]=st.getString(12);
            	info[10]=st.getString(13);
            	model.addRow(info);
            }
        } catch (Exception e) {
            System.out.println("Error al llamar(No se pudo traer los datos): " + e);
        }
        conectar.cerrar();
        return numero; 
}


public int EliminarActivarUsuario(String id, String peticion) {
	
    Conexion conectar = new Conexion();
    String sql= "UPDATE `Users` SET `estados_id`="+peticion+""
	    		+ " WHERE id = "+id+"";
	
    int rs = 0;
    try {
        PS = conectar.getConnection().prepareStatement(sql);
        rs = PS.executeUpdate();
        
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador Users): " + e);
    }finally {
    	PS = null;
    	conectar.cerrar();
	}
    
    return rs;
}
	
	//------ Parte de Productos-----------------------------------
	
public boolean TraerDatosProducto(Productos p) {
    Conexion conectar = new Conexion();
    String sql = "SELECT * "
    		+ "FROM productos "
    		+ "WHERE id = "+p.getId()+"";
    ResultSet rs;
    boolean numero = false;
    try {
        rs = conectar.consultar(sql);
        if(rs.next()){
                 numero = true;
                 p.setNombre(rs.getString("nombre"));
                 p.setDescripcion(rs.getString("descripcion"));
                 p.setPrecio(Integer.parseInt(rs.getString("precio")));
                 p.setDescuento(Integer.parseInt(rs.getString("descuento")));
                
  
             }
        else {
        }
    } catch (Exception e) {
   System.out.println("Error en comparar clave(controlador user): " + e);
    }
    conectar.cerrar();
    return numero;
}

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
		public int EditarProducto(Productos p, boolean categoria) {
			
		    Conexion conectar = new Conexion();
		    String sql;
		    if (categoria == true) {
		    	sql= "UPDATE `productos` SET `nombre`='"+p.getNombre()+"',`precio`='"+p.getPrecio()+"',`descuento`='"+p.getDescuento()+"',`descripcion`='"+p.getDescripcion()+"',`categoria`='"+p.getCategoria()+"'"
			    		+ " WHERE id = "+p.getId()+"";
			} else {
				sql= "UPDATE `productos` SET `nombre`='"+p.getNombre()+"',`precio`='"+p.getPrecio()+"',`descuento`='"+p.getDescuento()+"',`descripcion`='"+p.getDescripcion()+"'"
			    		+ " WHERE id = "+p.getId()+"";
			}
		    int rs = 0;
		    try {
		        PS = conectar.getConnection().prepareStatement(sql);
		        rs = PS.executeUpdate();
		        
		    } catch (Exception e) {
		   System.out.println("Error en comparar clave(controlador Users): " + e);
		    }finally {
		    	PS = null;
		    	conectar.cerrar();
			}
		    
		    return rs;
		}

		public boolean TraerImagenPrincipal(Productos producto) {
	        Conexion conectar = new Conexion();
	        String sql = "SELECT * FROM Imagenes_productos where id_producto = "+producto.getId()+"";
	        ResultSet rs;
	        boolean numero = false;
	        try {
	        	
	            rs = conectar.consultar(sql);
	            if(rs.next()){
	                    producto.setId_imagen(rs.getString("id"));
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
	  
	  public int EditarImagen(Productos p) {
			
		    Conexion conectar = new Conexion();
		    String sql="UPDATE `Imagenes_productos` SET `imagen`='"+p.getImagen()+"'"
			    		+ " WHERE id = "+p.getId_imagen()+"";
			
		    int rs = 0;
		    try {
		        PS = conectar.getConnection().prepareStatement(sql);
		        rs = PS.executeUpdate();
		        
		    } catch (Exception e) {
		   System.out.println("Error en comparar clave(controlador Users): " + e);
		    }finally {
		    	PS = null;
		    	conectar.cerrar();
			}
		    
		    return rs;
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
	  
	  
	  public boolean CargarTablaImagenes(JTable table, Productos p) {
			Conexion conectar = new Conexion();
			String sql = "SELECT*FROM Imagenes_productos WHERE id_producto="+p.getId()+" AND estados_id=1";
			ResultSet st; 
			
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("Id");
			model.addColumn("IMAGEN");
			table.setModel(model); 
			int contador = 0;
			String[] info = new String[2];
			 boolean numero = false;
		        try {
		            st = conectar.consultar(sql);
		            while(st.next()) {
		            	if(contador>0) {
		            		info[0]=st.getString(1);
			            	info[1]=st.getString(2);
			            	model.addRow(info);
		            	}
		            	contador= contador+1;
	                    p.setCantidad(contador);
		            	
		            }
		        } catch (Exception e) {
		            System.out.println("Error al llamar(No se pudo traer los datos): " + e);
		        }
		        conectar.cerrar();
		        return numero; 
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

			 
			String[] info = new String[10];
			
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
				String sql = "SELECT * FROM productos  WHERE estados_id=1";
				
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

				 
				String[] info = new String[10];
				int contador = 0;
				 boolean numero = false;
			        try {
			            st = conn.consultar(sql);
			            while(st.next()) {
			            	
			            	if(contador < 6) {
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
			            	contador = contador + 1;
			            	}
			            }
			        } catch (Exception e) {
			            System.out.println("Error al llamar(No se pudo traer los datos): " + e);
			        }
			        conn.cerrar();
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
				String sql = "SELECT*FROM slider WHERE estados_id=1";
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
			
				public boolean actualizarColores(Productos ct) {
				
				
				
		        Conexion conectar = new Conexion();
		        String sql ="UPDATE colores SET color='"+ct.getColor()+
		        		"' WHERE id='"+ct.getId_color()+"'";
		        		
		        boolean actu = false;
		        try {
		        

		            if(conectar.ejecutar(sql)){
		                actu = true;
		            }
		        } catch (Exception e) {
		            System.out.println("Error al insertar(controlador user): " + e);
		        }
		        conectar.cerrar();
		        return actu;
		}
			
			public boolean actualizarTallas(Productos ct) {
		        Conexion conectar = new Conexion();
		        String sql ="UPDATE tallas SET cantidad="+ct.getCantidad()+
		        		" , talla='"+ct.getTalla()+
		        		"' WHERE id="+ct.getId_talla()+"";
		        		
		        boolean actu = false;
		        try {
		        	

		            if(conectar.ejecutar(sql)){
		                actu = true;
		            }
		        } catch (Exception e) {
		            System.out.println("Error al insertar(controlador user): " + e);
		        }
		        conectar.cerrar();
		        return actu;
		}
			
			public boolean EliminarTalla(Productos ct) {
		        Conexion conectar = new Conexion();
		        String sql ="UPDATE tallas SET estados_id=2"
		        		+" WHERE id='"+ct.getId_talla()+"'";
		        		
		        boolean actu = false;
		        try {
		    

		            if(conectar.ejecutar(sql)){
		                actu = true;
		            }
		        } catch (Exception e) {
		            System.out.println("Error al insertar(controlador user): " + e);
		        }
		        conectar.cerrar();
		        return actu;
		}
			
			public boolean EliminarColor(Productos ct) {
		        Conexion conectar = new Conexion();
		        String sql ="UPDATE colores SET estados_id=2"
		        		
		        		+" WHERE id='"+ct.getId_color()+"'";
		        		
		        boolean actu = false;
		        try {
		        	

		            if(conectar.ejecutar(sql)){
		                actu = true;
		            }
		        } catch (Exception e) {
		            System.out.println("Error al insertar(controlador user): " + e);
		        }
		        conectar.cerrar();
		        return actu;
		}
			
			public boolean insertarTalla(Productos ct) {	
				
		        Conexion conectar = new Conexion();
		        String sql = "INSERT INTO tallas (cantidad, talla, id_producto, estados_id) VALUES ("
		                + "'" + ct.getCantidad() + "',"
		                + "'" + ct.getTalla() + "',"
		                + "" + ct.getId_Producto() + ","
		                + "1)";
		        
		        boolean numero = false;
		        try {
		            
		            if(conectar.ejecutar(sql)){
		                numero = true;
		            }
		        } catch (Exception e) {
		            System.out.println("Error al insertar: " + e);
		        }
		        conectar.cerrar();
		        return numero;
				
			}

			public boolean insertarColor(Productos ct) {	
				
		        Conexion conectar = new Conexion();
		        String sql = "INSERT INTO colores (Color,id_producto, estados_id) VALUES ("
		                + "'" + ct.getColor() + "',"
		                + "" + ct.getId_Producto() + ","
		                + "1)";
		        
		        boolean numero = false;
		        try {
		            
		            if(conectar.ejecutar(sql)){
		                numero = true;
		            }
		        } catch (Exception e) {
		            System.out.println("Error al insertar: " + e);
		        }
		        conectar.cerrar();
		        return numero;
				
			}	
			
	
			public boolean CargarColores(JTable table,Productos p) {
				Conexion conectar = new Conexion();
				String sql = "SELECT*FROM colores where id_producto="+p.getId_Producto()+" AND estados_id=1";
				ResultSet st; 
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Id");
				model.addColumn("COLOR");
				table.setModel(model); 
				
				String[] info = new String[2];
				 boolean numero = false;
			        try {
			            st = conectar.consultar(sql);
			            while(st.next()) {
			            	info[0]=st.getString(1);
			            	info[1]=st.getString(2);
			            
			            	model.addRow(info);
			            }
			        } catch (Exception e) {
			            System.out.println("Error al llamar(No se pudo traer los datos): " + e);
			        }
			        conectar.cerrar();
			        return numero; 
			}
			

			public boolean CargarTallas(JTable table,Productos p) {
				Conexion conectar = new Conexion();
				String sql = "SELECT*FROM tallas where id_producto="+p.getId_Producto()+" AND estados_id=1";
				ResultSet st; 
				DefaultTableModel model = new DefaultTableModel();
				model.addColumn("Id");
				model.addColumn("CANTIDAD");
				model.addColumn("TALLA");
				table.setModel(model); 
				
				String[] info = new String[3];
				 boolean numero = false;
			        try {
			            st = conectar.consultar(sql);
			            while(st.next()) {
			            	info[0]=st.getString(1);
			            	info[1]=st.getString(2);
			            	info[2]=st.getString(3);
			            	model.addRow(info);
			            }
			        } catch (Exception e) {
			            System.out.println("Error al llamar(No se pudo traer los datos): " + e);
			        }
			        conectar.cerrar();
			        return numero; 
			}


		

}
