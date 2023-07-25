package herramientas;

public class Validaciones {
	

	public static boolean vacio(String texto) {
		
		if(texto.isEmpty()) {
			return true;
		}
		return false;
	}
	public static boolean SoloNum (String texto) {
		
		if(!texto.matches("[0-9]*")) {
			return true;
			}else 
			return false;
		}
		
	
	
public static boolean SoloLetras (String texto) {
	
		if(!texto.matches("[a-z, A-Z]*")) {
			return true;
	}
		return false;
}

public static boolean  CantidadPersonas(String texto){
	
	if(Integer.parseInt(texto) > 10) {
		return true;
	}else
	if(texto.equals("00")) {
		return true;
	}
	else {
		return false;
	}


	
}

public static boolean CantidadCedula(String texto) {
	
	if(Integer.parseInt(texto) > 1 || Integer.parseInt(texto) < 99) {
	return true;
	}
	else {
		return false;
	}
}

public static boolean DescuentoProducto(String texto) {
	int largo = texto.length();
	
	if(largo >= 1 && largo <= 99) {
	return true;
	}
	else {
		return false;
	}
}

public static boolean CantidadDireccion(String texto) {
	int largo = texto.length();
	
	if(largo > 3 || largo < 2) {
	return true;
	}
	else {
		return false;
	}
}


//public static boolean ValidarMayorDeEdad(String texto) {
//	int largo = Integer.parseInt(texto);
//	
//	if(largo > 2005) {
//	return true;
//	}
//	else {
//		return false;
//	}
//}


public static boolean CantidadTelefono(String texto) {
	int largo = texto.length();
	
	if(largo > 11 || largo < 6) {
	return true;
	}
	else {
		return false;
	}
}


public static boolean ValidarCorreo(String texto) {
	
	if(!texto.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
		return true;
		}else {
	return false;
		}
}

public static boolean ValidarContraseña(String texto) {
	
	if(!texto.matches("[a-z, A-Z, 0-9]*")) {
		return true;
	}else {
	return false;}
}

public static boolean Dirrecion(String texto) {
	
	if(!texto.matches("[a-z, A-Z, 0-9]*")) {
		return true;
	}else {
	return false;}
}
public static boolean FechaNacimiento(String texto) {
	
	if(!texto.matches("[a-z, A-Z, 0-9]*")) {
		return true;
	}else {
	return false;}
}

public static boolean Cantidadcontraseña(String texto) {
	
	int numero = texto.length();
	if(numero <= 10 && numero > 0 && numero >= 8) {
		
		return false;
	}
	else {
		return true;
	}
}

public static boolean CantidadDescuento(String texto) {
	
	int numero = texto.length();
	if(numero < 3) {
		
		return false;
	}
	else {
		return true;
	}
}
public static boolean Menorquediez(String texto) {
	int largo = Integer.parseInt(texto);
	
	if(largo > 20) {
	return true;
	}
	else {
		return false;
	}
}
	public static boolean MenorqueCinco(String texto) {
		int largo = Integer.parseInt(texto);
		
		if(largo > 5) {
		return true;
		}
		else {
			return false;
		}
}
	
	public static boolean CantidadFecha(String texto) {
		int largo =  texto.length();
		
		
		if(largo > 10 || largo < 10) {
		return true;
		}
		else {
			return false;
		}
}
	public static boolean CantidadCorreo(String texto) {
		int largo =  texto.length();
		
		
		if(largo > 35) {
		return true;
		}
		else {
			return false;
		}
}
	public static boolean CantidadDia(String texto) {
		int largo = Integer.parseInt(texto);
		int largo1 = texto.length();
		if(largo > 31 ||  largo1 < 2) {
		return true;
		}
		else {
			return false;
		}
		}
		
		public static boolean CantidadMes(String texto) {
			int largo = Integer.parseInt(texto);
			int largo1 = texto.length();
			if(largo > 12 || largo1 < 2) {
			return true;
			}
			else {
				return false;
			}
}
		public static boolean CantidadAño(String texto) {
			int largo = texto.length();
			
			if(largo > 4 || largo < 4) {
			return true;
			}
			else {
				return false;
			}
}
		
		public static boolean esEntero(String texto) {
		    try {
		        Integer.parseInt(texto);
		        return true;
		    } catch (NumberFormatException e) {
		        return false;
		    }
		}
		
		public static boolean contieneLetrasNumeros(String texto) {
		    return texto.matches("[a-zA-Z0-9-]+");
		}

}
