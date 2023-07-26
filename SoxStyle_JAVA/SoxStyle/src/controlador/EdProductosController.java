package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import herramientas.Ayudas;
import herramientas.Validaciones;
import modelo.Productos;
import sql.Consultas;
import vista.Administrador;
import vista.Agregar_imagen;
import vista.ColoresTallas;
import vista.EditarProductos;

public class EdProductosController implements ActionListener, KeyListener, MouseListener {
	
	EditarProductos ed;
	Validaciones vali = new Validaciones();
	Productos pro = new Productos();
	Consultas consulta = new Consultas();
	String FinFormato;
	Path Origen = null;
	boolean accioncategoria= false;
	Administrador a;
	public EdProductosController (EditarProductos ed, Productos p, Administrador a) {
		this.a = a;
		this.ed = ed;
		this.pro = p;
		ed.btnActualizar.addActionListener(this);
		ed.btnEdColorTalla.addActionListener(this);
		ed.txtNombre.addKeyListener(this);
		ed.txtPrecio.addKeyListener(this);
		ed.txtDescuento.addKeyListener(this);
		ed.btnAgregarImagen.addActionListener(this);
		ed.btnEditarImagenes.addActionListener(this);
		ed.btnCancelar.addActionListener(this);
		ed.cbxCategoria.addMouseListener(this);
		
		CargarDatos();
		box();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		if(e.getSource().equals(ed.btnAgregarImagen)) {
			
			JFileChooser file = new JFileChooser();
			file.showOpenDialog(null);
			File archivo = file.getSelectedFile();
			
			if(archivo != null) {
				int formato = archivo.getName().length() - 4;
				FinFormato = archivo.getName().toString().substring(formato);
				if (!FinFormato.equals(".png") && !FinFormato.equals(".jpg")&&!FinFormato.equals("jpeg")) {
					
					JOptionPane.showMessageDialog(null, "FORMATO NO VALIDO \n EL FORMATO DEBE SER png,jpeg o jpg");
				}else {
					if(FinFormato.equals("jpeg")) {
						FinFormato = "."+ FinFormato;
					}
					String Orig = archivo.getPath();
					Origen = Paths.get(Orig);
					
					ed.btnAgregarImagen.setVisible(false);
					ed.lbl_Imagen.setText(String.valueOf(Origen));
					ed.btnCancelar.setVisible(true);
			
				}
			}
	
		}
		
		if(e.getSource().equals(ed.btnCancelar)) {
			ed.btnAgregarImagen.setVisible(true);
		ed.btnCancelar.setVisible(false);
		Origen = null;
		}
		
		if(e.getSource().equals(ed.btnEditarImagenes)) {
			
			Agregar_imagen ai = new Agregar_imagen();
			new AgregarImagenController(ai, pro, a);
			Ayudas.ActualizarPanel(ai, ed);
		}
		if (e.getSource().equals(ed.btnEdColorTalla)) {
			ColoresTallas color_talla = new ColoresTallas();
			new ColoresTallasController(color_talla, pro, a);
			Ayudas.ActualizarPanel(color_talla,ed);
		
			
		}
		
		if(e.getSource().equals(ed.btnActualizar)) {
			
			String nompro = ed.txtNombre.getText();
			String precio = ed.txtPrecio.getText();
			String descuento = ed.txtDescuento.getText();
			String descripcion = ed.textAreaDescripcion.getText();
			
			//Validaciones de el campo Nombre Producto
			
			if(Validaciones.vacio(nompro)) {
				
				ed.lblErrorNombrePro.setText("Campo Vacio");
				ed.lblErrorNombrePro.setVisible(true);		
				
			}
			else 
				if(Validaciones.SoloLetras(nompro)){
				
					ed.lblErrorNombrePro.setText("Ingrese Letras");
					ed.lblErrorNombrePro.setVisible(true);
	
			}
			
			//Validaciones del campo Precio Productos
			
			else 
				if(Validaciones.vacio(precio)) {
						
					ed.lblErrorPrecio.setText("Campo Vacio");
					ed.lblErrorPrecio.setVisible(true);
						
					}
				
			else
				if(Validaciones.SoloNum(precio)) {
						
					ed.lblErrorPrecio.setText("Ingrese Numeros");
					ed.lblErrorPrecio.setVisible(true);
						
					}
			else
				if(Validaciones.vacio(descuento)) {
					
					ed.lblErrorDescuento.setText("Campo vacio");
					ed.lblErrorDescuento.setVisible(true);
					
				}
			else 
				if(Validaciones.SoloNum(descuento)) {
					
					ed.lblErrorDescuento.setText("Ingrese Numeros");
					ed.lblErrorDescuento.setVisible(true);
					
				}
			
			else 
				if(Validaciones.CantidadDescuento(descuento)) {
					
					ed.lblErrorDescuento.setText("Descuento Incorrecto");
					ed.lblErrorDescuento.setVisible(true);
					
				}
			
			//Validacion del campo Descripcion
			
			else
				if(descripcion.length() > 500) {
						
					ed.lblErrorDescripcion.setText("500 caracteres Permitidos");
					ed.lblErrorDescripcion.setVisible(true);
					
					}
		
		else {
			
			//Aqui podes meter la funcionality de la vista
			
			pro.setNombre(ed.txtNombre.getText());
			pro.setPrecio(Integer.parseInt(ed.txtPrecio.getText()));
			pro.setDescuento(Integer.parseInt(ed.txtDescuento.getText()));
			pro.setDescripcion(ed.textAreaDescripcion.getText());
			pro.setNombre_Categoria(String.valueOf(ed.cbxCategoria.getSelectedItem()));
			consulta.TraerCategoria(pro);
			consulta.TraerImagenPrincipal(pro);
			if(consulta.EditarProducto(pro, accioncategoria)>0) {
				
				if (Origen == null) {
					
				} else {
					String fechayhora = Ayudas.obtenerFechaYHoraActual();
					Ayudas.uploadFileToFTP(fechayhora+FinFormato,new File(String.valueOf(Origen)),FinFormato);
					pro.setImagen(fechayhora+FinFormato);
					consulta.EditarImagen(pro);
				}
				consulta.Monitorias(a.lbl_IdUser.getText(), "10", pro.getNombre());
				JOptionPane.showMessageDialog(null, "Exito en la edicion del Producto");;
			    ed.btnAgregarImagen.setVisible(true);
				Origen = null;
				accioncategoria=false;
				ed.btnCancelar.setVisible(false);
				CargarDatos();
			}
		}
		}
		
	}
	
	public void box () {
		
		Consultas.comboBox(ed.cbxCategoria);
		
	}

	public void CargarDatos() {
		consulta.TraerDatosProducto(pro);
		ed.txtNombre.setText(pro.getNombre());
		ed.textAreaDescripcion.setText(pro.getDescripcion());
		ed.txtDescuento.setText(String.valueOf(pro.getDescuento()));
		ed.txtPrecio.setText(String.valueOf(pro.getPrecio()));
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//Metodo el cual al momento de escribir esconda el lbl del error
		
		
		if(e.getSource().equals(ed.txtNombre)) {
			
			ed.lblErrorNombrePro.setVisible(false);
			
		}
		if(e.getSource().equals(ed.txtPrecio)) {
			
			ed.lblErrorPrecio.setVisible(false);
			
		}
//		if(e.getSource().equals(ed.txtEstado)) {
//			
//			ed.lblErrorEstado.setVisible(false);
//			
//		}
		if(e.getSource().equals(ed.txtDescuento)) {
			
			ed.lblErrorDescuento.setVisible(false);
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(ed.cbxCategoria)) {
			accioncategoria=true;
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



}
