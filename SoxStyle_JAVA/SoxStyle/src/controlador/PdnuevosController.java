package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import vista.Vpdnuevos;
import modelo.Productos;

public class PdnuevosController implements ActionListener{
	
	Vpdnuevos vpdnuevos;
	Productos pd = new Productos();
	
	public PdnuevosController(Vpdnuevos vpdnuevos) {
		this.vpdnuevos = vpdnuevos;
		vpdnuevos.btnEditar.addActionListener(this);
		vpdnuevos.btnBuscarN.addActionListener(this);
		vpdnuevos.btnEliminar.addActionListener(this);
	}
	public void eventos() {
		
			vpdnuevos.tblPdnuevos.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				int row = vpdnuevos.tblPdnuevos.getSelectedRow();
				
				
				vpdnuevos.textId.setText(vpdnuevos.tblPdnuevos.getValueAt(row, 0).toString());
				
				//ESTO_ES_PARA_CAPTURAR_LOS_DATOS_DE_LAS_CELDAS_INDICADAS_Y_PARSA_LA_NUEVA
				//INFORMACION_AL_MODELO
				String nombre = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 1).toString();
				pd.setNombre(nombre);
				String precio = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 2).toString();
				pd.setPrecio(Integer.parseInt(precio));
				String descuento = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 3).toString();
				pd.setDescuento(Integer.parseInt(descuento));
				String categoria = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 4).toString();
				pd.setCategoria(Integer.parseInt(categoria));
				String descripcion = (String) vpdnuevos.tblPdnuevos.getValueAt(row, 5).toString();
				pd.setDescripcion(descripcion);
				
				
				/* Esto_es_para_que_una_columna_dentro_de_la_tabla_se
				 * vuelva_invisible_esto_lo_investigue_por_mi_parte_ya_que
				 * en_los_wireframes_de_dicha_table_no_debia_aparecer_el
				 * id_pero_si_no_llamaba_el_id_a_futuro_no_podria_indicar
				 * que_dato_debe_editar_o_desactivar_entonces_lo_que_hago_aqui_es
				 * simplemente_ocultar_la_columna_del_id_cuando_se_selecciona_la_fila
				 * a_editar
				 */
				vpdnuevos.tblPdnuevos.getColumnModel().getColumn(0).setMinWidth(0);
				vpdnuevos.tblPdnuevos.getColumnModel().getColumn(0).setMaxWidth(0);
				vpdnuevos.tblPdnuevos.getColumnModel().getColumn(0).setWidth(0);
				vpdnuevos.tblPdnuevos.getColumnModel().getColumn(0).setPreferredWidth(0);	
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Buscador_de_productos_en_la_tabla_productos_nuevos
		if(e.getSource().equals(vpdnuevos.btnBuscarN)) {
			String textoBusqueda = vpdnuevos.textBuscarPdNuevos.getText();
			DefaultTableModel modeloTabla = (DefaultTableModel) vpdnuevos.tblPdnuevos.getModel();
			TableRowSorter<DefaultTableModel> filtro = new TableRowSorter<DefaultTableModel>(modeloTabla);
			vpdnuevos.tblPdnuevos.setRowSorter(filtro);
			filtro.setRowFilter(RowFilter.regexFilter(textoBusqueda));
			
		//Desactivar_el_registro_de_la_tabla_pero_sin_eliminarlo_de_la_base_de_datos
		}if(e.getSource().equals(vpdnuevos.btnEliminar)){
			pd.setId(Integer.parseInt(vpdnuevos.textId.getText()));
			pd.getId();
			//aqui_se_llamara_la_consulta_de_desactivar_usuario
		}
		InfoTbala();
		}
	public void InfoTbala() {
		//funcion_para_mostrar_los_datos_en_la_tabla
	}
}
