package controlador;
import modelo.*;
import sql.Consultas;
import vista.*;
import herramientas.*;
import java.awt.event.*;


// Se_instancia_la_página_productos,_la_clase_de_consultas,_un_modelo_de_productos_y_usuario  
public class AdministradorController implements ActionListener, MouseListener{
	PaginaProductos v_PagProd = new PaginaProductos();
	Productos       m_Prod    = new Productos();
	Usuario         u = new Usuario();
	Consultas 		consulta  = new Consultas();
	Administrador   a;

	// Se_crea_el_constructor_de_la_clase_que_recibe_la_vista_asignada_y_un_modelo_de_usuario.
	// Se_crean_los_escuchadores_de_los_componentes,_y_se_ejecuta_la_página
	// Se_ejecutan_los_eventos_de_la_clase
	public AdministradorController(Administrador a, Usuario u) {
		this.u = u;
		this.a = a;
		
		a.btnProductos.   addActionListener(this);
		a.btnProductosN.  addActionListener(this);
		a.btnProductosA.  addActionListener(this);
		a.btnSliders.     addActionListener(this);
		a.btnEstadisticas.addActionListener(this);
		a.btnUsuariosR.   addActionListener(this);
		a.btnPedidos.	  addActionListener(this);
		a.lblImagen.      addMouseListener(this);
		a.lblCerrarSesion.addMouseListener(this);
		
		
		eventos();
	}
	
	
	/*_Las_funciones_de_este_método_incluyen:_mostrar_el_id_del_usuario_
	  _Repintar_panel_de_productos_en_la_página_principal
	  _Y_ejecutar_la_vista_asignada*/
	public void eventos() {
		a.lbl_IdUser.setText(String.valueOf(u.getId()));
		new PaginaProductosController(v_PagProd, a);
		Ayudas.ActualizarPanel(v_PagProd, a.panelPrincipal);
		a.setVisible(true);
	}
	
	
	// Acá_encontramos_las_acciones_que_realizan_los_componentes_cuando_el_usuario_interactua_con_ellos
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
			new SliderController(v_Slider,a);
			Ayudas.ActualizarPanel(v_Slider, a.panelPrincipal);
		}
		
		if (e.getSource().equals(a.btnEstadisticas)) {
			Estadisticas v_estad = new Estadisticas();
			new EstadisticasController(v_estad);
			Ayudas.ActualizarPanel(v_estad, a.panelPrincipal);
		}
		
		if (e.getSource().equals(a.btnUsuariosR)) {
			UsuariosRegistrados v_UserR = new UsuariosRegistrados();
			new UsuariosRegistradosController(v_UserR, a);
			Ayudas.ActualizarPanel(v_UserR, a.panelPrincipal);
		}
		if (e.getSource().equals(a.btnPedidos)) {
			Vpedidos vpedi = new Vpedidos();
			new PedidosCyD_Controller(vpedi,a);
			Ayudas.ActualizarPanel(vpedi, a.panelPrincipal);
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