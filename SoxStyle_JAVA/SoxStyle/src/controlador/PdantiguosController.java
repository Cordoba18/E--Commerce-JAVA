package controlador;

import java.awt.event.*;

import javax.swing.table.*;
import javax.swing.*;
import modelo.Productos;
import vista.*;
import herramientas.*;
import sql.*;

public class PdantiguosController implements ActionListener, KeyListener{
	

	Vpdantiguos vpdantiguos;
	Productos pd = new Productos();
	Consultas consultar = new Consultas();
	Validaciones validar = new Validaciones();
	
	
	public PdantiguosController(Vpdantiguos vpdantiguos) {
		this.vpdantiguos = vpdantiguos;
		this.vpdantiguos.btnEditar.addActionListener(this);
		this.vpdantiguos.btnEliminar.addActionListener(this);
		this.vpdantiguos.btnCancelar.addActionListener(this);
		this.vpdantiguos.textBuscarPdAntiguos.addKeyListener(this); 
		
		eventos();
		InfoTbala();
	}
	
	public void eventos() {
		
		vpdantiguos.tblPdantiguos.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				
				if(e.getSource().equals(vpdantiguos.tblPdantiguos)) {
					vpdantiguos.btnEditar.setVisible(true);
					vpdantiguos.btnEliminar.setVisible(true);
					vpdantiguos.btnCancelar.setVisible(true);
				}
				
				/*
				 * Esta_parte_de_codigo_es_para_seleccionar_un_regsitro_y
				 * almacenarlo_mediante_el_modelo_para_despues_poderlo
				 * editar_en_el_jpanel_que_corresponda
				 */
				
				int row = vpdantiguos.tblPdantiguos.getSelectedRow();
				
				
				vpdantiguos.textId.setText(vpdantiguos.tblPdantiguos.getValueAt(row, 0).toString());
				
				//ESTO_ES_PARA_CAPTURAR_LOS_DATOS_DE_LAS_CELDAS_INDICADAS_Y_PARSA_LA_NUEVA
				//INFORMACION_AL_MODELO
				String nombre = (String) vpdantiguos.tblPdantiguos.getValueAt(row, 1).toString();
				pd.setNombre(nombre);
				String precio = (String) vpdantiguos.tblPdantiguos.getValueAt(row, 2).toString();
				pd.setPrecio(Integer.parseInt(precio));
				String descuento = (String) vpdantiguos.tblPdantiguos.getValueAt(row, 3).toString();
				pd.setDescuento(Integer.parseInt(descuento));
				String descripcion = (String) vpdantiguos.tblPdantiguos.getValueAt(row, 4).toString();
				pd.setDescripcion(descripcion);
				String estado = (String) vpdantiguos.tblPdantiguos.getValueAt(row, 7).toString();
				pd.setEstado(String.valueOf(estado));
				
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Boton_para_traer_el_jpanel_de_editar_el_registro_y_poder_hacer_su_edicion
		if(e.getSource().equals(vpdantiguos.btnEditar)) {
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
				Ayudas.ActualizarPanel(ed, vpdantiguos);
			} catch (Exception e2) {
				System.out.println("NO SE PUDO TRAER EL JPANEL " +e2);
			}
		}else {
			//Desactivar_el_registro_de_la_tabla_pero_sin_eliminarlo_de_la_base_de_datos
			if(e.getSource().equals(vpdantiguos.btnEliminar)) {
				pd.setId(Integer.parseInt(vpdantiguos.textId.getText()));
				pd.getId();
				
				/*
				 *Se llama la consulta de desactivar el regsitro 
				 */
				
				consultar.eliminarProducto(pd);
				JOptionPane.showMessageDialog(vpdantiguos, "SE DESACTIVO EL REGISTRO");
			}else {
				//Boton_cancelar_para_ocultar_los_dos_botones_Editar_y_Eliminar
				if(e.getSource().equals(vpdantiguos.btnCancelar)) {
					vpdantiguos.btnCancelar.setVisible(false);
					vpdantiguos.btnEditar.setVisible(false);
					vpdantiguos.btnEliminar.setVisible(false);
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
		//funcion_para_mostrar_los_datos_en_la_tabla
		consultar.mostrarpdAntiguos(vpdantiguos.tblPdantiguos);
		
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
		
		
		
		//Buscador_de_productos_en_la_tabla_productos_antiguos
		if(e.getSource().equals(vpdantiguos.textBuscarPdAntiguos)) {
			String textoBusqueda = vpdantiguos.textBuscarPdAntiguos.getText();

			/*
			 * Las_validaciones_para_el_campo_de_buscar_producto
			 */
			
			if(Validaciones.vacio(textoBusqueda)) {
				vpdantiguos.lblErrorA.setText("No se puede buscar 'CAMPO VACIO'");
				vpdantiguos.textBuscarPdAntiguos.setText("");
				vpdantiguos.lblErrorA.setVisible(true);
				
			}else
				if(Validaciones.SoloLetras(textoBusqueda)) {
						vpdantiguos.lblErrorA.setText("No permitido este tipo de caracteres");
						vpdantiguos.textBuscarPdAntiguos.setText("");
						vpdantiguos.lblErrorA.setVisible(true);
			
			//funciona_es_para_los_espacios_vacios
				}else
					if(textoBusqueda.isBlank()) {
						vpdantiguos.lblErrorA.setText("No permitido espacios en blanco");
						vpdantiguos.textBuscarPdAntiguos.setText("");
						vpdantiguos.lblErrorA.setVisible(true);
			}else {
				vpdantiguos.lblErrorA.setVisible(false);
				DefaultTableModel modeloTabla = (DefaultTableModel) vpdantiguos.tblPdantiguos.getModel();
				TableRowSorter<DefaultTableModel> filtro = new TableRowSorter<DefaultTableModel>(modeloTabla);
				vpdantiguos.tblPdantiguos.setRowSorter(filtro);
				filtro.setRowFilter(RowFilter.regexFilter(textoBusqueda));
			}
		}	
	}

}
