package ejecutador;

import controlador.*;
import vista.*;

public class Main {

	public static void main(String[] args) {
		Login l = new Login();
		new LoginController(l);
	}
}
