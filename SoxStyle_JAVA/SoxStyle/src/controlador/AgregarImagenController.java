package controlador;

//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//import herramientas.Validaciones;
//import modelo.Productos;
//import sql.Conexion;
//import sql.Consultas;
//import vista.Agregar_imagen;

//public class AgregarImagenController {
//	
//	Agregar_imagen vista_imagen = new Agregar_imagen();
//	Productos p = new Productos();
//	DefaultTableModel modelo = new DefaultTableModel();
//	Conexion conectar = new Conexion();
//	Consultas consultar = new Consultas();
//	
//	public AgregarImagenController(Agregar_imagen vista, Productos p ) {
//		this.vista_imagen = vista;
//		this.p=p;
//		
//	}
//	
//	private void mostrardatos() {
//
//		Conexion conectar = new Conexion();
//		DefaultTableModel model = new DefaultTableModel();
//		model.addColumn("id");
//		model.addColumn("Imagen");
//		model.addColumn("Estado");
//		
//		vista_imagen.table.setModel(model); 
//		
//		ResultSet st; 
//		String [] registros = new String [3];
//		String sql= "SELECT * FROM BASE DE DATOS"; 
//		st = conectar.consultar(sql); 
//		
//	}
//	
//	  public DefaultTableModel buscar(String buscar){
//
//        
//        String []  Columnas = {"id","Imagen","Estado"};
//        
//        String [] registros = new String[3];
//        
//        DefaultTableModel modelo = new DefaultTableModel(null, Columnas);
//        
//        String sql = "SELECT * FROM ***** WHERE id LIKE '%"+buscar+"%' OR Imagen LIKE '%"+buscar+"%";
//        
//		Connection con = conectar.getConnection();
//        
//        PreparedStatement pst = null;
//        
//        ResultSet rs = null;                           
//        
//        try
//        {	
//       	
//        	con = conectar.getConnection();  
//	
//            
//            pst = con.prepareStatement(sql);                        
//            
//            rs = pst.executeQuery();
//            
//            while(rs.next())
//            {
//                
//                registros[0] = rs.getString("id");
//                
//                registros[1] = rs.getString("Imagen");
//               
//                registros[2] = rs.getString("Estado");          
//                
//                modelo.addRow(registros);
//    
//            }                      
//        }
//        catch(SQLException e)
//        {
//            
//            JOptionPane.showMessageDialog(null,"Error al conectar. "+e.getMessage());
//            
//        }
//        
//         return modelo;
//    }    
//	
//		public void buscar1(String buscar) {
//			DefaultTableModel modeloo =buscar(buscar);
//			vista_imagen.tabla.setModel(modeloo);
//}
//
//
//		public void txtBuscar() {
//		vista_imagen.txtBuscar.addKeyListener(new KeyAdapter(){
//	
//			public void keyReleased(KeyEvent e) {
//
//				buscar(vista_imagen.txtBuscar.getText());
//		}
//		
//});
//		}
//}
