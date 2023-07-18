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
	
	public PaginaProductosController(PaginaProductos vista, Administrador a) {
		this.vista = vista;
		this.a = a;
		this.vista.btnAgregarProductos.addActionListener(this);
		botones();
		pruebacancelar();
		datostabla();
		
	}
	
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(vista.btnAgregarProductos)){
			 JOptionPane.showMessageDialog(null, "ir a vista de agregar productos");
				AgregarProductos ag = new AgregarProductos();
				 new AgProductosController(ag, a);
				   Ayudas.ActualizarPanel(ag, vista);
					
					 }
		         }
			
		
		   public void inicializarEditarPanel() {
			   
		        new EdProductosController(editarPanel);
		        Ayudas.ActualizarPanel(editarPanel, vista); // metodo de clase ayudas
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
				
				vista.btnEditar.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                int filaSeleccionada = vista.tblProductos.getSelectedRow();
		                if (filaSeleccionada >= 0) {
		                    // Obtener los valores de la fila seleccionada en la tabla
//		                    String id = vista.tblProductos.getValueAt(filaSeleccionada, 0).toString();
		                    String nombre = vista.tblProductos.getValueAt(filaSeleccionada, 0).toString();
		                    String precio = vista.tblProductos.getValueAt(filaSeleccionada, 1).toString();
		                    String descuento = vista.tblProductos.getValueAt(filaSeleccionada, 2).toString();
		                    String descripcion = vista.tblProductos.getValueAt(filaSeleccionada, 3).toString();
		                    String categoria = vista.tblProductos.getValueAt(filaSeleccionada, 4).toString();
		                    String estado = vista.tblProductos.getValueAt(filaSeleccionada, 5).toString();
		                    inicializarEditarPanel();
//		                    editarPanel.txtID.setText(id);
		                    editarPanel.txtNombre.setText(nombre);
		                    editarPanel.txtPrecio.setText(precio);
		                    editarPanel.txtDescuento.setText(descuento);
		                    editarPanel.textAreaDescripcion.setText(descripcion); 
		                    editarPanel.cbxCategoria.setSelectedItem(categoria);    
		                    editarPanel.txtEstado.setText(estado);
		             
		                }
		            }
		        });
//		        vista.btnEliminar.addActionListener(new ActionListener() {
//		            @Override
//		            public void actionPerformed(ActionEvent e) {
//		                int filaSeleccionada = vista.tblProductos.getSelectedRow();
//		                if (filaSeleccionada >= 0) {
//		                    String id = vista.tblProductos.getValueAt(filaSeleccionada, 0).toString();
//		                    String estado = vista.tblProductos.getValueAt(filaSeleccionada, 7).toString();
//		                    
//		                    // Verificar el estado actual del producto
//		                    if (estado.equals("activo")) {
//		                        // Realizar la consulta para cambiar el estado a "desactivado"
//		                       
//		                        boolean exito = consultar.cambiarEstadoProducto(id, "desactivado");
//		                        
//		                        if (exito) {
//		                            // Actualizar la tabla con los datos actualizados
//		                            DefaultTableModel modelo = consultar.listar1();
//		                            vista.tblProductos.setModel(modelo);
//		                            JOptionPane.showMessageDialog(null, "Producto desactivado correctamente");
//		                        } else {
//		                            JOptionPane.showMessageDialog(null, "Error al desactivar el producto");
//		                        }
//		                    } else {
//		                        JOptionPane.showMessageDialog(null, "El producto ya está desactivado");
//		                    }
//		                } else {
//		                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún producto");
//		                }
//		            }
//		        });
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
