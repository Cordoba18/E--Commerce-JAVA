package controlador;

import java.awt.event.*;
import herramientas.*;
import vista.*;

public class AdministradorController implements ActionListener {
	
	Administrador a;
	
	public AdministradorController(Administrador a) {
		this.a = a;
		a.btnProductos.   addActionListener(this);
		a.btnProductosN.  addActionListener(this);
		a.btnProductosA.  addActionListener(this);
		a.btnSliders.     addActionListener(this);
		a.btnEstadisticas.addActionListener(this);
		a.btnUsuariosR.   addActionListener(this);
		iniciar();
	}

	public void iniciar() {
		a.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(a.btnProductos)) {
			AgregarProductos v_AggProd = new AgregarProductos();
			Ayudas.ActualizarPanel(v_AggProd, a.panelPrincipal);
		}
		
		if (e.getSource().equals(a.btnProductosN)) {
			Vpdnuevos v_Pn = new Vpdnuevos();
			Ayudas.ActualizarPanel(v_Pn, a.panelPrincipal);
		}
		
		if (e.getSource().equals(a.btnProductosA)) {
			Vpdantiguos v_Pa = new Vpdantiguos();
			Ayudas.ActualizarPanel(v_Pa, a.panelPrincipal);
		}
		
		if (e.getSource().equals(a.btnSliders)) {
			Slider v_Slider = new Slider();
			Ayudas.ActualizarPanel(v_Slider, a.panelPrincipal);
		}
		
		if (e.getSource().equals(a.btnEstadisticas)) {
			Estadisticas v_estad = new Estadisticas();
			Ayudas.ActualizarPanel(v_estad, a.panelPrincipal);
		}
		
		if (e.getSource().equals(a.btnUsuariosR)) {
			UsuariosRegistrados v_UserR = new UsuariosRegistrados();
			Ayudas.ActualizarPanel(v_UserR, a.panelPrincipal);
		}
	}
}