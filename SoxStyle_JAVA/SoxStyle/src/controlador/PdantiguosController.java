package controlador;

import java.awt.event.*;
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
		vpdantiguos.btnBuscarA.addActionListener(this);
		vpdantiguos.btnEditar.addActionListener(this);
		vpdantiguos.btnElimnar.addActionListener(this);
		vpdantiguos.textBuscarPdAntiguos.addKeyListener(this); 
	}
	
	public void eventos() {
		
		vpdantiguos.tblPdantiguos.addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				
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
		
		if(e.getSource().equals(vpdantiguos.btnBuscarA)) {
			JOptionPane.showMessageDialog(vpdantiguos, "probando");
			
		}
		if(e.getSource().equals(vpdantiguos.btnEditar)) {
		
			try {
				JOptionPane.showMessageDialog(vpdantiguos, "probando 2");
				EditarProductos ed = new EditarProductos();
				Ayudas.ActualizarPanel(ed, vpdantiguos);
			} catch (Exception e2) {
				System.out.println("NO SE PUDO TRAER EL JPANEL " +e2);
			}
			
			
		}
		if(e.getSource().equals(vpdantiguos.btnElimnar)) {
			JOptionPane.showMessageDialog(vpdantiguos, "probando 3");
		}
	}

		

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if(e.getSource().equals(vpdantiguos.textBuscarPdAntiguos)) {
			JOptionPane.showMessageDialog(vpdantiguos, "LO ESCUCHE");
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
