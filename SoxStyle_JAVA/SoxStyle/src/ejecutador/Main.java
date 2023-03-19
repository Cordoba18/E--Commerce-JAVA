package ejecutador;

import controlador.AdministradorController;
import controlador.LoginController;
import vista.Administrador;
import vista.Login;

public class Main {

	public static void main(String[] args) {
//		Administrador admin = new Administrador();
//		new AdministradorController(admin);
		
		Login L = new Login();
		new LoginController(L);
	}

}
