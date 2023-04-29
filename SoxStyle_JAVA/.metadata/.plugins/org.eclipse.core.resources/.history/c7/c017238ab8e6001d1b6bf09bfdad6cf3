package controlador;
import modelo.Productos;
import vista.PaginaProductos;
import vista.AgregarProductos;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.awt.event.*;
import herramientas.*;
import sql.*;


public class PaginaProductosController implements ActionListener, KeyListener {
	
	Validaciones validar = new Validaciones();
	DefaultTableModel modelo = new DefaultTableModel();
	Conexion conectar = new Conexion();
	Consultas consultar = new Consultas();
	
	
	PaginaProductos vista;
	Productos p;
	
	
	public PaginaProductosController(PaginaProductos vista, Productos p ) {
		this.vista = vista;
		this.p=p;
		vista.btnAgregarProductos.addActionListener(this);
		botones();
		pruebacancelar();
		
	}
	
	
	
			public void actionPerformed(ActionEvent e) {
			
			if(e.getSource().equals(vista.btnAgregarProductos)) {
				
				try {
					JOptionPane.showMessageDialog(vista, "ir a vista de agregar productos");
					AgregarProductos ag = new AgregarProductos();
					new AgProductosController(ag);
					Ayudas.ActualizarPanel(ag, vista);
				} catch (Exception error) {
					System.out.println("Error al traer el panel de agregar productos " +error);
				}
				
				
			}
		
		}
	 
			public void botones () {
				vista.tblProductos.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
					       int filaSeleccionada = vista.tblProductos.getSelectedRow();
			               if (filaSeleccionada >= 0) {
			                   // Muestra los botones y los agrega al contenedor
			           		vista.btnEditar.setVisible(true);
							vista.btnEliminar.setVisible(true);
							vista.btnAgregarProductos.setVisible(true);
			                  
			               }
					}
				});
			}
			
			private void pruebacancelar() {
				vista.btnCancelar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(e.getSource().equals(vista.btnCancelar)) {
							
							vista.btnEditar.setVisible(false);
							vista.btnEliminar.setVisible(false);
							vista.btnCancelar.setVisible(false);
							
							
						}
						
					}
				});
		}

	
	
	
			public void datostabla () {
//				DefaultTableModel modeloo =consulta.listar1(); aqui se llama 
//				vista.tblProductos.setModel(modeloo);
			
			}

	
//	 estos son los paramentros que se le van a pasar a la tabla para poder que funciones el buscador
//	public void buscar (String buscar) {
//		DefaultTableModel modeloo =buscarProductos(buscar); Aqui se llama la consulta para buscar productos
//		vista.tblProductos.setModel(modeloo);
//	}
//	
//		//este metodo permite pasarle los metodos anteriores al jtexfield que es el que se encarga de buscar los datos de la tabla
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
//		}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



}
