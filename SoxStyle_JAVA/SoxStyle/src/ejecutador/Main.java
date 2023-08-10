package ejecutador;

import controlador.*;
import modelo.Usuario;
import vista.*;

public class Main {

	public static void main(String[] args) {
		 Administrador admin = new Administrador();
		 Usuario u = new Usuario(); new
		 AdministradorController(admin, u);
		 
//		Login l = new Login();
//		new LoginController(l);
	}
}
 