package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import herramientas.Validaciones;
import modelo.Productos;
import vista.AgregarProductos;

public class AgProductosController implements ActionListener {
	
	AgregarProductos ap = new AgregarProductos();
	Validaciones vali = new Validaciones();
	Productos produ = new Productos();
	

	public AgProductosController (AgregarProductos ap) {
		
		this.ap = ap;
		iniciar();
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource().equals(ap.btnAgregar)){
			
			String nompro = ap.txtNombre.getText();
			String preciopro = ap.txtPrecio.getText();
			String estadopro = ap.txtEstado.getText();
			String tallapro = ap.txtTalla.getText(); 	 	
			
			if(vali.vacio(nompro) || vali.vacio(preciopro) || vali.vacio(estadopro) || vali.vacio(tallapro)) {
				
				ap.lblError.setText("Hay campos vacio");
				ap.lblError.setVisible(true);
				
			}
		}
		
	}
	
	private void iniciar() {
		
		ap.setVisible(true);
		
	}
	
}
