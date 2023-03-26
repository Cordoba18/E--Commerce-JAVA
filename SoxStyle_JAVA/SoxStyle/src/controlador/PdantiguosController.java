package controlador;

import java.awt.event.*;
import javax.swing.table.*;
import javax.swing.*;
import modelo.Productos;
import vista.*;
import herramientas.*;

public class PdantiguosController implements ActionListener, KeyListener{
	
	Administrador adm;
	Vpdantiguos vpdantiguos;
	Productos pd = new Productos();
	
	public PdantiguosController(Vpdantiguos vpdantiguos) {
		this.vpdantiguos = vpdantiguos;
		vpdantiguos.btnEditar.addActionListener(this);
		vpdantiguos.btnEliminar.addActionListener(this);
		vpdantiguos.btnCancelar.addActionListener(this);
		vpdantiguos.textBuscarPdAntiguos.addKeyListener(this); 
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
				
//				int row = vpdantiguos.tblPdantiguos.getSelectedRow();
//				
//				
//				vpdantiguos.textId.setText(vpdantiguos.tblPdantiguos.getValueAt(row, 0).toString());
//				
//				//ESTO_ES_PARA_CAPTURAR_LOS_DATOS_DE_LAS_CELDAS_INDICADAS_Y_PARSA_LA_NUEVA
//				//INFORMACION_AL_MODELO
//				String nombre = (String) vpdantiguos.tblPdantiguos.getValueAt(row, 1).toString();
//				pd.setNombre(nombre);
//				String precio = (String) vpdantiguos.tblPdantiguos.getValueAt(row, 2).toString();
//				pd.setPrecio(Integer.parseInt(precio));
//				String descuento = (String) vpdantiguos.tblPdantiguos.getValueAt(row, 3).toString();
//				pd.setDescuento(Integer.parseInt(descuento));
//				String categoria = (String) vpdantiguos.tblPdantiguos.getValueAt(row, 4).toString();
//				pd.setCategoria(Integer.parseInt(categoria));
//				String descripcion = (String) vpdantiguos.tblPdantiguos.getValueAt(row, 5).toString();
//				pd.setDescripcion(descripcion);
//				
//				
//				/* Esto_es_para_que_una_columna_dentro_de_la_tabla_se
//				 * vuelva_invisible_esto_lo_investigue_por_mi_parte_ya_que
//				 * en_los_wireframes_de_dicha_table_no_debia_aparecer_el
//				 * id_pero_si_no_llamaba_el_id_a_futuro_no_podria_indicar
//				 * que_dato_debe_editar_o_desactivar_entonces_lo_que_hago_aqui_es
//				 * simplemente_ocultar_la_columna_del_id_cuando_se_selecciona_la_fila
//				 * a_editar
//				 */
//				vpdantiguos.tblPdantiguos.getColumnModel().getColumn(0).setMinWidth(0);
//				vpdantiguos.tblPdantiguos.getColumnModel().getColumn(0).setMaxWidth(0);
//				vpdantiguos.tblPdantiguos.getColumnModel().getColumn(0).setWidth(0);
//				vpdantiguos.tblPdantiguos.getColumnModel().getColumn(0).setPreferredWidth(0);	
			}
		});
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//boton_de_editar_que_llamara_el_jpanel_de_editar
		if(e.getSource().equals(vpdantiguos.btnEditar)) {
		
			try {
				EditarProductos ed = new EditarProductos();
				new EdProductosController(ed);
				Ayudas.ActualizarPanel(ed, vpdantiguos);
			} catch (Exception e2) {
				System.out.println("NO SE PUDO TRAER EL JPANEL " +e2);
			}
			
			
		}
		
		//Desactivar_el_registro_de_la_tabla_pero_sin_eliminarlo_de_la_base_de_datos
		if(e.getSource().equals(vpdantiguos.btnEliminar)) {
			/*
			 * Estas_lineas_de_codigo_son_para_la_desactivacion_de_producto
			 * esta_comentado_por_el_momento
			 */
//			pd.setId(Integer.parseInt(vpdantiguos.textId.getText()));
//			pd.getId();
			
			//aqui_se_llamara_la_consulta_de_desactivar_el_registro
		}
		if(e.getSource().equals(vpdantiguos.btnCancelar)) {
			vpdantiguos.btnEditar.setVisible(false);
			vpdantiguos.btnEliminar.setVisible(false);
			vpdantiguos.btnCancelar.setVisible(false);
		}
		InfoTbala();
		}
		
	/*
	 * metodo_con_la_consulta_de_llamar_la_informacion
	 * para_mostrarla_en_la_tabla
	 */	 
	public void InfoTbala() {
		//funcion_para_mostrar_los_datos_en_la_tabla
		
	}

		

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		//Buscador_de_productos_en_la_tabla_productos
		if(e.getSource().equals(vpdantiguos.textBuscarPdAntiguos)) {
			String textoBusqueda = vpdantiguos.textBuscarPdAntiguos.getText();
			DefaultTableModel modeloTabla = (DefaultTableModel) vpdantiguos.tblPdantiguos.getModel();
			TableRowSorter<DefaultTableModel> filtro = new TableRowSorter<DefaultTableModel>(modeloTabla);
			vpdantiguos.tblPdantiguos.setRowSorter(filtro);
			filtro.setRowFilter(RowFilter.regexFilter(textoBusqueda));
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
