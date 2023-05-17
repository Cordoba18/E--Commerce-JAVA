package ejecutador;

import controlador.*;
import vista.*;

public class Main {

	public static void main(String[] args) {
		Administrador admin = new Administrador();
		new AdministradorController(admin);
	}
}
 