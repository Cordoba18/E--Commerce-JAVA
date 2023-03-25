package controlador;
import vista.PaginaProductos;
import herramientas.Validaciones;
import controlador.
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Productos;
import herramientas.Ayudas;
import sql.Conexion;
import sql.Consultas;
public class PaginaProductosController {
	
	Validaciones validar = new Validaciones();
	DefaultTableModel modelo = new DefaultTableModel();
	Conexion conectar = new Conexion();
	Consultas consultar = new Consultas();
	
	
	PaginaProductos vista;
	Productos p;
	
	
	public PaginaProductosController(PaginaProductos vista, Productos p ) {
		this.vista = vista;
		this.p=p;
		
	}
	
	
	//metodo para traer datos de la base de datos de la tabla productos
	private void mostrardatos() {

		Conexion conectar = new Conexion();
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nombre");
		model.addColumn("Precio");
		model.addColumn("Descuento");
		model.addColumn("Categoria");
		model.addColumn("Descripcion");
		model.addColumn("Imagen del producto");
		model.addColumn("Estado");

		vista.tblProductos.setModel(model); 
		//ResultSet st; 
		String [] registros = new String [7];
		String sql= "SELECT * FROM usuario"; //aqui se pine la base de datos que se necesite en este caso seria productos
//		st = conectar.consultar(sql); 
		
		
//		try {
//		
//			
//			
//			while (st.next()) {
//				registros[0]=st.getString(1);
//				registros[1]=st.getString(2);
//				registros[2]=st.getString(3);
//				registros[3]=st.getString(4);
//				registros[4]=st.getString(5);
//				registros[5]=st.getString(6);
//				registros[6]=st.getString(7);
//				model.addRow(registros);
				
//			}
//			vista.tblProductos.setModel(model);
//		}catch(Exception e) {
//			JOptionPane.showMessageDialog(null, "no se pudo mostar la tabla", "error en la operacion",JOptionPane.ERROR_MESSAGE);	
//		}finally {
//			
//		}
//	}

//	  public DefaultTableModel buscarProductos(String buscar)
//	    {
//
//	    
//	        
//	        String []  nombresColumnas = {"Nombre","Precio","Descuento","Categoria", "Descripcion", "Imagen del producto"};//Indica el nombre de las columnas en la tabla
//	        
//	        String [] registros = new String[7];
//	        
//	        DefaultTableModel modelo = new DefaultTableModel(null, nombresColumnas);
//	        
//	        String sql = "SELECT * FROM usuario WHERE Nombre LIKE '%"+buscar+"%' OR Precio LIKE '%"+buscar+"%'  OR Descripcion LIKE '%"+buscar+"%' 
//			OR Descuento LIKE '%"+buscar+"%'"; // aqui se ponen las columnas para buscar datos en especificos, con solo clikear una letra el jtrexfield busca datos automaticamente
//	        
//			Connection con = conectar.getConnection();
//	        
//	        PreparedStatement pst = null;
//	        
//	        ResultSet rs = null;                           
//	        
//	        try
//	        {	
//	        	
//	        	con = conectar.getConnection();  
//		         
//	            pst = con.prepareStatement(sql);                        
//	            
//	            rs = pst.executeQuery();
//	            
//	            while(rs.next())
//	            {
//	                
//	                registros[0] = rs.getString("Nombre");
//	                
//	                registros[1] = rs.getString("Precio");
//	               
//	                registros[2] = rs.getString("Descuento");        
//	                
//	                registros[3] = rs.getString("Categoria");   
//	                
//	                modelo.addRow(registros);
//	                
//	           
//	                
//	            }                      
//	        }
//	        catch(SQLException e)
//	        {
//	            
//	            JOptionPane.showMessageDialog(null,"Error al conectar. "+e.getMessage());
//	            
//	        }
//	        
//	         return modelo;
//	    }    
//	
//	// estos son los paramentros que se le van a psar a la tabla productos en este caso el metodo de arriba de buscarproductos
//	public void buscar (String buscar) {
//		DefaultTableModel modeloo =buscarProductos(buscar);
//		vista.tblProductos.setModel(modeloo);
//	}
//	
		//este metodo permite pasarle los metodos anteriores al jtexfield que es el que se encarga de buscar los datos de la tabla
//	public void buscadorr() {
//			vista.txtProductos.addKeyListener(new KeyAdapter(){
//		
//				public void keyReleased(KeyEvent e) {
//	
//					buscar(vista.txtProductos.getText());
//			
//   } 
//			
//});
		}



}
