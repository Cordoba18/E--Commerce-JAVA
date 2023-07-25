package controlador;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;


import sql.*;
import herramientas.Ayudas;
import herramientas.Validaciones;
import vista.Administrador;
import vista.EditarProductos;
import vista.Vpdnuevos;
import modelo.Productos;

public class PdnuevosController implements ActionListener, KeyListener{
	
	Vpdnuevos vpdnuevos;
	Productos pd = new Productos();
	Consultas consultar = new Consultas();
	Validaciones validar = new Validaciones();
	Administrador a;
	
	public PdnuevosController(Vpdnuevos vpdnuevos, Administrador a) {
		this.vpdnuevos = vpdnuevos;
		this.a = a;
		this.vpdnuevos.btnEditar.addActionListener(this);
		this.vpdnuevos.btnEliminar.addActionListener(this);
		this.vpdnuevos.btnCancelar.addActionListener(this);
		this.vpdnuevos.textBuscarPdNuevos.addKeyListener(this);
				
		eventos();
		InfoTbala();
	}
	public void eventos() {
		
			vpdnuevos.tblPdnuevos.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			if(e.getSource().equals(vpdnuevos.tblPdnuevos)) {
				vpdnuevos.btnEditar.setVisible(true);
				vpdnuevos.btnEliminar.setVisible(true);
				vpdnuevos.btnCancelar.setVisible(true);
			}
			/*
			 * Esta_parte_de_codigo_es_para_seleccionar_un_regsitro_y
			 * almacenarlo_mediante_el_modelo_para_despues_poderlo
			 * editar_en_el_jpanel_que_corresponda
			 */
			
				int row = vpdnuevos.tblPdnuevos.getSelectedRow();
				
				
				pd.setId((Integer.parseInt(vpdnuevos.tblPdnuevos.getValueAt(row, 0).toString())));
				//ESTO_ES_PARA_CAPTURAR_LOS_DATOS_DE_LAS_CELDAS_INDICADAS_Y_PARSA_LA_NUEVA
				//INFORMACION_AL_MODELO
				String nombre = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 1).toString();
				pd.setNombre(nombre);
				String precio = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 2).toString();
				pd.setPrecio(Integer.parseInt(precio));
				String descuento = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 3).toString();
				pd.setDescuento(Integer.parseInt(descuento));
				String descripcion = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 4).toString();
				pd.setDescripcion(descripcion);
				String estado = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 7).toString();
				pd.setEstado(String.valueOf(estado));
				
				
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Boton_para_traer_el_jpanel_de_editar_el_registro_y_poder_hacer_su_edicion
			if(e.getSource().equals(vpdnuevos.btnEditar)) {
				EditarProductos ed = new EditarProductos();
				
				//esto_es_una_ayuda_para_mandar_los_datos_de_un_jpanel
				//a_otro
				new EdProductosController(ed, pd);
				Ayudas.ActualizarPanel(ed, a.panelPrincipal);
			}else {
				//Desactivar_el_registro_de_la_tabla_pero_sin_eliminarlo_de_la_base_de_datos
				if(e.getSource().equals(vpdnuevos.btnEliminar)) {
					
					consultar.eliminarProducto(pd);
					JOptionPane.showMessageDialog(vpdnuevos, "SE DESACTIVO EL REGISTRO");
				}else {
					//Boton_cancelar_para_ocultar_los_dos_botones_Editar_y_Eliminar
					if(e.getSource().equals(vpdnuevos.btnCancelar)) {
						vpdnuevos.btnCancelar.setVisible(false);
						vpdnuevos.btnEditar.setVisible(false);
						vpdnuevos.btnEliminar.setVisible(false);
					}
				}
			}
			/*llamo_una_funcion_la_cual_se_encarga_de_mostrar
			 *los_datos_en_la_tabla 
			 */
			InfoTbala();
	}
	
	
	
	
	
	
	
	/*
	 * metodo_con_la_consulta_de_llamar_la_informacion
	 * para_mostrarla_en_la_tabla
	 */
	public void InfoTbala() {
		//funcion_para_mostrar_los_datos_en_la_tabla_comentada_por_el_momento
		consultar.mostrarpdNuevos(vpdnuevos.tblPdnuevos);
	}
	
	
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
	
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		
		//Buscador_de_productos_en_la_tabla_productos_nuevos
		if(e.getSource().equals(vpdnuevos.textBuscarPdNuevos)) {
			String textoBusqueda = vpdnuevos.textBuscarPdNuevos.getText();

			/*
			 * Las_validaciones_para_el_campo_de_buscar_producto
			 */
			
			if(Validaciones.vacio(textoBusqueda)) {
				vpdnuevos.lblError.setText("No se puede buscar 'CAMPO VACIO'");
				vpdnuevos.textBuscarPdNuevos.setText("");
				vpdnuevos.lblError.setVisible(true);
				
			}else
				if(Validaciones.SoloLetras(textoBusqueda)) {
						vpdnuevos.lblError.setText("No permitido este tipo de caracteres");
						vpdnuevos.textBuscarPdNuevos.setText("");
						vpdnuevos.lblError.setVisible(true);
			
			//funciona_es_para_los_espacios_vacios
				}else
					if(textoBusqueda.isBlank()) {
						vpdnuevos.lblError.setText("No permitido espacios en blanco");
						vpdnuevos.textBuscarPdNuevos.setText("");
						vpdnuevos.lblError.setVisible(true);
			}else {
				vpdnuevos.lblError.setVisible(false);
				DefaultTableModel modeloTabla = (DefaultTableModel) vpdnuevos.tblPdnuevos.getModel();
				TableRowSorter<DefaultTableModel> filtro = new TableRowSorter<DefaultTableModel>(modeloTabla);
				vpdnuevos.tblPdnuevos.setRowSorter(filtro);
				filtro.setRowFilter(RowFilter.regexFilter(textoBusqueda));
			}
		}	
	}
}
