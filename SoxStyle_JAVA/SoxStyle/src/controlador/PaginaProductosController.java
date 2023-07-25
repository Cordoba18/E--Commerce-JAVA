package controlador;
import modelo.Productos;


import vista.EditarProductos;
import vista.PaginaProductos;
import vista.Administrador;
import vista.AgregarProductos;
import javax.swing.table.DefaultTableModel;
import controlador.EdProductosController;

import javax.swing.JOptionPane;
import java.awt.event.*;
import herramientas.*;
import sql.*;



public class PaginaProductosController implements ActionListener, KeyListener {
	
	    Validaciones validar = new Validaciones(); // Objeto para realizar validaciones
	    DefaultTableModel modelo = new DefaultTableModel(); // Modelo de datos para la tabla
	  
	    Consultas consultar = new Consultas(); // Objeto para realizar consultas a la base de datos
	    PaginaProductos vista; // Referencia a la vista "PaginaProductos"
	    EditarProductos editarPanel; // Referencia a la vista "EditarProductos"
	    EdProductosController editar; // Controlador para la vista "EditarProductos"
	    Administrador a; // Referencia a la vista "Administrador"
	    Productos pd = new Productos(); // Objeto para manejar datos de productos
	    
	    // Constructor que recibe las vistas "PaginaProductos" y "Administrador"    
	public PaginaProductosController(PaginaProductos vista, Administrador a) {
		this.vista = vista;
		this.a = a;
		// Agrega el controlador como oyente a los botones de la vista "PaginaProductos"
		this.vista.btnAgregarProductos.addActionListener(this);
		this.vista.btnEditar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnCancelar.addActionListener(this);
	    // Llama a diferentes métodos para configurar y cargar datos en la vista
		eventos();
		buscadorr();
		datostabla();
		
	}
	
		public void actionPerformed2(ActionEvent e) {
			if(e.getSource().equals(vista.btnAgregarProductos)){
			 JOptionPane.showMessageDialog(null, "ir a vista de agregar productos");
				AgregarProductos ag = new AgregarProductos();
				 new AgProductosController(ag, a);
				   Ayudas.ActualizarPanel(ag, vista);
					
					 }
		         }
			
		
		 
		   
		   
		   public void eventos() {
				
			   vista.tblProductos.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseReleased(MouseEvent e) {
						if(e.getSource().equals(vista.tblProductos)) {
							vista.btnEditar.setVisible(true);
							vista.btnEliminar.setVisible(true);
							vista.btnCancelar.setVisible(true);
						}
			               
			             
			                    // Obtener los valores de la fila seleccionada en la tabla
								int filaSeleccionada = vista.tblProductos.getSelectedRow();
								pd.setId((Integer.parseInt(vista.tblProductos.getValueAt(filaSeleccionada, 0).toString())));
			                    String nombre = (String) vista.tblProductos.getValueAt(filaSeleccionada, 1).toString();
			                    pd.setNombre(nombre);
			                    String precio = (String)vista.tblProductos.getValueAt(filaSeleccionada, 2).toString();
			                    pd.setPrecio(Integer.parseInt(precio));
			                    String descuento = (String)vista.tblProductos.getValueAt(filaSeleccionada, 3).toString();
			                    pd.setDescuento(Integer.parseInt(descuento));
			                    String descripcion =(String) vista.tblProductos.getValueAt(filaSeleccionada, 4).toString();
			                    pd.setDescripcion(descripcion);
			                    
			                    String estado =(String) vista.tblProductos.getValueAt(filaSeleccionada, 9).toString();
			                    pd.setEstado(String.valueOf(estado));
			                 
			                  

			             
			                
					}
				});
			
		}
		// Método para manejar la acción del botón "btnAgregarProductos"  
		   public void actionPerformed(ActionEvent e) {
		
				
					if(e.getSource().equals(vista.btnEditar)) {
					  	EditarProductos ed = new EditarProductos();
						
						//esto_es_una_ayuda_para_mandar_los_datos_de_un_jpanel
						//a_otro
					  	 new EdProductosController(ed, pd, a); // Crea controlador para la vista "EditarProductos"
				         Ayudas.ActualizarPanel(ed, a.panelPrincipal); // Actualiza el panel principal con la vista "EditarProductos"
					}
		   else {
			// Desactiva el producto seleccionado de la base de datos
				if(e.getSource().equals(vista.btnEliminar)) {
					
						consultar.eliminarProducto(pd);
						consultar.Monitorias(a.lbl_IdUser.getText(), "11", pd.getNombre());
						JOptionPane.showMessageDialog(vista, "SE DESACTIVO EL REGISTRO");
	                   
				}else {
					//Boton_cancelar_para_ocultar_los_dos_botones_Editar_y_Eliminar
					if(e.getSource().equals(vista.btnCancelar)) {
						vista.btnCancelar.setVisible(false);
						vista.btnEditar.setVisible(false);
						vista.btnEliminar.setVisible(false);
					}else {
						if(e.getSource().equals(vista.btnAgregarProductos)){
							 JOptionPane.showMessageDialog(null, "ir a vista de agregar productos");
								AgregarProductos ag = new AgregarProductos();
								  new AgProductosController(ag, a); // Crea controlador para la vista "AgregarProductos"
			                        Ayudas.ActualizarPanel(ag, vista); // Actualiza el panel principal con la vista "AgregarProductos"
									
									 }
					}
				}
			}
					datostabla(); // Actualiza los datos de la tabla de productos
		   }


		    // Método para cargar los datos en la tabla de productos
		    public void datostabla() {
		        DefaultTableModel modeloo = consultar.listar1();
		        vista.tblProductos.setModel(modeloo);
		    }

		    // Método para buscar productos según el texto ingresado en el campo de búsqueda
		    public void buscar(String buscar) {
		        if (buscar.isEmpty()) {
		            datostabla();  // Si no hay texto de búsqueda, muestra todos los productos
		        } else {
		            DefaultTableModel modeloo = consultar.buscarproductos(buscar);
		            vista.tblProductos.setModel(modeloo);  // Actualiza la tabla con los resultados de la búsqueda
		        }
		    }
		    
		    // Método que agrega un KeyListener al campo de búsqueda de productos
		    public void buscadorr() {
		        vista.txtProductos.addKeyListener(new KeyAdapter() {
		            public void keyReleased(KeyEvent e) {
		                buscar(vista.txtProductos.getText()); // Realiza la búsqueda al soltar una tecla en el campo de búsqueda
		            }
		            
		            public void keyTyped(KeyEvent e) {
		                if (vista.txtProductos.getText().isEmpty()) {
		                    datostabla();  // Si el campo de búsqueda está vacío, muestra todos los productos
		                }
		            }
		        });
		    }
		    
   // Implementación de los métodos de la interfaz KeyListener (vacíos, no se utilizan)
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
