package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import herramientas.Validaciones;
import modelo.Productos;
import vista.AgregarProductos;

public class AgProductosController implements ActionListener {
	
	AgregarProductos ap = new AgregarProductos();
	Validaciones vali = new Validaciones();
	Productos produ = new Productos();
	

	public AgProductosController (AgregarProductos ap) {
		this.ap = ap;
		ap.btnAgregar.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(ap.btnAgregar)){
			String nompro = ap.txtNombre.getText();
			String preciopro = ap.txtPrecio.getText();
			String estadopro = ap.txtEstado.getText();
			String tallapro = ap.txtTalla.getText(); 	 	
			
			if(Validaciones.vacio(nompro) || Validaciones.vacio(preciopro) || Validaciones.vacio(estadopro) || Validaciones.vacio(tallapro)) {
				
				ap.lblError.setText("Hay campos vacio");
				ap.lblError.setVisible(true);		
			}
		}
		
	}
}
