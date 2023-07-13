package controlador;
import modelo.*;
import sql.Consultas;
import vista.*;
import herramientas.*;
import java.awt.event.*;

public class AdministradorController implements ActionListener {
	PaginaProductos v_PagProd = new PaginaProductos();
	Productos       m_Prod    = new Productos();
	Usuario         u = new Usuario();
	Consultas 		consulta  = new Consultas();
	Administrador   a;

	
	public AdministradorController(Administrador a, Usuario u) {
		this.u = u;
		this.a = a;
		
		a.btnProductos.   addActionListener(this);
		a.btnProductosN.  addActionListener(this);
		a.btnProductosA.  addActionListener(this);
		a.btnSliders.     addActionListener(this);
		a.btnEstadisticas.addActionListener(this);
		a.btnUsuariosR.   addActionListener(this);
		
		mostrarID();
		new PaginaProductosController(v_PagProd);
		Ayudas.ActualizarPanel(v_PagProd, a.panelPrincipal);
		iniciar();
	}

	public void mostrarID() {
		a.lbl_IdProd.setText(String.valueOf(u.getId()));
	}

	public void iniciar() {
		a.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(a.btnProductos)) {
			
			Ayudas.ActualizarPanel(v_PagProd, a.panelPrincipal);
		}
		
		if (e.getSource().equals(a.btnProductosN)) {
			Vpdnuevos v_Pn = new Vpdnuevos();
//			new PdnuevosController(v_Pn);
			Ayudas.ActualizarPanel(v_Pn, a.panelPrincipal);
		}
		
		if (e.getSource().equals(a.btnProductosA)) {
			Vpdantiguos v_Pa = new Vpdantiguos();
//			new PdantiguosController(v_Pa);
			Ayudas.ActualizarPanel(v_Pa, a.panelPrincipal);
		}
		
		if (e.getSource().equals(a.btnSliders)) {
			Slider v_Slider = new Slider();
			new SliderController(v_Slider);
			Ayudas.ActualizarPanel(v_Slider, a.panelPrincipal);
		}
		
		if (e.getSource().equals(a.btnEstadisticas)) {
			Estadisticas v_estad = new Estadisticas();
			//new EstadisticasController(v_estad);
			Ayudas.ActualizarPanel(v_estad, a.panelPrincipal);
		}
		
		if (e.getSource().equals(a.btnUsuariosR)) {
			UsuariosRegistrados v_UserR = new UsuariosRegistrados();
			new UsuariosRegistradosController(v_UserR);
			Ayudas.ActualizarPanel(v_UserR, a.panelPrincipal);
		}
	}
}
