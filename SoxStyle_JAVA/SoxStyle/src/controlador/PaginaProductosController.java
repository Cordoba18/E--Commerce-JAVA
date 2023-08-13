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

    Validaciones validar = new Validaciones(); // Objeto_para_realizar_validaciones
    DefaultTableModel modelo = new DefaultTableModel(); // Modelo_de_datos_para_la_tabla

    Consultas consultar = new Consultas(); // Objeto_para_realizar_consultas_a_la_base_de_datos
    PaginaProductos vista; // Referencia_a_la_vista_"PaginaProductos"
    EditarProductos editarPanel; // Referencia_a_la_vista_"EditarProductos"
    EdProductosController editar; // Controlador_para_la_vista_"EditarProductos"
    Administrador a; // Referencia_a_la_vista_"_Administrador"
    Productos pd = new Productos(); // Objeto_para_manejar_datos_de_productos

    // Constructor_que_recibe_las_vistas_"PaginaProductos"_y_"_Administrador"
    public PaginaProductosController(PaginaProductos vista, Administrador a) {
        this.vista = vista;
        this.a = a;
        // Agrega_el_controlador_como_oyente_a_los_botones_de_la_vista_"PaginaProductos"
        this.vista.btnAgregarProductos.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);
        // Llama_a_diferentes_métodos_para_configurar_y_cargar_datos_en_la_vista
        eventos();
        buscadorr();
        datostabla();
    }


	
	
			
		
		 
		   
		   
	
		// Método_para_configurar_los_eventos_asociados_a_la_tabla_de_productos.
		// Cuando_se_seleccione_una_fila_en_la_tabla,_se_mostrarán_ciertos_botones_y_se_obtendrán_los_valores_de_la_fila_seleccionada.
		public void eventos() {
		    // Añadir_un_adaptador_de_eventos_del_mouse_a_la_tabla_de_productos
		    vista.tblProductos.addMouseListener(new MouseAdapter() {

		        @Override
		        public void mouseReleased(MouseEvent e) {
		            // Verificar_si_la_fuente_del_evento_es_la_tabla_de_productos
		            if (e.getSource().equals(vista.tblProductos)) {
		                // Mostrar_los_botones_de_edición,_eliminación_y_cancelación
		                vista.btnEditar.setVisible(true);
		                vista.btnEliminar.setVisible(true);
		                vista.btnCancelar.setVisible(true);
		            }

		            // Obtener_el_índice_de_la_fila_seleccionada_en_la_tabla_de_productos
		            int filaSeleccionada = vista.tblProductos.getSelectedRow();
		            // Obtener_el_ID_del_producto_de_la_fila_seleccionada_y_almacenarlo_en_el_objeto_pd
		            pd.setId((Integer.parseInt(vista.tblProductos.getValueAt(filaSeleccionada, 0).toString())));
		            // Obtener_el_nombre_del_producto_de_la_fila_seleccionada_y_almacenarlo_en_el_objeto_pd
		            String nombre = (String) vista.tblProductos.getValueAt(filaSeleccionada, 1).toString();
		            pd.setNombre(nombre);
		            // Obtener_el_precio_del_producto_de_la_fila_seleccionada_y_almacenarlo_en_el_objeto_pd
		            String precio = (String) vista.tblProductos.getValueAt(filaSeleccionada, 2).toString();
		            pd.setPrecio(Integer.parseInt(precio));
		            // Obtener_el_descuento_del_producto_de_la_fila_seleccionada_y_almacenarlo_en_el_objeto_pd
		            String descuento = (String) vista.tblProductos.getValueAt(filaSeleccionada, 3).toString();
		            pd.setDescuento(Integer.parseInt(descuento));
		            // Obtener_la_descripción_del_producto_de_la_fila_seleccionada_y_almacenarla_en_el_objeto_pd
		            String descripcion = (String) vista.tblProductos.getValueAt(filaSeleccionada, 4).toString();
		            pd.setDescripcion(descripcion);
		            // Obtener_el_estado_del_producto_de_la_fila_seleccionada_y_almacenarlo_en_el_objeto_pd
		            String estado = (String) vista.tblProductos.getValueAt(filaSeleccionada, 9).toString();
		            pd.setEstado(String.valueOf(estado));
		        }
		    });
		}



		// Método_para_manejar_la_acción_del_botón "btnAgregarProductos"  
		   public void actionPerformed(ActionEvent e) {
		
				
					if(e.getSource().equals(vista.btnEditar)) {
					  	EditarProductos ed = new EditarProductos();
						
						//esto_es_una_ayuda_para_mandar_los_datos_de_un_jpanel_a_otro
					  	 new EdProductosController(ed, pd, a); // Crea_controlador_para_la vista "EditarProductos"
				         Ayudas.ActualizarPanel(ed, a.panelPrincipal); // Actualiza_el panel principal con_la vista "EditarProductos"
					}
		   else {
			// Desactiva_el producto_seleccionado_de la_base de_datos
				if(e.getSource().equals(vista.btnEliminar)) {
					
						consultar.eliminarProducto(pd);
						consultar.EliminarCarritos(String.valueOf(pd.getId()));
						consultar.EliminarListasDeseos(String.valueOf(pd.getId()));
						consultar.Monitorias(a.lbl_IdUser.getText(), "11", pd.getNombre());
						vista.btnCancelar.setVisible(false);
						vista.btnEditar.setVisible(false);
						vista.btnEliminar.setVisible(false);
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
								  new AgProductosController(ag, a); // Crea_controlador_para_la_vista_"AgregarProductos"
			                        Ayudas.ActualizarPanel(ag, vista); // Actualiza_el_panel_principal_con_la_vista_"AgregarProductos"
									
									 }
					}
				}
			}
					datostabla(); // Actualiza_los_datos_de_la_tabla_de_productos
		   }


		    // Método_para_cargar_los_datos_en_la_tabla_de_productos
		    public void datostabla() {
		        DefaultTableModel modeloo = consultar.listar1();
		        vista.tblProductos.setModel(modeloo);
		    }

		    // Método_para_buscar_productos_según_el_texto_ingresado_en_el_campo_de_búsqueda
		    public void buscar(String buscar) {
		        if (buscar.isEmpty()) {
		            datostabla();  // Si_no_hay_texto_de_búsqueda,_muestra_todos_los_productos
		        } else {
		            DefaultTableModel modeloo = consultar.buscarproductos(buscar);
		            vista.tblProductos.setModel(modeloo);  // Actualiza_la_tabla_conlos_resultados_de_la_búsqueda
		        }
		    }
		    
		    // Método_que_agrega_un_KeyListener_al_campo_de_búsqueda_de_productos
		    public void buscadorr() {
		        vista.txtProductos.addKeyListener(new KeyAdapter() {
		            public void keyReleased(KeyEvent e) {
		                buscar(vista.txtProductos.getText()); // Realiza_la_búsqueda_al_soltar_una_tecla_en_el_campo_de_búsqueda
		            }
		            
		            public void keyTyped(KeyEvent e) {
		                if (vista.txtProductos.getText().isEmpty()) {
		                    datostabla();  // Si_el_campo_de_búsqueda_está_vacío,_muestra_todos_los_productos
		                }
		            }
		        });
		    }
		    
   // Implementación_de_los_métodos_de_la_interfaz_KeyListener_(_vacíos,_no_se_utilizan)
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
