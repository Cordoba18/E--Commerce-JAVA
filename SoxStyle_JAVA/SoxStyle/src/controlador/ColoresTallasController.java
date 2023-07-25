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
	
	
	DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modelo2 = new DefaultTableModel();
    ColoresTallas ct = new ColoresTallas();
    Validaciones vali = new Validaciones();
    Consultas consult = new Consultas();
    Productos colt;
    Productos tc = new Productos();
   
    
	public ColoresTallasController (ColoresTallas ct) {
		
		this.ct = ct;
		
		ct.BtnAgregarTalla.addActionListener(this);
        ct.BtnAgregarC.addActionListener(this);
        ct.BtnBorrarTalla.addActionListener(this);
        ct.BtnBorrarC.addActionListener(this);
        ct.BtnEditarTalla.addActionListener(this);
        ct.BtnEditarC.addActionListener(this);
        ct.BtnCancelarC.addActionListener(this);
        ct.BtncancelarTalla.addActionListener(this);
        ct.txtTalla.addKeyListener(this);
        ct.txtCantidad.addKeyListener(this);
        ct.txtColor.addKeyListener(this);
        ct.TablaTalla.addMouseListener(this);
        ct.TablaColores.addMouseListener(this);
        pruebacancelar();
        encenderbotones();
        tabla();
        tabla2();
        editartalla();
        editarcolor();
		
	}

	public void tabla() {
        DefaultTableModel modeloo = consult.listar1T();
        ct.TablaTalla.setModel(modeloo);
    }

    public void tabla2() {
        DefaultTableModel modeloo2 = consult.listar2C();
        ct.TablaColores.setModel(modeloo2);
    }

    public void ini() {
        ct.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(ct.BtnAgregarTalla)) {
        	agregarTalla(); 
        } else if (e.getSource().equals(ct.BtnAgregarC)) {
            
            agregarColor();
        } else if (e.getSource().equals(ct.BtnEditarTalla)) {
        	
        	
        }
        // Otros botones y acciones aquí
    }
    
    private void agregarColor() {
        Productos ta = new Productos();
        String colores = ct.txtColor.getText();

        if (Validaciones.vacio(colores)) {
            ct.lblErrorColor.setText("Campo Vacio");
            ct.lblErrorColor.setVisible(true);
        } else if (Validaciones.SoloLetras(colores)) {
            ct.lblErrorColor.setText("Ingrese Letras");
            ct.lblErrorColor.setVisible(true);
        } else {
            if (vali.vacio(colores)) {
                JOptionPane.showMessageDialog(null, "Debe digitar un color", "Error en la operación",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            ta.setColor(ct.txtColor.getText());
            if (consult.insertarColoresTallas(ta)) {
                JOptionPane.showMessageDialog(ct, "Se ingresaron los datos correctamente");
                ct.txtColor.setText("");
                tabla2();
            }
        }
       
    }
    
    private void agregarTalla() {
        Productos tc = new Productos();
        String talla = ct.txtTalla.getText();
        String cantidad = ct.txtCantidad.getText();

        	if (Validaciones.vacio(talla)){
            ct.lblErrorTalla.setText("Campo Vacio");
            ct.lblErrorTalla.setVisible(true);    
        } else if (Validaciones.vacio(cantidad)) {
        	 ct.lblErrorCantidad.setText("Campo Vacio");
             ct.lblErrorCantidad.setVisible(true);
        } else if (!Validaciones.esEntero(cantidad)) {
            ct.lblErrorCantidad.setText("Ingrese Numeros");
            ct.lblErrorCantidad.setVisible(true);
        } else if (!Validaciones.contieneLetrasNumeros(talla)) {
            ct.lblErrorTalla.setText("Ingrese solo letras o números");
            ct.lblErrorTalla.setVisible(true);
            
        } else {
            int cantidadInt;
            try {
                cantidadInt = Integer.parseInt(cantidad);
            } catch (NumberFormatException e) {
                ct.lblErrorCantidad.setText("Ingrese un número entero válido");
                ct.lblErrorCantidad.setVisible(true);
                return; // Salir del método si no se puede convertir a entero
            }

            // Resto del código que depende de la cantidad entera

            // Asignar los valores a la instancia de ColoresT
            tc.setTalla(talla);
            tc.setCantidad(cantidadInt);

            // Resto del código para agregar la talla a la tabla o realizar las operaciones necesarias

            consult.insertarTallascolores(tc);
            tabla();
            JOptionPane.showMessageDialog(ct, "Se ingresaron los datos correctamente");
            ct.lblErrorCantidad.setVisible(false);
            ct.lblErrorTalla.setVisible(false);
            ct.txtTalla.setText("");
            ct.txtCantidad.setText("");
        }
    }

    private void editarcolores(int idColor) {
	    Productos ta = new Productos();
	    String colores = ct.txtColor.getText();

	    if (Validaciones.vacio(colores)) {
	        ct.lblErrorColor.setText("Campo Vacio");
	        ct.lblErrorColor.setVisible(true);
	    } else if (Validaciones.SoloLetras(colores)) {
	        ct.lblErrorColor.setText("Ingrese Letras");
	        ct.lblErrorColor.setVisible(true);
	    } else {
	        ta.setColor(colores);

	        // Resto del código para agregar el color a la tabla o realizar las operaciones necesarias

	        consult.actualizarColores(ta);
	        tabla2();
	        JOptionPane.showMessageDialog(ct, "Se ACTUALIZARON los datos correctamente");
	        ct.lblErrorColor.setVisible(false);
	        ct.txtColor.setText("");
	    }
	}

	public void editarcolor() {
	    ct.TablaColores.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            int filaSeleccionada2 = ct.TablaColores.getSelectedRow();

	            if (filaSeleccionada2 >= 0) {
	                Object idObj = ct.TablaColores.getValueAt(filaSeleccionada2, 0);
	                Object coloresObj = ct.TablaColores.getValueAt(filaSeleccionada2, 1);

	                if (idObj != null && coloresObj != null) {
	                    String id = idObj.toString();
	                    String colores = coloresObj.toString();

	                    if (!id.isEmpty()) {
	                        int idColor = Integer.parseInt(id);
	                        ct.txtColor.setText(colores);
	                        ct.id_2.setText(id);

	                        ct.BtnEditarC.addActionListener(new ActionListener() {
	                            public void actionPerformed(ActionEvent e) {
	                                // Llamar al método editarcolores() con el idColor
	                                editarcolores(idColor);
	                            }
	                        });
	                    } else {
	                        // Manejo de error o mensaje de advertencia cuando el id está vacío
	                    }
	                }
	            }
	        }
	    });
	    
	}
	
	private void editarTalla(int idTalla) {
        Productos tc = new Productos();
        String talla = ct.txtTalla.getText();
        String cantidad = ct.txtCantidad.getText();

        if (Validaciones.vacio(talla)){
            ct.lblErrorTalla.setText("Campo Vacio");
            ct.lblErrorTalla.setVisible(true);    
        } else if (Validaciones.vacio(cantidad)) {
        	 ct.lblErrorCantidad.setText("Campo Vacio");
             ct.lblErrorCantidad.setVisible(true);
        } else if (!Validaciones.esEntero(cantidad)) {
            ct.lblErrorCantidad.setText("Ingrese Numeros");
            ct.lblErrorCantidad.setVisible(true);
        } else if (!Validaciones.contieneLetrasNumeros(talla)) {
            ct.lblErrorTalla.setText("Ingrese solo letras o números");
            ct.lblErrorTalla.setVisible(true);
        } else {
            int cantidadInt;
            try {
                cantidadInt = Integer.parseInt(cantidad);
            } catch (NumberFormatException e) {
                ct.lblErrorCantidad.setText("Ingrese un número entero válido");
                ct.lblErrorCantidad.setVisible(true);
                return; // Salir del método si no se puede convertir a entero
            }

            // Resto del código que depende de la cantidad entera

            // Asignar los valores a la instancia de ColoresT
            tc.setTalla(talla);
            tc.setCantidad(cantidadInt);

            // Resto del código para agregar la talla a la tabla o realizar las operaciones necesarias

            consult.actualizarTallas(tc);
            tabla();
            JOptionPane.showMessageDialog(ct, "Se ACTUALIZARON los datos correctamente");
            ct.lblErrorCantidad.setVisible(false);
            ct.lblErrorTalla.setVisible(false);
            ct.txtTalla.setText("");
            ct.txtCantidad.setText("");
        }
    }
	
	public void editartalla() {
		ct.TablaTalla.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
        int filaSeleccionada = ct.TablaTalla.getSelectedRow();
       

        if (filaSeleccionada >= 0) {
            String id = ct.TablaTalla.getValueAt(filaSeleccionada, 0).toString();
            int idTalla = Integer.parseInt(id);
            String talla = ct.TablaTalla.getValueAt(filaSeleccionada, 1).toString();
            String cantidad = ct.TablaTalla.getValueAt(filaSeleccionada, 2).toString();
            ct.txtTalla.setText(talla);
            ct.txtCantidad.setText(cantidad);
            ct.id.setText(id);

            // Llamar al método editarTalla() con el ID
            
        }

        
    }
});
		 ct.BtnEditarTalla.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Obtener el ID desde alguna fuente (por ejemplo, desde un campo de texto)
	                int idTalla = Integer.parseInt(ct.id.getText());
	                
	                // Llamar al método editarTalla() con el ID
	                editarTalla(idTalla);
	            }
	        });
	    }
		public void encenderbotones() {
		ct.TablaColores.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
           int filaSeleccionada = ct.TablaColores.getSelectedRow();
           if (filaSeleccionada >= 0) {
               // Muestra los botones y los agrega al contenedor
               ct.BtnEditarC.setVisible(true);
               ct.BtnBorrarC.setVisible(true);
               ct.BtnCancelarC.setVisible(true);
           }
       }    
 
 });  
		ct.TablaTalla.addMouseListener(new MouseAdapter() {
			   public void mouseClicked(MouseEvent e) {
	             int filaSeleccionada = ct.TablaTalla.getSelectedRow();
	             if (filaSeleccionada >= 0) {
	                 // Muestra los botones y los agrega al contenedor
	                 ct.BtnEditarTalla.setVisible(true);
	                 ct.BtnBorrarTalla.setVisible(true);
	                 ct.BtncancelarTalla.setVisible(true);
	             }
	         }    
		 
		 }); 
		
	}
		private void pruebacancelar() {
		       ct.BtncancelarTalla.addActionListener(new ActionListener() {
		           @Override
		           public void actionPerformed(ActionEvent e) {
		               if (e.getSource().equals( ct.BtncancelarTalla)) {
		            	   ct.BtnEditarTalla.setVisible(false);
		                   ct.BtnBorrarTalla.setVisible(false);
		                   ct.BtncancelarTalla.setVisible(false);
		               }
		           }
		       });
		       ct.BtnCancelarC.addActionListener(new ActionListener() {
		           @Override
		           public void actionPerformed(ActionEvent e) {
		               if (e.getSource().equals( ct.BtnCancelarC)) {
		            	   ct.BtnEditarC.setVisible(false);
		                   ct.BtnBorrarC.setVisible(false);
		                   ct.BtnCancelarC.setVisible(false);
		               }
		           }
		       });
		   }
		
		 @Override
		    public void keyTyped(KeyEvent e) {
		        if (e.getSource().equals(ct.txtTalla)) {
		            ct.lblErrorTalla.setVisible(false);
		        }
		        if (e.getSource().equals(ct.txtCantidad)) {
		            ct.lblErrorCantidad.setVisible(false);
		        }
		        if (e.getSource().equals(ct.txtColor)) {
		            ct.lblErrorColor.setVisible(false);
		        }
		    }

		@Override
		public void keyPressed(KeyEvent e) {
		
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
		
		}
		
				   
		public void mousePressed(MouseEvent e) {
		
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
		
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
		
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
		
		}
		
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			}
		
		}	