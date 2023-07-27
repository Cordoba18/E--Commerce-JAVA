// IMPORTACION DE PAQUETES Y CLASES NECESARIAS

package controlador;


import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.Productos;
import herramientas.Validaciones;
import vista.Administrador;
import vista.AgregarProductos;
import vista.ColoresTallas;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import sql.Consultas;


public class ColoresTallasController implements ActionListener, KeyListener,MouseListener{
	
	
	// DECLARACION DE VARIABLES 
	
    Consultas consult = new Consultas(); // INSTANCIA EL OBJETO PARA REALIZAR CONSULTAS A LA BASE DE DATOS
    Productos p = new Productos();	// INSTANCIA  EL OBJETO QUE REPRESENTA LOS PRODUCTOS
    ColoresTallas ct; // INSTANCIA  VISTA DE LA INTERFAZ GRAFICA DE COLORES Y TALLAS
    Administrador a; // INSTANCIA EL ADMINISTRADOR PRINCIPAL
    
 
    // CONSTRUCTOR DEL CONTROLADOR 
	public ColoresTallasController (ColoresTallas ct, Productos p, Administrador a) {
		
		// ASIGNACION DE OBJETOS Y VISTA
		this.ct = ct;
		this.p =p;
		this.a = a;
		
		// ASOCIAR EVENTOS A LOS BOTONES Y CAMPOS DE TEXTO EN LA VISTA 
		ct.BtnAgregarTalla.addActionListener(this);
        ct.BtnAgregarC.addActionListener(this);
        ct.BtnBorrarTalla.addActionListener(this);
        ct.BtnBorrarC.addActionListener(this);
        ct.BtnEditarTalla.addActionListener(this);
        ct.BtnCancelarC.addActionListener(this);
        ct.BtncancelarTalla.addActionListener(this);
        ct.txtTalla.addKeyListener(this);
        ct.txtCantidad.addKeyListener(this);
        ct.txtColor.addKeyListener(this);
        ct.TablaTalla.addMouseListener(this);
        ct.TablaColores.addMouseListener(this);
        
        // OBTENER EL ID DEL PRODUCTO Y CARGAR LOS COLORES Y TALLAS ASOCIADOS AL PRODUCTO
		p.setId_Producto(p.getId());
		CargarColores();
		CargarTallas();
	}

	
	 // IMPLEMENTACIÓN DE MÉTODOS DEL MOUSELISTENER
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(ct.TablaColores)) {
			
			 // CUANDO SE HACE CLIC EN LA TABLA DE COLORES,
			//SE OBTIENE LA INFORMACION DE LA FILA SELECCIONADA Y SE ALMACENA EN EL OBJETO 'P'
			int row = ct.TablaColores.getSelectedRow();
			p.setId_color((String) ct.TablaColores.getValueAt(row, 0).toString());
			p.setColor((String) ct.TablaColores.getValueAt(row, 1).toString());
			ct.BtnBorrarC.setVisible(true);
			ct.BtnCancelarC.setVisible(true);
			ct.BtnAgregarC.setVisible(false);
		}
		
		if(e.getSource().equals(ct.TablaTalla)) {
			
			// CUANDO SE HACE CLIC EN LA TABLA DE TALLAS, 
			//SE OBTIENE LA INFORMACION DE LA FILA SELECCIONADA Y SE ALMACENA EN EL OBEJTO 'P'
		
			int row = ct.TablaTalla.getSelectedRow();
			p.setId_talla((String) ct.TablaTalla.getValueAt(row, 0).toString());
			p.setTalla((String) ct.TablaTalla.getValueAt(row, 2).toString());
			p.setCantidad(Integer.parseInt((String) ct.TablaTalla.getValueAt(row, 1).toString()));
			ct.txtTalla.setText(p.getTalla());
			ct.txtCantidad.setText(String.valueOf(p.getCantidad()));
			ct.BtnBorrarTalla.setVisible(true);
			ct.BtnEditarTalla.setVisible(true);
			ct.BtncancelarTalla.setVisible(true);
			ct.BtnAgregarTalla.setVisible(false);
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

	
	 // AQUI SE IMPLEMENTAN LOS MÉTODOS DEL KEYLISTENER
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		
		//AQUI SE REALIZAN LAS VALIDACIONES CUANDO 
		//SE SUELTA UNA TECLA EN LOS CAMPOS DE TEXTO DE LA VISTA, SI EN UN CASO EL MENSAJE ESTA VACIO MOSTRARA UN MENSAJE.
		// SE EVALUA SI EL TXT ESTA TENIENDO UNA FUNCION PARA ANALIZAR O REVISAR LO QUE ESTA DENTRO DEL CAMPO, ADEMAS SI EN UNA OPCION EL CAMPO ESTA VACIO SALDRA EL MENSAJE CORRESPONDIENTE.
		//TAMBIEN  SI SE CUMPLE LA CONDICION DE QUE EL CAMPO ESTA VACIO, SE ENCIENDE EL LABEL
		//INDICA QUE SE EJECUTARA EL BLOQUE DE CODIGO QUE LE SIGUE SOLO SI LA CONDICION DENTRO DE LOS PARENTESIS ES VERDADERA
		//SE DEBE CUMPLIR CON LO QUE PIDE LA VALIDACION DE SOLO INGRESAR NUMEROS.
		//SI SE CUMPLE LA CONDICION DE QUE EN EL CAMPO SE ESTAN INGRESANDO LETRAS, SE ENCENDERA EL LABEL.
		//EN OTRO CASO SI LA CONDICION SE CUMPLE, SE DESACTIVARA EL LABEL.
		
		if(e.getSource().equals(ct.txtCantidad)) {
			if (Validaciones.vacio(ct.txtCantidad.getText())) { 
				ct.lblErrorCantidad.setText("CAMPO VACIO"); 
				ct.lblErrorCantidad.setVisible(true); 
			} else if(Validaciones.SoloNum(ct.txtCantidad.getText())){
				ct.lblErrorCantidad.setText("SOLO SE PERMITEN NUMEROS");
				ct.lblErrorCantidad.setVisible(true);
			}else {
				ct.lblErrorCantidad.setVisible(false);
			}
		}
		
		
		//ESTA LINEA DE CODIGO INICIA CON EL BLOQUE CONDICIONAL QUE SE VERIFICA SI EL EVENTO SE A GENERADO POR EL COMPONENTE CORRESPONDIENTE
		//TAMBIEN SE VERIFICA SI EL TEXTO OBTENIDO DEL COMPONENTE ESTA VACIO.
		// SE LLAMA LA CLASE PARA VALIDAR PARA VER SI SE CONTIENE UNA FUNCION QUE PROBABLEMENTE REALIZA LA VERIFICACION Y DEVUELVE TRUE PARA ACTICVAR EL LABEL
		//SI EL CAMPO DE TEXTO EN UNA OCACION LLEGA A ESTAR VACIO SE MOSTRARA EL MENSAJE "CAMPO VACIO" Y HACEN QUE EL COMPONENTE SEA VISIBLE.
		//SI EN EL CAMPO CORRESPONDIENTE NO ESTA VACIO Y SOLO CONTIENE LETRAS NO SE ACTIVARA NINGUN LABEL.
		//SE DEBE CUMPLR CON LO QUE PIDE LA VALIDACION DE SOLO INGRESAR LETRAS.
		//SI NO SE CUMPLE LA FUNCION SE ACTIVARA EL LABEL.
		
		
		
			if(e.getSource().equals(ct.txtColor)) {
			if (Validaciones.vacio(ct.txtColor.getText())) {
				ct.lblErrorColor.setText("CAMPO VACIO");
				ct.lblErrorColor.setVisible(true);
			} else if (Validaciones.SoloLetras(ct.txtColor.getText())) {
				ct.lblErrorColor.setText("SOLO SE PERMITEN LETRAS");
				ct.lblErrorColor.setVisible(true);
			}else{
				ct.lblErrorColor.setVisible(false);
			}
		}
		if(e.getSource().equals(ct.txtTalla)) {
			if(Validaciones.vacio(ct.txtTalla.getText())){
				ct.lblErrorTalla.setText("CAMPO VACIO");
				ct.lblErrorTalla.setVisible(true);
			}else {
				ct.lblErrorTalla.setVisible(false);
			}
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		 //  ACCION PARA EL BOTON "AGREGAR TALLA"
		if(e.getSource().equals(ct.BtnAgregarTalla)) {
			
			if (Validaciones.vacio(ct.txtCantidad.getText())) { //AQUI SE VALIDA LOS CAMPOS DE TEXTO
				ct.lblErrorCantidad.setText("CAMPO VACIO");
				ct.lblErrorCantidad.setVisible(true);
			} else if(Validaciones.SoloNum(ct.txtCantidad.getText())){
				ct.lblErrorCantidad.setText("SOLO SE PERMITEN NUMEROS");
				ct.lblErrorCantidad.setVisible(true);
				
			}
			
			else if(Validaciones.vacio(ct.txtTalla.getText())){
				ct.lblErrorTalla.setText("CAMPO VACIO");
				ct.lblErrorTalla.setVisible(true);
			}else {

			p.setCantidad(Integer.parseInt(ct.txtCantidad.getText()));
			p.setTalla(ct.txtTalla.getText());
			consult.insertarTalla(p);
			consult.Monitorias(a.lbl_IdUser.getText(), "16", p.getTalla()+",id_producto:"+p.getId_Producto());
			ct.txtCantidad.setText("");
			ct.txtTalla.setText("");
			CargarTallas();
			}
		}
		
		if(e.getSource().equals(ct.BtnAgregarC)) {			
			p.setColor(ct.txtColor.getText());
			
			if (Validaciones.vacio(ct.txtColor.getText())) {
				ct.lblErrorColor.setText("CAMPO VACIO");
				ct.lblErrorColor.setVisible(true);
			} else if (Validaciones.SoloLetras(ct.txtColor.getText())) {
				ct.lblErrorColor.setText("SOLO SE PERMITEN LETRAS");
				ct.lblErrorColor.setVisible(true);
			}else{

			ct.txtColor.setText("");
			consult.insertarColor(p);
			consult.Monitorias(a.lbl_IdUser.getText(), "21", p.getColor()+",id_producto:"+p.getId_Producto());
			CargarColores();
			}
		}
		
		if (e.getSource().equals(ct.BtnEditarTalla)) {
			
			if (Validaciones.vacio(ct.txtCantidad.getText())) {
				ct.lblErrorCantidad.setText("CAMPO VACIO");
				ct.lblErrorCantidad.setVisible(true);
			} else if(Validaciones.SoloNum(ct.txtCantidad.getText())){
				ct.lblErrorCantidad.setText("SOLO SE PERMITEN NUMEROS");
				ct.lblErrorCantidad.setVisible(true);
			}
			else if(Validaciones.vacio(ct.txtTalla.getText())){
				ct.lblErrorTalla.setText("CAMPO VACIO");
				ct.lblErrorTalla.setVisible(true);
			}else {
			p.setCantidad(Integer.parseInt(ct.txtCantidad.getText()));
			p.setTalla(ct.txtTalla.getText());
			consult.Monitorias(a.lbl_IdUser.getText(), "17", p.getTalla()+",id_producto:"+p.getId_Producto());
			consult.actualizarTallas(p);
			ct.BtnBorrarTalla.setVisible(false);
			ct.BtnEditarTalla.setVisible(false);
			ct.BtncancelarTalla.setVisible(false);
			ct.BtnAgregarTalla.setVisible(true);
			ct.txtTalla.setText("");
			ct.txtCantidad.setText("");
			CargarTallas();
			}
		}
		
		if(e.getSource().equals(ct.BtnBorrarC)) {
			ct.txtColor.setText("");
			consult.Monitorias(a.lbl_IdUser.getText(), "22", p.getColor()+",id_producto:"+p.getId_Producto());
			consult.EliminarColor(p);
			CargarColores();
			ct.BtnBorrarC.setVisible(false);
			ct.BtnCancelarC.setVisible(false);
			ct.BtnAgregarC.setVisible(true);
			
		}
		if(e.getSource().equals(ct.BtnBorrarTalla)) {
			consult.EliminarTalla(p);
			consult.Monitorias(a.lbl_IdUser.getText(), "18", p.getTalla()+",id_producto:"+p.getId_Producto());
			ct.BtnBorrarTalla.setVisible(false);
			ct.BtnEditarTalla.setVisible(false);
			ct.BtncancelarTalla.setVisible(false);
			ct.BtnAgregarTalla.setVisible(true);
			ct.txtTalla.setText("");
			ct.txtCantidad.setText("");
			CargarTallas();
		}
		if(e.getSource().equals(ct.BtncancelarTalla)) {
			ct.BtnBorrarTalla.setVisible(false);
			ct.BtnEditarTalla.setVisible(false);
			ct.BtncancelarTalla.setVisible(false);
			ct.BtnAgregarTalla.setVisible(true);
			ct.txtTalla.setText("");
			ct.txtCantidad.setText("");
		}
		if(e.getSource().equals(ct.BtnCancelarC)) {
			
			ct.BtnBorrarC.setVisible(false);
			ct.BtnCancelarC.setVisible(false);
			ct.BtnAgregarC.setVisible(true);
			
		}
	}
	
	public void CargarTallas() {
	                
		consult.CargarTallas(ct.TablaTalla, p);
}
	public void CargarColores() {
		consult.CargarColores(ct.TablaColores, p);
}	
		}	