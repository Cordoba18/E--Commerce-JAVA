package herramientas;

import java.io.UnsupportedEncodingException;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JPanel;

import modelo.Productos;
import vista.EditarProductos;

public class Ayudas {

	
	public static void ActualizarPanel(JPanel Agregar, JPanel PanelPrincipal) {
		PanelPrincipal.removeAll();
		PanelPrincipal.add(Agregar);
		PanelPrincipal.repaint();
		PanelPrincipal.revalidate();
	}
	
	/*
	 *esta ayuda recibirdatos la hice para enviar los datos de mis tablas pdnuevos y 
	 *pdantiguos a el jpanel editar 
	 *ATTE: julian :D 
	 */
	public static void recibirDatos(EditarProductos ed,Productos pd) {
//		ed.textId.setText(String.valueOf(pd.getId()));
		ed.txtNombre.setText(pd.getNombre());
		ed.txtPrecio.setText(String.valueOf(pd.getPrecio()));
		ed.txtEstado.setText(pd.getEstado());
		ed.txtDescuento.setText(String.valueOf(pd.getDescuento()));
		ed.textAreaDescripcion.setText(pd.getDescripcion());
	}
	
	 public static String obtenerFechaYHoraActual() {
	    	String formato = "yyyy-MM-dd_HH_mm_ss";
	    	DateTimeFormatter formateador = DateTimeFormatter.ofPattern(formato);
	    	LocalDateTime ahora = LocalDateTime.now();
	    	return formateador.format(ahora);
	    }
	 private SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		
	        byte[] claveEncriptacion = clave.getBytes("UTF-8");
	        
	        MessageDigest sha = MessageDigest.getInstance("SHA-1");
	        
	        claveEncriptacion = sha.digest(claveEncriptacion);
	        claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);
	        
	        SecretKeySpec secretKey = new SecretKeySpec(claveEncriptacion, "AES");

	        return secretKey;
	    }

	    /**
	     * Aplica la encriptacion AES a la cadena de texto usando la clave indicada
	     * @param datos Cadena a encriptar
	     * @param claveSecreta Clave para encriptar
	     * @return Información encriptada
	     * @throws UnsupportedEncodingException
	     * @throws NoSuchAlgorithmException
	     * @throws InvalidKeyException
	     * @throws NoSuchPaddingException
	     * @throws IllegalBlockSizeException
	     * @throws BadPaddingException 
	     */
	    public String Cifra(String datos) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
	        SecretKeySpec secretKey = this.crearClave(datos);
	        
	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");        
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

	        byte[] datosEncriptar = datos.getBytes("UTF-8");
	        byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
	        String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);

	        return encriptado;
	    }
	    
	    /**
	     * Aplica la encriptacion AES a la cadena de texto usando la clave indicada
	     * @param datos Cadena a encriptar
	     * @param claveSecreta Clave para encriptar
	     * @return Información encriptada
	     * @throws UnsupportedEncodingException
	     * @throws NoSuchAlgorithmException
	     * @throws InvalidKeyException
	     * @throws NoSuchPaddingException
	     * @throws IllegalBlockSizeException
	     * @throws BadPaddingException 
	     */


	
	   
	    /**
	     * Desencripta la cadena de texto indicada usando la clave de encriptacion
	     * @param datosEncriptados Datos encriptados
	     * @param claveSecreta Clave de encriptacion
	     * @return Informacion desencriptada
	     * @throws UnsupportedEncodingException
	     * @throws NoSuchAlgorithmException
	     * @throws InvalidKeyException
	     * @throws NoSuchPaddingException
	     * @throws IllegalBlockSizeException
	     * @throws BadPaddingException 
	     */
	    public String descifrar(String datosEncriptados, String contrasena) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
	        SecretKeySpec secretKey = this.crearClave(contrasena);

	        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey);
	        
	        byte[] bytesEncriptados = Base64.getDecoder().decode(datosEncriptados);
	        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
	        String datos = new String(datosDesencriptados);
	        
	        return datos;
	    }
	    

	    
}
