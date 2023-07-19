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
	
	Validaciones validar = new Validaciones();
	DefaultTableModel modelo = new DefaultTableModel();
	/* Conexion conectar = new Conexion(); */
	Consultas consultar = new Consultas();
	PaginaProductos vista;
	EditarProductos editarPanel;
	EdProductosController editar;
	Administrador a;
	Productos pd = new Productos();
	public PaginaProductosController(PaginaProductos vista, Administrador a) {
		this.vista = vista;
		this.a = a;
		this.vista.btnAgregarProductos.addActionListener(this);
		this.vista.btnEditar.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnCancelar.addActionListener(this);
		
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
			
		
		   public void inicializarEditarPanel() {
			   
			   	EditarProductos ed = new EditarProductos();
				
				//esto_es_una_ayuda_para_mandar_los_datos_de_un_jpanel
				//a_otro
				Ayudas.recibirDatos(ed, pd);
				new EdProductosController(ed);
				Ayudas.ActualizarPanel(ed, vista);
		        
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
								vista.txtid.setText(vista.tblProductos.getValueAt(filaSeleccionada, 0).toString());
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
		   
		   public void actionPerformed(ActionEvent e) {
				
				
				
					if(e.getSource().equals(vista.btnEditar)) {
						pd.getNombre();
						pd.getPrecio();
						pd.getDescuento();
						pd.getDescripcion();
					
						pd.getEstado();

						try {
							EditarProductos ed = new EditarProductos();
							
							//esto_es_una_ayuda_para_mandar_los_datos_de_un_jpanel
							//a_otro
							Ayudas.recibirDatos(ed, pd);
							new EdProductosController(ed);
							Ayudas.ActualizarPanel(ed, vista);
						} catch (Exception e2) {
							System.out.println("NO SE PUDO TRAER EL JPANEL " +e2);
						}
					}
		   else {
				
				if(e.getSource().equals(vista.btnEliminar)) {
					int filaSeleccionada = vista.tblProductos.getSelectedRow();
	                if (filaSeleccionada >= 0) {
	                    String id = vista.tblProductos.getValueAt(filaSeleccionada, 0).toString();
	                	pd.setId(Integer.parseInt(vista.txtid.getText()));
						pd.getId();
						
					
						consultar.eliminarProducto(pd);
						JOptionPane.showMessageDialog(vista, "SE DESACTIVO EL REGISTRO");
	                    
	                
	                } 
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
								 new AgProductosController(ag, a);
								   Ayudas.ActualizarPanel(ag, vista);
									
									 }
					}
				}
			}
					datostabla();
		   }


	
		    public void datostabla() {
		        DefaultTableModel modeloo = consultar.listar1();
		        vista.tblProductos.setModel(modeloo);
		    }

	
		    public void buscar(String buscar) {
		        if (buscar.isEmpty()) {
		            datostabla();
		        } else {
		            DefaultTableModel modeloo = consultar.buscarproductos(buscar);
		            vista.tblProductos.setModel(modeloo);
		        }
		    }
		    
		    public void buscadorr() {
		        vista.txtProductos.addKeyListener(new KeyAdapter() {
		            public void keyReleased(KeyEvent e) {
		                buscar(vista.txtProductos.getText());
		            }
		            
		            public void keyTyped(KeyEvent e) {
		                if (vista.txtProductos.getText().isEmpty()) {
		                    datostabla();
		                }
		            }
		        });
		    }

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
