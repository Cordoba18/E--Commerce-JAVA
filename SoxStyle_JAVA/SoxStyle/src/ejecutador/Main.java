package ejecutador;

import controlador.AdministradorController;
import controlador.AgProductosController;
import controlador.LoginController;
import vista.Administrador;
import vista.AgregarProductos;
import vista.Login;

public class Main {

	public static void main(String[] args) {
//		Administrador admin = new Administrador();
//		new AdministradorController(admin);
		
		AgregarProductos ap = new AgregarProductos();
		new AgProductosController(ap);
	}

}
