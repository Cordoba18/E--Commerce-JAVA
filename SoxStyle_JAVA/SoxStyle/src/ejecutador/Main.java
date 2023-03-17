package ejecutador;

import controlador.AdministradorController;
import vista.Administrador;
import vista.Login;

public class Main {

	public static void main(String[] args) {
		Administrador admin = new Administrador();
		new AdministradorController(admin);
	}

}
