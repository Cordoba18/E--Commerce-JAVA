package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import herramientas.*;
import vista.Administrador;
import vista.PaginaProductos;
import vista.Vpdnuevos;

public class AdministradorController implements ActionListener {
	Administrador a;
	
	public AdministradorController(Administrador a) {
		this.a = a;
		a.btnProductos.addActionListener(this);
		eventos();
		iniciar();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(a.btnProductos)) {
			PaginaProductos pagProductos = new PaginaProductos();
			Ayudas.ActualizarPanel(pagProductos, a.panelPrincipal);
		}
		if (e.getSource().equals(a.btnProductosN)) {
			
		}
		if (e.getSource().equals(a.btnProductosA)) {
			
		}
		if (e.getSource().equals(a.btnSliders)) {
			
		}
		if (e.getSource().equals(a.btnEstadisticas)) {
			
		}
		if (e.getSource().equals(a.btnUsuariosR)) {
		}
	}

	public void eventos() {
	}

	public void iniciar() {
		a.setVisible(true);
	}

	
}
