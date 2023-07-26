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
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.StringTokenizer;
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
	 *ATTE: julian
	 */
	
	
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
	    
	    //Ayudas.uploadFileToFTP(fechayhora+FinFormato,new File(String.valueOf(Origen)),FinFormato);
	    public static void uploadFileToFTP(String NombreFinalImagen ,File file){
	    	String ftpServer = "style-sport.shop";  
	    	String user = "stylespo";
	    	String password = "ADSI-208ss";
	    	String location = "/public_html/imgs";
	    	boolean debug = true;
	    	try {
	    	  if(file.exists()){
	    	   Socket socket=new Socket(ftpServer,21);
	    	   BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
	    	   BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    	   bufferedWriter.write("USER "+user+"\r\n");
	    	   bufferedWriter.flush();
	    	   bufferedWriter.write("PASS "+password+"\r\n");
	    	   bufferedWriter.flush();
	    	   bufferedWriter.write("CWD "+location+"\r\n");
	    	   bufferedWriter.flush();
	    	   bufferedWriter.write("TYPE I\r\n");
	    	   bufferedWriter.flush();
	    	   bufferedWriter.write("PASV\r\n");
	    	   bufferedWriter.flush();
	    	   String response=null;
	    	   while((response=bufferedReader.readLine())!=null){
	    	    if(debug)
	    	     System.out.println(response);
	    	    if(response.startsWith("530")){
	    	     System.err.println("Login aunthentication failed");
	    	     break;
	    	    }
	    	    if(response.startsWith("227")){
	    	         String address = null;  
	    	                  int port = -1;  
	    	                  int opening = response.indexOf('(');  
	    	                  int closing = response.indexOf(')', opening + 1);  
	    	                  if (closing > 0) {  
	    	                      String dataLink = response.substring(opening + 1, closing);  
	    	                      StringTokenizer tokenizer = new StringTokenizer(dataLink, ",");  
	    	                      try {  
	    	                          address = tokenizer.nextToken() + "." + tokenizer.nextToken() + "." + tokenizer.nextToken() + "." + tokenizer.nextToken();  
	    	                          port = Integer.parseInt(tokenizer.nextToken()) * 256 + Integer.parseInt(tokenizer.nextToken());  
	    	                      }  
	    	                      catch (Exception e) {  
	    	                          e.printStackTrace();
	    	                      }
	    	                      try{
	    	                    	 
	    	                      	
	    	                Socket transfer =new Socket(address,port);
	    	                // AQUI MODIFICO EL NOMBRE DEL ARCHIVO A LA FECHA Y HORA ACTUAL JUNTO CON EL FORMATO
	    	             bufferedWriter.write("STOR "+NombreFinalImagen +"\r\n");
	    	             bufferedWriter.flush();
	    	                   response=bufferedReader.readLine();
	    	                   if(debug)
	    	                    System.out.println(response);
	    	             if(response.startsWith("150")){
	    	              FileInputStream fileInputStream=new FileInputStream(file);
	    	              final int BUFFER_SIZE = 8192; // Aumentar el tamaño del buffer según sea necesario
	    	              byte buffer[] = new byte[BUFFER_SIZE];
	    	              int len=0,off=0;
	    	              if(debug)
	    	               System.out.println("uploading file...");
	    	              while((len=fileInputStream.read(buffer))!=-1)
	    	               transfer.getOutputStream().write(buffer, off, len);
	    	              transfer.getOutputStream().flush();
	    	              transfer.close();
	    	              bufferedWriter.write("QUIT\r\n");
	    	              bufferedWriter.flush();
	    	              bufferedReader.close();
	    	              socket.close();
	    	              System.out.println("File sucessfully transferred!");
	    	              break;
	    	     
	    	              }
	    	                      }catch (Exception e) {
	    	        System.err.println(e);
	    	       }
	    	                  }  
	    	     }
	    	    }
	    	   }else{
	    	    System.err.println(file+"no exist!");
	    	   }
	    	  } catch (MalformedURLException e) {
	    	   e.printStackTrace();
	    	  } catch (IOException e) {
	    	   e.printStackTrace();
	    	  }
	    }
}
