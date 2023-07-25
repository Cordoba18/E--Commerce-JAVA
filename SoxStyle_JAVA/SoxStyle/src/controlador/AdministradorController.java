package controlador;
import modelo.*;
import sql.Consultas;
import vista.*;
import herramientas.*;
import java.awt.event.*;
import java.util.Date;

public class AdministradorController implements ActionListener, MouseListener{
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
		a.lblImagen.      addMouseListener(this);
		a.lblCerrarSesion.addMouseListener(this);
		mostrarID();
		new PaginaProductosController(v_PagProd, a);
		Ayudas.ActualizarPanel(v_PagProd, a.panelPrincipal);
		iniciar();
	}

	public void mostrarID() {
		a.lbl_IdUser.setText(String.valueOf(u.getId()));
	}

	public void iniciar() {
		a.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(a.btnProductos)) {
			PaginaProductos v_PagProd = new PaginaProductos();
			new PaginaProductosController(v_PagProd, a);
			Ayudas.ActualizarPanel(v_PagProd, a.panelPrincipal);
		}
		
		if (e.getSource().equals(a.btnProductosN)) {
			Vpdnuevos v_Pn = new Vpdnuevos();
			new PdnuevosController(v_Pn, a);
			Ayudas.ActualizarPanel(v_Pn, a.panelPrincipal);
		}
		
		if (e.getSource().equals(a.btnProductosA)) {
			Vpdantiguos v_Pa = new Vpdantiguos();
			new PdantiguosController(v_Pa, a);
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
			new UsuariosRegistradosController(v_UserR, a);
			Ayudas.ActualizarPanel(v_UserR, a.panelPrincipal);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(a.lblImagen)) {
			Perfil_administrador V_P_A = new Perfil_administrador();
			new Perfil_administradorController(V_P_A, a);
			Ayudas.ActualizarPanel(V_P_A, a.panelPrincipal);
		}
		if(e.getSource().equals(a.lblCerrarSesion)) {
			Login l = new Login();
			new LoginController(l);
			a.dispose();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
